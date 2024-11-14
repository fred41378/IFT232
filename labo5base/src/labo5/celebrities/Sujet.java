package labo5.celebrities;

import labo5.Message;
import labo5.followers.Follower;
import labo5.followers.SerialReposter;

import java.util.ArrayList;

public abstract class Sujet {
    public ArrayList<Follower> followers = new ArrayList<Follower>();

    public void attach(Follower f) {
        followers.add(f);
    }

    public void notifyFollowers(Message notif){
        for (Follower f : followers) {
            f.update(notif);
        }
    }

    public abstract String getName();
}
