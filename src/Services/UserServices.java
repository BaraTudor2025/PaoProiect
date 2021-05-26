package Services;

import Models.Item;
import Models.User;

public class UserServices {
    public static void printUsers(){
        for(var user : UserRepository.getRepo().readUsers()){
            System.out.println(user.getName());
        }
    }

    public static void totalMoneySpendByUser(User user){
        if(user.getItemsBought() != null){
            var total = user.getItemsBought().stream().map(Item::getBuyingPrice).reduce(0, Integer::sum);
            System.out.println("user " + user.getName() + " spent in total: " + total);
        } else {
            System.out.println("user " + user.getName() + " nu a cumparat nimic");
        }
    }

    public static void totalMoneyEarnedByUser(User user){
        if(user.getItemsSold() != null){
            var total = user.getItemsSold().stream().map(Item::getBuyingPrice).reduce(0, Integer::sum);
            System.out.println("user " + user.getName() + "  a castigat: " + total);
        } else {
            System.out.println("user " + user.getName() + " nu a pus la licitatie nimic");
        }
    }

    public static void showWhatItemsUserBought(User user){
        int art = 0, company = 0, antique = 0;
        for(var item : user.getItemsBought()){
            switch (item.getCategory()) {
                case Antique -> antique += 1;
                case Art -> art += 1;
                case Company -> company += 1;
            }
        }
        System.out.println("User " + user.getName() +  " bought " + art + " pieces of art, "
                + antique + " antique items, " + company + " company stocks");
    }

}
