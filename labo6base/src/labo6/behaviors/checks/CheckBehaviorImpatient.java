package labo6.behaviors.checks;

import labo6.bots.ChatBot;

public class CheckBehaviorImpatient extends CheckBehavior {
    //Seduction Session
    @Override
    public boolean checkForWakeUp(String text, ChatBot bot) {
        return !text.trim().isEmpty();
    }
}
