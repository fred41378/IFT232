package labo2.tests;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

import labo2.Vecteur;
import labo2.Equation;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestEquation {
    ArrayList<Character> variables = new ArrayList<Character>(
            Arrays.asList('x', 'y', 'z')
    );
    ArrayList<Integer> coefficients = new ArrayList<Integer>(
            Arrays.asList(3, 5, -2)
    );
    int constante = 0;
    Equation e1;

    @Before
    public void setUp() {
        e1 = new Equation(variables, coefficients, constante);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLireEquation() {
        String equationString1 = "3x + 5y - 2z = 0";
        Equation e2 = new Equation();
        e2.lire(equationString1);

        String equationFause1 = "3x + 5y - 2z = ";
        Equation e3 = new Equation();
        e3.lire(equationFause1);
        String equationFause2 = "3x + 5z - 2z = 0";
        Equation e4 = new Equation();
        e4.lire(equationFause2);
        String equationFause3 = "3x + 5y - 2z = 0 + 3";
        Equation e5 = new Equation();
        e5.lire(equationFause3);
        String equationFause4 = "3x + 5y - 2z ";
        Equation e6 = new Equation();
        e6.lire(equationFause4);

        assertEquals(e1, e2);
    }

    @Test
    public void testToSringEquation() {
        String resAttendu = "3x + 5y - 2z = 0";
        String equationFause1 = "3x + 6y - 2z = 0 + 3";

        assertEquals(resAttendu, e1.toString());
        assertNotEquals(equationFause1, e1.toString());
    }
}
