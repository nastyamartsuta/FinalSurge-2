package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShoesModel {

    private String ShoesName;
    private String Model;
    private String Cost;
    private String DatePurchased;
    private String StartingDistance;
    private String DistanceAlert;
    private String Notes;
    private String ShoeSize;
    private String DistanceType;
    private String DistanceAlertType;
    private String Brand;
}
