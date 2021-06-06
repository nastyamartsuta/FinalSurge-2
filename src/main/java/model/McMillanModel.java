package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class McMillanModel {

    @Builder.Default
    public static String recentTimeHours = "1";
    @Builder.Default
    public static String recentTimeMinutes = "20";
    @Builder.Default
    public static String recentTimeSeconds = "30";
    @Builder.Default
    public static String goalTimeHours = "1";
    @Builder.Default
    public static String goalTimeMinutes = "05";
    @Builder.Default
    public static String goalTimeSeconds = "10";
    @Builder.Default
    public static String recentDistanceType = "1500m";
    @Builder.Default
    public static String goalDistanceType = "1500m";
}
