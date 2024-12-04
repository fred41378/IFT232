package labo7.commands;

import java.util.Stack;

public class CommandLog {
    private Stack<Command> pastCommands = new Stack<>();

    public void add(Command cmd) {
        pastCommands.add(cmd);
    }

    public void undo(){
        System.out.println("Undo CommandLog");
        if (!pastCommands.isEmpty()) {
            EditDocumentCommand cmd = (EditDocumentCommand)pastCommands.pop();
            cmd.undo();
        }
    }

    public boolean isEmpty() {
        return pastCommands.isEmpty();
    }
}
