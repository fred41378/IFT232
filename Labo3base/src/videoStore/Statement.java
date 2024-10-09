package videoStore;

import java.util.Vector;

public abstract class Statement {

    public String print(Vector<Rental> rentals, Customer c) {
        String result = header(c);
        for (Rental each : rentals) {
            result += rentalLine(each);
        }
        // add footer lines
        result += footer(c);
        return result;
    }

    protected abstract String header(Customer c);
    protected abstract String rentalLine(Rental r);
    protected abstract String footer(Customer c);
}
