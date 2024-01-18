/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java2024;

/**
 *
 * @author Lim Ee Chian
 */
public class UserSessionClass {
    private String userID;
    private String userRole;
    
    public UserSessionClass(String userID, String userRole) {
        this.userID = userID;
        this.userRole = userRole;
    }
    
    public String getUserID() {
        return userID;
    }
    
    public String getUserRole() {
        return userRole;
    }
}
