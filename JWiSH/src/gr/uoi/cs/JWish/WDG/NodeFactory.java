package gr.uoi.cs.JWish.WDG;

public class NodeFactory {
	
	public WDGNode createNode(String nodeID, String nodeType) {
		if (nodeType.equals("Composite")) {
			return new CompositeNode(nodeID);	
		} else if (nodeType.equals("Primitive")) {
			return new PrimitiveNode(nodeID);
		} else {
	    		return null;
		}
	}

}
