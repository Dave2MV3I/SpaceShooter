package my_project.model;

public abstract class LevelControl {

    Bullet[] bullets;
    Spaceship[] spaceships;

    public LevelControl(int nBullets, int nSpaceships) {
        bullets = new Bullet[nBullets];
        spaceships = new Spaceship[nSpaceships];

        // TODO 1 Der Hintergrund von Szene 0 soll weiterhin nur gezeichnet werden.
        //  Verschönern Sie ihn nach eigenem Ermessen, aber animieren Sie die Sterne in jedem Fall
        //  (sie könnten z.B. von links nach rechts fliegen und links wieder erscheinen o.ä.).
        //  Beachten Sie bei der Verschönerung, dass sie dabei zwei Methoden implementieren sollen,
        //  die etwas in den Hintergrund zeichnen und dabei sinnvolle Parameter verwenden,
        //  z.B. “zeichnePlanet(radius, farbe, mitWolken, mitMond)”.

        // TODO 2: Schiessen und Bullets
        // TODO 3 for-Schleife zum Erstellen der Bullets und Spaceships
        // TODO 4: Player soll von SpaceShip erben
        // Spaceships
        // Kollisionserkennung in dieser Klasse implementieren
    }

}
