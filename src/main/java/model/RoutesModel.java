package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoutesModel {

    //input
    private String RouteName;
    private String Distance;
    private String RoutePersonalRecord;
    private String PersonalRecordDate;
    private String Notes;

    //dropdown
    private String Activity;
    private String DistanceType;

}
