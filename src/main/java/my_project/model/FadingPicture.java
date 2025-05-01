package my_project.model;

import KAGO_framework.view.DrawTool;

import java.awt.*;

public class FadingPicture extends Picture{

    private double fadingTimer;
    private double timerLength = 5;
    private double endY;

    public FadingPicture(double x, double y, String path, double endY) {
        super(x, y, path);
        this.endY = endY;
    }

    @Override
    public void draw(DrawTool drawTool) {

        if (fadingTimer > 0 && fadingTimer <= timerLength) {
            Graphics2D g2d = drawTool.getGraphics2D();
            Composite originalComposite = g2d.getComposite(); // merken
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)(1f-(fadingTimer/timerLength)*1f))); // 0.0f = ganz transparent, 1.0f = voll sichtbar
            super.draw(drawTool); // das Bild transparent zeichnen

            g2d.setComposite(originalComposite); // zurücksetzen
        } else {
            super.draw(drawTool); // das Bild transparent zeichnen
        }
    }

    @Override
    public void update(double dt){
        if (y > endY) {
            y -= 100 * dt;
        } else fadingTimer += dt;;
    }

    public boolean getFadingEnded(){return fadingTimer >= timerLength;}
}
