# Diploma project
## Testing of "https://log.finalsurge.com/UserProfile.cshtml" website using following patterns:
 
1. Page Object
2. Loadable Page/Component 
3. Value object
4. Loadable component 
5. Steps

## Use technologies:

1. Maven
2. TestNG
3. Selenium
4. Allure Reporting
5. CircleCI
6. Log4J
7. Lombok
8. Exception handling
 
# Test suite
## Test case 1 - Login Test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Send email | email entered | 
| 2 | Send password | password entered | 
| 3 | Click checkbox | checkbox is select | 
| 4 | Click "Login button" | open main page | 

## Test case 2 - Workout quick add
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Click "Calendar button" | open calender page | 
| 2 | Click day of week | open list | 
| 3 | Click "quick add" | open workout quick add menu | 
| 4 | Choose a date | date selected | 
| 5 | Choose a time | time selected | 
| 6 | Choose activity type | activity type selected | 
| 7 | Send workout name | workout name entered | 
| 8 | Send workout description | workout description entered | 
| 9 | Click checkbox | checkbox is select | 
| 10 | Send Distance | Distance entered  | 
| 11 | Choose DistType | DistType is select | 
| 12 | Send Duration | Duration entered | 
| 13 | Choose DistType | DistType is select | 
| 14 | Send Pace | Pace entered | 
| 15 | Choose How I Felt | How I Felt is select | 
| 16 | Choose Perceived Effort | Perceived Effort is select | 
| 17 | Send Results | Results  entered | 
| 18 | Click "Add workout" button | Workout added to calendar | 

## Test case 3 - Сalculate training pace
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Click "Workout calculators" button | open Workout calculators page | 
| 2 | Click "Hansons" button | open Hansons | 
| 3 | Send Distance | Distance entered | 
| 4 | Send Time | Time entered | 
| 5 | Send Heat/Humidity/Wind Chill Adjustments | Heat/Humidity/Wind Chill Adjustments entered | 
| 6 | Click "Calculate paces" button | open recent race information and training paces | 

## Test case 4 - Get report
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Click "Report and Statistics" button | open Report and Statistics page | 
| 2 | Choose start date | start date is select | 
| 3 | Choose end date | end date is select | 
| 4 | Choose Activity Type | Activity Type is select | 
| 5 | Choose Report View | Report View is select | 
| 6 | Click "View Report" button | displayed Report and Statistics| 

## Test case 5 - Print workouts
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Click "Print workouts" button | open Print workouts page | 
| 2 | Choose Print Starting Date | Print Starting Date is select | 
| 3 | Choose Print Ending Date | Print Ending Date is select | 
| 4 | Click "Print workouts" button | the result is printed| 

## Test case 6 - Send message
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Click "Mailbox" button | open Print workouts page | 

## Test case 7 - Add Shoe
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Click "Gear & Roules" button | open equipment page | 
| 2 | Click "Shoes" | open shoes page | 
| 3 | Send Shoe Name | Shoe Name entered | 
| 4 | Choose Brand | Brand is select | 
| 5 | Send Model | Model entered |  
| 6 | Send cost | Cost entered |  
| 7 | Send Date Purchased | Date Purchased entered |  
| 8 | Choose Shoe Size | Shoe Size is select | 
| 9 | Send Starting Distance | Starting Distance entered | 
| 10 | Send Distance Alert | Distance Alert entered | 
| 11 | Send Notes | Notes entered | 
| 12 | Click "Add Shoe" button | added shoe | 

Run tests:
```
mvn clean test -Demail_account=<EMAIL> -Dpassword_account=<PASSWORD>
```
In order to generate a report:
```
mvn allure:serve
```
