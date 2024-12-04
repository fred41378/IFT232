package labo7.commands;

import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

public abstract class EditDocumentCommand extends Command implements Cloneable{
    protected EditableDocument model;
    protected EditorTextArea textBox;
    protected String oldData;

    public EditDocumentCommand(EditableDocument model, EditorTextArea textBox, CommandLog log) {
        this.model = model;
        this.textBox = textBox;
        this.log = log;
    }

    public EditDocumentCommand clone(){
        try{
            return (EditDocumentCommand)super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public abstract void undo();

    public void execute(){
        oldData = textBox.getText();
    }

}
