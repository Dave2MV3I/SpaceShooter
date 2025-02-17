package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Player extends GraphicalObject {

    private double hoverY;
    private boolean hoverUp;

    public Player(double x, double y){
        this.setNewImage("src/main/resources/graphic/spaceship.png");
        this.x = x;
        this.y = y;
        hoverUp = true;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(getMyImage(),x,y+hoverY);
    }

    @Override
    public void update(double dt){
        // Bewegung auf der Stelle
        if (hoverUp){
            hoverY = hoverY - 8*dt;
            if (hoverY < -5) hoverUp = false;
        } else {
            hoverY = hoverY + 8*dt;
            if (hoverY > 5) hoverUp = true;
        }
    }

}
