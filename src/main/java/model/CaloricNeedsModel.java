package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CaloricNeedsModel {

    //input
    private String Weight;
    private String Height;
    private String Age;
    private String RunDistance;

    //radiobutton
    private String WeightType;
    private String HeightType;
    private String Gender;
    private String DistanceType;
}
