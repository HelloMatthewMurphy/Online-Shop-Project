/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuUI;
import Services.Shop;
import ThirdParty.Payment.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author brian
 */
public class PaymentSetupUI extends javax.swing.JFrame {

    /**
     * Creates new form PaymentSetupUI
     */
    private Payment paymentType;
    private IPaymentSystem temp;
    
    public PaymentSetupUI(Payment customerPayment) {
        initComponents();
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        paymentType = customerPayment;
        temp = null;
    }

    public void run() {
        this.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        SubmitButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NetbankingRadio = new javax.swing.JRadioButton();
        CardRatio = new javax.swing.JRadioButton();
        AIBRadio = new javax.swing.JRadioButton();
        BOIRadio = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Payment Setup");

        jSeparator1.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(0, 51, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator2.setForeground(new java.awt.Color(0, 51, 0));

        SubmitButton.setText("Submit");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Type");

        jLabel3.setText("Provider");

        buttonGroup1.add(NetbankingRadio);
        NetbankingRadio.setText("NetBanking");
        NetbankingRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NetbankingRadioActionPerformed(evt);
            }
        });

        buttonGroup1.add(CardRatio);
        CardRatio.setText("Card");
        CardRatio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardRatioActionPerformed(evt);
            }
        });

        buttonGroup2.add(AIBRadio);
        AIBRadio.setText("AIB");
        AIBRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AIBRadioActionPerformed(evt);
            }
        });

        buttonGroup2.add(BOIRadio);
        BOIRadio.setText("BOI");
        BOIRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOIRadioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CardRatio)
                            .addComponent(NetbankingRadio))))
                .addGap(44, 44, 44)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel3)
                        .addContainerGap(87, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BOIRadio)
                            .addComponent(AIBRadio))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(SubmitButton)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(57, 57, 57))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(58, 58, 58)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(CardRatio)
                                .addGap(18, 18, 18)
                                .addComponent(NetbankingRadio)
                                .addGap(43, 43, 43))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(AIBRadio)
                                .addGap(18, 18, 18)
                                .addComponent(BOIRadio))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SubmitButton)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
        
        if (paymentType == null) {   
            System.out.print("payment null");
            JOptionPane.showMessageDialog(new JFrame(), "Error - No Payment type selected!.",
                    "Dialog", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (temp == null) {
            System.out.print("temp null");
            JOptionPane.showMessageDialog(new JFrame(), "Error - No Payment provider selected!.",
                "Dialog", JOptionPane.ERROR_MESSAGE);
            return;
        }
        paymentType._IPaymentSystem = temp;
        Shop.getInstance().getAccount().setPaymentType(paymentType);
        paymentType.MakePayment();
        this.dispose();          
    }//GEN-LAST:event_SubmitButtonActionPerformed

    private void CardRatioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CardRatioActionPerformed

        paymentType = new CardPayment();
        if (temp != null) {
            paymentType._IPaymentSystem = temp;
        }
    }//GEN-LAST:event_CardRatioActionPerformed

    private void NetbankingRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NetbankingRadioActionPerformed

        paymentType = new NetBankingPayment();
        if (temp != null) {
            paymentType._IPaymentSystem = temp;
        }
    }//GEN-LAST:event_NetbankingRadioActionPerformed

    private void BOIRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOIRadioActionPerformed
        temp = new BOIPaymentSystem();
    }//GEN-LAST:event_BOIRadioActionPerformed

    private void AIBRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AIBRadioActionPerformed
        temp = new AIBPaymentSystem();
    }//GEN-LAST:event_AIBRadioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AIBRadio;
    private javax.swing.JRadioButton BOIRadio;
    private javax.swing.JRadioButton CardRatio;
    private javax.swing.JRadioButton NetbankingRadio;
    private javax.swing.JButton SubmitButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables

    private void setVisble(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
