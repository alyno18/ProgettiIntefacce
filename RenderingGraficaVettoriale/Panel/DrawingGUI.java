package Panel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

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
