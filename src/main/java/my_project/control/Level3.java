/*
package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.model.Shield;
import my_project.model.enemy.SmallSpaceship;
import my_project.model.enemy.BigSpaceship;

public class Level3 extends LevelController {
    //Attribute

    //Referenzen
    private final ProgramController pc;

    //Methoden
    public Level3(int nSpaceships, ProgramController pc, String bgSong, int nShields, ViewController viewController, int scene) {
        super(nSpaceships, pc, bgSong, nShields, viewController, scene, nSpaceships*5 + 20);

        enemyCounter = 0;
        this.pc = pc;

        for (int i = 0; i < nSpaceships - 4; i++) {
            spaceships[i] = new SmallSpaceship();
        }

        for (int i = nSpaceships - 4; i < nSpaceships; i++) {
            spaceships[i] = new BigSpaceship();
        }
        for (int i = 0; i < nShields; i++){
            shields[i] = new Shield();
        }
        addDrawables();
    }


    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
        //System.out.println("Lvl3 wird gezeichnet");

    }

    public void update(double dt){
        super.update(dt);
        if (timer > 10 && enemyCounter < 8) {
            //System.out.println("Spaceship gestartet (2)");
            if (enemyCounter %2 == 0){
                for (int j = 0; j < spaceships.length-4; j++) {
                    if (!spaceships[j].isActive()) {
                        spaceships[j].startSpaceship(800, enemyCounter * 80, pc);
                        enemyCounter += 1;
                    }
                }
            }

            if (enemyCounter %2 == 1){
                for (int j = spaceships.length - 4; j < spaceships.length; j++) {
                    if (!spaceships[j].isActive()) {
                        spaceships[j].startSpaceship(800, enemyCounter * 80, pc);
                        enemyCounter += 1;
                    }
                }
            }
        }

        // Modulo teilt timer durch 1 und erhält den Rest (hinterm Komma); an den nächsten Intervall drangegangen wg. overflow

        if (enemyCounter > 7 && noSpaceships()) {
            //System.out.println(pc.getCurrentScene());
            pc.setSceneAndLevel(4);
        }

    }


}
*/
