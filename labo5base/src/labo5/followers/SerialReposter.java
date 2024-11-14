package labo5.followers;

import labo5.Labo5Main;
import labo5.Message;
import labo5.Util;
import labo5.celebrities.SocialMediaCelebrity;
import labo5.celebrities.Sujet;
import labo5.ui.MessageView;

import java.util.ArrayList;

public class SerialReposter extends Reposter {

    public SerialReposter(Labo5Main ui, String n) {
        super(ui,n);
    }

    public void update(Message message) {
        viewport.appendMessage(Util.personnalize(message.getSujet().getName(), message.getMessage()));
    }
}