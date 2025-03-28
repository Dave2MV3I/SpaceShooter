package my_project.model.menue;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.event.MouseEvent;

public class UIButton extends InteractiveGraphicalObject {

    private String text;
    private boolean active = false;
    private UIManager manager;

    public UIButton(double x, double y, String text, UIManager manager) {
        this.x = x;
        this.y = y;
        this.text = text;
        this.manager = manager;
    }

    @Override
    public void draw(DrawTool drawTool) {
        if (active) {
            drawTool.setCurrentColor(0, 200, 0, 255); // Grün für aktive Buttons
        } else {
            drawTool.setCurrentColor(200, 0, 0, 255); // Rot für inaktive Buttons
        }
        drawTool.drawFilledRectangle(x, y, 100, 30);
        drawTool.setCurrentColor(255, 255, 255, 255);
        drawTool.drawText(x + 10, y + 20, text);
    }

    public boolean isClicked(MouseEvent e) {
        return e.getX() >= x && e.getX() <= x + 100 && e.getY() >= y && e.getY() <= y + 30;
    }

    public void toggleActive() {
        active = !active;
    }

    public boolean isActive() {
        return active;
    }

    public void setY(double newY) {
        this.y = newY;
    }
}
