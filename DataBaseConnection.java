package data_base_access;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
  
// This class can be used to initialize the database connection 
public class DataBaseConnection { 
    protected static Connection initializeDatabase() 
        throws SQLException, ClassNotFoundException 
    { 
        // Initialize all the information regarding 
        // Database Connection 
        String dbDriver = "com.mysql.jdbc.Driver"; 
        
        Class.forName(dbDriver); 
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wwwproducts","root","roota"); 
        return con; 
    } 
} 