package wrappers;

import java.io.IOException;
import java.util.ArrayList;

import base.Element;
import base.statistics.Visitor;

public class Section implements Element {
	
	private String titlu;
	ArrayList<Element> contents = new ArrayList<Element>();

	public Section(String titlu){

		
		this.titlu = titlu;
		
	}

	public void add(Element element)  {

		this.contents.add(element);
	}

	public void remove(Element element) {

		this.contents.remove(element);
		
	}

	@Override
	public Element getChild(int index) {

		return this.contents.get(index);
	}

	@Override
	public void accept(Visitor visitor) {

		visitor.visitSection(this);		
	}

	@Override
	public void print() throws IOException {
		
		System.out.println(this.titlu);
		
		for(Element child : this.contents)
				child.print();
	}

	@Override
	public String getTitle() {

		return this.titlu;
	}

	@Override
	public int getChildLength() {

		return this.contents.size();
	}
}
