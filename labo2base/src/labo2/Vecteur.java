package labo2;


/*
 * Classe représentant un vecteur. 
 */

public class Vecteur {
	
	private double valeurs[];
	
	
	public Vecteur(double [] valeurs){
		
		this.valeurs = new double[valeurs.length];
		for(int i=0;i<valeurs.length;i++){
			
			this.valeurs[i]=valeurs[i];			
		}		
	}
	
	public String toString(){
		
		String res="[";
		for (double v:valeurs){
			res+=v+" ";
		}
		return  res.substring(0, res.length()-1)+"]";
	}
	
	public int taille(){
		return valeurs.length;
	}
	
	public double getValeur(int pos){
		return valeurs[pos];
	}
	
	public void setValeur(int pos,double val){
		valeurs[pos]=val;
	}

	public static boolean egaliteDoublePrecision(double a, double b, double epsilon){
		return (Math.abs(a-b)<=epsilon);
	}

	public boolean equals(Object obj){
		if(obj instanceof Vecteur){
			Vecteur v = (Vecteur)obj;
			if(valeurs.length!=v.valeurs.length){
				return false;
			}
			for (int i = 0; i < valeurs.length; i++) {
				if(!egaliteDoublePrecision(valeurs[i],v.valeurs[i],0.00001)){
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public Vecteur sousVecteur(int taille){
		if(taille>valeurs.length || taille<0){
			throw new IllegalArgumentException("Dimensions inadmissibles");
		}
		double[] nouvelleValeurs = new double[taille];
		for(int i=0;i<taille;i++){
			nouvelleValeurs[i] = valeurs[i];
		}
		return new Vecteur(nouvelleValeurs);
	}
	
}
