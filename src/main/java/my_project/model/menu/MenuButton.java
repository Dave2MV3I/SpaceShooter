package my_project.model.menu;

import my_project.model.Picture;
import KAGO_framework.view.DrawTool;

public class MenuButton extends Picture {
    public MenuButton(double x, double y, String path) {super(x, y, path);}

    @Override
    public void update(double dt) {}

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(0,0,255,255);
        drawTool.drawFilledRectangle(x, y, 120,30);
    }

}