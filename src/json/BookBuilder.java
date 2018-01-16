package json;

import wrappers.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiConsumer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import base.Element;
import base.alignment.AlignStrategy;
import base.alignment.CenterAlign;
import base.alignment.LeftAlign;
import base.alignment.RightAlign;
import base.items.Image;
import base.items.ImageProxy;
import base.items.Paragraph;

public class BookBuilder {
	
	private String filePath = null;
	private JSONParser parser = null;
	private FileReader reader = null;
	private JSONObject bookContainer = null; 
	
	public BookBuilder(String filePath) throws Exception {
		
		this.filePath = filePath;
		
		this.reader = new FileReader(this.filePath);
		
		this.parser = new JSONParser();
		
		
		this.bookContainer = (JSONObject) this.parser.parse(this.reader);
	}
	
	public Book initBook() throws Exception{
		
		// Get title and instantiate book.
		Book result = new Book((String) this.bookContainer.get("title"));
		
		// Set book authors.
		this.extractAuthors(result);
		
		// Set book children.
		this.setBookChildren((JSONArray) this.bookContainer.get("children"), result);
		
		return result;
	}
	
	private void extractAuthors(Book carte){
				
		// Extract book authors from the JSON file.
		JSONArray authors = (JSONArray) this.bookContainer.get("authors");
		
		for(int i = 0; i < authors.size(); i++){
			
			JSONObject author = (JSONObject) authors.get(i);
			
			String first =(String) author.get("first");
			String last = (String) author.get("last");
			
			// Create the new author.
			carte.addAutor(new Author(last,  first));
		}
	}
	
	private void setBookChildren(JSONArray children, Book carte) throws Exception{
		
		Element vessel = new Section("Host");
		
		this.setChildren(children, vessel);
		
		for(int i = 0; i < vessel.getChildLength(); i++)
			carte.addCapitol(vessel.getChild(i));
		
	}
	
	private void setChildren(JSONArray children, Element parent) throws Exception{
		
		for(int i = 0; i < children.size(); i++){
			
			JSONObject currentItem = (JSONObject) children.get(i);
			
			parent.add(this.getChild(currentItem));
		}
		
	}
	
	private Element getChild(JSONObject child) throws Exception{
		
		Element result = null;
		
		String className = (String) child.get("class");
		String itemTitle = (String) child.get("title");
		
		List childKeys = Arrays.asList((child.keySet().toArray()));
		
		Boolean hasChildren = childKeys.contains("children") && ((JSONArray) child.get("children")).size() != 0;
		Boolean hasAlignment = childKeys.contains("align");
		
		switch(className){
		
			case "Paragraph":	
				
				AlignStrategy strategy = new LeftAlign();
				
				if(hasAlignment == false)
					strategy = new LeftAlign();
				else
					switch((String) child.get("align")){				
						
						case "left": strategy = new LeftAlign(); break;
						
						case "right": strategy  = new RightAlign(); break;
						
						case "center": strategy  = new CenterAlign(); break;
					}
				
				return new Paragraph((String) child.get("text"), strategy);
			
			case "Section": 

				Section section = new Section(itemTitle);
				
				if(hasChildren == true)
					this.setChildren((JSONArray) child.get("children"), section);
				
				return section;
			
			case "Image":

				return new Image((String) child.get("url"));
			
			case "ImageProxy": 
				
				return new ImageProxy((String) child.get("url"));
				
				
		
		}		
		
		return result;		
	}
}
