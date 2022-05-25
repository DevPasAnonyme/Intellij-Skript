package fr.devanonyme.notepadd.menus.keys;

import fr.devanonyme.notepadd.Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    Main main;

    public KeyHandler(Main main) {
        this.main = main;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_N) {
            main.functionFichier.newFile();
        }
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_O) {
            main.functionFichier.open();
        }
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
            main.functionFichier.save();
        } else if(e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_S) {
            main.functionFichier.saveAs();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
