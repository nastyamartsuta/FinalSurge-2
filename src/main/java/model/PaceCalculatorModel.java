package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PaceCalculatorModel {

    @Builder.Default
    public static String timeHours = "01";
    @Builder.Default
    public static String timeMinutes = "15";
    @Builder.Default
    public static String timeSeconds = "20";
    @Builder.Default
    public static String distance = "5";
    @Builder.Default
    public static String distType = "km";
}
