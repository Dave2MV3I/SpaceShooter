package my_project.model;


import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;


public class Bullet extends GraphicalObject {


    double x, y;
    int damage;
    double speed;
    public BulletControl bulletControl;

    public Bullet(BulletControl bulletcontrol, double x, double y, int damage, double speed) {
        this.bulletControl = bulletcontrol;
        this.bulletControl.addBullet(this);

        this.x = x;
        this.y = y;
        this.damage = damage;
        this.speed = speed;

    }

    public void draw (DrawTool drawTool) {
        drawTool.drawFilledCircle(this.x, this.y, 5);
    }


    public void update (double dt, Object shooter, Spaceship sp1, Spaceship sp2, Spaceship sp3, Spaceship sp4, Spaceship sp5, Spaceship sp6, Spaceship sp7, Spaceship sp8, Spaceship sp9, Spaceship sp10, Player player) {
        this.x = this.x + speed * dt;

        if (shooter instanceof Player){
            if (this.collidesWith(sp1)) {
                sp1.setHealth(-damage);
                bulletControl.removeBullet(this);
            } else if (this.collidesWith(sp2)) {
                sp2.setHealth(-damage);
                bulletControl.removeBullet(this);
            } else if (this.collidesWith(sp3)) {
                sp3.setHealth(-damage);
                bulletControl.removeBullet(this);
            } else if (this.collidesWith(sp4)) {
                sp4.setHealth(-damage);
                bulletControl.removeBullet(this);
            } else if (this.collidesWith(sp5)) {
                sp5.setHealth(-damage);
                bulletControl.removeBullet(this);
            } else if (this.collidesWith(sp6)) {
                sp6.setHealth(-damage);
                bulletControl.removeBullet(this);
            } else if (this.collidesWith(sp7)) {
                sp7.setHealth(-damage);
                bulletControl.removeBullet(this);
            } else if (this.collidesWith(sp8)) {
                sp8.setHealth(-damage);
                bulletControl.removeBullet(this);
            } else if (this.collidesWith(sp9)) {
                sp9.setHealth(-damage);
                bulletControl.removeBullet(this);
            } else if (this.collidesWith(sp10)) {
                sp10.setHealth(-damage);
                bulletControl.removeBullet(this);
            }
        } else if (shooter instanceof Spaceship){
            if (this.collidesWith(player)) {
                player.setHealth(-damage);
                bulletControl.removeBullet(this);
            }
        }

    }
}