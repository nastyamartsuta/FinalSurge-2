package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IntensityModel {

    //input
    private String TimeHours;
    private String TimeMinutes;
    private String TimeSeconds;

    //radiobutton
    private String EventType;

}
