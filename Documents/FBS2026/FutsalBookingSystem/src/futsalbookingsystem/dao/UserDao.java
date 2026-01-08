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
import javax.swing.table.TableModel;

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

//    public TableModel getScheduleModel() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    
    public javax.swing.table.DefaultTableModel getScheduleModel() {
        java.util.Vector<String> columnNames = new java.util.Vector<>();
        columnNames.add("Time Slot");
        columnNames.add("Court 1 Status");
        columnNames.add("Court 2 Status");

        java.util.Vector<java.util.Vector<Object>> data = new java.util.Vector<>();

        try (Connection conn = DbConnection.getConnection()) {
            String sql = "SELECT time_slot, court1_user, court2_user FROM schedules";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                java.util.Vector<Object> row = new java.util.Vector<>();
                row.add(rs.getString("time_slot"));
                
                String c1 = rs.getString("court1_user");
                row.add((c1 == null || c1.trim().isEmpty()) ? "Available" : "Booked (" + c1 + ")");
                
                String c2 = rs.getString("court2_user");
                row.add((c2 == null || c2.trim().isEmpty()) ? "Available" : "Booked (" + c2 + ")");
                
                data.add(row);
            }
        } catch (Exception e) {
            System.out.println("Schedule Fetch Error: " + e.getMessage());
            return new javax.swing.table.DefaultTableModel(new String[]{"Time Slot", "Court 1 Status", "Court 2 Status"}, 0);
        }
        return new javax.swing.table.DefaultTableModel(data, columnNames);
    }
    
}
