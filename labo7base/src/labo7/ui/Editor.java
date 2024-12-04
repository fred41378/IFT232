package labo7.ui;


import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import labo7.commands.*;
import labo7.model.EditableDocument;
import labo7.ui.buttons.EditorButton;
import labo7.ui.shortcuts.KeyboardShortcut;
import labo7.ui.shortcuts.ShortcutManager;

@SuppressWarnings("serial")
public class Editor extends JFrame{

	
	private EditableDocument model;
	
	
	private ShortcutManager shortcuts;

	
	private EditorLabel charCount;
	private EditorCheckBox insert;
	private EditorTextArea textBox;
	private EditorButton copyButton;
	private EditorButton cutButton;
	private EditorButton pasteButton;
	private EditorButton minButton;
	private EditorButton twitButton;
	private EditorButton majButton;
	private EditorButton redoButton;
	private EditorButton undoButton;

	private CommandLog CommandLog;



	public void initCommands(CommandLog log) {
		CommandFactory.initialize(model, textBox, log, insert);
		CommandLog = log;

		//Commandes
		EditDocumentCommand copyCommand = CommandFactory.createCopyCommand();
		EditDocumentCommand cutCommand = CommandFactory.createCutCommand();
		EditDocumentCommand pasteCommand = CommandFactory.createPasteCommand();
		EditDocumentCommand minCommand = CommandFactory.createMinCommand();
		EditDocumentCommand majCommand = CommandFactory.createMajCommand();
		EditDocumentCommand twitCommand = CommandFactory.createTwitCommand();
		Command toggle = CommandFactory.createToggleInsertCommand();

		//Boutons
		copyButton.storeCommand(copyCommand);
		cutButton.storeCommand(cutCommand);
		pasteButton.storeCommand(pasteCommand);
		minButton.storeCommand(minCommand);
		majButton.storeCommand(majCommand);
		twitButton.storeCommand(twitCommand);
		insert.storeCommand(toggle);

		//Les shortcut
		KeyboardShortcut copy = new KeyboardShortcut(KeyEvent.VK_C, true);
		copy.storeCommand(copyCommand);
		shortcuts.addShortcut(copy);

		KeyboardShortcut paste = new KeyboardShortcut(KeyEvent.VK_V, true);
		paste.storeCommand(pasteCommand);
		shortcuts.addShortcut(paste);

		KeyboardShortcut cut = new KeyboardShortcut(KeyEvent.VK_X, true);
		cut.storeCommand(cutCommand);
		shortcuts.addShortcut(cut);

		// Undo
		Command undoCommand = new UndoCommand(log);
		undoButton.storeCommand(undoCommand);
		KeyboardShortcut undo = new KeyboardShortcut(KeyEvent.VK_Z, true);
		undo.storeCommand(undoCommand);
		shortcuts.addShortcut(undo);
	}


	public Editor(EditableDocument doc) {

		setModel(doc);
		setSize(800,600);
		setTitle("TwitEdit");		

		
		Font font =new Font("Arial",Font.BOLD,20);
		JPanel background = new JPanel();
		background.setLayout(new BoxLayout(background ,BoxLayout.X_AXIS));
		
		//Bo�te de texte
		textBox= new EditorTextArea(500, 400,model, CommandLog);
		textBox.setFont(font);
		textBox.setLineWrap(true);
		textBox.setWrapStyleWord(true);
		
		//Gestionnaire de clavier pour les raccourcis
		shortcuts= new ShortcutManager(); 
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(shortcuts);
		
		
		/*
		 * Initialisation du panneau contenant les boutons
		 */		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel,BoxLayout.Y_AXIS));
		buttonsPanel.setMaximumSize(new Dimension(130,600));


		copyButton = new EditorButton("Copier",textBox);
		cutButton = new EditorButton("Couper",textBox);
		pasteButton = new EditorButton("Coller",textBox);
		majButton = new EditorButton("MAJUSCULES",textBox);
		minButton = new EditorButton("minuscules",textBox);
		twitButton = new EditorButton("Twitterize",textBox);

		buttonsPanel.add(Box.createVerticalGlue());
		buttonsPanel.add(copyButton);
		buttonsPanel.add(cutButton);
		buttonsPanel.add(pasteButton);
		buttonsPanel.add(majButton);
		buttonsPanel.add(minButton);
		buttonsPanel.add(twitButton);
		buttonsPanel.add(Box.createVerticalGlue());

		background.add(buttonsPanel);
		background.add(Box.createHorizontalGlue());
		
		
		/*
		 * Initialisation du panneau contenant la bo�te de texte et les autres contr�les
		 */		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BoxLayout(textPanel,BoxLayout.Y_AXIS));			
			
	
		//Compteur de caract�res
		charCount=new EditorLabel();
		charCount.setModel(model);
		charCount.setFont(font);
		textPanel.add(charCount);
		textPanel.add(textBox);
	
		//Panneau avec undo, redo et insere
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new BoxLayout(controlPanel,BoxLayout.X_AXIS));

		undoButton = new EditorButton("undo",textBox);
		redoButton = new EditorButton("redo",textBox);

		
		insert = new EditorCheckBox("Insertion",model);
		insert.setSelected(true);
		controlPanel.add(undoButton);
		controlPanel.add(redoButton);
		controlPanel.add(insert);
		
		textPanel.add(controlPanel);		
		background.add(textPanel);		
		
		
		//Ajout du panneau principal dans le frame
		add(background);		
		
		//Pr�parations finales
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public void setModel(EditableDocument doc) {
		model=doc;		
	}	

}