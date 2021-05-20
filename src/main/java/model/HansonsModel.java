package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HansonsModel {

        private String TimeHours;
        private String TimeMinutes;
        private String TimeSeconds;
        private String Temperature;
        private String WindSpeed;
        private String Humidity;
        private String RaceDistance;
        private String TemperatureType;
        private String SpeedType;
}
