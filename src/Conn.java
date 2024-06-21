import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    Conn(){
      try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      //Class.forName("com.mysql.jdbc.Driver");
      c = DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","root", "123456789");
      s = c.createStatement();

      }
      catch(Exception e){
        e.printStackTrace();
      }
    }
}