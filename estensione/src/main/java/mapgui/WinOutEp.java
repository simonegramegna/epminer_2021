/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapgui;

import javax.swing.DefaultListModel;
import java.util.LinkedList;
import java.util.Arrays;

/**
 *
 * @author User
 */
public class WinOutEp extends javax.swing.JDialog {

    private DefaultListModel<String> modelEP;
    private DefaultListModel<String> modelFP;
    
    /**
     * Creates new form WinOutEp
     */
    public WinOutEp(java.awt.Frame parent, boolean modal, String epMiner, String fpMiner, float minsup, float mingr, String target, String background, String fp, String ep) {
        super(parent, modal);
        
        modelEP = new DefaultListModel<>();
        modelFP = new DefaultListModel<>();
        initComponents();

        this.setResizable(false);
        this.setDisplayedInput(minsup, mingr, target, background);
        
        setDisplayedFPEP(modelFP, fp);
        setDisplayedFPEP(modelEP, ep);
    }
    
     private void setDisplayedInput(float minsup, float mingr, String target, String background) {

        minsoutLabel.setText(Float.toString(minsup));
        mingroutLabel.setText(Float.toString(mingr));
        targetoutLabel.setText(target);
        backgroundoutLabel.setText(background);
     }
     
     private void setDisplayedFPEP(DefaultListModel<String> listM, String fpEp){
         
         LinkedList<String> outputList = new LinkedList<String>(Arrays.asList(fpEp.split("\n")));
         
         for( String outEPFP : outputList){
             
             listM.addElement(outEPFP);
         }
     }
     
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        minsLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();
        mingrLabel = new javax.swing.JLabel();
        minsoutLabel = new javax.swing.JLabel();
        mingroutLabel = new javax.swing.JLabel();
        targetLabel = new javax.swing.JLabel();
        targetoutLabel = new javax.swing.JLabel();
        backgroundoutLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        newEPbtn = new javax.swing.JButton();
        quitEP = new javax.swing.JButton();
        fpLabel = new javax.swing.JLabel();
        EPLabel = new javax.swing.JLabel();
        FPScroll = new javax.swing.JScrollPane();
        FPOut = new javax.swing.JList<>(modelFP);
        EPScroll = new javax.swing.JScrollPane();
        EPOut = new javax.swing.JList<>(modelEP);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        minsLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        minsLabel.setForeground(new java.awt.Color(30, 0, 255));
        minsLabel.setText("minSup:");

        backgroundLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        backgroundLabel.setForeground(new java.awt.Color(30, 0, 255));
        backgroundLabel.setText("backgroundTable:");

        mingrLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        mingrLabel.setForeground(new java.awt.Color(30, 0, 255));
        mingrLabel.setText("minGr:");

        minsoutLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        mingroutLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        targetLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        targetLabel.setForeground(new java.awt.Color(30, 0, 255));
        targetLabel.setText("targetTable:");

        targetoutLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        backgroundoutLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        newEPbtn.setText("Nuova Computazione");

        quitEP.setText("Esci");
        quitEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitEPActionPerformed(evt);
            }
        });

        fpLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        fpLabel.setForeground(new java.awt.Color(30, 0, 255));
        fpLabel.setText("FPMiner:");

        EPLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        EPLabel.setForeground(new java.awt.Color(30, 0, 255));
        EPLabel.setText("EPMiner:");

        FPOut.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        FPScroll.setViewportView(FPOut);

        EPOut.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        EPScroll.setViewportView(EPOut);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(backgroundLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(backgroundoutLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(targetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(targetoutLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(minsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minsoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(mingrLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mingroutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 251, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jSeparator1)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(newEPbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quitEP, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(EPScroll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                    .addComponent(fpLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EPLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FPScroll, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mingrLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mingroutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(minsLabel)
                    .addComponent(minsoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(targetoutLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(targetLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(19, 19, 19)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(backgroundLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(backgroundoutLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FPScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EPScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(quitEP, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(newEPbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void quitEPActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_quitEPActionPerformed
        // TODO add your handling code here:
        dispose();
    }// GEN-LAST:event_quitEPActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WinOutEp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WinOutEp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WinOutEp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WinOutEp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EPLabel;
    private javax.swing.JList<String> EPOut;
    private javax.swing.JScrollPane EPScroll;
    private javax.swing.JList<String> FPOut;
    private javax.swing.JScrollPane FPScroll;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel backgroundoutLabel;
    private javax.swing.JLabel fpLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel mingrLabel;
    private javax.swing.JLabel mingroutLabel;
    private javax.swing.JLabel minsLabel;
    private javax.swing.JLabel minsoutLabel;
    private javax.swing.JButton newEPbtn;
    private javax.swing.JButton quitEP;
    private javax.swing.JLabel targetLabel;
    private javax.swing.JLabel targetoutLabel;
    // End of variables declaration//GEN-END:variables
}
