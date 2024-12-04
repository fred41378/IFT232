package labo7.ui.shortcuts;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


/*
 * Classe g�rant les raccourcis clavier.
 */

public class ShortcutManager implements KeyEventDispatcher {


	private ArrayList<KeyboardShortcut> shortcuts;

	public ShortcutManager() {
		
		shortcuts = new ArrayList<KeyboardShortcut>();
	}

	/*
	 * M�thode invoqu�e lorsqu'une touche est enfonc�e ou rel�ch�e.
	 */
	@Override
	public boolean dispatchKeyEvent(KeyEvent evt) {

		/*
		 * V�rifie si un des raccourcis clavier correspond
		 * � l'�v�nement re�u.
		 */		
		for (KeyboardShortcut sc : shortcuts) {
			if (sc.match(evt)) {
				sc.activateShortcut();
				return true;
			}
		}
		return false;
	}
	
	
	/*
	 * Permet l'ajout d'un raccourci.
	 */
	public void addShortcut(KeyboardShortcut sc){
		shortcuts.add(sc);
	}
	
	/*
	 * D�finit les raccourcis actuels. 
	 */
	public void initManager(){
		
		shortcuts.add(new KeyboardShortcut(KeyEvent.VK_C, true){
			public void activateShortcut(){
				System.out.println("Copier!");
			}
		});
		
		shortcuts.add(new KeyboardShortcut(KeyEvent.VK_V, true){
			public void activateShortcut(){
				System.out.println("Coller!");
			}
		});
		
		shortcuts.add(new KeyboardShortcut(KeyEvent.VK_X, true){
			public void activateShortcut(){
				System.out.println("Couper!");
			}
		});
		
		shortcuts.add(new KeyboardShortcut(KeyEvent.VK_Z, true){
			public void activateShortcut(){
				System.out.println("Undo!");
			}
		});
		
		shortcuts.add(new KeyboardShortcut(KeyEvent.VK_Y, true){
			public void activateShortcut(){
				System.out.println("Redo!");
			}
		});		
	}
	
	
	
}
