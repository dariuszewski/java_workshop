package pl.dariuszewski.sales;

import java.math.BigDecimal;

public class Offer {

    private BigDecimal total;
    private int itemsCount;

    public Offer(BigDecimal total) {
        this.total = total;
        this.itemsCount = 0;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public int getItemsCount() {
        return itemsCount;
    }
}
