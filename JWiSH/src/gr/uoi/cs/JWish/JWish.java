package gr.uoi.cs.JWish;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import gr.uoi.cs.JWish.Parsers.Parser;
import gr.uoi.cs.JWish.Parsers.ParserFactory;
import gr.uoi.cs.JWish.WDG.WDGBuilder;
import gr.uoi.cs.JWish.WDG.WDGNode;

public class JWish {
	private static final String PATH = "C:\\Users\\user\\Desktop\\FFT";

	public static void main(String[] args) {
		ParserFactory factory = new ParserFactory();
		Parser parser = factory.createParser("AST", PATH);
		parser.setToolCriteriaSource("Swing");
		
		PrintWriter outputStream = null;
		int filecounter = 0;
		
		try {
			parser.findEachFileSlices();
		} catch (IOException e) {
			System.out.println("Problem opening file.");
			System.exit(0);
		}
		
		for (WDGBuilder graph : parser.getWidgetGraphs()) {
			 try {
					outputStream = new PrintWriter(new FileOutputStream("Slices" + filecounter + ".txt"));
			 } catch (FileNotFoundException e) {
					System.out.println("Problem opening File. ");
			 }

			 for (WDGNode node : graph.getAllNodes()) {
				// if (node.getNodeID().equals("mnFile")){
					 node.printNodeInfo(outputStream);
				 //}
			 }
			 filecounter++;
		}
		 outputStream.close();
	}

}
