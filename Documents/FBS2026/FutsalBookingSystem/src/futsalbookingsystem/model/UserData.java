/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package futsalbookingsystem.model;

/**
 * @author aakirti
 */
public class UserData {
    
    private String fname;
    private String email;
    private String phonenumber;
    private String password;

    // Empty Constructor for flexibility
    public UserData() {}

    // Constructor to quickly create a user object
    public UserData(String fname, String email, String phonenumber, String password) {
        this.fname = fname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.password = password;
    }

    // Getters and Setters
    public String getFname() { return fname; }
    public void setFname(String fname) { this.fname = fname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhonenumber() { return phonenumber; }
    public void setPhonenumber(String phonenumber) { this.phonenumber = phonenumber; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}