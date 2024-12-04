package labo6.behaviors.checks;

import labo6.bots.ChatBot;

public class CheckBehaviorPatient extends CheckBehavior {
    //Session Normal
    @Override
    public boolean checkForWakeUp(String text, ChatBot bot) {
        String lastLine = bot.getPeer().getLastLine();
        return lastLine.trim().endsWith("?");
    }
}
