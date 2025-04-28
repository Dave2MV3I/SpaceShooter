package my_project.model.userInterface;

import KAGO_framework.view.DrawTool;
import my_project.control.SettingController;

public class SettingButton extends BlockWithIcon{

    private final int[] activeColor = {47,76,57,255};
    private final int[] inactiveColor = {194,59,34,255};
    private final SettingController sc;
    private final int index;

    public SettingButton(double x, double y, double height, String iconPath, UserInterface ui, int index) {
        super(x, y, height, false, iconPath, ui.getSC().getSettingName(index), ui, true);
        this.sc = ui.getSC();
        this.index = index;
        if (sc.getActivity(index)) {
            color[0] = activeColor[0]; color[1] = activeColor[1]; color[2] = activeColor[2]; color[3] = activeColor[3];
        } else color[0] = inactiveColor[0]; color[1] = inactiveColor[1]; color[2] = inactiveColor[2]; color[3] = inactiveColor[3];
    }

    @Override
    public void draw(DrawTool drawTool){
        if (sc.getActivity(index)) {
            color[0] = activeColor[0]; color[1] = activeColor[1]; color[2] = activeColor[2]; color[3] = activeColor[3];
        } else color[0] = inactiveColor[0]; color[1] = inactiveColor[1]; color[2] = inactiveColor[2]; color[3] = inactiveColor[3];

        super.draw(drawTool);
    }
}

