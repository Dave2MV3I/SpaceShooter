package my_project.model.spaceships;

import KAGO_framework.view.DrawTool;
import my_project.Config;

public class SmallSpaceship extends Spaceship {

    public SmallSpaceship(){
        super("src/main/resources/graphic/spaceships/smallSpaceship.png", 50);
        //https://www.flaticon.com/free-icons/topdown Topdown icons created by Andrew Dynamite - FlatIcon
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
