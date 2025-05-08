package my_project.model.spaceships;

import KAGO_framework.view.DrawTool;
import my_project.Config;
import my_project.control.ProgramController;

public class Starfighter extends Spaceship {
    private ProgramController pc;
    private double movementRandomizer = Math.random();

    public Starfighter(ProgramController pc){
        super("src/main/resources/graphic/spaceships/stardestroyer.png", 35);
        //https://www.flaticon.com/free-icons/topdown Topdown icons created by Andrew Dynamite - FlatIcon
        this.cooldown = 3;
        this.cooldownTimer = 3;
        this.pc = pc;

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
