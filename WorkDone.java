/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodj;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author yongj
 */
public class WorkDone extends javax.swing.JFrame {
    
    
     // Add a listener to the date chooser components
    private PropertyChangeListener dateChooserListener = new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (dcStartDate.getDate() != null && dcEndDate.getDate() != null) {
                btnSearch.setEnabled(true);
            } else {
                btnSearch.setEnabled(false);
            }
        }
    };

    public WorkDone() {
        initComponents();
         loadTableData();
          // UserUtilityClass.displayUsername(tfUsername);
        addComboBoxActionListener(); // Add ActionListener to the ComboBox
        
         // Add the listener to the date chooser components
    dcStartDate.addPropertyChangeListener("date", new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            // Check if both dates are selected
            if (dcStartDate.getDate() != null && dcEndDate.getDate() != null) {
                // Check if the selected date in JCBeforeDate is after the selected date in JCAfterDate
                if (dcStartDate.getDate().after(dcEndDate.getDate())) {
                    // Disable the date chooser and show an error message
                    dcStartDate.setDate(null);
                    JOptionPane.showMessageDialog(WorkDone.this, "Selected date cannot be after the end date", "Date Selection Error", JOptionPane.ERROR_MESSAGE);
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
                    JOptionPane.showMessageDialog(WorkDone.this, "Selected date cannot be before the start date", "Date Selection Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    });
        
          // Attach dateChooserListener to both date chooser components
    dcStartDate.addPropertyChangeListener(dateChooserListener);
    dcEndDate.addPropertyChangeListener(dateChooserListener);
        
        cbProductStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "WorkDone", "Pending","InProgress" }));
        // Disable the combobox initially
       // CBProductStatus.setEnabled(false);
        //JCBeforeDate.setEnabled(false);
        //JCAfterDate.setEnabled(false);
        btnSearch.setEnabled(false);
        
        // Add an item listener to the combobox
        cbProductStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }

            private void jComboBox1ItemStateChanged(ItemEvent evt) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbProductStatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSaleOrdersTable = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        dcStartDate = new com.toedter.calendar.JDateChooser();
        dcEndDate = new com.toedter.calendar.JDateChooser();
        btnSearch = new javax.swing.JButton();
        tfUsername = new javax.swing.JTextField();
        btnGenerate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Generate Work Done Report");

        jLabel2.setText("Filter by product status: ");

        cbProductStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Pending", "WorkDone", "InProgress" }));
        cbProductStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProductStatusActionPerformed(evt);
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

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel3.setText("Filter By Completed Date:");

        dcStartDate.setDateFormatString("dd-MM-yyyy");

        dcEndDate.setDateFormatString("dd-MM-yyyy");

        btnSearch.setText("Search Range Date");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnGenerate.setText("Generate");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbProductStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dcEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(351, 351, 351)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(btnRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerate)
                .addGap(85, 85, 85))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1))
                    .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cbProductStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(dcStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(btnGenerate))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(909, 909, 909)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        // Method to load data into the JTable from the text file
    private void loadTableData() {
      
          // Text File
    String filePath = "C:\\GitHub\\OODJassignment\\OODJAss\\SaleOrdersTable.txt";
    File file = new File(filePath);

    try {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String firstLine = br.readLine().trim();
        String[] columnsName = firstLine.split(";");

        // Define the columns you want to display
      String[] displayColumns = {"SaleOrderNo", "PurchaseOrderNo", "PurchaseOrderDate", 
                                   "UserID", "CustomerName", "CustomerPhoneNo","ProductName", 
                                   "TotalAmount", "ProductStatus","CompletedDate","DeliveryDate","DeliveryStatus"};

        // Create a model with specific columns
        DefaultTableModel model = new DefaultTableModel(displayColumns, 0);
        tbSaleOrdersTable.setModel(model);

        String line;
        while ((line = br.readLine()) != null) {
            String[] dataRow = line.split(";");
            // Add only specific columns to the model
            Object[] rowData = {dataRow[0], dataRow[6], dataRow[7], dataRow[2],dataRow[3],dataRow[4],dataRow[10],dataRow[16],dataRow[17],dataRow[18],dataRow[19],dataRow[20]};
            model.addRow(rowData);
        }

        // Enable the ComboBox after loading data into the JTable
        cbProductStatus.setEnabled(true);

        // Check if the table is empty and disable date chooser components accordingly
        if (model.getRowCount() == 0) {
            dcStartDate.setEnabled(false);
            dcEndDate.setEnabled(false);
        } else {
            dcStartDate.setEnabled(true);
            dcEndDate.setEnabled(true);
        }

        // Close the BufferedReader
        br.close();

    } catch (IOException ex) {
        Logger.getLogger(Approved.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
     // Clear the date choosers and set the selected index of the combobox to 0 (None)
    dcStartDate.setDate(null);
    dcEndDate.setDate(null);
    cbProductStatus.setSelectedIndex(0);
    
    // Disable the search button since there's no filter set
    btnSearch.setEnabled(false);
    
    // Refresh the table data by calling the loadTableData method again
    loadTableData();
        
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void cbProductStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProductStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbProductStatusActionPerformed

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

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbSaleOrdersTable.getModel();
    List<Object[]> rowDataList = new ArrayList<>();

    // Check if any filters are applied or if rows are selected
    if ((cbProductStatus.getSelectedIndex() == 0 && dcStartDate.getDate() == null && dcEndDate.getDate() == null) && tbSaleOrdersTable.getSelectedRow() == -1) {
        // Display a dialog box to notify the user to filter before generating the report
        JOptionPane.showMessageDialog(this, "Please apply filters or select a row before generating the report.", "Filter Required", JOptionPane.WARNING_MESSAGE);
    } else {
        // Proceed with generating the report
        int[] selectedRows = tbSaleOrdersTable.getSelectedRows();

        if (selectedRows.length > 0) {
            // Collect data from selected rows
            for (int selectedRow : selectedRows) {
                Object[] rowData = new Object[5]; // Array to store only the required attributes
                rowData[0] = tbSaleOrdersTable.getValueAt(selectedRow, 0); // SalesOrderNumber
                rowData[1] = tbSaleOrdersTable.getValueAt(selectedRow, 4); // CustomerName
                rowData[2] = tbSaleOrdersTable.getValueAt(selectedRow, 6); // ProductName
                rowData[3] = tbSaleOrdersTable.getValueAt(selectedRow, 9); // CompletedDate
                rowData[4] = tbSaleOrdersTable.getValueAt(selectedRow, 10); // DeliveryDate
                rowDataList.add(rowData);
            }
        } else {
            // Collect data from all rows that meet the filter criteria
            for (int i = 0; i < model.getRowCount(); i++) {
                // Check if the row passes the filter criteria
                if (tbSaleOrdersTable.getRowSorter().convertRowIndexToView(i) != -1) {
                    Object[] rowData = new Object[5]; // Array to store only the required attributes
                    rowData[0] = model.getValueAt(i, 0); // SalesOrderNumber
                    rowData[1] = model.getValueAt(i, 4); // CustomerName
                    rowData[2] = model.getValueAt(i, 6); // ProductName
                    rowData[3] = model.getValueAt(i, 9); // CompletedDate
                    rowData[4] = model.getValueAt(i, 10); // DeliveryDate
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
    Document document = new Document();
    String userHomeDirectory = System.getProperty("user.home");
    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String filePath = userHomeDirectory + File.separator + "WorkDoneReport_" + timeStamp + ".pdf";

    try {
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));

        // Add header and footer
        HeaderFooterPageEvent event = new HeaderFooterPageEvent();
        writer.setPageEvent(event);

        document.open();

        // Add "YOYO" on a new line
        Paragraph yoyoParagraph = new Paragraph("YOYO Work Done Report\n\n");
        document.add(yoyoParagraph);

        // Add header row with column names
        PdfPTable headerTable = new PdfPTable(5);
        String[] columnNames = {"SalesOrder", "Customer", "Product", "CompletedDate", "DeliveryDate"};
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
    }
    } 

     

// Custom page event class for header and footer
class HeaderFooterPageEvent extends PdfPageEventHelper {
   public void onEndPage(PdfWriter writer, Document document) {
        PdfPTable header = new PdfPTable(1);
      //  PdfPCell cell = new PdfPCell(new Phrase("YOYO\n"));
      //  cell.setBorder(Rectangle.NO_BORDER);
        //header.addCell(cell);
        header.setTotalWidth(document.right() - document.left());
        header.writeSelectedRows(0, -1, document.left(), document.top() + 10, writer.getDirectContent());

        PdfPTable footer = new PdfPTable(1);
        PdfPCell cell2 = new PdfPCell(new Phrase(String.format("Page %d", writer.getPageNumber())));
        cell2.setBorder(Rectangle.NO_BORDER);
        footer.addCell(cell2);
        footer.setTotalWidth(document.right() - document.left());
        footer.writeSelectedRows(0, -1, document.left(), document.bottom() - 10, writer.getDirectContent());
    }
    }//GEN-LAST:event_btnGenerateActionPerformed
 private void addComboBoxActionListener() {
        cbProductStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterTableByProductStatus(); // Call method to filter table
            }
        });
    }
 
 
   //Filter By Purchase Order Date
private void filterByDate() {
    DefaultTableModel model = (DefaultTableModel) tbSaleOrdersTable.getModel();
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    tbSaleOrdersTable.setRowSorter(sorter);

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    System.out.println("BeforeDate: " + dcStartDate.getDate());
    System.out.println("AfterDate: " + dcEndDate.getDate());
    
    
    Date fromDate = dcStartDate.getDate();
    Date toDate = dcEndDate.getDate();
    String selectedOrderStatus = cbProductStatus.getSelectedItem().toString();

    RowFilter<DefaultTableModel, Object> dateFilter = new RowFilter<DefaultTableModel, Object>() {
        @Override
        public boolean include(RowFilter.Entry<? extends DefaultTableModel, ? extends Object> entry) {
            String dateString = (String) entry.getValue(getColumnIndex("CompletedDate"));
            String productStatus = (String) entry.getValue(getColumnIndex("ProductStatus"));

            try {
                Date completedDate = dateFormat.parse(dateString);

                // Check if the purchase order date falls within the specified range
                boolean dateInRange = (fromDate == null || completedDate.compareTo(fromDate) >= 0) &&
                                      (toDate == null || completedDate.compareTo(toDate) <= 0);

                // Check if the order status matches the selected status
                boolean statusMatches = selectedOrderStatus.equals("None") || selectedOrderStatus.equals(productStatus);

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
 
 
 
// Method to filter table by ProductStatus
 private void filterTableByProductStatus() {
        DefaultTableModel model = (DefaultTableModel) tbSaleOrdersTable.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tbSaleOrdersTable.setRowSorter(sorter);

        String selectedStatus = cbProductStatus.getSelectedItem().toString();
        if (!selectedStatus.equals("None")) {
            RowFilter<DefaultTableModel, Object> rf = RowFilter.regexFilter(selectedStatus, 8); // Assuming ProductStatus is in the 8th column (index 7)
            sorter.setRowFilter(rf);
        } else {
            tbSaleOrdersTable.setRowSorter(null); // Remove any existing filters
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
            java.util.logging.Logger.getLogger(WorkDone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WorkDone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WorkDone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WorkDone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WorkDone().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbProductStatus;
    private com.toedter.calendar.JDateChooser dcEndDate;
    private com.toedter.calendar.JDateChooser dcStartDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbSaleOrdersTable;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
