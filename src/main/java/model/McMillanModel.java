package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class McMillanModel {

    //input
    private String RecentTimeHours;
    private String RecentTimeMinutes;
    private String RecentTimeSeconds;

    private String GoalTimeHours;
    private String GoalTimeMinutes;
    private String GoalTimeSeconds;


    //dropdown
    private String RecentDistanceType;
    private String GoalDistanceType;

}
