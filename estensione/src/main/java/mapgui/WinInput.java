/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapgui;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 *
 * @author User
 */
public class WinInput extends javax.swing.JPanel {

    private ObjectInputStream panelIn;
    private ObjectOutputStream panelOut;

    /**
     * Creates new form Win2
     */
    public WinInput(ObjectInputStream in, ObjectOutputStream out) {
        initComponents();
        panelIn = in;
        panelOut = out;
    }

    private static String availableTables[] = { "playtennisbackground", "playtennistarget" };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        supLabel = new javax.swing.JLabel();
        inputMinSup = new javax.swing.JTextField();
        grLabel = new javax.swing.JLabel();
        inputGrowRate = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        targetLabel = new javax.swing.JLabel();
        targetInput = new javax.swing.JTextField();
        backgroundLabel = new javax.swing.JLabel();
        backgroundInput = new javax.swing.JTextField();
        detailBtn = new javax.swing.JButton();
        btnInput = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(600, 500));

        supLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        supLabel.setText(" Valore di minimo supporto ");

        grLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        grLabel.setText("Valore minimo di Grow Rate");

        inputGrowRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputGrowRateActionPerformed(evt);
            }
        });

        targetLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        targetLabel.setText("Tabella Target");

        targetInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                targetInputActionPerformed(evt);
            }
        });

        backgroundLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        backgroundLabel.setText("Tabella Background");

        detailBtn.setText("Visualizza tabelle presenti");
        detailBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailBtnActionPerformed(evt);
            }
        });

        btnInput.setText("VAI!");
        btnInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(detailBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInput, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(backgroundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(backgroundInput, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(targetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(targetInput))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(grLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(supLabel)))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputGrowRate, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputMinSup, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(supLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputMinSup, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputGrowRate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(targetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(targetInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backgroundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backgroundInput, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detailBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInput, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void targetInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_targetInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_targetInputActionPerformed

    private String getInfoTableMessage() {
        return "Le tabelle presenti sono: \n"
                + java.util.Arrays.toString(availableTables).replace("]", "").replace("[", "");
    }

    private void inputGrowRateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_inputGrowRateActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_inputGrowRateActionPerformed

    private void btnInputActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnInputActionPerformed

        String minSup = inputMinSup.getText();
        String minGrow = inputGrowRate.getText();
        String targetTable = targetInput.getText();
        String backgroundTable = backgroundInput.getText();

        float sentMinSup = -1;
        float sentMinGrow = -1;
        String sentTargetTable = "";
        String sentBackgroundTable = "";

        if (minSup.equals("")) {
            JOptionPane.showMessageDialog(null, "Inserire un valore di minimo supporto", "Errore",
                    JOptionPane.ERROR_MESSAGE);
        } else {

            if (Utils.isNumber(minSup)) {

                if (Utils.getNumber(minSup) <= 0 || Utils.getNumber(minSup) > 1) {
                    JOptionPane.showMessageDialog(null, "Inserire un valore compreso tra 0 e 1", "Errore",
                            JOptionPane.ERROR_MESSAGE);
                    inputMinSup.setText("");
                } else {
                    sentMinSup = Utils.getNumber(minSup);
                }
            }
        }
        if (minGrow.equals("")) {
            JOptionPane.showMessageDialog(null, "Inserire un valore di grow rate", "Errore", JOptionPane.ERROR_MESSAGE);
        } else {

            if (Utils.isNumber(minGrow)) {

                if (Utils.getNumber(minGrow) <= 0) {
                    JOptionPane.showMessageDialog(null, "Inserire un valore strettamente maggiore di 0", "Errore",
                            JOptionPane.ERROR_MESSAGE);
                    inputGrowRate.setText("");
                } else {
                    sentMinGrow = Utils.getNumber(minGrow);
                }
            }
        }

        if (targetTable.equals("")) {
            JOptionPane.showMessageDialog(null, "Inserire per la tabella target", "Errore", JOptionPane.ERROR_MESSAGE);

            targetInput.setText("");
        } else {

            if (Utils.checkStringArray(availableTables, targetTable)) {

                sentTargetTable = targetTable;
            } else {
                JOptionPane.showMessageDialog(null, "La tabella inserita non e' presente tra le tabelle", "Errore",
                        JOptionPane.ERROR_MESSAGE);
                targetInput.setText("");
            }
        }

        if (backgroundTable.equals("")) {
            JOptionPane.showMessageDialog(null, "Inserire per la tabella target", "Errore", JOptionPane.ERROR_MESSAGE);

            backgroundInput.setText("");
        } else {

            if (Utils.checkStringArray(availableTables, backgroundTable)) {

                sentBackgroundTable = backgroundTable;
            } else {
                JOptionPane.showMessageDialog(null, "La tabella inserita non e' presente tra le tabelle", "Errore",
                        JOptionPane.ERROR_MESSAGE);
                backgroundInput.setText("");
            }
        }

        if ((sentMinSup > 0 && sentMinSup <= 1) && (sentMinGrow > 0)
                && Utils.checkStringArray(availableTables, sentBackgroundTable)
                && Utils.checkStringArray(availableTables, sentTargetTable)) {

            try{
                panelOut.writeObject(sentMinSup);
                panelOut.writeObject(sentMinGrow);
                panelOut.writeObject(sentTargetTable);
                panelOut.writeObject(sentBackgroundTable);

                String fpMiner = (String) (panelIn.readObject());
                String epMiner = (String) (panelIn.readObject());
                
                resetInput();
                this.setVisible(false);
                MainWinClient topFrame = (MainWinClient) SwingUtilities.getWindowAncestor(this);
                topFrame.resetMainPanel();
                
             WinOutEp dialog = new WinOutEp(new javax.swing.JFrame(), true, epMiner, fpMiner, sentMinSup, sentMinGrow, sentTargetTable, sentBackgroundTable, fpMiner, epMiner);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Errore invio dei dati ", "Qualcosa e' andato storto ",
                JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Errore invio dei dati ", "Qualcosa e' andato storto ",
                JOptionPane.ERROR_MESSAGE);
            }
        
          
        } else {
            JOptionPane.showMessageDialog(null, "I valori inseriti non sono validi ", "Qualcosa e' andato storto ",
                    JOptionPane.ERROR_MESSAGE);
        }

    }// GEN-LAST:event_btnInputActionPerformed

    private void detailBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_detailBtnActionPerformed

        JOptionPane.showMessageDialog(this, getInfoTableMessage());
    }// GEN-LAST:event_detailBtnActionPerformed
    
    private void resetInput(){
        
        backgroundInput.setText("");
        inputGrowRate.setText("");
        inputMinSup.setText("");
        targetInput.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField backgroundInput;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JButton btnInput;
    private javax.swing.JButton detailBtn;
    private javax.swing.JLabel grLabel;
    private javax.swing.JTextField inputGrowRate;
    private javax.swing.JTextField inputMinSup;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel supLabel;
    private javax.swing.JTextField targetInput;
    private javax.swing.JLabel targetLabel;
    // End of variables declaration//GEN-END:variables
}
