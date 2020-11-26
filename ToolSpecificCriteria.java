package gr.uoi.cs.JWish.ToolCriteria;

import java.util.HashSet;


public abstract class ToolSpecificCriteria {
	private final String toolID;
	protected HashSet<String> criteria = new HashSet<>();
	protected HashSet<String> toolWidgetTypes = new HashSet<>();
	
	abstract protected void initializeComponentAdditionEvent();
	abstract protected void initializeWidgetNames();
	
	public ToolSpecificCriteria(String toolID) {
		this.toolID = toolID;
		initializeComponentAdditionEvent();
		initializeWidgetNames();
	}
	
	public String getToolID() {
		return toolID;
	}
	
	public boolean meetsCriteria(String name) {
		return criteria.contains(name);
	}
	
	public boolean isToolComponent(String variableType) {
		return toolWidgetTypes.contains(variableType);
	}
	
}
