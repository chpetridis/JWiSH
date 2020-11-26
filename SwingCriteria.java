package gr.uoi.cs.JWish.ToolCriteria;

public class SwingCriteria extends ToolSpecificCriteria{
	
	public SwingCriteria(String toolID) {
		super (toolID);
	}
	
	protected void initializeComponentAdditionEvent() {
		criteria.add("add");
		criteria.add("addLayoutComponent");
		criteria.add("addImpl");
		criteria.add("JPanel");
		criteria.add("Popup");
	}
	
	 protected void initializeWidgetNames() {
		 toolWidgetTypes.add("ButtonGroup");
		 toolWidgetTypes.add("Box");
		 toolWidgetTypes.add("Container");
		 toolWidgetTypes.add("GroupLayout");
		 toolWidgetTypes.add("Separator");
		 toolWidgetTypes.add("JApplet");
		 toolWidgetTypes.add("JButton");
		 toolWidgetTypes.add("JCheckBox");
		 toolWidgetTypes.add("JCheckBoxMenuItem");
		 toolWidgetTypes.add("JColorChooser");
		 toolWidgetTypes.add("JComboBox");
		 toolWidgetTypes.add("JComponent");
		 toolWidgetTypes.add("JDesktopPane");
		 toolWidgetTypes.add("JDialog");
		 toolWidgetTypes.add("JEditorPane"); 
		 toolWidgetTypes.add("JFileChooser");
		 toolWidgetTypes.add("JFormattedTextField");
		 toolWidgetTypes.add("JFrame");
		 toolWidgetTypes.add("JInternalFrame");
		 toolWidgetTypes.add("JLabel");
		 toolWidgetTypes.add("JLayer");
		 toolWidgetTypes.add("JLayeredPane");
		 toolWidgetTypes.add("JList");
		 toolWidgetTypes.add("JMenu");
		 toolWidgetTypes.add("JMenuBar");
		 toolWidgetTypes.add("JMenuItem");
		 toolWidgetTypes.add("JOptionPane");
		 toolWidgetTypes.add("JPanel");
		 toolWidgetTypes.add("JPasswordField");
		 toolWidgetTypes.add("JPopupMenu");
		 toolWidgetTypes.add("JProgressBar");
		 toolWidgetTypes.add("JRadioButton");
		 toolWidgetTypes.add("JRadioButtonMenuItem");
		 toolWidgetTypes.add("JRootPane");
		 toolWidgetTypes.add("JScrollBar");
		 toolWidgetTypes.add("JScrollPane");
		 toolWidgetTypes.add("JSeparator");
		 toolWidgetTypes.add("JSlider");
		 toolWidgetTypes.add("JSpinner");
		 toolWidgetTypes.add("JSplitPane");
		 toolWidgetTypes.add("JTabbedPane");
		 toolWidgetTypes.add("JTable");
		 toolWidgetTypes.add("JTextArea");
		 toolWidgetTypes.add("JTextField");
		 toolWidgetTypes.add("JTextPane");
		 toolWidgetTypes.add("JToggleButton");
		 toolWidgetTypes.add("JToolBar");
		 toolWidgetTypes.add("JToolTip");
		 toolWidgetTypes.add("JTree");
		 toolWidgetTypes.add("JViewport");
		 toolWidgetTypes.add("JWindow");		 
	 }

}
