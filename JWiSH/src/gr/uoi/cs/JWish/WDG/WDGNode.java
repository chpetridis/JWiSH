package gr.uoi.cs.JWish.WDG;

import java.io.PrintWriter;
import java.util.ArrayList;


public abstract class WDGNode {
	protected String nodeID;
	protected WDGNode parent;
	
	abstract public void printNodeInfo(PrintWriter outputStream);
	abstract public void addFragment(String fragment, int fragmentLength, int fragmentStartPosition);
	abstract public void addSubNode(WDGNode node);
	abstract public void setOriginNode(WDGNode originSlice);
	abstract public ArrayList<SliceFragment> getFragments();
	
	public WDGNode(String nodeID) {
		this.nodeID = nodeID;
	}

	public String getNodeID() {
		return nodeID;
	}
	
	protected void setParent(WDGNode parent) {
		this.parent = parent;
	}

	public WDGNode getParent() {
		return parent;
	}
}
