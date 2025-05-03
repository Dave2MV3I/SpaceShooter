/*
package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.model.Shield;
import my_project.model.enemy.SmallSpaceship;
import my_project.model.enemy.Spaceship;

public class Level2 extends LevelController {
    //Attribute

    //Referenzen
    private final ProgramController pc;

    //Methoden
    public Level2(int nSpaceships, ProgramController pc, String bgSong, int nShields, ViewController viewController, int scene) {
        super(nSpaceships, pc, bgSong, nShields, viewController, scene, nSpaceships*5 + 20);
        System.out.println ("Levels2.draw() wurde aufgerufen");

        for (int i = 0; i < nSpaceships; i++) {
            spaceships[i] = new SmallSpaceship();
        }
        for (int i = 0; i < nShields; i++){
            shields[i] = new Shield();
        }
        this.pc = pc;
        addDrawables();
    }


    public void draw(DrawTool drawTool) {
        super.draw(drawTool);

        //System.out.println("drawLevel2() wurde aufgerufen");

    }

    public void update(double dt){
        //System.out.println("Lvl2 Update läuft");
        super.update(dt);

        if (timer > 10 && enemyCounter < 8) {
            System.out.println("Spaceship gestartet (2)");
            for (Spaceship spaceship : spaceships) {

                if (!spaceship.isActive()) {
                    spaceship.startSpaceship(800, enemyCounter * 55, pc);
                    enemyCounter += 1;

                    break;
                }
            }

            for (Spaceship spaceship : spaceships) {
                if (!spaceship.isActive()) {
                    spaceship.startSpaceship(800, 700 - enemyCounter * 55, pc);
                    enemyCounter += 1;
                    timer = timer % 10;
                    break;
                }
            }
        }
        // Modulo teilt timer durch 1 und erhält den Rest (hinterm Komma); ans nächste Intervall drangegangen wg. overflow

        if (enemyCounter > 7 && noSpaceships()) {
            if (!levelEnded) {
                pc.setSceneAndLevel(3);
                levelEnded = true;
            }
        }

    }

}
*/
