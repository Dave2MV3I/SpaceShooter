package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;
import my_project.control.ProgramController;

import java.awt.*;

/**
 * Dient zum Zeichnen von nicht beweglichen Objekten im Hintergrund
 */
public class StartBackground extends GraphicalObject {

    private double starsX = 0;
    private ProgramController pc;

    public StartBackground(ProgramController pc) {this.pc = pc;}

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

        //drawPlanet(500, 600, 60, 0, 0, 255, 150, true, drawTool);
        //drawPlanet(100, 200, 35, 140, 0, 20, 200, false, drawTool);

        if (Math.random() > 0.5) {
            for (int i = 0; i< 7; i++){
                drawPlanet(Math.random()*Config.WINDOW_WIDTH, Math.random()*Config.WINDOW_HEIGHT, (int)(15+Math.random()*100), Math.random()*255, Math.random()*255, Math.random()*255, Math.random()*255, Math.random()>0.5, drawTool);
            }
        }

        pc.getUI().draw(drawTool);
    }

    public void update (double dt) {
        starsX += 32*dt;
    }

    private void drawPlanet(double x, double y, int radius, double r, double g, double b, double a, boolean withDust, DrawTool drawTool){
        drawTool.setCurrentColor((int) r, (int) g, (int) b, (int) a);
        drawTool.drawFilledCircle(x, y, radius);

        if (withDust){
            drawTool.setCurrentColor((int) r, (int) g, (int) b, 255);
            drawTool.drawFilledRectangle(x-1.5*radius, y-0.1*radius, 3*radius, 0.2*radius);
            drawTool.drawFilledCircle(x-1.5*radius, y, 0.1*radius);
            drawTool.drawFilledCircle(x+1.5*radius, y, 0.1*radius);
        }

    }
}
