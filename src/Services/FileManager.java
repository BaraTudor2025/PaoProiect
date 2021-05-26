package Services;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;
import java.util.function.*;

import Models.*;

@FunctionalInterface
interface ThrowingConsumer<T> extends Consumer<T> {

    @Override
    default void accept(final T elem) {
        try {
            acceptThrows(elem);
        } catch (IOException e) {
            //System.out.println("");
            throw new RuntimeException(e);
        }
    }

    void acceptThrows(T elem) throws IOException;
}

/****** serviciu CSV nefolosit *******/
public class FileManager {

    static void readCSV(String filePath, Consumer<String[]> proc)
    {
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(filePath));
            String row = csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                proc.accept(data);
            }
            csvReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void writeTo(String filePath, ThrowingConsumer<FileWriter> write)
    {
        try {
            var file = new FileWriter(filePath);
            write.acceptThrows(file);
            file.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeActionLog(String message)
    {
        writeTo("./action-log.txt", file -> {
            file.append(message);
            file.append(",");
            file.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            file.append("\n");
        });
    }

    public static ArrayList<User> readUsers()
    {
        var list = new ArrayList<User>();
        readCSV("./users.txt", line -> list.add(new User(0, line[0])));
        return list;
    }

    public static void writeUsers(ArrayList<User> users)
    {
        writeTo("./users.txt", file -> {
            file.write("Name\n");
            for(var user : users){
                file.write(user.getName());
                file.write("\n");
            }
        });
    }

    public static ArrayList<Item> readItems()
    {
        var list = new ArrayList<Item>();
        var users = readUsers();
//        Consumer<String[], Consumer<Item>> readItem = (line, item, ) -> {
//        };

        readCSV("./items.txt", line -> {
            ItemCategory cat = ItemCategory.valueOf(line[0]);
            Item item = switch (cat){
                case Art -> new ArtItem();
                case Antique -> new AntiqueItem();
                case Company -> new CompanyItem();
            };
            item.setCategory(cat);
            item.setName(line[1]);
            item.setDescription(line[2]);
            item.setStartingPrice(Integer.parseInt(line[3]));
            item.setBuyingPrice(Integer.parseInt(line[4]));
            item.setSeller(users.stream().filter(u -> u.getName().equals(line[5])).findFirst().orElse(null));
            item.getSeller().getItemsSold().add(item);
            if(cat == ItemCategory.Antique) {
                ((AntiqueItem)item).setAge(Integer.parseInt(line[6]));
            }
            else if(cat == ItemCategory.Art){
                ((ArtItem)item).setAuthor(line[6]);
            }
            else{
                ((CompanyItem)item).setStockAmount(Integer.parseInt(line[6]));
            }
            if(item.getBuyingPrice() != 0){
                item.setBuyer(users.stream().filter(u -> u.getName().equals(line[7])).findFirst().orElse(null));
                item.getBuyer().getItemsBought().add(item);
            }
            list.add(item);
        });
        return list;
    }

    // se citesc si prelucreaza clasele Category, Item cu derivatele ei, si User
    public static TreeMap<ItemCategory, Category> readCategories()
    {
        var cats = new TreeMap<ItemCategory, Category>();
        readCSV("./categories.txt", line -> {
            var cat = ItemCategory.valueOf(line[0]);
            cats.put(cat, new Category(cat, new ArrayList<Item>()));
        });
        var items = readItems();
        for(var item : items){
            cats.get(item.getCategory()).getItems().add(item);
        }
        return cats;
    }

    public static void writeItems(TreeMap<ItemCategory, Category> categories)
    {
        writeTo("./items.txt", file -> {
            file.write("Category,Name,Description,StartingPrice,BuyingPrice,Seller,SpecifficValue,Buyer");
            for(var category : categories.values()) {
                for(var item : category.getItems()) {
                    file.write(item.getCategory().name());
                    file.write(',');
                    file.write(item.getName());
                    file.write(',');
                    file.write(item.getDescription());
                    file.write(',');
                    file.write(item.getStartingPrice());
                    file.write(',');
                    file.write(item.getBuyingPrice());
                    file.write(',');
                    file.write(item.getSeller().getName());
                    file.write(',');

                    if(item.getCategory() == ItemCategory.Antique){
                        file.write(((AntiqueItem)item).getAge());
                    }
                    else if(item.getCategory() == ItemCategory.Art){
                        file.write(((ArtItem)item).getAuthor());
                    }
                    else{
                        file.write(((CompanyItem)item).getStockAmount());
                    }
                    file.write(',');
                    if(item.getBuyingPrice() != 0){
                        file.write(item.getBuyer().getName());
                    }
                    file.write('\n');
                }
            }
        });
    }
}
