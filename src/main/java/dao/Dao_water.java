package dao;

import entity.Energy;
import entity.Water;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;


public class Dao_water {
    
    private final DataSource ds;

    public Dao_water(DataSource ds) {
        this.ds = ds;
    }
    
    public List<Water> getWaterHistory(Date dateStart, Date dateEnd){
        List<Water> WaterHist = new ArrayList<Water>();
        
        String sql = "SELECT * FROM WATER WHERE UPDATE_AT < ? AND UPDATE_AT > ? ";
        try(Connection connection = ds.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setDate(1, dateStart);
                stmt.setDate(2, dateEnd);
                ResultSet rs = stmt.executeQuery();
               
                while(rs.next()){
                    float quantity = rs.getFloat("quantity");
                    WaterHist.add(new Water(quantity));
                }
            
        } catch (Exception ex){
            
        }
        
        
        
        
        return WaterHist;
    }
    
    
}
