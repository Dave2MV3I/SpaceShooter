package my_project.control;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import my_project.model.*;
import my_project.model.player.Player;
import my_project.model.userInterface.UserInterface;
import my_project.view.InputManager;

import java.awt.event.KeyEvent;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern.
 * Hinweise:
 * - Der Konstruktor sollte nicht geändert werden.
 * - Sowohl die startProgram()- als auch die updateProgram(...)-Methoden müssen vorhanden sein und ihre Signatur sollte
 *   nicht geändert werden
 * - Zusätzliche Methoden sind natürlich gar kein Problem
 */



public class ProgramController {

    //Attribute
        private int currentScene;
        private String currentSong = "level1BGM";
        private String soundName;

    // Referenzen
        private final ViewController viewController;
        private Player p1;

        private LevelControl currentLevel;
        private StartBackground sback;
        private UserInterface ui;
        private SettingController sc;

    // Methoden

    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    public void startProgram() {
        // Vorbereitungen
            InputManager inputManager = new InputManager(this);
            currentScene = 0;

        // Startbildschirm (Szene 0)
            // Ton
                viewController.getSoundController().loadSound("src/main/resources/sound/bgm_startScreen.mp3","startBGM", true);
                currentSong = "startBGM";
                //checkAndHandleMusic(false);
            // Sounds
                 viewController.getSoundController().loadSound("src/main/resources/sound/laser.mp3", "laser", false);
                 viewController.getSoundController().loadSound("src/main/resources/sound/space_explosion.mp3", "explosion", false);
                 viewController.getSoundController().loadSound("src/main/resources/sound/impact.mp3", "impact", false);



            // Bild
                sback = new StartBackground();
                viewController.draw(sback,0);
                Picture titleText = new Picture(100, 200, "src/main/resources/graphic/title_text.png");
                viewController.draw(titleText,0);
            // Interaktion
                viewController.register(inputManager,0);

        // Spielbildschirm (Szene 1)

            viewController.createScene();
            Picture level1BG = new Picture(0,0,"src/main/resources/graphic/backgrounds/spaceBG.png");
            viewController.draw(level1BG,1);
            p1 = new Player(50,300, this);
            currentLevel = new Level1(8, this, "level1BGM");
            viewController.draw(currentLevel,1);


        // Spielbildschirm (Szene 2)
            viewController.createScene();
            viewController.draw(level1BG,2);

        // Spielbildschirm (Szene 3)
            viewController.createScene();

        // Endbildschirm (Szene 4)
            viewController.createScene();
            Picture loseText = new Picture(0,0,"src/main/resources/graphic/backgrounds/loseBG.png");
            viewController.draw(loseText,4);

        // Endbildschirm (Szene 5)
            viewController.createScene();
            Picture winText = new Picture(0,0,"src/main/resources/graphic/backgrounds/winBG.png");
            viewController.draw(winText,5);

        // Background Music
            viewController.getSoundController().loadSound("src/main/resources/sound/bgm_level1.mp3","level1BGM", true);
            // Music by https://pixabay.com/de/users/alex-productions-32020823/?utm_source=link-attribution&utm_medium=referral&utm_campaign=music&utm_content=132919Alex Cristoforetti from https://pixabay.com/music//?utm_source=link-attribution&utm_medium=referral&utm_campaign=music&utm_content=132919
            // Photo by eberhard grossgasteiger: https://www.pexels.com/photo/brown-rocky-mountain-photography-2098427/

        viewController.register(inputManager,1);
        viewController.register(inputManager,2);
        //viewController.register(inputManager,3);
        viewController.register(inputManager,4);
        viewController.register(inputManager,5);
    }

    public void updateProgram(double dt){
        //System.out.println(currentLevel);
        if (currentScene == 0) sback.update(dt);
        if (currentScene > 0 && currentScene < 4) currentLevel.update(dt);
    }

    public void processKeyboardInput(int key, boolean pressed) {
        //System.out.println("process keyboardInput wird aufgerufen");
        if (!pressed && key == KeyEvent.VK_SPACE && currentScene == 0) {
            setSceneOrLevel(1);
            checkAndHandleMusic(true);
        }
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_S || key == KeyEvent.VK_A || key == KeyEvent.VK_D){
            p1.processWASD(key, pressed);
        }
        if (key == KeyEvent.VK_SPACE && pressed) {
            p1.processSpace();
            if (currentScene != 0) if (sc.getActivity(1)) SoundController.playSound("laser");
        }
        if (key == KeyEvent.VK_F){
            //System.out.println("Playerposition: " + "X: " + Math.round(p1.getX()) + ", Y: " + Math.round(p1.getY()) + ", X2: " + Math.round(p1.getX()+p1.getWidth()) + ", Y2: " + Math.round(p1.getY()+p1.getHeight()));
        }
    }

    public void setSceneOrLevel(int s){
        this.currentScene = s;

        if (s == 1) {
            sc = new SettingController(6);
            ui = new UserInterface(this);
        }

        if (s == 2) {
            currentLevel = new Level2 (8, this, "level1BGM");
            getPlayer().setAmmunition(48);
        }
        if (s == 3) {
            currentLevel = new Level3 (8, this, "level1BGM");
            getPlayer().setAmmunition(64);
        }
        if (s == 4){
            currentLevel = new Level4 (8, this, "level1BGM");
            getPlayer().setAmmunition(64);
        }

        if (s > 0 && s < 4) {
            viewController.draw(currentLevel, s);
            viewController.register(ui,s);
        }

        viewController.showScene(currentScene);
        System.out.println("CurrentScene: " + currentScene);
    }

    /**
     * @param lvlChanged
     * If this method is called because of a new started Level, type true
     */

    public void checkAndHandleMusic(boolean lvlChanged){
        if (lvlChanged) {
            SoundController.stopSound(currentSong);
            currentSong = currentLevel.getBgSong();
            if (sc.getActivity(0)) SoundController.playSound(currentSong);
        } else {
            if (sc.getActivity(0)) {
                SoundController.playSound(currentSong);
            } else SoundController.stopSound(currentSong);
        }
    }

    public Player getPlayer(){return p1;}
    public UserInterface getUI(){return ui;}
    public LevelControl getCurrentLevel() {return currentLevel;}
    public int getCurrentScene(){return currentScene;}
    public SettingController getSC(){return sc;}

    public void playSound(String soundName){
        SoundController.playSound(soundName);
    }
}
