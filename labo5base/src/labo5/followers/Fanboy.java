package labo5.followers;

import labo5.Message;
import labo5.Util;
import labo5.celebrities.SocialMediaCelebrity;

public class Fanboy extends SocialMediaCelebrity implements Follower {

    public Fanboy(String n, int wait) {
        super(n, wait);
    }

    @Override
    public void changeStatus() {

    }

    @Override
    public void update(Message message) {
        //if(Util.contains(message.getMessage(), message.getSujet().))
    }
}
