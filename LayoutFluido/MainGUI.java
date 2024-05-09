package LayoutFluido;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainGUI extends JFrame {

    DrawingPanel drawPanel;

    public MainGUI() {
        super("Scalable drawing ...");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));

        this.drawPanel = new DrawingPanel();

        Container contPane = getContentPane();
        contPane.setLayout(new BorderLayout());

        contPane.add(drawPanel, BorderLayout.CENTER);

        pack();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run () {
                new MainGUI().setVisible(true);
            }
        });
    }
}
