package dao;

import entity.Energy;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;


public class DAO_energy {
    
    private final DataSource ds;

    public DAO_energy(DataSource ds) {
        this.ds = ds;
    }
    
    public List<Energy> getEnergyHistory(Date dateStart, Date dateEnd){
        List<Energy> energies = new ArrayList<Energy>();
        
        String sql = "SELECT * FROM ENERGY WHERE UPDATE_AT < ? AND UPDATE_AT > ? ";
        try(Connection connection = ds.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setDate(1, dateStart);
                stmt.setDate(2, dateEnd);
                ResultSet rs = stmt.executeQuery();
               
                while(rs.next()){
                    int valeur = rs.getInt("valeur");
                    String name = rs.getString("name");
                    energies.add(new Energy(valeur, name));
                }
            
        } catch (Exception ex){
            
        }
        
        
        
        
        return energies;
    }
    
    
}
