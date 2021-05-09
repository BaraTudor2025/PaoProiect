import Models.*;

import java.io.IOException;
import java.util.*;

public class Main {

    static final private TreeMap<ItemCategory, Category> categories = new TreeMap<>();

    public static void main(String[] args) {
        boolean quit = false;
        TreeMap<ItemCategory, Category> categories = FileManager.readCategories();

        while(!quit) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("""
                        1 Cat a cheltuit un User in total la licitatii
                        2 Cat a castigat un User in total la licitatii
                        3 Vezi numarul de obiecte cumparate de catre un User pe categorii
                        4 Cati bani au fost cheltuiti in total intr-o categorie de iteme
                        5 Cati bani au fost cheltuiti in medie intr-o categorie de iteme
                        6 Informatii despre o licitatie
                        7 Vezi lista cu Iteme Antique in licitatie si cat de vechi sunt
                        8 Vezi lista cu Stock-uri in licitatie
                        9 Vezi lista cu Arta in licitatie
                        10 Vezi castigatorul la o licitatie
                        11 Quit""");
                // TODO: 11 Adauga castigator pentru o licitatie (pentru CRUD + altele)
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        // dummy values, pun valori reale cand deserializez datele din fisiere CVS
                        Services.totalMoneySpendByUser(new User());
                        FileManager.writeActionLog("show-totalMoneySpendByUser");
                        break;
                    case 2:
                        Services.totalMoneyEarnedByUser(new User());
                        FileManager.writeActionLog("show-totalMoneyEarnedByUser");
                        break;
                    case 3:
                        Services.showWhatItemsUserBought(new User());
                        FileManager.writeActionLog("show-whatItemsUserBought");
                        break;
                    case 4:
                        Services.totalMoneySpendInCategoryOfItems(new Category("Arta", ItemCategory.Art));
                        FileManager.writeActionLog("show-totalMoneySpendInCategoryOfItems");
                        break;
                    case 5:
                        Services.averageMoneySpendInCategoryOfItems(new Category("Antique", ItemCategory.Antique));
                        FileManager.writeActionLog("show-averageMoneySpendInCategoryOfItems");
                        break;
                    case 6:
                        Services.showAuctionInfo(new Auction());
                        FileManager.writeActionLog("show-auctionInfo");
                        break;
                    case 7: {
                        //var categories = new TreeMap<ItemCategory, Category>();
                        var category = new Category("stocks", ItemCategory.Company);
                        category.setItems(new ArrayList<>(Arrays.asList(new CompanyItem(new User(), "GME", "nush", 200, 4000))));
                        categories.put(ItemCategory.Company, category);
                        Services.showBiddingAntiqueItemsAges(categories);
                        FileManager.writeActionLog("show-biddingAntiqueItemsAges");
                        break;
                    }
                    case 8:
                        Services.showBiddingCompaniesStocks(new TreeMap<ItemCategory, Category>());
                        FileManager.writeActionLog("show-biddingCompaniesStocks");
                        break;
                    case 9:
                        Services.showBiddingArtPieces(new TreeMap<ItemCategory, Category>());
                        FileManager.writeActionLog("show-biddingArtPieces");
                        break;
                    case 10:
                        System.out.println(new Auction().getItemSold().getBuyer());
                        FileManager.writeActionLog("show-buyerInAuction");
                        break;
                    case 11:
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
