package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.model.Picture;
import my_project.model.Shield;
import my_project.model.enemy.SmallSpaceship;
import my_project.model.enemy.Spaceship;

public class Level1 extends Level {

    //Attribute
    private Picture wKey;
    private Picture aKey;
    private Picture sKey;
    private Picture dKey;
    private Picture fKey;
    private Picture spaceKey;

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

        //System.out.println("startBullet() wurde aufgerufen");
    }

    public void update(double dt){
        super.update(dt);

        if (timer > 1 && !tutorialStarted){
            startTutorial();
        }
        if (tutorialStarted){

        }

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

    private void startTutorial(){
        tutorialStarted = true;

        wKey = new Picture(220, 900,  "src/main/resources/graphic/keys/wkey.png");
        aKey = new Picture(100, 1000, "src/main/resources/graphic/keys/akey.png");
        sKey = new Picture(220, 1000, "src/main/resources/graphic/keys/skey.png");
        dKey = new Picture(340, 1000, "src/main/resources/graphic/keys/dkey.png");
        //fKey = new Picture(bla, bla, "src/main/resources/graphic/keys/fkey.png");
        spaceKey = new Picture(500, 900, "src/main/resources/graphic/keys/spacekey.png");

        // Mit Arrays arbeiten und updaten,
        // bei Picture Methode für Transparenz hinzufügen und Klasse von Picture erbben lassen, updatePositions und updateTransparence dorthin verschieben
    }

}
