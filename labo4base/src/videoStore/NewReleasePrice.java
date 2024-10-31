package videoStore;

public class NewReleasePrice extends Price{

    public double amount(int daysRented){
        return daysRented * 3;
    }

    public int points(){
        return 2;
    }
}
