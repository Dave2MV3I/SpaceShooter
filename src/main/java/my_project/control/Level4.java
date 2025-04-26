package my_project.control;

import KAGO_framework.view.DrawTool;
import my_project.model.Bullet;
import my_project.model.enemy.SmallSpaceship;
import my_project.model.enemy.Spaceship;
import my_project.model.enemy.Stardestroyer;

public class Level4 extends LevelControl{
    //Attribute
    int counter = 0;

    //Referenzen
    private final ProgramController pc;

    //Methoden
    public Level4 (int nSpaceships, ProgramController pc, String bgSong) {
        super(nSpaceships, pc, bgSong);
        int nBullets = nSpaceships*5 + 20;

        counter = 0;
        this.pc = pc;

        for (int i = 0; i < nBullets; i++) {
            bullets[i] = new Bullet();
        }

        for (int i = 0 ; i < nSpaceships; i++) {
            spaceships[i] = new Stardestroyer();
        }



        //spaceships[1].startSpaceship(300,300, 0.5, pc);
        //bullets[1].startBullet(800, 400, "enemy", 20, 100, 100);
    }


    public void draw(DrawTool drawTool) {
        super.draw(drawTool);

        System.out.println("startBullet() wurde aufgerufen");
        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i].isActive()) bullets[i].draw(drawTool);
        }

        for (int i = 0; i < spaceships.length; i++) {
            if (spaceships[i].isActive()) spaceships[i].draw(drawTool);
        }
    }

    public void update(double dt){
        if (timer > 10 && counter < 8) {
            System.out.println("Spaceship gestartet (2)");
            for (Spaceship spaceship : spaceships) {

                if (!spaceship.isActive()) {
                    spaceship.startSpaceship(800, counter * 60, pc);
                    counter += 1;

                    break;
                }
            }

            for (Spaceship spaceship : spaceships) {
                if (!spaceship.isActive()) {
                    spaceship.startSpaceship(800, 700 - counter * 50, pc);
                    counter += 1;
                    timer = timer % 10;
                    break;
                }
            }

        }



        // Modulo teilt timer durch 1 und erhält den Redt (hinterm Komma); an den nächsten Intervall drangegangen wg. overflow

        if (counter > 7 && noSpaceships()) {
            pc.setSceneOrLevel(5);
        }

        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i].isActive()) bullets[i].update(dt);
        }

        for (int i = 0; i < spaceships.length; i++) {
            if (spaceships[i].isActive()) spaceships[i].update(dt);
        }


    }

    public boolean noSpaceships(){
        for (int i = 0; i< spaceships.length; i++){
            if (spaceships[i].isActive()) return false;
        }
        return true;
    }

}