package labo5.followers;

import labo5.Message;

/*
 * Journal système. Affiche dans la console le message en question.
 * Utilisez-le pour voir si les messages sont produits comme prévu
 * par les vedettes.
 */
public class MessageLog implements Follower {
	
	public void update(Message m){
		
		System.out.println(m.getMessage());
	}

}
