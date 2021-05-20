package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReportsModel {

    private String StartDate;
    private String EndDate;
    private String ActivityType;
    private String ReportView;
}
