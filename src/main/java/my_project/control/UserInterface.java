package my_project.control;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.model.menu.MenuButton;

import java.awt.event.MouseEvent;

public class UserInterface extends GraphicalObject {

    // Attribute
        private double buttonWidth = 120;
        private double buttonHeight = 30;
        private double buffer = 10;
        private boolean menuOpen = false;
        private final int visibleInTheBeninging = 0;

    // Arrays
        private final String[] paths = {
                // Active in the beninging and visible
                "src/main/resources/graphic/menu/settings.png", // SETTINGS

                // Inactive in the beninging
                "src/main/resources/graphic/menu/settings.png", // MUSIC
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

        private MenuButton[] buttons = new MenuButton[paths.length];

    // Referenzen


    // Methoden
    public UserInterface() {

        // So viele Buttons erstellen, wie es Pfade gibt, richtiger Pfad als Parameter übergeben; buttons[] mit ihnen befüllen
        for (int i = 0; i < paths.length; i++) {
            buttons[i] = new MenuButton(
                    20, 20+i*(buttonHeight+buffer), buttonWidth, buttonHeight, paths[i],
                    true, i <= visibleInTheBeninging, buttonTexts[i]
                    // Bei buttonVisible wird true übergeben, wenn der Pfad zu einem am Anfang sichtbaren Button gehört, also i <= visibleInTheBeninging
            );
        }
    }

    @Override
    public void update(double dt){
    }

    @Override
    public void draw(DrawTool drawTool){
        for (MenuButton button : buttons) {
            if (button.isButtonVisible()) button.draw(drawTool);
        }
    }

    public void menuClicked(){
        if (menuOpen){
            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setY(20+i*(buttonHeight+buffer));
                buttons[i].setButtonVisible(true);
            }
        } else {
            for (int i = 1; i < buttons.length; i++) {
                buttons[i].setButtonVisible(false);
            }

            /*
            for (int i = 1; i < buttons.length; i++) {
                if (!buttons[i].isSettingActive()) buttons[i].setButtonVisible(false);
            }

            int visibles = 0;
            MenuButton[] visibleButtons;

            for (int i = 0; i < buttons.length; i++) {
                if (buttons[i].isButtonVisible()) visibles++;
            }
            visibleButtons = new MenuButton[visibles];

            int index = 0;
            for (int i = 0; i < buttons.length; i++) {
                if (buttons[i].isButtonVisible()) {
                    visibleButtons[index] = buttons[i];
                    index++;  // Den Index erhöhen, damit der nächste sichtbare Button die nächste Stelle im array visibleButtons bekommt
                }
            }

            for (int i = 0; i < visibleButtons.length; i++) {
                visibleButtons[i].setY(20+i*(buttonHeight+buffer));
            }*/
        }
    }

    public void mouseClicked(MouseEvent e){
        if (buttons[0].collidesWith(e.getX(), e.getY())){
            menuOpen = !menuOpen;
            menuClicked();
            if (menuOpen){
                buttons[0].setSettingActive(true);
            } else buttons[0].setSettingActive(false);
        } else {
            for (int i = 0; i < buttons.length; i++){
                if (buttons[i].collidesWith(e.getX(), e.getY())){
                    buttons[i].setSettingActive(!buttons[i].isSettingActive());
                }
            }
        }
    }
}

