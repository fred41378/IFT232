package labo6.behaviors.checks;

import labo6.bots.ChatBot;

public abstract class CheckBehavior {
    public abstract boolean checkForWakeUp(String text, ChatBot bot);
}
