
/* actions:
 * 1. max bid from an auction(winning bid)
 * 2. max winning bid from all time
 * 3. max winning bid from buyer
 * 4. max bid that a seller got
 * 5. total money spend by a buyer
 * 6. total mosey earned by a seller
 * 7. average/max bid from a category
 * 8. profile of a user(history of events that he participated)
 * 9. total money spend by a buyer
 * 10.user buys item through high bid
 * 11.Auction.java for product:
 * - Select product
 * - user places bid
 * - user with highest bid wins(after special command)
 * - user now has bought item
 */

import java.util.stream.Stream;

public class Services {
    public static void totalMoneySpendByUser(User user){
        var total = user.getItemsBought().stream().map(Item::getStartingPrice).reduce(0, Integer::sum);
        System.out.println("user " + user.getName() + " spent in total: " + total);
    }
    public static void totalMoneySpendInCategoryOfItems(Category category){
        var total = category.getItems().stream().map(Item::getStartingPrice).reduce(0, Integer::sum);
        System.out.println("money spent in the category " + category.getName() + " is " + total);
    }
    public static void averageMoneySpendInCategoryOfItems(Category category){
        var total = category.getItems().stream().map(Item::getStartingPrice).reduce(0, Integer::sum);
        System.out.println("people spend in averege " + total + " dollars in " + category.getName());
    }
}
