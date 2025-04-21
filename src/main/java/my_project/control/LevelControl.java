package my_project.control;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.model.Bullet;
import my_project.model.enemy.SmallSpaceship;

public abstract class LevelControl extends GraphicalObject{

    private final ProgramController pc;
    Bullet[] bullets;
    SmallSpaceship[] spaceships;
    protected double timer;
    protected double globalTimer;

    public LevelControl(int nBullets, int nSpaceships, ProgramController pc) {

        bullets = new Bullet[nBullets];
        spaceships = new SmallSpaceship[nSpaceships];
        this.pc = pc;
        pc.getViewController().register(pc.getUI(),1);
    }

    @Override
    public void draw(DrawTool drawTool){
        pc.getUI().draw(drawTool);
        pc.getPlayer().draw(drawTool);
        /*drawTool.setCurrentColor(255, 255, 255, 255);
        drawTool.drawFilledRectangle (0, 0, 100, 48);
        drawTool.setCurrentColor(0, 0, 0, 255);
        drawTool.drawText (2, 10, "Dauer des Levels:");
        drawTool.setCurrentColor(0, 0, 0, 255);
        drawTool.drawText (44, 40, String.valueOf((int) globalTimer + "s"));*/
    }

    @Override
    public void update(double dt){
        timer += dt;
        globalTimer += dt;
        pc.getUI().update(dt);
        pc.getPlayer().update(dt);

        //SOLVED Kollisonserkennung reparieren (fragt nicht wo das Problem ist, kp)
        //System.out.println("");
        for (int i = 0; i < bullets.length; i++) {

            if (bullets[i].isActive()){
                //System.out.println("Bullet existiert" + i);
                for (int j = 0; j < spaceships.length; j++) {

                    if (spaceships[j].isActive()) {
                        //System.out.println("Spaceship existiert");
                        //System.out.println("Distance to Bullet: " + bullets[i].getDistanceTo(spaceships[j]));
                        if (bullets[i].collidesWith(spaceships[j]) && bullets[i].getShooter().equals("player")) {
                            spaceships[j].modifyHP(-(bullets[i].getDamage()));
                            System.out.println("Bullet ist mit Gegner kollidiert");
                            //TODO funktion fuer bullet collision (frag joshi genaueres)

                            bullets[i].setIsActive(false);
                        }
                    }
                }

                if (bullets[i].collidesWith(pc.getPlayer()) && bullets[i].getShooter().equals("enemy")) {
                    pc.getPlayer().modifyHP(-(bullets[i].getDamage()));
                    bullets[i].setIsActive(false);
                }
            }
        }

        if (pc.getPlayer().getHealth() <= 0) {
            pc.setCurrentSceneAndLevel(4);
        }
        // Kollisionsüberprüfung Player und Bullets (shooter nicht instanceof player)

        // Kollisionsüberprüfung jeder Bullet mit jedem Spaceship (shooter instanceof player)
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
