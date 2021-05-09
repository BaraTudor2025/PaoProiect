package Models;

public final class AntiqueItem extends Item {
    private int age; // in years

    public AntiqueItem() { }

    public AntiqueItem(User seller, String name, String description, int startingPrice, int age) {
        super(seller, name, description, startingPrice);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "AntiqueItem{" +
                "age=" + age +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startingPrice=" + startingPrice +
                '}';
    }
}