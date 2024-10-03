package videoStore.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import videoStore.Movie;
import videoStore.Rental;

public class RentalTest {
    public static double DELTA = 0.001;
    Movie childMovie;
    Movie newMovie1;
    Movie newMovie2;
    Movie regularMovie;
    @Before
    public void setUp(){
        childMovie = new Movie("Caillou a le cancer", Movie.CHILDRENS);
        newMovie1 = new Movie("31 Jump Street: Ninja Academy", Movie.NEW_RELEASE);
        newMovie2 = new Movie("Fast and furious 38: Diesel Cars vs Google Cars", Movie.NEW_RELEASE);
        regularMovie = new Movie("Les oiseaux se cachent pour mourir", Movie.REGULAR);
    }

    @Test
    public void testGetAmount(){
        Rental shortRegular = new Rental(regularMovie, 1);
        Rental longRegular = new Rental(regularMovie, 14);
        Rental shortChild = new Rental(childMovie, 1);
        Rental longChild = new Rental(childMovie, 14);
        Rental shortNewRel = new Rental(newMovie1, 1);
        Rental longNewRel = new Rental(newMovie1, 14);

        assertEquals(shortRegular.getAmount(), 2, DELTA);
        assertEquals(longRegular.getAmount(), 20, DELTA);
        assertEquals(shortChild.getAmount(), 1.5, DELTA);
        assertEquals(longChild.getAmount(), 18, DELTA);
        assertEquals(shortNewRel.getAmount(), 3, DELTA);
        assertEquals(longNewRel.getAmount(), 42, DELTA);
    }

    @Test
    public void testGetFrequentRenterPoints(){
        Rental rentalRegular = new Rental(regularMovie, 1);
        Rental rentalChild = new Rental(childMovie, 1);
        Rental rentalNew = new Rental(newMovie1, 1);
        Rental rentalNew2 = new Rental(newMovie2, 1);
        Rental[] rentalsOneNew = {rentalRegular, rentalChild, rentalNew};
        Rental[] rentalsTwoNew = {rentalRegular, rentalChild, rentalNew, rentalNew2};
        Rental[] rentalsNoNew = {rentalRegular, rentalChild};
        int frqPtsOneNew = 0;
        int frqPtsTwoNew = 0;
        int frqPtsNoNew = 0;

        for (Rental each : rentalsOneNew){
            frqPtsOneNew += each.getFrequentRenterPoints();
        }
        for (Rental each : rentalsTwoNew){
            frqPtsTwoNew += each.getFrequentRenterPoints();
        }
        for (Rental each : rentalsNoNew){
            frqPtsNoNew += each.getFrequentRenterPoints();
        }

        assertEquals(frqPtsOneNew, 4);
        assertEquals(frqPtsTwoNew, 6);
        assertEquals(frqPtsNoNew, 2);
    }
}
