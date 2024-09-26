package labo2.tests;

import org.junit.Before;
import org.junit.Test;

import labo2.Vecteur;

import static org.junit.Assert.*;

public class TestVecteur {

	double[] s1 = { 1, 2, 3, 14 };			
	Vecteur l1 = new Vecteur(s1);	
	
	
	@Before
	public void setup(){		
				
		l1 = new Vecteur(s1);	
		
	}
	//Exercice 1
	//Déjà fait en guise d'exemple.
	//Quelque-chose de semblable doit être fait du côté de TestMatrice.
	@Test
	public void testToString() {

		double[] s1l1 = { 1, 2, 3, 14 };		

		Vecteur l1 = new Vecteur(s1l1);	
		
		String resAttendu = "[1.0 2.0 3.0 14.0]";
		
		assertTrue(l1.toString().equals(resAttendu));
		
		
		
	}
	//Exercice 2
	//Devrait fonctionner une fois votre equals implanté. 
	//Incomplet! N'oubliez pas d'ajouter d'autres assertions.
	//Quelque-chose de semblable doit être fait du côté de TestMatrice.
	@Test
	public void testEquals() {

		double[] s2 = { 1, 2, 3, 14 };
		double[] s3 = { 10, 2, 3, 14 };
		double[] s4 = { 1, 20, 3, 14 };

		Vecteur l1 = new Vecteur(s1);
		
		Vecteur resAttendu = new Vecteur(s2);
		Vecteur l2 = new Vecteur(s3);
		Vecteur l3 = new Vecteur(s4);

		assertEquals(resAttendu,l1);
		assertNotEquals(l2,l3);
		assertNotEquals(l1,"test");
		assertNotEquals(l1,l3);
		assertNotEquals(l3,l1);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSousVecteur(){
		Vecteur l1 = new Vecteur(s1);
		Vecteur l2 = l1.sousVecteur(2);
		double[] s2 = { 1, 2 };
		Vecteur resAttendu = new Vecteur(s2);

		Vecteur l3 = l1.sousVecteur(8);
		Vecteur l4 = l1.sousVecteur(-1);

		assertEquals(l2, resAttendu);
	}
}
