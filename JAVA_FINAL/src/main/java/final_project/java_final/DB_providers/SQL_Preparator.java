/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package final_project.java_final.DB_providers;


import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;
import javax.swing.JTable;


/**
 *
 * @author 79509
 */
public class SQL_Preparator {


    public PreparedStatement query_prepared = null;
    String type_connect = ""; // insert or refractor
    JTable sourse;
    String targetTable;
    public SQL_Preparator(String type_connect, String targetTable, JTable sourse){
        this.targetTable = targetTable;
        this.type_connect = type_connect;
        this.sourse= sourse;

    }


    
    public PreparedStatement getPreparedSQL_insert(String unprepared_SQL, Connection engine) throws IOException, SQLException{
        
        String client_name=this.sourse.getValueAt(0, 0).toString();
      
        Integer client_phone= (Integer) this.sourse.getValueAt(0, 1);
        String clients_car=this.sourse.getValueAt(0, 2).toString();
        System.out.println("clients_car = "+ clients_car);
        String record_description=(String) this.sourse.getValueAt(0, 3);
        
    
        
      
        PreparedStatement query_prepared = engine.prepareStatement(unprepared_SQL);
        
        
        
        switch (this.targetTable) {
            case "clients":
                query_prepared.setString(1,client_name ); // 
                query_prepared.setInt(2,client_phone ); // 
                query_prepared.setString(3,clients_car ); //
                query_prepared.addBatch(); 
              break;
                
            case "records":
                
                int client_id_getter = new GetIdSQL().getID("client_id","clients", "client_name", client_name );
       
              query_prepared.setInt(1,  client_id_getter); 
                query_prepared.setString(2, "new"); //status
                query_prepared.setString(3, record_description); //description
     
                query_prepared.setNull(4, Types.NULL); //accepter_id
       
                query_prepared.setBoolean(5,false ); //
                query_prepared.setNull(6,Types.NULL  ); // 
                query_prepared.setNull(7,Types.NULL  ); // 
                query_prepared.setFloat(8,0 ); // 
                query_prepared.addBatch(); 
                
                break;



            default:
                throw new AssertionError();
        }
        
 
     this.query_prepared = query_prepared;
        System.out.println(query_prepared);
    return this.query_prepared;
        
    }
    
    
    
    

    
    
}
