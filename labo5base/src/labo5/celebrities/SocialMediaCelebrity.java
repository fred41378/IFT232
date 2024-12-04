package labo5.celebrities;

import labo5.Message;

public abstract class SocialMediaCelebrity extends Sujet{

	private int waitTime;
	protected String name;
	protected String status = "I'm new to Facetwit, lol.";

	public SocialMediaCelebrity(String n, int wait) {
		name = n;
		waitTime = wait * 1000;

	}

	public abstract void changeStatus();

	protected void setStatus(String ns) {
		waitBeforePost();
		Message msg = new Message(ns, this);
		if (checkVeto(msg)) {
			status = ns;
			notifyFollowers(msg);
		} else {
			System.out.println(getName() + ": OBJECTIONS !!!");
		}
	}

	public String getStatus() {
		return status;
	}

	public String getName() {
		return name;
	}

	private void waitBeforePost() {
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
		}
	}

}
