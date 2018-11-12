/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuUI;

import Services.Purchase;
import Services.Shop;
import Services.ShopControl;
import Services.ShoppingBasket;
import Stock.StockItem;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hello
 */
public class CheckoutUI extends javax.swing.JFrame {

    private ArrayList<Purchase> items = new ArrayList<Purchase>();
    
    /**
     * Creates new form CheckoutUI
     */
    public CheckoutUI() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        SetData();
    }
    
    public void SetData(){
        DeleteData();
        items = ShoppingBasket.GetInstance().GetBasketContents();
        
        DefaultTableModel model = (DefaultTableModel) itemsInBasket.getModel();
        Object rowData[] = new Object[4];
        float total = 0;
        
        for (int i = 0; i < items.size();i++){
            rowData[0] = items.get(i).getItem().getName();
            rowData[1] = items.get(i).getQuantity();
            rowData[2] = items.get(i).getItem().getPrice();
            total += items.get(i).getItem().getPrice();
            model.addRow(rowData);
        }
        totalCost.setText("Total: " + total);
    }
    
    public void DeleteData(){
        DefaultTableModel model = (DefaultTableModel) itemsInBasket.getModel();
        
        for(int i = model.getRowCount()-1; i >= 0; i--){
            model.removeRow(i);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemsInBasket = new javax.swing.JTable();
        totalCost = new javax.swing.JLabel();
        UndoButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton5.setText("Checkout");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        itemsInBasket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(itemsInBasket);

        totalCost.setText("Total: €0.00");

        UndoButton.setText("Undo");
        UndoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(totalCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(UndoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalCost, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(UndoButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // checkout
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Shop s = Shop.getInstance();
        for (int i = 0; i < items.size(); i++){
            s.makePurchase(items.get(i).getItem(), items.get(i).getQuantity(), items.get(i).getUsername());
        }
        this.setVisible(false);
        ShoppingBasket.GetInstance().ClearBasket();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void UndoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UndoButtonActionPerformed
        ShopControl.GetInstance().Undo();
        SetData();
    }//GEN-LAST:event_UndoButtonActionPerformed

    /* Create and display the form */
       
    public void run() {
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UndoButton;
    private javax.swing.JTable itemsInBasket;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel totalCost;
    // End of variables declaration//GEN-END:variables
}
