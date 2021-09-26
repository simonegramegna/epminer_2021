import java.io.IOException;
import java.util.LinkedList;
import java.util.Arrays;
import java.io.ObjectOutputStream;

// swing
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
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.WindowConstants;

class WinOutEp extends JDialog {

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

    WinOutEp(Frame parent, boolean modal, String epMiner, String fpMiner, float minsup, float mingr, String target,
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

    private void setDisplayedInput(float minsup, float mingr, String target, String background) {

        minsoutLabel.setText(Float.toString(minsup));
        mingroutLabel.setText(Float.toString(mingr));
        targetoutLabel.setText(target);
        backgroundoutLabel.setText(background);
    }

    private void setDisplayedFpEp(DefaultListModel<String> model, String FpEp) {

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
        minsLabel.setText("minSup:");

        backgroundLabel.setFont(new Font("Arial", 0, 18));
        backgroundLabel.setForeground(new Color(30, 0, 255));
        backgroundLabel.setText("backgroundTable:");

        mingrLabel.setFont(new Font("Arial", 0, 18));
        mingrLabel.setForeground(new Color(30, 0, 255));
        mingrLabel.setText("minGr:");

        minsoutLabel.setFont(new Font("Arial", 0, 18));

        mingroutLabel.setFont(new Font("Arial", 0, 18));

        targetLabel.setFont(new Font("Arial", 0, 18));
        targetLabel.setForeground(new Color(30, 0, 255));
        targetLabel.setText("targetTable:");

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
        fpLabel.setText("FPMiner:");

        epLabel.setFont(new Font("Arial", 0, 18));
        epLabel.setForeground(new Color(30, 0, 255));
        epLabel.setText("EPMiner:");

        fpOut.setFont(new Font("Arial", 0, 12));
        fpScroll.setViewportView(fpOut);

        epOut.setFont(new Font("Arial", 0, 14));
        epScroll.setViewportView(epOut);

        targetoutLabel.setFont(new Font("Arial", 0, 18));

        backgroundoutLabel.setFont(new Font("Arial", 0, 18));

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
                GroupLayout.Alignment.TRAILING,
                mainPanelLayout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newEPbtn).addGap(340, 340, 340))
                .addGroup(mainPanelLayout.createSequentialGroup().addContainerGap()
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(fpScroll)
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(epLabel, GroupLayout.PREFERRED_SIZE, 74,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 736, Short.MAX_VALUE))
                                .addComponent(epScroll))
                        .addContainerGap())
                .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(mainPanelLayout.createSequentialGroup().addGap(39, 39, 39)
                                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(mainPanelLayout.createSequentialGroup().addGap(4, 4, 4)
                                                        .addComponent(backgroundLabel)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(backgroundoutLabel, GroupLayout.PREFERRED_SIZE,
                                                                470, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(mainPanelLayout.createSequentialGroup()
                                                        .addComponent(targetLabel, GroupLayout.PREFERRED_SIZE, 110,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(targetoutLabel, GroupLayout.PREFERRED_SIZE, 509,
                                                                GroupLayout.PREFERRED_SIZE))
                                                .addGroup(mainPanelLayout.createSequentialGroup()
                                                        .addComponent(minsLabel, GroupLayout.PREFERRED_SIZE, 76,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(minsoutLabel, GroupLayout.PREFERRED_SIZE, 100,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(mingrLabel, GroupLayout.PREFERRED_SIZE, 67,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addGap(26, 26, 26).addComponent(mingroutLabel,
                                                                GroupLayout.PREFERRED_SIZE, 166,
                                                                GroupLayout.PREFERRED_SIZE))))
                                .addGroup(mainPanelLayout.createSequentialGroup().addContainerGap().addComponent(
                                        fpLabel, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(mainSeparator, GroupLayout.Alignment.TRAILING));
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

    private void newEPbtnActionPerformed(ActionEvent evt) {

        try {
            winOutStream.writeObject('s');

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Errore nell'invio dei dati", "Errore", JOptionPane.ERROR_MESSAGE);
        }
        dispose();
    }

    public static void main(String args[]) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WinOutEp.class.getName()).log(Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            Logger.getLogger(WinOutEp.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            Logger.getLogger(WinOutEp.class.getName()).log(Level.SEVERE, null, ex);

        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(WinOutEp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
