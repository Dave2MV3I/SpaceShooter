package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;


public class Spaceship extends GraphicalObject{

    double x, y;
    int health;
    double speed;
    public boolean isActive;


    public void draw (DrawTool drawTool){
        //drawTool.drawFilledCircle (this.x, this.y, 1);
        drawTool.drawImage(getMyImage(),x,y);
    }


    public void update(double dt){
        this.x -= speed*dt;
        //if (this.health > 0){
        //}
    }

    public void startSpaceship(double x, double y) {
        this.isActive = true;

        this.x = x;
        this.y = y;
    }

    public void setHealth (int health){
        this.health += health;
    }

    public boolean isActive() {
        return isActive;
    }
}
