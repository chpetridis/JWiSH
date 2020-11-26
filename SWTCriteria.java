package gr.uoi.cs.JWish.ToolCriteria;

public class SWTCriteria extends ToolSpecificCriteria{
	
	public SWTCriteria(String toolID) {
		super (toolID);
	}
	
	protected void initializeComponentAdditionEvent() {
		criteria.add("Widget");
		criteria.add("Composite");
		criteria.add("Canvas");
		criteria.add("Caret");
		criteria.add("ColorDialog");
		criteria.add("Combo");
		criteria.add("Control");
		criteria.add("CoolBar");
		criteria.add("CoolItem");
		criteria.add("DateTime");
		criteria.add("Decorations");
		criteria.add("Button");
		criteria.add("Dialog");
		criteria.add("DirectoryDialog");
		criteria.add("ExpandBar");
		criteria.add("ExpandItem");
		criteria.add("FileDialog");
		criteria.add("FontDialog");
		criteria.add("Group");
		criteria.add("IME");
		criteria.add("Item");
		criteria.add("Label");
		criteria.add("Link");
		criteria.add("List");
		criteria.add("Menu");
		criteria.add("MenuItem");
		criteria.add("MessageBox");
		criteria.add("ProgressBar");
		criteria.add("Sash");
		criteria.add("Scale");
		criteria.add("Scrollable");
		criteria.add("Shell");
		criteria.add("Slider");
		criteria.add("Spinner");
		criteria.add("Sychronizer");
		criteria.add("TabFolder");
		criteria.add("TabItem");
		criteria.add("Table");
		criteria.add("TableColumn");
		criteria.add("TableItem");
		criteria.add("Text");
		criteria.add("ToolBar");
		criteria.add("ToolItem");
		criteria.add("ToolTip");
		criteria.add("Tracker");
		criteria.add("Tree");
		criteria.add("TreeColumn");
		criteria.add("TreeItem");
		criteria.add("setLayout");
		criteria.add("setMenu");
		criteria.add("setParent");
		criteria.add("setMenuBar");
		criteria.add("setCaret"); // ?
		criteria.add("setIME"); // ?
		criteria.add("setSelection"); // ?	
	}
	
	protected void initializeWidgetNames() {
		toolWidgetTypes.add("Button");
		toolWidgetTypes.add("Canvas");
		toolWidgetTypes.add("Caret");
		toolWidgetTypes.add("ColorDialog");
		toolWidgetTypes.add("Combo");
		toolWidgetTypes.add("Composite");
		toolWidgetTypes.add("Control");
		toolWidgetTypes.add("CoolBar");
		toolWidgetTypes.add("CoolItem");
		toolWidgetTypes.add("DateTime");
		toolWidgetTypes.add("Decorations");
		toolWidgetTypes.add("Dialog");
		toolWidgetTypes.add("DirectoryDialog");
		toolWidgetTypes.add("Display");
		toolWidgetTypes.add("Event");
		toolWidgetTypes.add("ExpandBar");
		toolWidgetTypes.add("ExpandItem");
		toolWidgetTypes.add("FileDialog");
		toolWidgetTypes.add("FontDialog");
		toolWidgetTypes.add("Group");
		toolWidgetTypes.add("IME");
		toolWidgetTypes.add("Item");
		toolWidgetTypes.add("Label");
		toolWidgetTypes.add("Layout");
		toolWidgetTypes.add("Link");
		toolWidgetTypes.add("List");
		toolWidgetTypes.add("Menu");
		toolWidgetTypes.add("MenuItem");
		toolWidgetTypes.add("MessageBox");
		toolWidgetTypes.add("Monitor");
		toolWidgetTypes.add("ProgressBar");
		toolWidgetTypes.add("Sash");
		toolWidgetTypes.add("Scale");
		toolWidgetTypes.add("Scrollable");
		toolWidgetTypes.add("ScrollBar");
		toolWidgetTypes.add("Shell");
		toolWidgetTypes.add("Slider");
		toolWidgetTypes.add("Spinner");
		toolWidgetTypes.add("Synchronizer");
		toolWidgetTypes.add("TabFolder");
		toolWidgetTypes.add("TabItem");
		toolWidgetTypes.add("Table");
		toolWidgetTypes.add("TableColumn");
		toolWidgetTypes.add("TableItem");
		toolWidgetTypes.add("TaskBar");
		toolWidgetTypes.add("TaskItem");
		toolWidgetTypes.add("Text");
		toolWidgetTypes.add("ToolBar");
		toolWidgetTypes.add("ToolItem");
		toolWidgetTypes.add("ToolTip");
		toolWidgetTypes.add("Touch");
		toolWidgetTypes.add("TouchSource");
		toolWidgetTypes.add("Tracker");
		toolWidgetTypes.add("Tray");
		toolWidgetTypes.add("TrayItem");
		toolWidgetTypes.add("Tree");
		toolWidgetTypes.add("TreeColumn");
		toolWidgetTypes.add("TreeItem");
		toolWidgetTypes.add("TypedListener");
		toolWidgetTypes.add("Widget");
	}
	
}
