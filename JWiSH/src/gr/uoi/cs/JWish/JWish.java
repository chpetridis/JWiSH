package gr.uoi.cs.JWish;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import gr.uoi.cs.JWish.Parsers.Parser;
import gr.uoi.cs.JWish.Parsers.ParserFactory;
import gr.uoi.cs.JWish.WDG.WDGBuilder;
import gr.uoi.cs.JWish.WDG.WDGNode;

public class JWish {
	private static final String PATH = "C:\\Users\\user\\Desktop\\FFT";

	public static void main(String[] args) {
		ParserFactory factory = new ParserFactory();
		Parser parser = factory.createParser("AST", PATH);
		parser.setToolCriteriaSource("SWT");
		PrintWriter outputStream = null;
		//Random rand = new Random();
		
		//long starttime = System.currentTimeMillis();
		try {
			parser.findEachFileSlices();
		} catch (IOException e) {
			System.out.println("Problem opening file.");
			System.exit(0);
		}
		//double elapsedSeconds = (System.currentTimeMillis() - starttime) / 1000.0;
		//System.out.println("Time passed: " + elapsedSeconds + " seconds");
		
		try {
			outputStream = new PrintWriter(new FileOutputStream("Slices.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening File. ");
		}
		 
		Slicer slicer = new Slicer(parser.getWidgetGraphs().get(0));

		outputStream.close();
	}

}
