/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package java2024;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;



/**
 *
 * @author Lim Ee Chian
 */
public final class QuotationsListPage extends javax.swing.JFrame {
    private TableRowSorter<DefaultTableModel> originalSorter;
    /**
     * Creates new form QuotationListPage
     */
    public QuotationsListPage() {
        initComponents();
        
        // Set up the custom close operation
        setupCloseOperation();
        
        // Set the location of the JFrame form to be centered on the screen
        setLocationRelativeTo(null);
        customizeButtons();
        
        UserUtilityClass.displayUsername(tfUsername);
        // Make the tfUsername field uneditable and not focusable
        tfUsername.setEditable(false);
        tfUsername.setFocusable(false);
        
        load2ndQuotationsTableData();
        
        
        // Initialization code or data loading 
        DefaultTableModel model = (DefaultTableModel) tb2ndQuotationsTable.getModel();
        originalSorter = new TableRowSorter<>(model);
        tb2ndQuotationsTable.setRowSorter(originalSorter);      
    }

    private void customizeButtons() {
    
        switch (AuthenticationClass.getCurrentUserSession().getUserRole()) {
            case "OFFICER" -> {
                btnCreateNewQuotation.setVisible(false);
            }
            case "SALESPERSON" -> {
                btnCreateNewQuotation.setVisible(true);
            }
            case "ADMIN" -> {
                btnCreateNewQuotation.setVisible(false);
            }
            default -> {
            }
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
        tfUsername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfSearchQuotation = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb2ndQuotationsTable = new javax.swing.JTable();
        btnCreateNewQuotation = new javax.swing.JButton();
        btnViewEdit = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        tfUsername.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jLabel1.setText("Quotations List");

        tfSearchQuotation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfSearchQuotationKeyTyped(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tb2ndQuotationsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Quotation ID", "Date", "Validity Date", "Salesperson ID", "Customer Name", "Phone No.", "Delivery Address", "Discount", "Delivery Fee", "Total Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb2ndQuotationsTable);

        btnCreateNewQuotation.setText("Create New Quotation");
        btnCreateNewQuotation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNewQuotationActionPerformed(evt);
            }
        });

        btnViewEdit.setText("View | Edit");
        btnViewEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewEditActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(432, 432, 432)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 360, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfSearchQuotation, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch)
                                .addGap(18, 18, 18)
                                .addComponent(btnRefresh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCreateNewQuotation, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnViewEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearchQuotation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(btnRefresh)
                    .addComponent(btnCreateNewQuotation))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnViewEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateNewQuotationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNewQuotationActionPerformed
        

        // Create an instance of CreateManageQuotationPage
        CreateManageQuotationPage createManageQuotationPage = new CreateManageQuotationPage();
        
        // Set its visibility to true (to show the CreateManageQuotationPage)
        createManageQuotationPage.setVisible(true);
        
        this.dispose();
        
        // Hide the current page (QuotationsListPage)
       // this.setVisible(false);
        
        
    }//GEN-LAST:event_btnCreateNewQuotationActionPerformed

    private void tfSearchQuotationKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchQuotationKeyTyped
        // Press enter key to search
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            DefaultTableModel model = (DefaultTableModel) tb2ndQuotationsTable.getModel();
            TableRowSorter<DefaultTableModel> searchSorter = new TableRowSorter<>(model);
            tb2ndQuotationsTable.setRowSorter(searchSorter);
            
            String searchText = tfSearchQuotation.getText();
            searchSorter.setRowFilter(RowFilter.regexFilter(searchText));
            
        }
    }//GEN-LAST:event_tfSearchQuotationKeyTyped

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // Search button - 
        
        // Search button
        DefaultTableModel model = (DefaultTableModel) tb2ndQuotationsTable.getModel();
        TableRowSorter<DefaultTableModel> searchSorter = new TableRowSorter<>(model);
        tb2ndQuotationsTable.setRowSorter(searchSorter);
        searchSorter.setRowFilter(RowFilter.regexFilter(tfSearchQuotation.getText()));
     
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // Refresh button
        
        // Reload the original data from the `2ndQuotationsTable` text file
        load2ndQuotationsTableData();
        
        // Clear the search text field
        tfSearchQuotation.setText("");
        
        // Clear the date chooser
        
        
        
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnViewEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewEditActionPerformed
        // Edit button - modify Quotation's information
        
        try {
            int selectedRow = tb2ndQuotationsTable.getSelectedRow();
            if (selectedRow != -1) {
                // Get the selected Quotation ID
                String selectedQuotationID = tb2ndQuotationsTable.getValueAt(selectedRow, 0).toString();
                
                // Navigate to the CreateManageQuotationPage
                CreateManageQuotationPage createManageQuotation = new CreateManageQuotationPage();
                
                // Using setQuotationID() method to pass the selected Quotation ID to the CreateManageQuotationPage
                createManageQuotation.setQuotationID(selectedQuotationID);
                
                try {
                    createManageQuotation.loadOldQuotationData(selectedQuotationID);
                } catch (ParseException e) {
                    System.out.println("ParseException occured during edit: " + e.getMessage());
                }
                createManageQuotation.setVisible(true);
            } else {
                // Display an error message indicating that no row is selected
                JOptionPane.showMessageDialog(rootPane, "Please select a row to edit.");
            }
            
            // Dispose of QuotationsListPage
            this.dispose();
            
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException occured during edit: " + e.getMessage());
        }
    }//GEN-LAST:event_btnViewEditActionPerformed



    
    public void load2ndQuotationsTableData() {
        // Load 2ndQuotationsTable.txt
        DefaultTableModel model = (DefaultTableModel) tb2ndQuotationsTable.getModel();
        model.setRowCount(0);  // Clear existing data in the table

        try (BufferedReader br = new BufferedReader(new FileReader("2ndQuotationsTable.txt"))) {  
            String line; 
            boolean firstLine = true; // Flag to skip the first line

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; 
                }
                String[] col = line.split(";");
                if (col.length >= 10) {                    
                    String quotationID = col[0].trim();
                    String quotationDate = col[1].trim();
                    String validityDate = col[2].trim();
                    String userID = col[3].trim();
                    String customerName = col[4].trim();
                    String customerPhoneNo = col[5].trim();
                    String deliveryAddress = col[6].trim();
                    String discount = col[7].trim();
                    String deliveryFee = col[8].trim();
                    String totalAmount = col[9].trim();

                    Object[] rowData = {quotationID, quotationDate, validityDate, userID, customerName, customerPhoneNo, deliveryAddress, discount, deliveryFee, totalAmount};
                    model.addRow(rowData);  
                } else {
                   
                    System.out.println("Invalid line: " + line);
                }     
            }

                // Initialization code or data loading
                originalSorter = new TableRowSorter<>(model);
                tb2ndQuotationsTable.setRowSorter(originalSorter);
        } catch (IOException e) { 
            
            System.out.println("IOException occured during loading quotations data: " + e.getMessage());
        }
    }
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(QuotationsListPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuotationsListPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuotationsListPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuotationsListPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuotationsListPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateNewQuotation;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnViewEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb2ndQuotationsTable;
    private javax.swing.JTextField tfSearchQuotation;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}