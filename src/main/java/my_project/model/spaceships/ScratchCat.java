package my_project.model.spaceships;

import KAGO_framework.view.DrawTool;
import my_project.Config;

public class ScratchCat extends Spaceship {

    int vy = 30;

    public ScratchCat(){
        super("src/main/resources/graphic/spaceships/smallSpaceship.png", 100);
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
        if (this.y < pc.getPlayer().getY()){
            if (this.y > 0){
                this.y = this.y - dt*vy;
            }
        }else if (this.y > pc.getPlayer().getY()) {
            if (this.y < Config.WINDOW_HEIGHT) {
                this.y = this.y + dt * vy;
            }
        }


        if (this.x > Config.WINDOW_WIDTH || this.y > Config.WINDOW_WIDTH || this.y < 0){this.isActive = false;}
    }
}
