package Services;

import Models.*;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class ItemServices {

    public static void addItem(Scanner scanner){
        try {
            System.out.println("Pick a category for the item (type the number): 1.Art 2.Company 3.Antique: ");
            int type = scanner.nextInt();
            Item item;
            switch (type){
                case 1 -> {
                    var aitem = new ArtItem();
                    System.out.print("Author:");
                    aitem.setAuthor(scanner.next());
                    System.out.print("Art Type(picture, painting, sculpture):");
                    aitem.setType(scanner.next());
                    //System.out.println(aitem.getAuthor() + aitem.getType());
                    item = aitem;
                }
                case 2 -> {
                    var citem = new CompanyItem();
                    System.out.print("Stock amount:");
                    citem.setStockAmount(scanner.nextInt());
                    item = citem;
                }
                case 3 -> {
                    var aitem = new AntiqueItem();
                    System.out.print("Age of object:");
                    aitem.setAge(scanner.nextInt());
                    item = aitem;
                }
                default -> throw new IOException("valoare invalida");
            }
            System.out.print("Name:");
            item.setName(scanner.next());
            System.out.print("Description:");
            item.setDescription(scanner.next());
            System.out.print("Starting price:");
            item.setStartingPrice(scanner.nextInt());
            while(true) {
                System.out.print("Seller name:");
                String name = scanner.next();
                var user = UserRepository.getRepo().findByName(name);
                if(user != null){
                    item.setSeller(user);
                    break;
                }
            }
            ItemRepository.getRepo().insertItem(item);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void printItems(boolean sold){
        for(var cat : ItemRepository.getRepo().getItems().values()){
            System.out.println("Category: " + cat.getType().name());
            for(var itm : cat.getItems()){
                if(!sold && itm.getBuyer() == null || sold && itm.getBuyer() != null){
                    System.out.print(" Name=" + itm.getName() + " StartPrice=" + itm.getStartingPrice()
                        + " Desc=" + itm.getDescription() + " Seller=" + itm.getSeller().getName());
                    if(sold){
                        System.out.print(" Sold/FinalPrice=" + itm.getBuyingPrice());
                    }
                    switch (itm.getCategory()){
                        case Antique -> {
                            var item = (AntiqueItem)itm;
                            System.out.println(" Age=" + item.getAge());
                        }
                        case Company -> {
                            var item = (CompanyItem)itm;
                            System.out.println(" Stock=" + item.getStockAmount());
                        }
                        case Art -> {
                            var item = (ArtItem)itm;
                            System.out.println(" Author=" + item.getAuthor() + " Type=" + item.getType());
                        }
                    }
                }
            }
        }
    }

    public static void winAuction(Scanner scanner){
        try{
            System.out.print("Buyer:");
            User user = UserRepository.getRepo().findByName(scanner.next());
            if(user == null){
                System.out.println("nume invalid");
                return;
            }
            System.out.print("Nume item: ");
            String itemName = scanner.next();
            int id = 0;
            for(var cat : ItemRepository.getRepo().getItems().values()){
                var opt = cat.getItems().stream().filter(item -> item.getName().equals(itemName)).findFirst();
                if(opt.isPresent())
                    id = opt.get().getId();
            }
            if(id == 0){
                System.out.print("Item not found");
                return;
            }

            System.out.print("Pret final:");
            int price = scanner.nextInt();
            ItemRepository.getRepo().updateItem(id, price, user.getId());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

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
        //System.out.println("Antique items: ");
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
