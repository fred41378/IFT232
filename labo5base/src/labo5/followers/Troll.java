package labo5.followers;

import labo5.Labo5Main;
import labo5.Message;
import labo5.Util;
import labo5.ui.MessageView;

public class Troll implements Follower{

    protected MessageView viewport;
    private String name;
    private int numTroll;

    public Troll(Labo5Main ui,String n, int nt){
        name=n;
        viewport = new MessageView(ui,name+" news feed");
        numTroll=nt;
    }

    @Override
    public void update(Message message) {
        if(Util.contains(message.getMessage(), Util.TROLL_DICTIONNARY1)&&numTroll==1){
           viewport.appendMessage(Util.TROLL_REPLY1);
        }
        else if(Util.contains(message.getMessage(), Util.TROLL_DICTIONNARY2)&&numTroll==2){
            viewport.appendMessage(Util.TROLL_REPLY2);
        }
    }
}
