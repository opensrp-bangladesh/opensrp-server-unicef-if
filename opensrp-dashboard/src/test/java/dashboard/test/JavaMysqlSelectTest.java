package dashboard.test;

import java.sql.*;

/**
 * A Java MySQL SELECT statement example.
 * Demonstrates the use of a SQL SELECT statement against a
 * MySQL database, called from a Java program.
 * 
 * Created by Alvin Alexander, http://devdaily.com
 */
public class JavaMysqlSelectTest
{

  public static void main(String[] args)
  {
    try
    {
      // create our mysql database connection
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/mjivitacr_live";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "root");
      
      // our SQL SELECT query. 
      // if you only need a few columns, specify them by name instead of using "*"
      String query = "SELECT * FROM User";

      // create the java statement
      Statement st = conn.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
      
      // iterate through the java resultset
      while (rs.next())
      {
        int id = rs.getInt("id");
        String firstName = rs.getString("displayName");
        
        // print the results
        System.out.format("%s, %s \n", id, firstName);
      }
      st.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
  }
}
