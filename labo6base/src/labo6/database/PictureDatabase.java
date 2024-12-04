package labo6.database;

import labo6.Ressources.Gender;

public class PictureDatabase {

	private static final PictureList PICTURES = new PictureList();

	public static PictureList getAllPictures() {
		return (PictureList) PICTURES.clone();
	}

	static {

		PICTURES.add("images/bender.png", Gender.nonbinary, true, true);
		PICTURES.add("images/goku.png", Gender.man, true, false);
		PICTURES.add("images/Troll.png", Gender.man, true, false);
		PICTURES.add("images/burger.png", Gender.man, false, false);
		PICTURES.add("images/barbie.png", Gender.woman, false, false);
		PICTURES.add("images/cat.png", Gender.man, false, false);
		PICTURES.add("images/catseyes.png", Gender.woman, true, true);
		PICTURES.add("images/corn.png", Gender.nonbinary, false, false);
		PICTURES.add("images/diver.png", Gender.man, false, false);
		PICTURES.add("images/dog.png", Gender.nonbinary, false, false);
		PICTURES.add("images/emmawatson.png", Gender.woman, false, true);
		PICTURES.add("images/ryangosling.jpg", Gender.man, false, true);
		PICTURES.add("images/dolphin.png", Gender.nonbinary, false, false);
		PICTURES.add("images/sakura.png", Gender.woman, true, false);
		PICTURES.add("images/shark.png", Gender.nonbinary, false, false);
		PICTURES.add("images/spike.png", Gender.man, true, true);
		PICTURES.add("images/towel.png", Gender.woman, false, true);
		PICTURES.add("images/football2.png", Gender.man, false, false);

	}

}
