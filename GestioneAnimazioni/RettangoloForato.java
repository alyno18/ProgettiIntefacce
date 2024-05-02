package GestioneAnimazioni;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class RettangoloForato extends AbstractDrawing{
    private Rectangle2D.Double rect;
    private Ellipse2D.Double ell;
    private boolean isExpanding; // expansion direction is sx -> dx, compression direction is sx <- dx
    private double xStep;
    private double xMinEll;
    private double xMaxEll;

    public RettangoloForato(double x, double y, double w, double h) {
        this.isExpanding = true; // sx -> dx
        this.xStep = w / 100.0;
        this.xMinEll = x + this.xStep;
        this.xMaxEll = x + w - this.xStep;
        this.rect = new Rectangle2D.Double(x, y, w, h);
        this.ell = new Ellipse2D.Double(this.xMinEll, y, 0, h);
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        g2d.setColor(Color.red);
        g2d.fill(this.rect);
        g2d.setColor(Color.black);
        g2d.draw(this.rect);

        g2d.fill(this.ell);
    }

    public int getDrawingWidth() {
        return ((int)Math.round(rect.getX() + rect.getWidth() + 0.5));
    }

    public int getDrawingHeight() {
        return ((int)Math.round(rect.getY() + rect.getHeight() + 0.5));
    }

    public void updateDrawing() {
        double newEllWidth = this.ell.getWidth();
        if (this.isExpanding) {
            if ((this.ell.getX() + this.ell.getWidth() + this.xStep) < this.xMaxEll)
                newEllWidth += this.xStep;
            else
                this.isExpanding = false;
        }
        else {
            if ((this.ell.getX() + this.ell.getWidth() - this.xStep) > this.xMinEll)
                newEllWidth -= this.xStep;
            else
                this.isExpanding = true;
        }

        this.ell.setFrame(this.ell.getX(), this.ell.getY(), newEllWidth, this.ell.getHeight());
    }
}
