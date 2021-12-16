package by.bsu.testing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourSearchData {
    private String destinationCountry;
    private String destinationCity;
    private String departureCity;
    private String price;
}
