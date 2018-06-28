package gr.uoi.cs.JWish;

import java.util.ArrayList;

import gr.uoi.cs.JWish.WDG.WDGBuilder;
import gr.uoi.cs.JWish.WDG.WDGNode;

public class Slicer {
	private WDGBuilder graph;
	
	public Slicer(WDGBuilder graph) {
		this.graph = graph;
	}
	
	public WDGNode getWidget(String nodeID) {
		return graph.findNode(nodeID);
	}
	
	public ArrayList<WDGNode> getAllWidgets() {
		return graph.getAllNodes();
	}
	
	public ArrayList<WDGNode> getAllWidgetsOfLevel(int level) {
		ArrayList<WDGNode> specificLevelNodes = new ArrayList<WDGNode>();
		
		for (WDGNode node : graph.getAllNodes()) {
			if (node.getNodeLevel() == level) {
				specificLevelNodes.add(node);
			}
		}
		return specificLevelNodes;
	}
	
	public ArrayList<WDGNode> getSpecificLevelAndTypeWidgets(int level, String widgetType) {
		ArrayList<WDGNode> specificLevelAndTypeNodes = new ArrayList<WDGNode>();
		
		for (WDGNode node : graph.getAllNodes()) {
			if (node.getWidgetType() == null) {
				continue;
			}
			if (node.getNodeLevel() == level && node.getWidgetType().equals(widgetType)) {
				specificLevelAndTypeNodes.add(node);
			}
		}
		return specificLevelAndTypeNodes;
	}
	
	public WDGNode getMaxLevelWidget() throws NullPointerException{
		int max = 0;
		WDGNode maxLevelWidget = null;
		
		for (WDGNode node : graph.getAllNodes()) {
			if (node.getNodeLevel() > max) {
				max = node.getNodeLevel();
				maxLevelWidget = node;
			}
		}
		return maxLevelWidget;
	}
	
	public ArrayList<WDGNode> getAllWidgetsOfType(String widgetType) {
		ArrayList<WDGNode> specificTypeNodes = new ArrayList<WDGNode>();
		
		for (WDGNode node : graph.getAllNodes()) {
			if (node.getWidgetType() == null) {
				continue;
			}
			if (node.getWidgetType().equals(widgetType)) {
				specificTypeNodes.add(node);
			}
		}
		return specificTypeNodes;
	}

}
