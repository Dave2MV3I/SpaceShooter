package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;

public class DeathTextDisplay extends GraphicalObject {

    private String text;

    public DeathTextDisplay(String reason) {
        this.text = reason;
        this.x = 120;
        this.y = 600;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(255, 255, 255, 255); // Weiß
        drawTool.formatText("Arial", Font.BOLD,32);
        drawTool.drawText(x, y, text);
    }

}

