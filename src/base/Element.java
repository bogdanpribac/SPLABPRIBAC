package base;

import java.io.IOException;

import base.statistics.Visitor;
import base.statistics.VisitorStatistics;

public interface Element {

    public void add(Element element) throws Exception;

    public void remove(Element element) throws Exception;

    public Element getChild(int index);

    public int getChildLength();
    
    public void accept(Visitor visitorStatistics);

    public void print() throws IOException;
    
    public String getTitle();
}
