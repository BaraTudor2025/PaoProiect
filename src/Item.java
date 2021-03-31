
public abstract class Item {
    protected User buyer;
    protected User seller;
    protected String name;
    protected String description;
    protected int startingPrice;

    public Item(User buyer, User seller, String name, String description, int startingPrice) {
        this.buyer = buyer;
        this.seller = seller;
        this.name = name;
        this.description = description;
        this.startingPrice = startingPrice;
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

    @Override
    public String toString() {
        return "Item{" +
                "buyer=" + buyer +
                ", seller=" + seller +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startingPrice=" + startingPrice +
                '}';
    }
}
