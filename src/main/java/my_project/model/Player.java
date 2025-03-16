package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

import java.awt.event.KeyEvent;

public class Player extends GraphicalObject {

    private double hoverY;
    private boolean hoverUp;

    private boolean floatUp = false;
    private boolean floatDown = false;
    private boolean floatRight = false;
    private boolean floatLeft = false;

    public int health;
    private int speed = 100;

    private ProgramController programController;

    public Player(double x, double y, ProgramController programController){
        this.setNewImage("src/main/resources/graphic/spaceship.png");
        this.x = x;
        this.y = y;
        hoverUp = true;
        this.health = 50;
        this.programController = programController;

    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(getMyImage(),x,y+hoverY);
    }

    @Override
    public void update(double dt/*, Spaceship sp1, Spaceship sp2, Spaceship sp3, Spaceship sp4, Spaceship sp5, Spaceship sp6, Spaceship sp7, Spaceship sp8, Spaceship sp9, Spaceship sp10, Player player*/){
        // Bewegung auf der Stelle
        if (hoverUp){
            hoverY = hoverY - 8*dt;
            if (hoverY < -5) hoverUp = false;
        } else {
            hoverY = hoverY + 8*dt;
            if (hoverY > 5) hoverUp = true;
        }

        if (floatUp){
            y -= speed*dt;
        }
        if (floatRight){
            x += speed*dt;
        }
        if (floatLeft){
            x -= speed*dt;
        }
        if (floatDown){
            y += speed*dt;
        }
    }

    public void processWASD(int keyCode, boolean pressed){
        if (keyCode == KeyEvent.VK_W) {
            if (pressed){
                floatUp = true;
            } else floatUp = false;

        } else if (keyCode == KeyEvent.VK_A) {
            if (pressed){
                floatLeft = true;
            } else floatLeft = false;

        } else if (keyCode == KeyEvent.VK_S) {
            if (pressed){
                floatDown = true;
            } else floatDown = false;

        } else if (keyCode == KeyEvent.VK_D) {
            if (pressed){
                floatRight = true;
            } else floatRight = false;
        }
    }

    public void processSpace (int keyCode, boolean pressed){
        if (keyCode == KeyEvent.VK_SPACE && pressed){
                new Bullet (this.programController.bulletControl , this.x + this.getWidth(), this.y + (this.getHeight()/2), 10, 100, "player");
        }
    }

    public void setHealth (int health){
        this.health += health;
    }

}
