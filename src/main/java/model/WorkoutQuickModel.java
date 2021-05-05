package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WorkoutQuickModel {

    //input
    private String Name;
    private String WorkoutDate;
    private String Distance;
    private String Duration;
    private String Pace;

    //textarea
    private String WorkoutDescription;
    private String Results;

    //dropdown
    private String DistanceType;
    private String PaceType;
    private String HowFeel;
    private String PerceivedEffort;
    private String ActivityType;

    //autocomplete
    private String TimeOfDay;

}
