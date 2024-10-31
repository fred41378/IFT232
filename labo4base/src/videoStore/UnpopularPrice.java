package videoStore;

public class UnpopularPrice extends Price {

    public double amount(int daysRented) {
        return 2;
    }

    public int points(){
        return 3;
    }
}
