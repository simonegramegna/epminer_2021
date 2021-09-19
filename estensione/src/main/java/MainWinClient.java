import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class MainWinClient extends javax.swing.JFrame {

    private Socket mainSocket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private WinInput mainInputPanel;

    private static int mainWidth = 500;
    private static int mainHeight = 400;
    
    private final static int newEpChoose = 1;
    private final static int fileChoose = 2;
    
    private final static int defaultPort = 5000;

    /**
     * Creates new form MainWinClient
     */
    public MainWinClient() throws IOException {

        initComponents();
        this.setResizable(false);
        this.setTitle("EpMiner2021");
        
        InetAddress addr = InetAddress.getByName("localhost");

        try {
            mainSocket = new Socket(addr, defaultPort);

        } catch (java.net.ConnectException e) {
            JOptionPane.showMessageDialog(null, "Connessione assente", "Errore", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        connectLabel.setText("Connesso sulla porta " + defaultPort);
        
        out = new ObjectOutputStream(mainSocket.getOutputStream());
        in = new ObjectInputStream(mainSocket.getInputStream());
        out.writeObject('s');
        
        mainInputPanel = new WinInput(in, out);
        mainInputPanel.setVisible(false);
    }

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

        mainPanel = new javax.swing.JPanel();
        mainTitle = new javax.swing.JLabel();
        startLabel = new javax.swing.JLabel();
        newEpBtn = new javax.swing.JButton();
        fileEpBtn = new javax.swing.JButton();
        quitBtn = new javax.swing.JButton();
        connectLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setPreferredSize(new java.awt.Dimension(500, 400));

        mainTitle.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        mainTitle.setForeground(new java.awt.Color(30, 0, 255));
        mainTitle.setText("Benvenuto in EpMiner!");

        startLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        startLabel.setText("   Inizia!");

        newEpBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        newEpBtn.setForeground(new java.awt.Color(191, 14, 14));
        newEpBtn.setText("Nuova Scoperta");
        newEpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEpBtnActionPerformed(evt);
            }
        });

        fileEpBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        fileEpBtn.setForeground(new java.awt.Color(0, 141, 14));
        fileEpBtn.setText("Risultati in archivio");
        fileEpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileEpBtnActionPerformed(evt);
            }
        });

        quitBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        quitBtn.setText("Esci");
        quitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitBtnActionPerformed(evt);
            }
        });

        connectLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        connectLabel.setForeground(new java.awt.Color(0, 141, 14));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(mainTitle))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(startLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fileEpBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(newEpBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(connectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(mainTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(newEpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(fileEpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(quitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(connectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fileEpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileEpBtnActionPerformed
       
        try {
            out.writeObject(fileChoose);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Errore nell'invio dei dati", "Errore", JOptionPane.ERROR_MESSAGE);
        }
        changePanel();
        this.setTitle("EpMiner2021 - EP da file");
    }//GEN-LAST:event_fileEpBtnActionPerformed

    private void newEpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEpBtnActionPerformed
        
        try {
            out.writeObject(newEpChoose);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Errore nell'invio dei dati", "Errore", JOptionPane.ERROR_MESSAGE);
        }
        changePanel();
        this.setTitle("EpMiner2021 - Nuovo EP");
    }//GEN-LAST:event_newEpBtnActionPerformed

    private void quitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitBtnActionPerformed
        
        if(JOptionPane.showConfirmDialog(rootPane,"Uscire dal programma?", "Epminer2021",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION ){
            
            if(mainSocket != null){
                try {
                    mainSocket.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Errore di chiusura della connessione", "Errore", JOptionPane.ERROR_MESSAGE);
                } 
            }
            dispose();
            System.exit(0);
        } 
    }//GEN-LAST:event_quitBtnActionPerformed

    private void changePanel(){
        
        mainPanel.setVisible(false);
        this.setContentPane(mainInputPanel);
        mainInputPanel.setVisible(true);
     }
    
    protected void resetMainPanel() {

        mainPanel.setVisible(true);
        this.setContentPane(mainPanel);
        this.setTitle("EpMiner2021");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
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
            java.util.logging.Logger.getLogger(MainWinClient.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWinClient.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWinClient.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWinClient.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainWinClient().setVisible(true);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Errore: IOException", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel connectLabel;
    private javax.swing.JButton fileEpBtn;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel mainTitle;
    private javax.swing.JButton newEpBtn;
    private javax.swing.JButton quitBtn;
    private javax.swing.JLabel startLabel;
    // End of variables declaration//GEN-END:variables
}
