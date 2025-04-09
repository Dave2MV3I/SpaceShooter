package my_project.model.userInterface;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;
import my_project.control.SettingController;

import java.awt.event.MouseEvent;

public class UserInterface extends InteractiveGraphicalObject {

    // Attribute
    private boolean menuOpen = false;
    // totals: 6 setting buttons, 1 main setting button, 3 status displays up to now
    private final SettingButton[] settingButtons = new SettingButton[6];
    private final StatusDisplay[] statusDisplays = new StatusDisplay[3];
    private final double buttonHeight = 30;

    // Referenzen
    private ProgramController pc;
    private SettingController sc;
    private MainSettingButton mainSettingButton;
    private DrawTool theDrawTool;

    // Methoden
    public UserInterface(ProgramController pc) {
        this.pc = pc;
        sc = new SettingController(settingButtons.length);
        double bX = 20;

        mainSettingButton = new MainSettingButton(bX, gBY(0), buttonHeight, "src/main/resources/graphic/menu/settings.png",  this);
        settingButtons[0] = new SettingButton(bX, gBY(1), buttonHeight, "src/main/resources/graphic/menu/settings.png", this, 0);
        settingButtons[1] = new SettingButton(bX, gBY(2), buttonHeight, "src/main/resources/graphic/menu/settings.png", this, 1);
        settingButtons[2] = new SettingButton(bX, gBY(3), buttonHeight, "src/main/resources/graphic/menu/settings.png", this, 2);
        settingButtons[3] = new SettingButton(bX, gBY(4), buttonHeight, "src/main/resources/graphic/menu/settings.png", this, 3);
        settingButtons[4] = new SettingButton(bX, gBY(5), buttonHeight, "src/main/resources/graphic/menu/settings.png", this, 4);
        settingButtons[5] = new SettingButton(bX, gBY(6), buttonHeight, "src/main/resources/graphic/menu/settings.png", this, 5);

        statusDisplays[0] = new StatusDisplay(bX, 20, buttonHeight, true, "src/main/resources/graphic/menu/settings.png", 0, this);
        statusDisplays[1] = new StatusDisplay(bX, 20, buttonHeight, true, "src/main/resources/graphic/menu/settings.png", 1, this);
        statusDisplays[2] = new StatusDisplay(bX, 20, buttonHeight, true, "src/main/resources/graphic/menu/settings.png", 0, this);
    }

    private double gBY(int i){
        double startBY = 20;
        final double buffer = 10;
        return startBY + i * (buttonHeight + buffer);
    }

    @Override
    public void draw(DrawTool drawTool){
        if (theDrawTool == null){theDrawTool = drawTool;}
        mainSettingButton.draw(drawTool);
        for (SettingButton button : settingButtons) {
            if (button.getVisible()) button.draw(drawTool);
        }
        for (int i = 2; i < statusDisplays.length; i++) {
            if (sc.getActivity(i)) statusDisplays[i].draw(drawTool);
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
                    if (!sc.getActivity(0)) {
                        pc.toggleMusic(null);
                    } else pc.toggleMusic("current");
                }

            }
        }
    }

    public void menuClicked(){
        System.out.print(sc.getActivity(0));
        if (menuOpen){
            for (int i = 0; i < settingButtons.length; i++) {
                settingButtons[i].setY(gBY(i+1));
                settingButtons[i].setVisibility(true);
            }
        } else {
            for (int i = 0; i < settingButtons.length; i++) {
                settingButtons[i].setVisibility(false);
            }
        }
    }

    public boolean getMenuOpen(){
        return menuOpen;
    }

    public SettingController getSC(){return sc;}
    public DrawTool getDrawTool(){return theDrawTool;}

}

    /*// Attribute
    private final int totalSettings = 4;
    private final int totalStatusDisplays = 3;


    // Arrays
    private final Setting[] settings = new Setting[totalSettings];
    private final StatusDisplay[] statusDisplays = new StatusDisplay[totalStatusDisplays];
    private final BlockWithIcon[] settingButtons = new BlockWithIcon[totalSettings];


    // Referenzen
    private SettingButton settingButton;


    // Konstruktor
    public UserInterface(ProgramController pc) {
        // Objekte für Einstellungen erstellen
        // Mit Statusanzeige
        settings[0] = new Setting("Level", "src/main/resources/graphic/menu/settings.png", true);
        settings[1] = new Setting("LevelTimer", "src/main/resources/graphic/menu/settings.png", false);
        settings[2] = new Setting("GlobalTimer", "src/main/resources/graphic/menu/settings.png", true);

        // Ohne Statusanzeige
        settings[3] = new Setting("Music", "src/main/resources/graphic/menu/settings.png", true);
        //settings[4] = new Setting("HP-Bar bottomed", "src/main/resources/graphic/menu/settings.png", true, false);

        //Buttons erstellen
        settingButton = new SettingButton(20, 20, 30, true, "src/main/resources/graphic/menu/settings.png",this);
        for (int i = 0; i < settings.length; i++) {
            settingButtons[i] = new BlockWithIcon(20, 60+ i*(buttonHeight+buffer), buttonHeight, false, settings[i]);
        }

        //Statusanzeigen erstellen
        double shift = 0;
        for (int i = 0; i < statusDisplays.length; i++) {
            statusDisplays[i] = new StatusDisplay(220 + shift, 20, buttonHeight, true, settings[i]);
            shift += statusDisplays[i].getWidth() + 10;
        }
    }

    // Methoden



    *//**
     * @param index <br>
     * 0- Level <br>
     * 1- LevelTimer <br>
     * 2- GlobalTimer <br>
     * 3- Music <br>
     *
     *//*

    public boolean getActive(int index){
        return settings[index].isActive();
    }*/


