/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuUI;

import Database.DBControler;
import Services.Purchase;
import Services.PurchaseConstraints;
import Services.Shop;
import Stock.StockItem;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shane
 */
public class ShopAnalysisUI extends javax.swing.JFrame {

    /**
     * Creates new form ShopAnalysisUI
     */
    public ShopAnalysisUI() {
        initComponents();
        
        updateComboBoxes();
        
        cbProduct.setEnabled(false);
    }
    
    private void updateComboBoxes() {
        updateCbCategories();
        updateCbProducts();
    }
    
    private void updateCbCategories() {
        
        ArrayList<String> categories = new ArrayList();
        
        for (StockItem si : DBControler.getInstance().getStockItemDB().getStockItems().values()) {
            if (!categories.contains(si.getCategory()))
                categories.add(si.getCategory());
        }
        
        cbCategory.removeAllItems();
        cbCategory.addItem("-- any --");
        
        for (String category : categories)
            cbCategory.addItem(category);
    }
    
    private void updateCbProducts() {
        
        ArrayList<String> products = new ArrayList();
        
        for (StockItem si : DBControler.getInstance().getStockItemDB().getStockItems().values()) {
            
            System.out.println(si.getCategory() + ", " + cbCategory.getSelectedItem());
            
            if (!products.contains(si.getName()) 
                    && si.getCategory().equals(cbCategory.getSelectedItem()))
                products.add(si.getName());
        }
        
        cbProduct.removeAllItems();
        cbProduct.addItem("-- any --");
        
        for (String product : products)
            cbProduct.addItem(product);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbProduct = new javax.swing.JComboBox<>();
        cbCategory = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lReturns = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lSales = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbMonthStart = new javax.swing.JComboBox<>();
        cbMonthEnd = new javax.swing.JComboBox<>();
        ftfStartYear = new javax.swing.JFormattedTextField();
        ftfEndYear = new javax.swing.JFormattedTextField();
        ftfSales = new javax.swing.JFormattedTextField();
        ftfReturns = new javax.swing.JFormattedTextField();
        ftfIncome = new javax.swing.JFormattedTextField();
        bGetInfo = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tReturns = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tSales = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Start:");

        jLabel1.setText("Category:");

        jLabel3.setText("Product:");

        cbProduct.setEnabled(false);
        cbProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProductActionPerformed(evt);
            }
        });

        cbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoryActionPerformed(evt);
            }
        });

        jLabel4.setText("End:");

        lReturns.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lReturns);

        lSales.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lSales);

        jLabel5.setText("Sales");

        jLabel6.setText("Returns");

        jLabel7.setText("Sales:");

        jLabel8.setText("Minus Returns:");

        jLabel9.setText("Net Income:");

        cbMonthStart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        cbMonthEnd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        ftfStartYear.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("####"))));
        ftfStartYear.setText("2000");
        ftfStartYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftfStartYearActionPerformed(evt);
            }
        });

        ftfEndYear.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("####"))));
        ftfEndYear.setText("2020");
        ftfEndYear.setToolTipText("");

        ftfSales.setEditable(false);
        ftfSales.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("€0.00"))));
        ftfSales.setText("€0.00");

        ftfReturns.setEditable(false);
        ftfReturns.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("€0.00"))));
        ftfReturns.setText("€0.00");

        ftfIncome.setEditable(false);
        ftfIncome.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("€0.00"))));
        ftfIncome.setText("€0.00");

        bGetInfo.setText("Get Sales Info");
        bGetInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGetInfoActionPerformed(evt);
            }
        });

        tReturns.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Quantity Returned", "Date Returned"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tReturns);

        tSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Quantity Bought", "Date Bought"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tSales);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel9)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ftfSales)
                                    .addComponent(ftfReturns)
                                    .addComponent(ftfIncome)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbMonthEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ftfEndYear))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbMonthStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ftfStartYear)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(bGetInfo, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(322, 322, 322)
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jScrollPane1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cbMonthStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfStartYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbMonthEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfEndYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ftfSales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bGetInfo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(ftfReturns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(ftfIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoryActionPerformed
        System.out.println(cbCategory.getSelectedItem());
        updateCbProducts();
        
        cbProduct.setEnabled(!cbCategory.getSelectedItem().equals("-- any --"));
    }//GEN-LAST:event_cbCategoryActionPerformed

    private void cbProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProductActionPerformed
        System.out.println(cbProduct.getSelectedItem());
    }//GEN-LAST:event_cbProductActionPerformed

    private void ftfStartYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftfStartYearActionPerformed

    }//GEN-LAST:event_ftfStartYearActionPerformed

    private void bGetInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGetInfoActionPerformed
        updateLists();
    }//GEN-LAST:event_bGetInfoActionPerformed
    
    private void updateLists() {
        // Set up search constraints
        int startMonth = cbMonthStart.getSelectedIndex();
        int endMonth = cbMonthEnd.getSelectedIndex();
        
        int startYear = Integer.parseInt(ftfStartYear.getText());
        int endYear = Integer.parseInt(ftfEndYear.getText());
        
        GregorianCalendar startDate = new GregorianCalendar(startYear, startMonth, 0);
        GregorianCalendar endDate = new GregorianCalendar(endYear, endMonth, 0);
        
        String catStr = null;
        if (!cbCategory.getSelectedItem().equals("-- any --"))
            catStr = cbCategory.getSelectedItem().toString();
        
        String productStr = null;
        if (!cbProduct.getSelectedItem().equals("-- any --"))
            productStr = cbProduct.getSelectedItem().toString();
        
        // Get Sales
        PurchaseConstraints pc = new PurchaseConstraints(
                startDate, endDate, catStr, productStr, PurchaseConstraints.PurchaseType.SALES);
        ArrayList<Purchase> sales = new ArrayList();
        sales.addAll(Shop.getInstance().getPurchases(pc));
        
        // Get Returns
        pc = new PurchaseConstraints(
                startDate, endDate, catStr, productStr, PurchaseConstraints.PurchaseType.RETURNS);
        ArrayList<Purchase> returns = new ArrayList();
        returns.addAll(Shop.getInstance().getPurchases(pc));
        
        // Update Tables
        DefaultTableModel tmSales = (DefaultTableModel)tSales.getModel();
        DefaultTableModel tmReturns = (DefaultTableModel)tReturns.getModel();
        
        // Remove all rows
        while (tmSales.getRowCount() > 0)
            tmSales.removeRow(0);
        
        while (tmReturns.getRowCount() > 0)
            tmReturns.removeRow(0);
        
        double salesAmount = 0, returnsAmount = 0;
        // Add Sales to table
        for (Purchase p : sales) {
            String readableDate = new SimpleDateFormat("dd/MM/yyyy").format(p.getDate().getTime());
            Object[] row = { p.getItem().getName(), p.getQuantity(), readableDate};
            tmSales.addRow(row);
            salesAmount += p.getQuantity() * p.getItem().getPrice() * p.getDiscount();
        }
        
        // Add returns to table
        for (Purchase p : returns) {
            String readableDate = new SimpleDateFormat("dd/MM/yyyy").format(p.getDate().getTime());
            Object[] row = { p.getItem().getName(), -p.getQuantity(), readableDate};
            tmReturns.addRow(row);            
            returnsAmount += -p.getQuantity() * p.getItem().getPrice() * p.getDiscount();
        }
        
        // Update Monetary Displays
        ftfSales.setText(String.format("€%.2f", salesAmount));
        ftfReturns.setText(String.format("€%.2f", returnsAmount));
        ftfIncome.setText(String.format("€%.2f", salesAmount - returnsAmount));
    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ShopAnalysisUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ShopAnalysisUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ShopAnalysisUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ShopAnalysisUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ShopAnalysisUI().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bGetInfo;
    private javax.swing.JComboBox<String> cbCategory;
    private javax.swing.JComboBox<String> cbMonthEnd;
    private javax.swing.JComboBox<String> cbMonthStart;
    private javax.swing.JComboBox<String> cbProduct;
    private javax.swing.JFormattedTextField ftfEndYear;
    private javax.swing.JFormattedTextField ftfIncome;
    private javax.swing.JFormattedTextField ftfReturns;
    private javax.swing.JFormattedTextField ftfSales;
    private javax.swing.JFormattedTextField ftfStartYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> lReturns;
    private javax.swing.JList<String> lSales;
    private javax.swing.JTable tReturns;
    private javax.swing.JTable tSales;
    // End of variables declaration//GEN-END:variables
}
