/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package futsalbookingsystem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aakirti
 */
public class DbConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/futsal_db";
            String user = "root";
            String password = "Aakirti@123456789";
            // Change 'root' and '' to your MySQL username and password
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/futsal_db", "root", "Aakirti@123456789");
            return con;
        }catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check database name or password: " + e.getMessage());
            return null;
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    
}
