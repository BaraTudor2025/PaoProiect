package Services;

import Models.*;

import java.util.Map;

public class ItemServices {
    public static void totalMoneySpendInCategoryOfItems(Category category){
        if(category.getItems() != null){
            var total = category.getItems().stream().map(Item::getBuyingPrice).reduce(0, Integer::sum);
            System.out.println("money spent in the category " + category.getType().name() + " is " + total);
        } else {
            System.out.println("no items sold under " + category.getType().name() + " category");
        }
    }

    public static void averageMoneySpendInCategoryOfItems(Category category){
        if(category.getItems() != null){
            float total = category.getItems().stream().map(Item::getBuyingPrice).reduce(0, Integer::sum);
            float average = total / category.getItems().size();
            System.out.println("people spend in averege " + average + " dollars in " + category.getType().name());
        } else {
            System.out.println("no items sold under " + category.getType().name() + " category");
        }
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
