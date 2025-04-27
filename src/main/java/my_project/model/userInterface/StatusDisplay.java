package my_project.model.userInterface;

public class StatusDisplay extends BlockWithIcon{

    private final int myIndex;

    public StatusDisplay(double startX, double y, double height, boolean visible, String iconPath, int index, UserInterface ui) {
        super(startX, y, height, visible, iconPath, ui);
        myIndex = index;
        widthCalculated = false;

        color[0] = 150;
        color[1] = 0;
        color[2] = 0;
        color[3] = 255;
    }

    @Override
    public void update(double dt){
        visible = ui.getSC().getActivity(myIndex);
        if (ui.getPC().getCurrentScene() < ui.getPC().getNLevels()+1) text = ui.getStatus(myIndex, dt);
    }

    public void setWidthCalculated(boolean widthCalculated) {this.widthCalculated = widthCalculated;}
}