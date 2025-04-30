package my_project.model;

import KAGO_framework.view.DrawTool;

public class FadingPicture extends Picture{

    private double fadingTimer;
    private double timerLength = 5;
    private double endY;

    public FadingPicture(double x, double y, String path, double endY) {
        super(x, y, path);
        this.endY = endY;
    }

    @Override
    public void draw(DrawTool drawTool) {
        //if ((fadingTimer/timerLength)*255 > 0) drawTool.setCurrentColor(255,255,255, (int)(255-(fadingTimer/timerLength)*255));
        if (fadingTimer > 0){drawTool.setCurrentColor(255,255,255, 50);}
        super.draw(drawTool);
    }

    @Override
    public void update(double dt){
        if (y > endY) {
            y -= 100 * dt;
        } else fadingTimer += dt;;
    }

    public boolean getFadingEnded(){return fadingTimer >= timerLength;}
}
