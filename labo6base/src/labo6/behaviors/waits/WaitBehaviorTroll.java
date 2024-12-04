package labo6.behaviors.waits;

import labo6.Ressources;
import labo6.bots.ChatBot;
import labo6.database.TextDatabase;
import labo6.database.TextList;
import labo6.database.TextMessage;

public class WaitBehaviorTroll extends WaitBehavior {
    public int waiting = 0;

    @Override
    public void waitForUser(ChatBot bot) {
        country = bot.getPeer().getCountry();
        bot.sleep(1000);
        TextList messageList = TextDatabase.getAllMessages();
        if(country == Ressources.Country.France || country == Ressources.Country.Quebec){
            messageList = messageList.keep(TextMessage.TextKey.language, TextMessage.Language.english);
        }
        else if(country == Ressources.Country.Japan || country == Ressources.Country.Canada){
            messageList = messageList.keep(TextMessage.TextKey.language, TextMessage.Language.french);
        }

        if (waiting < 4) {
            messageList = messageList.keep(TextMessage.TextKey.isOffensive, true);
            waiting++;
        } else {
            messageList = messageList.keep(TextMessage.TextKey.isPassiveAggressive, true);
        }

        bot.appendMessage(messageList.random().getMessage());
    }
}