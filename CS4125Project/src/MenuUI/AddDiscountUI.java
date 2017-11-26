/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuUI;

import Database.DBControler;
import Database.StockItemDB;
import Services.Shop;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * UI used to add discounts to StockItem
 * @author Jack
 */
public class AddDiscountUI extends javax.swing.JFrame {

    StockItemDB db;
    /**
     * Creates new form AddDiscountUI
     * @throws SQLException
     */
    public AddDiscountUI() throws SQLException {
        initComponents();
        setComboBox();
        db = DBControler.getInstance().getStockItemDB();
        setFirstDiscountText();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        discountValue = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        discountText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Item");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        discountValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountValueActionPerformed(evt);
            }
        });

        jLabel2.setText("Discount amount in format (XX% discount)");

        submit.setText("submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(discountValue, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(submit)
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(discountText, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discountValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submit))
                .addGap(28, 28, 28)
                .addComponent(discountText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
    * @param evt when an action is performed.
    *
    */
    private void discountValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountValueActionPerformed

    }//GEN-LAST:event_discountValueActionPerformed
/**
    * @param evt when an action is performed updates StockItems discount
    *
    */
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        double value = 0;
        boolean error = false;
        try {
                if(discountValue.getText().equals("")){
                    error = true;
                    JOptionPane.showMessageDialog(null, "Invalid value inputed. Please enter a number in the format. (XX%)");
                }
                else{
                    value = (Double.parseDouble(discountValue.getText())/100);
                }
    } catch (NumberFormatException e) {
        error = true;
        JOptionPane.showMessageDialog(null, "Invalid value inputed. Please enter a number in the format. (XX%)");
    }
        if((value > 100 || value <= 0) && !error){
            error = true;
            JOptionPane.showMessageDialog(null, "Invalid value inputed. Please enter a value between 0 and 100.");
        }
        if(!error){
        db.getStockItemByName((String)jComboBox1.getSelectedItem()).setDiscount(value);            
        
        try {
            db.save();
        } catch (IOException ex) {
            Logger.getLogger(AddDiscountUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Discount updated!");
        }
    }//GEN-LAST:event_submitActionPerformed
    /**
        * @param evt when an action is performed changes discount
        * in discountText to current StockItem discount.
        *
        */
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String disS = "";
        double disD = (db.getStockItemByName((String)jComboBox1.getSelectedItem()).getDiscount()) * 100;
        disS += disD;
        discountText.setText("Current item discount = " + (int)(disD) + "%");

    }//GEN-LAST:event_jComboBox1ActionPerformed
    /**
    * Fills combobox with all StockItem.
    *
    * @throws SQLException
    */
    private void setComboBox() throws SQLException{
        Shop s = Shop.getInstance();
        ArrayList<Map.Entry<String,Integer>> list = (ArrayList<Map.Entry<String,Integer>>) s.getSortedStock(Shop.SortOrder.NAME_ASC);
        
        int i = 0;
        String[] itemNames = new String[list.size()];
        for(Map.Entry<String,Integer> entry : list){
            itemNames[i] = entry.getKey();
            i++;
        }
        
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(itemNames));

    }
    
    /**
    * Sets the discount on label for the first StockItem to be displayed
    * when the Frame is displayed
    *
    */
    private void setFirstDiscountText(){
        Shop s = Shop.getInstance();
        ArrayList<Map.Entry<String,Integer>> list = (ArrayList<Map.Entry<String,Integer>>) s.getSortedStock(Shop.SortOrder.NAME_ASC);
        
        int i = 0;
        String[] itemNames = new String[list.size()];
        for(Map.Entry<String,Integer> entry : list){
            itemNames[i] = entry.getKey();
            i++;
        }
        String disS = "";
        double disD = (db.getStockItemByName(itemNames[0]).getDiscount()) * 100;
        disS += disD;
        discountText.setText("Current item discount = " + (int)(disD) + "%");
    }
    /**
    * Sets visible to true for the JFrame
    *
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    */
    public void run() {
                this.setVisible(true);
            }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel discountText;
    private javax.swing.JTextField discountValue;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}