package my_project.view;

import KAGO_framework.model.InteractiveGraphicalObject;
import my_project.control.ProgramController;

/**
 * Realisiert ein Objekt, dass alle Eingaben empfängt und dann danach passende Methoden
 * im ProgramController aufruft.
 */
public class InputManager extends InteractiveGraphicalObject {

    private final ProgramController pc;

    /**
     * Objekterzeugung
     * @param pc Nötig als Objekt vom Control-Bereich, der informiert wird
     */
    public InputManager(ProgramController pc){
        this.pc = pc;

    }

    @Override
    public void keyPressed(int key){
        //System.out.println("keyPressed in InputManager wird aufgerufen");
        pc.processKeyboardInput(key, true);
    }

    @Override
    public void keyReleased(int key){
        pc.processKeyboardInput(key, false);
    }
}