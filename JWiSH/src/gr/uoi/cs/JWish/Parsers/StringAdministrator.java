package gr.uoi.cs.JWish.Parsers;

public class StringAdministrator {
	
	public String getConstructorName(String constructorText) {
		return extractInformation(constructorText, '(', '(', ' ');
	}
	
	public String getComponentName(String constructorText) {
		return extractInformation(constructorText, ',', ')', '(');
	}
	
	private String extractInformation(String constructorText, char firstBreakPoint, 
									  char secondBreakPoint, char startPoint) {
		
		String componentName = "";
		boolean foundStartPoint = false;
		
		for (char character : constructorText.toCharArray()) {
			if (foundStartPoint) {
				if (character == firstBreakPoint || character == secondBreakPoint) {
						break;
				}
				componentName += character;
			}
			
			if (!(character == startPoint)) {
				continue;
			} else {
				foundStartPoint = true;
			}
		}
		return componentName;
	}
	
	public String getVariableTypeFromDeclaration(String declaration) {
		String componentType = "";
		
		for (String word : declaration.split(" ")) {
			if (!isJavaStandardType(word)) {
				componentType += word;
				break;
			}
		}
		return takeFurtherActions(componentType);
	}
	
	private boolean isJavaStandardType(String type) {
		return type.equals("private") || type.equals("public")
			   || type.equals("protected")
			   || type.equals("static")
			   || type.equals("final");
	}
	
	private String takeFurtherActions(String componentType) {
		if (componentType.contains(".")) {
			String[] words = componentType.split("\\.");
			return words[words.length - 1];
		}
		return componentType;
	}

}
