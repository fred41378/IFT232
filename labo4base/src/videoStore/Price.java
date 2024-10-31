package videoStore;

public abstract class Price {
    private int code;

    public int getPriceCode(){
        return this.code;
    }

    public void setPriceCode(int pCode){
        this.code = pCode;
    }

    public int points(){return 1;}

    public abstract double amount(int daysRented);

}
