package gr.uoi.cs.JWish.WDG;

import java.util.ArrayList;


public class WDGBuilder {
	private ArrayList<WDGNode> widgetNodes = new ArrayList<WDGNode>();
	private NodeFactory factory = new NodeFactory();
	
	public void addNode(String nodeID, String nodeType) {
		widgetNodes.add(factory.createNode(nodeID, nodeType));
	}
	
	public WDGNode findNode(String nodeID) {
		for (WDGNode node : widgetNodes) {
			if (nodeID.equals(node.getNodeID())) {
				return node;
			}
		}
		return null;
	}
	
	public void setWidgetType(String nodeID, String widgetType) {
		findNode(nodeID).setWidgetType(widgetType);
	}
	
	public void addSubNode(String sourceNode, String destinationNode) {
		findNode(sourceNode).addSubNode(findNode(destinationNode));
	}
	
	public ArrayList<WDGNode> getAllNodes() {
		return widgetNodes;
	}
	
}
