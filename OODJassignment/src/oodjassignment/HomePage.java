/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodjassignment;

import java.net.MalformedURLException;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Loo Hui En
 */
public class HomePage extends javax.swing.JFrame {

    public HomePage() {
        initComponents();
        
        // Set the location of the JFrame form to be centered on the screen
        setLocationRelativeTo(null);
        
        customizeButtons();
        UserUtilityClass.displayUsername(tfUsername);

        // Override the windowClosing method
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                confirmLogout(windowEvent);
            }
        });
    }

    private void confirmLogout(java.awt.event.WindowEvent windowEvent) {
        int option = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            // User chose to logout
            LoginPage loginPage = new LoginPage();
            loginPage.setVisible(true);
            this.dispose(); // Close the current window
        }
    }

    private void customizeButtons() {
        String userRole = AuthenticationClass.getCurrentUserSession().getUserRole();

        btnManagePersonalProfile.setEnabled(true);
        btnViewQuotationsList.setEnabled(true);
        btnViewSaleOrdersList.setEnabled(true);
        btnViewProductList.setEnabled(true);
        btnViewPersonalSaleOrder.setEnabled(true);
        btnManageUser.setEnabled(true);

        switch (userRole) {
            case "OFFICER":
                btnViewPersonalSaleOrder.setEnabled(false);
                btnManageUser.setEnabled(false);
                break;
            case "SALESPERSON":
                btnManageUser.setEnabled(false);
                break;
            case "ADMIN":
                btnViewPersonalSaleOrder.setEnabled(false);
                btnViewQuotationsList.setEnabled(false);
                break;
            default:
                break;
        }
        // Load and set icons for each button
        setButtonIcon(btnManagePersonalProfile, "Manage_Personal_Profile.png");
        setButtonIcon(btnViewQuotationsList, "View_Quotation_List.png");
        setButtonIcon(btnViewSaleOrdersList, "View_Sale_Order_List.png");
        setButtonIcon(btnViewProductList, "View_Product_List.png");
        setButtonIcon(btnViewPersonalSaleOrder, "View_Personal_Sale_Order.png");
        setButtonIcon(btnManageUser, "Manage_User.png");
    }

    private void setButtonIcon(javax.swing.JButton button, String iconName) {
        try {
            // Use an absolute path to load the image
            java.net.URL imageURL = Paths.get("C:\\OODJassignment\\images", iconName).toUri().toURL();

            if (imageURL != null) {
                ImageIcon icon = new ImageIcon(imageURL);
                button.setIcon(resizeImageIcon(icon, 40, 40));
            } else {
                System.err.println("Error loading image: " + iconName);
            }
        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException is occured: " + e.getMessage());
        }
    }

    private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        return new ImageIcon(icon.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnManagePersonalProfile = new javax.swing.JButton();
        btnViewProductList = new javax.swing.JButton();
        btnViewQuotationsList = new javax.swing.JButton();
        btnViewPersonalSaleOrder = new javax.swing.JButton();
        btnViewSaleOrdersList = new javax.swing.JButton();
        btnManageUser = new javax.swing.JButton();
        panel2 = new java.awt.Panel();
        tfUsername = new javax.swing.JTextField();
        btnLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home Page");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnManagePersonalProfile.setBackground(new java.awt.Color(254, 250, 224));
        btnManagePersonalProfile.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnManagePersonalProfile.setText("Manage Personal Profile");
        btnManagePersonalProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagePersonalProfileActionPerformed(evt);
            }
        });

        btnViewProductList.setBackground(new java.awt.Color(254, 250, 224));
        btnViewProductList.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnViewProductList.setText("View Product List");
        btnViewProductList.setMaximumSize(new java.awt.Dimension(158, 23));
        btnViewProductList.setMinimumSize(new java.awt.Dimension(158, 23));
        btnViewProductList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewProductListActionPerformed(evt);
            }
        });

        btnViewQuotationsList.setBackground(new java.awt.Color(254, 250, 224));
        btnViewQuotationsList.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnViewQuotationsList.setText("View Quotations List");
        btnViewQuotationsList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewQuotationsListActionPerformed(evt);
            }
        });

        btnViewPersonalSaleOrder.setBackground(new java.awt.Color(254, 250, 224));
        btnViewPersonalSaleOrder.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnViewPersonalSaleOrder.setText("View Personal Sale Order");
        btnViewPersonalSaleOrder.setMaximumSize(new java.awt.Dimension(158, 23));
        btnViewPersonalSaleOrder.setMinimumSize(new java.awt.Dimension(158, 23));
        btnViewPersonalSaleOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPersonalSaleOrderActionPerformed(evt);
            }
        });

        btnViewSaleOrdersList.setBackground(new java.awt.Color(254, 250, 224));
        btnViewSaleOrdersList.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnViewSaleOrdersList.setText("View Sale Orders List");
        btnViewSaleOrdersList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewSaleOrdersListActionPerformed(evt);
            }
        });

        btnManageUser.setBackground(new java.awt.Color(254, 250, 224));
        btnManageUser.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnManageUser.setText("Manage User");
        btnManageUser.setMaximumSize(new java.awt.Dimension(158, 23));
        btnManageUser.setMinimumSize(new java.awt.Dimension(158, 23));
        btnManageUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageUserActionPerformed(evt);
            }
        });

        panel2.setBackground(new java.awt.Color(169, 179, 136));

        tfUsername.setBackground(new java.awt.Color(254, 250, 224));
        tfUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsernameActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(95, 111, 82));
        btnLogout.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Home Page\n");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnLogout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 275, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(282, 282, 282)
                .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(551, 551, 551))
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnManagePersonalProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(btnViewProductList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnViewQuotationsList, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewPersonalSaleOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnViewSaleOrdersList, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(btnManageUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewQuotationsList, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnManagePersonalProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewSaleOrdersList, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewProductList, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewPersonalSaleOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnManageUser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnManagePersonalProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagePersonalProfileActionPerformed
        String userID = "";
        UserSessionClass currentUserSession = AuthenticationClass.getCurrentUserSession();
        // Check if the user is logged in
        if (currentUserSession != null) {
            // Get the userID and set it as the Salesperson ID
            userID = currentUserSession.getUserID();
        }

        ManagePersonalProfilePage manageProfilePage = new ManagePersonalProfilePage();
        manageProfilePage.loadUserProfileData(userID);
        manageProfilePage.setVisible(true);
    }//GEN-LAST:event_btnManagePersonalProfileActionPerformed

    private void btnViewQuotationsListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewQuotationsListActionPerformed
        QuotationsListPage quotationsListPage = new QuotationsListPage();
        quotationsListPage.setVisible(true);
    }//GEN-LAST:event_btnViewQuotationsListActionPerformed

    private void btnViewSaleOrdersListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewSaleOrdersListActionPerformed
        SaleOrdersListPage saleOrdersListPage = new SaleOrdersListPage();
        saleOrdersListPage.setVisible(true);
    }//GEN-LAST:event_btnViewSaleOrdersListActionPerformed

    private void btnViewPersonalSaleOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPersonalSaleOrderActionPerformed
        ViewPersonalSaleOrderPage viewPersonalSaleOrderPage = new ViewPersonalSaleOrderPage();
        viewPersonalSaleOrderPage.setVisible(true);
    }//GEN-LAST:event_btnViewPersonalSaleOrderActionPerformed

    private void btnManageUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageUserActionPerformed
        ManageUserPage manageUserPage = new ManageUserPage();
        manageUserPage.setVisible(true);
    }//GEN-LAST:event_btnManageUserActionPerformed

    private void btnViewProductListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewProductListActionPerformed
        ViewProductListPage viewProductListPage = new ViewProductListPage();
        viewProductListPage.setVisible(true);
    }//GEN-LAST:event_btnViewProductListActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            // User chose to logout
            LoginPage loginPage = new LoginPage();
            loginPage.setVisible(true);
            this.dispose(); // Close the current window
        } else {
            // If the user chose NO, do nothing
            setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void tfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsernameActionPerformed

    }//GEN-LAST:event_tfUsernameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManagePersonalProfile;
    private javax.swing.JButton btnManageUser;
    private javax.swing.JButton btnViewPersonalSaleOrder;
    private javax.swing.JButton btnViewProductList;
    private javax.swing.JButton btnViewQuotationsList;
    private javax.swing.JButton btnViewSaleOrdersList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private java.awt.Panel panel2;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
