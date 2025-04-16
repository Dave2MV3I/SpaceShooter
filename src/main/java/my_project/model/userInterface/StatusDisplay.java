package my_project.model.userInterface;

import KAGO_framework.view.DrawTool;
import my_project.control.SettingController;

public class StatusDisplay extends BlockWithIcon{

    private int index;

    public StatusDisplay(double x, double y, double height, boolean visible, String iconPath, int index, UserInterface ui) {
        super(x, y, height, visible, iconPath, "status", ui);
        // text setzen mit sc und getter, text aktualisieren
        text = "Statusanzeige";
        this.index = index;
    }

    @Override
    public void draw(DrawTool drawTool){
        // Block zeichnen
        //x = widthNeeded;
        System.out.println("Visibility1: " + String.valueOf(visible));
        x = 400;
        drawTool.setCurrentColor(29, 28, 26,255);
        drawTool.drawFilledCircle(x+buttonRadius, y+buttonRadius, buttonRadius);
        drawTool.drawFilledCircle(x+width-10, y+buttonRadius, buttonRadius);
        drawTool.drawFilledRectangle(x+buttonRadius, y, width-height, height);
    }

    @Override
    public void update(double dt){
        if (ui.getSC().getActivity(index)) {
            visible = true;
        } else visible = false;
    }
}