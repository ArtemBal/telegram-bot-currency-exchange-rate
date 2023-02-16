package artem.balan.telegrambotcurrencyexchangerate.model;

import lombok.Data;

import java.util.Date;

@Data
public class CurrencyModel {
    Date StartDate;
    int TimeSign;
    int CurrencyCode;
    String CurrencyCodeL;
    int Units;
    double Amount;
}
