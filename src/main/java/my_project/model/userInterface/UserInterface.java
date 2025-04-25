package my_project.model.userInterface;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;
import my_project.control.ProgramController;
import my_project.control.SettingController;
import my_project.model.Picture;

import java.awt.event.MouseEvent;

public class UserInterface extends InteractiveGraphicalObject {

    // Attribute
        private boolean menuOpen = false;
        // totals: 6 setting buttons, 1 main setting button, 3 status displays up to now
        private final SettingButton[] settingButtons = new SettingButton[6];
        private final StatusDisplay[] statusDisplays = new StatusDisplay[4];
        private final double buttonHeight = 30;
        private boolean playerOutside = false;


    // Referenzen
        private final ProgramController pc;
        private final SettingController sc;
        private final MainSettingButton mainSettingButton;
        private DrawTool theDrawTool;
        private final Picture pin = new Picture(-20, -20, "src/main/resources/graphic/menu/pin.png");

    // Methoden
    public UserInterface(ProgramController pc) {
        this.pc = pc;
        sc = pc.getSC();
        double bX = 20;

        // Icons von flaticon.com
        mainSettingButton = new MainSettingButton(bX, gBY(0), buttonHeight, "src/main/resources/graphic/menu/settings.png",  this);
        settingButtons[0] = new SettingButton(bX, gBY(1), buttonHeight, "src/main/resources/graphic/menu/music.png", this, 0);
        settingButtons[1] = new SettingButton(bX, gBY(2), buttonHeight, "src/main/resources/graphic/menu/sounds.png", this, 1);
        settingButtons[2] = new SettingButton(bX, gBY(3), buttonHeight, "src/main/resources/graphic/menu/level.png", this, 2);
        settingButtons[3] = new SettingButton(bX, gBY(4), buttonHeight, "src/main/resources/graphic/menu/time.png", this, 3);
        settingButtons[4] = new SettingButton(bX, gBY(5), buttonHeight, "src/main/resources/graphic/menu/globalTime.png", this, 4);
        settingButtons[5] = new SettingButton(bX, gBY(6), buttonHeight, "src/main/resources/graphic/menu/fps.png", this, 5);

        statusDisplays[0] = new StatusDisplay(200, 20, buttonHeight, sc.getActivity(2), "src/main/resources/graphic/menu/level.png", 2, this);
        statusDisplays[1] = new StatusDisplay(200, 20, buttonHeight, sc.getActivity(3), "src/main/resources/graphic/menu/time.png", 3, this);
        statusDisplays[2] = new StatusDisplay(200, 20, buttonHeight, sc.getActivity(4), "src/main/resources/graphic/menu/globalTime.png", 4, this);
        statusDisplays[3] = new StatusDisplay(200, 20, buttonHeight, sc.getActivity(5), "src/main/resources/graphic/menu/fps.png", 5, this);
    }

    private double gBY(int i){
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

        if (px+pw < 0 && py >= 0 && py+ph <= winHeight){ // links .
            sx = 0;
            sy = py+ph/2;
            rotation = 90;
        } else if (px > winWidth && py >= 0 && py+ph <= winHeight){ // rechts .
            sx = winWidth;
            sy = py+ph/2;
            rotation = 270;
        } else if (py < 0 && px >= 0 && px <= winWidth){ // oben .
            sx = px+pw/2;
            sy = 0;
            rotation = 180;
        } else if (py > winHeight && px >= 0 && px <= winWidth){ // unten .
            sx = px+pw/2;
            sy = winHeight;

        } else if (px < 0 && py < 0){ // links oben .
            sx = 0;
            sy = 0;
            rotation = 135;
        } else if (px+pw > winWidth && py < 0){ // rechts oben .
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
        // Align and update StatusDisplays
        alignDisplays();
        for (StatusDisplay display : statusDisplays) {
            display.update(dt);
        }
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
                for (int j = 0; j < statusDisplays.length; j++){
                    statusDisplays[j].setVisible(sc.getActivity(j+2));
                }
            }
        }
    }

    public void menuClicked(){
        if (menuOpen){
            for (int i = 0; i < settingButtons.length; i++) {
                settingButtons[i].setY(gBY(i+1));
                settingButtons[i].setVisible(true);
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

    /*
    @Override
    public void keyPressed(int k){
        if (k == KeyEvent.VK_F) {

        }
    }*/

    public boolean getMenuOpen(){return menuOpen;}
    public SettingController getSC(){return sc;}
    public ProgramController getPC(){return pc;}
    public DrawTool getDrawTool(){return theDrawTool;}

    public String getStatus(int index, double dt){
        if (index == 2) return String.valueOf(pc.getCurrentScene());
        if (index == 3) return String.valueOf(Math.round(pc.getCurrentLevel().getTimer()));
        if (index == 4) return String.valueOf(Math.round(pc.getCurrentLevel().getGlobalTimer()));
        if (index == 5) return String.valueOf(Math.round(1/dt));
        return "nichts";
    }

    public void setPlayerOutside(boolean outside){playerOutside = outside;}

}


