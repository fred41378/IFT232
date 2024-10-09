package videoStore;

import java.util.Vector;

public class FrenchStatement extends Statement{


    protected String footer(Customer c) {
        return "Le total du est: " + c.getTotalAmount() + "\n"
                + "Vous avez gagner " + c.getFrequentRenterPoints() + " points de client frequent\n";
    }

    protected String header(Customer c) {
        return  "Record de location pour " + c.getName() + "\n";
    }

    protected String rentalLine(Rental each) {
        return "\t" + each.getMovie().getTitle() + "\t" + each.getAmount() + "\n";
    }
}
