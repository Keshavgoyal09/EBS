
package electricity.billing.system;
import java.sql.*;


public class Conn {
    Connection c;                 // in sql package
    Statement s;
    Conn(){
//        class.forName("com.mysql.cj.jdbc.Driver"); // driver class connect with pscksge
          try{
          c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root","goyal@0909");
          s = c.createStatement();
          }
          catch (Exception e){
              e.printStackTrace();
          }
    }
}
