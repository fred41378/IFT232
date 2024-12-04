package labo5.followers;

import labo5.Labo5Main;
import labo5.Message;
import labo5.Util;
import labo5.ui.MessageView;

public class PressAgent {

    private String name;
    private String[] vetoedWords;

    public PressAgent(String n, String[] v) {
        name = n;
        vetoedWords = v;
    }

    public boolean veto(Message message) {
        return Util.contains(message.getMessage(), vetoedWords);
    }
}
