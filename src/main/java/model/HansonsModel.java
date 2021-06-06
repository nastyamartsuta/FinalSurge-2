package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class HansonsModel {

    @Builder.Default
    public static String timeHours = "5";
    @Builder.Default
    public static String timeMinutes = "30";
    @Builder.Default
    public static String timeSeconds = "00";
    @Builder.Default
    public static String temperature = "15";
    @Builder.Default
    public static String windSpeed = "10";
    @Builder.Default
    public static String humidity = "80";
    @Builder.Default
    public static String raceDistance = "Marathon";
    @Builder.Default
    public static String temperatureType = "°C";
    @Builder.Default
    public static String speedType = "mph";
}
