package my_project.model.userInterface;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;
import my_project.control.SettingController;

import java.awt.*;

public class BlockWithIcon extends GraphicalObject{

    // Attribute
    protected boolean visible;
    protected final double buttonRadius;  // Nicht der Radius des GraphicalObjects, deshalb neu deklariert
    protected final double iconWidth = 20;
    protected String text;
    private boolean widthCalculated;

    // Arrays
    protected int[] color = new int[4];
    protected UserInterface ui;

    // Referenzen
    protected Icon icon;

    // Konstruktoren
    public BlockWithIcon(double x, double y, double height, boolean visible, String iconPath, String text, UserInterface ui) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.visible = visible;
        this.buttonRadius = height/2;
        this.text = text;
        this.ui = ui;

        icon = new Icon(this, iconPath, iconWidth);
    }

    // Methoden
    @Override
    public void draw(DrawTool drawTool) {
        if (!widthCalculated) {
            this.width = calculateWidth(drawTool, text);
            widthCalculated = true;
        }

        // Block zeichnen
        drawTool.setCurrentColor(color[0],color[1],color[2],color[3]);
        drawTool.drawFilledCircle(x+buttonRadius, y+buttonRadius, buttonRadius);
        drawTool.drawFilledCircle(x+width-buttonRadius, y+buttonRadius, buttonRadius);
        drawTool.drawFilledRectangle(x+buttonRadius, y, width-2*buttonRadius, height);

        // Icon zeichnen
        icon.draw(drawTool);

        // Text zeichnen
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawText(x+buttonRadius+30, y+1.3*buttonRadius, text); // TODO Position an Schriftgröße und Font anpassen
    }

    @Override
    public void update(double dt){
    }

    protected double calculateWidth(DrawTool drawTool, String name) {
        FontMetrics fm = drawTool.getGraphics2D().getFontMetrics();
        return fm.stringWidth(name) + buttonRadius * 3 + 20;
    }

    public boolean getVisible(){return visible;}
    public void setVisibility(boolean visible) {this.visible = visible;}

    public double getButtonRadius(){return buttonRadius;}

    // Private Klasse
    protected class Icon extends GraphicalObject {
        private final BlockWithIcon pb; // parent Button
        private final double iconWidth;

        public Icon(BlockWithIcon parentButton, String path, double iconWidth) {
            setNewImage(path);
            this.pb = parentButton;
            this.iconWidth = iconWidth;
        }

        @Override
        public void draw(DrawTool drawTool){
            drawTool.drawImage(getMyImage(),pb.getX()+pb.getButtonRadius(), pb.getY()+((pb.getHeight()-20)/2)); //Icon bekommt eigene Koordinaten; 20px als Iconhöhe
        }
    }

}
