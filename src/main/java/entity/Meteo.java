package entity;


public class Meteo {
    
    public final static int SOLEIL = 0;
    public final static int PLUIE = 1;
    public final static int ORAGE = 2;
    public final static int VENT = 3;
    public final static int NUAGEUX = 4;
    
    private int temps;
    
   public Meteo(int temps){
       this.temps = temps;
   }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }
   
   
   
   
    
    
    
}
