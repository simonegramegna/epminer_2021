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

public class InputWindow {
    
    public InputWindow() {
        final JFrame mainWin = new JFrame("EPMiner");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        /*
        double screenwidth = screenSize.getWidth();
        double screenheight = screenSize.getHeight();
        mainWin.setExtendedState(mainWin.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        */

        Container mainContainer = mainWin.getContentPane();
        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));

        JPanel mainPanel = new JPanel();
        mainContainer.add(mainPanel);
        mainPanel.setLayout(new GridLayout(0, 1));
        mainPanel.setPreferredSize(new DimensionUIResource(400, 300));

        mainWin.pack();
        mainWin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainWin.setLocationRelativeTo(null);
        mainWin.setResizable(false);
        mainWin.setVisible(true);

    }

}