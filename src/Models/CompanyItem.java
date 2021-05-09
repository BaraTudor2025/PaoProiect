package Models;

public final class CompanyItem extends Item {
    private int stockAmount;

    public CompanyItem(){ }

    public CompanyItem(User seller, String name, String description, int startingPrice, int stockAmount) {
        super(seller, name, description, startingPrice);
        this.stockAmount = stockAmount;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    @Override
    public String toString() {
        return "CompanyItem{" +
                "stockAmount=" + stockAmount +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startingPrice=" + startingPrice +
                '}';
    }
}