package labo6.profiler;

import labo6.Ressources.Gender;
import labo6.User;
import labo6.bots.ChatBot;
import labo6.behaviors.checks.CheckBehavior;
import labo6.behaviors.waits.WaitBehavior;
import labo6.database.Picture;
import labo6.Ressources.Country;
import labo6.database.PictureList;
import labo6.database.TextList;
import labo6.database.TextMessage;

public abstract class Profiler {

    protected User peer;
    protected Country country;


    public Profiler(User human) {
        this.peer = human;
        country = human.getCountry();
    }

    public abstract PictureList getSuitablePictures();
    public abstract TextList getSuitableMessages();
    public abstract CheckBehavior createCheckBehavior();
    public abstract WaitBehavior createWaitBehavior();


    public ChatBot createChatBot(User user, Picture picture, Gender gender) {
        return new ChatBot(user, "Bot", picture, gender, createCheckBehavior(), createWaitBehavior());
    }

    public String generateGreeting() {
        return getSuitableMessages().keep(TextMessage.TextKey.isGreeting, true).random().getMessage();
    }

    public TextMessage generateAnswer() {
        return getSuitableMessages().random();
    }
}
