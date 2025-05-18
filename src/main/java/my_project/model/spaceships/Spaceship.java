package my_project.model.spaceships;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;
import my_project.model.DamageDisplay;


public abstract class Spaceship extends InteractiveGraphicalObject{
    protected int maxHealth;
    protected int health;
    protected double speed;

    protected boolean isActive;

    private int typeOfMovement;
    double trackingSpeed = 100;
    private double boostSpeed;
    private double boostDuration = 0.5;
    private double boostCooldown = 2.5;
    private double boostTimer = 0;
    private double cooldownTimerBoost = 0;
    private boolean isBoosting = false;
    private double baseY;

    // Shooting Attributes
    protected double bulletSpeedX;
    protected double bulletSpeedY;
    protected int bulletDamage;
    protected boolean bulletIsTorpedo;

    protected ProgramController pc;

    protected double cooldown;
    protected double cooldownTimer;

    public Spaceship(String path, double speed, double bulletSpeedX, double bulletSpeedY, int bulletDamage, boolean bulletIsTorpedo) {
        this.setNewImage(path);
        //System.out.println("Spaceship wurde aufgerufen");
        this.speed = speed;
        this.boostSpeed = speed*2;

        this.bulletSpeedX = bulletSpeedX;
        this.bulletSpeedY = bulletSpeedY;
        this.bulletDamage = bulletDamage;
        this.bulletIsTorpedo = bulletIsTorpedo;
    }

    public void draw(DrawTool drawTool){
        if (isActive){
            drawTool.drawImage(getMyImage(),x,y);
            drawHealthBar(drawTool);
        }
    }


    public void update(double dt){
        if (this.isActive && !pc.getUI().getMenuOpen()) {

            if (!(this instanceof ScratchCat))
                switch(typeOfMovement){
                    case 1: movement1(dt);
                    break;
                    case 2: movement2(dt);
                    break;
                    case 3: movement3(dt);
                    break;
            }

            // Firing shots
            if (cooldownTimer < 0) {
                Player p = pc.getPlayer();
                this.cooldownTimer = cooldown;
                if (this.x > p.getX()) {

                    // SCHUSS AB MITTE LINKS DES GEGNERS
                    double phi = Math.atan2((p.getY() + p.getHeight() / 2) - (this.y + this.height / 2), (p.getX() + p.getWidth() / 2) - this.x);

                    pc.getLevelController().startNextBullet(this.x, this.y + this.getHeight() / 2, this, bulletDamage, bulletSpeedX * Math.cos(phi), bulletSpeedY * Math.sin(phi), bulletIsTorpedo);

                    // SCHUSS AB MITTELPUNKT DES GEGNERS
                    /*
                    double sourceX = this.x + this.getWidth() / 2;
                    double sourceY = this.y + this.getHeight() / 2;
                    double targetX = p.getX() + p.getWidth() / 2;
                    double targetY = p.getY() + p.getHeight() / 2;
                    double phi = Math.atan2(targetY - sourceY, targetX - sourceX);

                    pc.getLevelController().startNextBullet(sourceX, sourceY, this, bulletDamage, bulletSpeedX * Math.cos(phi), bulletSpeedY * Math.sin(phi), bulletIsTorpedo);
                    */
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
            this.health = 200;
            this.maxHealth = this.health;
        }

        if (this instanceof Starfighter){
            this.health = 30;
            this.maxHealth = this.health;
        }

        if (!(this instanceof ScratchCat)) typeOfMovement = (int)(Math.random() * 3) + 1;
    }


    public void modifyHP(int points) {
        this.health += points;
        pc.getViewController().draw(new DamageDisplay(this.getX(), this.getY(), Math.abs(points)), pc.getCurrentScene());
        if (health <= 0) {
            isActive = false;
            pc.getLevelController().startNextShield(this.getX(), this.getY(), pc, false, 5000);
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
        double barWidth = 0.5*this.maxHealth;
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

    public void movement1(double dt){
        this.x -= speed * dt;
        if (this.y < pc.getPlayer().getY()) {
            this.y += trackingSpeed * dt;
        } else if (this.y > pc.getPlayer().getY()) {
            this.y -= trackingSpeed * dt;
        }
    }

    public void movement2(double dt){
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

    public void movement3(double dt){
        x -= speed * dt;

        double amplitude = 50;
        double frequency = 2;
        y = baseY + Math.sin(pc.getGlobalTimer() * frequency) * amplitude;
    }
}
