package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ReportsModel {

    @Builder.Default
    public static String startDate = "01/01/2021";
    @Builder.Default
    public static String endDate = "12/12/2021";
    @Builder.Default
    public static String activityType = "Run";
}
