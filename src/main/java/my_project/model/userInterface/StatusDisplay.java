package my_project.model.userInterface;

import KAGO_framework.view.DrawTool;
import my_project.control.SettingController;

public class StatusDisplay extends BlockWithIcon{

    private int index;

    public StatusDisplay(double startX, double y, double height, boolean visible, String iconPath, int index, UserInterface ui) {
        super(startX, y, height, visible, iconPath, "status", ui);
        // text setzen mit sc und getter, text aktualisieren
        text = "Statusanzeige";
        this.index = index;

        color[0] = 150;
        color[1] = 0;
        color[2] = 0;
        color[3] = 255;
    }

    @Override
    public void draw(DrawTool drawTool){
        //System.out.println("Position von: " + String.valueOf(index) + ": " + String.valueOf(x));
        //System.out.println(String.valueOf(width));
        super.draw(drawTool);
    }

    @Override
    public void update(double dt){
        if (ui.getSC().getActivity(index)) {
            visible = true;
        } else visible = false;
    }
}