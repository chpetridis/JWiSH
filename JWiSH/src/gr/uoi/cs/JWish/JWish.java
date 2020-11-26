package gr.uoi.cs.JWish;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import gr.uoi.cs.JWish.Parsers.Parser;
import gr.uoi.cs.JWish.Parsers.ParserFactory;
import gr.uoi.cs.JWish.WDG.WDGNode;

public class JWish {
	private static final String PATH = "C:\\Users\\user\\Desktop\\FFT";

	public static void main(String[] args) {
		ParserFactory factory = new ParserFactory();
		Parser parser = factory.createParser("AST", PATH);
		parser.setToolCriteriaSource("Swing");
		PrintWriter outputStream = null;
		
		long startTime = System.nanoTime();
		try {
			parser.findEachFileSlices();
		} catch (IOException e) {
			System.out.println("Problem opening file.");
			System.exit(0);
		}
		System.out.println("Time passed: " + ((System.nanoTime() - startTime)/ 1000000000.0) + " seconds");
		
		try {
			outputStream = new PrintWriter(new FileOutputStream("Slices.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening File. ");
		}
		 
		Slicer slicer = new Slicer(parser.getWidgetGraphs().get(0));
		
		for (WDGNode node : slicer.getAllWidgets()) {
			node.printNodeInfo(outputStream);
		}

		if (outputStream != null) {
			outputStream.close();
		}
	}

}
