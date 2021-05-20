package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UploadWorkoutDataModel {

    private String WorkoutDateAdd;
    private String Name;
    private String Description;
    private String ActivityType;
}
