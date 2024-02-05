/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package java2024;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Loo Hui En
 */
public class ManageUserPage extends javax.swing.JFrame {

    /**
     * Creates new form ManageUserPage
     */
    public ManageUserPage() {
        initComponents();
        // Define User Role options for the cbUserRole JComboBox
        String[] userRoleOptions = {"", "ADMIN", "OFFICER", "SALESPERSON"};
        cbRole.setModel(new DefaultComboBoxModel<>(userRoleOptions));
        loadDataToTable();
        // Make the tfUserID field uneditable and not focusable
        tfUserID.setEditable(false);
        tfUserID.setFocusable(false);

        UserUtilityClass.displayUsername(tfUserName);

        // Set up the custom close operation
        setupCloseOperation();
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
        jPanel2 = new javax.swing.JPanel();
        tfUserName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfUserID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfPassword = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbRole = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfICNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfPhoneNumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        tfClearTextFields = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        UsersTable = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(169, 179, 136));

        tfUserName.setBackground(new java.awt.Color(254, 250, 224));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Create & Manage User");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(266, 266, 266)
                .addComponent(tfUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tfUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(254, 250, 224));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setText("User ID");

        tfUserID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUserIDActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setText("Password");

        tfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPasswordActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel4.setText("Role");

        cbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setText("Name");

        tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel6.setText("I/C Number");

        tfICNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfICNumberActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel7.setText("Phone Number");

        tfPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPhoneNumberActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel8.setText("Email");

        tfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmailActionPerformed(evt);
            }
        });

        tfClearTextFields.setBackground(new java.awt.Color(95, 111, 82));
        tfClearTextFields.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        tfClearTextFields.setForeground(new java.awt.Color(255, 255, 255));
        tfClearTextFields.setText("Clear");
        tfClearTextFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfClearTextFieldsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(tfUserID)
                    .addComponent(tfPassword)
                    .addComponent(cbRole, 0, 204, Short.MAX_VALUE)
                    .addComponent(tfName)
                    .addComponent(tfICNumber)
                    .addComponent(tfPhoneNumber)
                    .addComponent(tfEmail))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(tfClearTextFields, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfICNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfClearTextFields)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(254, 250, 224));

        UsersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "User Password", "User Role", "User Name", "User IC Number", "User Phone Number", "User Email"
            }
        ));
        UsersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UsersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(UsersTable);

        btnAdd.setBackground(new java.awt.Color(95, 111, 82));
        btnAdd.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(95, 111, 82));
        btnDelete.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(95, 111, 82));
        btnEdit.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(95, 111, 82));
        btnSave.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnSave)
                    .addComponent(btnDelete)
                    .addComponent(btnEdit))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Delete selected row
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DefaultTableModel model = (DefaultTableModel) UsersTable.getModel();
        // Get selected row index
        try {
            int selectedRowIndex = UsersTable.getSelectedRow();
            model.removeRow(selectedRowIndex);
           
            // Save the changes to file
            saveDataToFile();
            
            // Clear the text fields and combo box after deleting a row
            clearTextFields();
        } catch (Exception ex) {
            // Display a JOptionPane with an error message
            JOptionPane.showMessageDialog(this, "Please select a row to delete.",
                    "No selected row", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    // Edit text from a selected row
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            // Get the selected row index
            int selectedRowIndex = UsersTable.getSelectedRow();

            if (selectedRowIndex >= 0) {
                // Check if all fields are filled
                if (validateFields()) {
                    DefaultTableModel model = (DefaultTableModel) UsersTable.getModel();
                    model.setValueAt(tfUserID.getText(), selectedRowIndex, 0);
                    model.setValueAt(tfPassword.getText(), selectedRowIndex, 1);
                    model.setValueAt(cbRole.getSelectedItem(), selectedRowIndex, 2);
                    model.setValueAt(tfName.getText(), selectedRowIndex, 3);
                    model.setValueAt(tfICNumber.getText(), selectedRowIndex, 4);
                    model.setValueAt(tfPhoneNumber.getText(), selectedRowIndex, 5);
                    model.setValueAt(tfEmail.getText(), selectedRowIndex, 6);

                    // Clear the text fields and combo box after editing
                    clearTextFields();

                } else {
                    // Display a JOptionPane with an error message for incomplete data
                    JOptionPane.showMessageDialog(this, "Please fill in all fields before editing.",
                            "Incomplete Data", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Display a JOptionPane with an error message for no selected row
                JOptionPane.showMessageDialog(this, "Please select a row to edit.",
                        "No selected row", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle the ArrayIndexOutOfBoundsException (no selected row)
            JOptionPane.showMessageDialog(this, "Please select a row to edit.",
                    "No selected row", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Handle any other exceptions
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    // Save to text file (UsersTable.txt)
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
           saveDataToFile();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tfUserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUserIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUserIDActionPerformed

    private void tfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPasswordActionPerformed

    private void tfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNameActionPerformed

    private void tfICNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfICNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfICNumberActionPerformed

    private void tfPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPhoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPhoneNumberActionPerformed

    private void tfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmailActionPerformed

    // Display text of the selected row in the text fields
    private void UsersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsersTableMouseClicked

        DefaultTableModel model = (DefaultTableModel) UsersTable.getModel();
        int selectedRowIndex = UsersTable.getSelectedRow();
        tfUserID.setText(model.getValueAt(selectedRowIndex, 0).toString());
        tfPassword.setText(model.getValueAt(selectedRowIndex, 1).toString());
        // Set the selected item for the combo box
        String role = model.getValueAt(selectedRowIndex, 2).toString();
        cbRole.setSelectedItem(role);
        tfName.setText(model.getValueAt(selectedRowIndex, 3).toString());
        tfICNumber.setText(model.getValueAt(selectedRowIndex, 4).toString());
        tfPhoneNumber.setText(model.getValueAt(selectedRowIndex, 5).toString());
        tfEmail.setText(model.getValueAt(selectedRowIndex, 6).toString());

    }//GEN-LAST:event_UsersTableMouseClicked

    // Add text from text fields to a new row
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            // Validate that all fields are filled before adding a new row
            // if TRUE, the row will be added
            if (validateFields()) {
                DefaultTableModel model = (DefaultTableModel) UsersTable.getModel();

                // Generate the next UserID
                String newUserID = generateUserID();

                // Populate the password field
                String newUserPW = generateUserPW();

                model.addRow(new Object[]{
                    newUserID,
                    newUserPW,
                    cbRole.getSelectedItem(),
                    tfName.getText(),
                    tfICNumber.getText(),
                    tfPhoneNumber.getText(),
                    tfEmail.getText()
                });
                
                // Save the changes to file
                saveDataToFile();

                // Clear the text fields and combo box after adding a new row
                clearTextFields();

            } else {
                // Display a JOptionPane with an error message for incomplete data
                JOptionPane.showMessageDialog(this, "Please fill in all fields before adding a new user.",
                        "Incomplete Data", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            // Handle any other exceptions
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tfClearTextFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfClearTextFieldsActionPerformed
        clearTextFields();
    }//GEN-LAST:event_tfClearTextFieldsActionPerformed

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
            java.util.logging.Logger.getLogger(ManageUserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageUserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageUserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageUserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageUserPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable UsersTable;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton tfClearTextFields;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfICNumber;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPassword;
    private javax.swing.JTextField tfPhoneNumber;
    private javax.swing.JTextField tfUserID;
    private javax.swing.JTextField tfUserName;
    // End of variables declaration//GEN-END:variables

    // Method to load data to the JTable
    private void loadDataToTable() {
        // Define the column names
        String[] columnNames = {"UserID", "UserPW", "UserRole", "UserName", "UserICNo", "UserPhoneNo", "UserEmail"};

        // Create a DefaultTableModel with the specified column names
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Read data from the text file, skipping the first line
        try (FileReader fr = new FileReader("UsersTable.txt"); BufferedReader br = new BufferedReader(fr)) {

            // Skip the first line
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into columns using the semicolon as the delimiter
                String[] col = line.split(";");

                // Add a new row to the model
                model.addRow(col);
            }

        } catch (IOException e) {
            System.out.println("IOException occurred when reading data from UserData.txt: " + e.getMessage());
        }

        // Set the model to the JTable
        UsersTable.setModel(model);
    }

    private void clearTextFields() {
        tfUserID.setText("");
        tfPassword.setText("");
        cbRole.setSelectedIndex(0); // Reset the combo box selection
        tfName.setText("");
        tfICNumber.setText("");
        tfPhoneNumber.setText("");
        tfEmail.setText("");
    }

    // Validate all fields
    // Checks if all the required fields have been filled before adding a new row
    private boolean validateFields() {
        return !tfEmail.getText().isEmpty()
                && !tfPhoneNumber.getText().isEmpty()
                && !tfICNumber.getText().isEmpty()
                && !tfName.getText().isEmpty()
                && cbRole.getSelectedIndex() > 0;
    }

    // Generate the next UserID based on the latest UserID in the file
    private String generateUserID() {
        // Read the latest UserID from the file
        String latestUserID = readLatestUserID();

        // Extract the numeric part of the UserID and increment it
        int numericPart = Integer.parseInt(latestUserID.substring(1));
        numericPart++;

        // Format the new UserID
        String newUserID = String.format("Y%05d", numericPart);

        // Write the updated latest UserID to the text file
        writeLatestUserID(newUserID);

        return newUserID;
    }

    // Read the latest UserID from the file
    private String readLatestUserID() {
        String latestUserID = "Y00000"; // Default if file is empty or not found

        try (BufferedReader br = new BufferedReader(new FileReader("UserID.txt"))) {
            String line;
            if ((line = br.readLine()) != null) {
                latestUserID = line.trim();
            }
        } catch (IOException | NumberFormatException e) {
            // Handle exceptions (IOException when reading, NumberFormatException when parsing UserID)
            System.out.println("Error reading latest UserID: " + e.getMessage());
        }

        return latestUserID;
    }

    // Write the latest UserID to the file
    private void writeLatestUserID(String latestUserID) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("UserID.txt"))) {
            bw.write(latestUserID);
        } catch (IOException e) {
            // Handle exception (IOException when writing)
            System.out.println("Error writing latest UserID: " + e.getMessage());
        }
    }

    // Generate the next UserID based on the latest UserPW in the file
    private String generateUserPW() {
        // Read the latest UserID from the file
        String latestUserPW = readLatestUserPW();

        // Extract the numeric part of the UserID and increment it
        int numericPart = Integer.parseInt(latestUserPW.substring(2));
        numericPart++;

        // Format the new UserID
        String newUserPW = String.format("PW%03d", numericPart);

        // Write the updated latest UserID to the text file
        writeLatestUserPW(newUserPW);

        return newUserPW;
    }

    // Read the latest UserPW from the file
    private String readLatestUserPW() {
        String latestUserPW = "PW000"; // Default if file is empty or not found

        try (BufferedReader br = new BufferedReader(new FileReader("UserPW.txt"))) {
            String line;
            if ((line = br.readLine()) != null) {
                latestUserPW = line.trim();
            }
        } catch (IOException | NumberFormatException e) {
            // Handle exceptions (IOException when reading, NumberFormatException when parsing UserID)
            System.out.println("Error reading latest UserPW: " + e.getMessage());
        }

        return latestUserPW;
    }

    // Write the latest UserPW to the file
    private void writeLatestUserPW(String latestUserPW) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("UserPW.txt"))) {
            bw.write(latestUserPW);
        } catch (IOException e) {
            // Handle exception (IOException when writing)
            System.out.println("Error writing latest UserPW: " + e.getMessage());
        }
    }

    // Override the windowClosing event
    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        // Close only this page
        this.dispose();
    }
    // Add this method to set up the custom close operation

    private void setupCloseOperation() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
    }

    private void saveDataToFile() {
        // Get the table model
        DefaultTableModel model = (DefaultTableModel) UsersTable.getModel();

        // Get the number of rows in the table
        int rowCount = model.getRowCount();

        // Create a StringBuilder to store the data
        StringBuilder data = new StringBuilder();

        // Append the column names to the data
        for (int i = 0; i < model.getColumnCount(); i++) {
            data.append(model.getColumnName(i));
            if (i < model.getColumnCount() - 1) {
                data.append(";");
            }
        }
        data.append("\n");

        // Append each row to the data
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                data.append(model.getValueAt(i, j));
                if (j < model.getColumnCount() - 1) {
                    data.append(";");
                }
            }
            data.append("\n");
        }

        // Write the data to the file
        try (java.io.FileWriter fw = new java.io.FileWriter("UsersTable.txt")) {
            fw.write(data.toString());

            // Notify the user about the successful save
            JOptionPane.showMessageDialog(this, "Changes Made.", "Save Successful", JOptionPane.INFORMATION_MESSAGE);

            // Clear the text fields and combo box after saving
            clearTextFields();
        } catch (IOException e) {
            System.out.println("IOException occurred when saving data to UsersTable.txt: " + e.getMessage());
        }
    }
}
