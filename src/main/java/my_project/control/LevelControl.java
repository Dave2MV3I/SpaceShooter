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
    protected String bgSong;

    public LevelControl(int nBullets, int nSpaceships, ProgramController pc, String bgSong) {

        bullets = new Bullet[nBullets];
        spaceships = new SmallSpaceship[nSpaceships];
        this.pc = pc;
        this.bgSong = bgSong;
    }

    @Override
    public void draw(DrawTool drawTool){
        pc.getUI().draw(drawTool);
        pc.getPlayer().draw(drawTool);
    }

    @Override
    public void update(double dt){
        timer += dt;
        globalTimer += dt;
        pc.getUI().update(dt);
        pc.getPlayer().update(dt);

        //SOLVED Kollisionserkennung reparieren (fragt nicht wo das Problem ist, kp)
        //System.out.println("");
        for (Bullet bullet : bullets) {

            if (bullet.isActive()) {
                //System.out.println("Bullet existiert" + i);
                for (SmallSpaceship spaceship : spaceships) {

                    if (spaceship.isActive()) {
                        if (bullet.collidesWith(spaceship) && bullet.getShooter().equals("player")) {
                            spaceship.modifyHP(-(bullet.getDamage()));
                            System.out.println("Bullet ist mit Gegner kollidiert");

                            bullet.setIsActive(false);
                        }
                    }
                }

                if (bullet.collidesWith(pc.getPlayer()) && bullet.getShooter().equals("enemy")) {
                    pc.getPlayer().modifyHP(-(bullet.getDamage()));
                    bullet.setIsActive(false);
                }
            }
        }

        if (pc.getPlayer().getHealth() <= 0) {
            pc.setSceneOrLevel(4);
        }
        // Kollisionsüberprüfung Player und Bullets (shooter nicht instanceof player)

        // Kollisionsüberprüfung jeder Bullet mit jedem Spaceship (shooter instanceof player)
    }

    public void startBullet (double x, double y, String shooter, int damage, double speedX, double speedY){

        for (Bullet bullet : bullets) {
            if (!bullet.isActive()) {
                bullet.startBullet(x, y, shooter, damage, speedX, speedY);
                break;
            }
            //break;
        }
    }

    public String getBgSong() {
        return bgSong;
    }
    public double getTimer() { return timer;}
    public double getGlobalTimer() { return globalTimer;}

}
