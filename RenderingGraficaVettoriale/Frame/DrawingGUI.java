package RenderingGraficaVettoriale.Frame;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;

public class DrawingGUI extends JFrame{
    private AbstractDrawing dw;

    private final static int JFRAME_WIDTH = 800;
    private final static int JFRAME_HEIGHT = 600;

    public DrawingGUI(String title, AbstractDrawing dw) {
        super(title);
        this.dw = dw;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(JFRAME_WIDTH, JFRAME_HEIGHT));
        pack();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        dw.draw(g);
    }

    public static void main(String[] args) {

        final AbstractDrawing drawing = new ConcreteDrawing();

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DrawingGUI("Drawing GUI", drawing).setVisible(true);

            }
        });
    }
}
