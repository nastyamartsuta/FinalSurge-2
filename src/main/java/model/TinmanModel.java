package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TinmanModel {

    @Builder.Default
    public static String timeHours = "1";
    @Builder.Default
    public static String timeMinutes = "30";
    @Builder.Default
    public static String timeSeconds ="00";
    @Builder.Default
    public static String gender = "Female";
    @Builder.Default
    public static String raceDistance = "0.4";
}
