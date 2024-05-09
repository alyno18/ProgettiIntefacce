package LayoutFluido;

import java.awt.Color;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

public class DrawingPanel extends JPanel implements MouseInputListener{

    private final static int NUM_ROWS = 20;
    private final static int NUM_COLUMNS = 20;
    private final static int NUM_CELLS = 10;
    private final static Color[] COLOR_ARRAY = {Color.black, Color.blue, Color.cyan, Color.darkGray, Color.gray, Color.green, Color.lightGray, Color.magenta, Color.orange, Color.pink, Color.red, Color.yellow};

    private final static int X_MARGIN = 10;
    private final static int Y_MARGIN = 10;

    private boolean showGrid;
    private double uX;
    private double uY;

    private int[] iIndexArray;
    private int[] jIndexArray;
    private Color[] colorArray;

    private Line2D.Double line;
    private Rectangle2D.Double rect;

    private int selectedCell;

    public DrawingPanel() {
        super();
        this.showGrid = true;
        this.line = new Line2D.Double();
        this.rect = new Rectangle2D.Double();
        this.selectedCell = -1;
        setIndexArray();
        setColorArray();
        setBackground(Color.white);
        addMouseListener(this);
        addMouseMotionListener(this);
        setBackground(Color.white);
    }

    private Color getRandomColor() {
        int i = ((int)(COLOR_ARRAY.length * Math.random())) % COLOR_ARRAY.length;
        return COLOR_ARRAY[i];
    }

    private void setIndexArray() {
        this.iIndexArray = new int[NUM_CELLS];
        this.jIndexArray = new int[NUM_CELLS];
        for (int n = 0; n < NUM_CELLS; n++) {
            this.iIndexArray[n] = ((int)(NUM_ROWS * Math.random())) % NUM_ROWS;
            this.jIndexArray[n] = ((int)(NUM_COLUMNS * Math.random())) % NUM_COLUMNS;
        }
    }

    private void setColorArray() {
        this.colorArray = new Color[NUM_CELLS];
        for (int n = 0; n < NUM_CELLS; n++)
            this.colorArray[n] = getRandomColor();
    }

    private void setGridUnit() {
        this.uX = (double)(getWidth() - 2 * X_MARGIN) / (double)NUM_COLUMNS;
        this.uY = (double)(getHeight() - 2 * Y_MARGIN) / (double)NUM_ROWS;
    }

    private void paintGrid(Graphics2D g2d) {
        Color oldColor = g2d.getColor();
        g2d.setColor(Color.gray);

        // Paint the horizontal grid lines
        for (int i = 0; i <= NUM_ROWS; i++) {
            this.line.setLine(X_MARGIN, Y_MARGIN + i * this.uY,
                              X_MARGIN + NUM_COLUMNS * this.uX, Y_MARGIN + i * this.uY);
            g2d.draw(this.line);
        }

        // Paint the vertical grid lines
        for (int j = 0; j <= NUM_COLUMNS; j++) {
            this.line.setLine(X_MARGIN + j * this.uX, Y_MARGIN,
                              X_MARGIN + j * this.uX, Y_MARGIN + NUM_ROWS * this.uY);
            g2d.draw(this.line);
        }

        g2d.setColor(oldColor);
    }

    private int getRowIndex(int y) {
        int i = -1;
        i = (int)((double)(y - Y_MARGIN) / this.uY);
        return i;
    }

    // Returns the column index of the selected pixel.
    // Returns -1 if the selected pixel does not belong to the matrix (grid).
    private int getColumnIndex(int x) {
        int j = -1;
        j = (int)((double)(x - X_MARGIN) / this.uX);
        return j;
    }

    // Given a pixel position it returns the index of the cell.
    // Returns -1 if no cell is painted over the specified pixel.
    private int getSelectedCell(int x, int y) {
        int indexCell = -1;
        boolean found = false;

        for (int n = 0; (n < NUM_CELLS) && !found; n++)
            if (this.iIndexArray[n] == getRowIndex(y) && this.jIndexArray[n] == getColumnIndex(x)) {
                indexCell = n;
                found = true;
            }

        return indexCell;
    }

    private void paintCells(Graphics2D g2d) {
        Color oldColor = g2d.getColor();
        for (int n = 0; n < NUM_CELLS; n++) {
            this.rect.setRect(X_MARGIN + this.jIndexArray[n] * this.uX, Y_MARGIN + this.iIndexArray[n] * this.uY, this.uX, this.uY);
            g2d.setColor(this.colorArray[n]);
            g2d.fill(this.rect);
            g2d.setColor(Color.black);
            g2d.draw(this.rect);
        }
        g2d.setColor(oldColor);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        setGridUnit();

        Graphics2D g2d = (Graphics2D)g;
        if (this.showGrid){
            paintGrid(g2d);
        }
        paintCells(g2d);
    }

    public void mouseClicked(MouseEvent e) {
        // do nothing
    }

    public void mouseEntered(MouseEvent e)  {
        // do nothing
    }

    public void mouseExited(MouseEvent e) {
        // do nothing
    }

    public void mousePressed(MouseEvent e) {
        //System.out.println("EVENT mousePressed(MouseEvent e)");
        //System.out.println("PRESS on point (" + e.getX() + ", " + e.getY() + ")");
        //System.out.println("[i, j] = [" + getRowIndex(e.getY()) + ", " + getColumnIndex(e.getX()) + "]");
        //System.out.println("Selected cell = " + getSelectedCell(e.getX(), e.getY()));
        this.selectedCell = getSelectedCell(e.getX(), e.getY());
    }

    public void mouseReleased(MouseEvent e)  {
        this.selectedCell = -1;
    }

    public void mouseDragged(MouseEvent e)  {
        if (this.selectedCell >= 0) {
            this.iIndexArray[this.selectedCell] = getRowIndex(e.getY());
            this.jIndexArray[this.selectedCell] = getColumnIndex(e.getX());
            this.repaint();
        }
    }

    public void mouseMoved(MouseEvent e)  {
        // do nothing
    }
}
