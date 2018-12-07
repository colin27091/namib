package entity;


public class Maintenance {
    
    private String name;
    private String description;

    public Maintenance(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getId_equipment() {
        return name;
    }

    public void setId_equipment(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
