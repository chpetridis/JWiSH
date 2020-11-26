package gr.uoi.cs.JWish.ToolCriteria;


public class ToolFactory {
	
	/*
	 * You can add your own tool here.
	 */
	public ToolSpecificCriteria getToolType(String toolID) {
		if (toolID.equals("Swing")) {
			return new SwingCriteria(toolID);	
		} else if (toolID.equals("SWT")) {
			return new SWTCriteria(toolID);
		} else {
	    	return null;
		}
	}

}
