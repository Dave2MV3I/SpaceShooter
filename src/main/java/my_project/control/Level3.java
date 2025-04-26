package my_project.control;

import KAGO_framework.view.DrawTool;
import my_project.model.Bullet;
import my_project.model.enemy.SmallSpaceship;
import my_project.model.enemy.Stardestroyer;

public class Level3 extends LevelControl{
    //Attribute
    int counter = 0;

    //Referenzen
    private final ProgramController pc;

    //Methoden
    public Level3(int nSpaceships, ProgramController pc, String bgSong) {
        super(nSpaceships, pc, bgSong);
        int nBullets = nSpaceships*5 + 20;

        counter = 0;
        this.pc = pc;

        for (int i = 0; i < nBullets; i++) {
            bullets[i] = new Bullet();
        }

        for (int i = 0; i < nSpaceships - 4; i++) {
            spaceships[i] = new SmallSpaceship();
        }

        for (int i = nSpaceships - 3; i < nSpaceships; i++) {
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
        super.update(dt);
        System.out.println("level2.update aufgerufen");
        if (timer > 10 /*&& counter < 8*/) {
            //System.out.println("Spaceship gestartet (2)");
            if (counter%2 == 0){
                for (int j = 0; j < spaceships.length-4; j++) {
                    if (spaceships[j].isActive()) {
                        spaceships[j].startSpaceship(800, counter * 80, pc);
                    }
                }
            }

            if (counter%2 == 1){
                for (int j = spaceships.length - 3; j < spaceships.length; j++) {
                    if (spaceships[j].isActive()) {
                        spaceships[j].startSpaceship(800, counter * 80, pc);
                    }
                }
            }
        }



        // Modulo teilt timer durch 1 und erhält den Redt (hinterm Komma); an den nächsten Intervall drangegangen wg. overflow

        if (counter > 7 && noSpaceships()) {
            pc.setSceneOrLevel(4);
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
