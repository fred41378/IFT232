package labo7.commands;

public class UndoCommand extends Command {
    private CommandLog log;

    public UndoCommand(CommandLog log) {
        this.log = log;
    }

    @Override
    public void execute() {
        log.undo();
    }
}
