package gr.uoi.cs.JWish.Parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import gr.uoi.cs.JWish.ToolCriteria.ToolFactory;
import gr.uoi.cs.JWish.ToolCriteria.ToolSpecificCriteria;
import gr.uoi.cs.JWish.WDG.WDGBuilder;

public abstract class Parser {
	private String pathToFiles;
	private ToolFactory factory = new ToolFactory();
	protected ToolSpecificCriteria toolCriteria;
	protected ArrayList<WDGBuilder> widgetGraphs = new ArrayList<WDGBuilder>();
	protected StringAdministrator stringAdministrator = new StringAdministrator();
	
	protected abstract void findSlices(String stringOfFile);

	public Parser(String pathToFiles) {
		this.pathToFiles = pathToFiles;
	}
	
	public void findEachFileSlices() throws IOException{
		File root = new File(pathToFiles);
		File[] files = root.listFiles();
 
		for (File file : files) {
			if(file.isFile()){
				findSlices(readFileToString(file.getAbsolutePath()));
			}
		}
	}
	
	private static String readFileToString(String filePath) throws IOException {
		StringBuilder fileData = new StringBuilder(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
 
		char[] buf = new char[10];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}
 
		reader.close();
		return  fileData.toString();	
	}
	
	public void setToolCriteriaSource(String source) {
		toolCriteria = factory.getToolType(source);
	}
	
	public ArrayList<WDGBuilder> getWidgetGraphs() {
		return widgetGraphs;
	}
	
}
