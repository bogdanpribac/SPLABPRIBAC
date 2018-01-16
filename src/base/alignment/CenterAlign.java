package base.alignment;

public class CenterAlign  implements AlignStrategy {

	private static String alignmentFormat = "\t\t\t%s\t\t\t";
	
	public CenterAlign() {

	}
	
	public void printParagraf(String text){
		
		System.out.println(String.format(CenterAlign.alignmentFormat, text));
	}

}
