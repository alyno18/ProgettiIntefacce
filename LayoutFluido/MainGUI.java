package LayoutFluido;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;

public class MainGUI extends JFrame implements ComponentListener {

    DrawingPanel drawPanel;

    public MainGUI() {
        super("Scalable drawing ...");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        addComponentListener(this);

        this.drawPanel = new DrawingPanel();

        Container contPane = getContentPane();
        contPane.setLayout(new BorderLayout());

        contPane.add(drawPanel, BorderLayout.CENTER);

        pack();
    }

    public void componentHidden(ComponentEvent e) {
        //do-nothing
    }

    public void componentMoved(ComponentEvent e) {
        //do-nothing
    }

    public void componentResized(ComponentEvent e) {
        this.drawPanel.setGridUnit();
    }

    public void componentShown(ComponentEvent e) {
        //do-nothing
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run () {
                new MainGUI().setVisible(true);
            }
        });
    }
}
