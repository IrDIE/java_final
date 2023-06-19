
package final_project.java_final.DB_providers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author 79509
 */
public class InserterSQL extends ConnectionRunners {

    String insert_SQL_clients = "INSERT INTO java.clients (client_name, client_phone, car_number) VALUES (?, ?, ?);";
    String insert_SQL_workers = "INSERT INTO java.workers (WORKER_NAME) VALUES ( ?);";
    String insert_SQL_records = "INSERT INTO java.all_records (client_id, status,description,accepter_id, client_decision ,maker_id, work_result, bill) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    String insert_SQL_details = "INSERT INTO java.details (detail_price, detail_name VALUES (?, ?);";
 
    String target_SQL_insert = "";
    JTable sourse;

    
    public InserterSQL(){   
    
    }

    
    
     public void run(String targetTable, JTable table )
     {
         this.sourse = table;
        try {
            switch (targetTable) {
                case "clients":
                    this.target_SQL_insert = insert_SQL_clients;
                    break;
                case "workers":
                    this.target_SQL_insert = insert_SQL_workers;
                    break;
                case "records":
                    this.target_SQL_insert = insert_SQL_records;
                    break;
                case "details":
                    this.target_SQL_insert = insert_SQL_details;
                    break;
                default:
                    throw new AssertionError();
            }
            
            
            // different realisation depends on Creator or Inserter are running
            Connection engine = DriverManager.getConnection(this.url, this.user, this.password);
            
            preparator = new SQL_Preparator(targetTable, this.sourse);
            PreparedStatement query_prepared = this.preparator.getPreparedSQL_insert(this.target_SQL_insert, engine ); /// GET PREPARED ROWS
            query_prepared.executeBatch();
            
            
            
            engine.close();
        } catch (SQLException ex) {
            Logger.getLogger(InserterSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InserterSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
         
   
    }

}
