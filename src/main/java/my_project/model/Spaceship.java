package my_project.model;


import KAGO_framework.view.DrawTool;


public class Spaceship {
    double x, y;
    int health;
    double speed;


    public void draw (DrawTool drawTool){
        drawTool.drawFilledCircle (this.x, this.y, 1);
    }


    public void update (double dt){
        this.x = this.x + speed*dt;
        if (this.health > 0){

        }
    }
}
