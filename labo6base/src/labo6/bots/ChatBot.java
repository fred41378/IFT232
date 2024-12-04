package labo6.bots;

import labo6.Ressources.Gender;
import labo6.User;
import labo6.behaviors.checks.CheckBehavior;
import labo6.behaviors.waits.WaitBehavior;
import labo6.database.Picture;
import labo6.database.TextDatabase;
import labo6.database.TextList;
import labo6.database.TextMessage;
import labo6.session.CasualSession;
import labo6.session.SeductionSession;
import labo6.session.Session;

public class ChatBot extends User {

	//L'utilisateur avec lequel le robot est en communication.
	protected User peer;
	private CheckBehavior checkBehavior;
	private WaitBehavior waitBehavior;

	public ChatBot(User p, String n, Picture pic, Gender g, CheckBehavior cb, WaitBehavior wb) {
		super(n, pic, g);
		peer = p;
		checkBehavior = cb;
		waitBehavior = wb;
	}

	public void sleep(int time) {
		try {

			Thread.sleep(time);
		} catch (InterruptedException e) {
		}
	}
	
	public void appendMessage(String msg){
		getUI().appendMessage(msg);
	}
	
	public User getPeer(){
		return peer;
	}

	public boolean checkForWakeUp(String text) {
		return checkBehavior.checkForWakeUp(text, this);
	}

	public void waitForUser() {
		waitBehavior.waitForUser(this);
	}



}
