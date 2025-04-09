package my_project.model.userInterface;

import KAGO_framework.view.DrawTool;
import my_project.control.SettingController;

public class SettingButton extends BlockWithIcon{


    private int[] activeColor = {47,76,57,255};
    private int[] inactiveColor = {194,59,34,255};
    private final SettingController sc;
    private final int index;

    public SettingButton(double x, double y, double height, boolean visible, String iconPath, SettingController sc, int index, String text) {
        super(x, y, height, visible, iconPath, text);
        this.sc = sc;
        this.index = index;
        if (sc.getActivity(index)) {
            color[0] = activeColor[0]; color[1] = activeColor[1]; color[2] = activeColor[2]; color[3] = activeColor[3];
        } else color[0] = inactiveColor[0]; color[1] = inactiveColor[1]; color[2] = inactiveColor[2]; color[3] = inactiveColor[3];

    }

    @Override
    public void draw(DrawTool drawTool){
        if (sc.getActivity(index)) {
            color[0] = activeColor[0]; color[1] = activeColor[1]; color[2] = activeColor[2]; color[3] = activeColor[3];
        } else color[0] = inactiveColor[0]; color[1] = inactiveColor[1]; color[2] = inactiveColor[2]; color[3] = inactiveColor[3];
    }

    public void switchColours() {
        /*if (isActive()) {
            color[0] = activeColor[0]; color[1] = activeColor[1]; color[2] = activeColor[2]; color[3] = activeColor[3];
        } else color[0] = inactiveColor[0]; color[1] = inactiveColor[1]; color[2] = inactiveColor[2]; color[3] = inactiveColor[3];
        */
    }

    /*private UserInterface ui;

    public SettingButton(double x, double y, double height, boolean visible, String iconPath, UserInterface ui) {
        super(x, y, height, visible, iconPath);
        this.ui = ui;
    }

    @Override
    public void draw(DrawTool drawTool){
        if (ui.getMenuOpen()){
            // Block zeichnen
            drawTool.setCurrentColor(29, 28, 26,255);
            drawTool.drawFilledCircle(x+buttonRadius, y+buttonRadius, buttonRadius);
            drawTool.drawFilledCircle(x+width-buttonRadius, y+buttonRadius, buttonRadius);
            width = 120;
            drawTool.drawFilledRectangle(x+buttonRadius, y, width-2*buttonRadius, height);

            // Icon zeichnen
            icon.draw(drawTool);

            // Text zeichnen
            drawTool.setCurrentColor(0,0,0,255);
            drawTool.drawText(x+buttonRadius+30, y+1.3*buttonRadius, "Settings"); // TODO Position an Schriftgröße und Font anpassen
        } else {
            // Block zeichnen
            drawTool.setCurrentColor(29, 28, 26,255);
            drawTool.drawFilledCircle(x+buttonRadius, y+buttonRadius, buttonRadius);
            drawTool.drawFilledCircle(x+40, y+buttonRadius, buttonRadius);
            width = 65;
            drawTool.drawFilledRectangle(x+buttonRadius, y, 30, height);

            // Icon zeichnen
            icon.draw(drawTool);
        }

    }*/
}
