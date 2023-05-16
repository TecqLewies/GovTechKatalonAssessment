import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Test Cases/WorkflowTestCases/TestCaseSetup'),[:],FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/WorkflowTestCases/MandatoryFields'),[('firstName'):firstName,('lastName'):lastName,
	('email'):email,('gender'):gender,('mobileNumber'):mobileNumber,('dateOfBirth'):dateOfBirth,
	('hobbiesSports'):hobbiesSports,('hobbiesReading'):hobbiesReading,('hobbiesMusic'):hobbiesMusic],FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/WorkflowTestCases/CompletedFormAndFeedback'),[('submitAnotherForm'):submitAnotherForm,
	('feedbackRating'):feedbackRating,('feedbackComment'):feedbackComment,
	('submitAnotherFormAfterFeedback'):submitAnotherFormAfterFeedback],FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/WorkflowTestCases/TestCaseTeardown'),[:],FailureHandling.STOP_ON_FAILURE)