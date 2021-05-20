package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VitalsModel {

    private String VitalsDate;
    private String Steps;
    private String CaloriesConsumed;
    private String Weight;
    private String BodyFat;
    private String Water;
    private String MuscleMass;
    private String Resting;
    private String Variability;
    private String SleepHours;
    private String TotalTimeAwake;
    private String Systolic;
    private String Diastolic;
    private String HealthNotes;
    private String WeightType;
    private String MuscleMassType;
    private String SleepAmount;
    private String SleepQuality;
    private String StressAmount;
}
