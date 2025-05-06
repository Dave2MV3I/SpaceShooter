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
        Graphics2D g2d = drawTool.getGraphics2D();

        if (fadingTimer <= timerLength) {
            float alpha = (float)(1.0 - (fadingTimer / timerLength));
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        }

        super.draw(drawTool);
    }


    @Override
    public void update(double dt){
        if (y > endY) {
            y -= 100 * dt;
        } else fadingTimer += dt;;
    }

    public boolean getFadingEnded(){return fadingTimer >= timerLength;}
}
