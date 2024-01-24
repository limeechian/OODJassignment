/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JTextField;

/**
 *
 * @author Lim Ee Chian
 */
public class UserUtilityClass {
    public static void displayUsername(JTextField tfUsername) {
        // Get the current user's session information
        UserSessionClass currentUserSession = AuthenticationClass.getCurrentUserSession();

        // Check if a user is logged in
        if (currentUserSession != null) {
            // Get the username and display it (consider passing the UI component as a parameter)
            String currentUserID = currentUserSession.getUserID();
            String currentUsername = getUsernameFromUserID(currentUserID);

            if (currentUsername != null) {
                // Display the username in the tfUsername field
                tfUsername.setText(currentUsername);
            }
        }
    }

    private static String getUsernameFromUserID(String userID) {
        try (FileReader fr = new FileReader("UsersTable.txt");
            BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] col = line.split(";");
                String userIDFromFile = col[0].trim();
                String usernameFromFile = col[3].trim();
                
                
                // Check if the input userID matches with any user in the file
                if (userID.equals(userIDFromFile)) {
                    return usernameFromFile;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException occured when get username from userID through UsersTable.txt: " + e.getMessage());
        }
        
        return null; // Return null if userID is not found
    }
}
