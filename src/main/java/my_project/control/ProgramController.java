package my_project.control;

import KAGO_framework.control.Drawable;
import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.model.*;
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

    // Referenzen
    private final ViewController viewController;
    private Player p1;
    public Level1 level1;


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
        //SoundController.playSound("startBGM");
        // Bild
        StartBackground sback = new StartBackground();
        viewController.draw(sback,0);
        Picture titleText = new Picture(100, 200, "src/main/resources/graphic/title_text.png");
        viewController.draw(titleText,0);
        // Interaktion
        viewController.register(inputManager,0);

        // Spielbildschirm (Szene 1)
        viewController.createScene();
        Picture level1BG = new Picture(0,0,"src/main/resources/graphic/spaceBG.png");
        viewController.draw(level1BG,1);
        p1 = new Player(50,300, this, 0.5);
        level1 = new Level1(64, 8, this);
        viewController.draw(level1,1);
        //viewController.draw(p1,1);
        //viewController.draw(level1,1);



        // Spielbildschirm (Szene 4)
        viewController.createScene();
        Picture loseText = new Picture(0,0,"src/main/resources/graphic/loseBG.png");
        viewController.draw(loseText,4);

        // Spielbildschirm (Szene 5)
        viewController.createScene();
        Picture winText = new Picture(0,0,"src/main/resources/graphic/winBG.png");
        viewController.draw(winText,5);



        viewController.getSoundController().loadSound("src/main/resources/sound/bgm_level1.mp3","level1BGM", true);
        // Music by https://pixabay.com/de/users/alex-productions-32020823/?utm_source=link-attribution&utm_medium=referral&utm_campaign=music&utm_content=132919Alex Cristoforetti from https://pixabay.com/music//?utm_source=link-attribution&utm_medium=referral&utm_campaign=music&utm_content=132919
        // Photo by eberhard grossgasteiger: https://www.pexels.com/photo/brown-rocky-mountain-photography-2098427/
        viewController.register(inputManager,1);

        // Endbildschirm (Szene 2)
    }

    public void updateProgram(double dt){
        //this.zeichneBullets();
        level1.update(dt);

        //if (currentScene == 1){
          //   level1.zeichneLevel(new DrawTool());
        //}
    }

    public Player getPlayer(){
        return p1;
    }

    public void processKeyboardInput(int key, boolean pressed) {
        if (!pressed && key == KeyEvent.VK_SPACE && currentScene == 0) {
            currentScene = 1;
            viewController.showScene(currentScene);
            SoundController.stopSound("startBGM");
            //SoundController.playSound("level1BGM");
        }
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_S || key == KeyEvent.VK_A || key == KeyEvent.VK_D){
            p1.processWASD(key, pressed);
        }
        if (key == KeyEvent.VK_SPACE && pressed) {
            p1.processSpace();
        }
    }
}
