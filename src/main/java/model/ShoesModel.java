package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ShoesModel {

    @Builder.Default
    public static String shoesName = "Running shoes";
    @Builder.Default
    public static String model = "Performance";
    @Builder.Default
    public static String cost = "99.00";
    @Builder.Default
    public static String datePurchased = "5/5/2021";
    @Builder.Default
    public static String startingDistance = "5";
    @Builder.Default
    public static String distanceAlert = "15";
    @Builder.Default
    public static String notes = "Don't run when it's raining";
    @Builder.Default
    public static String shoeSize = "7.5";
    @Builder.Default
    public static String distanceType = "km";
    @Builder.Default
    public static String distanceAlertType = "km";
    @Builder.Default
    public static String brand = "adidas";
}
