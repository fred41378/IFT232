package videoStore;

import java.time.LocalDate;

public class PriceDate implements Comparable{
    private Price price;
    private LocalDate date;

    public PriceDate(Price pPrice, LocalDate pDate) {
        price = pPrice;
        date = pDate;
    }

    public LocalDate getDate() {return date;}
    public Price getPrice() {return price;}


    @Override
    public int compareTo(Object o) {
        if (o instanceof PriceDate) {
            PriceDate p = (PriceDate) o;
            return date.compareTo(p.getDate());
        }
        return 0;
    }
}
