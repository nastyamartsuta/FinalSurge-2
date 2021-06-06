package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CaloricNeedsModel {

    @Builder.Default
    public static String weight = "60";
    @Builder.Default
    public static String height = "180";
    @Builder.Default
    public static String age = "25";
    @Builder.Default
    public static String runDistance = "5";
}
