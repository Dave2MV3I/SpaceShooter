package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.*;

/**
 * Dient zum Zeichnen von nicht beweglichen Objekten im Hintergrund
 */
public class StartBackground extends GraphicalObject {

    private double starsX = 0;

    @Override

    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(Color.black);
        drawTool.drawFilledRectangle(0,0,800,800);
        drawTool.setCurrentColor(Color.WHITE);
        drawTool.drawFilledCircle((70 + starsX)% Config.WINDOW_HEIGHT,30,2);
        drawTool.drawFilledCircle((170 + starsX)% Config.WINDOW_HEIGHT,60,2);
        drawTool.drawFilledCircle((20 + starsX)% Config.WINDOW_HEIGHT,230,2);
        drawTool.drawFilledCircle((400 + starsX)% Config.WINDOW_HEIGHT,130,2);
        drawTool.drawFilledCircle((230 + starsX)% Config.WINDOW_HEIGHT,530,2);
        drawTool.drawFilledCircle((700 + starsX)% Config.WINDOW_HEIGHT,630,2);
        drawTool.drawFilledCircle((700 + starsX)% Config.WINDOW_HEIGHT,230,2);

        drawPlanet(500, 600, 60, 0, 0, 255, 150, true, drawTool);
    }

    public void update (double dt) {
        starsX += 32*dt;
    }

    private void drawPlanet(double x, double y, int radius, double r, double g, double b, double a, boolean withDust, DrawTool drawTool){
        drawTool.setCurrentColor((int) r, (int) g, (int) b, (int) a);
        drawTool.drawFilledCircle(x, y, radius);

        if (withDust){
            drawTool.drawFilledRectangle(x-1.5*radius, y-0.1*radius, 3*radius, 0.2*radius);
        }

    }
}
