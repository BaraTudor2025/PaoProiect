import Models.Bid;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("1 Cat a cheltuit un User in total la licitatii\n" +
                    "2 Cat a castigat un User in total la licitatii \n" +
                    "3 Vezi numarul de obiecte cumparate de catre un User pe categorii\n" +
                    "4 Cati bani au fost cheltuiti in total intr-o categorie de iteme\n" +
                    "5 Cati bani au fost cheltuiti in medie intr-o categorie de iteme\n" +
                    "6 Informatii despre o licitatie\n" +
                    "7 Vezi lista cu Iteme Antique in licitatie si cat de vechi sunt\n" +
                    "8 Vezi lista cu Stock-uri in licitatie\n" +
                    "9 Vezi lista cu Arta in licitatie ");
            int option = scanner.nextInt();
            switch(option){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                default:
                    System.out.println("option not avalilable");
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
