package Services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Consumer;

public class AuditService {

    public static void writeActionLog(String message)
    {
        writeTo("./action-log.txt", file -> {
            file.append(message);
            file.append(",");
            file.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            file.append("\n");
        });
    }

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


}
