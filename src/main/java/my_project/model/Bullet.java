package my_project.model;


import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;


public class Bullet extends GraphicalObject {


    double x, y;
    int damage;
    double speed;
    private String shooter;
    public boolean isActive;

    public BulletControl bulletControl;


    public Bullet(/*BulletControl bulletcontrol, double x, double y, int damage, double speed, String shooter*/) {
        this.isActive = false;

        //this.bulletControl = bulletcontrol;
        //this.bulletControl.addBullet(this);

        //this.shooter = shooter;

        //this.x = x;
        //this.y = y;

        //this.damage = damage;
        //this.speed = speed;
    }

    public void startBullet (double x, double y, String shooter, int damage, double speed) {
        this.isActive = true;



        this.x = x;
        this.y = y;

        this.shooter = shooter;

        this.damage = damage;
        this.speed = speed;
    }

    public void draw (DrawTool drawTool) {
        if (isActive) {


            //TODO hier wird die methode aufgerufen, aber aus irgendeinem grund nichts gezeichnet
            drawTool.setCurrentColor(255, 255, 255, 255);
            drawTool.drawFilledCircle(this.x, this.y, 5);
        }
    }


    public void update (double dt) {
        if (isActive) {

            this.x = this.x + speed * dt;


        }
    }
}