package labo5.followers;

import labo5.Labo5Main;
import labo5.Message;
import labo5.Util;
import labo5.celebrities.SocialMediaCelebrity;
import labo5.ui.MessageView;

public class Hater extends SocialMediaCelebrity implements Follower{

    protected MessageView viewport;

    public Hater(Labo5Main ui, String n, int wait) {
        super(n, wait);
        viewport = new MessageView(ui,name +" news feed");
    }

    public void changeStatus() {
        setStatus(Util.getRandomString(Util.HATER_DICTIONNARY));
    }

    @Override
    public void update(Message message) {
        changeStatus();
        viewport.appendMessage(Util.personnalize(message.getSujet().getName(), Util.getRandomString(Util.HATER_DICTIONNARY)));
    }
}
