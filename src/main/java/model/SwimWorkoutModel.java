package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SwimWorkoutModel {

    private String Date;
    private String WorkoutTime;
    private String WorkoutName;
    private String Distance;
    private String Duration;
    private String Pace;
    private String CaloriesBurned;
    private String DistanceType;
    private String PaceType;
    private String PerceivedEffort;
    private String HowIFelt;
    private String WorkoutDescription;
}
