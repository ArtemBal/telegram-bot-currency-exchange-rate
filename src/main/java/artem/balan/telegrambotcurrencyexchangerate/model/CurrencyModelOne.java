package artem.balan.telegrambotcurrencyexchangerate.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
public class CurrencyModelOne {
    private int r030;
    private String txt;
    private double rate;
    private String cc;
    private String exchangeDate;
}
