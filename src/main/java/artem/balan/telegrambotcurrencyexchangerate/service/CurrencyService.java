package artem.balan.telegrambotcurrencyexchangerate.service;

import artem.balan.telegrambotcurrencyexchangerate.model.CurrencyModelOne;
import artem.balan.telegrambotcurrencyexchangerate.model.CurrencyModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class CurrencyService {
    public static String getCurrencyRates() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<CurrencyModel> list = objectMapper.readValue(new URL("https://bank.gov.ua/NBU_Exchange/exchange?json"),
                new TypeReference<>() {});
        return list.toString();
    }


    public static String getOneCurrencyRate(String currency) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<CurrencyModelOne> currencyModelOne = objectMapper.readValue(new URL("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchangenew?valcode="
                        + currency + "&json"),  new TypeReference<>() {});

        return "Official rate of UAH to " + currencyModelOne.get(0).getCc() + "\n" +
                "on the date: " + currencyModelOne.get(0).getExchangeDate() + "\n" +
                "is: 1 UAH per " + currencyModelOne.get(0).getRate() + " " + currencyModelOne.get(0).getCc();
    }
}
