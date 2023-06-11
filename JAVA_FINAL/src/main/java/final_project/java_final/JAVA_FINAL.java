/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package final_project.java_final;

import final_project.java_final.DB_providers.DisplayerDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 79509
 */
public class JAVA_FINAL {

    public static void main(String[] args) {
        try {
            System.out.println("Hello World!");
            
            DisplayerDB dd = new DisplayerDB("select client_id from java.clients where client_name = 'david ' ");
            ArrayList res =  new ArrayList( dd.getData());
            // System.out.println( "res = "+ res.get(""));
        } catch (SQLException ex) {
            Logger.getLogger(JAVA_FINAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
