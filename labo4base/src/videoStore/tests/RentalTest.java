package videoStore.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import videoStore.Movie;
import videoStore.Rental;

import java.time.LocalDate;

public class RentalTest {
	
	private final double EPSILON = 0.01;
	private Movie childMovie;
	private Movie regularMovie;
	private Movie newMovie;
	private Movie unpopularMovie;
	
	@Before
	public void setup() {
		childMovie = new Movie("Caillou a le cancer", Movie.CHILDRENS);
		newMovie = new Movie("31 Jump Street: Ninja Academy", Movie.NEW_RELEASE);
		regularMovie = new Movie("Les oiseaux se cachent pour mourir", Movie.REGULAR);
		unpopularMovie = new Movie("Titanic", Movie.UNPOPULAR_MOVIE);
	}
	
	
	@Test
	public void testAmount(){
		Rental child1day = new Rental(childMovie,1);
		Rental child3days = new Rental(childMovie,3);
		Rental child5days = new Rental(childMovie,5);
		Rental new1day = new Rental(newMovie,1);
		Rental new5days = new Rental(newMovie,5);
		Rental reg1day = new Rental(regularMovie,1);
		Rental reg2days = new Rental(regularMovie,2);
		Rental reg5days = new Rental(regularMovie,5);
		Rental unpop1day = new Rental(unpopularMovie,1);
		Rental unpop5day = new Rental(unpopularMovie,2);
		
		
		assertEquals(child1day.amount(),1.5,EPSILON);
		assertEquals(child1day.amount(), child3days.amount(),EPSILON);
		assertEquals(child5days.amount(),4.5,EPSILON);
		assertEquals(reg1day.amount(),2.0,0.0001);
		assertEquals(reg1day.amount(), reg2days.amount(),EPSILON);
		assertEquals(reg5days.amount(),6.5,EPSILON);
		assertEquals(new1day.amount(),3.0,EPSILON);
		assertEquals(new5days.amount(),15.0,EPSILON);
		assertEquals(unpop1day.amount(),2.0,EPSILON);
		assertEquals(unpop5day.amount(),2.0,EPSILON);
		
	}
	
	@Test
	public void testPoints(){
		Rental childrens = new Rental(childMovie,1);		
		Rental newrelease = new Rental(newMovie,1);	
		Rental regular = new Rental(regularMovie,5);
		Rental unpopular = new Rental(unpopularMovie,3);
		
		assertEquals(newrelease.points(),2);
		assertEquals(childrens.points(),1);
		assertEquals(regular.points(),1);
		assertEquals(unpopular.points(),3);
	}

	@Test
	public void testAmountDifferentDates() {

		unpopularMovie.setPriceCode(Movie.CHILDRENS, LocalDate.of(2002, 7, 28));
		unpopularMovie.setPriceCode(Movie.NEW_RELEASE, LocalDate.of(2004, 2, 3));
		unpopularMovie.setPriceCode(Movie.REGULAR, LocalDate.of(2016, 9, 14));
		unpopularMovie.setPriceCode(Movie.UNPOPULAR_MOVIE, LocalDate.of(2026, 8, 1));


		Rental firstRental = new Rental(unpopularMovie, LocalDate.of(2002, 7, 28) ,3);
		assertEquals(firstRental.amount(), 1.5, EPSILON);
		Rental secondRental = new Rental(unpopularMovie, LocalDate.of(2004, 2, 3) ,3);
		assertEquals(secondRental.amount(), 9, EPSILON);
		Rental thirdRental = new Rental(unpopularMovie, LocalDate.of(2016, 9, 14) ,3);
		assertEquals(thirdRental.amount(), 3.5, EPSILON);
		Rental fourthRental = new Rental(unpopularMovie, LocalDate.of(2026, 8, 1) ,3);
		assertEquals(fourthRental.amount(), 2, EPSILON);
	}

	
	@After
	public void teardown() {
		childMovie = null;
		regularMovie=null;
		newMovie=null;
		unpopularMovie=null;
	}
}
