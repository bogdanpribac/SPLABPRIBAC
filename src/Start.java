import java.util.ArrayList;

import base.Element;
import base.items.Paragraph;
import base.items.Table;
import base.statistics.VisitorStatistics;
import json.BookBuilder;
import wrappers.Author;
import wrappers.Book;

public class Start {

	private static String bookTitle = "Once upon a time";
	
	public static void main(String args[]) throws Exception{

		
		BookBuilder builder = new BookBuilder("book.json");		
		
		Book carte =  builder.initBook();
		
		carte.print();
		
		VisitorStatistics.printStatistics();
	}
}
