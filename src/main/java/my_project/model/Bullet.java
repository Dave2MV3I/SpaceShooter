package my_project.model;


import my_project.Config;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;


public class Bullet extends GraphicalObject {



    int damage;
    double speedX, speedY;
    private String shooter;
    public boolean isActive;

    //wpublic BulletControl bulletControl;


    public Bullet() {
        this.isActive = false;
    }

    public void startBullet(double x, double y, String shooter, int damage, double speedX, double speedY) {
        this.isActive = true;

        this.x = x;
        this.y = y;

        this.shooter = shooter;

        this.damage = damage;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public void draw(DrawTool drawTool) {
        if (isActive) {

            //drawTool.setCurrentColor(255, 255, 255, 255);
            drawTool.setCurrentColor(255, 0, 0, 255);
            drawTool.drawFilledCircle(this.x, this.y, 5);
        }
    }


    public void update(double dt) {
        if (isActive) {
            this.x = this.x + speedX * dt;
            this.y = this.y + speedY * dt;
            if (this.x > Config.WINDOW_WIDTH){this.isActive = false;}
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public String getShooter() {
        return shooter;
    }
}