package my_project.model.menu;

import my_project.model.Picture;
import KAGO_framework.view.DrawTool;

public class MenuButton extends Picture {
    private double radius; // Nicht der Radius des GraphicalObjects, deshalb neu deklariert

    private boolean settingActive; // Die Einstellung ist aktiviert, z.B. BG-Musik
    private boolean buttonVisible; // Der Button dieser Einstellung wird angezeigt

    public MenuButton(double x, double y, String path, double width, double height, boolean settingActive, boolean buttonVisible) {
        super(x+0.5*height, y, path); //Icon bekommt eigene Koordinaten
        this.width = width;
        this.height = height;
        this.radius = 0.5*height;
        this.settingActive = settingActive;
        this.buttonVisible = buttonVisible;
    }

    @Override
    public void update(double dt) {}

    @Override
    public void draw(DrawTool drawTool) {
        // Button zeichnen
        if (settingActive) { drawTool.setCurrentColor(0,0,255,255);}
        else drawTool.setCurrentColor(0,0,255,100);

        drawTool.drawFilledCircle(x+radius, y+radius, radius);
        drawTool.drawFilledRectangle(x+radius, y, width-height, height);
        drawTool.drawFilledCircle(x+width-radius, y+radius, radius);

        // Icon zeichnen
        super.draw(drawTool);

        // Text zeichnen

    }

    public boolean isSettingActive() {
        return settingActive;
    }
    public void setSettingActive(boolean settingActive) {
        this.settingActive = settingActive;
    }

    public boolean isButtonVisible() {
        return buttonVisible;
    }
    public void setButtonVisible(boolean buttonVisible) {
        this.buttonVisible = buttonVisible;
    }



}