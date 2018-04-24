package gr.uoi.cs.JWish.Parsers;

public class ParserFactory {
	
	public Parser createParser(String parserType, String pathToFiles) {
		/*
		 * You can add your own parser type here.
		 */
		if (parserType.equals("AST")) {
			return new ParserAST(pathToFiles);	
		} else {
	    	return null;
		}
	}

}
