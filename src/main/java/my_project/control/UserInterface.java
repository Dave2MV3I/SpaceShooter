package my_project.control;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.model.menu.MenuButton;

public class UserInterface extends GraphicalObject{

    // Attribute
    private int nSettings = 4;
    // Arrays
    private MenuButton[] activeSettings = new MenuButton[nSettings]; //Music, Level, lvlTimer, glbTimer
    private MenuButton[] inactiveSettings = new MenuButton[0];

    // Referenzen


    // Methoden
    public UserInterface() {
        for (int i = 0; i < nSettings; i++) {
            activeSettings[i] = new MenuButton(20, 20+i*40, "src/main/resources/graphic/menu/button.png");
        }
    }

    @Override
    public void update(double dt){}

    @Override
    public void draw(DrawTool drawTool){
        for (int i = 0; i < nSettings; i++) {
            activeSettings[i].draw(drawTool);
        }
    }
}