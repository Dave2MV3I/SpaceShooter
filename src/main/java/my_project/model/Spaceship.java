package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;


public class Spaceship extends GraphicalObject{

    double x, y;
    int health;
    double speed;
    public boolean isActive;
    private ProgramController pc;
    private double cooldown;
    private double cooldownTimer;


    public void draw (DrawTool drawTool){
        //drawTool.drawFilledCircle (this.x, this.y, 1);
        drawTool.drawImage(getMyImage(),x,y);
    }


    public void update(double dt){
        if (this.isActive) {
            this.x -= speed*dt;
            if (cooldownTimer < 0) {
                this.cooldownTimer = cooldown;

                double phi = Math.atan2(- this.y + pc.getPlayer().getY(), - this.x +pc.getPlayer().getX());
                pc.level1.startBullet(this.x, this.y + this.getHeight()/2, "enemy", 10, 64* Math.cos(phi), 64*Math.sin(phi) );

            }else {
                cooldownTimer = cooldownTimer - dt;
            }
        }
    }

    public void startSpaceship(double x, double y, double cooldown, ProgramController pc) {
        this.isActive = true;

        this.cooldown = cooldown;
        this.cooldownTimer = cooldown;
        this.x = x;
        this.y = y;
        this.pc = pc;
    }

    public void setHealth (int health){
        this.health += health;
    }

    public boolean isActive() {
        return isActive;
    }
}
