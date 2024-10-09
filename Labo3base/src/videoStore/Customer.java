package videoStore;

import java.util.Vector;


/**
 * M. Fowler, et al., Refactoring, Improving the design of existing code,
 * Addison-Wiley, 2000. Exemple Chapitre 1
 * <p>
 * The Customer class represents the customer of the store.
 */

public class Customer {
    private String name;
    private Vector<Rental> rentals;

    public Customer(String name) {
        this.name = name;
        rentals = new Vector<Rental>();
    }

    public void addRentals(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (Rental each : rentals) {
            totalAmount += each.getAmount();
        }
        return totalAmount;
    }

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental each : rentals) {
            frequentRenterPoints += each.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    public String frenchStatement(){
        return new FrenchStatement().print(this.rentals, this);
    }
    public String englishStatement(){
        return new EnglishStatement().print(this.rentals, this);
    }

}
