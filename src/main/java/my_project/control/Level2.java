package my_project.control;

import KAGO_framework.view.DrawTool;
import my_project.model.Bullet;
import my_project.model.enemy.SmallSpaceship;
import my_project.model.enemy.Spaceship;

public class Level2 extends LevelControl{
    //Attribute
    int counter = 0;

    //Referenzen
    private final ProgramController pc;

    //Methoden
    public Level2(int nSpaceships, ProgramController pc, String bgSong) {
        super(nSpaceships, pc, bgSong);
        int nBullets = nSpaceships*5 + 20;
        System.out.println ("Levels2.draw() wurde aufgerufen");

        for (int i = 0; i < nBullets; i++) {
            bullets[i] = new Bullet();
        }

        for (int i = 0; i < nSpaceships; i++) {
            spaceships[i] = new SmallSpaceship();
        }
        this.pc = pc;
    }


    public void draw(DrawTool drawTool) {
        super.draw(drawTool);

        System.out.println("drawLevel2() wurde aufgerufen");
        for (Bullet bullet : bullets) {
            if (bullet.isActive()) bullet.draw(drawTool);
        }

        for (Spaceship spaceship : spaceships) {
            if (spaceship.isActive()) spaceship.draw(drawTool);
        }
    }

    public void update(double dt){
        //System.out.println("Lvl2 Update läuft");
        super.update(dt);

        if (timer > 10 && counter < 8) {
            System.out.println("Spaceship gestartet (2)");
            for (Spaceship spaceship : spaceships) {

                if (!spaceship.isActive()) {
                    spaceship.startSpaceship(800, counter * 55, pc);
                    counter += 1;

                    break;
                }
            }

            for (Spaceship spaceship : spaceships) {
                if (!spaceship.isActive()) {
                    spaceship.startSpaceship(800, 700 - counter * 55, pc);
                    counter += 1;
                    timer = timer % 10;
                    break;
                }
            }
        }
        // Modulo teilt timer durch 1 und erhält den Rest (hinterm Komma); ans nächste Intervall drangegangen wg. overflow

        if (counter > 7 && noSpaceships()) {
            pc.setSceneOrLevel(3);
        }

        for (Bullet bullet : bullets) {
            if (bullet.isActive()) bullet.update(dt);
        }

        for (Spaceship spaceship : spaceships) {
            if (spaceship.isActive()) spaceship.update(dt);
        }


    }

    public boolean noSpaceships(){
        for (Spaceship spaceship : spaceships) {
            if (spaceship.isActive()) return false;
        }
        return true;
    }

}
