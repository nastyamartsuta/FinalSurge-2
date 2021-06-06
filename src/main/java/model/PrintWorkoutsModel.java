package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PrintWorkoutsModel {

    @Builder.Default
    public static String printStartingDate = "1/1/2021";
    @Builder.Default
    public static String printEndingDate = "12/12/2021";
}
