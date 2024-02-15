/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodjassignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Lim Ee Chian
 */
public class AuthenticationClass {
    private static UserSessionClass currentUserSession;
        
    public static boolean userAuthentication(String userID, String userPassword, String userRole) throws IOException {
        // Perform authentication logic here and return true if authenticated, if authentication fails, return false
        try (FileReader fr = new FileReader("UsersTable.txt");
            BufferedReader br = new BufferedReader(fr)) {
            
            String line;
            boolean userFound = false;
            
            while ((line = br.readLine()) != null) {
                // Split the line into columns
                String[] col = line.split(";");
                String userIDFromFile = col[0].trim();
                String userPWFromFile = col[1].trim();
                String userRoleFromFile = col[2].trim();
                
                // Check if the input credentials match with any user in the file
                if (userID.equals(userIDFromFile) && userPassword.equals(userPWFromFile) && userRole.equals(userRoleFromFile)) {
                    userFound = true;
                
                    // Retrieve user role and create a new UserSession instance
                    currentUserSession = new UserSessionClass(userID, userRole);
                    return true;
                    //break;
                }
            }
            return userFound;
            
            
    
        } catch (IOException e) {
            System.out.println("IOException occured during login: " + e.getMessage());
        } 
        
        return false;
    
    }
    
    public static UserSessionClass getCurrentUserSession() {
        return currentUserSession;
    }
    
}
