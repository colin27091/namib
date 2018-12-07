package dao;

import entity.Heatlh;
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


public class DAO_heatlh {
    
    private final DataSource ds;
    
    public DAO_heatlh(DataSource ds){
        this.ds = ds;
    }
    
    public List<Heatlh> getHeatlhHistory(Date dateStart, Date dateEnd){
        List<Heatlh> heatlhHistory = new ArrayList<Heatlh>();
        
        String sql = "SELECT * FROM HISTORY_HEATLH WHERE UPDATE_AT < ? AND UPDATE_AT > ? ";
        try(Connection connection = ds.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setDate(1, dateStart);
                stmt.setDate(2, dateEnd);
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()){
                    float weigh = rs.getFloat("weigh");
                    heatlhHistory.add(new Heatlh(weigh));
                }
               
        } catch (SQLException ex) {
        }
        return heatlhHistory;
    }
    
}
