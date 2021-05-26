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
            scanner.useDelimiter("\n");
            try {
                System.out.println("""
                        \n1 Adauga un user 
                        2 Vezi utilizatorii inregistrati
                        3 Listeaza un item
                        4 Vezi itemele listate pentru licitatie
                        5 Castiga o licitatie
                        6 Cat a cheltuit un User in total la licitatii
                        7 Cat a castigat un User in total la licitatii
                        8 Vezi numarul de obiecte cumparate de catre un User pe categorii
                        9 Cati bani au fost cheltuiti in total intr-o categorie de iteme
                        10 Cati bani au fost cheltuiti in medie intr-o categorie de iteme
                        11 Istoric tranzactii
                        -1 Quit""");
                int option = scanner.nextInt();
                switch (option) {
                    case 1:{
                        UserServices.addUser(scanner);
                        AuditService.writeActionLog("add-user");
                        break;
                    }
                    case 2:{
                        UserServices.printUsers();
                        AuditService.writeActionLog("show-users");
                        break;
                    }
                    case 3:{
                        ItemServices.addItem(scanner);
                        AuditService.writeActionLog("add-item");
                        break;
                    }
                    case 4: {
                        ItemServices.printItems(false);
                        AuditService.writeActionLog("show-items");
                        break;
                    }
                    case 5:{
                        ItemServices.winAuction(scanner);
                        AuditService.writeActionLog("win-auction");
                        break;
                    }
                    case 6:
                        for (var user : UserRepository.getRepo().getUsers()){
                            UserServices.totalMoneySpendByUser(user);
                        }
                        AuditService.writeActionLog("show-totalMoneySpendByUser");
                        break;
                    case 7:
                        for (var user : UserRepository.getRepo().getUsers()) {
                            UserServices.totalMoneyEarnedByUser(user);
                        }
                        AuditService.writeActionLog("show-totalMoneyEarnedByUser");
                        break;
                    case 8:
                        for (var user : UserRepository.getRepo().getUsers()) {
                            UserServices.showWhatItemsUserBought(user);
                        }
                        AuditService.writeActionLog("show-whatItemsUserBought");
                        break;
                    case 9:
                        for(var cat : ItemRepository.getRepo().getItems().values()){
                            ItemServices.totalMoneySpendInCategoryOfItems(cat);
                        }
                        AuditService.writeActionLog("show-totalMoneySpendInCategoryOfItems");
                        break;
                    case 10:
                        for(var cat : ItemRepository.getRepo().getItems().values()) {
                            ItemServices.averageMoneySpendInCategoryOfItems(cat);
                        }
                        AuditService.writeActionLog("show-averageMoneySpendInCategoryOfItems");
                        break;
                    case 11:
                        ItemServices.printItems(true);
                        AuditService.writeActionLog("show-auctionInfo");
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
            }
        }
        Database.closeConnection();
    }
}
