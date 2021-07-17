package epminer_gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.RandomAccessFile;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class MainWindow {

    public MainWindow() {

        final JFrame mainWin = new JFrame("EPMiner");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        /*
         * double screenwidth = screenSize.getWidth(); double screenheight =
         * screenSize.getHeight(); mainWin.setExtendedState(mainWin.getExtendedState() |
         * JFrame.MAXIMIZED_BOTH);
         */

        Container mainContainer = mainWin.getContentPane();
        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));

        JPanel mainPanel = new JPanel();
        mainContainer.add(mainPanel);
        mainPanel.setLayout(new GridLayout(0, 1));
        mainPanel.setPreferredSize(new DimensionUIResource(800, 600));

        JLabel mainTitle = new JLabel("Benvenuto in EPMiner! ");
        mainPanel.add(mainTitle);
        mainTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        mainTitle.setBorder(new EmptyBorder(5, 10, 0, 0));

        JLabel epDescription = new JLabel(
                "<html> Trovare tutte i pattern emergenti che siano frequenti (supporto maggiore o uguale di minS) in Dtarget e emergenti (grow rate maggiore uguale di minGr) rispetto a DBackground </html>");
        mainPanel.add(epDescription);
        epDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
        epDescription.setBorder(new EmptyBorder(0, 10, 0, 10));

        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));

        mainPanel.add(info);

        TitledBorder radioBorder = new TitledBorder("Seleziona la modalita' ");
        radioBorder.setTitleFont(new Font("Tahoma", Font.BOLD, 15));
        info.setBorder(new CompoundBorder(new EmptyBorder(5, 10, 10, 10), radioBorder));

        JRadioButton choose1 = new JRadioButton("Nuova scoperta ");
        JRadioButton choose2 = new JRadioButton("Risultati in archivio ");

        choose1.setBounds(75, 50, 100, 30);
        choose2.setBounds(75, 100, 100, 30);

        ButtonGroup bg_radio = new ButtonGroup();
        bg_radio.add(choose1);
        bg_radio.add(choose2);
        info.add(choose1);
        info.add(choose2);

        JPanel buttonPanel = new JPanel();
        mainPanel.add(buttonPanel);

        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(new EmptyBorder(15, 0, 0, 10));

        JButton goBtn = new JButton("VAI");
        buttonPanel.add(goBtn);

        goBtn.setPreferredSize(new DimensionUIResource(150, 70));

        goBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InputWindow();
            }
        }

        );

        mainWin.pack();
        mainWin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainWin.setLocationRelativeTo(null);
        mainWin.setResizable(false);
        mainWin.setVisible(true);

    }

}