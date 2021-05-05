package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaceCalculatorModel {

    //input
    private String TimeHours;
    private String TimeMinutes;
    private String TimeSeconds;
    private String Distance;

    //dropdown
    private String DistType;

}
