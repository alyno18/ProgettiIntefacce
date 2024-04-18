package RenderingInformazioneGrafica;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BasicDrawer extends JFrame{
    public BasicDrawer() {
        super("BasicDrawer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        Container contPane = getContentPane();
        contPane.add(new DrawingCanvas() ,BorderLayout.CENTER);
        pack();
    }

    class DrawingCanvas extends JPanel{
        public DrawingCanvas(){
            super();
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            draw(g);
        }
    }

    private void draw (Graphics g){
        g.drawLine(200, 200, 100, 100);
        g.fillOval(210, 210, 100, 100);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BasicDrawer().setVisible(true);
            }
        });
    }
}
