package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class WorkoutQuickModel {

    @Builder.Default
    public static String name = "Run/swim";
    @Builder.Default
    public static String workoutDate = "5/30/2021";
    @Builder.Default
    public static String distance = "5";
    @Builder.Default
    public static String duration = "0:50";
    @Builder.Default
    public static String pace = "12000";
    @Builder.Default
    public static String workoutDescription = "Warm-up, run, stretching";
    @Builder.Default
    public static String results = "Check pulse and blood pressure";
    @Builder.Default
    public static String distanceType = "km";
    @Builder.Default
    public static String paceType = "km";
    @Builder.Default
    public static String howFeel = "2";
    @Builder.Default
    public static String perceivedEffort = "3";
    @Builder.Default
    public static String activityType = "Run";
    @Builder.Default
    public static String timeOfDay = "12:45 AM";
}
