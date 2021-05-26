package Models;

import java.util.ArrayList;

public class Category {
    private ItemCategory type;
    private ArrayList<Item> items;

    public Category(ItemCategory type) {
        this.type = type;
        this.items = new ArrayList<>();
    }

    public Category(ItemCategory type, ArrayList<Item> items) {
        this.type = type;
        this.items = items;
    }

    public ItemCategory getType() {
        return type;
    }

    public void setType(ItemCategory type) {
        this.type = type;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Category{" +
                ", type=" + type +
                ", items=" + items +
                '}';
    }
}