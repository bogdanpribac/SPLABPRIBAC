package wrappers;
import java.io.IOException;
//0733778253
import java.util.ArrayList;

import base.Element;
import base.statistics.Visitor;
import base.statistics.VisitorStatistics;
import wrappers.Author;;

public class Book {

    private String titlu;
    private ArrayList<Author> autori;
    private ArrayList<Element> continut = new ArrayList<Element>();
    private VisitorStatistics stat = new VisitorStatistics();

    public Book(String titlu, ArrayList<Author> autori) {

        this.titlu = titlu;
        this.autori = autori;
    }

    public Book(String titlu) {

        this.titlu = titlu;
        
        this.autori = new ArrayList<Author>();
    }
    
    public Book(ArrayList<Author> autori){
    	
    	this.autori = autori;
    }
    
    public void addAutor(Author autor){
    	
    	this.autori.add(autor);
    }

    public void addCapitol(Element capitol) {
        
    	capitol.accept(this.stat);
        this.continut.add(capitol);
    }
    
    public void setTitle(String title) throws Exception{
    	
    	if(this.titlu!= null)
    		this.titlu = title;
    	else
    		throw new Exception("The page title cannot be overwritten,");
    }

    public void print() throws IOException {

        // Show book title.
        System.out.print(String.format("\"%s\" by: ", this.titlu));

        // All authors.
        String authros = this.autori.toString().replaceAll(",", " &");
        System.out.println(authros.substring(1, authros.length() - 1));
        

        // All contents.
        for (Element contentElement : continut) {
            contentElement.print();
        }
    }
}
