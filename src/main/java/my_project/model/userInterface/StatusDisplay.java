package my_project.model.userInterface;

public class StatusDisplay extends BlockWithIcon{

    private final int index;

    public StatusDisplay(double startX, double y, double height, boolean visible, String iconPath, int index, UserInterface ui) {
        super(startX, y, height, visible, iconPath, ui);
        this.index = index;
        widthCalculated = false;

        color[0] = 150;
        color[1] = 0;
        color[2] = 0;
        color[3] = 255;
    }

    @Override
    public void update(double dt){
        visible = ui.getSC().getActivity(index);
        //if (index == 3) System.out.print(index);
        if (ui.getPC().getCurrentScene() < 4) text = ui.getStatus(index, dt);
    }

    public int getIndex() {return index;}
}