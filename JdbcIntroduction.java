import java.sql.*;
    
public class JdbcIntroduction{
    public static void main (String args[])
        throws SQLException, ClassNotFoundException
    {
        String driverClass = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/wild_db_quest";
        String username = "root";
        String password = "here4mysql";
        
    // load the driver to work with the database 
    Class.forName(driverClass);

    // Connect with the database
    Connection connection = DriverManager.getConnection(url, username, password);

    // Create a Statement object
    Statement statement = connection.createStatement();  
    // Execute an update for inserting new records
    String sql = "insert into persons" + "firstname, lastname, age" + "values ('David', 'Pfeiffer', '24')";
    statement.executeUpdate(sql);
    
    //  update the lastname of one record in the persons table
    String sql1= "UPDATE persons SET lastname='Jones' + WHERE firstname = 'Sarah'";
    statement.executeUpdate(sql1);

    //deletes at least two records in the persons table
    String sql2 = "DELETE FROM persons + WHERE lastname='Smith' + WHERE lastname='Jones'";
    statement.executeUpdate(sql2);

    // attempt to write some bad sql injection statements


    /* Using prepared statements
    // Create a preparedStatement object 
    Statement preparedStatement = connection.createStatement();
    preparedStatement = connection.prepareStatement("INSERT INTO persons + (firstname, lastname, age) VALUES (?, ?, ?)");
    preparedStatement.setString(1, "David");
    preparedStatement.setString(2, "Pfeiffer");
    preparedStatement.setInt(3, 24);

    preparedStatement.executeUpdate();

    */
    // ResultSet - rows from persons
    ResultSet resultSet = statement.executeQuery("select rows(*) from persons");
    ResultSet resultSet1 = statement.exeucteQuery( "insert into persons" + "firstname, lastname, age" + "values ('David', 'Pfeiffer', '24')";)
    
    // Process the ResultSet
    while(resultSet.next()) {
        System.out.println(resultSet.getString(1)); // Firstname
        System.out.println(resultSet.getString(2)); // Lastname
        System.out.println(resultSet.getInteger(3)); // Age
    }
    // CleanUp 
    resultSet.close();
    statement.close();
    preparedStatement.close();
    connection.close();

    }
}