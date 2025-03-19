package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

public abstract class LevelControl extends GraphicalObject     {

    private final ProgramController pc;
    Bullet[] bullets;
    SmallSpaceship[] spaceships;
    protected double timer;

    public LevelControl(int nBullets, int nSpaceships, ProgramController pc) {

        bullets = new Bullet[nBullets];
        spaceships = new SmallSpaceship[nSpaceships];
        this.pc = pc;

    }

    @Override
    public void draw(DrawTool drawTool){
        pc.getPlayer().draw(drawTool);
    }

    @Override
    public void update(double dt){
        timer += dt;
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
                            spaceships[j].modifyHP(-(bullets[i].damage));
                            System.out.println("Bullet ist mit Gegner kollidiert");
                            //TODO funktion fuer bullet collision (frag joshi genaueres)

                            bullets[i].setIsActive(false);
                        }
                    }
                }

                if (bullets[i].collidesWith(pc.getPlayer()) && bullets[i].getShooter().equals("enemy")) {
                    pc.getPlayer().modifyHP(-(bullets[i].damage));
                    bullets[i].setIsActive(false);
                }

            }

        }
        // Kollisionsüberprüfung Player und Bullets (shooter nicht instanceof player)

        // Kollisionsüberprüfung jeder Bullet mit jedem Spaceship (shooter instanceof player)
    }

}
