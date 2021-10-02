import java.io.IOException;
import java.util.LinkedList;
import java.util.Arrays;
import java.io.ObjectOutputStream;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.GroupLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager.*;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 *  Classe che rappresenta la finestra di dialogo per mostrare i pattern frequenti e 
 *  i pattern emergenti
 */
public class WinOutEp extends JDialog {

    private JLabel epLabel;
    private JList<String> epOut;
    private JScrollPane epScroll;
    private JList<String> fpOut;
    private JScrollPane fpScroll;
    private JLabel backgroundLabel;
    private JLabel backgroundoutLabel;
    private JLabel fpLabel;
    private JSeparator mainSeparator;
    private JPanel mainPanel;
    private JLabel mingrLabel;
    private JLabel mingroutLabel;
    private JLabel minsLabel;
    private JLabel minsoutLabel;
    private JButton newEPbtn;
    private JLabel targetLabel;
    private JLabel targetoutLabel;

    private DefaultListModel<String> modelEP;
    private DefaultListModel<String> modelFP;
    private ObjectOutputStream winOutStream;

    /**
     * 
     *  Crea la finestra di dialogo
     * 
     * @param parent
     * @param modal
     * @param epMiner
     * @param fpMiner
     * @param minsup
     * @param mingr
     * @param target
     * @param background
     * @param fp
     * @param ep
     * @param out
     */
    public WinOutEp(Frame parent, boolean modal, String epMiner, String fpMiner, float minsup, float mingr, String target,
            String background, String fp, String ep, ObjectOutputStream out) {

        super(parent, modal);

        modelEP = new DefaultListModel<>();
        modelFP = new DefaultListModel<>();
        initComponents();

        this.setResizable(false);
        this.setDisplayedInput(minsup, mingr, target, background);
        this.setTitle("EP: mingr: " + mingr + " minsup: " + minsup);

        setDisplayedFpEp(modelFP, fp);
        setDisplayedFpEp(modelEP, ep);
        winOutStream = out;
    }

    /**
     *  Imposta l'output mostrato
     * @param minsup
     * @param mingr
     * @param target
     * @param background
     */
    protected void setDisplayedInput(float minsup, float mingr, String target, String background) {

        minsoutLabel.setText(Float.toString(minsup));
        mingroutLabel.setText(Float.toString(mingr));
        targetoutLabel.setText(target);
        backgroundoutLabel.setText(background);
    }

    /**
     * Rende visibili nell'interfaccia i pattern frequenti 
     * e i pattern emergenti nel pannello
     * @param model
     * @param FpEp
     */
    protected void setDisplayedFpEp(DefaultListModel<String> model, String FpEp) {

        LinkedList<String> outputList = new LinkedList<String>(Arrays.asList(FpEp.split("\n")));

        outputList.forEach(outEPFP -> {
            model.addElement(outEPFP);
        });
    }

    private void initComponents() {

        mainPanel = new JPanel();
        minsLabel = new JLabel();
        backgroundLabel = new JLabel();
        mingrLabel = new JLabel();
        minsoutLabel = new JLabel();
        mingroutLabel = new JLabel();
        targetLabel = new JLabel();
        mainSeparator = new JSeparator();
        newEPbtn = new JButton();
        fpLabel = new JLabel();
        epLabel = new JLabel();
        fpScroll = new JScrollPane();
        fpOut = new JList<>(modelFP);
        epScroll = new JScrollPane();
        epOut = new JList<>(modelEP);
        targetoutLabel = new JLabel();
        backgroundoutLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        minsLabel.setFont(new Font("Arial", 0, 18));
        minsLabel.setForeground(new Color(30, 0, 255));
        minsLabel.setText("min Supporto:");

        backgroundLabel.setFont(new Font("Arial", 0, 18));
        backgroundLabel.setForeground(new Color(30, 0, 255));
        backgroundLabel.setText("Tabella Background:");

        mingrLabel.setFont(new Font("Arial", 0, 18));
        mingrLabel.setForeground(new Color(30, 0, 255));
       mingrLabel.setText("min Grow rate:");

        minsoutLabel.setFont(new Font("Arial", 0, 18));

        mingroutLabel.setFont(new Font("Arial", 0, 18));

        targetLabel.setFont(new Font("Arial", 0, 18));
        targetLabel.setForeground(new Color(30, 0, 255));
        targetLabel.setText("Tabella Target:");

        newEPbtn.setFont(new Font("Arial", 1, 14));
        newEPbtn.setForeground(new Color(0, 141, 14));
        newEPbtn.setText("Nuova Computazione");
        newEPbtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                newEPbtnActionPerformed(evt);
            }
        });

        fpLabel.setFont(new Font("Arial", 0, 18));
        fpLabel.setForeground(new Color(30, 0, 255));
        fpLabel.setText("Pattern Frequenti:");

        epLabel.setFont(new Font("Arial", 0, 18));
        epLabel.setForeground(new Color(30, 0, 255));
        epLabel.setText("Pattern Emergenti:");

        fpOut.setFont(new Font("Arial", 0, 12));
        fpScroll.setViewportView(fpOut);

        epOut.setFont(new Font("Arial", 0, 14));
        epScroll.setViewportView(epOut);

        targetoutLabel.setFont(new Font("Arial", 0, 18));

        backgroundoutLabel.setFont(new Font("Arial", 0, 18));

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);

        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newEPbtn)
                .addGap(340, 340, 340))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fpScroll)
                    .addComponent(epScroll)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(epLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(mainSeparator, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(backgroundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(backgroundoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(targetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(targetoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(minsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minsoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(mingrLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mingroutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(fpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(140, Short.MAX_VALUE))
        );

        mainPanelLayout.setVerticalGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup().addGap(22, 22, 22)
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(mingrLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(minsoutLabel, GroupLayout.PREFERRED_SIZE, 22,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minsLabel))
                                .addComponent(mingroutLabel, GroupLayout.PREFERRED_SIZE, 26,
                                        GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(targetLabel).addComponent(targetoutLabel, GroupLayout.PREFERRED_SIZE, 24,
                                        GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(backgroundLabel, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                                .addComponent(backgroundoutLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mainSeparator, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fpLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(fpScroll, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(epLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(epScroll, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(newEPbtn, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainPanel,
                GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainPanel,
                GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
        setLocationRelativeTo(null);
    }
    
    /**
     * Definisce il comportamento del bottone per la nuova computazione
     * @param evt
     */
    protected void newEPbtnActionPerformed(ActionEvent evt) {

        try {
            winOutStream.writeObject('s');

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Errore nell'invio dei dati", "Errore", JOptionPane.ERROR_MESSAGE);
        }
        dispose();
    }

    /**
     * Metodo main per eseguire la finestra
     * @param args
     */
    public static void main(String args[]) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
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
    }
}
