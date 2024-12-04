package labo6;

import java.util.Random;

/*
 * Définitions et fonctions utilitaires.
 */

public class Ressources {

	public enum Gender {
		man(0), woman(1), nonbinary(2);

		public final int value;

		Gender(int v) {
			value = v;
		}
		
		public static Gender random(){
			Random generator = new Random();
				
			return values()[generator.nextInt(values().length)];
		}
	}

	public enum Country {
		Canada(0), Quebec(1), France(2), Japan(3), UnitedStates(4);

		public final int value;

		Country(int v) {
			value = v;
		}

		public Country next() {

			return values()[(value + 1) % values().length];

		}
	}

	

	public static final String[] flagImages = { "images/canflag.png", "images/quebecflag.png", "images/franceflag.png",
			"images/japflag.png", "images/usflag.png"

	};

	
	public static final String[] genderIcons = {

			"images/masicon.png", "images/femicon.png", "images/unkicon.png" };

	
}
