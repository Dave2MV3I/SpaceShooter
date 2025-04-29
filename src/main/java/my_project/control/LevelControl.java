package my_project.control;

import KAGO_framework.control.Drawable;
import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.model.Bullet;
import my_project.model.Shield;
import my_project.model.enemy.Spaceship;

public abstract class LevelControl extends GraphicalObject{

    private final ProgramController pc;
    private final ViewController viewController;
    protected Bullet[] bullets;
    protected Shield[] shields;
    protected Spaceship[] spaceships;
    protected double timer;
    protected double globalTimer;
    protected String bgSong;

    protected int counter = 0;
    protected boolean levelEnded = false;
    protected int myScene;

    public LevelControl(int nSpaceships, ProgramController pc, String bgSong, int nShields, ViewController viewController, int scene, int nBullets) {

        spaceships = new Spaceship[nSpaceships];
        bullets = new Bullet[nBullets];
        shields = new Shield[nShields];

        for (int i = 0; i < nBullets; i++) {
            bullets[i] = new Bullet(pc);
        }

        this.pc = pc;
        this.bgSong = bgSong;
        this.viewController = viewController;
        myScene = scene;
    }

    @Override
    public void draw(DrawTool drawTool){
        //pc.getPlayer().draw(drawTool);
    }

    @Override
    public void update(double dt){
        timer += dt;
        globalTimer += dt;
        //pc.getPlayer().update(dt);

        if (pc.getPlayer().getHealth() <= 0) {
            pc.setSceneOrLevel(10);
        }

        /*
        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i].isActive()) bullets[i].update(dt);
        }

        for (int i = 0; i < spaceships.length; i++) {
            if (spaceships[i].isActive()) spaceships[i].update(dt);
        }

        for (int i = 0; i < shields.length; i++) {
            if (shields[i].isActive()) shields[i].update(dt);
        }*/


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
                    if (pc.getPlayer().isShielded()) {}
                    else {
                        pc.getPlayer().modifyHP(-(bullet.getDamage()));
                    }
                    bullet.setIsActive(false);
                }
            }
        }

        // Kollisionsüberprüfung Player und Bullets (shooter nicht instanceof player)

        // Kollisionsüberprüfung jeder Bullet mit jedem Spaceship (shooter instanceof player)
    }

    public void startBullet(double x, double y, String shooter, int damage, double speedX, double speedY){

        for (Bullet bullet : bullets) {
            if (!bullet.isActive()) {
                bullet.startBullet(x, y, shooter, damage, speedX, speedY);
                break;
            }
            //break;
        }
    }

    public void startShield(double x, double y, ProgramController programController, boolean movingLeft, boolean collected, double spawnTime) {
        if (Math.random() < 0.5) {
            for (Shield shield : shields) {
                if (!shield.isActive()) {
                    boolean moveLeft = Math.random() < 0.5;
                    shield.startShield(x, y, programController, moveLeft, collected, spawnTime);
                    break;
                }
            }
        }
    }


    public String getBgSong() {
        return bgSong;
    }

    public double getTimer() { return timer;}
    public double getGlobalTimer() { return globalTimer;}
    public Spaceship[] getSpaceships() { return spaceships;}

    public boolean noSpaceships(){
        for (int i = 0; i< spaceships.length; i++){
            if (spaceships[i].isActive()) return false;
        }
        return true;
    }

    public void addDrawables() {
        for (Bullet bullet : bullets) {
            viewController.draw(bullet, myScene);
        }

        for (Spaceship spaceship : spaceships) {
            viewController.draw(spaceship, myScene);
        }

        for (Shield shield : shields) {
            viewController.draw(shield, myScene);
        }
    }

}
