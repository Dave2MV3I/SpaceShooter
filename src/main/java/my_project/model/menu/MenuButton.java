package my_project.model.menu;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import javax.swing.*;

public class MenuButton extends GraphicalObject {
    private final double radius; // Nicht der Radius des GraphicalObjects, deshalb neu deklariert

    private boolean settingActive; // Die Einstellung ist aktiviert, z.B. BG-Musik
    private boolean buttonVisible; // Der Button dieser Einstellung wird angezeigt
    private String buttonText;

    private Icon icon;

    public MenuButton(double x, double y, double width, double height, String path, boolean settingActive, boolean buttonVisible, String buttonText) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.radius = 0.5*height;
        this.settingActive = settingActive;
        this.buttonVisible = buttonVisible;
        this.icon = new Icon(path, this, x, width, height);
        this.buttonText = buttonText;
    }

    @Override
    public void update(double dt) {
    }

    @Override
    public void draw(DrawTool drawTool) {
        if (buttonVisible){
            // Button zeichnen
            if (settingActive) { drawTool.setCurrentColor(47,76,57,255);}
            else drawTool.setCurrentColor(194,59,34,255);

            drawTool.drawFilledCircle(x+radius, y+radius, radius);
            drawTool.drawFilledCircle(x+width-radius, y+radius, radius);
            drawTool.drawFilledRectangle(x+radius, y, width-2*radius, height);

            // Icon zeichnen
            icon.draw(drawTool);

            // Text zeichnen
            drawTool.setCurrentColor(0,0,0,255);
            drawTool.drawText(x+radius+30, y+1.3*radius, buttonText ); // TODO Position an Schriftgröße und Font anpassen
        }
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

    private class Icon extends GraphicalObject{
        private final MenuButton parentButton;
        double buttonX, buttonWidth, buttonHeight;

        public Icon(String path, MenuButton parentButton, double x, double width, double height) {
            setNewImage(path);
            this.parentButton = parentButton;
            buttonX = x;
            buttonWidth = width;
            buttonHeight = height;
        }

        @Override
        public void draw(DrawTool drawTool){
            drawTool.drawImage(getMyImage(),buttonX+0.5*buttonHeight, parentButton.getY()+((buttonHeight-20)/2)); //Icon bekommt eigene Koordinaten; 20px als Iconhöhe
        }
    }

}