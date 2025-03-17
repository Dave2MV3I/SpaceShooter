package my_project.model;

import KAGO_framework.view.DrawTool;

public class SmallSpaceship extends Spaceship{

    public SmallSpaceship(){
        this.setNewImage("src/main/resources/graphic/SpaceshipSmall.png");
        // https://www.flaticon.com/free-icons/topdown Topdown icons created by Andrew Dynamite - Flaticon

        speed = 25;
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
