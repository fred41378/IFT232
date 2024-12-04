package labo5;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import labo5.celebrities.BroScienceCelebrity;
import labo5.celebrities.DramaticCelebrity;
import labo5.celebrities.PositiveCelebrity;
import labo5.celebrities.SocialMediaCelebrity;
import labo5.followers.*;
import labo5.ui.MessageView;

public class Labo5Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel background;
	private ArrayList<MessageView> views = new ArrayList<MessageView>();

	private ArrayList<SocialMediaCelebrity> posters = new ArrayList<SocialMediaCelebrity>();
	private MessageLog log = new MessageLog();

	/*
	 * Initialisation des Celebrities et des Followers. établissement des liens
	 * entre eux.
	 */

	public Labo5Main(String[] args) {

		DramaticCelebrity dramaQueen = new DramaticCelebrity("BritneySpears", 2);
		PositiveCelebrity spiritualKing = new PositiveCelebrity("LookWithin", 3);
		BroScienceCelebrity superBro = new BroScienceCelebrity("JohnCena", 4);
		Fanboy fanboy = new Fanboy(this, "Simp_Master", 1);
		Hater hater = new Hater(this, "NoGainsWithPains", 1);
		Troll troll1 = new Troll(this, "ElmoTheKingOfIdiots",1);
		Troll troll2 = new Troll(this, "JJFREAKY",2);
		posters.add(dramaQueen);
		posters.add(spiritualKing);
		posters.add(superBro);
		posters.add(fanboy);
		posters.add(hater);

		for (SocialMediaCelebrity poster: posters){
			poster.attach(troll1);
			poster.attach(troll2);
		}

		SerialReposter nolife = new SerialReposter(this, "NoLife");

		dramaQueen.attach(new Reposter(this, "Britney_Fan"));
		dramaQueen.attach(log);
		dramaQueen.attach(nolife);
		dramaQueen.attach(fanboy);


		spiritualKing.attach(new Reposter(this, "Spiritual_Fan"));
		spiritualKing.attach(log);
		spiritualKing.attach(nolife);

		superBro.attach(new Reposter(this, "JohnCena_Fan"));
		superBro.attach(log);
		superBro.attach(nolife);
		superBro.attach(hater);

		fanboy.attach(new Reposter(this, "Simp_Master_Fan"));
		fanboy.attach(log);

		hater.attach(new Reposter(this, "NoGainsWithPains_Fan"));
		hater.attach(log);

		PressAgent agentSmith = new PressAgent("Agent_Smith", Util.TROLL_DICTIONNARY1);
		dramaQueen.attachVeto(agentSmith);
		spiritualKing.attachVeto(agentSmith);
		superBro.attachVeto(agentSmith);
	}
	
	/*
	 * Boucle qui change les statuts des vedettes à tour de rôle. 
	 * Drama knows no bounds! Ne terminera jamais (fermez la fenêtre pour
	 * arrêter le programme).
	 */

	public void startTheDrama() {

		while (true) {
			for(SocialMediaCelebrity celeb: posters){
				celeb.changeStatus();
			}
		}

	}

	/*
	 * Initialisation de la fenêtre.
	 */
	private void initUI() {

		setTitle("FaceTwit");
		setSize(1600, 1000);
		background = new JPanel(new GridLayout(4, 5));
		for (MessageView view : views) {
			background.add(view);
		}

		add(background);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void addToMainWindow(MessageView view) {
		views.add(view);
	}

	public static void main(String[] args) {

		/*
		 * Mise en file de l'exécution de l'interface graphique pour le
		 * EventDispatchThread (gestionnaire de fenêtres).
		 */
		Labo5Main ex = new Labo5Main(args);

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {

				ex.initUI();
				ex.setVisible(true);
			}
		});

		ex.startTheDrama();
	}
}
