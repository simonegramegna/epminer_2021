import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.ConnectException;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;

/**
 * Classe per creare la finestra principale
 */
public class MainWinClient extends JFrame {

    private JLabel connectLabel;
    private JButton fileEpBtn;
    private JPanel mainPanel;
    private JLabel mainTitle;
    private JButton newEpBtn;
    private JButton quitBtn;
    private JLabel startLabel;

    private Socket mainSocket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private WinInput mainInputPanel;

    private static int mainWidth = 500;
    private static int mainHeight = 400;
    private final static int newEpChoose = 1;
    private final static int fileChoose = 2;
    private final static int defaultPort = 8080;

    /**
     * Crea la finestra principale
     * 
     * @throws IOException
     */
    public MainWinClient() throws IOException {

        initComponents();
        this.setResizable(false);
        this.setTitle("EpMiner2021");

        InetAddress addr = InetAddress.getByName("localhost");

        try {
            mainSocket = new Socket(addr, defaultPort);

        } catch (ConnectException e) {
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

    private void initComponents() {

        mainPanel = new JPanel();
        mainTitle = new JLabel();
        startLabel = new JLabel();
        newEpBtn = new JButton();
        fileEpBtn = new JButton();
        quitBtn = new JButton();
        connectLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setPreferredSize(new java.awt.Dimension(500, 400));

        mainTitle.setFont(new Font("Arial", 0, 36));
        mainTitle.setForeground(new Color(30, 0, 255));
        mainTitle.setText("Benvenuto in EpMiner!");

        startLabel.setFont(new Font("Arial", 0, 18));
        startLabel.setText("   Inizia!");

        newEpBtn.setFont(new Font("Arial", 1, 14));
        newEpBtn.setForeground(new Color(191, 14, 14));
        newEpBtn.setText("Nuova Scoperta");
        newEpBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {

                newEpBtnActionPerformed(evt);
            }
        });

        fileEpBtn.setFont(new Font("Arial", 1, 14));
        fileEpBtn.setForeground(new Color(0, 141, 14));
        fileEpBtn.setText("Risultati in archivio");
        fileEpBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {

                fileEpBtnActionPerformed(evt);
            }
        });

        quitBtn.setFont(new Font("Arial", 1, 14));
        quitBtn.setText("Esci");
        quitBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {

                quitBtnActionPerformed(evt);
            }
        });

        connectLabel.setFont(new Font("Arial", 0, 14));
        connectLabel.setForeground(new Color(0, 141, 14));

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        
        mainPanelLayout.setHorizontalGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup().addGroup(mainPanelLayout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup().addGap(109, 109, 109).addComponent(mainTitle))
                        .addGroup(mainPanelLayout.createSequentialGroup().addGap(245, 245, 245).addComponent(startLabel,
                                GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                        .addGroup(mainPanelLayout.createSequentialGroup().addGap(180, 180, 180)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(fileEpBtn, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                        .addComponent(newEpBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(quitBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)))
                        .addGroup(mainPanelLayout.createSequentialGroup().addContainerGap().addComponent(connectLabel,
                                GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(135, Short.MAX_VALUE)));

        mainPanelLayout.setVerticalGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup().addGap(27, 27, 27)
                        .addComponent(mainTitle, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(startLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(newEpBtn, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(fileEpBtn, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(quitBtn, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(connectLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE)));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainPanel,
                GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainPanel,
                GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE));

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Definisce il comportamento del bottone per richiedere una computazione già
     * esistente in archivvio
     * 
     * @param evt
     */
    protected void fileEpBtnActionPerformed(ActionEvent evt) {

        try {
            out.writeObject(fileChoose);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Errore nell'invio dei dati", "Errore", JOptionPane.ERROR_MESSAGE);
        }
        changePanel();
        this.setTitle("EpMiner2021 - EP da file");
    }

    /**
     * Definisce il comportamento del bottone per richiedere una nuova computazione
     * 
     * @param evt
     */
    protected void newEpBtnActionPerformed(ActionEvent evt) {

        try {
            out.writeObject(newEpChoose);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Errore nell'invio dei dati", "Errore", JOptionPane.ERROR_MESSAGE);
        }
        changePanel();
        this.setTitle("EpMiner2021 - Nuovo EP");
    }

    /**
     * Definisce il comportamento del bottone per uscire dal programma
     * 
     * @param evt
     */
    protected void quitBtnActionPerformed(ActionEvent evt) {

        if (JOptionPane.showConfirmDialog(rootPane, "Uscire dal programma?", "Epminer2021", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

            if (mainSocket != null) {
                try {
                    mainSocket.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Errore di chiusura della connessione", "Errore",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            dispose();
            System.exit(0);
        }
    }

    private void changePanel() {

        mainPanel.setVisible(false);
        this.setContentPane(mainInputPanel);
        mainInputPanel.setVisible(true);
    }

    /**
     * Metodo per resettare il pannello principale
     */
    protected void resetMainPanel() {

        mainPanel.setVisible(true);
        this.setContentPane(mainPanel);
        this.setTitle("EpMiner2021");
    }

    public static void main(String args[]) throws IOException {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {

                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ClassNotFoundException", "Errore", JOptionPane.ERROR_MESSAGE);

        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, "InstantiationException", "Errore", JOptionPane.ERROR_MESSAGE);

        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "IllegalAccessException", "Errore", JOptionPane.ERROR_MESSAGE);

        } catch (UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, "UnsupportedLookAndFeelException", "Errore", JOptionPane.ERROR_MESSAGE);
        }

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new MainWinClient().setVisible(true);

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Errore: IOException", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
