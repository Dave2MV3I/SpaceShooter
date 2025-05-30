package my_project.model.spaceships;

import KAGO_framework.view.DrawTool;
import my_project.Config;
import my_project.control.ProgramController;

public class ScratchCat extends Spaceship {

    int vy = 200;
    boolean floatingUp;
    ProgramController pc;

    public ScratchCat(ProgramController pc){
        super("src/main/resources/graphic/spaceships/miau.png", 0, 196, 200, 64, false);
        this.pc = pc;

        this.cooldown = 1;
        this.cooldownTimer = 1;
        //System.out.println("created");
    }

    @Override
    public void update(double dt) {
        super.update(dt);

        // Endgegner fliegt von alleine hoch und runter
        if (floatingUp) {
            if (this.y + this.height < Config.WINDOW_HEIGHT-50) {
                this.y += dt * vy;
            } else floatingUp = false;
        } else {
            if (this.y > 20) {
                this.y -= dt * vy;
            } else floatingUp = true;
        }

        // Endgegner fliegt hoch, wenn Player unter ihm und andersherum - fliegt also vertikal von ihm weg
        /*if (this.y < pc.getPlayer().getY()){
            if (this.y > 0+this.height){
                this.y -= dt*vy;
            }
        } else if (this.y > pc.getPlayer().getY()) {
            if (this.y + this.height < Config.WINDOW_HEIGHT-50) {
                this.y += vy*dt;
            }
        }*/

        if (this.x < 0  || this.x > Config.WINDOW_WIDTH || this.y < 0){this.isActive = false;}
    }
}
