package dao;

import entity.Food;
import entity.Maintenance;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;


public class DAO_maintenance {
    
    private final DataSource ds;
    
    public DAO_maintenance(DataSource ds){
        this.ds = ds;
    }
    
    public List<Maintenance> getMaintenance(Date dateStart, Date dateEnd){
        List<Maintenance> maintenance = new ArrayList<Maintenance>();
        
        String sql = "SELECT * FROM MAINTENANCE WHERE UPDATE_AT < ? AND UPDATE_AT > ? ";
        try(Connection connection = ds.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setDate(1, dateStart);
                stmt.setDate(2, dateEnd);
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()){
                    int id_equipment = rs.getInt("id_equipment");
                    String description = rs.getString("descrption");
                    maintenance.add(new Maintenance(id_equipment, description));
                }
                
        } catch (Exception ex){
            
        }
        return maintenance;
    }
    
    
    
    
}
