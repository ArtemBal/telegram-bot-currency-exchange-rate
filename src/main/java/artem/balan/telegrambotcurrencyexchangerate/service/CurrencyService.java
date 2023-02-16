package artem.balan.telegrambotcurrencyexchangerate.service;

import artem.balan.telegrambotcurrencyexchangerate.model.CurrencyModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class CurrencyService {
    public static String getCurrencyRate() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ArrayList<CurrencyModel> list = objectMapper.readValue(new URL("https://bank.gov.ua/NBU_Exchange/exchange?json"),
                new TypeReference<ArrayList<CurrencyModel>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });
        return list.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getCurrencyRate());
    }
}
