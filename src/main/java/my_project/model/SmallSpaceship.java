package my_project.model;

import KAGO_framework.view.DrawTool;

public class SmallSpaceship extends Spaceship{

    public SmallSpaceship(){
        this.setNewImage("src/main/resources/graphic/SpaceshipSmall.png");
        // https://www.flaticon.com/free-icons/topdown Topdown icons created by Andrew Dynamite - Flaticon

        this.speed = 25;
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
    }
}
