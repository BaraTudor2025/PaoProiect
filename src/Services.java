import Models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Services {

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

    public static void totalMoneySpendInCategoryOfItems(Category category){
        if(category.getItems() != null){
            var total = category.getItems().stream().map(Item::getBuyingPrice).reduce(0, Integer::sum);
            System.out.println("money spent in the category " + category.getName() + " is " + total);
        } else {
            System.out.println("no items sold under " + category.getName() + " category");
        }
    }

    public static void averageMoneySpendInCategoryOfItems(Category category){
        if(category.getItems() != null){
            float total = category.getItems().stream().map(Item::getBuyingPrice).reduce(0, Integer::sum);
            float average = total / category.getItems().size();
            System.out.println("people spend in averege " + average + " dollars in " + category.getName());
        } else {
            System.out.println("no items sold under " + category.getName() + " category");
        }
    }

    public static void showAuctionInfo(Auction auction){
        System.out.println(auction);
    }

    public static void showBiddingAntiqueItemsAges(Map<ItemCategory, Category> categories){
        var category = categories.get(ItemCategory.Antique);
        for(var item : category.getItems()){
            if(item.getBuyer() == null)
                System.out.println("Antique item " + item.getName() + " has " + ((AntiqueItem)item).getAge() + " years");
        }
    }

    public static void showBiddingCompaniesStocks(Map<ItemCategory, Category> categories){
        var category = categories.get(ItemCategory.Company);
        for(var item : category.getItems()){
            if(item.getBuyer() == null)
                System.out.println("Company " + item.getName() + " sold " + ((CompanyItem)item).getStockAmount() + " stocks");
        }
    }

    public static void showBiddingArtPieces(Map<ItemCategory, Category> categories){
        var category = categories.get(ItemCategory.Art);
        for(var item : category.getItems()){
            if(item.getBuyer() == null){
                ArtItem artItem = (ArtItem)item;
                System.out.println(artItem.getType() + " by " + artItem.getAuthor()+ " sold with " + artItem.getBuyingPrice());
            }
        }
    }

}
