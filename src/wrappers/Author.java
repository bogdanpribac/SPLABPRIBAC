package wrappers;

import java.util.ArrayList;

public class Author {

    private String nume;
    private String prenume;

    public Author(String nume, String prenume) {

        this.nume = nume;
        this.prenume = prenume;
    }

    public String toString() {

        return String.format("%s %s", this.prenume, this.nume);
    }
    
    public static ArrayList<Author> createFromArguments(String ...args){
    	
    	ArrayList<Author> result = new ArrayList<Author>();
    	
    	for(String name : args){
    	
    		// Split author name.
    		String first = name.split(" ")[0],
    				last = name.split(" ")[1];
    		
    		// Create the new author.
    		result.add(new Author(last, first));
    	
    	}
    	
    	return result;
    }
}
