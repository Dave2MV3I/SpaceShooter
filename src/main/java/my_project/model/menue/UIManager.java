package my_project.model.menue;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.event.MouseEvent;

public class UIManager extends InteractiveGraphicalObject {

    private UIButton menuButton; // Der Button zum Öffnen des Menüs
    private UIButton[] buttons;  // Alle Buttons (sichtbar + unsichtbar)
    private UIButton[] visibleButtons; // Nur die aktivierten Buttons
    private boolean menuOpen = false;

    public UIManager() {
        // Menü-Button (zum Öffnen des Auswahlmenüs)
        menuButton = new UIButton(10, 10, "Menü", this);

        // UI-Buttons für verschiedene Anzeigen (Timer, HP, etc.)
        buttons = new UIButton[]{
                new UIButton(10, 50, "Timer", this),
                new UIButton(10, 90, "HP", this),
                new UIButton(10, 130, "Score", this),
                new UIButton(10, 170, "Level", this)
        };

        // Anfangs sind keine Buttons aktiv
        visibleButtons = new UIButton[0];
    }

    @Override
    public void draw(DrawTool drawTool) {
        // Menü-Button immer zeichnen
        menuButton.draw(drawTool);

        // Falls das Menü offen ist, zeichne alle Buttons zur Auswahl
        if (menuOpen) {
            for (UIButton button : buttons) {
                button.draw(drawTool);
            }
        } else {
            // Wenn das Menü geschlossen ist, zeige nur die aktivierten Buttons
            for (UIButton button : visibleButtons) {
                button.draw(drawTool);
            }
        }
    }

    @Override
    public void update(double dt) {
        // Buttons müssen nicht ständig aktualisiert werden
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Prüfe, ob der Menü-Button geklickt wurde
        if (menuButton.isClicked(e)) {
            menuOpen = !menuOpen;
            if (!menuOpen) {
                updateVisibleButtons();
            }
            return;
        }

        // Falls das Menü offen ist, überprüfe, ob ein UI-Button angeklickt wurde
        if (menuOpen) {
            for (UIButton button : buttons) {
                if (button.isClicked(e)) {
                    button.toggleActive(); // Button aktivieren/deaktivieren
                }
            }
        }
    }

    private void updateVisibleButtons() {
        // Zähle die aktiven Buttons
        int count = 0;
        for (UIButton button : buttons) {
            if (button.isActive()) count++;
        }

        // Neues Array mit der passenden Größe erstellen
        visibleButtons = new UIButton[count];

        // Fülle das neue Array mit den aktivierten Buttons
        int index = 0;
        for (UIButton button : buttons) {
            if (button.isActive()) {
                visibleButtons[index] = button;
                index++;
            }
        }

        // Die Buttons gleichmäßig ausrichten
        arrangeVisibleButtons();
    }

    private void arrangeVisibleButtons() {
        int yStart = 50; // Startposition (y-Wert) für die Buttons
        int spacing = 40; // Abstand zwischen den Buttons

        for (int i = 0; i < visibleButtons.length; i++) {
            visibleButtons[i].setY(yStart + i * spacing);
        }
    }
}
