package dao;

import entity.Equipment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;


public class DAO_equipment {
    
    private final DataSource ds;
    
    public DAO_equipment(DataSource ds){
        this.ds = ds;
    }
    
    public List<Equipment> getEquipmentList(){
        List<Equipment> equipments = new ArrayList<Equipment>();
        
        String sql = "SELECT * FROM EQUIPMENT";
        
        try(Connection connection = ds.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)){
                ResultSet rs = stmt.executeQuery();
                
                
                while(rs.next()){
                    String name = rs.getString("name");
                    boolean available= rs.getBoolean("available");
                    equipments.add(new Equipment(name, available));
                }
                
        } catch (Exception ex){
            
        }
        return equipments;
    }
    
    public Equipment getEquipment(String name){
        Equipment equipment = null; 
        
        String sql ="SELECT * FROM EQUIPMENT WHERE NAME=?";
        
        try(Connection connection = ds.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
       
            while(rs.next()){
                boolean available = rs.getBoolean("available");
                equipment = new Equipment(name, available);
            }
            
        } catch (Exception ex){
            
        }
        return equipment;
    }
    
}
