import Models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Services {



    public static void showAuctionInfo(Auction auction){
        System.out.println(auction);
    }

    public static void showBiddingAntiqueItemsAges(Map<ItemCategory, Category> categories){
        var category = categories.get(ItemCategory.Antique);
        for(var item : category.getItems()){
            if(item.getBuyer() == null){
                System.out.println("Antique item " + item.getName() + " has " + ((AntiqueItem)item).getAge() + " years");
            }
        }
    }

    public static void showBiddingCompaniesStocks(Map<ItemCategory, Category> categories){
        var category = categories.get(ItemCategory.Company);
        for(var item : category.getItems()){
            if(item.getBuyer() == null){
                System.out.println("Company " + item.getName() + " sold " + ((CompanyItem)item).getStockAmount() + " stocks");
            }
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
