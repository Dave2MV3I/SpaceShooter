package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.Bullet;
import my_project.model.Level;
import my_project.model.Picture;
import my_project.model.Shield;
import my_project.model.spaceships.*;
//import my_project.view.DamageDisplay;

import static my_project.model.Level.*;

public class LevelController{

    // Attribute
    private final Level levelAfterPressingSpace = LEVEL1;  // <<<<<< Entwickleroption >>>>>>
    protected double timer;
    protected int enemyCounter = 0;

    // Flags

    // Arrays
    protected Bullet[] bullets;
    protected Shield[] shields;
    protected Spaceship[] spaceships;

    // Referenzen
    private final ProgramController pc;
    protected final ViewController viewController;
    private Level level;

    public LevelController(ProgramController pc, ViewController viewController) {
        this.pc = pc;
        this.viewController = viewController;
        startLevel(levelAfterPressingSpace);
    }

    public void updateLevel(double dt){
        timer += dt;

        if (pc.getPlayer().getHealth() <= 0) {
            pc.setCurrentScene(10);
        }

        // Kollisionserkennung, zwischen Bullets, Player und Spaceships
        for (Bullet bullet : bullets) {

            if (bullet.isActive()) {
                for (Spaceship spaceship : spaceships) {

                    if (spaceship.isActive()) {

                        //Wenn Spaceship mit Spieler kollidiert
                            if (spaceship.collidesWith(pc.getPlayer())){
                                //Ziehe Player HP ab
                                    if (spaceship instanceof ScratchCat){
                                        pc.getPlayer().modifyHP(-128);
                                    } else if (spaceship instanceof BigSpaceship) {
                                        pc.getPlayer().modifyHP(-48);
                                    }else{
                                        pc.getPlayer().modifyHP(-16);
                                    }

                                //Verliere eventuell das Spiel
                                    if (pc.getPlayer().getHealth() <= 0) pc.getDeathReason().setReason("Du bist mit einem Gegner kollidiert");
                                    if (pc.getSC().getActivity(1)) pc.playSound("impact");

                                spaceship.setActive(false);
                            }

                        //Wenn Bullet mit Gegner kollidiert
                            if (bullet.collidesWith(spaceship) && bullet.getShooter() instanceof Player) {
                                //Ziehe Spieler HP ab
                                    //System.out.println("Hallo");
                                    spaceship.modifyHP(-(bullet.getDamage()));
                                    //System.out.println("Bullet ist mit Gegner kollidiert");
                                    bullet.setIsActive(false);
                            }
                    }
                }
                //Wenn Bullet mit Player kollidiert
                    if (bullet.collidesWith(pc.getPlayer().getHitBoxObject()) && !(bullet.getShooter() instanceof Player)) {
                        //Ziehe Player HP ab und verliere Eventuell
                            if (pc.getSC().getActivity(1)) pc.playSound("impact");
                            if (!pc.getPlayer().isShielded()) pc.getPlayer().modifyHP(-(bullet.getDamage()));
                            if (pc.getPlayer().getHealth() <= 0) pc.getDeathReason().setReason("Du wurdest von einem Schuss getötet");
                            bullet.setIsActive(false);
                    }
            }
        }

        level.updateEnemies(this);

        //Man verliert, wenn ein Gegner durchgeflogen ist
        for (Spaceship spaceship : spaceships){
            if (spaceship.getX() < - spaceship.getWidth()){
                pc.getDeathReason().setReason("Du hast einen Gegner verpasst");
                pc.setCurrentScene(10);
            }
        }

        // Check if level ended and switch if needed
        if (enemyCounter > spaceships.length-1 && noSpaceships()) {
            level.nextScene(this);
        }
    }

    public void startNextBullet(double x, double y, Spaceship shooter, int damage, double speedX, double speedY, boolean isTorpedo){
        for (Bullet bullet : bullets) {
            if (!bullet.isActive()) {
                bullet.startBullet(x, y, shooter, damage, speedX, speedY, isTorpedo);
                break;
            }
        }
    }

    public void startNextShield(double x, double y, ProgramController pc, boolean collected, double spawnTime) {
        if (Math.random() < 0.5) {
            for (Shield shield : shields) {
                if (!shield.isActive()) {
                    boolean moveLeft = Math.random() < 0.5;
                    shield.startShield(x, y, pc, moveLeft, collected, spawnTime);
                    break;
                }
            }
        }
    }

    public void startLevel(Level level) {
        this.level = level;
        System.out.println(level);

        Picture bgPicture = new Picture(0, 0, level.bgPicture);
        assert viewController != null;
        viewController.draw(bgPicture, level.myScene);

        pc.addDrawablesAndInteractables(level.myScene);
        pc.setCurrentScene(level.myScene);

        // Arrays with Objects for the new Level
        spaceships = new Spaceship[level.nSpaceships];
        bullets = new Bullet[level.nBullets];
        shields = new Shield[level.nShields];

        enemyCounter = 0;
        timer %= 10;
        spaceships = level.createEnemies(this);

        if (level == LEVEL5) pc.getPlayer().setCooldown(0);
        
        for (int i = 0; i < level.nBullets; i++) {
            bullets[i] = new Bullet(pc);
        }

        for (int i = 0; i < level.nShields; i++){
            shields[i] = new Shield();
        }

        // Add drawables for them being drawn and updated
        for (Bullet bullet : bullets) {
            // vc darf nicht null sein. Falls doch, kann man es sich mit assert ausgeben lassen
            // besser als if (viewController != null), da man sonst nicht wüsste,
            // warum die Objekte nicht gezeichnet werden, sie würden im Stillen nicht zu den drawables hinzugefügt werden
            viewController.draw(bullet, level.myScene);
        }

        for (Spaceship spaceship : spaceships) {
            viewController.draw(spaceship, level.myScene);
        }
        for (Shield shield : shields) {
            viewController.draw(shield, level.myScene);
        }

        Player p = pc.getPlayer();

        if (level == LEVEL5) {
            p.setHealth(100);

            p.setAmmunition(80);
        } else {
            p.setHealth(50);
            p.setAmmunition(64);
        }

        if (level != levelAfterPressingSpace) pc.checkAndHandleMusic(true);
    }

    public Spaceship[] getSpaceships(){return spaceships;}
    public void setTimer(double timer){this.timer = timer;}
    public void increaseEnemyCounter(){enemyCounter++;}
    public int getEnemyCounter(){return enemyCounter;}
    public double getTimer(){return timer;}
    public ProgramController getPC(){return pc;}
    public String getBgSong() {return level.bgSong;}

    public boolean noSpaceships(){
        for (Spaceship spaceship : spaceships) {
            if (spaceship.isActive()) return false;
        }
        return true;
    }

}
