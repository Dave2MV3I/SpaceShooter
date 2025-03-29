package my_project.model.enemy;

import KAGO_framework.view.DrawTool;
import my_project.Config;

public class SmallSpaceship extends Spaceship {

    public SmallSpaceship(){
        this.setNewImage("src/main/resources/graphic/spaceships/SpaceshipSmall.png");
        //https://www.flaticon.com/free-icons/topdown Topdown icons created by Andrew Dynamite - Flaticon

        this.speed = 25;
        this.cooldown = 5;
        this.cooldownTimer = 5;
    }

    @Override
    public void draw(DrawTool drawTool){
        super.draw(drawTool);
    }

    @Override
    public void update(double dt) {
        super.update(dt);
        if (this.x > Config.WINDOW_WIDTH || this.x < 0 || this.y > Config.WINDOW_WIDTH || this.y < 0){this.isActive = false;}
    }
}
