package labo7.commands;

import labo7.model.EditableDocument;
import labo7.ui.EditorCheckBox;

public class ToggleInsertCommand extends Command {

    private EditableDocument model;
    private EditorCheckBox toggle;

    public ToggleInsertCommand(EditableDocument model, EditorCheckBox toggle) {
        this.model = model;
        this.toggle = toggle;
    }
    @Override
    public void execute() {
        if (toggle.isSelected()) {
            model.enableInsert();
        } else {
            model.disableInsert();
        }
    }
}
