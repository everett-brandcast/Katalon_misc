package com.designstudio.component


import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.brandcast.Core
import com.brandcast.Utils
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

import internal.GlobalVariable
import java.util.List
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver

public class Text {
	
	Core brandcast = new Core()
	Utils utils = new Utils()

	/* ==================================================================================================
	 *
	 * Text Component
	 *
	 */

	private TextComponentXpath = '//span[contains(@class,"bc-site-content")]/div[contains(@data-radium,"true")]/div[contains(@class,"root") and contains(@class,"has-selections") and contains(@class,"outline-view")]/span/span/div[contains(@class,"inline") and contains(@data-radium,"true")]/div[contains(@class,"inline")]/span/div[contains(@data-schema-name,"Video") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-type,"Video") and contains(@class,"bc-video-wrapper") and contains(@class,"component-wrapper") and contains(@class,"bc-center") and contains(@class,"root-component") and contains(@data-radium,"true")]'

	public String getTextComponentXpath(){
		return this.TextComponentXpath
	}

	public WebElement getTextComponent(){
		return brandcast.getElementByXpath(this.getTextComponentXpath())
	}

	/*Video Focus Controls*/
	private String TextFocusControlsXpath = '//span[contains(@class,"focus-controls")]/div[contains(@class,"focus-controls-inner")]'

	public String getTextFocusControlsXpath(){
		return this.TextFocusControlsXpath
	}

	public WebElement getTextFocusControls(){
		return brandcast.getChildElementByXpath(this.getTextComponent(), this.getTextFocusControlsXpath())
	}

	/*Top Sizing*/
	private String TextTopSizingXpath = '//span[contains(@class,"top-sizing-container")]/span[contains(@class,"top-sizing-anchor-container")]/span[contains(@class,"anchor sizing")]/div[contains(@class,"focus-frame-info")]'

	String getTextTopSizingXpath(){
		return this.TextTopSizingXpath
	}

	WebElement getTextTopSizing(){
		return brandcast.getChildElementByXpath(this.getTextFocusControls(), this.getTextTopSizingXpath())
	}
	

	@Keyword
	public def clickTextTopSizing(){
		this.getTextTopSizing().click()
	}


	/*Right Sizing*/
	private String TextRightSizingXpath = '//span[contains(@class,"right-sizing-container")]'

	public String getTextRightSizingXpath(){
		return this.TextRightSizingXpath
	}

	WebElement getTextRightSizing(){
		return brandcast.getChildElementByXpath(this.getTextFocusControls(), this.getTextRightSizingXpath())
	}

	@Keyword
	def clickTextRightSizing(){
	}

	@Keyword
	def dragTextRightSizingUp(){
	}

	/*Bottom Sizing*/
	private String TextBottomSizingXpath = '//span[contains(@class,"bottom-sizing-container")]'

	String getTextBottomSizingXpath(){
		return this.TextBottomSizingXpath
	}

	WebElement getTextBottomSizing(){
		return brandcast.getChildElementByXpath(this.getTextFocusControls(), this.getTextBottomSizingXpath())
	}

	@Keyword
	def clickTextBottomSizing(){
	}

	@Keyword
	def dragTextBottomSizingUp(){
	}

	/*Left Sizing*/
	private String TextLeftSizingXpath = '//span[contains(@class,"left-sizing-container")]'

	String getTextLeftSizingXpath(){
		return this.TextLeftSizingXpath
	}

	WebElement getTextLeftSizing(){
		return brandcast.getChildElementByXpath(this.getTextFocusControls(), this.getTextLeftSizingXpath())
	}

	@Keyword
	def clickTextLeftSizing(){
	}

	@Keyword
	def dragTextLeftSizingUp(){
	}

	/*Top Padding*/
	private String TextTopPaddingXpath = '//span[contains(@class,"top-padding-container")]'

	String getTextTopPaddingXpath(){
		return this.TextTopPaddingXpath
	}

	WebElement getTextTopPadding(){
		return brandcast.getChildElementByXpath(this.getTextFocusControls(), this.getTextTopPaddingXpath())
	}

	@Keyword
	def clickTextTopPadding(){
	}

	@Keyword
	def dragTextTopPaddingUp(){
	}

	/*Right Padding*/
	private String TextRightPaddingXpath = '//span[contains(@class,"right-padding-container")]'

	String getTextRightPaddingXpath(){
		return this.TextRightPaddingXpath
	}

	WebElement getTextRightPadding(){
		return brandcast.getChildElementByXpath(this.getTextFocusControls(), this.getTextRightPaddingXpath())
	}

	@Keyword
	def clickTextRightPadding(){
	}

	@Keyword
	def dragTextRightPaddingUp(){
	}

	/*Bottom Padding*/
	private String TextBottomPaddingXpath = '//span[contains(@class,"bottom-padding-container")]'

	String getTextBottomPaddingXpath(){
		return this.TextBottomPaddingXpath
	}

	WebElement getTextBottomPadding(){
		return brandcast.getChildElementByXpath(this.getTextFocusControls(), this.getTextBottomPaddingXpath())
	}

	@Keyword
	def clickTextBottomPadding(){
	}

	@Keyword
	def dragTextBottomPaddingUp(){
	}

	/*Left Padding*/
	private String TextLeftPaddingXpath = '//span[contains(@class,"left-padding-container")]'

	String getTextLeftPaddingXpath(){
		return this.TextLeftPaddingXpath
	}

	WebElement getTextLeftPadding(){
		return brandcast.getChildElementByXpath(this.getTextFocusControls(), this.getTextLeftPaddingXpath())
	}

	@Keyword
	def clickTextLeftPadding(){
	}

	@Keyword
	def dragTextLeftPaddingUp(){
	}

	/*Focus Link*/
	private String TextFocusLinkXpath = '//span[contains(@class,"focus-link-container")]'

	String getTextFocusLinkXpath(){
		return this.TextFocusLinkXpath
	}

	WebElement getTextFocusLink(){
		return brandcast.getChildElementByXpath(this.getTextFocusControls(), this.getTextFocusLinkXpath())
	}

	@Keyword
	def clickTextFocusLink(){
	}

	/*Save As*/
	private String TextSaveAsXpath = '//span[contains(@class,"save-as")]'

	String getTextSaveAsXpath(){
		return this.TextSaveAsXpath
	}

	WebElement getTextSaveAs(){
		return brandcast.getChildElementByXpath(this.getTextFocusControls(), this.getTextSaveAsXpath())
	}

	@Keyword
	def clickTextSaveAs(){
	}
}
