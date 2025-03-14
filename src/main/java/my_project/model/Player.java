package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Player extends GraphicalObject {

    private double hoverY;
    private boolean hoverUp;

    private boolean floatUp = false;
    private boolean floatDown = false;
    private boolean floatRight = false;
    private boolean floatLeft = false;

    public int health;
    private int speed = 100;

    public Player(double x, double y){
        this.setNewImage("src/main/resources/graphic/spaceship.png");
        this.x = x;
        this.y = y;
        hoverUp = true;
        this.health = 50;
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

    public void setDirection(int direction){
        if (direction == 1){
            floatUp = true;
        } else floatUp = false;

        if (direction == 2){
            floatDown = true;
        } else floatDown = false;

        if (direction == 3){
            floatLeft = true;
        }  else floatLeft = false;

        if (direction == 4){
            floatRight = true;
        } else floatRight = false;
    }

    public void setHealth (int health){
        this.health += health;
    }

}
