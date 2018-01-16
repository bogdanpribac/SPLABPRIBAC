package base.items;

import base.AbstractElement;
import base.statistics.Visitor;
import base.statistics.VisitorStatistics;

public class Table extends AbstractElement {

    private String name;

    public Table(String nume) {

    	// Save the table name.
        this.name = nume;
    }

    public void print() {

    	// Call this toString method.
        System.out.print(this);
    }
    
    public String toString(){
    	
    	return String.format("Nume tabel: %s", this.name);
    }
    
    public void accept(Visitor v){
    	
    	v.visitTabel(this);
    }

}
