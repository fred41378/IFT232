package labo2.tests;

import labo2.Matrice;
import labo2.Vecteur;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

public class TestMatrice {
    double[][] s1 = {
            { 3, 5, -3, 15 },
            { 7, 10, 1, 2 },
            { -3, 2, -5, 6 }
    };
    Matrice m1 = new Matrice(s1);

    @Before
    public void setUp(){
        m1 = new Matrice(s1);
    }

    @Test
    public void testToString(){

        String restAttendu  = "[3.0 5.0 -3.0 15.0]\n" +
                "[7.0 10.0 1.0 2.0]\n" +
                "[-3.0 2.0 -5.0 6.0]\n";

        assertEquals(m1.toString(), restAttendu);
    }

    @Test
    public void testEquals(){
        double[][] t2l1 = {
                { 3, 5, -3, 15 },
                { 7, 10, 1, 2 },
                { -3, 2, -5, 6 }
        };
        double[][] t2l2 = {
                { 3, 5, -3, 15 },
                { 70, 10, 1, 2 },
                { -3, 2, -5, 6 }
        };
        double[][] t2l3 = {
                { 3, 5, -3, 15 },
                { 7, 10, 1, 2 },
                { -30, 2, -5, 6 },
                { -30, 2, -50, 6 }
        };
        Matrice mt1 = new Matrice(s1);

        Matrice resAttendu = new Matrice(t2l1);
        Matrice mt2 = new Matrice(t2l2);
        Matrice mt3 = new Matrice(t2l3);

        assertEquals(resAttendu,m1);
        assertNotEquals(mt2,mt3);
        assertNotEquals(mt1,"test");
        assertNotEquals(mt1,mt3);
        assertNotEquals(mt3,mt1);

    }

    @Test
    public void testGauss(){
        m1.Gauss();

        double[][] t3l2 = {
                { 1, 0, 0, 4.15625 },
                { 0, 1, 0, -2.25 },
                { 0, 0, 1, -4.59375 }
        };
        Matrice resAttendu = new Matrice(t3l2);

        assertEquals(m1,resAttendu);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSousMatrice(){
        Matrice m1 = new Matrice(s1);
        Matrice m2 = m1.sousMatrice(2, 3);
        double[][] s2 = {
                { 3, 5, -3 },
                { 7, 10, 1 }
        };
        Matrice resAttendu = new Matrice(s2);

        Matrice err1 = m1.sousMatrice(-1, 3);
        Matrice err2 = m1.sousMatrice(2, -1);
        Matrice err3 = m1.sousMatrice(4, 3);
        Matrice err4 = m1.sousMatrice(2, 5);

        assertEquals(m2, resAttendu);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreerMatriceNul(){
        Matrice m2 = Matrice.creerMatriceNul(3, 4);
        double[][] s2 = {
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 }
        };
        Matrice resAttendu = new Matrice(s2);

        Matrice err1 = m1.sousMatrice(0, 3);
        Matrice err2 = m1.sousMatrice(2, 0);
        Matrice err3 = m1.sousMatrice(-1, 3);
        Matrice err4 = m1.sousMatrice(2, -1);

        assertEquals(m2, resAttendu);
    }
}
