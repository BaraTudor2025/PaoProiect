package Models;

public abstract class Item {
    protected User buyer;
    protected User seller;
    protected String name;
    protected String description;
    protected int startingPrice;
    protected int buyingPrice;
    protected ItemCategory category;

    public Item(){ }

    public Item(User seller, String name, String description, int startingPrice) {
        this.seller = seller;
        this.name = name;
        this.description = description;
        this.startingPrice = startingPrice;
        this.buyer = null;
        this.buyingPrice = 0;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(int startingPrice) {
        this.startingPrice = startingPrice;
    }

    public int getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(int buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "buyer=" + (buyer != null ? buyer : "not sold yet") +
                ", seller=" + seller +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startingPrice=" + startingPrice +
                ", buyingPrice=" + buyingPrice +
                '}';
    }
}
