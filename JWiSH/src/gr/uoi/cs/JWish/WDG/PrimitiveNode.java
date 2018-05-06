package gr.uoi.cs.JWish.WDG;

import java.io.PrintWriter;
import java.util.ArrayList;


public class PrimitiveNode extends WDGNode{
	private ArrayList<SliceFragment> sliceFragments = new ArrayList<SliceFragment>();
	
	public PrimitiveNode(String nodeID) {
		super (nodeID);
		this.setNodeLevel(0);
	}
	
	public void addFragment(String fragment, int fragmentLength, int fragmentStartPosition) {
		sliceFragments.add(new SliceFragment(fragment, fragmentLength, fragmentStartPosition));
	}
	
	public ArrayList<SliceFragment> getFragments() {
		return sliceFragments;
	}
	
	public void addSubNode(WDGNode node) {
		return;
	}
	
	public void setOriginNode(WDGNode node) {
		return;
	}
	
	public void printNodeInfo(PrintWriter outputStream) {
		outputStream.println("*************** SLICE OF " + nodeID + "*************");
		for (SliceFragment fragment : sliceFragments) {
			outputStream.println(fragment.getFragment());
		}
		outputStream.println();
	}

}
