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
			if(pColonnes > lignes[i].taille()){
				throw new IllegalArgumentException("Dimensions inadmissibles");
			}
		}
		double[][] nouvelleMatrice = new double[pLignes][pColonnes];
		for (int i = 0; i < pLignes; i++) {
			for (int j = 0; j < pColonnes; j++) {
				nouvelleMatrice[i][j] = lignes[i].getValeur(j);
			}
		}
		return new Matrice(nouvelleMatrice);
	}

	public static Matrice creerMatriceNul(int pLignes, int pColonnes){
		if(pLignes < 0 || pColonnes < 0 ){
			throw new IllegalArgumentException("Dimensions inadmissibles");
		}
		double[][] nouvelleMatrice = new double[pLignes][pColonnes];
		for (int i = 0; i < pLignes; i++) {
			for (int j = 0; j < pColonnes; j++) {
				nouvelleMatrice[i][j] = 0;
			}
		}
		return new Matrice(nouvelleMatrice);
	}

	public static Matrice creerrMatriceIdentite(int taille){
		if(taille < 0){
			throw new IllegalArgumentException("Dimensions inadmissibles");
		}
		double[][] nouvelleMatrice = new double[taille][taille];
		int positionUn = 0;
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				if(i == positionUn && j == positionUn){
					nouvelleMatrice[positionUn][i] = 1;
					positionUn++;
				}
				else {
					nouvelleMatrice[i][j] = 0;
				}
			}
		}
		return new Matrice(nouvelleMatrice);
	}
}
