package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class VitalsModel {

    @Builder.Default
    public static String vitalsDate = "5/30/2021";
    @Builder.Default
    public static String steps = "8000";
    @Builder.Default
    public static String caloriesConsumed = "1500";
    @Builder.Default
    public static String weight = "70";
    @Builder.Default
    public static String bodyFat = "18.5";
    @Builder.Default
    public static String water = "10";
    @Builder.Default
    public static String muscleMass = "27";
    @Builder.Default
    public static String resting = "80";
    @Builder.Default
    public static String variability = "80";
    @Builder.Default
    public static String sleepHours = "8";
    @Builder.Default
    public static String totalTimeAwake = "16";
    @Builder.Default
    public static String systolic = "120";
    @Builder.Default
    public static String diastolic = "80";
    @Builder.Default
    public static String healthNotes = "The body is healthy";
    @Builder.Default
    public static String weightType = "kg";
    @Builder.Default
    public static String muscleMassType = "kg";
    @Builder.Default
    public static String sleepAmount = "Enough";
    @Builder.Default
    public static String sleepQuality = "Good";
    @Builder.Default
    public static String stressAmount = "Moderate";
}
