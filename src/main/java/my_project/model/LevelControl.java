package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

public abstract class LevelControl extends GraphicalObject     {

    private final ProgramController pc;
    Bullet[] bullets;
    SmallSpaceship[] spaceships;

    public LevelControl(int nBullets, int nSpaceships, ProgramController pc) {

        bullets = new Bullet[nBullets];
        spaceships = new SmallSpaceship[nSpaceships];
        this.pc = pc;



        // TODO 1 Siehe Unten

        //  Der Hintergrund von Szene 0 soll weiterhin nur gezeichnet werden.
            //  Verschönern Sie ihn nach eigenem Ermessen, aber animieren Sie die Sterne in jedem Fall
            //  (sie könnten z.B. von links nach rechts fliegen und links wieder erscheinen o.ä.).
            //  Beachten Sie bei der Verschönerung, dass sie dabei zwei Methoden implementieren sollen,
            //  die etwas in den Hintergrund zeichnen und dabei sinnvolle Parameter verwenden,
            //  z.B. “zeichnePlanet(radius, farbe, mitWolken, mitMond)”.
        // Schiessen und Bullets: Schaden
        // gegner schiessen
        // Anzeige oben: Munition übrig (natürlich abzüglich der Munition der Gegner, eventuell Anzahl im Array erhöhen. Grenzen für Shooter festlegen)
        // Gewinnen wenn alle getötet
        // Verlieren wenn von Gegner berührt oder getroffen
        // Player soll nicht aus dem Spiel rausfliegen können
        // Player soll von SpaceShip erben
        // Kollisionserkennung in dieser Klasse implementieren
        //Timer pro Level und ihn pausieren, falls nicht alle getötet und keine Referenzen für neue Gegner übrig

    }

    @Override
    public void draw(DrawTool drawTool){
        pc.getPlayer().draw(drawTool);
    }

    @Override
    public void update(double dt){
        pc.getPlayer().update(dt);

        // Kollisionsüberprüfung Player und Bullets (shooter nicht instanceof player)

        // Kollisionsüberprüfung jeder Bullet mit jedem Spaceship (shooter instanceof player)
    }

}
