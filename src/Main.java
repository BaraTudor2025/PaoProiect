import Models.*;
import Services.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean quit = false;
        UserRepository userRepo = UserRepository.getRepo();
        ItemRepository itemRepo = ItemRepository.getRepo();
        var categories = itemRepo.getItems();

        while(!quit) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("""
                        (Scrie datele dupa optiune)
                        1 Adauga un user 
                        2 Vezi utilizatorii inregistrati
                        3 Adauga un item pentru a-l licita
                        4 Vezi itemele listate pentru licitatie
                        5 Castiga o licitatie
                        6 Cat a cheltuit un User in total la licitatii
                        7 Cat a castigat un User in total la licitatii
                        8 Vezi numarul de obiecte cumparate de catre un User pe categorii
                        9 Cati bani au fost cheltuiti in total intr-o categorie de iteme
                        10 Cati bani au fost cheltuiti in medie intr-o categorie de iteme
                        11 Informatii despre o licitatie
                        12 Vezi lista cu Iteme Antique in licitatie si cat de vechi sunt
                        13 Vezi lista cu Stock-uri in licitatie
                        14 Vezi lista cu Arta in licitatie
                        15 Vezi castigatorul la o licitatie
                        -1 Quit""");
                int option = scanner.nextInt();
                switch (option) {
                    case 1:{
                        String name = scanner.nextLine();
                        userRepo.insertUser(new User(0, name));
                        break;
                    }
                    case 2:{
                        UserServices.printUsers();
                        break;
                    }
                    case 3:{
                        break;
                    }
                    case 4: {

                    }
                    case 5:{
                        break;
                    }
                    case 6:
                        UserServices.totalMoneySpendByUser(new User());
                        FileManager.writeActionLog("show-totalMoneySpendByUser");
                        break;
                    case 7:
                        UserServices.totalMoneyEarnedByUser(new User());
                        FileManager.writeActionLog("show-totalMoneyEarnedByUser");
                        break;
                    case 8:
                        UserServices.showWhatItemsUserBought(new User());
                        FileManager.writeActionLog("show-whatItemsUserBought");
                        break;
                    case 9:
                        ItemServices.totalMoneySpendInCategoryOfItems(new Category(ItemCategory.Art));
                        FileManager.writeActionLog("show-totalMoneySpendInCategoryOfItems");
                        break;
                    case 10:
                        ItemServices.averageMoneySpendInCategoryOfItems(new Category(ItemCategory.Antique));
                        FileManager.writeActionLog("show-averageMoneySpendInCategoryOfItems");
                        break;
                    case 11:
                        Services.showAuctionInfo(new Auction());
                        FileManager.writeActionLog("show-auctionInfo");
                        break;
                    case 12: {
                        //var categories = new TreeMap<ItemCategory, Category>();
                        var category = new Category(ItemCategory.Company);
                        category.setItems(new ArrayList<>(Arrays.asList(new CompanyItem(0, new User(), "GME", "nush", 200, 4000))));
                        categories.put(ItemCategory.Company, category);
                        Services.showBiddingAntiqueItemsAges(categories);
                        FileManager.writeActionLog("show-biddingAntiqueItemsAges");
                        break;
                    }
                    case 13:
                        Services.showBiddingCompaniesStocks(new TreeMap<ItemCategory, Category>());
                        FileManager.writeActionLog("show-biddingCompaniesStocks");
                        break;
                    case 14:
                        Services.showBiddingArtPieces(new TreeMap<ItemCategory, Category>());
                        FileManager.writeActionLog("show-biddingArtPieces");
                        break;
                    case 15:
                        System.out.println(new Auction().getItemSold().getBuyer());
                        FileManager.writeActionLog("show-buyerInAuction");
                        break;
                    case -1:
                        quit = true;
                        break;
                    default:
                        System.out.println("option not avalilable");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.toString());
                quit = true;
            }
        }
    }
}
