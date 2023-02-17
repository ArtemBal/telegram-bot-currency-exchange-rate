package artem.balan.telegrambotcurrencyexchangerate.service;

import artem.balan.telegrambotcurrencyexchangerate.model.CurrencyModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class CurrencyService {
    public static String getCurrencyRate() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<CurrencyModel> list = objectMapper.readValue(new URL("https://bank.gov.ua/NBU_Exchange/exchange?json"),
                new TypeReference<>() {});
        return list.toString();
    }
}
