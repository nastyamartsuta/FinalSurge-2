package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SwimWorkoutModel {
    //input
    private String Date;
    private String WorkoutTime;
    private String WorkoutName;

    private String Distance;
    private String Duration;
    private String Pace;
    private String CaloriesBurned;

    //dropdown
    private String DistanceType;
    private String PaceType;
    private String PerceivedEffort;

    //radiobutton
    private String HowIFelt;

    //textarea
    private String WorkoutDescription;
}
