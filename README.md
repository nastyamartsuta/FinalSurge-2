# Training test Framework
## Training project on UI testing automation in Java + Selenium.
Testing of "https://log.finalsurge.com/UserProfile.cshtml" website. It is the website for creating a workout plan.
Following patterns were used:
 
1. Page Object
2. Loadable Page/Component 
3. Value object
4. Chain of invocation 
5. Steps

## Used technologies:
Java, Selenium, Maven, TestNG, Allure Reporting, Jenkins, Docker, Log4J, Lombok
 
# Tests
## Test suite 1 - Login Test
## Test case 1.1 - Login test with valid Email and Password
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Enter valid Email and Password | Successful validation. There are no error messages. | 
## Test case 1.2 - Login test with invalid Email and Password
| Step | Description | Expected result |
| --- | --- | --- |
| 1 | Enter invalid Email and Password | Failed validation. Error messages. | 
## Test case 1.3 - Login test with valid Email and invalid Password
| Step | Description | Expected result |
| --- | --- | --- |
| 1 | Enter valid Email and invalid Password | Failed validation. Error messages. |
## Test case 1.4 - Login test with invalid Email and valid Password
| Step | Description | Expected result |
| --- | --- | --- |
| 1 | Enter invalid Email and valid Password | Failed validation. Error messages. | 
## Test case 1.5 - Login test with empty Email and Password
| Step | Description | Expected result |
| --- | --- | --- |
| 1 | Enter empty Email and Password | Failed validation. Error messages. | 
## Test case 1.6 - Login test with empty Email and valid Password
| Step | Description | Expected result |
| --- | --- | --- |
| 1 | Enter empty Email and valid Password | Failed validation. Error messages. | 
## Test case 1.7 - Login test with valid Email and empty Password
| Step | Description | Expected result |
| --- | --- | --- |
| 1 | Enter valid Email and empty Password | Failed validation. Error messages. | 

## Test suite 2 - Activity Type Test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open activity type page | Activity type page was opened |
| 2 | Fill in the fields | The fields was filled |
| 3 | Save new activity type | The new activity type was successfully added |

## Test suite 3 - Workout quick add Test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open calendar panel | Calendar panel was opened |
| 2 | Fill in the fields | The fields was filled |
| 3 | Save new workout | The new workout was successfully added |

## Test suite 4 - Calendar page test
## Test case 4.1 - Add workout quick test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open calendar page | Calendar page was opened |
| 2 | Fill in the fields | The fields was filled |
| 3 | Save new workout quick | The new workout quick was successfully added |
## Test case 4.2 - Move workout test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open calendar page | Calendar page was opened |
| 2 | Fill in the fields | The fields was filled |
| 3 | Save new workout quick | The new workout quick was successfully added |
| 4 | Open menu | Menu was opened |
| 5 | Move workout | Workout was moved |
## Test case 4.3 - Add comment test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open calendar page | Calendar page was opened |
| 2 | Fill in the fields | The fields was filled |
| 3 | Save new workout quick | The new workout quick was successfully added |
| 4 | Open menu | Menu was opened |
| 5 | Open comment page | Comment page was opened |
| 6 | Save new comment | New comment was saved |
## Test case 4.4 - Open library test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open workout library panel | Workout library panel was opened |
| 2 | Select activity type filter | Activity type filter was selected |
| 3 | Open library | Library was opened |
## Test case 4.5 - Upload workout data test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open calendar page | Calendar page was opened |
| 2 | Open menu | Menu was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Upload workout | New workout was uploaded |
## Test case 4.6 - View workout details test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open calendar page | Calendar page was opened |
| 2 | Open menu | Menu was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Upload workout | New workout was uploaded |
| 5 | Open workout details | Workout details was opened |
## Test case 4.7 - Delete uploaded workout test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open calendar page | Calendar page was opened |
| 2 | Open menu | Menu was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Upload workout | New workout was uploaded |
| 5 | Open calendar page | Calendar page was opened |
| 6 | Open menu | Menu was opened |
| 7 | Delete uploaded workout | Uploaded workout was deleted |

## Test suite 5 - Daily vitals page test
## Test case 5.1 - View vitals test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open Daily vitals page | Daily vitals page was opened |
| 2 | View last month vitals | Last month vitals was viewed |
## Test case 5.2 - Add vitals test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open Daily vitals page | Daily vitals page was opened |
| 2 | Open add vitals panel | Vitals panel was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Save new vitals | New vitals was added |

## Test suite 6 - Equipment page test
## Test case 6.1 - Add Shoes test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open equipment page | Equipment page was opened |
| 2 | Open shoes page | Shoes page was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Save new shoes | New shoes was added |
## Test case 6.2 - Add Bike test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open equipment page | Equipment page was opened |
| 2 | Open bike page | Bike page was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Save new bike | New bike was added |
## Test case 6.3 - Add Route test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open equipment page | Equipment page was opened |
| 2 | Open route page | Route page was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Save new route | New route was added |

## Test suite 7 - Other calculator page test
## Test case 7.1 - Calculate needs test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open other calculate page | Other calculator page was opened |
| 2 | Open calculate needs page | Calculate needs page was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Calculate caloric needs | Today's caloric needs was calculated |
## Test case 7.2 - Pace calculate test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open other calculate page | Other calculator page was opened |
| 2 | Open pace calculate page | Pace calculate page was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Calculate paces | Paces was calculated |

## Test suite 8 - Get report test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open Report and Statistics page | Report and Statistics page was opened | 
| 2 | Fill in the fields | The fields was filled |
| 3 | View Report | Report was viewed | 

## Test suite 9 - Print workouts test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open Print workouts page | Print workouts page was opened | 
| 2 | Fill in the fields | The fields was filled |
| 3 | Print workouts | Workouts was printed |

## Test suite 10 - Workout calculator page test
## Test case 10.1 - Tinman test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open calculate page | Calculator page was opened |
| 2 | Open tinman page | Tinman page was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Calculate paces | Paces was calculated |
## Test case 10.2 - Intensity test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open calculate page | Calculator page was opened |
| 2 | Open Intensity page | Intensity page was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Calculate paces | Paces was calculated |
## Test case 10.3 - Hansons test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open calculate page | Calculator page was opened |
| 2 | Open Hansons page | Hansons page was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Calculate paces | Paces was calculated |
## Test case 10.4 - McMillan test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open calculate page | Calculator page was opened |
| 2 | Open McMillan page | McMillan page was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Calculate my paces | My paces was calculated |

Run tests:
```
mvn clean test -Demail_account=<EMAIL> -Dpassword_account=<PASSWORD>
```
In order to generate a report:
```
mvn allure:serve
```
