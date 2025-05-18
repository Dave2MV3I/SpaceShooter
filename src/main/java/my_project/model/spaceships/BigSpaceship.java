package my_project.model.spaceships;

import KAGO_framework.view.DrawTool;
import my_project.Config;

public class BigSpaceship extends Spaceship {

    public BigSpaceship(){
        super("src/main/resources/graphic/spaceships/stardestroyer1.png", 25, 256, 250, 20, false);
        //https://www.flaticon.com/free-icons/topdown Topdown icons created by Andrew Dynamite - Flaticon
        //this.health = 20;
        //this.maxHealth = 20;
        this.cooldown = 2;
        this.cooldownTimer = 2;
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
