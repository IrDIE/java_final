
package final_project.java_final.DB_providers;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CreatorSQL extends ConnectionRunners{

    
    private String SQL_DropCreate = "";
    
    
    public CreatorSQL(){
      //this.SQL_DropCreate = scriptSQL_DropCreate;
        
    }
    
      
    @Override
     public void run(){
       
        try {
            Connection engine = DriverManager.getConnection(this.url, this.user, this.password);
            Statement stmt = engine.createStatement();
            
            String query = this.SQL_DropCreate;
            stmt.execute(query);
            engine.close();
        } catch (SQLException ex) {
            Logger.getLogger(CreatorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

            
            
        
    }



}
