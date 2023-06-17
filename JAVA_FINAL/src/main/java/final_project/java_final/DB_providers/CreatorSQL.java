
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
      this.SQL_DropCreate = "DROP SCHEMA IF  EXISTS java  cascade;\n" +
"\n" +
"DROP TABLE IF EXISTS  java.clients cascade;\n" +
"DROP TABLE IF EXISTS  java.damages;\n" +
"DROP TABLE IF EXISTS  java.workers;\n" +
"DROP TABLE IF EXISTS  java.all_records ;\n" +
"DROP TABLE IF EXISTS  java.details ;\n" +
"DROP TABLE IF EXISTS   java.damages2records;\n" +
"\n" +
"CREATE SCHEMA IF NOT EXISTS java;\n" +
"CREATE TABLE IF NOT EXISTS java.clients (\n" +
"\n" +
"  client_id  SERIAL  PRIMARY KEY ,\n" +
"  client_name varchar(200),\n" +
"  client_phone integer NOT NULL,\n" +
"  car_number varchar(50)\n" +
");\n" +
"\n" +
"\n" +
"\n" +
"CREATE TABLE IF NOT EXISTS java.damages (\n" +
"\n" +
"  damage1_id SERIAL PRIMARY KEY ,\n" +
"  categoty varchar(200),\n" +
"  sub_categoty varchar(200),\n" +
"  details integer[]\n" +
");\n" +
"\n" +
"\n" +
"\n" +
"CREATE TABLE IF NOT EXISTS java.workers (\n" +
"\n" +
"  worker_id  SERIAL  PRIMARY KEY ,\n" +
"  worker_name varchar(50),\n" +
"  category2fix varchar(200) \n" +
");\n" +
"\n" +
"\n" +
"CREATE TABLE IF NOT EXISTS java.all_records (\n" +
"\n" +
"  record_id  SERIAL  PRIMARY KEY ,\n" +
"  client_id integer,\n" +
"  status varchar(100) DEFAULT 'new' , --- 'new'  'diagnosis'  'done'\n" +
"  description varchar(500),\n" +
"  \n" +
"  \n" +
"  accepter_id integer ,\n" +
"  client_decision boolean,\n" +
"  maker_id integer,\n" +
"  \n" +
"  work_result varchar(1000), \n" +
"  bill float DEFAULT 0.0,\n" +
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
");\n" +
"\n" +
"CREATE TABLE IF NOT EXISTS java.damages2records (\n" +
"\n" +
"  record_id int   ,\n" +
"  damage1_id int ,\n" +
"  category varchar(200),\n" +
"  sub_category varchar(200),\n" +
"  details  integer[],\n" +
"  detail_id int,\n" +
"  detail_price float,\n" +
"  detail_name varchar(50)\n" +
"  \n" +
");\n" +
"";
        
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
