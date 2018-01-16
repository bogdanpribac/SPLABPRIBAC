package base;

import base.statistics.Visitor;
import base.statistics.VisitorStatistics;

public class AbstractElement implements Element {
	
	private Exception notSupported = new Exception("Not supported yet.");
	public void add(Element element) throws Exception {
		
		throw this.notSupported;
	}

	@Override
	public void remove(Element element) throws Exception {
		
		throw this.notSupported;
		
	}

	@Override
	public Element getChild(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildLength() {

		return 0;
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
