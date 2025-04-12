package my_project.model.userInterface;

import KAGO_framework.view.DrawTool;
import my_project.control.SettingController;

public class StatusDisplay extends BlockWithIcon{
    static double widthNeeded;

    public StatusDisplay(double startX, double y, double height, boolean visible, String iconPath, int index, UserInterface ui) {
        super(startX + widthNeeded, y, height, visible, iconPath, "status", ui);
        // text setzen mit sc und getter, text aktualisieren
        text = "Statusanzeige";
    }

    @Override
    public void draw(DrawTool drawTool){
        // Block zeichnen
        x = widthNeeded;
        drawTool.setCurrentColor(29, 28, 26,255);
        drawTool.drawFilledCircle(x+buttonRadius, y+buttonRadius, buttonRadius);
        drawTool.drawFilledCircle(x+width-10, y+buttonRadius, buttonRadius);
        drawTool.drawFilledRectangle(x+buttonRadius, y, width-height, height);
    }

    public  void updateAlignment(){
        if (visible) {
            widthNeeded += width + 20;
        } else widthNeeded -= width + 20;
    }
}
