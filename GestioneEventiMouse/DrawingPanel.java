package GestioneEventiMouse;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class DrawingPanel extends JPanel implements MouseInputListener{

    private final static int MARGIN = 100;

    private MainGUI mainGUI;
    private Rectangle2D.Double rect;
    private Rectangle clipRect;
    private boolean draggable;

    public DrawingPanel(MainGUI mainGUI) {
        super();
        this.mainGUI = mainGUI;
        this.rect = new Rectangle2D.Double(100.0, 100.0, 10.0, 10.0);
        this.clipRect = new Rectangle();
        this.draggable = false;
        setBackground(Color.white);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

        this.clipRect.setRect(
                this.rect.getX() - MARGIN,
                this.rect.getY() - MARGIN,
                this.rect.getWidth() + 2 * MARGIN,
                this.rect.getHeight() + 2 * MARGIN);
        g2d.setClip(this.clipRect);

        g2d.setColor(Color.red);
        g2d.fill(this.rect);
        g2d.setColor(Color.black);
        g2d.draw(this.rect);
    }


    //MouseListener
    public void mouseClicked(MouseEvent e) {
        // do nothing
        //System.out.println("EVENT mouseClicked(MouseEvent e)");
        //System.out.println("CLICK on point (" + e.getX() + ", " + e.getY() + ")");
    }

    public void mouseEntered(MouseEvent e)  {
        // do nothing
        //System.out.println("EVENT mouseEntered(MouseEvent e)");
        //System.out.println("ENTERED on point (" + e.getX() + ", " + e.getY() + ")");
    }

    public void mouseExited(MouseEvent e) {
        // do nothing
        //System.out.println("EVENT mouseExited(MouseEvent e)");
        //System.out.println("EXITED on point (" + e.getX() + ", " + e.getY() + ")");
    }

    public void mousePressed(MouseEvent e) {
        // do nothing
        //System.out.println("EVENT mousePressed(MouseEvent e)");
        //System.out.println("PRESS on point (" + e.getX() + ", " + e.getY() + ")");
        if (this.rect.contains(e.getX(), e.getY()))
            this.draggable = true;
    }

    public void mouseReleased(MouseEvent e)  {
        // do nothing
        //System.out.println("EVENT mouseReleased(MouseEvent e)");
        //System.out.println("RELEASE on point (" + e.getX() + ", " + e.getY() + ")");
        this.draggable = false;
    }


    //MouseMotionListener
    public void mouseDragged(MouseEvent e)  {
        // do nothing
        //System.out.println("EVENT mouseDragged(MouseEvent e)");
        //System.out.println("DRAGGED on point (" + e.getX() + ", " + e.getY() + ")");
        this.mainGUI.setMouseCoordinates(e.getX(), e.getY());
        if (this.draggable) {
            this.rect.setRect(e.getX(), e.getY(), this.rect.getWidth(), this.rect.getHeight());
            this.repaint();
        }

        /*this.repaint(0,
                    e.getX() - MARGIN,
                    e.getY() - MARGIN,
                    2 * MARGIN + (int)this.rect.getWidth(),
                    2 * MARGIN + (int)this.rect.getHeight());*/
    }

    public void mouseMoved(MouseEvent e)  {
        // do nothing
        //System.out.println("EVENT mouseMoved(MouseEvent e)");
        //System.out.println("MOVED on point (" + e.getX() + ", " + e.getY() + ")");
        this.mainGUI.setMouseCoordinates(e.getX(), e.getY());
    }
}