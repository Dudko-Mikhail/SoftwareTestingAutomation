package by.bsu.testing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourSearchData {
    private String countryTo;
    private String cityTo;
    private String cityFrom;
    private String moneyLimit;
}
