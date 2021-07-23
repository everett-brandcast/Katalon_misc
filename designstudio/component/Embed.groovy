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

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

public class Embed {
	Core brandcast = new Core()
	Utils utils = new Utils()

	/* ==================================================================================================
	 *
	 * Embed Component
	 *
	 */

	private String EmbedComponentXpath = '//span[contains(@class,"bc-site-content")]/div[contains(@data-radium, "true")]/div[contains(@class,"root") and contains(@class,"has-selections") and contains(@class,"outline-view")]/span/span/div[contains(@class,"inline") and contains(@data-radium,"true")]/div[contains(@class,"inline")]/span/div[contains(@data-schema-name,"Embed") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-type,"Embed") and contains(@class,"bc-embed-wrapper") and contains(@class,"component-wrapper") and contains(@class,"bc-center") and contains(@class,"focused") and contains(@class,"root-component") and contains(@data-radium,"true")]'

	String getEmbedComponentXpath(){
		return this.EmbedComponentXpath
	}

	WebElement getEmbedComponent(){
		return brandcast.getElementByXpath(this.getEmbedComponentXpath())
	}

	/*Embed Focus Controls*/
	private String EmbedFocusControlsXpath = '//span[contains(@class,"focus-controls")]/div[contains(@class,"focus-controls-inner")]'

	String getEmbedFocusControlsXpath(){
		return this.EmbedFocusControlsXpath
	}

	WebElement getEmbedFocusControls(){
		return brandcast.getChildElementByXpath(this.getEmbedComponent(), this.getEmbedFocusControlsXpath())
	}

	/*Top Sizing*/
	private String EmbedTopSizingXpath = '//span[contains(@class,"top-sizing-container")]/span[contains(@class,"top-sizing-anchor-container")]/span[contains(@class,"anchor sizing")]/div[contains(@class,"focus-frame-info")]'

	String getEmbedTopSizingXpath(){
		return this.EmbedTopSizingXpath
	}

	WebElement getEmbedTopSizing(){
		return brandcast.getChildElementByXpath(this.getEmbedFocusControls(), this.getEmbedTopSizingXpath())
	}
	@Keyword
	def clickEmbedTopSizing(){
		this.getEmbedTopSizing().click()
	}


	/*Right Sizing*/
	private String EmbedRightSizingXpath = '//span[contains(@class,"right-sizing-container")]'

	String getEmbedRightSizingXpath(){
		return this.EmbedRightSizingXpath
	}

	WebElement getEmbedRightSizing(){
		return brandcast.getChildElementByXpath(this.getEmbedFocusControls(), this.getEmbedRightSizingXpath())
	}

	@Keyword
	def clickEmbedRightSizing(){
	}

	@Keyword
	def dragEmbedRightSizingUp(){
	}

	/*Bottom Sizing*/
	private String EmbedBottomSizingXpath = '//span[contains(@class,"bottom-sizing-container")]'

	String getEmbedBottomSizingXpath(){
		return this.EmbedBottomSizingXpath
	}

	WebElement getEmbedBottomSizing(){
		return brandcast.getChildElementByXpath(this.getEmbedFocusControls(), this.getEmbedBottomSizingXpath())
	}

	@Keyword
	def clickEmbedBottomSizing(){
	}

	@Keyword
	def dragEmbedBottomSizingUp(){
	}

	/*Left Sizing*/
	private String EmbedLeftSizingXpath = '//span[contains(@class,"left-sizing-container")]'

	String getEmbedLeftSizingXpath(){
		return this.EmbedLeftSizingXpath
	}

	WebElement getEmbedLeftSizing(){
		return brandcast.getChildElementByXpath(this.getEmbedFocusControls(), this.getEmbedLeftSizingXpath())
	}

	@Keyword
	def clickEmbedLeftSizing(){
	}

	@Keyword
	def dragEmbedLeftSizingUp(){
	}

	/*Top Padding*/
	private String EmbedTopPaddingXpath = '//span[contains(@class,"top-padding-container")]'

	String getEmbedTopPaddingXpath(){
		return this.EmbedTopPaddingXpath
	}

	WebElement getEmbedTopPadding(){
		return brandcast.getChildElementByXpath(this.getEmbedFocusControls(), this.getEmbedTopPaddingXpath())
	}

	@Keyword
	def clickEmbedTopPadding(){
	}

	@Keyword
	def dragEmbedTopPaddingUp(){
	}

	/*Right Padding*/
	private String EmbedRightPaddingXpath = '//span[contains(@class,"right-padding-container")]'

	String getEmbedRightPaddingXpath(){
		return this.EmbedRightPaddingXpath
	}

	WebElement getEmbedRightPadding(){
		return brandcast.getChildElementByXpath(this.getEmbedFocusControls(), this.getEmbedRightPaddingXpath())
	}

	@Keyword
	def clickEmbedRightPadding(){
	}

	@Keyword
	def dragEmbedRightPaddingUp(){
	}

	/*Bottom Padding*/
	private String EmbedBottomPaddingXpath = '//span[contains(@class,"bottom-padding-container")]'

	String getEmbedBottomPaddingXpath(){
		return this.EmbedBottomPaddingXpath
	}

	WebElement getEmbedBottomPadding(){
		return brandcast.getChildElementByXpath(this.getEmbedFocusControls(), this.getEmbedBottomPaddingXpath())
	}

	@Keyword
	def clickEmbedBottomPadding(){
	}

	@Keyword
	def dragEmbedBottomPaddingUp(){
	}

	/*Left Padding*/
	private String EmbedLeftPaddingXpath = '//span[contains(@class,"left-padding-container")]'

	String getEmbedLeftPaddingXpath(){
		return this.EmbedLeftPaddingXpath
	}

	WebElement getEmbedLeftPadding(){
		return brandcast.getChildElementByXpath(this.getEmbedFocusControls(), this.getEmbedLeftPaddingXpath())
	}

	@Keyword
	def clickEmbedLeftPadding(){
	}

	@Keyword
	def dragEmbedLeftPaddingUp(){
	}

	/*Focus Link*/
	private String EmbedFocusLinkXpath = '//span[contains(@class,"focus-link-container")]'

	String getEmbedFocusLinkXpath(){
		return this.EmbedFocusLinkXpath
	}

	WebElement getEmbedFocusLink(){
		return brandcast.getChildElementByXpath(this.getEmbedFocusControls(), this.getEmbedFocusLinkXpath())
	}

	@Keyword
	def clickEmbedFocusLink(){
	}

	/*Save As*/
	private String EmbedSaveAsXpath = '//span[contains(@class,"save-as")]'

	String getEmbedSaveAsXpath(){
		return this.EmbedSaveAsXpath
	}

	WebElement getEmbedSaveAs(){
		return brandcast.getChildElementByXpath(this.getEmbedFocusControls(), this.getEmbedSaveAsXpath())
	}

	@Keyword
	def clickEmbedSaveAs(){
	}
}
