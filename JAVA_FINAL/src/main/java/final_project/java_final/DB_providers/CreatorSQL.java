
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CreatorSQL extends ConnectionRunners{

    
    private String SQL_DropCreate = "DROP TABLE IF EXISTS  java.clients cascade;\n" +
"DROP TABLE IF EXISTS  java.workers cascade;\n" +
"DROP TABLE IF EXISTS  java.all_records cascade;\n" +
"DROP TABLE IF EXISTS  java.details cascade;\n" +
"\n" +
"\n" +
"CREATE TABLE IF NOT EXISTS java.clients (\n" +
"\n" +
"  client_id  SERIAL  PRIMARY KEY ,\n" +
                "\n" +
"  client_name varchar(200),\n"+
"  client_phone integer NOT NULL,\n" +
"  car_number varchar(50)\n" +
");\n" +
"\n" +
"\n" +
"\n" +
"CREATE TABLE IF NOT EXISTS java.workers (\n" +
"\n" +
"  worker_id  SERIAL  PRIMARY KEY ,\n" +
"  worker_name varchar(50)\n" +
");\n" +
"\n" +
"\n" +
"CREATE TABLE IF NOT EXISTS java.all_records (\n" +
"\n" +
"  record_id  SERIAL  PRIMARY KEY ,\n" +
"  client_id integer,\n" +
"  status varchar(100) DEFAULT 'new' ,\n" +
"  description varchar(500),\n" +
"  \n" +
"  \n" +
"  accepter_id integer ,\n" +
"  client_decision boolean,\n" +
"  maker_id integer,\n" +
"  \n" +
"  FOREIGN KEY(client_id) REFERENCES java.clients(client_id),\n" +
"  FOREIGN KEY(maker_id) REFERENCES java.workers(worker_id),\n" +
"  FOREIGN KEY(accepter_id) REFERENCES java.workers(worker_id)\n" +
");\n" +
"\n" +
"\n" +
"CREATE TABLE IF NOT EXISTS java.details (\n" +
"\n" +
"  detail_id  SERIAL  PRIMARY KEY ,\n" +
"  detail_price float ,\n" +
"  detail_name varchar(50)\n" +
"  \n" +
")\n" +
" ";
    
    
    public CreatorSQL(){
      //this.SQL_DropCreate = scriptSQL_DropCreate;
        
    }
    
      
    @Override
     public void run(){
       
        try {
            // different realisation depends on Creator or Inserter are running
            Connection engine = DriverManager.getConnection(this.url, this.user, this.password);
            
            /*
            dont need a preparator unprepared_SQL = prepared sql
            */
            Statement stmt = engine.createStatement();
            
            String query = this.SQL_DropCreate;
            stmt.execute(query);
            engine.close();
        } catch (SQLException ex) {
            Logger.getLogger(CreatorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

            
            
        
    }



}
