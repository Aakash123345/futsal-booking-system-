/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package futsalbookingsystem.database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author aakirti
 */
public class DbConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Change 'root' and '' to your MySQL username and password
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_db", "root", "");
            return con;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    
}
