/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapgui;

/**
 *
 * @author User
 */
public class WinOut extends javax.swing.JPanel {

    private String epMiner;
    private String fpMiner;
    private float minSup;
    private float minGrow;
    private String targetTable;
    private String backgroundTable;

    /**
     * Creates new form WinOut
     */
    public WinOut(String ep, String fp, float mins, float mingr, String target, String background) {
        
        epMiner = ep;
        fpMiner = fp;
        minSup = mins;
        minGrow = mingr;
        targetTable = target;
        backgroundTable = background;

        initComponents();

        minsoutLabel.setText(Float.toString(mins));
        mingroutLabel.setText(Float.toString(mingr));
        targetoutLabel.setText(targetTable);
        backgroundoutLabel.setText(backgroundTable);

        outLabel.setText(ep + "\n\n" + fp);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        outLabel = new javax.swing.JLabel();
        minsLabel = new javax.swing.JLabel();
        mingrLabel = new javax.swing.JLabel();
        targetLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();
        minsoutLabel = new javax.swing.JLabel();
        mingroutLabel = new javax.swing.JLabel();
        targetoutLabel = new javax.swing.JLabel();
        backgroundoutLabel = new javax.swing.JLabel();
        newEPBtn = new javax.swing.JButton();
        quitBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(600, 500));

        jScrollPane1.setViewportView(outLabel);

        minsLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        minsLabel.setForeground(new java.awt.Color(30, 0, 255));
        minsLabel.setText("minSup:");

        mingrLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        mingrLabel.setForeground(new java.awt.Color(30, 0, 255));
        mingrLabel.setText("minGr:");

        targetLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        targetLabel.setForeground(new java.awt.Color(30, 0, 255));
        targetLabel.setText("targetTable:");

        backgroundLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        backgroundLabel.setForeground(new java.awt.Color(30, 0, 255));
        backgroundLabel.setText("backgroundTable:");

        minsoutLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        mingroutLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        targetoutLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        backgroundoutLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        newEPBtn.setText("Nuova Computazione");
        newEPBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEPBtnActionPerformed(evt);
            }
        });

        quitBtn.setText("Esci");
        quitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(newEPBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(minsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minsoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(mingrLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mingroutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(targetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(targetoutLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backgroundLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(backgroundoutLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                        .addContainerGap())))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minsLabel)
                    .addComponent(mingrLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minsoutLabel)
                    .addComponent(mingroutLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(targetLabel)
                    .addComponent(targetoutLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backgroundLabel)
                    .addComponent(backgroundoutLabel))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(newEPBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newEPBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEPBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newEPBtnActionPerformed

    private void quitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quitBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel backgroundoutLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel mingrLabel;
    private javax.swing.JLabel mingroutLabel;
    private javax.swing.JLabel minsLabel;
    private javax.swing.JLabel minsoutLabel;
    private javax.swing.JButton newEPBtn;
    private javax.swing.JLabel outLabel;
    private javax.swing.JButton quitBtn;
    private javax.swing.JLabel targetLabel;
    private javax.swing.JLabel targetoutLabel;
    // End of variables declaration//GEN-END:variables
}
