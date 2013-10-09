/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package des;

import java.math.BigInteger;


public class Ventana extends javax.swing.JFrame {

    firstStage fs;
    secondStage ss;
    secondStageInv ssi;
    thirdStage ts;
    keyGenerator kg;
    long fsmessage;
    long ssmessage;
    long tsmessage;
    long fsimessage;
    long ssimessage;
    long tsimessage;
    long[] keys;
    String keysta;
    
    public Ventana() {
        initComponents();
        initStages();
    }
    
    private void initStages(){
        
        fs = new firstStage();
        ss = new secondStage();
        ssi = new secondStageInv();
        ts = new thirdStage();
        kg = new keyGenerator();
        keysta = "";
        
    }
    
    private static long parseLong(String s, int base) {
        return new BigInteger(s, base).longValue();
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plaintextTF = new javax.swing.JTextField();
        key1TF = new javax.swing.JTextField();
        cifrarB = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ciphertextL = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        llaveAleatoriaCB = new javax.swing.JCheckBox();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        keyArea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        Descifrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        plaintextTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plaintextTFActionPerformed(evt);
            }
        });

        cifrarB.setText("Cifrar");
        cifrarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cifrarBActionPerformed(evt);
            }
        });

        jLabel1.setText("Mensaje");

        jLabel2.setText("LLave");

        ciphertextL.setForeground(new java.awt.Color(0, 51, 51));
        ciphertextL.setText("   ");

        jLabel3.setText("El texto resultado es:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Data Encryption Standard (DES)");

        llaveAleatoriaCB.setText("LLave aleatoria");
        llaveAleatoriaCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                llaveAleatoriaCBItemStateChanged(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        keyArea.setColumns(20);
        keyArea.setRows(5);
        jScrollPane1.setViewportView(keyArea);

        jLabel5.setText("Round keys");

        Descifrar.setText("Descifrar");
        Descifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescifrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ciphertextL, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(llaveAleatoriaCB)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cifrarB)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Descifrar))
                                            .addComponent(key1TF, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(plaintextTF, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(plaintextTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(key1TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cifrarB)
                                    .addComponent(llaveAleatoriaCB)
                                    .addComponent(Descifrar))
                                .addGap(29, 29, 29)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ciphertextL)
                                .addGap(12, 12, 12))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jSeparator2)))
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(32, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void plaintextTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plaintextTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plaintextTFActionPerformed

    private void cifrarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cifrarBActionPerformed
        
        if(key1TF.getText().length() == 16 && plaintextTF.getText().length() == 16){
            keys = kg.generatekeys(parseLong(key1TF.getText(),16));
            for(int i = 0;i<16;i++){
                keysta += "Round " + (i+1) + " : " + Long.toHexString(keys[i]) + "\n";
            }
            keyArea.setText(keysta);
            keysta = "";
            fsmessage = fs.initialPermutation(parseLong(plaintextTF.getText(),16));
            ssmessage = ss.round16(fsmessage, keys);
            tsmessage = ts.finalPermutation(ssmessage);
            ciphertextL.setText(Long.toHexString(tsmessage));
        }
        else{
            ciphertextL.setText("Llave y mensaje deben ser de 16 caracteres");
        }
        
              
        
    }//GEN-LAST:event_cifrarBActionPerformed

    private void llaveAleatoriaCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_llaveAleatoriaCBItemStateChanged
        if(key1TF.isEditable()) {
            //generar llave
            String llave = "";
            int digito;
            for (int i = 0; i < 16; i++) {
                digito = (int)Math.floor(Math.random()*16);
                llave += Integer.toHexString(digito);
            }
            key1TF.setText(llave);
            //inhabilitar
            key1TF.setEditable(false);
        }
        else {
            key1TF.setEditable(true);
            key1TF.setText("");
        }
    }//GEN-LAST:event_llaveAleatoriaCBItemStateChanged

    private void DescifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescifrarActionPerformed
        
        if(key1TF.getText().length() == 16 && plaintextTF.getText().length() == 16){
            keys = kg.generatekeys(parseLong(key1TF.getText(),16));
            for(int i = 0;i<16;i++){
                keysta += "Round " + i + " : " + Long.toHexString(keys[i]) + "\n";
            }
            keyArea.setText(keysta);
            keysta = "";
            fsimessage = fs.initialPermutation(parseLong(plaintextTF.getText(),16));
            ssimessage = ssi.round16Inv(fsimessage, keys);
            tsimessage = ts.finalPermutation(ssimessage);
            ciphertextL.setText(Long.toHexString(tsimessage));
        }
        else{
            ciphertextL.setText("Llave y mensaje deben ser de 16 caracteres");
        }
        
    }//GEN-LAST:event_DescifrarActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Descifrar;
    private javax.swing.JButton cifrarB;
    private javax.swing.JLabel ciphertextL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField key1TF;
    private javax.swing.JTextArea keyArea;
    private javax.swing.JCheckBox llaveAleatoriaCB;
    private javax.swing.JTextField plaintextTF;
    // End of variables declaration//GEN-END:variables
}
