/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package java2024;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Lim Ee Chian
 */
public class CreateManageQuotationPage extends javax.swing.JFrame {

    public String selectedQuotationID;  // Public variable to store the selectedQuotationID
    
    // Method to set the Quotation ID
    public void setQuotationID(String selectedQuotationID) {
        this.selectedQuotationID = selectedQuotationID;
    }
    
    /**
     * Creates new form CreateManageQuotationPage
     */
    public CreateManageQuotationPage() {
        initComponents();
        
        // Set up the custom close operation
        setupCloseOperation();
        
        // Set the location of the JFrame form to be centered on the screen
        setLocationRelativeTo(null);
        
        // Set the initial visibility of the save button
        btnSave.setVisible(false);
        
        UserUtilityClass.displayUsername(tfUsername);
        // Make the tfUsername field uneditable and not focusable
        tfUsername.setEditable(false);
        tfUsername.setFocusable(false);
        
        tfQuotationID.setEditable(false);
        tfQuotationID.setFocusable(false);
        
        tfSubtotal.setEditable(false);
        tfSubtotal.setFocusable(false);
        
        tfTotalAmount.setEditable(false);
        tfTotalAmount.setFocusable(false);
        
        tfProductType.setEditable(false);
        tfProductType.setFocusable(false);
        
        tfProductName.setEditable(false);
        tfProductName.setFocusable(false);
        
        tfProductUnitPrice.setEditable(false);
        tfProductUnitPrice.setFocusable(false);
        
        taProductDescription.setEditable(false);
        taProductDescription.setFocusable(false);
        
        tfSalespersonID.setEditable(false);
        tfSalespersonID.setFocusable(false);
        
        tfPurchaseOrderNo.setEditable(false);
        tfPurchaseOrderNo.setFocusable(false);
        
        String userID = "";
        UserSessionClass currentUserSession = AuthenticationClass.getCurrentUserSession();
        // Check if the user is logged in
        if (currentUserSession != null) {
            // Get the userID and set it as the Salesperson ID
            userID = currentUserSession.getUserID();
        }
        // Set the text of tfSalespersonID
        tfSalespersonID.setText(userID);
        
        // Set up SpinnerNumberModel for snQuantity
        SpinnerModel quantityModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
        snQuantity.setModel(quantityModel);
        
        tfDiscount.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTotalAmount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTotalAmount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateTotalAmount();
            }
        }); 

        tfDeliveryFee.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTotalAmount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTotalAmount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateTotalAmount();
            }
        });
        
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
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        tfUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taProductDescription = new javax.swing.JTextArea();
        tfSearchProductID = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        tfProductType = new javax.swing.JTextField();
        tfProductName = new javax.swing.JTextField();
        tfProductUnitPrice = new javax.swing.JTextField();
        snQuantity = new javax.swing.JSpinner();
        btnRemove = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSelectProduct = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        tfSubtotal = new javax.swing.JTextField();
        tfDiscount = new javax.swing.JTextField();
        tfDeliveryFee = new javax.swing.JTextField();
        tfTotalAmount = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taDeliveryAddress = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfCustomerPhoneNo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfCustomerName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfSalespersonID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dcValidityDate = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        dcQuotationDate = new com.toedter.calendar.JDateChooser();
        tfQuotationID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        tfPurchaseOrderNo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        dcPurchaseOrderDate = new com.toedter.calendar.JDateChooser();
        btnConfirmSaleOrder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Create Manage Quotation Page");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(169, 179, 136));
        jPanel2.setPreferredSize(new java.awt.Dimension(731, 114));

        tfUsername.setEditable(false);
        tfUsername.setBackground(new java.awt.Color(254, 250, 224));

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Create & Manage Quotation");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(204, 204, 204)
                .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(254, 250, 224));

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel14.setText("Product ID");

        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel15.setText("Type");

        jLabel16.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel16.setText("Name");

        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel17.setText("Unit Price (RM)");

        jLabel18.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel18.setText("Quantity");

        jLabel19.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel19.setText("Description");

        taProductDescription.setEditable(false);
        taProductDescription.setColumns(20);
        taProductDescription.setRows(5);
        jScrollPane1.setViewportView(taProductDescription);

        btnSearch.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tfProductType.setEditable(false);

        tfProductName.setEditable(false);

        tfProductUnitPrice.setEditable(false);
        tfProductUnitPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfProductUnitPriceActionPerformed(evt);
            }
        });

        btnRemove.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        tbSelectProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Type", "Name", "Unit Price", "Quantity"
            }
        ));
        jScrollPane2.setViewportView(tbSelectProduct);

        jLabel20.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel20.setText("Discount (%)");

        jLabel21.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel21.setText("Delivery Fee (RM)");

        jLabel22.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel22.setText("Total Amount (RM)");

        jLabel23.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel23.setText("Subtotal (RM)");

        tfSubtotal.setEditable(false);

        tfTotalAmount.setEditable(false);

        btnSave.setBackground(new java.awt.Color(95, 111, 82));
        btnSave.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCreate.setBackground(new java.awt.Color(95, 111, 82));
        btnCreate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel13.setText("Select Product");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(tfSearchProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(snQuantity)
                                    .addComponent(tfProductType, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfProductName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfProductUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(btnRemove)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRefresh)
                                .addGap(33, 33, 33))))
                    .addComponent(jScrollPane2))
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190))
            .addComponent(jSeparator2)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tfDeliveryFee)
                        .addComponent(tfTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(tfSearchProductID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(btnRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(tfProductType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(tfProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(tfProductUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(snQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRemove)
                        .addComponent(btnAdd))
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(tfDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(tfSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDeliveryFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSave)
                        .addComponent(btnCreate))
                    .addComponent(jLabel22))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(254, 250, 224));

        taDeliveryAddress.setColumns(20);
        taDeliveryAddress.setRows(5);
        jScrollPane3.setViewportView(taDeliveryAddress);

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel10.setText("Delivery Address");

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel9.setText("Customer Phone No.");

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel8.setText("Customer Name");

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel7.setText("Salesperson ID");

        tfSalespersonID.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel6.setText("Validity Date of Quotation");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setText("Quotation Date");

        tfQuotationID.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel4.setText("Quotation ID");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfCustomerName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(tfCustomerPhoneNo, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(26, 26, 26))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfQuotationID, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dcQuotationDate, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(dcValidityDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfSalespersonID))))
                .addGap(21, 21, 21))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfQuotationID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dcQuotationDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dcValidityDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfSalespersonID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfCustomerPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(21, 21, 21))
        );

        jPanel4.setBackground(new java.awt.Color(169, 179, 136));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel11.setText("Purchase Order No.");

        tfPurchaseOrderNo.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel12.setText("Purchase Order Date");

        btnConfirmSaleOrder.setBackground(new java.awt.Color(95, 111, 82));
        btnConfirmSaleOrder.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnConfirmSaleOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmSaleOrder.setText("Confirm Sale Order");
        btnConfirmSaleOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmSaleOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dcPurchaseOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfPurchaseOrderNo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btnConfirmSaleOrder)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfPurchaseOrderNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(dcPurchaseOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnConfirmSaleOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // Create Quotation button - save into QuotationsTable.txt and 2ndQuotationsTable.txt  
        
        String discountText = tfDiscount.getText();
        String deliveryFeeText = tfDeliveryFee.getText();
        if (discountText.isEmpty() && deliveryFeeText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Discount and Delivery Fee are required.", "Error", JOptionPane.ERROR_MESSAGE); 
        }
        
        String quotationID = tfQuotationID.getText();
        Date quotationDate = dcQuotationDate.getDate();
        Date validityDate = dcValidityDate.getDate();
        String salespersonID = tfSalespersonID.getText();
        String customerName = tfCustomerName.getText();
        String customerPhoneNo = tfCustomerPhoneNo.getText();
        String deliveryAddress = taDeliveryAddress.getText();
        String subtotal = tfSubtotal.getText();
        String discount = tfDiscount.getText();
        String deliveryFee = tfDeliveryFee.getText();
        String totalAmount = tfTotalAmount.getText();
        
        String generatedQuotationID = "";
        
        try {
            // Check if the fields are filled
            if (quotationDate == null || validityDate == null || salespersonID.isEmpty() || customerName.isEmpty() || customerPhoneNo.isEmpty() || deliveryAddress.isEmpty() || 
                    subtotal.isEmpty() || discount.isEmpty() || deliveryFee.isEmpty() || totalAmount.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill up all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Check if the tfQuotationID text field is empty
                if (quotationID.isEmpty()) {
                    // Generate the Quotation ID for the new Quotation record
                    generatedQuotationID = generateQuotationID();
                    
                    // Set the generated Quotation ID in the tfQuotationID text field
                    tfQuotationID.setText(generatedQuotationID);
                }                 
            }

            // Format the date
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String quotationDateString = dateFormat.format(quotationDate);
            String validityDateString = dateFormat.format(validityDate);
            
        // All fields are filled, proceed with the select product
        
            // Write contents into QuotationsTable.txt file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("QuotationsTable.txt",true))) {
                DefaultTableModel model = (DefaultTableModel) tbSelectProduct.getModel();
                int rowCount = model.getRowCount();
                
                // Get value of the selected rows from the Select Product table
                for (int i = 0; i < rowCount; i++) {
                    String productID = model.getValueAt(i, 0).toString();
                    String productType = model.getValueAt(i, 1).toString();
                    String productName = model.getValueAt(i, 2).toString();
                    String productUnitPrice = model.getValueAt(i, 3).toString();
                    String quantity = model.getValueAt(i, 4).toString();
                    
                    // Quotation with product rows
                    String [] productRow = {generatedQuotationID,quotationDateString,validityDateString,salespersonID,customerName,customerPhoneNo,
                        deliveryAddress,productID,productType,productName,productUnitPrice,quantity,subtotal,discount,deliveryFee,totalAmount};
                    String rowProduct = String.join(";", productRow);
                    bw.write(rowProduct);
                    bw.newLine();
                }
                JOptionPane.showMessageDialog(rootPane, "Quotation is created successfully!");
            } catch (IOException e) {
                System.out.println("IOException occured during writing to QuotationsTable.txt: " + e.getMessage());
            }

            
            // Write contents into 2ndQuotationsTable.txt file
            try (BufferedWriter bw2 = new BufferedWriter(new FileWriter("2ndQuotationsTable.txt",true))) {
                // Quotation without product rows
                String [] dataRow = {generatedQuotationID,quotationDateString,validityDateString,salespersonID,customerName,customerPhoneNo,deliveryAddress,discount,deliveryFee,totalAmount};
                String rowData = String.join(";", dataRow);
                bw2.write(rowData);
                bw2.newLine();
                
                // Navigate to the QuotationListPage
                SwingUtilities.invokeLater(() -> {
                    QuotationsListPage quotationsList = new QuotationsListPage();
                    quotationsList.load2ndQuotationsTableData();  // Reload data in QuotationsListPage 
                    quotationsList.setVisible(true);
                    this.dispose();  // Dispose of CreateManageQuotationPage
                });
                
            } catch (IOException e) {
                System.out.println("IOException occured during writing to 2ndQuotationsTable.txt: " + e.getMessage());
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException occured during creating a new Quotation: " + e.getMessage());
        }
        
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // Save button

        String quotationID = tfQuotationID.getText();
        Date quotationDate = dcQuotationDate.getDate();
        Date validityDate = dcValidityDate.getDate();
        String salespersonID = tfSalespersonID.getText();
        String customerName = tfCustomerName.getText();
        String customerPhoneNo = tfCustomerPhoneNo.getText();
        String deliveryAddress = taDeliveryAddress.getText();
        String subtotal = tfSubtotal.getText();
        String discount = tfDiscount.getText();
        String deliveryFee = tfDeliveryFee.getText();
        String totalAmount = tfTotalAmount.getText();
        
        // Format the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String quotationDateString = dateFormat.format(quotationDate);
        String validityDateString = dateFormat.format(validityDate);
        
        DefaultTableModel model = (DefaultTableModel) tbSelectProduct.getModel();
        
        // Check if fields are filled
        if (quotationID.isEmpty() || quotationDate == null || validityDate == null || salespersonID.isEmpty() || customerName.isEmpty() || customerPhoneNo.isEmpty() || 
                deliveryAddress.isEmpty() || subtotal.isEmpty() || discount.isEmpty() || deliveryFee.isEmpty() || totalAmount.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill up all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (model.getRowCount() == 0) {
            // The JTable has no rows
            JOptionPane.showMessageDialog(this, "The table has no data.", "No Data", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        // Read the contents of the file and modify the specific line(s) based on QuotationID
        String filePath1 = "QuotationsTable.txt";
        File inputFile1 = new File(filePath1);
        List<String> lines1 = new ArrayList<>();
        //boolean removedExisting = false;
        boolean modified1 = false;
        
        try (BufferedReader br1 = new BufferedReader(new FileReader(inputFile1))) {
            String line1;
            while ((line1 = br1.readLine()) != null) {
                String[] rowInFile1 = line1.split(";");
                if (rowInFile1.length != 16) {
                    continue;
                }            
                String existingQuotationID1 = rowInFile1[0].trim();
                if (existingQuotationID1.equals(quotationID)) {
                    continue;
                }
                lines1.add(line1);
                
            }
                // Add the modified data to the lines list
                int rowCount = model.getRowCount();
                // Get value of the selected products from the tbSelectProduct table
                for (int i = 0; i < rowCount; i++) {
                    String productID = model.getValueAt(i, 0).toString();
                    String productType = model.getValueAt(i, 1).toString();
                    String productName = model.getValueAt(i, 2).toString();
                    String productUnitPrice = model.getValueAt(i, 3).toString();
                    String quantity = model.getValueAt(i, 4).toString(); 

                    String[] rowModifyData1 = {quotationID,quotationDateString,validityDateString,salespersonID,customerName,customerPhoneNo,deliveryAddress,
                        productID,productType,productName,productUnitPrice,quantity,subtotal,discount,deliveryFee,totalAmount};
                    String rowMData1 = String.join(";", rowModifyData1);
                    lines1.add(rowMData1);
                    modified1 = true;
                } 
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        // Write the modified contents back to the QuotationsTable.txt file
        if (modified1) {
            try (BufferedWriter bw1 = new BufferedWriter(new FileWriter(inputFile1))) {
                for (String line : lines1) {
                    bw1.write(line);
                    bw1.newLine();
                }
            } catch (IOException e) {
                System.out.println("IOException occured during writing to QuotationsTable.txt: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "No matching Quotation record found in QuotationsTable.txt with the given Quotation ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Read the content of the 2ndQuotationsTable.txt file and modify the specific line(s) based on Quotation ID
        String filePath2 = "2ndQuotationsTable.txt";
        File inputFile2 = new File(filePath2);
        List<String> lines2 = new ArrayList<>();
        boolean modified2 = false; // Flag to track if the data is modified
        
        try (BufferedReader br2 = new BufferedReader(new FileReader(inputFile2))) {
            String line2;
            while ((line2 = br2.readLine()) != null) {
                String[] rowInFile2 = line2.split(";");
                if (rowInFile2.length != 10) {
                    // Skip the line if it doesn't have the correct number of elements
                    continue;
                }
                
                String existingQuotationID2 = rowInFile2[0].trim();
                if (existingQuotationID2.equals(quotationID)) {
                    // Modify the data for the matching QuotationID in ArrayList
                    String[] rowModifyData2 = {quotationID,quotationDateString,validityDateString,salespersonID,customerName,customerPhoneNo,
                        deliveryAddress,discount,deliveryFee,totalAmount};
                    String rowMData2 = String.join(";", rowModifyData2);
                    lines2.add(rowMData2);
                    modified2 = true;
                } else {
                    lines2.add(line2);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        // Write the modified contents back to the 2ndQuotationsTable.txt file
        if (modified2) {
            try (BufferedWriter bw2 = new BufferedWriter(new FileWriter(inputFile2))) {
                for (String line : lines2) {
                    bw2.write(line);
                    bw2.newLine();
                }
            JOptionPane.showMessageDialog(this, "Modified Quotation is record saved successfully!");
            } catch (IOException e) {
                System.out.println("IOException occured during writing to 2ndQuotationsTable.txt: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "No matching Quotation record found in 2ndQuotationsTable.txt with the given Quotation ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
            
        // Navigate to the QuotationListPage
        SwingUtilities.invokeLater(() -> {
            QuotationsListPage quotationsList = new QuotationsListPage();
            quotationsList.load2ndQuotationsTableData();  // Reload data in QuotationsListPage 
            quotationsList.setVisible(true);
            this.dispose();  // Dispose of CreateManageQuotationPage
        });
     
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // Implement logic to remove a product from tbSelectProduct
        
        // Get the selected row index
        int selectedRowIndex = tbSelectProduct.getSelectedRow();
        
        // Check if any row is selected
        if (selectedRowIndex != -1) {
            // Remove the selected row from the table model
            DefaultTableModel model = (DefaultTableModel) tbSelectProduct.getModel();
            model.removeRow(selectedRowIndex);
            
            // Recalculate and update the subtotal
            updateSubtotal(); 
            
            // Recalculate aUpdate the Total Amount
            updateTotalAmount();
            
        } else {
            // Inform the user that no row is selected
            JOptionPane.showMessageDialog(null, "Please select a row to remove.","No Row Selected", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        
        // Search for a product and display its details
        String productID = tfSearchProductID.getText();
        
        // Read from ProductsTable.txt and display product details
        try (FileReader fr = new FileReader("ProductsTable.txt");
                BufferedReader br = new BufferedReader(fr)) {
            
            String line;
            while ((line = br.readLine()) != null) {
                String[] col = line.split(";");
                String productIDFromFile = col[0].trim();
                
                if (productID.equals(productIDFromFile)) {
                    // Product found, update text fields with respective details
                    String type = col[2].trim();
                    String name = col[1].trim();
                    String unitPrice = col[3].trim();
                    String description = col[4].trim();
                    
                    tfProductType.setText(type);
                    tfProductName.setText(name);
                    tfProductUnitPrice.setText(unitPrice);
                    taProductDescription.setText(description);
                    
                    return;  // Exit the loop once the product is found
                }
            }
            
            // Product not found
            JOptionPane.showMessageDialog(this, "Product not found.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            // Handle IO Exception
            System.out.println("IOException occured during searching Product ID: " + e.getMessage());  
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Add a product to tbSelectProduct
        
        String productID = tfSearchProductID.getText();
        String productType = tfProductType.getText();
        String productName = tfProductName.getText();
        String productUnitPrice = tfProductUnitPrice.getText();
        //String productDescription = taProductDescription.getText();
        int quantity = (int) snQuantity.getValue();
        if (quantity < 0) {
            snQuantity.setValue(0);
        }
        
        // Validate inputs
        if (productID.isEmpty() || productType.isEmpty() || productName.isEmpty() || productUnitPrice.isEmpty() || quantity == 0) {
            // Display an error message
            JOptionPane.showMessageDialog(this, "Please fill up all fields to add product.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // exit method if validation fails
        }
        
        // Create an array with the product details
        Object[] rowData = {productID,productType,productName,productUnitPrice,quantity};

        // Get the table model from tbSelectProduct
        DefaultTableModel model = (DefaultTableModel) tbSelectProduct.getModel();
        
        // Add the new row to the table
        model.addRow(rowData);
        
        // Clear the contents of specific text fields
        clearFields();
        
        // Update subtotal whenever the table changes
        updateSubtotal(); 
        
        // Update the Total Amount
        updateTotalAmount();
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // Refresh button - Clear some fields
        
        clearFields();
        
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnConfirmSaleOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmSaleOrderActionPerformed
        // Confirm sale order
        String purchaseOrderNo = tfPurchaseOrderNo.getText();
        Date purchaseOrderDate = dcPurchaseOrderDate.getDate();
    
        try {
            // Check if the PO No. and the PO date fields are filled
            if (purchaseOrderDate == null) {
                JOptionPane.showMessageDialog(this,"Please fill in the Purchase Order Date.", "Error", JOptionPane.ERROR_MESSAGE);
                //return;
            } else {
                // Check if the tfPurchaseOrderNo text field is empty
                if (purchaseOrderNo.isEmpty()) {
                    // Generate the Purchase Order No for the new Sale Order record
                    String generatedPurchaseOrderNo = generatePurchaseOrderNo();
                    
                    // Set the generated Purchase Order No in the tfPurchaseOrderNo text field
                    tfPurchaseOrderNo.setText(generatedPurchaseOrderNo);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException occured during Confirm & Create Sale Order: " + e.getMessage());
        }
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String purchaseOrderDateString = dateFormat.format(purchaseOrderDate);
        
        int choice = JOptionPane.showConfirmDialog(this, "Do you wish to confirm sale order?", "Sale Order Confirmation", JOptionPane.YES_NO_OPTION);
        
        if (choice == JOptionPane.YES_OPTION) {
            ManageSaleOrderPage manageSaleOrder = new ManageSaleOrderPage();
            String existPurchaseOrderNo = tfPurchaseOrderNo.getText();
            manageSaleOrder.setPurchaseOrderInfo(existPurchaseOrderNo, purchaseOrderDateString);
            
            String currentQuotationID = tfQuotationID.getText();
            try {
                manageSaleOrder.loadQuotationDataDisplayAtSaleOrder(currentQuotationID);
            } catch (ParseException ex) {
                System.out.println("ParseException occured during directing data to ManageSaleOrderPage: " + ex.getMessage());
            }
            manageSaleOrder.setVisible(true);
            // Close the current page
            this.dispose();
        }
      
    }//GEN-LAST:event_btnConfirmSaleOrderActionPerformed

    private void tfProductUnitPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfProductUnitPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfProductUnitPriceActionPerformed

    
    // Method to load and display the old Quotation data to each text field and table
    public void loadOldQuotationData(String selectedQuotationID) throws ParseException {
        btnSave.setVisible(true);
        btnCreate.setVisible(false);
        
        // Create the table model - Update the table with the select products information
        DefaultTableModel model = (DefaultTableModel) tbSelectProduct.getModel();
        // Clear existing rows from the table
        model.setRowCount(0);
        
        // Search in QuotationsTable.txt
        try (BufferedReader br = new BufferedReader(new FileReader("QuotationsTable.txt"))) {
            String line;
            boolean firstLine = true;
            
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; 
                }
                String[] col = line.split(";");  // limit means what  String[] col = line.split(";",-1);
                if (col.length >= 16) {
                    String quotationID = col[0].trim();
                    if (quotationID.equals(selectedQuotationID)) {
                        // Match found, extract relevant informaiton
                        // Repeated
                        String quotationDateString = col[1].trim();
                        String validityDateString = col[2].trim();
                        String userID = col[3].trim();
                        String customerName = col[4].trim();
                        String customerPhoneNo = col[5].trim();
                        String deliveryAddress = col[6].trim();
                        String subtotal = col[12].trim();
                        String discount = col[13].trim();
                        String deliveryFee = col[14].trim();
                        String totalAmount = col[15].trim();
                        
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        Date quotationDate = dateFormat.parse(quotationDateString);
                        Date validityDate = dateFormat.parse(validityDateString);
                        dcQuotationDate.setDate(quotationDate);
                        dcValidityDate.setDate(validityDate);
                        
                        // not repeated
                        String productID = col[7].trim();
                        String productType = col[8].trim();
                        String productName = col[9].trim();
                        String productUnitPrice = col[10].trim();
                        String quantity = col[11].trim();
                        
                        // Assign the extracted information to respective text fields, date choosers and table
                        tfQuotationID.setText(selectedQuotationID);
                        tfSalespersonID.setText(userID);
                        tfCustomerName.setText(customerName);
                        tfCustomerPhoneNo.setText(customerPhoneNo);
                        taDeliveryAddress.setText(deliveryAddress);
                        tfSubtotal.setText(subtotal);
                        tfDiscount.setText(discount);
                        tfDeliveryFee.setText(deliveryFee);
                        tfTotalAmount.setText(totalAmount);
                        
                        // Add a new row to the table with the selected products information
                        Object[] rowData = {productID,productType,productName,productUnitPrice,quantity};
                        model.addRow(rowData);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("IOException occured during loading old Quotation data: " + e.getMessage());
        }
        
    }
    
    
    // Method to clear the contents of specific text fields
    private void clearFields () {
        try {
            //String searchProductID = tfSearchProductID.getText();
            tfSearchProductID.setText("");
            tfProductType.setText("");
            tfProductName.setText("");
            tfProductUnitPrice.setText("");
            taProductDescription.setText("");
            snQuantity.setValue(0);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException occured during refresh: " + e.getMessage());
        }
    }
    
    private void updateTotalAmount() {
    
        
        String subtotalText = tfSubtotal.getText().trim();
        String discountText = tfDiscount.getText().trim();
        String deliveryFeeText = tfDeliveryFee.getText().trim();
        
        if (!subtotalText.isEmpty() && !discountText.isEmpty() && !deliveryFeeText.isEmpty()) {
            try {
                double subtotal = Double.parseDouble(subtotalText);
                
                // Simplified parsing using Double.parseDouble / Double.valueOf
                double discount = Double.parseDouble(discountText);
                double deliveryFee = Double.parseDouble(deliveryFeeText);
                
                double discountedAmount = subtotal - (subtotal * (discount / 100));
                double totalAmount = discountedAmount + deliveryFee;

                // Format the total amount as needed (e.g., in RM format)
                String formattedTotalAmount = String.format("%.2f", totalAmount);

                tfTotalAmount.setText(formattedTotalAmount);
            } catch (NumberFormatException ex) {
                // Handle the case where the user enters non-numeric values
                tfTotalAmount.setText("Invalid Input");  // Because of invalid input of Discount and Delivery Fee
            }
        } else {
            // If any of the required fields is empty, do not calculate the total amount
            tfTotalAmount.setText("");
        }
    }
    
    // Calculate subtotal for products in tbSelectProduct
    private void updateSubtotal() {
        DefaultTableModel model = (DefaultTableModel) tbSelectProduct.getModel();
        int rowCount = model.getRowCount();
        double subtotal = 0.00;
        for (int i = 0; i < rowCount; i++) {
            double unitPrice = Double.parseDouble(model.getValueAt(i, 3).toString());
            int quantity = Integer.parseInt(model.getValueAt(i, 4).toString());
            
            subtotal = subtotal + (unitPrice * quantity);  // subtotal += unitPrice * quantity;
        }
        
        // Format the subtotal as needed in RM format
        String formattedSubtotal = String.format("%.2f", subtotal);
        // Update the Subtotal text field with the calculated subtotal
        tfSubtotal.setText(formattedSubtotal);
        
    }
    
    // Method to generate the next Quotation ID
    private String generateQuotationID() {
        // Read the current Quotation ID number from the QuotationID.txt
        try (BufferedReader br = new BufferedReader(new FileReader("QuotationID.txt"))) {
            String currentID = br.readLine();
            int nextID = Integer.parseInt(currentID) + 1;  // Increment the current Quotation ID number
            
            // Write the updated Quotation ID number back to the QuotationID.txt file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("QuotationID.txt"))) {
            bw.write(String.valueOf(nextID));
            }
            
            // Format the Quotation ID with leading zeros (e.g., Q00001, Q00002)
            String newID = String.format("%05d", nextID);
            
            // Generate the new Quotation ID
            String quotationID = "Q" + newID;
            
            return quotationID; 
        } catch (IOException e) {
            // Handle file reading error
            System.out.println("IOException occured during generating Quotation ID: " + e.getMessage());
        }
        return null;
    }
    
    
    // Method to generate the next Purchase Order No.
    private String generatePurchaseOrderNo() {
        // Read the current PurchaseOrderNO number from the PurchaseOrderNo.txt 
        try (BufferedReader br = new BufferedReader(new FileReader("PurchaseOrderNo.txt"))) {
            String currentPoNo = br.readLine();
            int nextPoNo = Integer.parseInt(currentPoNo) + 1;  // Increment the current Purchase Order No number
            
            // Write the updated Purchase Order No number back to the PurchaseOrderNo.txt file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("PurchaseOrderNo.txt"))) {
            bw.write(String.valueOf(nextPoNo));
            }
            
            // Format the Purchase Order no with leading zeros (e.g., P00001, P00002)
            String newPoNo = String.format("%05d", nextPoNo);
            
            // Generate the new Purchase Order No
            String purchaseOrderNo = "P" + newPoNo;
            
            return purchaseOrderNo;
        } catch (IOException e) {
            // Handle file reading error
            System.out.println("IOException occured during generating Purchase Order No: " + e.getMessage());
        }
        
        return null;
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
            java.util.logging.Logger.getLogger(CreateManageQuotationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateManageQuotationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateManageQuotationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateManageQuotationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateManageQuotationPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnConfirmSaleOrder;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private com.toedter.calendar.JDateChooser dcPurchaseOrderDate;
    private com.toedter.calendar.JDateChooser dcQuotationDate;
    private com.toedter.calendar.JDateChooser dcValidityDate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSpinner snQuantity;
    private javax.swing.JTextArea taDeliveryAddress;
    private javax.swing.JTextArea taProductDescription;
    private javax.swing.JTable tbSelectProduct;
    private javax.swing.JTextField tfCustomerName;
    private javax.swing.JTextField tfCustomerPhoneNo;
    private javax.swing.JTextField tfDeliveryFee;
    private javax.swing.JTextField tfDiscount;
    private javax.swing.JTextField tfProductName;
    private javax.swing.JTextField tfProductType;
    private javax.swing.JTextField tfProductUnitPrice;
    private javax.swing.JTextField tfPurchaseOrderNo;
    private javax.swing.JTextField tfQuotationID;
    private javax.swing.JTextField tfSalespersonID;
    private javax.swing.JTextField tfSearchProductID;
    private javax.swing.JTextField tfSubtotal;
    private javax.swing.JTextField tfTotalAmount;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables


}
