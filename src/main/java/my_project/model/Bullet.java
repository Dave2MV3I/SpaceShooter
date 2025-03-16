package my_project.model;


import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;


public class Bullet extends GraphicalObject {


    double x, y;
    int damage;
    double speed;
    public BulletControl bulletControl;
    private String shooter;

    public Bullet(BulletControl bulletcontrol, double x, double y, int damage, double speed, String shooter) {
        this.bulletControl = bulletcontrol;
        this.bulletControl.addBullet(this);

        this.shooter = shooter;

        this.x = x;
        this.y = y;
        this.damage = damage;
        this.speed = speed;

    }

    public void draw (DrawTool drawTool) {
        drawTool.setCurrentColor(255, 255, 255, 255);
        drawTool.drawFilledCircle(this.x, this.y, 5);
    }


    public void update (double dt, Spaceship sp1, Spaceship sp2, Spaceship sp3, Spaceship sp4, Spaceship sp5, Spaceship sp6, Spaceship sp7, Spaceship sp8, Spaceship sp9, Spaceship sp10, Player player) {
        this.x = this.x + speed * dt;


        if (this.shooter == "player"){
            if (sp1 != null && this.collidesWith(sp1)) {
                sp1.setHealth(-damage);
                bulletControl.removeBullet(this);
            } else if (sp2 != null && this.collidesWith(sp2)) {
                sp2.setHealth(-damage);
                bulletControl.removeBullet(this);
            } else if (sp3 != null && this.collidesWith(sp3)) {
                sp3.setHealth(-damage);
                bulletControl.removeBullet(this);
            } else if (sp4 != null && this.collidesWith(sp4)) {
                sp4.setHealth(-damage);
                bulletControl.removeBullet(this);
            } else if (sp5 != null && this.collidesWith(sp5)) {
                sp5.setHealth(-damage);
                bulletControl.removeBullet(this);
            } else if (sp6 != null && this.collidesWith(sp6)) {
                sp6.setHealth(-damage);
                bulletControl.removeBullet(this);
            } else if (sp7 != null && this.collidesWith(sp7)) {
                sp7.setHealth(-damage);
                bulletControl.removeBullet(this);
            } else if (sp8 != null && this.collidesWith(sp8)) {
                sp8.setHealth(-damage);
                bulletControl.removeBullet(this);
            } else if (sp9 != null && this.collidesWith(sp9)) {
                sp9.setHealth(-damage);
                bulletControl.removeBullet(this);
            } else if (sp10 != null && this.collidesWith(sp10)) {
                sp10.setHealth(-damage);
                bulletControl.removeBullet(this);
            }
        } else if (this.shooter == "enemy"){
            if (this.collidesWith(player)) {
                player.setHealth(-damage);
                bulletControl.removeBullet(this);
            }
        }

    }
}