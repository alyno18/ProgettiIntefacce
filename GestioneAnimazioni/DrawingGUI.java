package GestioneAnimazioni;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.Timer;

public class DrawingGUI extends JFrame{
    private final static int JFRAME_WIDTH = 800;
    private final static int JFRAME_HEIGHT = 600;

    public DrawingGUI(String title, AbstractDrawing dw) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(JFRAME_WIDTH, JFRAME_HEIGHT));

        DrawingPanel drawPanel = new DrawingPanel(dw);

        JScrollPane scrollPane = new JScrollPane(drawPanel);

        Container contPane = getContentPane();
        contPane.setLayout(new BorderLayout());
        contPane.add(scrollPane, BorderLayout.CENTER);

        pack();

        int delay = 10; // milliseconds
        Timer timer = new Timer(delay, drawPanel);
        timer.start();
    }

    public static void main(String[] args) {

        double x = 20;
        double y = 60;
        double w = 600;
        double h = 300;
        final AbstractDrawing drawing = new RettangoloForato(x, y, w, h);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DrawingGUI("Drawing GUI", drawing).setVisible(true);

            }
        });
    }
}
