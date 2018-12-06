package dao;

import entity.Energy;
import entity.Food;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;


public class DAO_food {
    
    private final DataSource ds;
    
    public DAO_food(DataSource ds){
        this.ds = ds;
    }
    
    public List<Food> getFoodHistory(Date dateStart, Date dateEnd){
        List<Food> foods = new ArrayList<Food>();
        
        String sql = "SELECT * FROM FOOD WHERE UPDATE_AT < ? AND UPDATE_AT > ? ";
        try(Connection connection = ds.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setDate(1, dateStart);
                stmt.setDate(2, dateEnd);
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()){
                    String type = rs.getString("type");
                    int cal = rs.getInt("cal");
                    int quantity = rs.getInt("quantity");
                    foods.add(new Food(type, cal, quantity));
                }
                
        } catch (Exception ex){
            
        }
        return foods;
    }
    
    public List<Food> getTypeFoodHistory(String type, Date dateStart, Date dateEnd){
        List<Food> foods = new ArrayList<Food>();
        
        String sql = "SELECT * FROM FOOD WHERE TYPE= ? AND UPDATE_AT < ? AND UPDATE_AT > ? ";
        try(Connection connection = ds.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, type);
            stmt.setDate(2, dateStart);
            stmt.setDate(3, dateEnd);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                int cal = rs.getInt("cal");
                int quantity = rs.getInt("quantity");
                foods.add(new Food(type, cal, quantity));
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO_food.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return foods;
    }
    
    
}
