package labo6.behaviors.checks;

import labo6.bots.ChatBot;

public class CheckBehaviorSlowmo extends CheckBehavior {
    //Casual Session
    private String previousLine = "";

    @Override
    public boolean checkForWakeUp(String text, ChatBot bot) {
        String lastLine = bot.getPeer().getLastLine();
        boolean isRepeated = lastLine.equals(previousLine) && !lastLine.isEmpty();
        previousLine = lastLine;
        return isRepeated;
    }
}
