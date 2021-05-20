package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BikeModel {

    private String BikeName;
    private String Model;
    private String Cost;
    private String DatePurchased;
    private String StartingDistance;
    private String Notes;
    private String Brand;
    private String DistanceType;
}
