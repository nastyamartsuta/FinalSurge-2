package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReportsModel {

    //input
    private String StartDate;
    private String EndDate;

    //dropdown
    private Integer ActivityType;

    //radiobutton
    private String ReportView;

}
