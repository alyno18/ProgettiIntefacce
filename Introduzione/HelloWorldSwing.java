package Introduzione;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Color;


public class HelloWorldSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("HelloWorldSwingGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(new Dimension(800, 500));

        JLabel label = new JLabel("Hello World");
        Container contPane = frame.getContentPane();

        Color colore1 = new Color (206,0,255);
        Color colore2 = new Color (0,211,255);

        contPane.add(label);
        contPane.setBackground(colore1);
        label.setForeground(colore2);
        frame.setVisible(true);
    }
}
