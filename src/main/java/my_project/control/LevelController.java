package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.model.Bullet;
import my_project.model.Level;
import my_project.model.Picture;
import my_project.model.Shield;
import my_project.model.enemy.Spaceship;

import static my_project.model.Level.LEVEL1;
import static my_project.model.Level.LEVEL4;

public class LevelController extends GraphicalObject{

    // Attribute
    protected double timer;
    protected int enemyCounter = 0;

    // Flags
    protected boolean levelEnded = false;

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
        for (int i = 0; i < level.nBullets; i++) {
            bullets[i] = new Bullet(pc);
        }
    }

    @Override
    public void draw(DrawTool drawTool){
        //pc.getPlayer().draw(drawTool);
    }

    @Override
    public void update(double dt){
        timer += dt;

        if (pc.getPlayer().getHealth() <= 0) {
            pc.setSceneAndLevel(10);
        }

        // Kollisionserkennung zwischen Bullets und Spaceships
        for (Bullet bullet : bullets) {

            if (bullet.isActive()) {
                for (Spaceship spaceship : spaceships) {

                    if (spaceship.isActive()) {

                        if (spaceship.getX() < - spaceship.getWidth()){
                            pc.setSceneAndLevel(10); //Man verliert, wenn Gegner durchgeflogen ist
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
        if (enemyCounter > spaceships.length && noSpaceships()) {
            if (!levelEnded) {
                if (level != LEVEL4) {
                    pc.setSceneAndLevel(level.myScene + 1); // Next level
                } else pc.setSceneAndLevel(11); // Winner-Screen

                System.out.println("Szene auf 2 gesetzt");
                levelEnded = true;
            }
        }
    }

    private void updateEnemies(){
        switch(level){
            case LEVEL1:
                if (timer > 10 && enemyCounter < 8) {
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

        // Arrays with Objects for the new Level
        spaceships = new Spaceship[level.nSpaceships];
        bullets = new Bullet[level.nBullets];
        shields = new Shield[level.nShields];

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

        Picture bgPicture = new Picture(0, 0, level.bgPicture);
        assert viewController != null;
        viewController.draw(bgPicture, level.myScene);

        assert pc != null;
        pc.getPlayer().setAmmunition(64);

        pc.checkAndHandleMusic(true);
    }

}
