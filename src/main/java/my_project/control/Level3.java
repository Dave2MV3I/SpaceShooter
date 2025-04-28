package my_project.control;

import KAGO_framework.view.DrawTool;
import my_project.model.Bullet;
import my_project.model.Shield;
import my_project.model.enemy.SmallSpaceship;
import my_project.model.enemy.Spaceship;
import my_project.model.enemy.Stardestroyer;

public class Level3 extends LevelControl{
    //Attribute

    //Referenzen
    private final ProgramController pc;

    //Methoden
    public Level3(int nSpaceships, ProgramController pc, String bgSong, int nShields) {
        super(nSpaceships, pc, bgSong, nShields);
        int nBullets = nSpaceships*5 + 20;

        counter = 0;
        this.pc = pc;

        for (int i = 0; i < nBullets; i++) {
            bullets[i] = new Bullet();
        }

        for (int i = 0; i < nSpaceships - 4; i++) {
            spaceships[i] = new SmallSpaceship();
        }

        for (int i = nSpaceships - 4; i < nSpaceships; i++) {
            spaceships[i] = new Stardestroyer();
        }
        for (int i = 0; i < nShields; i++){
            shields[i] = new Shield();
        }
    }


    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
        //System.out.println("Lvl3 wird gezeichnet");

    }

    public void update(double dt){
        super.update(dt);
        if (timer > 10 && counter < 8) {
            //System.out.println("Spaceship gestartet (2)");
            if (counter%2 == 0){
                for (int j = 0; j < spaceships.length-4; j++) {
                    if (!spaceships[j].isActive()) {
                        spaceships[j].startSpaceship(800, counter * 80, pc);
                        counter += 1;
                    }
                }
            }

            if (counter%2 == 1){
                for (int j = spaceships.length - 4; j < spaceships.length; j++) {
                    if (!spaceships[j].isActive()) {
                        spaceships[j].startSpaceship(800, counter * 80, pc);
                        counter += 1;
                    }
                }
            }
        }

        // Modulo teilt timer durch 1 und erhält den Rest (hinterm Komma); an den nächsten Intervall drangegangen wg. overflow

        if (counter > 7 && noSpaceships()) {
            //System.out.println(pc.getCurrentScene());
            pc.setSceneOrLevel(4);
        }

    }


}
