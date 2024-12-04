package labo7.ui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import labo7.commands.Command;
import labo7.commands.Invoker;
import labo7.model.EditableDocument;

public class EditorMenuItem extends JMenuItem implements ActionListener, Invoker {

	private static final long serialVersionUID = 1L;
	protected EditableDocument model;
	protected JTextArea textBox;
	protected Command command;

	public EditorMenuItem(String label,EditableDocument doc,JTextArea txt){
		super(label);
		model=doc;
		textBox=txt;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if (command != null) {
			command.execute();
		}
	}

	@Override
	public void storeCommand(Command command) {
		this.command = command;
	}

}
