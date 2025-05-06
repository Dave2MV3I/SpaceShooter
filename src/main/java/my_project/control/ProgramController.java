package my_project.control;

import KAGO_framework.control.Drawable;
import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import my_project.model.*;
import my_project.model.spaceships.Player;
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

    // Entwicklerattribute

    //Attribute
        private int currentScene;
        private String currentSong = "level1BGM";
        private int nLevels = 9;
        private String deathReason;
        private double globalTimer;

    // Referenzen
        private final ViewController viewController;
        private Player p1;
        private LevelController levelController;
        private StartBackground sback;
        private UserInterface ui;
        private Settings sc;
        private InputManager inputManager;

    // Methoden
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    public void startProgram() {
        // Vorbereitungen
            inputManager = new InputManager(this);
            currentScene = 0;

        // UserInterface
        sc = new Settings();
        ui = new UserInterface(this);
        viewController.register(ui,0);

        // Objekte
        p1 = new Player(50,300, this);
        //System.out.println("LevelController created");


        // Sounds
        viewController.getSoundController().loadSound("src/main/resources/sound/laser.mp3", "laser", false);
        viewController.getSoundController().loadSound("src/main/resources/sound/space_explosion.mp3", "explosion", false);
        viewController.getSoundController().loadSound("src/main/resources/sound/impact.mp3", "impact", false);


        // Startbildschirm (Szene 0)
            // Ton
                viewController.getSoundController().loadSound("src/main/resources/sound/bgm_startScreen.mp3","startBGM", true);
                currentSong = "startBGM";
            // Bild
                sback = new StartBackground(this, viewController);
                viewController.draw(sback,0);
                Picture titleText = new Picture(100, 350, "src/main/resources/graphic/title_text.png");
                viewController.draw(titleText,0);
            // Interaktion
                viewController.register(inputManager,0);

        // Spielbildschirm (Szene 1)
            viewController.createScene();

        // Spielbildschirm (Szene 2)
            viewController.createScene();

        // Spielbildschirm (Szene 3)
            viewController.createScene();

        // Spielbildschirm (Szene 4)
            viewController.createScene();

        // Spielbildschirm (Szene 5)
            viewController.createScene();

        // Spielbildschirm (Szene 6)
            viewController.createScene();

        // Spielbildschirm (Szene 7)
            viewController.createScene();

        // Spielbildschirm (Szene 8)
            viewController.createScene();

        // Spielbildschirm (Szene 9)
            viewController.createScene();

        // Endbildschirm (Szene 10)
            viewController.createScene();
            Picture loseText = new Picture(0,0,"src/main/resources/graphic/backgrounds/loseBG.png");
            viewController.draw(loseText,10);

        // Endbildschirm (Szene 11)
            viewController.createScene();
            Picture winText = new Picture(0,0,"src/main/resources/graphic/backgrounds/winBG.png");
            viewController.draw(winText,11);

        // Background Music
            viewController.getSoundController().loadSound("src/main/resources/sound/bgm_level1.mp3","level1BGM", true);
            // Music by https://pixabay.com/de/users/alex-productions-32020823/?utm_source=link-attribution&utm_medium=referral&utm_campaign=music&utm_content=132919Alex Cristoforetti from https://pixabay.com/music//?utm_source=link-attribution&utm_medium=referral&utm_campaign=music&utm_content=132919
            // Photo by eberhard grossgasteiger: https://www.pexels.com/photo/brown-rocky-mountain-photography-2098427/
    }

    public void updateProgram(double dt){
        globalTimer += dt;
        ui.update(dt);
        if (!ui.getMenuOpen()) {
            if (currentScene == 0) sback.update(dt);
            //if (currentScene > 0 && currentScene < nLevels+1) currentLevel.update(dt);
        }
        if (currentScene > 0 && currentScene < 10) levelController.updateLevel(dt);
    }

    public void processKeyboardInput(int key, boolean pressed) {
        //System.out.println("process keyboardInput wird aufgerufen");
        if (!pressed && key == KeyEvent.VK_SPACE && currentScene == 0) {
            levelController = new LevelController(this, viewController);
            checkAndHandleMusic(true);
        }
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_S || key == KeyEvent.VK_A || key == KeyEvent.VK_D){
            p1.processWASD(key, pressed);
        }
        if (key == KeyEvent.VK_SPACE && pressed) {
            //viewController.getSoundController().loadSound("src/main/resources/sound/shoot_sound.mp3","shootSound", false);
            //SoundController.playSound(shootSound);
            p1.processSpace();
        }
        if (key == KeyEvent.VK_F){
            //System.out.println("Playerposition: " + "X: " + Math.round(p1.getX()) + ", Y: " + Math.round(p1.getY()) + ", X2: " + Math.round(p1.getX()+p1.getWidth()) + ", Y2: " + Math.round(p1.getY()+p1.getHeight()));
            //System.out.println(currentScene);
            System.out.println("HI");
            for (Drawable drawable : viewController.getDrawables()){
                System.out.println(drawable);
            }
        }
    }

    /**
     *
     * @param s <br>
     *          0 für Startbildschirm <br>
     *          1-9 für entsprechendes LevelController <br>
     *          10 für Lose <br>
     *          11 für Win <br>
     */
    public void setCurrentScene(int s){
        this.currentScene = s;
        viewController.showScene(currentScene);
        if (s == 10) System.out.println(deathReason);
    }
    public void addDrawablesAndInteractables(int s){
        viewController.draw(ui,s);
        viewController.register(ui,s);
        viewController.register(inputManager,s);
        viewController.draw(p1, s);
    }

    /**
     * @param lvlChanged
     * If this method is called because of a new started LevelController, type true
     */

    public void checkAndHandleMusic(boolean lvlChanged){
        if (lvlChanged) {
            SoundController.stopSound(currentSong);
            if (currentScene == 0){
                currentSong = "startBGM";
            } else {
                currentSong = levelController.getBgSong();
            }
            if (sc.getActivity(0)) SoundController.playSound(currentSong);
        } else {
            if (sc.getActivity(0)) {
                SoundController.playSound(currentSong);
            } else SoundController.stopSound(currentSong);
        }
    }

    public Player getPlayer(){return p1;}
    public UserInterface getUI(){return ui;}
    public LevelController getLevelController() {return levelController;}
    public int getCurrentScene(){return currentScene;}
    public Settings getSC(){return sc;}
    public int getNLevels(){return nLevels;}
    public double getGlobalTimer() { return globalTimer;}

    public void playSound(String soundName){
        SoundController.playSound(soundName);
    }

    public ViewController getViewController() {
        return viewController;
    }
}
