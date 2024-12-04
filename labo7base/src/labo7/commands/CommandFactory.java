package labo7.commands;

import labo7.model.EditableDocument;
import labo7.ui.EditorCheckBox;
import labo7.ui.EditorTextArea;

public class CommandFactory {

    private static EditableDocument model;
    private static EditorTextArea textBox;
    private static CommandLog log;
    private static EditorCheckBox checkBox;

    private static CopyCommand copyCommand;
    private static PasteCommand pasteCommand;
    private static CutCommand cutCommand;
    private static MajCommand majCommand;
    private static MinCommand minCommand;
    private static TwitCommand twitCommand;
    private static ToggleInsertCommand toggleInsertCommand;

    public static void initialize(EditableDocument m, EditorTextArea t, CommandLog l, EditorCheckBox c) {
        model = m;
        textBox = t;
        log = l;
        checkBox = c; // Initialisation de EditorCheckBox
    }

    public static CopyCommand createCopyCommand() {
        if (copyCommand == null) {
            copyCommand = new CopyCommand(model, textBox, log);
        }
        return copyCommand;
    }

    public static PasteCommand createPasteCommand() {
        if (pasteCommand == null) {
            pasteCommand = new PasteCommand(model, textBox, log);
        }
        return pasteCommand;
    }

    public static CutCommand createCutCommand() {
        if (cutCommand == null) {
            cutCommand = new CutCommand(model, textBox, log);
        }
        return cutCommand;
    }

    public static MajCommand createMajCommand() {
        if (majCommand == null) {
            majCommand = new MajCommand(model, textBox, log);
        }
        return majCommand;
    }

    public static MinCommand createMinCommand() {
        if (minCommand == null) {
            minCommand = new MinCommand(model, textBox, log);
        }
        return minCommand;
    }

    public static TwitCommand createTwitCommand() {
        if (twitCommand == null) {
            twitCommand = new TwitCommand(model, textBox, log);
        }
        return twitCommand;
    }

    public static ToggleInsertCommand createToggleInsertCommand() {
        if (toggleInsertCommand == null) {
            toggleInsertCommand = new ToggleInsertCommand(model, checkBox);
        }
        return toggleInsertCommand;
    }
}
