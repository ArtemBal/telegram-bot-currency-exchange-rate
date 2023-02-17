package artem.balan.telegrambotcurrencyexchangerate.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
public class AbbreviationModel {
    private String abbreviation;
    private String fullCurrencyName;
}
