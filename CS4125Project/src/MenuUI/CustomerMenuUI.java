/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuUI;

import Database.DBControler;
import Services.Shop;
import ThirdParty.CreditCardCo;
import ThirdParty.Delivery.BasicDelivery;
import ThirdParty.Delivery.MoneySaver;
import ThirdParty.Delivery.Premium;
import ThirdParty.Delivery.Delivery;
import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author Brian
 */
public class CustomerMenuUI extends javax.swing.JFrame {

    /**
     * Creates new form CustomerMenuUI
     */
    private String username;
    public CustomerMenuUI(String username) {
        initComponents();
        this.username = username;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Buy Stock");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Welcome!");

        jButton3.setText("Check Stock");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Purchase History");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(jButton3)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jButton4)))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(11, 11, 11)
                .addComponent(jButton4)
                .addGap(12, 12, 12)
                .addComponent(jButton1)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Logout
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(null, "See you next time!");
        this.setVisible(false);
        try {
            new MainMenuUI().run();
        } catch (IOException ex) {
            Logger.getLogger(CustomerMenuUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    //Check stock
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Shop s = Shop.getInstance();
        ArrayList<Map.Entry<String,Integer>> list = (ArrayList<Map.Entry<String,Integer>>) s.getSortedStock(Shop.SortOrder.NAME_ASC);
        
        int i = 0;
        String[] itemNames = new String[list.size()];
        for(Map.Entry<String,Integer> entry : list){
            itemNames[i] = entry.getKey() + " -€" + DBControler.getInstance().getStockItemDB().getStockItemByName(entry.getKey()).getPrice();
            i++;
        }
        
        //Picking item
        String pickedItem = "";
        Object itemList = JOptionPane.showInputDialog(null, 
                                                   "Pick item you would like to buy.", 
                                                   "Buy Stock", 
                                                    JOptionPane.QUESTION_MESSAGE, 
                                                    null,
                                                    itemNames, 
                                                    itemNames[0]);
        String[] selectionSplit = itemList.toString().split(" ");
        pickedItem = selectionSplit[0]; 
        
        MenuUI.buyItemFromShop(pickedItem);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Shop s = Shop.getInstance();
        ArrayList<Map.Entry<String,Integer>> list = (ArrayList<Map.Entry<String,Integer>>) s.getSortedStock(Shop.SortOrder.NAME_ASC);
        
        int i = 0;
        String[] itemNames = new String[list.size()];
        for(Map.Entry<String,Integer> entry : list){
            itemNames[i] = entry.getKey();
            i++;
        }
        
        //Picking item
        JComboBox cb = new JComboBox(itemNames);
        String pickedItem = "";
        Object itemList = JOptionPane.showInputDialog(null, 
                                                   "Pick item you would like to see information of.", 
                                                   "Check Stock", 
                                                    JOptionPane.QUESTION_MESSAGE, 
                                                    null,
                                                    itemNames, 
                                                    itemNames[0]);
        pickedItem = itemList.toString();
        //Show info on item
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.out.println(username+"banana");
        new PurchaseHistoryUI(username).run();
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * 
     */

            public void run() {
                this.setVisible(true);
            }
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
