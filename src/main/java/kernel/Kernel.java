package kernel;

import entity.Energy;
import entity.Equipment;
import entity.Food;
import entity.Heatlh;
import entity.Maintenance;
import entity.Water;
import java.util.ArrayList;
import java.util.List;

public class Kernel {
    
    private List<Energy> energy;
    private List<Equipment> equipments;
    private List<Food> foodManager;
    private Heatlh heatlh;
    private List<Maintenance> maintenance;
    private Water water;
    private static Kernel instance;
    
    public static Kernel getInstance() {
        if (instance == null) {
             instance = new Kernel();
        }
        return instance;
    
    }
    
    
    public Kernel(){
        this.equipments = new ArrayList<Equipment>();
        this.equipments.add(new Equipment("Panneaux photovoltaïques", true));
        this.equipments.add(new Equipment("Portable", true));
        this.equipments.add(new Equipment("Panneaux Solaires", true));
        this.equipments.add(new Equipment("Eoliennes", true));
        this.equipments.add(new Equipment("Appareils de mesure", true));
        
        this.energy = new ArrayList<Energy>();
        this.energy.add(new Energy(100, "Portable"));
        this.energy.add(new Energy(100, "Appareils de mesure"));
        
        this.foodManager = new ArrayList<Food>();
        this.foodManager.add(new Food("Pain", 100, 50));
        this.foodManager.add(new Food("Fruit", 50, 50));
        this.foodManager.add(new Food("Conserve légume", 10, 100));
        this.foodManager.add(new Food("Viandes", 50, 100));
        
        
        this.heatlh = (new Heatlh((float) 80.0));
        
        
        this.maintenance = new ArrayList<Maintenance>();
        
        
        this.water = new Water(200);
        
        
        
    }

    public List<Energy> getEnergy() {
        return energy;
    }

    public void setEnergy(List<Energy> energy) {
        this.energy = energy;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public List<Food> getFoodManager() {
        return foodManager;
    }

    public void setFoodManager(List<Food> foodManager) {
        this.foodManager = foodManager;
    }

    public Heatlh getHeatlh() {
        return heatlh;
    }

    public void setHeatlh(Heatlh heatlh) {
        this.heatlh = heatlh;
    }

    public List<Maintenance> getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(List<Maintenance> maintenance) {
        this.maintenance = maintenance;
    }

    public Water getWater() {
        return water;
    }

    public void setWater(Water water) {
        this.water = water;
    }
    
    
}
