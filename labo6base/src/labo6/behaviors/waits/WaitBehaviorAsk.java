package labo6.behaviors.waits;

import labo6.Ressources;
import labo6.bots.ChatBot;
import labo6.database.TextDatabase;
import labo6.database.TextList;
import labo6.database.TextMessage;

public class WaitBehaviorAsk extends WaitBehavior {
    //Normal Session
    @Override
    public void waitForUser(ChatBot bot) {
        country = bot.getPeer().getCountry();
        bot.sleep(2000);
        TextList messageList = TextDatabase.getAllMessages().remove(TextMessage.TextKey.isSeductive, true).keep(TextMessage.TextKey.isQuestion, true);
        if(country == Ressources.Country.France || country == Ressources.Country.Quebec){
            messageList = messageList.keep(TextMessage.TextKey.language, TextMessage.Language.french);
        }
        else if(country == Ressources.Country.Japan || country == Ressources.Country.Canada){
            messageList = messageList.keep(TextMessage.TextKey.language, TextMessage.Language.english);
        }
        bot.appendMessage(messageList.random().getMessage());
    }
}
