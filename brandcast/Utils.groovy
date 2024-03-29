package com.brandcast

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject


/*Selenium*/
import org.openqa.selenium.By
import org.openqa.selenium.By.ByXPath
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import static java.util.UUID.randomUUID
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.sql.Timestamp
import java.time.Instant
import internal.GlobalVariable

public class Utils {
	/**
	 * 
	 * Get Random Number From Range
	 * 	
	 */
	@Keyword
	def getRandomNumber(Integer min, Integer max){
		return Math.round(((Math.random() * (max - min)) + min))
	}


	/**
	 * 
	 * Get UUID 
	 * 
	 */
	@Keyword
	def getUUID(){
		return randomUUID().toString()
	}


	/**
	 *
	 * Get Current Date
	 *
	 */
	@Keyword
	def getTodayDate(){
		Date date = new Date();
		return date.toString()
	}
	/**
	 *
	 * Get Current Date
	 *
	 */
	@Keyword
	def getTimeStamp(){
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.getTime().toString()
	}

	/**
	 *
	 * Get Date as Serial
	 * 
	 */
	@Keyword
	def getDateSerial(){
		LocalDateTime dateObj = LocalDateTime.now()
		DateTimeFormatter dateFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss")
		return dateObj.format(dateFormatObj).toString()
	}

	/**
	 *
	 * Get Random Text
	 *
	 */
	@Keyword
	def getRandomText(){
		return this.getTodayDate()+" "+this.getUUID()
	}

	/**
	 *
	 * Get Screenshot Name
	 *
	 */
	def getScreenShotName(){
		return "image-"+randomUUID().toString()+".png"
	}

	/**
	 *
	 * Get Screenshot Name
	 *
	 */
	def getVerifiedScreenShotName(){
		return "verified-"+randomUUID().toString()+".png"
	}

	/**
	 *
	 * Get Template Name
	 *
	 */
	@Keyword
	def getTemplateName(){
		return 'Template ' + this.getUUID()
	}

	/**
	 * 
	 * Get Website Name 
	 * 
	 */
	@Keyword
	def getWebsiteName(){
		return 'Hello_World ' + this.getUUID()
	}

	/**
	 *
	 * Get Tagname Name
	 *
	 */
	@Keyword
	def getTimeStampName(){
		return 'TagName' + this.getTimeStamp()
	}

	@Keyword
	def getOperatingSystem(){
		return System.getProperty('os.name')
	}
}
