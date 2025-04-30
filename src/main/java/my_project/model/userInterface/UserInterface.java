package my_project.model.userInterface;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;
import my_project.control.ProgramController;
import my_project.control.Settings;
import my_project.model.Picture;

import java.awt.event.MouseEvent;

public class UserInterface extends InteractiveGraphicalObject {

    // Attribute
        private boolean menuOpen = false;
        // totals: 6 setting buttons, 1 main setting button, 3 status displays up to now
        private final SettingButton[] settingButtons;
        private final StatusDisplay[] statusDisplays;
        private final double buttonHeight = 30;
        private boolean playerOutside = false;


    // Referenzen
        private final ProgramController pc;
        private final Settings sc;
        private final MainSettingButton mainSettingButton;
        private final BlockWithIcon shieldStatusDisplay;
        private DrawTool theDrawTool;
        private final Picture pin = new Picture(-20, -20, "src/main/resources/graphic/menu/pin.png");

    // Methoden
    public UserInterface(ProgramController pc) {
        this.pc = pc;
        sc = pc.getSC();
        shieldStatusDisplay = new BlockWithIcon(20, 750, buttonHeight, false, "src/main/resources/graphic/menu/shield.png", "Shield", this, false);
        settingButtons = new SettingButton[sc.getSettings().length];

        double buttonX = 20;

        // Icons von flaticon.com
        mainSettingButton = new MainSettingButton(buttonX, getButtonY(0), buttonHeight, "src/main/resources/graphic/menu/settings.png",  this);
        for (int i = 0; i < sc.getSettings().length; i++){
            settingButtons[i] = new SettingButton(buttonX, getButtonY(i+1), buttonHeight, sc.getIconPaths()[i], this, i);
        }
        statusDisplays = new StatusDisplay[sc.getStatusSettingIndices().length];
        for (int i = 0; i < statusDisplays.length; i++) {
            int settingIndex = sc.getStatusSettingIndices()[i];
            statusDisplays[i] = new StatusDisplay(200, 20, buttonHeight, sc.getActivity(settingIndex), sc.getIconPaths()[settingIndex], settingIndex, this);
        }
    }

    private double getButtonY(int i){
        double startBY = 20;
        final double buffer = 10;
        return startBY + i * (buttonHeight + buffer);
    }

    @Override
    public void draw(DrawTool drawTool){
        // Buttons und Displays zeichnen
        if (theDrawTool == null){theDrawTool = drawTool;}
        mainSettingButton.draw(drawTool);
        for (SettingButton button : settingButtons) {
            if (button.getVisible()) button.draw(drawTool);
        }
        for (StatusDisplay display : statusDisplays) {
            //if (sc.getActivity(i+2)) statusDisplays[i].draw(drawTool);
            if (display.getVisible()) display.draw(drawTool);
        }

        //Stecknadel zeichnen
        if (playerOutside) drawPin(drawTool);
        if (shieldStatusDisplay.getVisible()) shieldStatusDisplay.draw(drawTool);
    }

    private void drawPin(DrawTool drawTool){
        // Playerangaben
        double px = pc.getPlayer().getX();
        double py = pc.getPlayer().getY();
        double pw = pc.getPlayer().getWidth();
        double ph = pc.getPlayer().getHeight();

        // Angepasste Fenstermaße wegen eines Fehlers im Framework
        int winWidth = Config.WINDOW_WIDTH-33;
        int winHeight = Config.WINDOW_HEIGHT-55;

        // Stecknadelposition
        double sx = 0;
        double sy = 0;
        double rotation = 0;

        if (px+pw < 0 && py >= 0 && py+ph <= winHeight){ // links
            sx = 0;
            sy = py+ph/2;
            rotation = 90;
        } else if (px > winWidth && py >= 0 && py+ph <= winHeight){ // rechts
            sx = winWidth;
            sy = py+ph/2;
            rotation = 270;
        } else if (py+ph < 0 && px >= 0 && px+pw <= winWidth){ // oben
            sx = px+pw/2;
            sy = 0;
            rotation = 180;
        } else if (py > winHeight && px >= 0 && px+pw <= winWidth){ // unten
            sx = px+pw/2;
            sy = winHeight;

        } else if (px < 0 && py < 0){ // links oben
            sx = 0;
            sy = 0;
            rotation = 135;
        } else if (px+pw > winWidth && py < 0){ // rechts oben
            sx = winWidth;
            sy = 0;
            rotation = 225;
        } else if (px < 0 && py+ph > winHeight){ // links unten
            sx = 0;
            sy = winHeight;
            rotation = 45;
        } else if (px+pw > winWidth && py+ph > winHeight){ // rechts unten
            sx = winWidth;
            sy = winHeight;
            rotation = 315;
        }

        drawTool.drawTransformedImage(pin.getMyImage(), sx, sy, rotation, 0);
    }

    @Override
    public void update(double dt){
        //System.out.println("Current Scene: " + pc.getCurrentScene());
        // Align and update StatusDisplays
        alignDisplays();
        for (StatusDisplay display : statusDisplays) {
            display.update(dt);
        }


        if (pc.getPlayer().isShielded()) {
            shieldStatusDisplay.setText(String.valueOf(pc.getPlayer().getShieldsActivityTime()));
            shieldStatusDisplay.setVisible(true);
        } else shieldStatusDisplay.setVisible(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (mainSettingButton.collidesWith(e.getX(), e.getY())){
            menuOpen = !menuOpen;
            menuClicked();
        } else {
            for (int i = 0; i < settingButtons.length; i++){
                if (settingButtons[i].collidesWith(e.getX(), e.getY())){
                    sc.toggleSetting(i);
                }
                if (i==0) {
                    pc.checkAndHandleMusic(false);
                }
            }
        }
    }

    public void menuClicked(){
        if (menuOpen){
            for (SettingButton settingButton : settingButtons) {
                settingButton.setVisible(true);
            }
        } else {
            for (StatusDisplay display : statusDisplays){
                display.setWidthCalculated(false);
                alignDisplays();
            }
            for (SettingButton settingButton : settingButtons) {
                settingButton.setVisible(false);
            }
        }
    }

    public void alignDisplays(){
        for (int i = 1; i < statusDisplays.length; i++){
            double shift = 0;
            for (int j = 0; j < statusDisplays.length; j++){
                if (j < i && statusDisplays[j].getVisible()) {
                    shift += statusDisplays[j].getWidth() + 20;
                }
            }
            statusDisplays[i].setX(200 + shift);
        }
    }

    public boolean getMenuOpen(){return menuOpen;}
    public Settings getSC(){return sc;}
    public ProgramController getPC(){return pc;}
    public DrawTool getDrawTool(){return theDrawTool;}

    public String getStatus(int index, double dt){
        if (index == 2) return String.valueOf(pc.getCurrentScene());
        if (index == 3) return String.valueOf(Math.round(pc.getGlobalTimer()));
        if (index == 4) return String.valueOf(Math.round(1/dt));
        if (index == 5) return String.valueOf(pc.getPlayer().getAmmunition());
        return "nichts";
    }

    public void setPlayerOutside(boolean outside){playerOutside = outside;}

}


