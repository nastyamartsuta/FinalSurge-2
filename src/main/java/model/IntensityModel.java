package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class IntensityModel {

    @Builder.Default
    public static String timeHours = "1";
    @Builder.Default
    public static String timeMinutes = "30";
    @Builder.Default
    public static String timeSeconds = "00";
}
