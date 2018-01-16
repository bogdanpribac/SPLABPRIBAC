package base.items;

import base.AbstractElement;
import base.alignment.AlignStrategy;
import base.alignment.LeftAlign;
import base.statistics.Visitor;

public class Paragraph extends AbstractElement {

	private String contents = null;
	private String title = null;
	private AlignStrategy strategy = new LeftAlign();
	
	public Paragraph(String content, AlignStrategy align){
		
		this.contents = content;
		this.strategy = align;
	}
	
	public void print() {
		
		this.strategy.printParagraf(this.contents);
	}	
	
	public void accept(Visitor visitor){
		
		visitor.visitParagraf(this);
	}
}
