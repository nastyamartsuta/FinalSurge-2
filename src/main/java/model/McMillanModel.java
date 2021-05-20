package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class McMillanModel {

    private String RecentTimeHours;
    private String RecentTimeMinutes;
    private String RecentTimeSeconds;
    private String GoalTimeHours;
    private String GoalTimeMinutes;
    private String GoalTimeSeconds;
    private String RecentDistanceType;
    private String GoalDistanceType;
}
