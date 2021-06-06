package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ActivityTypeModel {

    @Builder.Default
    public static String aTypeName = "Yoga";
}
