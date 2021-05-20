package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaceCalculatorModel {

    private String TimeHours;
    private String TimeMinutes;
    private String TimeSeconds;
    private String Distance;
    private String DistType;
}
