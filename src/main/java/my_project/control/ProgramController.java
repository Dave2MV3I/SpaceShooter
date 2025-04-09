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
        private String currentSong;
    // Referenzen
        private final ViewController viewController;
        private Player p1;



    private LevelControl currentLevel;
        //private Level2 level2;
        private StartBackground sback;
        private UserInterface ui;

    // Methoden

    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    public void startProgram() {
        // Vorbereitungen
            InputManager inputManager = new InputManager(this);
            currentScene = 0;
            ui = new UserInterface(this);

        // Startbildschirm (Szene 0)
            // Ton
                viewController.getSoundController().loadSound("src/main/resources/sound/bgm_startScreen.mp3","startBGM", true);
                SoundController.playSound("startBGM");
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
            currentLevel = new Level1(64, 8, this);
            viewController.draw(this.getCurrentLevel(),1);


        // Spielbildschirm (Szene 2)
            viewController.createScene();
            /*Picture level2BG = new Picture(0,0,"src/main/resources/graphic/backgrounds/spaceBG.png");
            viewController.draw(level2BG,2);
            level2 = new Level2(64, 8, this);
            viewController.draw(level2,2);*/

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
    }

    public void updateProgram(double dt){

        if (currentScene == 0) sback.update(dt);
        if (currentScene == 1) currentLevel.update(dt);

        //if (currentScene == 2) level2.update(dt);

        //System.out.println(1/dt ); /*FPS ANZEIGE*/
        //System.out.println(p1.getHealth());
    }

    public Player getPlayer(){
        return p1;
    }
    public Level1 getLevel(int l) {if (l == 1) return (Level1) currentLevel; return null;}
    public UserInterface getUI(){return ui;}

    public void processKeyboardInput(int key, boolean pressed) {
        if (!pressed && key == KeyEvent.VK_SPACE && currentScene == 0) {
            currentScene = 1;
            viewController.showScene(currentScene);
            SoundController.stopSound("startBGM");
            SoundController.playSound("level1BGM");
        }
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_S || key == KeyEvent.VK_A || key == KeyEvent.VK_D){
            p1.processWASD(key, pressed);
        }
        if (key == KeyEvent.VK_SPACE && pressed) {
            p1.processSpace();
        }
    }

    public void setCurrentScene(int s){
        this.currentScene = s;
        viewController.showScene(currentScene);
    }

    public void startLevel2(){
        currentLevel = new Level2(64, 8, this);
        //controlMusic();
    }

    public LevelControl getCurrentLevel() {
        return currentLevel;
    }


    public void toggleMusic(String newPath){
        /*currentSong = newPath;
        if (ui.getActive(3)) {
            SoundController.playSound(currentSong);
        } else SoundController.stopSound(currentSong);*/
    }
}
