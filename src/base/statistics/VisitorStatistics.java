	package base.statistics;

import base.Element;
import base.items.*;
import wrappers.Section;

public class VisitorStatistics implements Visitor {



    private static int imageCount = 0;

    private static int paragrafCount = 0;

    private static int tabelCount = 0;

    private static int sectiuneCount = 0;



    public static void printStatistics(){

        System.out.println("Exista:");

        System.out.println(sectiuneCount + " sectiuni");

        System.out.println(imageCount + " imagini");

        System.out.println(paragrafCount + " paragrafe");

        System.out.println(tabelCount + " tabele");

    }



    public void visitImageProxy(ImageProxy image){

        imageCount++;

    }



    public void visitImage(Image image){

        imageCount++;

    }

    public void visitParagraf(Paragraph paragraf){

        paragrafCount++;

    }

    public void visitTabel(Table tabel){

        tabelCount++;

    }

	public void visitSection(Section section) {

        sectiuneCount++;

		for(int i  = 0; i < section.getChildLength(); i++)
			section.getChild(i).accept(this);


		
	}
}