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

public class Video {
	Core brandcast = new Core()
	Utils utils = new Utils()

	/* ==================================================================================================
	 *
	 * Video Component
	 *
	 */

	private String VideoComponentXpath = '//span[contains(@class,"bc-site-content")]/div[contains(@data-radium,"true")]/div[contains(@class,"root") and contains(@class,"has-selections") and contains(@class,"outline-view")]/span/span/div[contains(@class,"inline") and contains(@data-radium,"true")]/div[contains(@class,"inline")]/span/div[contains(@data-schema-name,"Video") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-type,"Video") and contains(@class,"bc-video-wrapper") and contains(@class,"component-wrapper") and contains(@class,"bc-center") and contains(@class,"root-component") and contains(@data-radium,"true")]'

	String getVideoComponentXpath(){
		return this.VideoComponentXpath
	}

	WebElement getVideoComponent(){
		return brandcast.getElementByXpath(this.getVideoComponentXpath())
	}

	/*Video Focus Controls*/
	private String VideoFocusControlsXpath = '//span[contains(@class,"focus-controls")]/div[contains(@class,"focus-controls-inner")]'

	String getVideoFocusControlsXpath(){
		return this.VideoFocusControlsXpath
	}

	WebElement getVideoFocusControls(){
		return brandcast.getChildElementByXpath(this.getVideoComponent(),this.getVideoFocusControlsXpath())
	}

	/*Top Sizing*/
	private String VideoTopSizingXpath = '//span[contains(@class,"top-sizing-container")]/span[contains(@class,"top-sizing-anchor-container")]/span[contains(@class,"anchor sizing")]/div[contains(@class,"focus-frame-info")]'

	String getVideoTopSizingXpath(){
		return this.VideoTopSizingXpath
	}

	WebElement getVideoTopSizing(){
		return brandcast.getChildElementByXpath(this.getVideoFocusControls(), this.getVideoTopSizingXpath())
	}
	@Keyword
	def clickVideoTopSizing(){
		this.getVideoTopSizing().click()
	}


	/*Right Sizing*/
	private String VideoRightSizingXpath = '//span[contains(@class,"right-sizing-container")]'

	String getVideoRightSizingXpath(){
		return this.VideoRightSizingXpath
	}

	WebElement getVideoRightSizing(){
		return brandcast.getChildElementByXpath(this.getVideoFocusControls(), this.getVideoRightSizingXpath())
	}

	@Keyword
	def clickVideoRightSizing(){
	}

	@Keyword
	def dragVideoRightSizingUp(){
	}

	/*Bottom Sizing*/
	private String VideoBottomSizingXpath = '//span[contains(@class,"bottom-sizing-container")]'

	String getVideoBottomSizingXpath(){
		return this.VideoBottomSizingXpath
	}

	WebElement getVideoBottomSizing(){
		return brandcast.getChildElementByXpath(this.getVideoFocusControls(), this.getVideoBottomSizingXpath())
	}

	@Keyword
	def clickVideoBottomSizing(){
	}

	@Keyword
	def dragVideoBottomSizingUp(){
	}

	/*Left Sizing*/
	private String VideoLeftSizingXpath = '//span[contains(@class,"left-sizing-container")]'

	String getVideoLeftSizingXpath(){
		return this.VideoLeftSizingXpath
	}

	WebElement getVideoLeftSizing(){
		return brandcast.getChildElementByXpath(this.getVideoFocusControls(), this.getVideoLeftSizingXpath())
	}

	@Keyword
	def clickVideoLeftSizing(){
	}

	@Keyword
	def dragVideoLeftSizingUp(){
	}

	/*Top Padding*/
	private String VideoTopPaddingXpath = '//span[contains(@class,"top-padding-container")]'

	String getVideoTopPaddingXpath(){
		return this.VideoTopPaddingXpath
	}

	WebElement getVideoTopPadding(){
		return brandcast.getChildElementByXpath(this.getVideoFocusControls(), this.getVideoTopPaddingXpath())
	}

	@Keyword
	def clickVideoTopPadding(){
	}

	@Keyword
	def dragVideoTopPaddingUp(){
	}

	/*Right Padding*/
	private String VideoRightPaddingXpath = '//span[contains(@class,"right-padding-container")]'

	String getVideoRightPaddingXpath(){
		return this.VideoRightPaddingXpath
	}

	WebElement getVideoRightPadding(){
		return brandcast.getChildElementByXpath(this.getVideoFocusControls(), this.getVideoRightPaddingXpath())
	}

	@Keyword
	def clickVideoRightPadding(){
	}

	@Keyword
	def dragVideoRightPaddingUp(){
	}

	/*Bottom Padding*/
	private String VideoBottomPaddingXpath = '//span[contains(@class,"bottom-padding-container")]'

	String getVideoBottomPaddingXpath(){
		return this.VideoBottomPaddingXpath
	}

	WebElement getVideoBottomPadding(){
		return brandcast.getChildElementByXpath(this.getVideoFocusControls(), this.getVideoBottomPaddingXpath())
	}

	@Keyword
	def clickVideoBottomPadding(){
	}

	@Keyword
	def dragVideoBottomPaddingUp(){
	}

	/*Left Padding*/
	private String VideoLeftPaddingXpath = '//span[contains(@class,"left-padding-container")]'

	String getVideoLeftPaddingXpath(){
		return this.VideoLeftPaddingXpath
	}

	WebElement getVideoLeftPadding(){
		return brandcast.getChildElementByXpath(this.getVideoFocusControls(), this.getVideoLeftPaddingXpath())
	}

	@Keyword
	def clickVideoLeftPadding(){
	}

	@Keyword
	def dragVideoLeftPaddingUp(){
	}

	/*Focus Link*/
	private String VideoFocusLinkXpath = '//span[contains(@class,"focus-link-container")]'

	String getVideoFocusLinkXpath(){
		return this.VideoFocusLinkXpath
	}

	WebElement getVideoFocusLink(){
		return brandcast.getChildElementByXpath(this.getVideoFocusControls(), this.getVideoFocusLinkXpath())
	}

	@Keyword
	def clickVideoFocusLink(){
	}

	/*Save As*/
	private String VideoSaveAsXpath = '//span[contains(@class,"save-as")]'

	String getVideoSaveAsXpath(){
		return this.VideoSaveAsXpath
	}

	WebElement getVideoSaveAs(){
		return brandcast.getChildElementByXpath(this.getVideoFocusControls(), this.getVideoSaveAsXpath())
	}

	@Keyword
	def clickVideoSaveAs(){
	}
}
