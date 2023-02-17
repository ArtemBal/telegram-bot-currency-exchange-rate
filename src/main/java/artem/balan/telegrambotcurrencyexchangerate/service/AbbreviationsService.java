package artem.balan.telegrambotcurrencyexchangerate.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AbbreviationsService {

    public static void getAbr() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, String> map = objectMapper.readValue(new URL("https://openexchangerates.org/api/currencies.json"),
                new TypeReference<>() {});

        File file = new File("src/main/resources/abbreviationsEnum.txt");
        try (FileWriter fileWriter = new FileWriter(file)) {
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Map.Entry<String, String> entry: map.entrySet()) {
                printWriter.println(entry.getKey().toUpperCase() + "(\"" + entry.getValue() + "\"),");
            }
            printWriter.close();
            System.out.println("Enum is ready at " + file.getAbsolutePath());
        }

    }

    public static void main(String[] args) throws IOException {
        getAbr();
    }
}
