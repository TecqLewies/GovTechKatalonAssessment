package formSubmissionConfirmationPage

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class FormSubmissionConfirmationPage {
	String submitAnotherResponse='Object Repository/Form completed page/Submit Another Response'
	String selectOneStar='Object Repository/Form completed page/Ratings/1 star'
	String selectTwoStar='Object Repository/Form completed page/Ratings/2 star'
	String selectThreeStar='Object Repository/Form completed page/Ratings/3 star'
	String selectFourStar='Object Repository/Form completed page/Ratings/4 star'
	String selectFiveStar='Object Repository/Form completed page/Ratings/5 star'
	String feedbackField='Object Repository/Form completed page/Feedback Comments'
	String submitButton='Object Repository/Form completed page/Submit feedback'
	String completedFeedbackTitle='Object Repository/Form Submitted Feedback/Completed Feedback Title'
	String technicalTestFormTitle='Object Repository/Technical Test Form Page/Technical Test Form Title'
	String submitAnotherResponseAfterFeedback='Object Repository/Form Submitted Feedback/Submit Another Response After Feedback'

	@Keyword
	def setRating(int rating) {
		try {
			switch(rating) {
				case 1:
					WebUI.click(findTestObject(selectOneStar))
					break
				case 2:
					WebUI.click(findTestObject(selectTwoStar))
					break
				case 3:
					WebUI.click(findTestObject(selectThreeStar))
					break
				case 4:
					WebUI.click(findTestObject(selectFourStar))
					break
				case 5:
					WebUI.click(findTestObject(selectFiveStar))
					break
			}
		} catch (Exception e) {
			KeywordUtil.logInfo("Exception at setting ratings!")
			WebUI.closeBrowser()
			throw e
		}
	}
	@Keyword
	def setFeedback(String feedback) {
		try {
			WebUI.setText(findTestObject(feedbackField), feedback)
		} catch (Exception e) {
			KeywordUtil.logInfo("Exception at setting feedbback!")
			WebUI.closeBrowser()
			throw e
		}
	}
	@Keyword
	def submitFeedback() {
		try {
			WebUI.click(findTestObject(submitButton))
			WebUI.waitForElementVisible(findTestObject(completedFeedbackTitle),
					10)
		} catch (Exception e) {
			KeywordUtil.logInfo("Exception at submitting feedback!")
			WebUI.closeBrowser()
			throw e
		}
	}
	@Keyword
	def submitAnotherForm() {
		try {
			WebUI.click(findTestObject(submitAnotherResponse))
			WebUI.waitForElementVisible(findTestObject(technicalTestFormTitle),
					10)
		} catch (Exception e) {
			KeywordUtil.logInfo("Exception at trying to submit another form!")
			WebUI.closeBrowser()
			throw e
		}
	}
	@Keyword
	def submitAnotherFormAfterFeedback() {
		try {
			WebUI.click(findTestObject(submitAnotherResponseAfterFeedback))
			WebUI.waitForElementVisible(findTestObject(technicalTestFormTitle),
					10)
		} catch (Exception e) {
			KeywordUtil.logInfo("Exception at trying to submit another form after submitting feedback!")
			WebUI.closeBrowser()
			throw e
		}
	}
}
