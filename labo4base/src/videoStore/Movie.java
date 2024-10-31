/*
 * Created on 2005-03-07
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package videoStore;

/**
 * M. Fowler, et al., Refactoring, Improving the design of existing code,
 * Addison-Wiley, 2000. Exemple Chapitre 1
 * 
 * The class Movie is just a simple data class
 */

public class Movie {
	public static final Price REGULAR = new RegularPrice();
	public static final Price NEW_RELEASE = new NewReleasePrice();
	public static final Price CHILDRENS = new ChildrensPrice();
	public static final Price UNPOPULAR_MOVIE = new UnpopularPrice();

	private java.lang.String title_;
	private Price priceCode_;

	public Movie(String title, Price priceCode) {
		title_ = title;
		priceCode_ = priceCode;
	}

	public java.lang.String getTitle() {
		return title_;
	}

	public int getPriceCode() {
		return priceCode_.getPriceCode();
	}
	public void setPriceCode(int priceCode) {
		priceCode_.setPriceCode(priceCode);
	}
	public double amount(int dayRented){
		return priceCode_.amount(dayRented);
	}
	 public int points(){
		return priceCode_.points();
	 }
}
