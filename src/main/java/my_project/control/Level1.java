package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.model.Bullet;
import my_project.model.Shield;
import my_project.model.enemy.SmallSpaceship;
import my_project.model.enemy.Spaceship;

public class Level1 extends LevelControl {

    //Attribute

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

        //System.out.println("startBullet() wurde aufgerufen");
    }

    public void update(double dt){
        super.update(dt);

        if (timer > 10 && counter < 8) {
            for (Spaceship spaceship : spaceships) {
                if (!spaceship.isActive()) {
                    spaceship.startSpaceship(800, counter * 80, pc);
                    counter += 1;
                    timer = timer % 10;
                    break;
                }
            }
        }
        // Modulo teilt timer durch 1 und erhält den Rest (hinterm Komma); ans nächste Intervall drangegangen wg. overflow

        if (counter > 7 && noSpaceships()) {
            if (!levelEnded) {
                pc.setSceneOrLevel(2);
                System.out.println("Szene auf 2 gesetzt");
                levelEnded = true;
            }
        }

    }

}
