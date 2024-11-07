/*
 * Created on 2005-03-07
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package videoStore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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
	//private Price priceCode_;
	private ArrayList<PriceDate> prices = new ArrayList<PriceDate>();

	public Movie(String title, Price priceCode) {
		title_ = title;
		prices.add(new PriceDate(priceCode, LocalDate.now()));
	}

	public java.lang.String getTitle() {
		return title_;
	}

	public Price getPriceCode(LocalDate date) {
		Collections.sort(prices);

		PriceDate priceDate = null;

		for(int i = 0; i < prices.size(); i++) {
			if(prices.get(i).getDate().isBefore(date) || prices.get(i).getDate().isEqual(date)){
				priceDate = prices.get(i);
			}
		}

		if(priceDate != null){
			return priceDate.getPrice();
		}

		return null;
	}
	public void setPriceCode(Price priceCode, LocalDate date) {
		PriceDate newPriceDate = new PriceDate(priceCode, date);
		prices.add(newPriceDate);
	}
	public double amount(int dayRented, LocalDate date){
		Price price = getPriceCode(date);

		if (price != null) {
			return price.amount(dayRented);
		}

		return 0;
	}
	public int points(LocalDate date) {

		Price price = getPriceCode(date);

		if (price != null) {
			return price.points();
		}

		return 0;
	}
}
