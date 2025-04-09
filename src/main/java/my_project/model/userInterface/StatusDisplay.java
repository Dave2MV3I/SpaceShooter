package my_project.model.userInterface;

import KAGO_framework.view.DrawTool;
import my_project.control.SettingController;

public class StatusDisplay extends BlockWithIcon{
    static double widthNeeded;

    public StatusDisplay(double x, double y, double height, boolean visible, String iconPath, int index, UserInterface ui) {
        super(x, y, height, visible, iconPath, "status", ui);
        widthNeeded += width + 20;
        // text setzen mit sc und getter, text aktualisieren
    }

    /*private Setting setting;



    @Override
    public void draw(DrawTool drawTool){
        // Block zeichnen
        drawTool.setCurrentColor(29, 28, 26,255);
        drawTool.drawFilledCircle(x+buttonRadius, y+buttonRadius, buttonRadius);
        width = calculateWidth(setting.getName());
        drawTool.drawFilledCircle(x+width-10, y+buttonRadius, buttonRadius);
        drawTool.drawFilledRectangle(x+buttonRadius, y, width-height, height);

        // Icon zeichnen
        icon.draw(drawTool);

        // Text zeichnen
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawText(x+buttonRadius+30, y+1.3*buttonRadius, Double.toString(setting.getVariable())); // TODO Position an Schriftgröße und Font anpassen
    }*/
}
