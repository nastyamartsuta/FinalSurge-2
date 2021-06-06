package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RoutesModel {

    @Builder.Default
    public static String routeName = "Green Velo";
    @Builder.Default
    public static String distance = "200.00";
    @Builder.Default
    public static String routePersonalRecord = "8:55:10";
    @Builder.Default
    public static String personalRecordDate = "6/6/2021";
    @Builder.Default
    public static String notes = "Very beautiful route";
    @Builder.Default
    public static String activity = "Bike";
    @Builder.Default
    public static String distanceType = "km";
}
