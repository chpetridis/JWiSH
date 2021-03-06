package gr.uoi.cs.JWish.Parsers;

import java.util.HashSet;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import gr.uoi.cs.JWish.WDG.CompositeNode;
import gr.uoi.cs.JWish.WDG.WDGBuilder;
import gr.uoi.cs.JWish.WDG.WDGNode;


public class ParserAST extends Parser {
	private static final int JLS = AST.JLS9;
	private WDGBuilder builder;
	private final HashSet<String> components = new HashSet<>();
	private final HashSet<String> multiLevelComponents = new HashSet<>();
	
	public ParserAST (String pathToFiles){
		super (pathToFiles);
	}
	
	public void findSlices(String stringOfFile) {
		ASTParser astParser = ASTParser.newParser(JLS);
		astParser.setSource(stringOfFile.toCharArray());
		astParser.setKind(ASTParser.K_COMPILATION_UNIT);
		final CompilationUnit cu = (CompilationUnit) astParser.createAST(null);
		builder = new WDGBuilder();
 
		cu.accept(new ASTVisitor() {
 
			public boolean visit(VariableDeclarationFragment node) {	
				String variableType = stringAdministrator.getVariableTypeFromDeclaration(node.getParent().toString());
				
				if (!toolCriteria.isToolComponent(variableType)){
					return true;
				}

				String variableName = node.getName().getIdentifier();
				createPrimitiveNode(node);
				
				if (!isAloneDeclaration(node)){
					String constructorName = stringAdministrator.getConstructorName(node.getInitializer().toString());
					String component = stringAdministrator.getComponentName(node.getInitializer().toString());
					
					if (toolCriteria.meetsCriteria(constructorName) && isComponent(component)) {
						createMultiLevelNode(component, variableName);
					}
				}
				return true;
			}
			
		});
		
		cu.accept(new ASTVisitor() {
			
			public boolean visit(Assignment node) {
				String variableName = node.getLeftHandSide().toString();
				String constructorName = stringAdministrator.getConstructorName(node.getRightHandSide().toString());
				String component = stringAdministrator.getComponentName(node.getRightHandSide().toString());
				
				if (isComponent(variableName)){
					addFragmentToNode(node, variableName);
				}

				if (toolCriteria.meetsCriteria(constructorName) && isComponent(component)) {
					createMultiLevelNode(component, variableName);
				}
				return true;
			}
			
			public boolean visit(QualifiedName node) {
				if (isInvalid(node)){
					return true;
				}

				if (isComponent(node.getQualifier().toString())){
					addFragmentToNode(node, node.getQualifier().toString());
				}
				return true;
			}
			
			public boolean visit(MethodInvocation node) {
				if (isStandAloneInvocation(node)) {
					return true;
				}
				String variableName = node.getExpression().toString();

				if (isComponent(variableName)) {
					addFragmentToNode(node, variableName);
				}
				
				if (node.arguments().size() == 0) {
					return true;
				}
				String candidate = node.arguments().get(0).toString();
				
				if (toolCriteria.meetsCriteria(node.getName().toString()) && isComponent(candidate)) {
					createMultiLevelNode(variableName, candidate);
				}
				return true;
			}

		});
		
		widgetGraphs.add(builder);
	}
	
	private void createPrimitiveNode(VariableDeclarationFragment node) {
		String addingComponent = node.getName().getIdentifier();
		String widgetType = stringAdministrator.getVariableTypeFromDeclaration(node.getParent().toString());
		
		components.add(addingComponent);
		builder.addNode(addingComponent, "Primitive");
		builder.setWidgetType(addingComponent, widgetType);
		addFragmentToNode(node, addingComponent);
	}
	
	private void createMultiLevelNode(String addingComponent, String addedComponent) {
		int newLevel = builder.findNode(addedComponent).getNodeLevel();
		
		if (!multiLevelComponents.contains(addingComponent)) {
			WDGNode oldPrimitiveNode = builder.findNode(addingComponent);
			builder.getAllNodes().remove(oldPrimitiveNode);
			builder.addNode(addingComponent, "Composite");
			WDGNode newCompositeNode = builder.findNode(addingComponent);
			newCompositeNode.transferStatements(oldPrimitiveNode.getFragments());
			newCompositeNode.setNodeLevel(newLevel + 1);
			
			if (!(oldPrimitiveNode.getParent() == null)){
				oldPrimitiveNode.getParent().addSubNode(newCompositeNode);
				((CompositeNode) oldPrimitiveNode.getParent()).getSubNodes().remove(oldPrimitiveNode);
			}
			multiLevelComponents.add(addingComponent);
		}
		builder.addSubNode(addingComponent, addedComponent);
	}
	
	private void addFragmentToNode(ASTNode node, String nodeName) {
		builder.findNode(nodeName).addFragment(node.getParent().toString(), 
											   node.getParent().getLength(),
											   node.getParent().getStartPosition());
	}
	
	private boolean isComponent(String componentID) {
		return components.contains(componentID);
	}
	
	private boolean isInvalid(QualifiedName node) {
		return node.getParent().getNodeType() == ASTNode.CLASS_INSTANCE_CREATION 
			|| node.getParent().getNodeType() == ASTNode.INFIX_EXPRESSION;
	}
	
	private boolean isStandAloneInvocation(MethodInvocation node) {
		return node.getExpression() == null;
	}
	
	private boolean isAloneDeclaration(VariableDeclarationFragment node) {
		return node.getInitializer() == null;
	}

}
