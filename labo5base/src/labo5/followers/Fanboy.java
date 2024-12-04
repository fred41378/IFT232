package labo5.followers;

import labo5.Labo5Main;
import labo5.Message;
import labo5.Util;
import labo5.celebrities.SocialMediaCelebrity;
import labo5.ui.MessageView;

public class Fanboy extends SocialMediaCelebrity implements Follower {

    protected MessageView viewport;

    public Fanboy(Labo5Main ui, String n, int wait) {
        super(n, wait);
        viewport = new MessageView(ui,name +" news feed");
    }

    @Override
    public void changeStatus() {
        setStatus(Util.getRandomString(Util.FANBOY_DICTIONNARY));
    }

    @Override
    public void update(Message message) {
        changeStatus();
        viewport.appendMessage(Util.personnalize(message.getSujet().getName(), Util.getRandomString(Util.FANBOY_DICTIONNARY)));
    }
}
