package labo7.ui.menu;

import javax.swing.JPopupMenu;

import labo7.commands.CommandFactory;
import labo7.commands.CommandLog;
import labo7.commands.UndoCommand;
import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

public class EditorMenu extends JPopupMenu {

	private static final long serialVersionUID = 1L;
	private EditableDocument model;
	private EditorTextArea textBox;
	private CommandLog log;

	public EditorMenu(EditableDocument model, EditorTextArea textBox, CommandLog log) {
		this.model = model;
		this.textBox = textBox;
		this.log = log;
	}

	@Override
	public void show(java.awt.Component invoker, int x, int y) {
		removeAll();
		createMenuItems();
		super.show(invoker, x, y);
	}

	private void createMenuItems() {
		boolean hasSelection = textBox.getSelectionStart() != textBox.getSelectionEnd();;


		if (hasSelection) {
			EditorMenuItem menuCut = new EditorMenuItem("Couper", model, textBox);
			menuCut.storeCommand(CommandFactory.createCutCommand());
			add(menuCut);

			EditorMenuItem menuCopy = new EditorMenuItem("Copier", model, textBox);
			menuCopy.storeCommand(CommandFactory.createCopyCommand());
			add(menuCopy);

			EditorMenuItem menuMaj = new EditorMenuItem("MAJUSCULES", model, textBox);
			menuMaj.storeCommand(CommandFactory.createMajCommand());
			add(menuMaj);

			EditorMenuItem menuMin = new EditorMenuItem("minuscules", model, textBox);
			menuMin.storeCommand(CommandFactory.createMinCommand());
			add(menuMin);
		}

		if (!hasSelection) {
			EditorMenuItem menuPaste = new EditorMenuItem("Coller", model, textBox);
			menuPaste.storeCommand(CommandFactory.createPasteCommand());
			add(menuPaste);
		}

		if (!log.isEmpty()) {
			EditorMenuItem menuUno = new EditorMenuItem("Annuler", model, textBox);
			menuUno.storeCommand(new UndoCommand(log));
			add(menuUno);
		}
	}
}
