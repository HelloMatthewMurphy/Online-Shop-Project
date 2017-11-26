/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuUI;

import Database.AccountDB;
import Database.DBControler;
import User.Account;
import User.AccountFactory;
import User.Customer;
import User.Supervisor;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Brian
 */
public class AddSupervisorUI extends javax.swing.JFrame {

    private Scanner scan;
    private List<Account> users;
    private String username;
    AccountDB db;
    private String password;
    private String email;
    
    public AddSupervisorUI() {
        initComponents();
        scan = new Scanner(System.in);
        db = DBControler.getInstance().getAccountDB();
        users = db.getAccounts();
        System.out.println(users.size());
        username = "";
        password = "";
        email = "";
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
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        RegisterUsername = new javax.swing.JTextField();
        RegisterEmail = new javax.swing.JTextField();
        RegisterPassword = new javax.swing.JTextField();

        jLabel1.setText("Create Supervisor Account");

        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Username:");

        jLabel3.setText("Email:");

        jLabel4.setText("Password:");

        RegisterUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterUsernameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(RegisterUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(RegisterEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(RegisterPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(RegisterUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(RegisterEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(RegisterPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean valid = false;
            while (valid == false){
                username = RegisterUsername.getText();
                System.out.println(username);
                RegisterUsername.setText("");
                password = RegisterPassword.getText();
                System.out.println(password);
                RegisterPassword.setText("");
                email = RegisterEmail.getText();
                System.out.println(email);
                RegisterEmail.setText("");
                
                    if(users.isEmpty()){
                        valid = true;
                    }
                    else
                        for(int i = 0; i < users.size();i++){
                            if(username.equals(users.get(i).getUsername()) || email.equals(users.get(i).getEmail())){
                                JOptionPane.showMessageDialog(null,"Invalid details");
                                return;
                            }
                            else valid = true;

                        }
            }  
                AccountFactory factory = new AccountFactory();
                users.add((Supervisor)factory.createAccount("supervisor", username, password, email));
               System.out.println(users.size());
                try{
                db.save();
                JOptionPane.showMessageDialog(null,"Successfully Registered!");
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                }catch(IOException e){
                    
                }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void RegisterUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegisterUsernameActionPerformed

            public void run() {
                this.setVisible(true);
            }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField RegisterEmail;
    private javax.swing.JTextField RegisterPassword;
    private javax.swing.JTextField RegisterUsername;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
