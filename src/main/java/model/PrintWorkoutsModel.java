package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PrintWorkoutsModel {
    //input
    private String PrintStartingDate;
    private String PrintEndingDate;
}
