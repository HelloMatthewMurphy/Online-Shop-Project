/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuUI;

import Services.Money;
import Services.Purchase;
import Services.PurchaseRequest;
import Services.PurchaseRequestDispatcher;
import Services.PurchaseRequestInterceptorChangeCurrency;
import Services.PurchaseRequestInterceptorLogging;
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

    private ArrayList<Purchase> purchases = new ArrayList<Purchase>();
    private Money.Currency currency = Money.Currency.values()[0];
    
    private PurchaseRequestDispatcher dispatcher;
    private PurchaseRequestInterceptorChangeCurrency currencyChangeInterceptor;
    
    /**
     * Creates new form CheckoutUI
     */
    public CheckoutUI() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        SetData();
        
        // Set up currency choice combo box
        for (Money.Currency currency : Money.Currency.values())
            cbCurrency.addItem(currency.name());
        
        // Set up the request dispatcher and interceptors
        dispatcher = new PurchaseRequestDispatcher();
        dispatcher.registerInterceptor(new PurchaseRequestInterceptorLogging("purchases.log"));
        currencyChangeInterceptor = null;
    }
    
    public void SetData(){
        DeleteData();
        purchases = ShoppingBasket.GetInstance().GetBasketContents();
        
        DefaultTableModel model = (DefaultTableModel) itemsInBasket.getModel();
        float total = 0;
        
        for (Purchase p : purchases) {
            Object rowData[] = new Object[3];
            rowData[0] = p.getItem().getName();
            rowData[1] = p.getQuantity();
            rowData[2] = String.format("€%.2f", p.getItem().getPrice());
            total += p.getItem().getPrice() * p.getQuantity();
            model.addRow(rowData);
        }
        
        // Set the text for the "Total Cost" label
        Money totalMoney = new Money(Money.Currency.EUR, total);
        totalMoney.changeCurrency(currency);
        totalCost.setText("Total: " + totalMoney);
        totalCost.repaint();
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
        cbCurrency = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

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

        cbCurrency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCurrencyActionPerformed(evt);
            }
        });

        jLabel1.setText("Which currency would you like to pay with?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(totalCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UndoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
        for (Purchase p: purchases) {
            dispatcher.dispatch(new PurchaseRequest(p));
        }
        ShoppingBasket.GetInstance().ClearBasket();
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void UndoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UndoButtonActionPerformed
        ShopControl.GetInstance().Undo();
        SetData();
    }//GEN-LAST:event_UndoButtonActionPerformed

    private void cbCurrencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCurrencyActionPerformed
        currency = Money.Currency.valueOf(cbCurrency.getSelectedItem().toString());
        SetData();
        
        // Set up currency change interceptor
        if (dispatcher != null) {
            dispatcher.unregisterInterceptor(currencyChangeInterceptor);
            currencyChangeInterceptor = new PurchaseRequestInterceptorChangeCurrency(currency);
            dispatcher.registerInterceptor(currencyChangeInterceptor);
        }
    }//GEN-LAST:event_cbCurrencyActionPerformed

    /* Create and display the form */
    public void run() {
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UndoButton;
    private javax.swing.JComboBox<String> cbCurrency;
    private javax.swing.JTable itemsInBasket;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel totalCost;
    // End of variables declaration//GEN-END:variables
}
