
package final_project.java_final.DB_providers;


public abstract class ConnectionRunners {
    
    public SQL_Preparator preparator;
    protected String url = "jdbc:postgresql://localhost:5432/postgres";
            //"jdbc:postgresql://host.docker.internal:5432/postgres"; //
    // "jdbc:postgresql://localhost:5432/postgres";

    protected  String user = "smirnov";
    protected  String password = "smirnov";
   
    
    
    public void run(){
    // different realisation depends on Creator or Inserter are running
    
    }
    
    
}
