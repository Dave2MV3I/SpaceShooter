package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Level1BG extends GraphicalObject {

    public Level1BG(){
        this.setNewImage("src/main/resources/graphic/spaceBG.png");
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(getMyImage(),0,0);
    }

}
