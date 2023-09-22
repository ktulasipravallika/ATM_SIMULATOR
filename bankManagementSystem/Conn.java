package bankManagementSystem;
import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

  
    public Conn(){
        
        try{
            //Class.forName(com.mysql.cj.jdbc.Driver);

            //Create Connection 
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root" , "30061996");
            //Create Statement
            s = c.createStatement();
            

        }catch(Exception e){
            System.out.println(e);

        }
    }
    
}
