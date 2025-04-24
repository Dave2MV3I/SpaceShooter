package my_project.model.player;

import KAGO_framework.view.DrawTool;
import my_project.Config;
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

    private final double cooldown;
    private double cooldownTimer;

    private final ProgramController pc;

    public Player(double x, double y, ProgramController pc) {
        super();
        this.setNewImage("src/main/resources/graphic/spaceships/spaceship.png");
        this.x = x;
        this.y = y;
        hoverUp = true;

        this.pc = pc;

        this.cooldown = 0.5;
        this.cooldownTimer = 0.5;
        this.speed = 100;

        this.health = 50;
        this.maxHealth = 50;
    }


    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
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

        pc.getUI().setPlayerOutside(x < 0 || y < 0 || x > Config.WINDOW_WIDTH || y > Config.WINDOW_HEIGHT-29);
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

        if (this.cooldownTimer < 0) {
            pc.getCurrentLevel().startBullet(this.x + this.getWidth(), this.y + (this.getHeight() / 2), "player", 10, 100, 0);
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