package artem.balan.telegrambotcurrencyexchangerate.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
public class CurrencyModel {
    private String startDate;
    private String timeSign;
    private String currencyCode;
    private String currencyCodeL;
    private int units;
    private double amount;
}
