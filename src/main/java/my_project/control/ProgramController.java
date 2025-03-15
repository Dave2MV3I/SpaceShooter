package my_project.control;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
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


    // Referenzen
    private final ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private Player p1;
    private int currentScene;
    private SpaceshipControl spaceshipControl;
    private BulletControl bulletControl;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen. Hier sollte also alles geregelt werden,
     * was zu diesem Zeitpunkt passieren muss.
     */
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
        p1 = new Player(50,300);
        spaceshipControl = new SpaceshipControl ();
        bulletControl = new BulletControl(this);

        viewController.draw(p1,1);
        viewController.getSoundController().loadSound("src/main/resources/sound/bgm_level1.mp3","level1BGM", true);
        // Music by https://pixabay.com/de/users/alex-productions-32020823/?utm_source=link-attribution&utm_medium=referral&utm_campaign=music&utm_content=132919Alex Cristoforetti from https://pixabay.com/music//?utm_source=link-attribution&utm_medium=referral&utm_campaign=music&utm_content=132919
        // Photo by eberhard grossgasteiger: https://www.pexels.com/photo/brown-rocky-mountain-photography-2098427/
        viewController.register(inputManager,1);

        // Endbildschirm (Szene 2)
    }

    /**
     * Diese Methode wird vom ViewController-Objekt automatisch mit jedem Frame aufgerufen (ca. 60mal pro Sekunde)
     * @param dt Zeit seit letztem Frame in Sekunden
     */
    public void updateProgram(double dt){

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
    }

}

// TODO 1 Der Hintergrund von Szene 0 soll weiterhin nur gezeichnet werden.
//  Verschönern Sie ihn nach eigenem Ermessen, aber animieren Sie die Sterne in jedem Fall
//  (sie könnten z.B. von links nach rechts fliegen und links wieder erscheinen o.ä.).
//  Beachten Sie bei der Verschönerung, dass sie dabei zwei Methoden implementieren sollen,
//  die etwas in den Hintergrund zeichnen und dabei sinnvolle Parameter verwenden,
//  z.B. “zeichnePlanet(radius, farbe, mitWolken, mitMond)”.
