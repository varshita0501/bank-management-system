import java.sql.*;
public class Conn {
//    five steps in connnection
//    doesnt require a main method as we use a object and access this class
//    They are:
//     1.Register the driver
 //   2.Create connection
 //   3. Create statement
    Connection c;
    Statement s;
    public Conn(){
        try{
            c= DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Varshi#0501");
            s=c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }



}
