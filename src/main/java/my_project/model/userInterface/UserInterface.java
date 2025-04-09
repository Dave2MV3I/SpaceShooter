package my_project.model.userInterface;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;
import my_project.control.SettingController;

import java.awt.event.MouseEvent;

public class UserInterface extends InteractiveGraphicalObject {

    // Attribute
    private boolean menuOpen;
    private final double buffer = 10;
    private final BlockWithIcon[] settingButtons = new BlockWithIcon[5];
    //private final StatusDisplay[] statusDisplays = new StatusDisplay[3];
    private final double buttonHeight = 30;
    // totals: 4 setting buttons, 3 status displays up to now

    // Referenzen
    private ProgramController pc;
    private SettingController sc;

    // Methoden
    public UserInterface(ProgramController pc) {
        this.pc = pc;
        /*settingButtons[0] = new BlockWithIcon();
        settingButtons[1] = new BlockWithIcon();
        settingButtons[2] = new BlockWithIcon();
        settingButtons[3] = new BlockWithIcon();
        settingButtons[4] = new BlockWithIcon();*/
        sc = new SettingController(settingButtons.length);
        /*statusDisplays[0] = ;
        statusDisplays[1] = ;
        statusDisplays[2] = ;*/
    }

    @Override
    public void draw(DrawTool drawTool){

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
    }

    public void menuClicked(){

    }

    public boolean getMenuOpen(){
        return menuOpen;
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
    @Override
    public void draw(DrawTool drawTool){
        settingButton.draw(drawTool);
        for (BlockWithIcon button : settingButtons) {
            if (button.getVisible()) button.draw(drawTool);
        }
        for (int i = 0; i < statusDisplays.length; i++) {
            if (settings[i].isActive()) statusDisplays[i].draw(drawTool);
        }
    }

    public boolean getMenuOpen() {return menuOpen;}

    public void mouseClicked(MouseEvent e){
        if (settingButton.collidesWith(e.getX(), e.getY())){
            menuOpen = !menuOpen;
            menuClicked();
        } else {
            for (int i = 0; i < settingButtons.length; i++){
                if (settingButtons[i].collidesWith(e.getX(), e.getY())){
                    settings[i].switchActivity();
                    settingButtons[i].switchColours();
                }
               if (i==3) {
                   settings[3].switchActivity();
                   //pc.toggleMusic(pc.getCurrentSong());
               }
            }
        }
    }

    public void menuClicked(){
        if (menuOpen){
            for (int i = 0; i < settingButtons.length; i++) {
                settingButtons[i].setY(60+i*(buttonHeight+buffer));
                settingButtons[i].setVisibility(true);
            }
        } else {
            for (int i = 0; i < settingButtons.length; i++) {
                settingButtons[i].setVisibility(false);
            }
        }
    }

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
}

