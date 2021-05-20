package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CaloricNeedsModel {

    private String Weight;
    private String Height;
    private String Age;
    private String RunDistance;
    private String WeightType;
    private String HeightType;
    private String Gender;
    private String DistanceType;
}
