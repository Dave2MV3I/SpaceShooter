package my_project.model;


import my_project.Config;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;


public class Bullet extends GraphicalObject {



    private int damage;
    double speedX, speedY;
    private String shooter;

    private boolean isActive;
    boolean isTorpedo;
    private ProgramController pc;


    public Bullet(ProgramController pc) {
        this.isActive = false;
        this.pc = pc;
    }

    public void startBullet(double x, double y, String shooter, int damage, double speedX, double speedY, boolean isTorpedo) {
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
        }
    }


    public void update(double dt) {
        if (isActive && !pc.getUI().getMenuOpen()) {
            if (isTorpedo) {
                double phi = Math.atan2( this.y - pc.getPlayer().getY(), this.x - pc.getPlayer().getX());
                speedX = 256*Math.cos(phi);
                speedY = 256*Math.sin(phi);
                System.out.println("Hallo");
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

    public String getShooter() {
        return shooter;
    }

    public int getDamage() {return damage;}
}