package Panel;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel{
    private final static int HORIZONTAL_GAP = 10;
    private final static int VERTICAL_GAP = 10;

    private AbstractDrawing dw = null;

    public DrawingPanel(AbstractDrawing dw) {
        super();
        this.dw = dw;
        updatePanelPreferredSize();
    }

    public void setDrawing(AbstractDrawing dw) {
        this.dw = dw;
        updatePanelPreferredSize();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        dw.draw(g);
    }

    private void updatePanelPreferredSize() {
        setPreferredSize(new Dimension(dw.getDrawingWidth() + HORIZONTAL_GAP, dw.getDrawingHeight() + VERTICAL_GAP));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(dw.getDrawingWidth() + HORIZONTAL_GAP, dw.getDrawingHeight() + VERTICAL_GAP);
    }
}
