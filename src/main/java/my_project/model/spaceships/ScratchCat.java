package my_project.model.spaceships;

import KAGO_framework.view.DrawTool;
import my_project.Config;
import my_project.control.ProgramController;

public class ScratchCat extends Spaceship {

    int vy = 200;
    ProgramController pc;

    public ScratchCat(ProgramController pc){
        super("src/main/resources/graphic/spaceships/smallSpaceship.png", 0);
        this.pc = pc;
        //https://www.flaticon.com/free-icons/topdown Topdown icons created by Andrew Dynamite - FlatIcon
        this.cooldown = 1;
        this.cooldownTimer = 1;
        //System.out.println("created");
    }

    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
    }

    @Override
    public void update(double dt) {
        super.update(dt);
        if (this.y < pc.getPlayer().getY()){
            if (this.y > 0+this.height){
                this.y -= dt*vy;
            }
        } else if (this.y > pc.getPlayer().getY()) {
            if (this.y + this.height < Config.WINDOW_HEIGHT-50) {
                this.y += vy*dt;
            }
        }

        if (this.x < 0  || this.x > Config.WINDOW_WIDTH || this.y < 0){this.isActive = false;}
    }
}
