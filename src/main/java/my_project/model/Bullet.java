package my_project.model;


import my_project.Config;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;
import my_project.model.spaceships.Spaceship;


public class Bullet extends GraphicalObject {



    private int damage;
    double speedX, speedY;
    private Spaceship shooter;

    private boolean isActive;
    boolean isTorpedo;
    private ProgramController pc;


    public Bullet(ProgramController pc) {
        this.isActive = false;
        this.pc = pc;
    }

    public void startBullet(double x, double y, Spaceship shooter, int damage, double speedX, double speedY, boolean isTorpedo) {
        this.isActive = true;
        this.isTorpedo = isTorpedo;
        this.x = x;
        this.y = y;

        this.shooter = shooter;

        this.damage = damage;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public void draw(DrawTool drawTool) {
        if (isActive) {
            drawTool.setCurrentColor(0, 255, 255, 255); //TODO change back color?
            drawTool.drawFilledCircle(this.x, this.y, 5);

            double absSpeed = Math.sqrt(Math.pow(this.speedX, 2) + Math.pow(this.speedY, 2));
            drawTool.setCurrentColor(255, 0, 0, 150);

            for (int i = 0; i < 5; i++){
                drawTool.drawFilledCircle(this.x- (speedX/ absSpeed)*5*i, this.y - (speedY/ absSpeed)*5*i, 4.5-0.5*i);
            }

            if (isTorpedo) {
                drawTool.setCurrentColor(255, 255, 255, 150);
                for (int i = 0; i < 5; i++){
                    drawTool.drawFilledCircle(this.x- (speedX/ absSpeed)*5*i, this.y - (speedY/ absSpeed)*5*i, 4.5-0.5*i);
                }
            }
        }
    }


    public void update(double dt) {
        if (isActive && !pc.getUI().getMenuOpen()) {
            if (isTorpedo) {
                //System.out.println("Torpedo");

                double dx = pc.getPlayer().getX() + pc.getPlayer().getWidth()/2 - this.x;
                double dy = pc.getPlayer().getY() + pc.getPlayer().getHeight()/2 - this.y;
                double phi = Math.atan2(dy, dx);

                speedX = 256*Math.cos(phi);
                speedY = 256*Math.sin(phi);
            }

            this.x = this.x + speedX * dt;
            this.y = this.y + speedY * dt;

            if (this.x > Config.WINDOW_WIDTH || this.x < 0 || this.y > Config.WINDOW_WIDTH || this.y < 0){this.isActive = false;}
        }
    }

    public boolean isActive() {
        return isActive;
    }
    public void setIsActive(boolean active) {
        isActive = active;
    }

    public Spaceship getShooter() {
        return shooter;
    }

    public int getDamage() {return damage;}
}