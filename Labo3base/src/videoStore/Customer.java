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

    public String englishStatement() {
        String result = "Rental Record for " + getName() + "\n";
        for (Rental each : rentals) {
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getAmount() + "\n";
        }
        // add footer lines
        result += "Amount owed is " + getTotalAmount() + "\n";
        result += "You earned " + getFrequentRenterPoints()
                + " frequent renter points\n";
        return result;
    }

    public String frenchStatement() {
        String result = "Record de location pour " + getName() + "\n";
        for (Rental each : rentals) {
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getAmount() + "\n";
        }
        // add footer lines
        result += "Le total du est: " + getTotalAmount() + "\n";
        result += "Vous avez gagner " + getFrequentRenterPoints()
                + " points de client frequent\n";
        return result;
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

}
