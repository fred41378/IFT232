package labo7.commands;

import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

public class PasteCommand extends EditDocumentCommand {


    public PasteCommand(EditableDocument model, EditorTextArea textBox, CommandLog log) {
        super(model, textBox, log);
    }

    @Override
    public void undo() {
        model.setText(oldData);
        System.out.println("Undo Paste");
    }

    @Override
    public void execute() {
        oldData = model.getText();
        model.paste(textBox.getSelectionStart());
        EditDocumentCommand cmdClone = this.clone();
        log.add(cmdClone);
    }
}
