package oodjassignment;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import com.itextpdf.text.Element;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Yong Jie Yee
 */

public class Approved extends javax.swing.JFrame {

    // Add a listener to the date chooser components
    private final PropertyChangeListener dateChooserListener = new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (dcStartDate.getDate() != null && dcEndDate.getDate() != null) {
                btnSearch.setEnabled(true);
            } else {
                btnSearch.setEnabled(false);
            }
        }
    };

    public Approved() {
        initComponents();

        // Set the location of the JFrame form to be centered on the screen
        setLocationRelativeTo(null);

        // Set up the custom close operation
        setupCloseOperation();

        UserUtilityClass.displayUsername(tfUsername);
        // Make the tfUsername field uneditable and not focusable
        tfUsername.setEditable(false);
        tfUsername.setFocusable(false);

        loadTableData();
        
        btnGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
            }
        });

        // Add a listener to the JCBeforeDate component
        dcStartDate.addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                // Check if both dates are selected
                if (dcStartDate.getDate() != null && dcEndDate.getDate() != null) {
                    // Check if the selected date in JCBeforeDate is after the selected date in JCAfterDate
                    if (dcStartDate.getDate().after(dcEndDate.getDate())) {
                        // Disable the date chooser and show an error message
                        dcStartDate.setDate(null);
                        JOptionPane.showMessageDialog(Approved.this, "Selected date cannot be after the end date", "Date Selection Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Add a listener to the JCAfterDate component
        dcEndDate.addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                // Check if both dates are selected
                if (dcStartDate.getDate() != null && dcEndDate.getDate() != null) {
                    // Check if the selected date in JCAfterDate is before the selected date in JCBeforeDate
                    if (dcEndDate.getDate().before(dcStartDate.getDate())) {
                        // Disable the date chooser and show an error message
                        dcEndDate.setDate(null);
                        JOptionPane.showMessageDialog(Approved.this, "Selected date cannot be before the start date", "Date Selection Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Add the listener to the date chooser components
        dcStartDate.addPropertyChangeListener("date", dateChooserListener);
        dcEndDate.addPropertyChangeListener("date", dateChooserListener);

        // Initialize the JComboBox (OrderStatus)
        cbOrderStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"None", "Approved", "Unapproved"}));
        btnSearch.setEnabled(false);

        // Add an item listener to the combobox
        cbOrderStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbOrderStatusItemStateChanged(evt);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        tfUsername = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cbOrderStatus = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        dcStartDate = new com.toedter.calendar.JDateChooser();
        dcEndDate = new com.toedter.calendar.JDateChooser();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSaleOrdersTable = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        btnGenerate = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Generate Approved Report");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(169, 179, 136));

        tfUsername.setBackground(new java.awt.Color(254, 250, 224));
        tfUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsernameActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dubai Medium", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Generate Approved Report");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(318, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(308, 308, 308))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(254, 250, 224));

        cbOrderStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Approved", "Unapproved" }));
        cbOrderStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbOrderStatusItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel4.setText("Filter by PO Date: ");

        dcStartDate.setDateFormatString("dd-MM-yyyy");

        dcEndDate.setDateFormatString("dd-MM-yyyy");

        btnSearch.setBackground(new java.awt.Color(95, 111, 82));
        btnSearch.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tbSaleOrdersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbSaleOrdersTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(tbSaleOrdersTable);

        btnRefresh.setBackground(new java.awt.Color(95, 111, 82));
        btnRefresh.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnGenerate.setBackground(new java.awt.Color(95, 111, 82));
        btnGenerate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnGenerate.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerate.setText("Generate Approved Report");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setText("-");

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setText("Filter By Order Status: ");

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel1.setText("Start");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setText("End");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dcStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(dcEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch)))))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerate)
                .addGap(111, 111, 111))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dcStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(dcEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2)
                                .addComponent(cbOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(28, 28, 28))
                            .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(btnGenerate))
                .addGap(0, 33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Method to load data into the JTable from the text file
    private void loadTableData() {
        // Text File
        String filePath = "2ndSaleOrdersTable.txt";
        File file = new File(filePath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String firstLine = br.readLine().trim();
            String[] columnsName = firstLine.split(";");

            // Define the columns you want to display
            String[] displayColumns = {"SaleOrderNo", "PurchaseOrderNo", "PurchaseOrderDate",
                "UserID", "CustomerName", "CustomerPhoneNo",
                "TotalAmount", "OrderStatus"};

            // Create a model with specific columns
            DefaultTableModel model = new DefaultTableModel(displayColumns, 0);
            tbSaleOrdersTable.setModel(model);

            String line;
            while ((line = br.readLine()) != null) {
                String[] dataRow = line.split(";");
                // Add only specific columns to the model
                Object[] rowData = {dataRow[0], dataRow[1], dataRow[2], dataRow[3],
                    dataRow[4], dataRow[5], dataRow[6], dataRow[11]};
                model.addRow(rowData);
            }

            // Enable the ComboBox after loading data into the JTable
            cbOrderStatus.setEnabled(true);

            // Check if the table is empty and disable date chooser components accordingly
            if (model.getRowCount() == 0) {
                dcStartDate.setEnabled(false);
                dcEndDate.setEnabled(false);
            } else {
                dcStartDate.setEnabled(true);
                dcEndDate.setEnabled(true);
            }

            br.close();
        } catch (IOException ex) {
            Logger.getLogger(Approved.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Display Data to JTable using refresh button
    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // Clear the date choosers and set the selected index of the combobox to 0 (None)
        dcStartDate.setDate(null);
        dcEndDate.setDate(null);
        cbOrderStatus.setSelectedIndex(0);

        // Disable the search button since there's no filter set
        btnSearch.setEnabled(false);

        // Refresh the table data by calling the loadTableData method again
        loadTableData();
    }//GEN-LAST:event_btnRefreshActionPerformed

    //ComboBox Selection Changed
    private void cbOrderStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbOrderStatusItemStateChanged
        String query = cbOrderStatus.getSelectedItem().toString();
        filter(query);
    }//GEN-LAST:event_cbOrderStatusItemStateChanged

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed

        DefaultTableModel model = (DefaultTableModel) tbSaleOrdersTable.getModel();
        List<Object[]> rowDataList = new ArrayList<>();

        // Check if any filters are applied or if rows are selected
        if ((cbOrderStatus.getSelectedIndex() == 0 && dcStartDate.getDate() == null && dcEndDate.getDate() == null) && tbSaleOrdersTable.getSelectedRow() == -1) {
            // Display a dialog box to notify the user to filter before generating the report
            JOptionPane.showMessageDialog(this, "Please apply filters or select a row before generating the report.", "Filter Required", JOptionPane.WARNING_MESSAGE);
        } else {
            // Proceed with generating the report
            int[] selectedRows = tbSaleOrdersTable.getSelectedRows();

            if (selectedRows.length > 0) {
                // Collect data from selected rows
                for (int selectedRow : selectedRows) {
                    Object[] rowData = new Object[5]; // Array to store only the required attributes
                    rowData[0] = tbSaleOrdersTable.getValueAt(selectedRow, 3); // UserID
                    rowData[1] = tbSaleOrdersTable.getValueAt(selectedRow, 4); // CustomerName
                    rowData[2] = tbSaleOrdersTable.getValueAt(selectedRow, 1); // PurchaseOrderNo
                    rowData[3] = tbSaleOrdersTable.getValueAt(selectedRow, 2); // PurchaseOrderDate
                    rowData[4] = tbSaleOrdersTable.getValueAt(selectedRow, 6); // TotalAmount
                    rowDataList.add(rowData);
                }
            } else {
                // Collect data from all rows that meet the filter criteria
                for (int i = 0; i < model.getRowCount(); i++) {
                    // Check if the row passes the filter criteria
                    if (tbSaleOrdersTable.getRowSorter().convertRowIndexToView(i) != -1) {
                        Object[] rowData = new Object[5]; // Array to store only the required attributes
                        rowData[0] = model.getValueAt(i, 3); // UserID
                        rowData[1] = model.getValueAt(i, 4); // CustomerName
                        rowData[2] = model.getValueAt(i, 1); // PurchaseOrderNo
                        rowData[3] = model.getValueAt(i, 2); // PurchaseOrderDate
                        rowData[4] = model.getValueAt(i, 6); // TotalAmount
                        rowDataList.add(rowData);
                    }
                }
            }

            // Generate PDF directly without involving another frame
            generatePDF(rowDataList);
        }
    }

    // Method to generate PDF from row data
    private void generatePDF(List<Object[]> rowDataList) {

        JFileChooser fileChooser = new JFileChooser(); // Create a file chooser
        fileChooser.setDialogTitle("Specify a file to save"); // Set dialog title

        // Get the current date and time
        Date now = new Date();

        // Create a date format that is file name safe
        // This format will not include characters like ":" which are not allowed in file names on most operating systems
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");

        // Format the current date and time
        String dateTimeStr = dateFormat.format(now);

        // Set the default filename
        String defaultApproveReportFileName = "ApproveReport_" + dateTimeStr;
        fileChooser.setSelectedFile(new File(defaultApproveReportFileName));

        // Add a file filter for PDF files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Files", "pdf");
        fileChooser.setFileFilter(filter);

        // Show save dialog; if user approves, proceed with PDF generation
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File fileToSave = fileChooser.getSelectedFile();

            // Ensure the file has a .pdf extension
            String outputPath = fileToSave.getAbsolutePath();

            // Append .pdf extension if not present
            if (!outputPath.toLowerCase().endsWith(".pdf")) {
                outputPath += ".pdf";
            }

            try {
                // Create a document with A4 landscape dimensions
                Document document = new Document(PageSize.A4.rotate());

                // Create a PdfWriter instance
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputPath));

                // Add header and footer
                HeaderFooterPageEvent event = new HeaderFooterPageEvent();
                writer.setPageEvent(event);

                document.open();

                // Add a new line (empty paragraph)
                document.add(new Paragraph("\n"));

                // Add "Furniture Sale Ordering Management System" in the next paragraph
                Paragraph systemParagraph = new Paragraph("Furniture Sale Ordering Management System");
                systemParagraph.setAlignment(Element.ALIGN_CENTER); // Align "Furniture Sale Ordering Management System" to the center
                document.add(systemParagraph);

                // Add "Approved Report" at the new line
                Paragraph approvedReportParagraph = new Paragraph("Approved Report");
                approvedReportParagraph.setAlignment(Element.ALIGN_CENTER); // Align "Approved Report" to the center
                document.add(approvedReportParagraph);

                // Add spacing between paragraphs
                document.add(new Paragraph("\n"));

                // Add the image
                Rectangle pageSize = document.getPageSize();
                String imagePath = "C:\\OODJassignment\\Yoyo_Logo.jpeg"; 
                Image logoImage = Image.getInstance(imagePath);
                float spaceBeforeLogo = 30;
                float logoX = (pageSize.getWidth() - logoImage.getScaledWidth()) / 2;
                float logoY = pageSize.getHeight() - 36 - spaceBeforeLogo;
                logoImage.setAbsolutePosition(logoX, logoY);
                float logoWidth = 100;
                float logoHeight = 70;
                logoImage.scaleAbsolute(logoWidth, logoHeight);
                document.add(logoImage);

                // Add header row with column names
                PdfPTable headerTable = new PdfPTable(5);
                String[] columnNames = {"Salesperson ID", "Customer Name", "Purchase Order No.", "Purchase Order Date", "Total Amount"};
                for (String columnName : columnNames) {
                    headerTable.addCell(new Phrase(columnName));
                }
                document.add(headerTable);

                // Add data rows
                for (Object[] rowData : rowDataList) {
                    PdfPTable table = new PdfPTable(5);
                    for (Object cellData : rowData) {
                        table.addCell(cellData != null ? cellData.toString() : "");
                    }
                    document.add(table);
                }

                document.close();

                JOptionPane.showMessageDialog(this, "PDF report generated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (DocumentException | FileNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error generating PDF report: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(Approved.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnGenerateActionPerformed

    // Custom page event class for header and footer
    class HeaderFooterPageEvent extends PdfPageEventHelper {

        public void onEndPage(PdfWriter writer, Document document) {
            PdfPTable header = new PdfPTable(1);
            header.setTotalWidth(document.right() - document.left());
            header.writeSelectedRows(0, -1, document.left(), document.top() + 10, writer.getDirectContent());

            PdfPTable footer = new PdfPTable(1);
            PdfPCell cell2 = new PdfPCell(new Phrase(String.format("Page %d", writer.getPageNumber())));
            cell2.setBorder(Rectangle.NO_BORDER);
            footer.addCell(cell2);
            footer.setTotalWidth(document.right() - document.left());
            footer.writeSelectedRows(0, -1, document.left(), document.bottom() - 10, writer.getDirectContent());
        }
    }


    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        // Check if either JCBeforeDate or JCAfterDate is null
        if (dcStartDate.getDate() == null || dcEndDate.getDate() == null) {
            // Display a message box indicating that one or both dates are not selected
            JOptionPane.showMessageDialog(this, "Please select both dates.", "Date Selection Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // If both dates are selected, proceed with filtering
            filterByDate();
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void tfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUsernameActionPerformed

    //Filter By Purchase Order Date
    private void filterByDate() {
        DefaultTableModel model = (DefaultTableModel) tbSaleOrdersTable.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tbSaleOrdersTable.setRowSorter(sorter);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date fromDate = dcStartDate.getDate();
        Date toDate = dcEndDate.getDate();
        String selectedOrderStatus = cbOrderStatus.getSelectedItem().toString();

        RowFilter<DefaultTableModel, Object> dateFilter = new RowFilter<DefaultTableModel, Object>() {
            @Override
            public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {
                String dateString = (String) entry.getValue(getColumnIndex("PurchaseOrderDate"));
                String orderStatus = (String) entry.getValue(getColumnIndex("OrderStatus"));

                try {
                    Date purchaseOrderDate = dateFormat.parse(dateString);

                    // Check if the purchase order date falls within the specified range
                    boolean dateInRange = (fromDate == null || purchaseOrderDate.compareTo(fromDate) >= 0)
                            && (toDate == null || purchaseOrderDate.compareTo(toDate) <= 0);

                    // Check if the order status matches the selected status
                    boolean statusMatches = selectedOrderStatus.equals("None") || selectedOrderStatus.equals(orderStatus);

                    return dateInRange && statusMatches;
                } catch (ParseException e) {
                    e.printStackTrace();
                    return false; // Handle parsing errors gracefully
                }
            }
        };

        sorter.setRowFilter(dateFilter);
    }

    // Helper method to get the column index by column name
    private int getColumnIndex(String columnName) {
        for (int i = 0; i < tbSaleOrdersTable.getColumnCount(); i++) {
            if (tbSaleOrdersTable.getColumnName(i).equals(columnName)) {
                return i;
            }
        }
        return -1;
    }

    //Filter by Order Status (ComboBox)
    private void filter(String query) {
        DefaultTableModel model = (DefaultTableModel) tbSaleOrdersTable.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        tbSaleOrdersTable.setRowSorter(tr);

        if (!query.equals("None")) {
            tr.setRowFilter(RowFilter.regexFilter(query));

        }
    }

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
            java.util.logging.Logger.getLogger(Approved.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Approved.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Approved.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Approved.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Approved().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbOrderStatus;
    private com.toedter.calendar.JDateChooser dcEndDate;
    private com.toedter.calendar.JDateChooser dcStartDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tbSaleOrdersTable;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables

}
