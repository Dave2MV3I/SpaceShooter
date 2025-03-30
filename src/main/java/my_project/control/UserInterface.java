package my_project.control;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.model.userInterface.Setting;

import java.awt.event.MouseEvent;

public class UserInterface extends GraphicalObject {

    // Attribute
        private double buttonWidth = 120;
        private double buttonHeight = 30;
        private double buffer = 10;
        private boolean menuOpen = false;
        private final int settingsWithStatusBlock = 2;

    // Arrays
        private final String[] paths = {
                // Without StatusBlock
                "src/main/resources/graphic/menu/settings.png", // SETTINGS
                "src/main/resources/graphic/menu/settings.png", // MUSIC

                // With StatusBlock
                "src/main/resources/graphic/menu/settings.png", // LEVEL
                "src/main/resources/graphic/menu/settings.png", // LEVEL_TIMER
                "src/main/resources/graphic/menu/settings.png"  // GLOBAL_TIMER
        };

        private final String[] buttonTexts = {
                "Settings", // SETTINGS
                "BG-Music", // MUSIC

                "Level", // LEVEL
                "Timer lvl", // LEVEL_TIMER
                "Timer glb"  // GLOBAL_TIMER
        };

        private Setting[] settings = new Setting[paths.length];

    // Referenzen


    // Methoden
    public UserInterface() {
        // So viele Buttons erstellen, wie es Pfade gibt, richtiger Pfad als Parameter übergeben; settings[] mit ihnen befüllen
        for (int i = 0; i < paths.length; i++) {
            settings[i] = new Setting(
                    20, 20+i*(buttonHeight+buffer), buttonWidth, buttonHeight, paths[i],
                    buttonTexts[i], true, i < 1, i < settingsWithStatusBlock
            );
        }
    }

    @Override
    public void update(double dt){
    }

    @Override
    public void draw(DrawTool drawTool){
        for (Setting setting : settings) {
            if (setting.isButtonVisible()) setting.draw(drawTool);
        }
    }

    public void menuClicked(){
        if (menuOpen){
            for (int i = 0; i < settings.length; i++) {
                settings[i].setY(20+i*(buttonHeight+buffer));
                settings[i].setButtonVisible(true);
            }
        } else {
            for (int i = 1; i < settings.length; i++) {
                settings[i].setButtonVisible(false);
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

    public void mouseClicked(MouseEvent e){
        if (settings[0].collidesWith(e.getX(), e.getY())){
            menuOpen = !menuOpen;
            menuClicked();
            if (menuOpen){
                settings[0].setSettingActive(true);
            } else settings[0].setSettingActive(false);
        } else {
            for (int i = 0; i < settings.length; i++){
                if (settings[i].collidesWith(e.getX(), e.getY())){
                    settings[i].setSettingActive(!settings[i].isSettingActive());
                }
            }
        }
    }
}

