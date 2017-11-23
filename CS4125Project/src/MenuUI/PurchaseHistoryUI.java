/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuUI;

import Database.DBControler;
import Database.PurchaseDB;
import Services.Purchase;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brian
 */
public class PurchaseHistoryUI extends javax.swing.JFrame {

    /**
     * Creates new form PurchaseHistoryUI
     */
    private PurchaseDB db;
    private List<Purchase> purchases;
    private String username;
    public PurchaseHistoryUI(String username) {
        this.username = username;
        initComponents();
        db = DBControler.getInstance().getPurchaseDB();
        purchases = db.getPurchases();
        addRowsToTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        purchaseHistory = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        purchaseHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Quantity", "Discount", "Date"
            }
        ));
        jScrollPane1.setViewportView(purchaseHistory);
        if (purchaseHistory.getColumnModel().getColumnCount() > 0) {
            purchaseHistory.getColumnModel().getColumn(0).setHeaderValue("Item");
            purchaseHistory.getColumnModel().getColumn(1).setHeaderValue("Quantity");
            purchaseHistory.getColumnModel().getColumn(2).setHeaderValue("Discount");
            purchaseHistory.getColumnModel().getColumn(3).setHeaderValue("Date");
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
        //</editor-fold>

        /* Create and display the form */
       
            public void run() {
                this.setVisible(true);
            }
     
    
    public void addRowsToTable(){
        //System.out.println(username);
        DefaultTableModel model = (DefaultTableModel) purchaseHistory.getModel();
        Object rowData[] = new Object[4];
        for (int i = 0; i < purchases.size();i++){
            System.out.println(purchases.get(i).getUsername());
            if(username.equals(purchases.get(i).getUsername())){
            rowData[0] = purchases.get(i).getItem().getName();
            rowData[1] = purchases.get(i).getQuantity();
            rowData[2] = purchases.get(i).getDiscount();
            rowData[3] = purchases.get(i).getDate().get(Calendar.DATE)+"/"+(purchases.get(i).getDate().get(Calendar.MONTH)+1)+"/"+purchases.get(i).getDate().get(Calendar.YEAR);
            model.addRow(rowData);
           }
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable purchaseHistory;
    // End of variables declaration//GEN-END:variables
}
