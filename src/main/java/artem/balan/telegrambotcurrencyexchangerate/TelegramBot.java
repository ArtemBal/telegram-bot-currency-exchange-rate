package artem.balan.telegrambotcurrencyexchangerate;

import artem.balan.telegrambotcurrencyexchangerate.config.BotConfig;
import artem.balan.telegrambotcurrencyexchangerate.model.CurrencyModelOne;
import artem.balan.telegrambotcurrencyexchangerate.service.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

@Component
@AllArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {
    private final BotConfig botConfig;

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {

        CurrencyModelOne currencyModel = new CurrencyModelOne();
        String currency = "";

        if(update.hasMessage() && update.getMessage().hasText()){
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            switch (messageText) {
                case "/start" -> startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                default -> {
                    try {
                        currency = CurrencyService.getOneCurrencyRate(messageText, currencyModel);

                    } catch (IOException | IndexOutOfBoundsException e) {
                        sendMessage(chatId, """
                                We have not found such a currency.
                                Enter the currency whose official exchange rate
                                you want to know in relation to UAH.
                                For example: USD""");
                    }
                    sendMessage(chatId, currency);
                }
            }
        }
    }

    private void startCommandReceived(Long chatId, String name) {
        String answer = "Hi, " + name + ", nice to meet you!" + "\n" +
                "Enter the currency whose official exchange rate" + "\n" +
                "you want to know in relation to UAH." + "\n" +
                "For example: USD";
        sendMessage(chatId, answer);
    }

    private void sendMessage(Long chatId, String textToSend){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(textToSend);
        try {
            execute(sendMessage);
        } catch (TelegramApiException ignored) {

        }
    }

}
