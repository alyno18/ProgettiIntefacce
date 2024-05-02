package GestioneAnimazioni;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel implements ActionListener{
    private final static int HORIZONTAL_GAP = 10;
    private final static int VERTICAL_GAP = 10;

    private AbstractDrawing dw = null;

    public DrawingPanel(AbstractDrawing dw) {
        super();
        this.dw = dw;
    }

    public void setDrawing(AbstractDrawing dw) {
        this.dw = dw;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        dw.draw(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(dw.getDrawingWidth() + HORIZONTAL_GAP, dw.getDrawingHeight() + VERTICAL_GAP);
    }

    public void actionPerformed(ActionEvent e) {
        this.dw.updateDrawing();
        this.repaint();
    }
}
