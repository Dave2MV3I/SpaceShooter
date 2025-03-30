package my_project.model.userInterface;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class BlockWithIcon extends GraphicalObject{

    // Attribute
    protected boolean visible;
    protected final double buttonRadius;  // Nicht der Radius des GraphicalObjects, deshalb neu deklariert

    // Arrays
    private int[] activeColor = {47,76,57,255};
    private int[] inactiveColor = {194,59,34,255};
    private int[] color = new int[4];


    // Referenzen
    private Setting setting;
    protected Icon icon;


    // Konstruktoren
    public BlockWithIcon(double x, double y, double height, boolean visible, Setting setting) {
        this.setting = setting;
        this.x = x;
        this.y = y;
        this.width = calculateWidth(setting.getName());
        this.height = height;
        this.visible = visible;
        this.buttonRadius = height/2;

        if (setting.isActive()) {
            color[0] = activeColor[0]; color[1] = activeColor[1]; color[2] = activeColor[2]; color[3] = activeColor[3];
        } else color[0] = inactiveColor[0]; color[1] = inactiveColor[1]; color[2] = inactiveColor[2]; color[3] = inactiveColor[3];

        icon = new Icon(this, setting.getIconPath());
    }
    public BlockWithIcon(double x, double y, double height, boolean visible, String iconPath) {
        this.setting = setting;
        this.x = x;
        this.y = y;
        this.width = calculateWidth("Settings");
        this.height = height;
        this.visible = visible;
        this.buttonRadius = height/2;

        icon = new Icon(this, iconPath);
    }

    // Methoden
    @Override
    public void draw(DrawTool drawTool) {
        // Block zeichnen
        drawTool.setCurrentColor(color[0],color[1],color[2],color[3]);
        drawTool.drawFilledCircle(x+buttonRadius, y+buttonRadius, buttonRadius);
        drawTool.drawFilledCircle(x+width-buttonRadius, y+buttonRadius, buttonRadius);
        drawTool.drawFilledRectangle(x+buttonRadius, y, width-2*buttonRadius, height);

        // Icon zeichnen
        icon.draw(drawTool);

        // Text zeichnen
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawText(x+buttonRadius+30, y+1.3*buttonRadius, setting.getName()); // TODO Position an Schriftgröße und Font anpassen
    }

    @Override
    public void update(double dt){
    }

    private double calculateWidth(String name) {
        // TODO Width an Textlänge anpassen
        return name.length()*15 + buttonRadius*2 + 20;
    }

    public boolean getVisible(){return visible;}
    public void setVisibility(boolean visible) {this.visible = visible;}

    public double getButtonRadius(){return buttonRadius;}

    public void switchColours() {
        if (setting.isActive()) {
            color[0] = activeColor[0]; color[1] = activeColor[1]; color[2] = activeColor[2]; color[3] = activeColor[3];
        } else color[0] = inactiveColor[0]; color[1] = inactiveColor[1]; color[2] = inactiveColor[2]; color[3] = inactiveColor[3];
    }


    // Private Klasse
    protected class Icon extends GraphicalObject {
        private final BlockWithIcon pb; // parent Button
        private double buttonX, buttonWidth, buttonHeight, radius;

        public Icon(BlockWithIcon parentButton, String path) {
            setNewImage(path);
            this.pb = parentButton;
        }

        @Override
        public void draw(DrawTool drawTool){
            drawTool.drawImage(getMyImage(),pb.getX()+pb.getButtonRadius(), pb.getY()+((pb.getHeight()-20)/2)); //Icon bekommt eigene Koordinaten; 20px als Iconhöhe
        }
    }

}
