package my_project.model;

import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

public class Level1 extends LevelControl{

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

        spaceships[1].startSpaceship(300,300, 0.5, pc);
        bullets[1].startBullet(800, 400, "enemy", 20, 100, 100);
    }

    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
        //System.out.println("startBullet() wurde aufgerufen");
        for (int i = 0; i < bullets.length; i++) {
            bullets[i].draw(drawTool);
        }

        for (int i = 0; i < spaceships.length; i++) {
            if (spaceships[i].isActive) spaceships[i].draw(drawTool);
        }
    }

    public void update (double dt){
        for (int i = 0; i < bullets.length; i++) {
            bullets[i].update(dt);
        }

        for (int i = 0; i < spaceships.length; i++) {
            spaceships[i].update(dt);
        }
        super.update(dt);
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
