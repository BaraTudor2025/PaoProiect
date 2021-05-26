package Services;

import Models.Category;
import Models.Item;

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

}
