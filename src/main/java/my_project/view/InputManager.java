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

    private final ProgramController pc;

    /**
     * Objekterzeugung
     * @param pc Nötig als Objekt vom Controllerbereich, das informiert wird
     */
    public InputManager(ProgramController pc){
        this.pc = pc;

    }

    @Override
    public void keyPressed(int key){
        pc.processKeyboardInput(key, true);
    }

    @Override
    public void keyReleased(int key){
        pc.processKeyboardInput(key, false);
    }

    @Override
    public void mouseClicked(MouseEvent e){
        if (e.getX()<100){pc.getUIManager().mousePressed(e);}
    }
}