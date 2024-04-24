package RenderingGraficaVettoriale.Frame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class ConcreteDrawing extends AbstractDrawing{
    private Rectangle2D.Double rect;

    public ConcreteDrawing() {
        this.rect = new Rectangle2D.Double(100, 100, 300, 300); // x, y, width, height
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        g2d.setColor(Color.red);
        g2d.fill(rect);
        g2d.setColor(Color.black);
        g2d.draw(rect);
    }
}
