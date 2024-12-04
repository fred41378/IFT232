package labo7.commands;

import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

public class CopyCommand extends EditDocumentCommand {


    public CopyCommand(EditableDocument model, EditorTextArea textBox, CommandLog log) {
        super(model, textBox, log);
    }

    @Override
    public void undo() {
        model.setText(oldData);
        System.out.println("Undo Copy");
    }

    @Override
    public void execute() {
        oldData = model.getText();
        model.copy(textBox.getSelectionStart(),textBox.getSelectionEnd());
        EditDocumentCommand cmdClone = this.clone();
        log.add(cmdClone);
    }

}
