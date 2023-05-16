package technicalTestFormPage
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
import java.awt.datatransfer.StringSelection
import java.awt.Robot
import java.awt.event.KeyEvent
import java.awt.Toolkit
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration

import internal.GlobalVariable

public class TechnicalTestFormPage {
	String firstNameField='Object Repository/Technical Test Form Page/First Name'
	String lastNameField='Object Repository/Technical Test Form Page/Last Name'
	String emailField='Object Repository/Technical Test Form Page/Email'
	String genderFieldMale='Object Repository/Technical Test Form Page/Gender/Gender Male Button'
	String genderFieldFemale='Object Repository/Technical Test Form Page/Gender/Gender Female Button'
	String mobileNumberField='Object Repository/Technical Test Form Page/Mobile Number'
	String dateOfBirthField='Object Repository/Technical Test Form Page/Date Of Birth'
	String hobbiesFieldSports='Object Repository/Technical Test Form Page/Hobbies/Hobbies Sports'
	String hobbiesFieldMusic='Object Repository/Technical Test Form Page/Hobbies/Hobbies Music'
	String hobbiesFieldReading='Object Repository/Technical Test Form Page/Hobbies/Hobbies Reading'
	String fileAttachmentField='Object Repository/Technical Test Form Page/Choose file'
	String locationField='Object Repository/Technical Test Form Page/Location/Location'
	String locationFieldNorth='Object Repository/Technical Test Form Page/Location/North'
	String locationFieldSouth='Object Repository/Technical Test Form Page/Location/South'
	String locationFieldEast='Object Repository/Technical Test Form Page/Location/East'
	String locationFieldWest='Object Repository/Technical Test Form Page/Location/West'
	String locationFieldCentral='Object Repository/Technical Test Form Page/Location/Central'
	String addressField='Object Repository/Technical Test Form Page/Address'
	String technicalTestFormTitle='Object Repository/Technical Test Form Page/Technical Test Form Title'
	String submitForm='Object Repository/Technical Test Form Page/Submit Form'
	String completedFormTitle='Object Repository/Form completed page/Completed Form Title'
	String mandatoryFieldMissing='Object Repository/Technical Test Form Page/Mandatory Field Missing/Field is required'

	Boolean dateInFuture=false
	Boolean invalidMobileNumLength=false
	String dateInFutureObject='Object Repository/Technical Test Form Page/Mandatory Field Missing/Date of Birth in future'
	String invalidMobileLengthObject='Object Repository/Technical Test Form Page/Mandatory Field Missing/Invalid mobile number length'

	@Keyword
	def setFirstName(String firstName) {
		try {
			WebUI.setText(findTestObject(firstNameField), firstName)
		} catch (Exception e) {
			KeywordUtil.logInfo("Exception at setting first name!")
			WebUI.closeBrowser()
			throw e
		}
	}
	@Keyword
	def setLastName(String lastName) {
		try {
			WebUI.setText(findTestObject(lastNameField), lastName)
		} catch (Exception e) {
			KeywordUtil.logInfo("Exception at setting last name!")
			WebUI.closeBrowser()
			throw e
		}
	}
	@Keyword
	def setEmail(String email) {
		try {
			WebUI.setText(findTestObject(emailField), email)
		} catch (Exception e) {
			KeywordUtil.logInfo("Exception at setting email!")
			WebUI.closeBrowser()
			throw e
		}
	}
	@Keyword
	def clickGender(String gender) {
		try {
			if(gender.equalsIgnoreCase("M"))
				WebUI.click(findTestObject(genderFieldMale))
			else if(gender.equalsIgnoreCase("F"))
				WebUI.click(findTestObject(genderFieldFemale))
		} catch (Exception e) {
			KeywordUtil.logInfo("Exception at setting gender!")
			WebUI.closeBrowser()
			throw e
		}
	}
	@Keyword
	def setMobileNumber(String mobileNumber) {
		if(mobileNumber.length()!=8)
			invalidMobileNumLength=true
		try {
			WebUI.setText(findTestObject(mobileNumberField), mobileNumber)
		} catch (Exception e) {
			KeywordUtil.logInfo("Exception at setting mobile number!")
			WebUI.closeBrowser()
			throw e
		}
	}
	@Keyword
	def setDateOfBirth(String dateOfBirth) {
		if(dateOfBirth.equals(''))
			dateInFuture=false
		else if(Integer.parseInt(dateOfBirth.substring(dateOfBirth.length()-4))>2023)
			dateInFuture=true
		try {
			WebUI.click(findTestObject(dateOfBirthField))
			WebUI.sendKeys(findTestObject(dateOfBirthField), dateOfBirth)
		} catch (Exception e) {
			KeywordUtil.logInfo("Exception at setting date of birth!")
			WebUI.closeBrowser()
			throw e
		}
	}
	@Keyword
	def clickHobbies(String sports,String reading,String music) {
		try {
			if(Boolean.parseBoolean(sports))
				WebUI.click(findTestObject(hobbiesFieldSports))
			if(Boolean.parseBoolean(reading))
				WebUI.click(findTestObject(hobbiesFieldReading))
			if(Boolean.parseBoolean(music))
				WebUI.click(findTestObject(hobbiesFieldMusic))
		} catch (Exception e) {
			KeywordUtil.logInfo("Exception at setting hobbies!")
			WebUI.closeBrowser()
			throw e
		}
	}
	@Keyword
	def uploadAttachment(String fileType) {
		try {
			String fileName=''
			String projectDir=RunConfiguration.getProjectDir()
			projectDir=projectDir.replaceAll("/","\\\\")
			if(fileType.equals('txt'))
				fileName=projectDir+'\\TestData\\UploadTestData\\TestUpload.txt'
			else if (fileType.equals('pdf'))
				fileName=projectDir+'\\TestData\\UploadTestData\\TestUpload.pdf'
			else if (fileType.equals('img'))
				fileName=projectDir+'\\TestData\\UploadTestData\\TestUpload.PNG'
			if(fileName!='') {
				StringSelection ss = new StringSelection(fileName);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
				WebUI.click(findTestObject(fileAttachmentField))
				Thread.sleep(1000)
				Robot rb=new Robot();
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_V);
				rb.keyRelease(KeyEvent.VK_V);
				rb.keyRelease(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_ENTER);
				rb.keyRelease(KeyEvent.VK_ENTER);
			}
		} catch (Exception e) {
			KeywordUtil.logInfo("Exception at uploading file!")
			WebUI.closeBrowser()
			throw e
		}
	}
	@Keyword
	def setLocation(String location) {
		try {
			WebUI.click(findTestObject(locationField))
			if(location.equalsIgnoreCase("West"))
				WebUI.click(findTestObject(locationFieldWest))
			else if(location.equalsIgnoreCase("East"))
				WebUI.click(findTestObject(locationFieldEast))
			else if(location.equalsIgnoreCase("North"))
				WebUI.click(findTestObject(locationFieldNorth))
			else if(location.equalsIgnoreCase("South"))
				WebUI.click(findTestObject(locationFieldSouth))
			else if(location.equalsIgnoreCase("Central"))
				WebUI.click(findTestObject(locationFieldCentral))
		} catch (Exception e) {
			KeywordUtil.logInfo("Exception at setting location!")
			WebUI.closeBrowser()
			throw e
		}
	}
	@Keyword
	def setAddress(String address) {
		try {
			WebUI.setText(findTestObject(addressField), address)
			WebUI.scrollToElement(findTestObject('Object Repository/Technical Test Form Page/Submit Form'), 3)
		} catch (Exception e) {
			KeywordUtil.logInfo("Exception at setting address!")
			WebUI.closeBrowser()
			throw e
		}
	}
	@Keyword
	def submitForm() {
		try {
			WebUI.click(findTestObject(submitForm))
			WebUI.waitForElementVisible(findTestObject(completedFormTitle),
					5)
		} catch (Exception e) {
			KeywordUtil.logInfo("Exception at submitting form!")
			WebUI.closeBrowser()
			throw e
		}
	}
	@Keyword
	def submitFormNegative() {
		try {
			WebUI.click(findTestObject(submitForm))
			WebUI.waitForElementVisible(findTestObject(technicalTestFormTitle),5,FailureHandling.STOP_ON_FAILURE)
			WebUI.waitForElementVisible(findTestObject(mandatoryFieldMissing),5,FailureHandling.STOP_ON_FAILURE)
			if(dateInFuture)
				WebUI.waitForElementVisible(findTestObject(dateInFutureObject),5,FailureHandling.STOP_ON_FAILURE)
			if(invalidMobileNumLength)
				WebUI.waitForElementVisible(findTestObject(invalidMobileLengthObject),5,FailureHandling.STOP_ON_FAILURE)
		} catch (Exception e) {
			KeywordUtil.logInfo("Exception at submitting form!")
			WebUI.closeBrowser()
			throw e
		}
	}
}
