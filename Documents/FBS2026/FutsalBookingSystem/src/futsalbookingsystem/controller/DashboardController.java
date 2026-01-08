/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package futsalbookingsystem.controller;
import futsalbookingsystem.view.DashboardView;
import futsalbookingsystem.view.MyBookingView;
import futsalbookingsystem.view.ViewScheduleView;
import futsalbookingsystem.view.RegistrationView;
import javax.swing.JOptionPane;

/**
 *
 * @author aakirti
 */
public class DashboardController {
    private DashboardView view;
    
    private String currentUsername;

    public DashboardController(DashboardView view,String username) {
        this.view = view;
        this.currentUsername=username;

        // Listen for button clicks on the Dashboard
        this.view.getBtnSchedule().addActionListener(e -> {
            new ViewScheduleView("").setVisible(true);
            view.dispose();
        });

        // Logic for "My Booking" Button
        this.view.getBtnBooking().addActionListener(e -> {
            new MyBookingView("","","").setVisible(true);
            view.dispose();
        });

        // Logic for "Logout" Button
        this.view.getBtnLogout().addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(view, "Are you sure you want to logout?");
            if (confirm == JOptionPane.YES_OPTION) {
                new RegistrationView().setVisible(true);
                view.dispose();
            }
        });
    }

    private void openBooking() {
        new MyBookingView("","","").setVisible(true);
        view.dispose();
    }

    private void openSchedule() {
        new ViewScheduleView("").setVisible(true);
        view.dispose();
    }

    private void logout() {
        new RegistrationView().setVisible(true);
        view.dispose();
    }
    
}
