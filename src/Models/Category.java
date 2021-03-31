package Models;

import java.util.ArrayList;

public class Category {
    private String name;
    private ItemCategory type;
    private ArrayList<Item> items;

    public Category(String name, ItemCategory type, ArrayList<Item> items) {
        this.name = name;
        this.type = type;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "name='" + name + '\'' +
                ", type=" + type +
                ", items=" + items +
                '}';
    }
}