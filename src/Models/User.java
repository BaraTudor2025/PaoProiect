package Models;

import Models.Item;

import java.util.ArrayList;


/* campurile itemsBought si itemsSold sunt generate din toate itemele */
public class User {
    private String name;
    private ArrayList<Item> itemsBought;
    private ArrayList<Item> itemsSold;

    public User(){ }

    public User(String name){
        this.name = name;
        this.itemsBought = null;
        this.itemsSold = null;
    }

    public User(String name, ArrayList<Item> itemsBought, ArrayList<Item> itemsSold) {
        this.name = name;
        this.itemsBought = itemsBought;
        this.itemsSold = itemsSold;
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