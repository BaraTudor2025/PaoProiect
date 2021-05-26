package Models;

public final class CompanyItem extends Item {
    private int stockAmount;

    public CompanyItem(){
        this.category = ItemCategory.Company;
    }

    public CompanyItem(int id, User seller, String name, String description, int startingPrice, int stockAmount) {
        super(id, seller, name, description, startingPrice);
        this.stockAmount = stockAmount;
        this.category = ItemCategory.Company;
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