package my_project.control;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.model.Bullet;
import my_project.model.enemy.SmallSpaceship;
import my_project.model.enemy.Spaceship;

public abstract class LevelControl extends GraphicalObject{

    private final ProgramController pc;
    Bullet[] bullets;
    Spaceship[] spaceships;
    protected double timer;
    protected double globalTimer;
    protected String bgSong;

    public LevelControl(int nSpaceships, ProgramController pc, String bgSong) {

        int nBullets = nSpaceships*5 + 20;
        spaceships = new Spaceship[nSpaceships];

        bullets = new Bullet[nBullets];
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
        //System.out.println("Update des lvl wird aufgerufen ;)");
        pc.getPlayer().update(dt);

        //SOLVED Kollisionserkennung reparieren (fragt nicht wo das Problem ist, kp)
        //System.out.println("");
        for (Bullet bullet : bullets) {

            if (bullet.isActive()) {
                //System.out.println("Bullet existiert" + i);
                for (Spaceship spaceship : spaceships) {

                    if (spaceship.isActive()) {

                        //Man verliert, wenn Gegner "durchgeflogen ist
                        if (spaceship.getX() < - spaceship.getWidth()){
                            pc.setSceneOrLevel(10);
                        }

                        //Man verliert HP wennn man mit Gegner kollidiert
                        if (spaceship.collidesWith(pc.getPlayer())){
                            spaceship.setActive(false);
                            pc.getPlayer().modifyHP(-16);
                            if (pc.getSC().getActivity(1)) pc.playSound("impact");
                        }

                        if (bullet.collidesWith(spaceship) && bullet.getShooter().equals("player")) {
                            spaceship.modifyHP(-(bullet.getDamage()));
                            System.out.println("Bullet ist mit Gegner kollidiert");

                            bullet.setIsActive(false);
                        }
                    }
                }

                if (bullet.collidesWith(pc.getPlayer()) && bullet.getShooter().equals("enemy")) {
                    if (pc.getSC().getActivity(1)) pc.playSound("impact");
                    pc.getPlayer().modifyHP(-(bullet.getDamage()));
                    bullet.setIsActive(false);
                }
            }
        }

        if (pc.getPlayer().getHealth() <= 0) {
            pc.setSceneOrLevel(10);
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
    public Spaceship[] getSpaceships() { return spaceships;}

}
