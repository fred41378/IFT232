package labo2;

/*
 * Classe représentant une matrice. Composée d'une liste
 * de vecteurs. Chaque rangée de la matrice est un vecteur.
 */
public class Matrice {

	private Vecteur[] lignes;

	public Matrice(double[][] dat) {

		lignes = new Vecteur[dat.length];

		for (int i = 0; i < dat.length; i++) {

			lignes[i] = new Vecteur(dat[i]);

		}
	}

	/*
	 * Élimination Gaussienne. Let me google that for you... Implémentation
	 * suivant le pseudo-code classique.
	 */
	public void Gauss() {

		int noLigne = 0;
		for (Vecteur ligne : lignes) {
			double pivot = ligne.getValeur(noLigne);
			if (pivot != 0) {
				double pivotInverse = 1.0 / pivot;
				for (int i = 0; i < ligne.taille(); i++) {
					ligne.setValeur(i, ligne.getValeur(i) * pivotInverse);
				}
			}

			for (Vecteur ligneElim : lignes) {
				if (ligneElim != ligne) {
					double f = ligneElim.getValeur(noLigne);
					for (int i = 0; i < ligneElim.taille(); ++i) {
						ligneElim.setValeur(i, ligneElim.getValeur(i) - f * ligne.getValeur(i));
					}
				}
			}
			noLigne++;
		}
	}
	
	public String toString() {

		String res = "";

		for (Vecteur v : lignes) {
			res += v + "\n";
		}

		return res;
	}

	public boolean equals(Object obj){
		if(obj instanceof Matrice){
			Matrice matrice = (Matrice) obj;
			if(lignes.length != matrice.lignes.length){
				return false;
			}
			for (int i = 0; i < lignes.length; i++) {
				if(!lignes[i].equals(matrice.lignes[i])){
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public Matrice sousMatrice(int pLignes, int pColonnes){
		if(pLignes < 0 || pColonnes < 0 || pColonnes > lignes.length){
			throw new IllegalArgumentException("Dimensions inadmissibles");
		}
		for (int i = 0; i < lignes.length; i++) {
			if(pLignes > lignes[i].taille()){
				throw new IllegalArgumentException("Dimensions inadmissibles");
			}
		}
		double[][] nouvellesLignes = new double[pColonnes][];
		for (int i = 0; i < pLignes; i++) {
			for (int j = 0; j < pColonnes; j++) {
				nouvellesLignes[i][j] = lignes[i].getValeur(j);
			}
		}
		return new Matrice(nouvellesLignes);
	}
}
