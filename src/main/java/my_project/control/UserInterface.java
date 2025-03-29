package my_project.control;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.model.menu.MenuButton;

public class UserInterface extends GraphicalObject{

    // Attribute
        private boolean menuVisible = false;

    // Arrays
        private final String[] visiblePaths = {
                "src/main/resources/graphic/menu/settings.png", // SETTINGS
                "src/main/resources/graphic/menu/settings.png", // LEVEL
                "src/main/resources/graphic/menu/settings.png", // LEVEL_TIMER
                "src/main/resources/graphic/menu/settings.png",  // GLOBAL_TIMER
        };
        private final String[] invisiblePaths = {
                "src/main/resources/graphic/menu/settings.png", // MUSIC
                "src/main/resources/graphic/menu/settings.png" // SHIELD
        };
        private final String[] buttonTexts = {
                "Settings", // SETTINGS
                "Level", // LEVEL
                "Timer lvl", // LEVEL_TIMER
                "Timer glb",  // GLOBAL_TIMER

                "BG-Music", // MUSIC
                "Shield" // SHIELD
        };

        private MenuButton[] buttons = new MenuButton[visiblePaths.length + invisiblePaths.length];

    // Referenzen


    // Methoden
    public UserInterface() {
        double width = 120;
        double height = 30;

        // So viele Buttons erstellen, wie es Pfade gibt, richtiger Pfad als Parameter übergeben; buttons[] mit ihnen befüllen
        for (int i = 0; i < visiblePaths.length; i++) {
            buttons[i] = new MenuButton(20, 20+i*(height+10), width, height, visiblePaths[i],true, true, buttonTexts[i]);
        }
        for (int i = 0; i < invisiblePaths.length; i++) {
            buttons[visiblePaths.length+i] = new MenuButton(20, (20+visiblePaths.length*(height+10))+(20+i*(height+10)), width, height, visiblePaths[i],true, false, buttonTexts[visiblePaths.length+i]);
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

    // Wenn man die Maus über den Methodenbezeichner changeSettingStatus hovert, sieht man folgenden Kommentar:
    /**
     * Methode ändert den Status einer bestimmten Einstellung.
     *
     * @param index Die Indexe der Einstellungen:<br>
     *              0 = SETTINGS<br>
     *              1 = LEVEL<br>
     *              2 = LEVEL_TIMER<br>
     *              3 = GLOBAL_TIMER<br>
     *              4 = MUSIC<br>
     *              5 = SHIELD<br>
     */

    public void changeSettingStatus(int index) {
        if (index >= 0 && index < buttons.length && buttons[index] != null) {
            buttons[index].setButtonVisible(!buttons[index].isButtonVisible());
        } else {
            System.err.println("Fehler: Ungültiger Index " + index); //Für Fehlerausgaben System.err verwenden statt System.out
        }
    }


    public void handleMenuClicked(boolean opened){
        if (opened){
            for (MenuButton button : buttons) {
                button.setButtonVisible(true);
            }
        } else {
            for (MenuButton button : buttons) {
                button.setButtonVisible(false);
            }
            //Auch Positionen neuanordnen!
            //...
        }
    }
}

