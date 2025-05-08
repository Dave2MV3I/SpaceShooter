package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;

public class DamageDisplay extends GraphicalObject {

    private final String text;
    private double lifetime = 1.0;
    private final double initialY;

    public DamageDisplay(double x, double y, int damage) {
        this.x = x;
        this.y = y;
        this.initialY = y;
        this.text = "-" + damage;
    }

    @Override
    public void draw(DrawTool drawTool) {
        if (lifetime > 0) {
            drawTool.setCurrentColor(255, 255, 255, 255); // Weiß
            drawTool.formatText("Arial", Font.ITALIC,20);
            drawTool.drawText(x, y, text);
        }
    }

    @Override
    public void update(double dt) {
        if (lifetime > 0) {
            lifetime -= dt;
            y = initialY - (1.0 - lifetime) * 30;
        }
    }

}

