package my_project.model.spaceships;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;


public abstract class Spaceship extends InteractiveGraphicalObject{
    protected int maxHealth;
    protected int health;
    protected double speed;

    protected boolean isActive;

    protected boolean movement1;
    protected boolean movement2;
    protected boolean movement3;
    double trackingSpeed = 100;
    private double boostSpeed;
    private double boostDuration = 0.5;
    private double boostCooldown = 2.5;
    private double boostTimer = 0;
    private double cooldownTimerBoost = 0;
    private boolean isBoosting = false;
    private double baseY;



    protected ProgramController pc;

    protected double cooldown;
    protected double cooldownTimer;

    public Spaceship(String path, double speed){
        this.setNewImage(path);
        //System.out.println("Spaceship wurde aufgerufen");
        this.speed = speed;
        this.boostSpeed = speed*2;
    }

    public void draw(DrawTool drawTool){
        if (isActive){
            drawTool.drawImage(getMyImage(),x,y);
            drawHealthBar(drawTool);
        }
    }


    public void update(double dt){
        if (this.isActive && !pc.getUI().getMenuOpen()) {
            //if (this instanceof Starfighter) {  weiss nicht ob ihr das für alle spaceships möchtet
            if (movement1) {
                this.x -= speed * dt;
                if (this.y < pc.getPlayer().getY()) {
                    this.y += trackingSpeed * dt;
                } else if (this.y > pc.getPlayer().getY()) {
                    this.y -= trackingSpeed * dt;
                }
            } else if (movement2) {
                if (this.isActive && !pc.getUI().getMenuOpen()) {

                    if (isBoosting) {
                        boostTimer -= dt;
                        if (boostTimer <= 0) {
                            isBoosting = false;
                            cooldownTimerBoost = 0;  // Cooldown fängt neu an
                        }
                    } else {
                        cooldownTimerBoost += dt;
                        if (cooldownTimerBoost >= boostCooldown) {
                            isBoosting = true;
                            boostTimer = boostDuration;
                        }
                    }
                    double currentSpeed = isBoosting ? boostSpeed : speed;
                    this.x -= currentSpeed * dt;
                }
            } else if (movement3) {
                x -= speed * dt;

                double amplitude = 50;
                double frequency = 2;
                y = baseY + Math.sin(pc.getGlobalTimer() * frequency) * amplitude;
            }
            // }
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


                if (cooldownTimer < 0) {
                    this.cooldownTimer = cooldown;
                    if (this.x > pc.getPlayer().getX()) {
                        double phi = Math.atan2(-this.y + pc.getPlayer().getY(), -this.x + pc.getPlayer().getX());
                        //System.out.println(phi);
                     //   if (this instanceof Stardestroyer) {
                         //   pc.getLevelController().startBullet(this.x, this.y + this.getHeight() / 2, "enemy", 20, 250 * Math.cos(phi), 250 * Math.sin(phi));
                       // }
                        if (this instanceof SmallSpaceship) {
                            pc.getLevelController().startBullet(this.x, this.y + this.getHeight() / 2, "enemy", 10, 150 * Math.cos(phi), 150 * Math.sin(phi));
                        }
                        if (this instanceof ScratchCat) {
                            pc.getLevelController().startBullet(this.x, this.y + this.getHeight() / 2, "enemy", 64, 150 * Math.cos(phi), 150 * Math.sin(phi));
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
        this.baseY = y;

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

        int movementNumber = (int)(Math.random() * 3) + 1;

        if (movementNumber == 1){
            movement1=true;
        }

        if (movementNumber == 2){
            movement2= true;
        }

        if (movementNumber == 3){
            movement3=true;
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
