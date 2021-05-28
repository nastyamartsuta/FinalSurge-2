# Training test Framework
## Training project on UI testing automation in Java language with selenium.
Testing of "https://log.finalsurge.com/UserProfile.cshtml" website. It is the website for creating a workout plan.
Using following patterns:
 
1. Page Object
2. Loadable Page/Component 
3. Value object
4. Loadable component 
5. Steps

## Use technologies:
Java, Selenium, Maven, TestNG, Allure Reporting, CircleCI, Log4J, Lombok
 
# Test suite
## Test case 1 - Login Test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Enter valid Email and Password | Successful validation. There are no error messages. | 
| 2 | Enter invalid Email and Password | Failed validation. Error messages. | 
| 3 | Enter valid Email and invalid Password | Failed validation. Error messages. | 
| 4 | Enter invalid Email and valid Password | Failed validation. Error messages. | 
| 5 | Enter empty Email and Password | Failed validation. Error messages. | 
| 6 | Enter empty Email and valid Password | Failed validation. Error messages. | 
| 7 | Enter valid Email and empty Password | Failed validation. Error messages. | 

## Test case 2 - Activity Type Test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open activity type page | Activity type page was opened |
| 2 | Fill in the fields | The fields was filled |
| 3 | Save new activity type | The new activity type was successfully added |

## Test case 3 - Workout quick add Test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open calendar panel | Calendar panel was opened |
| 2 | Fill in the fields | The fields was filled |
| 3 | Save new workout | The new workout was successfully added |

## Test case 4 - Calendar page test
## Test 4.1 - Add workout quick test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open calendar page | Calendar page was opened |
| 2 | Fill in the fields | The fields was filled |
| 3 | Save new workout quick | The new workout quick was successfully added |
## Test 4.2 - Move workout test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open calendar page | Calendar page was opened |
| 2 | Fill in the fields | The fields was filled |
| 3 | Save new workout quick | The new workout quick was successfully added |
| 4 | Open menu | Menu was opened |
| 5 | Move workout | Workout was moved |
## Test 4.3 - Add comment test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open calendar page | Calendar page was opened |
| 2 | Fill in the fields | The fields was filled |
| 3 | Save new workout quick | The new workout quick was successfully added |
| 4 | Open menu | Menu was opened |
| 5 | Open comment page | Comment page was opened |
| 6 | Save new comment | New comment was saved |
## Test 4.4 - Open library test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open workout library panel | Workout library panel was opened |
| 2 | Select activity type filter | Activity type filter was selected |
| 3 | Open library | Library was opened |
## Test 4.5 - Upload workout data test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open calendar page | Calendar page was opened |
| 2 | Open menu | Menu was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Upload workout | New workout was uploaded |
## Test 4.6 - View workout details test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open calendar page | Calendar page was opened |
| 2 | Open menu | Menu was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Upload workout | New workout was uploaded |
| 5 | Open workout details | Workout details was opened |
## Test 4.7 - Delete uploaded workout test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open calendar page | Calendar page was opened |
| 2 | Open menu | Menu was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Upload workout | New workout was uploaded |
| 5 | Open calendar page | Calendar page was opened |
| 6 | Open menu | Menu was opened |
| 7 | Delete uploaded workout | Uploaded workout was deleted |

## Test case 5 - Daily vitals page test
## Test 5.1 - View vitals test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open Daily vitals page | Daily vitals page was opened |
| 2 | View last month vitals | Last month vitals was viewed |
## Test 5.2 - Add vitals test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open Daily vitals page | Daily vitals page was opened |
| 2 | Open add vitals panel | Vitals panel was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Save new vitals | New vitals was added |

## Test case 6 - Equipment page test
## Test 6.1 - Add Shoes test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open equipment page | Equipment page was opened |
| 2 | Open shoes page | Shoes page was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Save new shoes | New shoes was added |
## Test 6.2 - Add Bike test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open equipment page | Equipment page was opened |
| 2 | Open bike page | Bike page was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Save new bike | New bike was added |
## Test 6.3 - Add Route test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open equipment page | Equipment page was opened |
| 2 | Open route page | Route page was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Save new route | New route was added |

## Test case 7 - Other calculator page test
## Test 7.1 - Calculate needs test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open other calculate page | Other calculator page was opened |
| 2 | Open calculate needs page | Calculate needs page was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Calculate caloric needs | Today's caloric needs was calculated |
## Test 7.2 - Pace calculate test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open other calculate page | Other calculator page was opened |
| 2 | Open pace calculate page | Pace calculate page was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Calculate paces | Paces was calculated |

## Test case 8 - Get report test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open Report and Statistics page | Report and Statistics page was opened | 
| 2 | Fill in the fields | The fields was filled |
| 3 | View Report | Report was viewed | 

## Test case 9 - Print workouts test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open Print workouts page | Print workouts page was opened | 
| 2 | Fill in the fields | The fields was filled |
| 3 | Print workouts | Workouts was printed |

## Test case 10 - Workout calculator page test
## Test 10.1 - Tinman test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open calculate page | Calculator page was opened |
| 2 | Open tinman page | Tinman page was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Calculate paces | Paces was calculated |
## Test 10.2 - Intensity test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open calculate page | Calculator page was opened |
| 2 | Open Intensity page | Intensity page was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Calculate paces | Paces was calculated |
## Test 10.3 - Hansons test
| Step | Description | Expected result |
| --- | --- | --- | 
| 1 | Open calculate page | Calculator page was opened |
| 2 | Open Hansons page | Hansons page was opened |
| 3 | Fill in the fields | The fields was filled |
| 4 | Calculate paces | Paces was calculated |
## Test 10.4 - McMillan test
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
