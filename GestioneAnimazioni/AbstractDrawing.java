package GestioneAnimazioni;

import java.awt.Graphics;

public abstract class AbstractDrawing {
    
    public abstract void draw(Graphics g);

    public abstract int getDrawingWidth();

    public abstract int getDrawingHeight();

    public abstract void updateDrawing();

}
