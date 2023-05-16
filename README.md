# GovTech Katalon Assessment
## QA Assessment
This project was undertaken as part of a QA assessment by GovTech. The application under test is an online form with fields requesting the personal details of the respondent. After form submission, the user is re-directed to a confirmation page with the possibility of either submitting a new form, or giving feedback.
As part of the requirements of this assessment, Katalon Studio was used as the tool of choice. Katalon Studio can be downloaded at this link https://katalon.com/download

## Running the script
Before running the test script, we would need to clone the project from github to our local machine. We can do this via the Katalon Studio application and setting the git repository to this project. Then we clone the project using our git credentials and opening the project in the application and navigating to the folder where the project has been downloaded.

There are 3 ways to run the script at different project levels

To run the test script at the test case level, navigate to Test Cases/MainTestCases and select any test case. Click on the run icon or ctrl+shift+A to run the test case with a default browser, or select the drop-down list beside the run icon to select a browser of choice. 

![image](https://github.com/TecqLewies/GovTechKatalonAssessment/assets/124225074/822a15cb-ecd1-464d-81ca-58a8e63c2078)

The testcase will repeat until all rows of test data associated with the test case has been covered. We can find which test data is attached to the test case under the Data Binding tab.

To run the test cases at the test suite level, navigate to Test Suites/TS_Happyflow or TS_Negativeflow. As the names suggest, I have separated the test cases in accordance to whether we expect a positive scenario or negative scenario. Similarly, Click on the run icon or ctrl+shift+A to run the test case with a default browser, or select the drop-down list beside the run icon to select a browser of choice. 

![image](https://github.com/TecqLewies/GovTechKatalonAssessment/assets/124225074/0d425f8b-02b2-424c-ada4-c243a3b838e8)

To check the test data for each test case in the test suite, click into each test case and check its Data Binding tab.

To run the test scripts at the test suite collection level, we would similarly navigate to Test Suites/ HappyFlow Test Suite Collection or NegativeFlow Test Suite Collection. At this level, we have the option to conduct cross-browser testing with different browsers as well as parallel execution of test suites for a faster runtime.

![image](https://github.com/TecqLewies/GovTechKatalonAssessment/assets/124225074/f00dad82-3fc4-43b8-87d7-77da2667b957)

For test suite collections, click on the execute icon after setting the desired options.

## Test Data
Test data for this testing exercise were derived using the pairwise testing approach. This was achieved through an open source tool Allpairs found at https://www.satisfice.com/download/allpairs This application requires the manual identification of variations of test parameters as the input data, and generates possible combinations to significantly reduce test data variations as compared to exhaustive testing. For this project, the input data for the test form and feedback form were generated separately, as we can only reach the feedback form in happy flows. I have attached the data generated in this project under allpairs-data.

## Versions

| Software | Version |
| --- | --- |
| Katalon | 8.6.0 |
| Chrome | 113.0.5672.63 |
| Firefox | v0.33.0 |

## Improvements

Portability testing – The system under test as it is only consists of web pages. It would be prudent to include a wider range of user platforms to ensure usability of the application across various devices such as mobile devices. We could explore portability testing across devices through mobile browser testing to include a larger number of user devices to increase confidence in the application.

Non-functional testing – The current testing project only considers the functional side of the application. We can further verify the quality of the system by conducting non-functional testing such as performance tests to simulate large volumes of users accessing the web page and interacting with the backend by submitting the forms and being redirected to the confirmation page. However, Katalon Studio may not be the most ideal tool for performance testing and we can possibly explore better alternatives, like JMeter.

## Defect reports

| | Defect 1 |
| --- | --- |
| Description | For fields first name and last name on the test form, invalid characters such as numbers and special characters are accepted without any error message |
| Severity | Medium |
| Expected results | Some error message to be shown when invalid characters are input into either fields, and user to be unable to submit the test form |
| Actions to take | To implement restrictions from submitting the form when invalid characters are found in either the first name or last name fields, and some error message to be shown |
| Steps to reproduce | Enter invalid characters into either the first name or last name field, such as 12345 or !@#$% or a combination of both |


| | Defect 2 |
| --- | --- |
| Description | The date of birth field currently accepts dates that are very far into the past, such as for the year 1850. This should not be allowed as it is high improbable |
| Severity | Low |
| Expected results | Some error message to be shown for dates that are very far in the past, and user to be unable to submit the test form |
| Actions to take | To implement restrictions from submitting the form when dates very far in the past are used, beyond 1900, and some error message to be shown |
| Steps to reproduce | Enter a date in the date of birth field which has its year very far in the past, ie 17/06/1850 |

| | Defect 3 |
| --- | --- |
| Description | Invalid file formats are allowed to be uploaded when the form specifies it only accepts plain text files or images |
| Severity | Medium |
| Expected results | When a file of an unexpected format is uploaded, the form should reject the file and show an error message |
| Actions to take | Introduce restrictions to not accept invalid file formats, and show an error message |
| Steps to reproduce | Upload an invalid file format to the attachment field, such as a pdf file |

| | Defect 4 |
| --- | --- |
| Description | The address field is a free text field, and it can accept purely numbers or special characters, which does not make sense for an address |
| Severity | Low |
| Expected results | When the input for address is made of only numbers and special characters, an error message should be shown, and user to be unable to submit the test form |
| Actions to take | To implement restrictions from submitting the form when the address text field does not have any alphabetical characters, and some error message to be shown |
| Steps to reproduce | Enter invalid characters into the address field, such as 12345 or !@#$% or a combination of both |

| | Defect 5 |
| --- | --- |
| Description | When the input for feedback comment is made of only numbers and special characters, an error message should be shown, and user to be unable to submit the feedback form |
| Severity | Low |
| Expected results | When the input for feedback comments is made of only numbers and special characters, an error message should be shown, and user to be unable to submit the feedback form |
| Actions to take | To implement restrictions from submitting the feedback form when the feedback comment text field does not have any alphabetical characters, and some error message to be shown |
| Steps to reproduce | Enter invalid characters into the feedback comment field, such as 12345 or !@#$% or a combination of both |

## Test results
Passed/Failed/Skipped

Happyflow 26/0/0


![image](https://github.com/TecqLewies/GovTechKatalonAssessment/assets/124225074/9ed04a14-2b29-4a45-9cee-cf032ff56589)


NegativeFlow 43/0/0

![image](https://github.com/TecqLewies/GovTechKatalonAssessment/assets/124225074/a6595fc7-3bbb-41bb-ae92-ab33c859bec9)


For both test suites of happy flow and negative flow, we observe that all of the test cases have passed. I have created 26 happy flows and 43 negative flow test cases for a total for 69 test cases based on the test data generated.
The reasoning behind the larger than normal happy flow test cases is that we can only test the feedback form when the flow is considered happy, and the variations in feedback data will thus be considered so.

For the test results, I only consider unique test cases at the test suite level. Test cases can be run across various browsers for cross-browser testing using the test suite collections in the project but they should not be considered additional test cases as it may cause confusion.

You can view the reports for both test suites under the main folder of this project, at either .html files. Download them as needed and open using a browser of choice.
