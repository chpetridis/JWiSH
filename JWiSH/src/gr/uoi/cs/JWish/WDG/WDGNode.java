package gr.uoi.cs.JWish.WDG;

import java.io.PrintWriter;
import java.util.ArrayList;


public abstract class WDGNode {
	protected String nodeID;
	protected WDGNode parent;
	private int nodeLevel;
	private String widgetType;
	protected ArrayList<SliceFragment> sliceFragments = new ArrayList<>();
	
	abstract public void printNodeInfo(PrintWriter outputStream);
	abstract public void addSubNode(WDGNode node);
	
	public WDGNode(String nodeID) {
		this.nodeID = nodeID;
	}
	
	public void addFragment(String fragment, int fragmentLength, int fragmentStartPosition) {
		sliceFragments.add(new SliceFragment(fragment, fragmentLength, fragmentStartPosition));
	}
	
	public ArrayList<SliceFragment> getFragments() {
		return sliceFragments;
	}
	
	public void transferStatements(ArrayList<SliceFragment> other) {
		this.sliceFragments.addAll(other);
	}

	public String getNodeID() {
		return nodeID;
	}
	
	public String getWidgetType() {
		return widgetType;
	}
	
	protected void setParent(WDGNode parent) {
		this.parent = parent;
	}

	public WDGNode getParent() {
		return parent;
	}
	
	public int getNodeLevel() {
		return nodeLevel;
	}
	
	public void setNodeLevel(int nodeLevel) {
		this.nodeLevel = nodeLevel;
	}
	
	public void setWidgetType(String widgetType) {
		this.widgetType = widgetType;
	}
	
}
