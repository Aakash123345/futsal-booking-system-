/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package futsalbookingsystem.dao;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import futsalbookingsystem.database.DbConnection;

/**
 *
 * @author aakirti
 */
public class BookingDao {
    
    public DefaultTableModel getScheduleData() {
    
    
//    public DefaultTableModel getScheduleData() {
       Vector<String> columnNames = new Vector<>();
        columnNames.add("Time Slot");
       columnNames.add("Court 1 Status");
        columnNames.add("Court 2 Status");

       Vector<Vector<Object>> data = new Vector<>();

        // USE THE DB CONNECTION CLASS INSTEAD OF HARDCODING
        try (Connection conn = DbConnection.getConnection()) {
            String sql = "SELECT time_slot, court1_user, court2_user FROM schedules";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getString("time_slot"));
                
                String c1 = rs.getString("court1_user");
                row.add((c1 == null || c1.trim().isEmpty()) ? "Available" : "Booked (" + c1 + ")");
                
                String c2 = rs.getString("court2_user");
                row.add((c2 == null || c2.trim().isEmpty()) ? "Available" : "Booked (" + c2 + ")");
                
                data.add(row);
            }
        } catch (Exception e) {
            System.out.println("DATABASE ERROR IN BOOKINGDAO: " + e.getMessage());
            // Return empty table with headers so the UI doesn't crash
            return new DefaultTableModel(new String[]{"Time Slot", "Court 1 Status", "Court 2 Status"}, 0);
        }
       return new DefaultTableModel(data, columnNames);
    }
    
}
   