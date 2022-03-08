package Common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Charger {

    private String serialNumber;
    private String model;

    public static Charger newCharger(String chargerModel) {
        return Charger.builder()
                .serialNumber("12345")
                .model(chargerModel)
                .build();
    }

}
