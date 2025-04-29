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

    private int nPlanets = 7;

    private double[] xPositions = new double[nPlanets];
    private double[] yPositions = new double[nPlanets];

    private double[] r = new double[nPlanets];
    private double[] g = new double[nPlanets];
    private double[] b = new double[nPlanets];

    private boolean[] dustFlags = new boolean[nPlanets];

    public StartBackground(ProgramController pc) {
        this.pc = pc;
        for (int d = 0; d < xPositions.length; d++) {
            xPositions[d] = (double)(Math.random()*(Config.WINDOW_WIDTH));
        }
        for (int d = 0; d < yPositions.length; d++) {
            yPositions[d] = (double)(Math.random()*Config.WINDOW_HEIGHT);
        }

        for (int i = 0; i < r.length; i++) {
            r[i] = (double)(Math.random()*255);
        }
        for (int i = 0; i < g.length; i++) {
            g[i] = (double)(Math.random()*255);
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = (double)(Math.random()*255);
        }

        for (int i = 0; i < dustFlags.length; i++) {
            dustFlags[i] = Math.random()>0.5;
        }
    }

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

        for (int d = 0; d < xPositions.length; d++) {
            for (int i = 0; i < 21; i++){
                drawPlanet(xPositions[d]+20*i, yPositions[d], (int)(15+Math.random()*100), r[d], g[d], b[d], 255-i*(255/21), dustFlags[d], drawTool);
            }
        }

        /*
        if (Math.random() > 0.5) {
            for (int i = 0; i< 7; i++){
                drawPlanet(Math.random()*Config.WINDOW_WIDTH, Math.random()*Config.WINDOW_HEIGHT, (int)(15+Math.random()*100), Math.random()*255, Math.random()*255, Math.random()*255, Math.random()*255, Math.random()>0.5, drawTool);
            }
        }*/

        pc.getUI().draw(drawTool);
    }

    public void update(double dt) {
        starsX += 32*dt;

        for (int i = 0; i < xPositions.length; i++) {
            xPositions[i] -= 1500*dt;
            if (xPositions[i] < -50) {
                xPositions[i] = Config.WINDOW_WIDTH+50 + Math.random()*Config.WINDOW_WIDTH;
                yPositions[i] = Math.random()*Config.WINDOW_HEIGHT;
                r[i] = Math.random()*255;
                g[i] = Math.random()*255;
                b[i] = Math.random()*255;
            }
        }
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
