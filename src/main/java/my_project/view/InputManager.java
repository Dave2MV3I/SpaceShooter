package my_project.view;

import KAGO_framework.model.InteractiveGraphicalObject;
import my_project.control.ProgramController;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Realisiert ein Objekt, dass alle Eingaben empfängt und dann danach passende Methoden
 * im ProgramController aufruft.
 */
public class InputManager extends InteractiveGraphicalObject {

    private final ProgramController programController;

    /**
     * Objekterzeugung
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     */
    public InputManager(ProgramController programController){
        this.programController = programController;

    }

    @Override
    public void keyReleased(int key){
        programController.processKeyboardInput(key);
    }

    @Override
    public void keyPressed(int key){
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_S || key == KeyEvent.VK_A || key == KeyEvent.VK_D){
            programController.processWASD(key);
        }
    }
}

// TODO 2 Diagonal fliegen können und aufhören zu fliegen bei Nichtdrücken, also bei Keyreleased direction auf false
//// TODO 3: Schiessen und Bullets