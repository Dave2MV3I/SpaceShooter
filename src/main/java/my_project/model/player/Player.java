package my_project.model.player;

import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;
import my_project.model.enemy.Spaceship;

import java.awt.event.KeyEvent;

public class Player extends Spaceship {

    private double hoverY;
    private boolean hoverUp;

    private boolean floatUp = false;
    private boolean floatDown = false;
    private boolean floatRight = false;
    private boolean floatLeft = false;


    public int health;
    private int speed = 100;

    private double cooldown;
    private double cooldownTimer;

    private ProgramController pc;

    public Player(double x, double y, ProgramController pc) {
        super();
        this.setNewImage("src/main/resources/graphic/spaceships/spaceship.png");
        this.x = x;
        this.y = y;
        hoverUp = true;
        this.health = 50; //50
        this.pc = pc;

        this.cooldown = 0.5;
        this.cooldownTimer = 0.5;
        this.speed = 100;
    }


    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(getMyImage(),x,y+hoverY);
    }

    @Override
    public void update(double dt/*, Spaceship sp1, Spaceship sp2, Spaceship sp3, Spaceship sp4, Spaceship sp5, Spaceship sp6, Spaceship sp7, Spaceship sp8, Spaceship sp9, Spaceship sp10, Player player*/) {

        // Bewegung auf der Stelle
        if (hoverUp) {
            hoverY = hoverY - 8 * dt;
            if (hoverY < -5) hoverUp = false;
        } else {
            hoverY = hoverY + 8 * dt;
            if (hoverY > 5) hoverUp = true;
        }

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
    }

    public void processWASD(int keyCode, boolean pressed) {
        if (keyCode == KeyEvent.VK_W) {
            if (pressed) {
                floatUp = true;
            } else floatUp = false;

        } else if (keyCode == KeyEvent.VK_A) {
            if (pressed) {
                floatLeft = true;
            } else floatLeft = false;

        } else if (keyCode == KeyEvent.VK_S) {
            if (pressed) {
                floatDown = true;
            } else floatDown = false;

        } else if (keyCode == KeyEvent.VK_D) {
            if (pressed) {
                floatRight = true;
            } else floatRight = false;
        }
    }

    public void processSpace() {
        //new Bullet (this.pc.bulletControl , this.x + this.getWidth(), this.y + (this.getHeight()/2), 10, 50, "enemy");

        if (this.cooldownTimer < 0) {
            pc.getLevel(1).startBullet(this.x + this.getWidth(), this.y + (this.getHeight() / 2), "player", 50, 100, 0);
            this.cooldownTimer = this.cooldown;
        }
    }

    public void modifyHP(int points){
        this.health += points;
    }



    public int getHealth() {
        return health;
    }

}