package base.alignment;

public class LeftAlign  implements AlignStrategy {

	private static String alignmentFormat = "%s";

	public void printParagraf(String text){
		
		System.out.println(String.format(LeftAlign.alignmentFormat, text));
	}
}
