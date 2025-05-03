/*
package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.model.Shield;
import my_project.model.enemy.SmallSpaceship;
import my_project.model.enemy.Spaceship;
import my_project.model.FadingPicture;

public class Level1 extends LevelController {

    //Attribute
    private FadingPicture[] keys = new FadingPicture[6];

    private boolean tutorialStarted;

    //Referenzen
    private final ProgramController pc;

    //Methoden
    public Level1(int nSpaceships, ProgramController pc, String bgSong, int nShields, ViewController viewController, int scene) {
        super(nSpaceships, pc, bgSong, nShields, viewController, scene,nSpaceships*8 + 20);

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
    }

    public void update(double dt){
        super.update(dt);

        if (timer > 1 && !tutorialStarted){
            startTutorial();

        } else if (tutorialStarted){
            for (int i = 0; i < keys.length; i++){
                if (keys[i] != null && keys[i].getFadingEnded()) {
                    viewController.removeDrawable(keys[i]);
                    keys[i] = null;
                }

            }
        }

        if (timer > 10 && enemyCounter < 8) {
            for (Spaceship spaceship : spaceships) {
                if (!spaceship.isActive()) {
                    spaceship.startSpaceship(800, enemyCounter * 80, pc);
                    enemyCounter += 1;
                    timer = timer % 10;
                    break;
                }
            }
        }
        // Modulo teilt timer durch 1 und erhält den Rest (hinterm Komma); ans nächste Intervall drangegangen wg. overflow

        if (enemyCounter > 7 && noSpaceships()) {
            if (!levelEnded) {
                pc.setSceneAndLevel(2);
                System.out.println("Szene auf 2 gesetzt");
                levelEnded = true;
            }
        }

    }

    private void startTutorial(){
        tutorialStarted = true;

        keys[0] = new FadingPicture(170, 900,  "src/main/resources/graphic/keys/wkey.png", 500);
        keys[1] = new FadingPicture(50, 1020, "src/main/resources/graphic/keys/akey.png", 620);
        keys[2] = new FadingPicture(170, 1020, "src/main/resources/graphic/keys/skey.png", 620);
        keys[3] = new FadingPicture(290, 1020, "src/main/resources/graphic/keys/dkey.png", 620);
        keys[4] = new FadingPicture(620, 900, "src/main/resources/graphic/keys/fkey.png", 500);
        keys[5] = new FadingPicture(450, 900, "src/main/resources/graphic/keys/spacekey.png", 500);

        for (FadingPicture key : keys){
            viewController.draw(key);
        }
    }

}
*/
