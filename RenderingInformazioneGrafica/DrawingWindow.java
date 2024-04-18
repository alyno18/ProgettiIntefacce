package RenderingInformazioneGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;

public class DrawingWindow extends JFrame{
    public DrawingWindow() {
        super("DrawingWindow");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        pack();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Color startColor = g.getColor();
        g.setColor(Color.magenta);
        g.drawRect(150, 150, 300, 200);
        g.setColor(Color.yellow);
        g.fillRect(160, 160, 280, 180);

        g.setColor(Color.black);
        g.fillRect(190, 190, 220, 120);

        g.setColor(Color.black);
        g.drawOval(470, 175, 300, 150);
        g.setColor(Color.pink);
        g.fillOval(470, 175, 300, 150);

        g.setColor(startColor);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DrawingWindow().setVisible(true);
            }
        });
    }
}
