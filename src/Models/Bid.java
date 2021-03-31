package Models;

public class Bid {
    private int amount;

    public Bid(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Models.Bid{" +
                "amount=" + amount +
                '}';
    }
}
