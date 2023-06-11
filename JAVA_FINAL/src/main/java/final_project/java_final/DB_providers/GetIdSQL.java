
package final_project.java_final.DB_providers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GetIdSQL extends ConnectionRunners{
 
    String select_what;
    String select_from;
    String where;
    String condition;
    Integer out_id = 0;
    public GetIdSQL(){

        
        
    
    }
    
    
    
    public int getID(String select_what, String select_from, String where,String condition ){
        try {
            
            Connection engine = DriverManager.getConnection(this.url, this.user, this.password);
            
            PreparedStatement stmt = engine.prepareStatement("select " +select_what + " from java." +select_from + " where " + where + " ='" +condition + "';");
            ResultSet res = stmt.executeQuery();
              while ( res.next() ) { this.out_id = res.getInt(1);
                
              }
           
            engine.close();
           
        } catch (SQLException ex) {
            Logger.getLogger(GetIdSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
      return this.out_id;
    
    }
    
   
    
    
    
}
