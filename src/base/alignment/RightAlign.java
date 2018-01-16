package base.alignment;

public class RightAlign implements AlignStrategy {

	private static String alignmentFormat = "\t\t\t\t\t\t%s";
	
public void printParagraf(String text){
		
		System.out.println(String.format(RightAlign.alignmentFormat, text));
	}
}
