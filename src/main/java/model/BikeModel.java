package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BikeModel {

    @Builder.Default
    public static String bikeName = "City bike";
    @Builder.Default
    public static String model = "slr03";
    @Builder.Default
    public static String cost = "1,250.00";
    @Builder.Default
    public static String datePurchased = "5/5/2021";
    @Builder.Default
    public static String startingDistance = "200.00";
    @Builder.Default
    public static String notes = "Lack of rearview mirror";
    @Builder.Default
    public static String brand = "BMC";
    @Builder.Default
    public static String distanceType = "km";
}
