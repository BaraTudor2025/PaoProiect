package Models;

import java.util.ArrayList;
import java.util.Date;

public class Auction {
    private Category category;
    private Item itemSold;
    private ArrayList<Bid> bids;
    //private Bid winningBid;
    private Date date;

    public Auction(Category category, Item itemSold, Date date) {
        this.category = category;
        this.itemSold = itemSold;
        this.date = date;

    }

    Bid getWinningBid() {
        if (bids.isEmpty()) {
            return new Bid(0);
        }
        else {
            var optMax = bids.stream().map(Bid::getAmount).max(Integer::compare);
            return new Bid(optMax.orElse(0));
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Item getItemSold() {
        return itemSold;
    }

    public void setItemSold(Item itemSold) {
        this.itemSold = itemSold;
    }

    public ArrayList<Bid> getBids() {
        return bids;
    }

    public void setBids(ArrayList<Bid> bids) {
        this.bids = bids;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "category=" + category +
                ", itemSold=" + itemSold +
                ", bids=" + bids +
                ", date=" + date +
                '}';
    }
}