package gr.uoi.cs.JWish.WDG;

import java.io.PrintWriter;


public class PrimitiveNode extends WDGNode{
	
	public PrimitiveNode(String nodeID) {
		super (nodeID);
		this.setNodeLevel(0);
	}
	
	public void addSubNode(WDGNode node) {
	}
	
	public void printNodeInfo(PrintWriter outputStream) {
		outputStream.println("*************** SLICE OF " + nodeID + "*************");
		for (SliceFragment fragment : sliceFragments) {
			outputStream.println(fragment.getFragment());
		}
		outputStream.println();
	}

}
