package my_project.model.userInterface;

import KAGO_framework.view.DrawTool;

public class MainSettingButton extends BlockWithIcon{
    private final UserInterface ui;

    public MainSettingButton(double x, double y, double height, String iconPath,  UserInterface ui) {
        super(x, y, height, true, iconPath, "Settings", ui, true);
        this.ui = ui;
        color[0] = 47;
        color[1] = 76;
        color[2] = 57;
        color[3] = 255;
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

    }

}
