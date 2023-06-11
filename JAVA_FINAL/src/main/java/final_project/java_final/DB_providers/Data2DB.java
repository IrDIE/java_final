
package final_project.java_final.DB_providers;

import java.util.ArrayList;

/*


умеет, используя своих двух рабочих -creator'а и inserter'а 
СОЗДАВАТЬ ТАБЛИЧКИ В БД, 
ДАЛЕЕ ПРОИСХОДИТ ИХ ЗАПОЛНЕНИЕ 

*/

public class Data2DB {

    private InserterSQL inserter;
    private CreatorSQL creator;
    private  String mode = "auto";
    
    
    public  Data2DB(String mode) {
        this.mode = mode;

    }

    public void StartCreate(){
        this.creator = new CreatorSQL(); 
        this.creator.run();
    
    }
    

    public void StartInsert(String sourse){
        
     
        InserterSQL excelInserter = new InserterSQL();
        excelInserter.run();

    }
    
        public void StartInsert(){
        InserterSQL OtherInserter = new InserterSQL();
        OtherInserter.run();

    }
    

   
    
    
}
