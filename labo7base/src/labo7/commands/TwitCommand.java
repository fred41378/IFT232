package labo7.commands;

import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

public class TwitCommand extends EditDocumentCommand {

    public TwitCommand(EditableDocument model, EditorTextArea textBox, CommandLog log) {
        super(model, textBox, log);
    }

    @Override
    public void undo() {
        model.setText(oldData);
        System.out.println("Undo Twit");
    }

    @Override
    public void execute() {
        oldData = model.getText();
        if(model.getText().length()>140){
            model.setText(model.getText().substring(0, 140));
            EditDocumentCommand cmdClone = this.clone();
            log.add(cmdClone);
        }

    }
}
