package labo5.followers;

import labo5.Message;

/*
 * Journal syst�me. Affiche dans la console le message en question.
 * Utilisez-le pour voir si les messages sont produits comme pr�vu
 * par les vedettes.
 */
public class MessageLog implements Follower {
	
	public void update(Message m){
		
		System.out.println(m.getMessage());
	}

}
