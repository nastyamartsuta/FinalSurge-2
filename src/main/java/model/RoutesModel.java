package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoutesModel {

    private String RouteName;
    private String Distance;
    private String RoutePersonalRecord;
    private String PersonalRecordDate;
    private String Notes;
    private String Activity;
    private String DistanceType;
}
