package core;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class AddStu {
    private SimpleStringProperty name, id;
    private SimpleIntegerProperty year;


    public AddStu(String name, String id,int year ) {
        this.name = new SimpleStringProperty(name);
        this.id = new SimpleStringProperty(id);
        this.year = new SimpleIntegerProperty(year);
        
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public void setId(String id) {
        this.id = new SimpleStringProperty(id);
    }

    public void setguestPerson(int year) {
        this.year = new SimpleIntegerProperty(year);
    }

    
    
    public String getName() {
       
        return name.get();
    }

    public String getID() {
        return id.get();
    }
    public int getYear() {
        return year.get();
    }
}

