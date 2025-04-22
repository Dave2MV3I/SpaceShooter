package my_project.model.userInterface;

public class StatusDisplay extends BlockWithIcon{

    private final int index;

    public StatusDisplay(double startX, double y, double height, boolean visible, String iconPath, int index, UserInterface ui) {
        super(startX, y, height, visible, iconPath, ui.getStatus(index, 1), ui);
        // text setzen mit sc und getter, text aktualisieren
        this.index = index;

        color[0] = 150;
        color[1] = 0;
        color[2] = 0;
        color[3] = 255;
    }

    @Override
    public void update(double dt){
        visible = ui.getSC().getActivity(index);
        if (ui.getPC().getCurrentScene() > 0 && ui.getPC().getCurrentScene() < 4) text = ui.getStatus(index, dt);
    }
}