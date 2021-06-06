package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SwimWorkoutModel {

    @Builder.Default
    public static String date = "05/30/2021";
    @Builder.Default
    public static String workoutTime = "8:00 AM";
    @Builder.Default
    public static String workoutName = "Swim";
    @Builder.Default
    public static String distance = "100.00";
    @Builder.Default
    public static String duration = "40:05:30";
    @Builder.Default
    public static String pace = "24:03";
    @Builder.Default
    public static String caloriesBurned = "100";
    @Builder.Default
    public static String distanceType = "km";
    @Builder.Default
    public static String paceType = "min/km";
    @Builder.Default
    public static String perceivedEffort = "4 (Moderate)";
    @Builder.Default
    public static String workoutDescription = "Morning workout";
}
