package labo7.commands;

public abstract class Command {
    protected CommandLog log;
    public abstract void execute();
}
