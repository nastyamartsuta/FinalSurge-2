package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IntensityModel {

    private String TimeHours;
    private String TimeMinutes;
    private String TimeSeconds;
    private String EventType;
}
