package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.Bullet;
import my_project.model.Level;
import my_project.model.Picture;
import my_project.model.Shield;
import my_project.model.spaceships.*;

import static my_project.model.Level.*;

public class LevelController{

    // Attribute
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
        startLevel(LEVEL1);
    }

    public void updateLevel(double dt){
        timer += dt;

        if (pc.getPlayer().getHealth() <= 0) {
            pc.setCurrentScene(10);
        }

        // Kollisionserkennung zwischen Bullets und Spaceships
        for (Bullet bullet : bullets) {

            if (bullet.isActive()) {
                for (Spaceship spaceship : spaceships) {

                    if (spaceship.isActive()) {

                        if (spaceship.getX() < - spaceship.getWidth()){
                            pc.setCurrentScene(10); //Man verliert, wenn Gegner durchgeflogen ist
                        }

                        // Man verliert HP, wenn man mit Gegner kollidiert
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

                if (bullet.collidesWith(pc.getPlayer().getHitBoxObject()) && bullet.getShooter().equals("enemy")) {
                    if (pc.getSC().getActivity(1)) pc.playSound("impact");
                    if (!pc.getPlayer().isShielded()) pc.getPlayer().modifyHP(-(bullet.getDamage()));
                    bullet.setIsActive(false);
                }
            }
        }

        updateEnemies();

        // Check if level ended
        //System.out.println(enemyCounter > spaceships.length-1 && noSpaceships());
        if (enemyCounter > spaceships.length-1 && noSpaceships()) {

                //enemyCounter = 0;
                if (level == LEVEL1) {
                    startLevel(LEVEL2);
                } else if (level == LEVEL2) {
                    startLevel(LEVEL4);
                } else if (level == LEVEL3) {
                    startLevel(LEVEL4);
                } else if (level == LEVEL4) {
                    pc.setCurrentScene(11);
                    System.out.println("WONNNN");
                } // Winner-Screen
                //if (level == LEVEL5) startLevel(LEVEL5);

        }
    }

    private void updateEnemies(){
        switch(level){
            case LEVEL1:
                if (timer > 1 && enemyCounter < 8) { // 1 statt 10
                    for (Spaceship spaceship : spaceships) {
                        if (!spaceship.isActive()) {
                            spaceship.startSpaceship(800, enemyCounter * 80, pc);
                            enemyCounter += 1;
                            timer = timer % 10; // Modulo teilt timer durch 1 und erhält den Rest (hinterm Komma); ans nächste Intervall drangegangen wg. overflow
                            break;
                        }
                    }
                }

            case LEVEL2:
                if (timer > 10 && enemyCounter < 8) {
                    System.out.println("Spaceship gestartet (2)");
                    for (Spaceship spaceship : spaceships) {

                        if (!spaceship.isActive()) {
                            spaceship.startSpaceship(800, enemyCounter * 55, pc);
                            enemyCounter += 1;

                            break;
                        }
                    }

                    for (Spaceship spaceship : spaceships) {
                        if (!spaceship.isActive()) {
                            spaceship.startSpaceship(800, 700 - enemyCounter * 55, pc);
                            enemyCounter += 1;
                            timer = timer % 10;
                            break;
                        }
                    }
                }

            case LEVEL3:
                if (timer > 10 && enemyCounter < 8) {
                    //System.out.println("Spaceship gestartet (2)");
                    if (enemyCounter %2 == 0){
                        for (int j = 0; j < spaceships.length-4; j++) {
                            if (!spaceships[j].isActive()) {
                                spaceships[j].startSpaceship(800, enemyCounter * 80, pc);
                                enemyCounter += 1;
                            }
                        }
                    }

                    if (enemyCounter %2 == 1){
                        for (int j = spaceships.length - 4; j < spaceships.length; j++) {
                            if (!spaceships[j].isActive()) {
                                spaceships[j].startSpaceship(800, enemyCounter * 80, pc);
                                enemyCounter += 1;
                            }
                        }
                    }
                }

            case LEVEL4:
                if (timer > 10 && enemyCounter < 8) {
                    //System.out.println("Spaceship gestartet (2)");
                    for (Spaceship spaceship : spaceships) {

                        if (!spaceship.isActive()) {
                            spaceship.startSpaceship(800, enemyCounter * 60, pc);
                            enemyCounter += 1;

                            break;
                        }
                    }

                    for (Spaceship spaceship : spaceships) {
                        if (!spaceship.isActive()) {
                            spaceship.startSpaceship(800, 700 - enemyCounter * 50, pc);
                            enemyCounter += 1;
                            timer = timer % 10;
                            break;
                        }
                    }

                }

            case LEVEL5:
        }
    }

    public void startBullet(double x, double y, String shooter, int damage, double speedX, double speedY){

        for (Bullet bullet : bullets) {
            if (!bullet.isActive()) {
                bullet.startBullet(x, y, shooter, damage, speedX, speedY);
                break;
            }
        }
    }

    public void startShield(double x, double y, ProgramController pc, boolean collected, double spawnTime) {
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


    public String getBgSong() {
        return level.bgSong;
    }

    public boolean noSpaceships(){
        for (Spaceship spaceship : spaceships) {
            if (spaceship.isActive()) return false;
        }
        return true;
    }

    public void startLevel(Level level) {
        this.level = level;

        Picture bgPicture = new Picture(0, 0, level.bgPicture);
        assert viewController != null;
        viewController.draw(bgPicture, level.myScene);

        pc.addDrawablesAndInteractables(level.myScene);
        if (level != LEVEL4) pc.setCurrentScene(level.myScene);

        // Arrays with Objects for the new Level
        spaceships = new Spaceship[level.nSpaceships];
        bullets = new Bullet[level.nBullets];
        shields = new Shield[level.nShields];

        for (int i = 0; i < level.nBullets; i++) {
            bullets[i] = new Bullet(pc);
        }

        enemyCounter = 0;
        createEnemies();

        for (int i = 0; i < level.nShields; i++){
            shields[i] = new Shield();
        }

        // Add drawables for them being drawn and updated
        for (Bullet bullet : bullets) {
            assert viewController != null;
            // vc darf nicht null sein. Falls doch, kann man es sich mit assert ausgeben lassen
            // besser als if (viewController != null), da man sonst nicht wüsste,
            // warum die Objekte nicht gezeichnet werden, sie würden im Stillen nicht zu den drawables hinzugefügt werden
            viewController.draw(bullet, level.myScene);
        }

        for (Spaceship spaceship : spaceships) {
            assert viewController != null;
            viewController.draw(spaceship, level.myScene);
        }
        for (Shield shield : shields) {
            assert viewController != null;
            viewController.draw(shield, level.myScene);
        }

        assert pc != null;
        pc.getPlayer().setAmmunition(64);

        //apc.checkAndHandleMusic(true);
    }

    private void createEnemies(){
        switch(level){
            case LEVEL1:
                for (int i = 0; i < level.nSpaceships; i++) {
                    spaceships[i] = new SmallSpaceship();
                }
            case LEVEL2:
                for (int i = 0; i < level.nSpaceships; i++) {
                    spaceships[i] = new SmallSpaceship();
                }
            case LEVEL3:
                for (int i = 0; i < level.nSpaceships - 4; i++) {
                    spaceships[i] = new SmallSpaceship();
                }
                for (int i = level.nSpaceships - 4; i < level.nSpaceships; i++) {
                    spaceships[i] = new Stardestroyer();
                }
            case LEVEL4:
                for (int i = 0 ; i < level.nSpaceships; i++) {
                    spaceships[i] = new Stardestroyer();
                }
        }
    }

    public Spaceship[] getSpaceships(){return spaceships;}

}
