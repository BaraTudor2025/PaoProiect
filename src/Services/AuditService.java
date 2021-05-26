package Services;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    static void writeTo(String filePath, ThrowingConsumer<FileWriter> write)
    {
        try {
            var file = new FileWriter(filePath, true);
            write.acceptThrows(file);
            file.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
