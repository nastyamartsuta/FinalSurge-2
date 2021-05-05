package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HansonsModel {

        //input
        private String TimeHours;
        private String TimeMinutes;
        private String TimeSeconds;
        private String Temperature;
        private String WindSpeed;
        private String Humidity;

        //dropdown
        private String RaceDistance;
        private String TemperatureType;
        private String SpeedType;

}
