package my_project.model.spaceships;

import KAGO_framework.control.SoundController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;
import my_project.control.ProgramController;

import java.awt.event.KeyEvent;

public class Player extends Spaceship {

    private int ammunition;
    private double hoverY;
    private boolean hoverUp;

    private boolean floatUp = false;
    private boolean floatDown = false;
    private boolean floatRight = false;
    private boolean floatLeft = false;

    private final double cooldown;
    private double cooldownTimer;

    private final ProgramController pc;
    HitBoxObject hitBoxObject;


    private boolean isShielded;
    private double shieldEndTime;

    public Player(double x, double y, ProgramController pc) {
        super("src/main/resources/graphic/spaceships/spaceship.png", 200);
        this.x = x;
        this.y = y;
        hoverUp = true;

        this.pc = pc;

        this.cooldown = 0.0;
        this.cooldownTimer = 0.3;

        this.health = 50;
        this.maxHealth = 50;

        this.isActive = true;

        hitBoxObject = new HitBoxObject(x+15, y+10, getWidth()-21, getHeight()-20);
    }

    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
        if (isShielded){
            drawTool.setCurrentColor(0, 0, 255, 30);
            drawTool.drawFilledCircle(x+width/2, y+width/2, 40);
        }
        //getHitBoxObject().draw(drawTool);
    }

    @Override
    public void update(double dt) {

        // Bewegung auf der Stelle
        if (hoverUp) {
            hoverY = hoverY - 8 * dt;
            if (hoverY < -5) hoverUp = false;
        } else {
            hoverY = hoverY + 8 * dt;
            if (hoverY > 5) hoverUp = true;
        }

        // Bewegung durch Interaktion
        if (floatUp) {
            y -= speed * dt;
        }
        if (floatRight) {
            x += speed * dt;
        }
        if (floatLeft) {
            x -= speed * dt;
        }
        if (floatDown) {
            y += speed * dt;
        }

        this.cooldownTimer = this.cooldownTimer - dt;

        pc.getUI().setPlayerOutside(x+width < 0 || y+height < 0 || x > Config.WINDOW_WIDTH || y > Config.WINDOW_HEIGHT-29);

        if (isShielded && System.currentTimeMillis() > shieldEndTime) {
            isShielded = false;
        }

        //links min 15, rechts min 6 und o und u min 10
        //hoehe 40 br 39
        //10px tiefer, 15px weiter rechts als vorher

        hitBoxObject.setX(x+15);
        hitBoxObject.setY(y+10);
    }

    @Override
    public void keyPressed(int key){
        processWASD(key, true);
        if (key == KeyEvent.VK_SPACE) processSpace();
    }

    @Override
    public void keyReleased(int key){
        processWASD(key, false);
    }

    public void processWASD(int keyCode, boolean pressed) {
        if (keyCode == KeyEvent.VK_W) {
            floatUp = pressed;

        } else if (keyCode == KeyEvent.VK_A) {
            floatLeft = pressed;

        } else if (keyCode == KeyEvent.VK_S) {
            floatDown = pressed;

        } else if (keyCode == KeyEvent.VK_D) {
            floatRight = pressed;
        }
    }

    public void processSpace() {
        //new Bullet (this.pc.bulletControl , this.x + this.getWidth(), this.y + (this.getHeight()/2), 10, 50, "enemy");

        if (this.cooldownTimer < 0 && this.ammunition > 0) {
            pc.getLevelController().startBullet(this.x + this.getWidth(), this.y + (this.getHeight() / 2), "player", 10, 200, 0);
            if (pc.getCurrentScene() > 0 && pc.getCurrentScene() < 10) if (pc.getSC().getActivity(1)) SoundController.playSound("laser");
            this.cooldownTimer = this.cooldown;
            this.ammunition = this.ammunition - 1;
            //System.out.println(this.ammunition);
        }
    }


    public void activateShield() {
        isShielded = true;
        shieldEndTime = System.currentTimeMillis() + 5000;
    }
    public int getShieldsActivityTime(){return (int)(shieldEndTime-System.currentTimeMillis());}

    public boolean isShielded() {
            return isShielded;
        }

    public void modifyHP(int points){
        this.health += points;
    }
    public int getHealth() {
        return health;
    }
    public int getAmmunition(){return ammunition;}
    public void setAmmunition(int ammunition) {
        this.ammunition = ammunition;
    }

    private class HitBoxObject extends GraphicalObject{
        public HitBoxObject(double x, double y, double width, double height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        @Override
        public void draw(DrawTool drawTool) {
            drawTool.drawRectangle(x, y, width, height);
        }
    }
    public HitBoxObject getHitBoxObject(){return hitBoxObject;}
}