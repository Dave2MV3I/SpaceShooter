package my_project.model.enemy;

import KAGO_framework.view.DrawTool;
import my_project.Config;

public class Stardestroyer extends Spaceship {

    public Stardestroyer(){
        this.setNewImage("src/main/resources/graphic/spaceships/stardestroyer1.png");
        //https://www.flaticon.com/free-icons/topdown Topdown icons created by Andrew Dynamite - Flaticon
        //this.health = 20;
        //this.maxHealth = 20;
        this.speed = 32;
        this.cooldown = 4;
        this.cooldownTimer = 4;
    }

    @Override
    public void draw(DrawTool drawTool){
        super.draw(drawTool);
    }

    @Override
    public void update(double dt) {
        super.update(dt);
        if (this.x > Config.WINDOW_WIDTH || this.y > Config.WINDOW_WIDTH || this.y < 0){this.isActive = false;}
    }
}
