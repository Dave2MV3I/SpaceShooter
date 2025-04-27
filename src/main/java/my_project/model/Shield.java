package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;
import my_project.model.player.Player;


public class Shield extends GraphicalObject {

    private boolean movingLeft;
    private boolean collected;
    private double spawnTime;
    private final int stayDuration = 3000;
    private ProgramController programController;

    private boolean isActive;

    public Shield(){ this.isActive = false; }

    public static void startShield() {
    }

    public void startShield(double x, double y, ProgramController programController, boolean movingLeft, boolean collected, double spawnTime){
        this.isActive = true;

        this.x = x;
        this.y = y;

        this.programController = programController;
        this.movingLeft = Math.random() < 0.5;
        this.spawnTime = System.currentTimeMillis();
        this.collected = false;
    }





    public void draw(DrawTool drawTool){
        if (isActive) {
            drawTool.setCurrentColor(0, 0, 255, 150);
            drawTool.drawFilledCircle(this.x, this.y, 10);
        }
    }


    @Override
    public void update(double dt) {
        if (isActive) {
            if (movingLeft) {
                this.x -= 100 * dt;
                if (this.x + this.width < 0) {
                    programController.getViewController().removeDrawable(this);
                }
            } else {
                if (System.currentTimeMillis() - spawnTime > stayDuration) {
                    programController.getViewController().removeDrawable(this);
                }
            }

            Player player = programController.getPlayer();
            if (!collected && this.collidesWith(player)) {
                collected = true;
                activatePlayerShield(player);
                programController.getViewController().removeDrawable(this);
            }

        }

    }

    public boolean isActive() {
        return isActive;
    }

    private void activatePlayerShield(Player player) {
        player.activateShield();
    }
}

