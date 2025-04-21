package my_project.model.enemy;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;
import my_project.model.player.Player;


public class Spaceship extends GraphicalObject{
    protected int maxHealth;
    protected int health;
    protected double speed;
    protected boolean isActive;
    protected ProgramController pc;

    protected double cooldown;
    protected double cooldownTimer;



    public void draw(DrawTool drawTool){
        //drawTool.drawFilledCircle (this.x, this.y, 1);
        drawTool.drawImage(getMyImage(),x,y);

        drawHealthBar(drawTool);
    }


    public void update(double dt){
        if (this.isActive) {
            this.x -= speed*dt;
            if (cooldownTimer < 0) {
                this.cooldownTimer = cooldown;
                if (this.x > pc.getPlayer().getX()) {
                    double phi = Math.atan2(-this.y + pc.getPlayer().getY(), -this.x + pc.getPlayer().getX());
                    //System.out.println(phi);
                    pc.getCurrentLevel().startBullet(this.x, this.y + this.getHeight() / 2, "enemy", 10, 64 * Math.cos(phi), 64 * Math.sin(phi));
                }

            }else {
                cooldownTimer = cooldownTimer - dt;
            }
        }
    }

    public void startSpaceship(double x, double y, ProgramController pc) {
        this.isActive = true;
        this.x = x;
        this.y = y;
        this.pc = pc;
        if (this instanceof SmallSpaceship){
        this.health = 20;
        this.maxHealth = this.health;
        }

    }

        public void modifyHP(int points) {
            this.health += points;
            if (health <= 0) isActive = false;
        }

    public boolean isActive() {
        return isActive;
    }

    private void drawHealthBar(DrawTool drawTool) {
        double barWidth = 40;
        double barHeight = 5;
        double h = this.health;
        double mH = this.maxHealth;

        double healthPercentage =  (h/mH);
        //System.out.println(healthPercentage);

        drawTool.setCurrentColor(255, 0, 0, 255);
        drawTool.drawFilledRectangle(x, y - 10, barWidth, barHeight);
        drawTool.setCurrentColor(0, 255, 0, 255);
        drawTool.drawFilledRectangle(x, y - 10, barWidth * healthPercentage, barHeight);
    }
}
