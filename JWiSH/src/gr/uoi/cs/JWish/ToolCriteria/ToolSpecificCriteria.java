package gr.uoi.cs.JWish.ToolCriteria;

import java.util.HashSet;


public abstract class ToolSpecificCriteria {
	private String toolID;
	protected HashSet<String> criteria = new HashSet<String>();
	protected HashSet<String> toolWidgetTypes = new HashSet<String>();
	
	abstract protected void initializeCriteria();
	abstract protected void initializeWidgetNames();
	
	public ToolSpecificCriteria(String toolID) {
		this.toolID = toolID;
		initializeCriteria();
		initializeWidgetNames();
	}
	
	public String getToolID() {
		return toolID;
	}
	
	public boolean meetsCriteria(String name) {
		if (criteria.contains(name)) {
			return true;
		}
		return false;
	}
	
	public boolean isToolComponent(String variableType) {
		if (toolWidgetTypes.contains(variableType)) {
			return true;
		}
		return false;
	}
	
}
