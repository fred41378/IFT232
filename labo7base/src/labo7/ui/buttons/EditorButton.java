package labo7.ui.buttons;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

import labo7.commands.Command;
import labo7.commands.CommandLog;
import labo7.commands.EditDocumentCommand;
import labo7.commands.Invoker;


public class EditorButton extends JButton implements Invoker, ActionListener {

	private Command cmd;
//	protected EditableDocument model;
	protected JTextArea textBox;

	public EditorButton(String label,JTextArea area)
	{
		super(label);
		setMaximumSize(new Dimension(120,20));
		this.addActionListener(this);
		textBox=area;
	}

	@Override
	public void actionPerformed(ActionEvent evt){
		cmd.execute();
	}


	@Override
	public void storeCommand(Command command) {
		cmd = command;
	}
}
