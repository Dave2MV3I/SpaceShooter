package my_project.control;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.model.userInterface.*;

import java.awt.event.MouseEvent;

public class UserInterface extends GraphicalObject {

    // Attribute
    private final int totalSettings = 4;
    private final int totalStatusDisplays = 3;
    private final double buttonHeight = 30;
    private final double buffer = 10;
    private boolean menuOpen = false;

    // Arrays
    private final Setting[] settings = new Setting[totalSettings];
    private final StatusDisplay[] statusDisplays = new StatusDisplay[totalStatusDisplays];
    private final BlockWithIcon[] settingButtons = new BlockWithIcon[totalSettings];


    // Referenzen
    private SettingButton settingButton;


    // Konstruktor
    public UserInterface() {
        // Objekte für Einstellungen erstellen
        // Mit Statusanzeige
        settings[0] = new Setting("Level", "src/main/resources/graphic/menu/settings.png", true);
        settings[1] = new Setting("LevelTimer", "src/main/resources/graphic/menu/settings.png", false);
        settings[2] = new Setting("GlobalTimer", "src/main/resources/graphic/menu/settings.png", true);

        // Ohne Statusanzeige
        settings[3] = new Setting("Music", "src/main/resources/graphic/menu/settings.png", true);
        //settings[4] = new Setting("HP-Bar bottomed", "src/main/resources/graphic/menu/settings.png", true, false);

        //Buttons erstellen
        settingButton = new SettingButton(20, 20, 30, true, "src/main/resources/graphic/menu/settings.png",this);
        for (int i = 0; i < settings.length; i++) {
            settingButtons[i] = new BlockWithIcon(20, 60+ i*(buttonHeight+buffer), buttonHeight, false, settings[i]);
        }

        //Statusanzeigen erstellen
        double shift = 0;
        for (int i = 0; i < statusDisplays.length; i++) {
            statusDisplays[i] = new StatusDisplay(220 + shift, 20, buttonHeight, true, settings[i]);
            shift += statusDisplays[i].getWidth() + 10;
        }
    }

    // Methoden
    @Override
    public void draw(DrawTool drawTool){
        settingButton.draw(drawTool);
        for (BlockWithIcon button : settingButtons) {
            if (button.getVisible()) button.draw(drawTool);
        }
        for (int i = 0; i < statusDisplays.length; i++) {
            if (settings[i].isActive()) statusDisplays[i].draw(drawTool);
        }
    }

    public boolean getMenuOpen() {return menuOpen;}

    public void mouseClicked(MouseEvent e){
        if (settingButton.collidesWith(e.getX(), e.getY())){
            menuOpen = !menuOpen;
            menuClicked();
        } else {
            for (int i = 0; i < settingButtons.length; i++){
                if (settingButtons[i].collidesWith(e.getX(), e.getY())){
                    settings[i].switchActivity();
                    settingButtons[i].switchColours();
                }
            }
        }
    }

    public void menuClicked(){
        if (menuOpen){
            for (int i = 0; i < settingButtons.length; i++) {
                settingButtons[i].setY(60+i*(buttonHeight+buffer));
                settingButtons[i].setVisibility(true);
            }
        } else {
            for (int i = 0; i < settingButtons.length; i++) {
                settingButtons[i].setVisibility(false);
            }
        }
    }
}

