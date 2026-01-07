/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package futsalbookingsystem.dao;

import futsalbookingsystem.database.DbConnection;
import futsalbookingsystem.model.UserData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author aakirti
 */
public class UserDao {
    public boolean registerUser(UserData user) {
        String query = "INSERT INTO users (fname, email, phonenumber, fpassword) VALUES (?, ?, ?, ?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmnt = conn.prepareStatement(query)) {
            
            stmnt.setString(1, user.getFname());
            stmnt.setString(2, user.getEmail());
            stmnt.setString(3, user.getPhonenumber());
            stmnt.setString(4, user.getPassword());
            
            int result = stmnt.executeUpdate();
            return result > 0; // Returns true if saving was successful
        } catch (Exception e) {
            System.out.println("CRITICAL DB ERROR: " + e.getMessage()); 
            e.printStackTrace();
            return false;
        }
    }

    // Method to verify user credentials (Login)
    public boolean checkLogin(String name, String password) {
        // Based on your UI, checking by Name and Password
        String query = "SELECT * FROM users WHERE fname = ? AND fpassword = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmnt = conn.prepareStatement(query)) {
            
            stmnt.setString(1, name);
            stmnt.setString(2, password);
            
            ResultSet rs = stmnt.executeQuery();
            return rs.next(); // Returns true if a matching user is found
        } catch (Exception e) {
            System.out.println("DATABASE ERROR: " + e.getMessage()); 
            e.printStackTrace();
            return false;
//            e.printStackTrace();
//            return false;

        }
    }
    
}
