package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import static pages.BasePage.*;

@Data
@Builder
@AllArgsConstructor
public class UploadWorkoutDataModel {

    @Builder.Default
    public static String workoutDateAdd = MONTH_PATTERN + "/" + DAY_PATTERN + "/" + YEAR_PATTERN;
    @Builder.Default
    public static String name = "Bike";
    @Builder.Default
    public static String description = "Walking bike";
    @Builder.Default
    public static String activityType = "Bike";
}
