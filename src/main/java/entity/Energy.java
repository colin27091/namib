package entity;

public class Energy {
    
    private int valeur;
    private String name;
    
    
    public Energy(){
        
    }

    public Energy(int valeur, String name) {
        this.valeur = valeur;
        this.name = name;
    }
    
    public int getValeur() {
        return valeur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
    
    
}
