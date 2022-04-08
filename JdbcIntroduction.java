import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
    
public class JdbcIntroduction{
    public static void main (String args[])
        throws SQLException, ClassNotFoundException
    {
        String driverClass = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/wild_db_quest";
        String username = "root";
        String password = "here4mysql";
        
    // load the driver to work with the database 
    Class.forName(driverClass);

    // Connect with the database
    Connection connection = DriverManager.getConnection(url, username, password);

    // Create a Statement object
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery( "select * from persons");
    while(resultSet.next()) {
        System.out.println(resultSet.getString(1)); // Firstname
        System.out.println(resultSet.getString(2)); // Lastname
        System.out.println(resultSet.getInt(3)); // Age
    }
    // Execute 3 taks  
    String sql = "insert into Persons" + "(lastname,firstname,age)" + " values ('Pfeiffer', 'David', '24')";
    String sql_01 = "update persons" + " set lastname='Pfeiffer'" + " where firstname='David'";
    String sql_02 = "delete from persons" + " where lastname='Pfeiffer'";
    statement.executeUpdate(sql);
    statement.executeUpdate(sql_01);
    statement.executeUpdate(sql_02);
    // attempt to write some bad sql injection statements
    statement.executeUpdate("insert into persons" + " where firstname='");
    // CleanUp 
    resultSet.close();
    statement.close();
    connection.close();
    }
}