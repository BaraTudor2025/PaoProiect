import java.util.ArrayList;

public class Category {
    private String name;
    private ItemType type;
    private ArrayList<Item> items;

    public Category(String name, ItemType type, ArrayList<Item> items) {
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

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
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