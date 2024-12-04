package labo6.behaviors.waits;

import labo6.Ressources;
import labo6.bots.ChatBot;

public abstract class WaitBehavior {
    public abstract void waitForUser(ChatBot bot);
    protected Ressources.Country country;
}
