package my_project.model;


import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;


public class Bullet extends GraphicalObject {


    double x, y;
    int damage;
    double speed;
    public BulletControl bulletControl;

    public Bullet(BulletControl bulletcontrol) {
        this.bulletControl = bulletcontrol;
    }

    public void draw(DrawTool drawTool) {
        drawTool.drawFilledCircle(this.x, this.y, 1);
    }


    public void Update(double dt, Spaceship sp1, Spaceship sp2, Spaceship sp3, Spaceship sp4, Spaceship sp5, Spaceship sp6, Spaceship sp7, Spaceship sp8, Spaceship sp9, Spaceship sp10, Spaceship player) {
        this.x = this.x + speed * dt;

        if (this.collidesWith(sp1)) {
            sp1.health -= damage;
            bulletControl.removeBullet(this);
        } else if (this.collidesWith(sp2)) {
            sp2.health -= damage;
            bulletControl.removeBullet(this);
        } else if (this.collidesWith(sp3)) {
            sp3.health -= damage;
            bulletControl.removeBullet(this);
        } else if (this.collidesWith(sp4)) {
            sp4.health -= damage;
            bulletControl.removeBullet(this);
        } else if (this.collidesWith(sp5)) {
            sp5.health -= damage;
            bulletControl.removeBullet(this);
        } else if (this.collidesWith(sp6)) {
            sp6.health -= damage;
            bulletControl.removeBullet(this);
        } else if (this.collidesWith(sp7)) {
            sp7.health -= damage;
            bulletControl.removeBullet(this);
        } else if (this.collidesWith(sp8)) {
            sp8.health -= damage;
            bulletControl.removeBullet(this);
        } else if (this.collidesWith(sp9)) {
            sp9.health -= damage;
            bulletControl.removeBullet(this);
        } else if (this.collidesWith(sp10)) {
            sp10.health -= damage;
            bulletControl.removeBullet(this);
        } else if (this.collidesWith(player)) {
            player.health -= damage;
            bulletControl.removeBullet(this);
        }
    }
}