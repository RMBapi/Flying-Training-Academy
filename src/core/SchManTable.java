package core;

import javafx.beans.property.SimpleStringProperty;

public class SchManTable {
    private SimpleStringProperty name, id;
    private SimpleStringProperty part;
    

    public SchManTable(String name, String id,String part) {
        this.name = new SimpleStringProperty(name);
        this.id = new SimpleStringProperty(id);
        this.part = new SimpleStringProperty(part);
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public void setId(String id) {
        this.id = new SimpleStringProperty(id);
    }

    public void setPart(String part) {
        this.part = new SimpleStringProperty(part);
    }

     public String getName() {
        return name.get();
    }

    public String getId() {
        return id.get();
    }
    public String getPart() {
        return part.get();
    }
    
}

