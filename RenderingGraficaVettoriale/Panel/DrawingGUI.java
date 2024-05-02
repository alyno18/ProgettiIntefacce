package Panel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class DrawingGUI extends JFrame implements ActionListener{
    private final static int JFRAME_WIDTH = 800;
    private final static int JFRAME_HEIGHT = 600;

    private final static String ZOOM_IN = "zoom in";
    private final static String ZOOM_OUT = "zoom out";
    private final static double[] SCALE_FACTOR_ARRAY = {0.01, 0.025, 0.05, 0.10, 0.25, 0.50, 0.75,
                            1.00, 1.25, 1.50, 1.75, 2.00, 4.00, 8.00,
                            16.00, 24.00, 32.00, 64.00};
    private final static int DEFAULT_SCALE_INDEX = 7;

    private int scaleIndex;
    private DrawingPanel drawPanel;
    private JTextArea zoomScale = new JTextArea();

    public DrawingGUI(String title, AbstractDrawing dw) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(JFRAME_WIDTH, JFRAME_HEIGHT));

        this.scaleIndex = DEFAULT_SCALE_INDEX;

        JToolBar toolBar = new JToolBar("Still draggable");
        addButtons(toolBar);
        toolBar.add(zoomScale);
        zoomScale.setEditable(false);
        zoomScale.setFont(new Font("Serif", Font.PLAIN, 16));

        this.drawPanel = new DrawingPanel(dw);

        JScrollPane scrollPane = new JScrollPane(drawPanel);

        Container contPane = getContentPane();
        contPane.setLayout(new BorderLayout());
        contPane.add(scrollPane, BorderLayout.CENTER);
        contPane.add(toolBar, BorderLayout.PAGE_START);

        pack();
    }

    private void addButtons(JToolBar toolBar) {
        // Insert the "zoom in" button.
        JButton zoomIn = new JButton();
        try {
            ImageIcon imageIcon = new ImageIcon("RenderingGraficaVettoriale\\Panel\\zoomIn.png");
            Image image = imageIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            zoomIn.setIcon(imageIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }
        zoomIn.addActionListener(this);
        zoomIn.setActionCommand(ZOOM_IN);
        toolBar.add(zoomIn);

        // Insert the "zoom out" button.
        JButton zoomOut = new JButton();
        try {
            ImageIcon imageIcon = new ImageIcon("RenderingGraficaVettoriale\\Panel\\zoomOut.png");
            Image image = imageIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
            imageIcon = new ImageIcon(image);
            zoomOut.setIcon(imageIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }
        zoomOut.addActionListener(this);
        zoomOut.setActionCommand(ZOOM_OUT);
        toolBar.add(zoomOut);
    }

    private void zoomIn() {
        if ((this.scaleIndex + 1) < SCALE_FACTOR_ARRAY.length) {
            this.scaleIndex++;
            this.drawPanel.setScaleFactor(SCALE_FACTOR_ARRAY[this.scaleIndex]);
        }
    }

    private void zoomOut() {
        if ((this.scaleIndex - 1) > 0) {
            this.scaleIndex--;
            this.drawPanel.setScaleFactor(SCALE_FACTOR_ARRAY[this.scaleIndex]);
        }
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        // Handle each button.
        if (ZOOM_IN.equals(cmd)) { // "zoom in" button clicked
            zoomIn();
            zoomScale.setText((SCALE_FACTOR_ARRAY[this.scaleIndex]*100) + "%");
            drawPanel.revalidate();
            drawPanel.repaint();
        }
        else if (ZOOM_OUT.equals(cmd)) { // "zoom out" button clicked
            zoomOut();
            zoomScale.setText((SCALE_FACTOR_ARRAY[this.scaleIndex]*100) + "%");
            drawPanel.revalidate();
            drawPanel.repaint();
        }
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
