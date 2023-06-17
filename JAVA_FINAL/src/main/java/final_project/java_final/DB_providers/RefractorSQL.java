package final_project.java_final.DB_providers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RefractorSQL extends ConnectionRunners {
    
    String update = "";
    
    public RefractorSQL(){}
    
    public void SetAccepter(int id_2_refractor){
        
        try {
            // set accepter id database
            String SQL_update = "UPDATE java.all_records \n" +
                        "SET accepter_id  = (SELECT worker_id FROM java.workers ORDER BY random() LIMIT 1)\n" +
                        "WHERE record_id = ";
            
            Connection engine = DriverManager.getConnection(this.url, this.user, this.password);
            Statement stmt = engine.createStatement();
            stmt.execute(SQL_update + Integer.toString(id_2_refractor));
            System.out.println("INSERTED");
            engine.close();       
        } catch (SQLException ex) {
            Logger.getLogger(RefractorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    public String addDamage2Record(int record_id){
        
        
        GetIdSQL getterN = new GetIdSQL();
        
        String DamageSql = " WITH damages_2_record AS (\n" +
                        "SELECT " +Integer.toString(record_id)  + " AS \"record_id\", \n" +
                        "* FROM  java.damages \n" +
                        "WHERE category  = (SELECT category  FROM java.damages d  ORDER BY random() LIMIT 1 )\n" +
                        "LIMIT (1+0.3*random()*(3*random() + 1))\n" +
                        ")\n" +
                        "\n" +
                        "SELECT * FROM damages_2_record\n" +
                        "LEFT JOIN  java.details  \n" +
                        "ON details.detail_id = ANY(damages_2_record.details)\n" +
                        "\n" +
                        "";
          
          String additionalDamage = "select count(*) AS counter\n" +
            "from java.damages2records where record_id = ";
          
          String additionalInputDamage = "INSERT INTO  java.damages2records \n" +
"(\n" +
"\n" +
"		WITH damages_2_record AS (\n" +
"		SELECT %s AS \"record_id\", \n" +
"		* FROM  java.damages \n" +
"		WHERE damages.sub_categoty = 'Замена кузовного элемента'\n" +
"		)\n" +
"		\n" +
"		SELECT * \n" +
"		FROM damages_2_record\n" +
"		LEFT JOIN  java.details  \n" +
"		ON details.detail_id = ANY(damages_2_record.details)\n" +
"\n" +
")";
        try {
          
            
            Connection engine = DriverManager.getConnection(this.url, this.user, this.password);
            Statement stmt = engine.createStatement();
            stmt.execute("INSERT INTO  java.damages2records ( " + DamageSql+ ")");
            
            
            
            Statement stmt_add = engine.createStatement();
            int counted = 0;
            
            ResultSet resultTableAdditional = stmt_add.executeQuery(additionalDamage + Integer.toString(record_id) + "and sub_category =  'стапельные работы'");  
            while ( resultTableAdditional.next() ) { 
                counted = resultTableAdditional.getInt(1);
                
              }
            System.out.println("counted = " + counted);
            if(counted > 0){
                
          String update = String.format(additionalInputDamage, Integer.toString(record_id));
              //  System.out.println("update = " + update);
            stmt_add.execute(  update);
            
            }
            
            
            
            engine.close();
        } catch (SQLException ex) {
            Logger.getLogger(RefractorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return DamageSql;
    
    }
    
    
    
    public void SetMaker(int id_2_refractor, String damage_category){
        
        try {
            String SQL_update = "UPDATE java.all_records \n" +
                        "SET maker_id  = " ;
            
            String condition =   "WHERE record_id = " + Integer.toString(id_2_refractor);
            String SQL_SetMaker_1 = "(select worker_id from java.workers where category2fix = 'Неисправность ДВС' order by random() limit 1 ) ";
            String SQL_SetMaker_2 = "(select worker_id from java.workers where category2fix = 'Кузовной ремонт' order by random() limit 1 ) ";
            String SQL_SetMaker_3 = " (select worker_id from java.workers where category2fix = 'Электрика автомобиля' order by random() limit 1) ";
            String SQL_SetMaker_4 = " (select worker_id from java.workers where category2fix = 'Иные проблемы' order by random() limit 1) ";
            
            Connection engine = DriverManager.getConnection(this.url, this.user, this.password);
            Statement stmt = engine.createStatement();
            
            // set maker in database
            
            switch (damage_category) {
                case "Неисправность ДВС":
                    
                    this.update = SQL_update+SQL_SetMaker_1+condition;
                    
                    break;
                case "Кузовной ремонт":
                    this.update = SQL_update+SQL_SetMaker_2+condition;
                    
                    break;
                case "Электрика автомобиля":
                    this.update = SQL_update+SQL_SetMaker_3+condition;
                    
                    break;
                default:
                    this.update =  SQL_update+SQL_SetMaker_4+condition;
                    
            }
             stmt.execute(this.update);
                    System.out.println("updated maker");
                    engine.close();
                    
                    
                   
            // rebew status of record
        } catch (SQLException ex) {
            Logger.getLogger(RefractorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    
    }
    
    
    
    public void SetStatusAfterAccepter(int id_2_refractor, String status){
    
        try {
            String SQL_update = String.format( "UPDATE java.all_records \n" +
                        "SET status  = '%s'\n" +
                        "WHERE record_id = ", status);
         
            Connection engine = DriverManager.getConnection(this.url, this.user, this.password);
            Statement stmt = engine.createStatement();
            
            stmt.execute(SQL_update  + Integer.toString(id_2_refractor));
            engine.close();
        } catch (SQLException ex) {
            Logger.getLogger(RefractorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


    public void SetStatusAfterMaker(int id_2_refractor){
    
        
        try {
            String SQL_update = "UPDATE java.all_records \n" +
                        "SET status  ='done_damages'\n" +
                        "WHERE record_id = ";
            Connection engine = DriverManager.getConnection(this.url, this.user, this.password);
            Statement stmt = engine.createStatement();
            
            stmt.execute(  SQL_update+ Integer.toString(id_2_refractor));
            engine.close();
        } catch (SQLException ex) {
            Logger.getLogger(RefractorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    public void setBillAfterWork(int id_2_refractor){
    
        
        try {
            String update = String.format( "UPDATE java.all_records \n" +
                        "SET bill  = (SELECT sum(detail_price) FROM java.damages2records dr \n" +
                        "WHERE record_id = %d ) WHERE record_id = %d",id_2_refractor, id_2_refractor );
            
            
            Connection engine = DriverManager.getConnection(this.url, this.user, this.password);
            Statement stmt = engine.createStatement();
            
            stmt.execute( update);
            engine.close();
            
  
        } catch (SQLException ex) {
            Logger.getLogger(RefractorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public void addDamageService2Record(int record_id) {
        
        try {
            String addServiceSQL = String.format("INSERT INTO  java.damages2records \n" +
                        "(\n" +
                        "		WITH damages_2_record AS (\n" +
                        "		SELECT %d AS \"record_id\", \n" +
                        "				* FROM  java.damages \n" +
                        "				WHERE category  = 'Сервисное обслуживание'\n" +
                        "				ORDER BY random()\n" +
                        "				limit 1\n" +
                        "				)\n" +
                        "				\n" +
                        "		SELECT * \n" +
                        "		FROM damages_2_record\n" +
                        "		LEFT JOIN  java.details  \n" +
                        "		ON details.detail_id = ANY(damages_2_record.details)\n" +
                        ")", record_id);
            Connection engine = DriverManager.getConnection(this.url, this.user, this.password);
            Statement stmt = engine.createStatement();
            
            stmt.execute( addServiceSQL);
            engine.close();
        } catch (SQLException ex) {
            Logger.getLogger(RefractorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    
    
    
}
