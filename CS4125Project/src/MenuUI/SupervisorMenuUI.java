/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuUI;

import Database.DBControler;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Brian
 */
public class SupervisorMenuUI extends javax.swing.JFrame {
    
    public SupervisorMenuUI() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Logout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        addSupervisor = new javax.swing.JButton();
        addDiscount = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        buttonRollback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        jLabel1.setText("Welcome");

        addSupervisor.setText("Add Supervisor");
        addSupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSupervisorActionPerformed(evt);
            }
        });

        addDiscount.setText("Add discount");
        addDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDiscountActionPerformed(evt);
            }
        });

        jButton1.setText("Check Sales and Returns");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonRollback.setText("Rollback Databases (BE CAREFUL!)");
        buttonRollback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRollbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 152, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Logout)
                        .addGap(170, 170, 170))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(177, 177, 177))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(130, 130, 130))))
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(addSupervisor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonRollback, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(addDiscount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonRollback)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addSupervisor)
                .addGap(18, 18, 18)
                .addComponent(Logout)
                .addGap(72, 72, 72))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        JOptionPane.showMessageDialog(null, "See you next time!");
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        try {
            new MainMenuUI().run();
        } catch (IOException ex) {
            Logger.getLogger(CustomerMenuUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LogoutActionPerformed

    private void addSupervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSupervisorActionPerformed
        new AddSupervisorUI().run();
    }//GEN-LAST:event_addSupervisorActionPerformed

    private void addDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDiscountActionPerformed
        try {
            new AddDiscountUI().run();
        } catch (SQLException ex) {
            Logger.getLogger(SupervisorMenuUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addDiscountActionPerformed


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            new ShopAnalysisUI().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonRollbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRollbackActionPerformed
        String[] backupDateStrings;
        try {
            backupDateStrings = DBControler.getInstance().getWarehouseDB().getBackupTimes();
        }
        catch (IOException ex) {
            return;
        }
        
        int numBackups = backupDateStrings.length;
                

        boolean isValid = false;
        int backupId = 0;
        
        while (!isValid) {
            String message = "Please enter a value from 0 to " + (numBackups - 1) + ", corresponding to the backup you which to use\n";
            for (String dateString : backupDateStrings)
                message += dateString + "\n";

            String input = JOptionPane.showInputDialog(message);

            if (input == null)
                return;
            try {
                backupId = Integer.parseInt(input);
            }catch(NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Error - Please enter a numeric value!", "Invalid Entry!", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            isValid = true;
        }
        
        if (backupId >= 0 && backupId < numBackups) {
            try {
                DBControler.getInstance().getPurchaseDB().loadBackup(backupId);
                DBControler.getInstance().getWarehouseDB().loadBackup(backupId);
                JOptionPane.showMessageDialog(null, "Successfully rolled back databases");
            }
            catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error, could not rollback databases");
            }
        } else 
            JOptionPane.showMessageDialog(null, "Please enter a value from 0 to " + (numBackups - 1));
    }//GEN-LAST:event_buttonRollbackActionPerformed

    public void run() {
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logout;
    private javax.swing.JButton addDiscount;
    private javax.swing.JButton addSupervisor;
    private javax.swing.JButton buttonRollback;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
