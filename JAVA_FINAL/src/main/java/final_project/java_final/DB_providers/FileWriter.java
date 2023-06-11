/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package final_project.java_final.DB_providers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 79509
 */
public class FileWriter  extends ConnectionRunners{
    
    
    public void write2File(File selectedFile, String record_id,  String query){
        
        
        FileOutputStream fp = null;
        try {
            String SQLQuery = query+record_id;
            Connection engine = DriverManager.getConnection(this.url, this.user, this.password);
            Statement st = engine.createStatement();
            
        
                // dr., dr., , 
            
            
            
            ResultSet res = st.executeQuery(SQLQuery);
            System.out.println("Employee Name: " );
            File f=new File("output.txt");
            fp = new FileOutputStream(selectedFile);
            while (res.next()) {
                String client_name = res.getString("client_name") + ",";
                String status = res.getString("status") + ",";
                String accepter_name = res.getString("accepter_name") + ",";
                String maker_name = res.getString("maker_name") + ",";
                String category = res.getString("category") + ",";
             
                String sub_category = res.getString("sub_category") + ",";
                String detail_name = res.getString("detail_name") + ",";
                String detail_price = res.getString("detail_price") + "";
                
                
                fp.write(client_name.getBytes());
                fp.write(status.getBytes());
                fp.write(accepter_name.getBytes());
                fp.write(maker_name.getBytes());
                fp.write(category.getBytes());
                
                fp.write(sub_category.getBytes());
                fp.write(detail_name.getBytes());
                fp.write(detail_price.getBytes());
                
                
                
                String newline="\r\n";
                fp.write(newline.getBytes());
            
            }
            fp.flush();
            fp.close();
            engine.close();
            
            
            
            
            
            
            
            
            
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);    
        } catch (SQLException ex) {
            Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fp.close();
            } catch (IOException ex) {
                Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
