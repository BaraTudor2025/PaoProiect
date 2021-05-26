package Models;

import java.util.ArrayList;

/* campurile itemsBought si itemsSold sunt generate din toate itemele */
public class User {
    private int id;
    private String name;
    private ArrayList<Item> itemsBought;
    private ArrayList<Item> itemsSold;

    public User(){ }

    public User(int id, String name){
        this.id = id;
        this.name = name;
        this.itemsBought = new ArrayList<>();
        this.itemsSold = new ArrayList<>();
    }

    public User(int id, String name, ArrayList<Item> itemsBought, ArrayList<Item> itemsSold) {
        this.id = id;
        this.name = name;
        this.itemsBought = itemsBought;
        this.itemsSold = itemsSold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Item> getItemsBought() {
        return itemsBought;
    }

    public void setItemsBought(ArrayList<Item> itemsBought) {
        this.itemsBought = itemsBought;
    }

    public ArrayList<Item> getItemsSold() {
        return itemsSold;
    }

    public void setItemsSold(ArrayList<Item> itemsSold) {
        this.itemsSold = itemsSold;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", itemsBought=" + itemsBought +
                ", itemsSold=" + itemsSold +
                '}';
    }


}