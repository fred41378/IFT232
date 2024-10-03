package videoStore.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import videoStore.Customer;
import videoStore.Movie;
import videoStore.Rental;

public class CustomerTest {
    public static double DELTA = 0.001;
    private Customer grandmaman;

    @Before
    public void setup() {
        Movie movies[] = new Movie[5];

        movies[0] = new Movie("Caillou a le cancer", Movie.CHILDRENS);
        movies[1] = new Movie("Fast and furious 38: Diesel Cars vs Google Cars", Movie.NEW_RELEASE);
        movies[2] = new Movie("31 Jump Street: Ninja Academy", Movie.NEW_RELEASE);
        movies[3] = new Movie("Les oiseaux se cachent pour mourir", Movie.REGULAR);
        movies[4] = new Movie("Les gars chauds se cachent pour vomir", Movie.REGULAR);

        grandmaman = new Customer("Grand-môman");

        grandmaman.addRentals(new Rental(movies[0], 4));
        grandmaman.addRentals(new Rental(movies[1], 1));
        grandmaman.addRentals(new Rental(movies[2], 2));
        grandmaman.addRentals(new Rental(movies[3], 7));
        grandmaman.addRentals(new Rental(movies[4], 1));
    }

    @Test
    public void testWholeStatement() {

        String expectedEnglish = "Rental Record for Grand-môman\n";
        expectedEnglish += "\tCaillou a le cancer\t3.0\n";
        expectedEnglish += "\tFast and furious 38: Diesel Cars vs Google Cars\t3.0\n";
        expectedEnglish += "\t31 Jump Street: Ninja Academy\t6.0\n";
        expectedEnglish += "\tLes oiseaux se cachent pour mourir\t9.5\n";
        expectedEnglish += "\tLes gars chauds se cachent pour vomir\t2.0\n";
        expectedEnglish += "Amount owed is 23.5\n";
        expectedEnglish += "You earned 7 frequent renter points\n";

        String expectedFrench = "Record de location pour Grand-môman\n";
        expectedFrench += "\tCaillou a le cancer\t3.0\n";
        expectedFrench += "\tFast and furious 38: Diesel Cars vs Google Cars\t3.0\n";
        expectedFrench += "\t31 Jump Street: Ninja Academy\t6.0\n";
        expectedFrench += "\tLes oiseaux se cachent pour mourir\t9.5\n";
        expectedFrench += "\tLes gars chauds se cachent pour vomir\t2.0\n";
        expectedFrench += "Le total du est: 23.5\n";
        expectedFrench += "Vous avez gagner 7 points de client frequent\n";

        assertEquals(grandmaman.englishStatement(), expectedEnglish);
        assertEquals(grandmaman.frenchStatement(), expectedFrench);
    }

    @Test
    public void testGetTotalAmount() {
        double testAmount = 23.5;
        assertEquals(testAmount, grandmaman.getTotalAmount(), DELTA);
    }

    @Test
    public void testGetFrequentRenterPoints() {
        int testFrequentRenterPoints = 7;
        assertEquals(testFrequentRenterPoints, grandmaman.getFrequentRenterPoints());
    }

    @After
    public void teardown() {
        grandmaman = null;
    }

}
