import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionListener;

/**
 * Classe che rappresenta il pannello per 
 * l'inserimento degli input
 */
public class WinInput extends JPanel {

    private JComboBox<String> backgroundChoose;
    private JLabel backgroundLabel;
    private JButton btnInput;
    private JLabel grLabel;
    private JTextField inputGrowRate;
    private JTextField inputMinSup;
    private JSeparator mainSeparator;
    private JLabel supLabel;
    private JComboBox<String> targetChoose;
    private JLabel targetLabel;

    private ObjectInputStream panelIn;
    private ObjectOutputStream panelOut;

    /**
     * Crea il pannello 
     * @param in
     * @param out
     */
    public WinInput(ObjectInputStream in, ObjectOutputStream out) {

        initComponents();
        panelIn = in;
        panelOut = out;
    }

    private void initComponents() {

        supLabel = new JLabel();
        inputMinSup = new JTextField();
        grLabel = new JLabel();
        inputGrowRate = new JTextField();
        mainSeparator = new JSeparator();
        targetLabel = new JLabel();
        backgroundLabel = new JLabel();
        btnInput = new JButton();
        targetChoose = new JComboBox<>();
        backgroundChoose = new JComboBox<>();

        setPreferredSize(new Dimension(600, 500));

        supLabel.setFont(new Font("Arial", 0, 14)); // NOI18N
        supLabel.setText(" Valore di minimo supporto ");

        grLabel.setFont(new Font("Arial", 0, 14)); // NOI18N
        grLabel.setText("Valore minimo di Grow Rate");

        targetLabel.setFont(new Font("Arial", 0, 14)); // NOI18N
        targetLabel.setText("Tabella Target");

        backgroundLabel.setFont(new Font("Arial", 0, 14)); // NOI18N
        backgroundLabel.setText("Tabella Background");

        btnInput.setFont(new Font("Arial", 1, 14)); // NOI18N
        btnInput.setForeground(new Color(30, 0, 255));
        btnInput.setText("VAI!");
        btnInput.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                btnInputActionPerformed(evt);
            }
        });

        targetChoose.setFont(new Font("Arial", 0, 14)); // NOI18N
        targetChoose.setModel(new DefaultComboBoxModel<>(new String[] { "playtennisTarget" }));

        backgroundChoose.setFont(new Font("Arial", 0, 14)); // NOI18N
        backgroundChoose.setModel(new DefaultComboBoxModel<>(new String[] { "playtennisBackground" }));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainSeparator, GroupLayout.Alignment.TRAILING)
                        .addGroup(layout
                                .createSequentialGroup().addGroup(layout.createParallelGroup(
                                        GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup().addGap(24, 24, 24).addGroup(layout
                                                .createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(backgroundLabel, GroupLayout.PREFERRED_SIZE, 154,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(backgroundChoose, GroupLayout.PREFERRED_SIZE, 333,
                                                                GroupLayout.PREFERRED_SIZE))
                                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(targetLabel, GroupLayout.PREFERRED_SIZE, 154,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(targetChoose, 0, GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup().addGap(32, 32, 32)
                                                                .addComponent(grLabel))
                                                        .addGroup(layout.createSequentialGroup().addGap(20, 20, 20)
                                                                .addComponent(supLabel)))
                                                .addGap(35, 35, 35)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(inputGrowRate, GroupLayout.PREFERRED_SIZE, 175,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(inputMinSup, GroupLayout.PREFERRED_SIZE, 176,
                                                                GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup().addGap(210, 210, 210).addComponent(
                                                btnInput, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(79, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(supLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                .addComponent(inputMinSup, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(inputGrowRate, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addComponent(grLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mainSeparator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(targetLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup().addGap(8, 8, 8).addComponent(targetChoose)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(backgroundLabel, GroupLayout.PREFERRED_SIZE, 38,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(backgroundChoose, GroupLayout.PREFERRED_SIZE, 29,
                                        GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addComponent(btnInput, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160)));
    }

    /**
     *  Definisce il comportamento del bottone per inviare gli input
     * @param evt
     */
    protected void btnInputActionPerformed(ActionEvent evt) {

        float sentMinSup = -1;
        float sentMinGrow = -1;

        String minSup = inputMinSup.getText();
        String minGrow = inputGrowRate.getText();
        String sentTargetTable = (String) targetChoose.getSelectedItem();
        String sentBackgroundTable = (String) backgroundChoose.getSelectedItem();

        if (minSup.equals("")) {

            JOptionPane.showMessageDialog(null, "Inserire un valore di minimo supporto", "Errore",
                    JOptionPane.ERROR_MESSAGE);
        } else {

            if (isNumber(minSup)) {

                if (getNumber(minSup) <= 0 || getNumber(minSup) > 1) {

                    JOptionPane.showMessageDialog(null, "Inserire un valore compreso tra 0 e 1", "Errore",
                            JOptionPane.ERROR_MESSAGE);
                    inputMinSup.setText("");
                } else {
                    sentMinSup = getNumber(minSup);
                }
            }
        }
        if (minGrow.equals("")) {

            JOptionPane.showMessageDialog(null, "Inserire un valore di grow rate", "Errore", JOptionPane.ERROR_MESSAGE);
        } else {
            if (isNumber(minGrow)) {

                if (getNumber(minGrow) <= 0) {

                    JOptionPane.showMessageDialog(null, "Inserire un valore strettamente maggiore di 0", "Errore",
                            JOptionPane.ERROR_MESSAGE);
                    inputGrowRate.setText("");
                } else {
                    sentMinGrow = getNumber(minGrow);
                }
            }
        }

        if ((sentMinSup > 0 && sentMinSup <= 1) && sentMinGrow > 0) {
            try {
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

                WinOutEp dialog = new WinOutEp(new JFrame(), true, epMiner, fpMiner, sentMinSup, sentMinGrow,
                        sentTargetTable, sentBackgroundTable, fpMiner, epMiner, panelOut);

                dialog.addWindowListener(new WindowAdapter() {

                    @Override
                    public void windowClosing(WindowEvent e) {
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
    }

    private void resetInput() {

        inputGrowRate.setText("");
        inputMinSup.setText("");
    }

    private boolean isNumber(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private float getNumber(String str) {

        return Float.parseFloat(str);
    }
}
