package my_project.control;

import KAGO_framework.view.DrawTool;
import my_project.model.Bullet;
import my_project.model.enemy.SmallSpaceship;

public class Level1 extends LevelControl {

    //Attribute
    int counter = 0;

    //Referenzen
    private final ProgramController pc;

    //Methoden
    public Level1(int nBullets, int nSpaceships, ProgramController pc) {
        super(nBullets, nSpaceships, pc);

        for (int i = 0; i < nBullets; i++) {
            bullets[i] = new Bullet();
        }

        for (int i = 0; i < nSpaceships; i++) {
            spaceships[i] = new SmallSpaceship();
        }
        this.pc = pc;

        //spaceships[1].startSpaceship(300,300, 0.5, pc);
        //bullets[1].startBullet(800, 400, "enemy", 20, 100, 100);
    }

    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
        //System.out.println("startBullet() wurde aufgerufen");
        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i].isActive()) bullets[i].draw(drawTool);
        }

        for (int i = 0; i < spaceships.length; i++) {
            if (spaceships[i].isActive()) spaceships[i].draw(drawTool);
        }
    }

    public void update(double dt){
        super.update(dt);

        if (timer > 10 && counter < 8) {
            for (int j = 0; j < spaceships.length; j++) {
                if (!spaceships[j].isActive()) {
                    spaceships[j].startSpaceship(800, counter * 80, pc);
                    counter += 1;
                    timer = timer % 10;
                    break;
                }
            }
        }
        // Modulo teilt timer durch 1 und erhält den Redt (hinterm Komma); an den nächsten Intervall drangegangen wg. overflow

        if (counter > 7 && noSpaceships()) {
            pc.setCurrentScene(2);
            System.out.println ("Szene auf 2 gesetzt");
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


    public void startBullet (double x, double y, String shooter, int damage, double speedX, double speedY){

        for (int i = 0; i < bullets.length; i++) {
            if (!bullets[i].isActive()){
                bullets[i].startBullet(x, y, shooter, damage, speedX, speedY);
                break;
            }
            //break;
        }
    }


}
