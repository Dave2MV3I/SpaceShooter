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
        settings[0] = new Setting("Music", "src/main/resources/graphic/menu/settings.png", true);
        settings[1] = new Setting("Level", "src/main/resources/graphic/menu/settings.png", true);
        settings[2] = new Setting("LevelTimer", "src/main/resources/graphic/menu/settings.png", false);
        settings[3] = new Setting("GlobalTimer", "src/main/resources/graphic/menu/settings.png", true);
        //settings[4] = new Setting("HP-Bar below", "src/main/resources/graphic/menu/settings.png", true, false);

        //Buttons erstellen
        settingButton = new SettingButton(20, 20, 30, true, "src/main/resources/graphic/menu/settings.png",this);
        for (int i = 0; i < totalSettings; i++) {
            settingButtons[i] = new BlockWithIcon(20, 60+ i*(buttonHeight+buffer), buttonHeight, false, settings[i]);
        }

//        statusDisplays[0] = new StatusDisplay();
//        statusDisplays[1] = new StatusDisplay();
//        statusDisplays[2] = new StatusDisplay();
    }

    // Methoden
    @Override
    public void draw(DrawTool drawTool){
        settingButton.draw(drawTool);
        for (BlockWithIcon button : settingButtons) {
            if (button.getVisible()) button.draw(drawTool);
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

            // Kommentiert man die "setButtonVisible(false)"-Schleife aus und entfert folgenden Kommentar,
            // so bleiben aktive Einstellungen im Spiel sichtbar
            /*
            for (int i = 1; i < settings.length; i++) {
                if (!settings[i].isSettingActive()) settings[i].setButtonVisible(false);
            }

            int visibles = 0;
            Setting[] visibleButtons;

            for (int i = 0; i < settings.length; i++) {
                if (settings[i].isButtonVisible()) visibles++;
            }
            visibleButtons = new Setting[visibles];

            int index = 0;
            for (int i = 0; i < settings.length; i++) {
                if (settings[i].isButtonVisible()) {
                    visibleButtons[index] = settings[i];
                    index++;  // Den Index erhöhen, damit der nächste sichtbare Button die nächste Stelle im array visibleButtons bekommt
                }
            }

            for (int i = 0; i < visibleButtons.length; i++) {
                visibleButtons[i].setY(20+i*(buttonHeight+buffer));
            }
            */
        }
    }
}

