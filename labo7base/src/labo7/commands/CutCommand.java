package labo7.commands;

import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

public class CutCommand extends EditDocumentCommand {


    public CutCommand(EditableDocument model, EditorTextArea textBox, CommandLog log) {
        super(model, textBox, log);
    }

    @Override
    public void undo() {
        model.setText(oldData);
        System.out.println("Undo Cut");
    }

    @Override
    public void execute() {
        oldData = model.getText();
        model.cut(textBox.getSelectionStart(),textBox.getSelectionEnd());
        EditDocumentCommand cmdClone = this.clone();
        log.add(cmdClone);
    }
}
