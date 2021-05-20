package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WorkoutQuickModel {

    private String Name;
    private String WorkoutDate;
    private String Distance;
    private String Duration;
    private String Pace;
    private String WorkoutDescription;
    private String Results;
    private String DistanceType;
    private String PaceType;
    private String HowFeel;
    private String PerceivedEffort;
    private String ActivityType;
    private String TimeOfDay;
}
