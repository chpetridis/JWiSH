package gr.uoi.cs.JWish.WDG;

import java.io.PrintWriter;
import java.util.ArrayList;


public class CompositeNode extends WDGNode{
	private ArrayList<WDGNode> subNodes = new ArrayList<WDGNode>();
	private PrimitiveNode originNode;
	
	public CompositeNode(String nodeID) {
		super (nodeID);
	}
	
	public void addFragment(String fragment, int fragmentLength, int fragmentStartPosition) {
		originNode.addFragment(fragment, fragmentLength, fragmentStartPosition);
	}
	
	public ArrayList<SliceFragment> getFragments() {
		return originNode.getFragments();
	}
	
	public WDGNode getOriginNode() {
		return originNode;
	}
	
	public void addSubNode(WDGNode subNode) {
		if (subNodes.contains(subNode)) {
			return;
		}
		subNodes.add(subNode);
		subNode.setParent(this);
		updateLevel(subNode);
	}
	
	private void updateLevel(WDGNode subNode) {
		if (subNode.getNodeLevel() >= this.getNodeLevel()) {
			this.setNodeLevel(subNode.getNodeLevel() + 1);
			informParentForChange();
		}
	}
	
	private void informParentForChange() {
		if (!(this.getParent() == null)) {
			((CompositeNode)this.getParent()).updateLevel(this);
		}
	}
	
	public void setOriginNode(WDGNode node) {
		this.originNode = (PrimitiveNode) node;
	}
	
	public ArrayList<WDGNode> getSubNodes() {
		return subNodes;
	}
	
	public void printNodeInfo(PrintWriter outputStream) {
		originNode.printNodeInfo(outputStream);
		outputStream.println("------------------Sub-Nodes info for: " + nodeID);
		for (WDGNode subSlice : subNodes) {
			subSlice.printNodeInfo(outputStream);
		}
		outputStream.println("------------------End of composite slice " + nodeID);
	}

}
