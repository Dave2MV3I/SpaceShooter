package my_project.model.spaceships;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;


public abstract class Spaceship extends InteractiveGraphicalObject{
    protected int maxHealth;
    protected int health;
    protected double speed;

    protected boolean isActive;
    protected ProgramController pc;

    protected double cooldown;
    protected double cooldownTimer;

    public Spaceship(String path, double speed){
        this.setNewImage(path);
        //System.out.println("Spaceship wurde aufgerufen");
        this.speed = speed;
    }

    public void draw(DrawTool drawTool){
        if (isActive){
            drawTool.drawImage(getMyImage(),x,y);
            drawHealthBar(drawTool);
        }
    }


    public void update(double dt){
        if (this.isActive && !pc.getUI().getMenuOpen()) {
            this.x -= speed*dt;
            if (cooldownTimer < 0) {
                this.cooldownTimer = cooldown;
                if (this.x > pc.getPlayer().getX()) {
                    //double phi = Math.atan2(-this.y + pc.getPlayer().getY(), -this.x + pc.getPlayer().getX());
                    double phi = Math.atan2(-this.y + pc.getPlayer().getY() + pc.getPlayer().getHeight()/2, -this.x + pc.getPlayer().getX() + pc.getPlayer().getWidth()/2);
                    //System.out.println(phi);
                    if (this instanceof BigSpaceship) {
                        pc.getLevelController().startBullet(this.x, this.y + this.getHeight() / 2, "enemy", 20, 250 * Math.cos(phi), 250 * Math.sin(phi));
                    }
                    if (this instanceof SmallSpaceship) {
                        pc.getLevelController().startBullet(this.x, this.y + this.getHeight() / 2, "enemy", 10, 150 * Math.cos(phi), 150 * Math.sin(phi));
                    }
                    if (this instanceof ScratchCat) {
                        pc.getLevelController().startBullet(this.x, this.y + this.getHeight() / 2, "enemy", 64, 200 * Math.cos(phi), 200 * Math.sin(phi));
                    }
                }
            } else {
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
        if (this instanceof BigSpaceship){
            this.health = 40;
            this.maxHealth = this.health;
        }

        if (this instanceof ScratchCat){
            this.health = 128;
            this.maxHealth = this.health;
        }
    }

    public void modifyHP(int points) {
        this.health += points;
        if (health <= 0) {
            isActive = false;
            pc.getLevelController().startShield(this.getX(), this.getY(), pc, false, 5000);
            if (pc.getSC().getActivity(1)) pc.playSound("explosion");
        }
    }

    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        isActive = active;
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
