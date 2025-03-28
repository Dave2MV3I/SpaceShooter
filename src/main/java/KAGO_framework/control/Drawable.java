package KAGO_framework.control;

import KAGO_framework.view.DrawTool;

/**
 * Interface für Objekte, die man zeichnen und steuern kann.
 * Vorgegebene Klasse des Frameworks. Modifikation auf eigene Gefahr.
 */
public interface Drawable {

    void draw(DrawTool drawTool);

    void update(double dt/*, Spaceship sp1, Spaceship sp2, Spaceship sp3, Spaceship sp4, Spaceship sp5, Spaceship sp6, Spaceship sp7, Spaceship sp8, Spaceship sp9, Spaceship sp10, Player player*/);

}
