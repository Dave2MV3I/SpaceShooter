package my_project.model.userInterface;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;
import my_project.control.SettingController;

import java.awt.event.MouseEvent;

public class UserInterface extends InteractiveGraphicalObject {

    // Attribute
    private boolean menuOpen = false;
    // totals: 6 setting buttons, 1 main setting button, 3 status displays up to now
    private final SettingButton[] settingButtons = new SettingButton[6];
    private final StatusDisplay[] statusDisplays = new StatusDisplay[3];
    private final double buttonHeight = 30;

    // Referenzen
    private final ProgramController pc;
    private final SettingController sc;
    private final MainSettingButton mainSettingButton;
    private DrawTool theDrawTool;

    // Methoden
    public UserInterface(ProgramController pc) {
        this.pc = pc;
        sc = new SettingController(settingButtons.length);
        double bX = 20;

        mainSettingButton = new MainSettingButton(bX, gBY(0), buttonHeight, "src/main/resources/graphic/menu/settings.png",  this);
        settingButtons[0] = new SettingButton(bX, gBY(1), buttonHeight, "src/main/resources/graphic/menu/settings.png", this, 0);
        settingButtons[1] = new SettingButton(bX, gBY(2), buttonHeight, "src/main/resources/graphic/menu/settings.png", this, 1);
        settingButtons[2] = new SettingButton(bX, gBY(3), buttonHeight, "src/main/resources/graphic/menu/settings.png", this, 2);
        settingButtons[3] = new SettingButton(bX, gBY(4), buttonHeight, "src/main/resources/graphic/menu/settings.png", this, 3);
        settingButtons[4] = new SettingButton(bX, gBY(5), buttonHeight, "src/main/resources/graphic/menu/settings.png", this, 4);
        settingButtons[5] = new SettingButton(bX, gBY(6), buttonHeight, "src/main/resources/graphic/menu/settings.png", this, 5);

        statusDisplays[0] = new StatusDisplay(200, 20, buttonHeight, sc.getActivity(2), "src/main/resources/graphic/menu/settings.png", 2, this);
        statusDisplays[1] = new StatusDisplay(200, 20, buttonHeight, sc.getActivity(3), "src/main/resources/graphic/menu/settings.png", 3, this);
        statusDisplays[2] = new StatusDisplay(200, 20, buttonHeight, sc.getActivity(4), "src/main/resources/graphic/menu/settings.png", 4, this);
        //200 + statusDisplays[0].getWidth() + 20 + statusDisplays[1].getWidth() + 80
    }

    private double gBY(int i){
        double startBY = 20;
        final double buffer = 10;
        return startBY + i * (buttonHeight + buffer);
    }

    @Override
    public void draw(DrawTool drawTool){
        if (theDrawTool == null){theDrawTool = drawTool;}
        mainSettingButton.draw(drawTool);
        for (SettingButton button : settingButtons) {
            if (button.getVisible()) button.draw(drawTool);
        }
        for (StatusDisplay display : statusDisplays) {
            //if (sc.getActivity(i+2)) statusDisplays[i].draw(drawTool);
            if (display.getVisible()) display.draw(drawTool);
        }
    }

    @Override
    public void update(double dt){
        // Align StatusDisplays
        for (int i = 1; i < statusDisplays.length; i++){
            double shift = 0;
            for (int j = 0; j < statusDisplays.length; j++){
                if (j < i) {
                    shift += statusDisplays[j].getWidth() + 20;
                }
            }
            statusDisplays[i].setX(200 + shift);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (mainSettingButton.collidesWith(e.getX(), e.getY())){
            menuOpen = !menuOpen;
            menuClicked();
        } else {
            for (int i = 0; i < settingButtons.length; i++){
                if (settingButtons[i].collidesWith(e.getX(), e.getY())){
                    sc.toggleSetting(i);
                }
                if (i==0) {
                    pc.checkAndHandleMusic(false);
                }
                for (int j = 0; j < statusDisplays.length; j++){
                    statusDisplays[j].setVisible(sc.getActivity(j+2));
                }
            }
        }
    }

    public void menuClicked(){
        if (menuOpen){
            for (int i = 0; i < settingButtons.length; i++) {
                settingButtons[i].setY(gBY(i+1));
                settingButtons[i].setVisible(true);
            }
        } else {
            for (SettingButton settingButton : settingButtons) {
                settingButton.setVisible(false);
            }
        }
    }

    public boolean getMenuOpen(){
        return menuOpen;
    }

    public SettingController getSC(){return sc;}
    public DrawTool getDrawTool(){return theDrawTool;}

}


