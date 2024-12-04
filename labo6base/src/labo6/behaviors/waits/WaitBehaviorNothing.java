package labo6.behaviors.waits;

import labo6.bots.ChatBot;

public class WaitBehaviorNothing extends WaitBehavior {
    //Casual Session
    @Override
    public void waitForUser(ChatBot bot) {
        bot.sleep(2000);
    }
}
