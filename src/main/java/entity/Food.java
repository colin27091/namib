package entity;

public class Food {
    
    private String type;
    private int cal;
    private int quantity;

    
    public Food(String type, int cal, int quantity) {
        this.type = type;
        this.cal = cal;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCal() {
        return cal;
    }

    public void setCal(int cal) {
        this.cal = cal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
