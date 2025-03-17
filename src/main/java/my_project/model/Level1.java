package my_project.model;

import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

public class Level1 extends LevelControl{
    //Referenzen
    private ProgramController programController;


    //Methoden
    public Level1(int nBullets, int nSpaceships, ProgramController programController) {
        super(nBullets, nSpaceships);

        for (int i = 0; i < nBullets; i++) {
            bullets[i] = new Bullet();
        }

        for (int i = 0; i < nSpaceships; i++) {
            spaceships[i] = new Spaceship();
        }

        this.programController = programController;;
    }

    public void draw (DrawTool drawTool) {
        System.out.println("startBullet() wurde aufgerufen");
        for (int i = 0; i < bullets.length; i++) {

            bullets[i].draw(drawTool);
        }

        for (int i = 0; i < spaceships.length; i++) {
            spaceships[i].draw(drawTool);
        }

        programController.getPlayer().draw(drawTool);
    }

    public void update (double dt){
        for (int i = 0; i < bullets.length; i++) {
            bullets[i].update(dt);
        }

        for (int i = 0; i < spaceships.length; i++) {
            spaceships[i].update(dt);
        }

        programController.getPlayer().update(dt);
    }

    public void startBullet (double x, double y, String shooter, int damage, double speed){

        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i].isActive == false){
                bullets[i].startBullet(x, y, shooter, damage, speed);
                break;
            }
        }
    }


}
