package labo7.ui.shortcuts;

import labo7.commands.Command;
import labo7.commands.EditDocumentCommand;
import labo7.commands.Invoker;

import java.awt.event.KeyEvent;

/*
 * Classe d�finissant un raccourci clavier.
 * Pr�voit une m�thode � �tre appel�e lorsque le raccourci est d�clench�.
 */

public class KeyboardShortcut implements Invoker{

	private boolean control;
	private int keyCode;
	private Command cmd;

	public KeyboardShortcut(int code, boolean ctrl) {
		control = ctrl;
		keyCode = code;
	}

	public boolean match(KeyEvent evt) {
		if (evt.getID() == KeyEvent.KEY_PRESSED) {				
			if(evt.getKeyCode() == keyCode && evt.isControlDown() == control){
				return true;
			}
		}
		return false;
	}

	@Override
	public void storeCommand(Command command) {
		cmd = command;
	}

	public void activateShortcut(){
		cmd.execute();
	}

}

