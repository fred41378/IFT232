package labo6.session;

import labo6.Labo6Main;
import labo6.Ressources.Gender;
import labo6.User;
import labo6.behaviors.checks.CheckBehavior;
import labo6.behaviors.checks.CheckBehaviorPatient;
import labo6.behaviors.waits.WaitBehavior;
import labo6.behaviors.waits.WaitBehaviorAsk;
import labo6.bots.ChatBot;
import labo6.database.*;
import labo6.profiler.NormalProfile;
import labo6.profiler.Profiler;


/*
 * Cette classe représente une session d'un utilisateur humain
 * avec un ou plusieurs robots.
 * La session se termine lorsqu'on détecte que l'utilisateur humain
 * s'est déconnecté (change de pays ou de genre, via les boutons "PAYS" et "GENRE").
 */

public class Session {

	protected User human;
	private ChatBot robot;
	private Labo6Main ui;
	private boolean ended;
	private Thread sleeper;
	protected Profiler profiler;
	protected Gender botGender;

	public Session(Labo6Main l, User u) {
		ui = l;
		human = u;
		ended = false;
		sleeper = Thread.currentThread();
	}

	public static Session createSession(String type, Labo6Main ui, User user) {
		if (type.equals("normal")) {
			return new Session(ui, user);
		} else if (type.equals("seduction")) {
			return new SeductionSession(ui, user);
		} else if (type.equals("casual")) {
			return new CasualSession(ui, user);
		} else if (type.equals("troll")) {
			return new TrollSession(ui, user);
		} else {
			throw new IllegalArgumentException("Wrong session type: " + type);
		}
	}


	public void start() {
		profiler = createProfiler();

		robot = profiler.createChatBot(human, profiler.getSuitablePictures().random(), botGender);
		ui.initBackGround(robot);


		robot.appendMessage(profiler.generateGreeting());

		while (!hasEnded()) {

			robot.waitForUser();

			if (robot.checkForWakeUp(human.getText())) {

				robot.appendMessage(profiler.generateAnswer().getMessage());
			}

		}
	}

	public Profiler createProfiler() {
		botGender = human.getGender();
		return new NormalProfile(human);
	}


	/*
	 * Appelé par le bouton SUIVANT
	 */
	public void changeChatBot() {
		robot = profiler.createChatBot(human, profiler.getSuitablePictures().random(), botGender);
		ui.initBackGround(robot);
	}
	

	public synchronized void end() {
		ended = true;
		sleeper.interrupt();
	}

	private synchronized boolean hasEnded() {
		return ended;
	}	
	
	

}
