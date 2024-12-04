package labo5.celebrities;

import labo5.Message;
import labo5.followers.Follower;
import labo5.followers.PressAgent;
import labo5.followers.SerialReposter;

import java.util.ArrayList;

public abstract class Sujet {
    public ArrayList<Follower> followers = new ArrayList<Follower>();
    public ArrayList<PressAgent> vetoFollowers = new ArrayList<PressAgent>();

    public void attach(Follower f) {
        followers.add(f);
    }

    public void notifyFollowers(Message notif){
        for (Follower f : followers) {
            f.update(notif);
        }
    }

    public boolean checkVeto(Message notif) {
        for (PressAgent a : vetoFollowers) {
            if(a.veto(notif))
                return false;
        }
        return true;
    }

    public void attachVeto(PressAgent pa) {
        vetoFollowers.add(pa);
    }

    public abstract String getName();
}
