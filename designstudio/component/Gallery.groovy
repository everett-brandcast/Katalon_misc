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

public class Gallery {
	Core brandcast = new Core()
	Utils utils = new Utils()
	/* ==================================================================================================
	 *
	 * Gallery Component
	 *
	 */
	private String GalleryComponentXpath ='//span[contains(@class,"bc-site-content")]/div[contains(@data-radium,"true")]/div[contains(@class,"root") and contains(@class,"has-selections") and contains(@class,"outline-view")]/span/span/div[contains(@class,"inline") and contains(@data-radium,"true")]/div[contains(@class,"inline")]/span/div[contains(@data-schema-name,"Embed") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-type,"Embed") and contains(@class,"bc-embed-wrapper") and contains(@class,"component-wrapper") and contains(@class,"bc-center") and contains(@class,"focused") and contains(@class,"root-component") and contains(@data-radium,"true")]'

	String getGalleryComponentXpath(){
		return this.GalleryComponentXpath
	}

	WebElement getGalleryComponent(){
		return brandcast.getElementByXpath(this.getGalleryComponentXpath())
	}

	/*Gallery Focus Controls*/
	private String GalleryFocusControlsXpath = '//span[contains(@class,"focus-controls")]/div[contains(@class,"focus-controls-inner")]'

	String getGalleryFocusControlsXpath(){
		return this.GalleryFocusControlsXpath
	}

	WebElement getGalleryFocusControls(){
		return brandcast.getChildElementByXpath(this.getGalleryComponent(), this.getGalleryFocusControlsXpath())
	}

	/*Top Sizing*/
	private String GalleryTopSizingXpath = '//span[contains(@class,"top-sizing-container")]/span[contains(@class,"top-sizing-anchor-container")]/span[contains(@class,"anchor sizing")]/div[contains(@class,"focus-frame-info")]'

	String getGalleryTopSizingXpath(){
		return this.GalleryTopSizingXpath
	}

	WebElement getGalleryTopSizing(){
		return brandcast.getChildElementByXpath(this.getGalleryFocusControls(), this.getGalleryTopSizingXpath())
	}
	@Keyword
	def clickGalleryTopSizing(){
		this.getGalleryTopSizing().click()
	}


	/*Right Sizing*/
	private String GalleryRightSizingXpath = '//span[contains(@class,"right-sizing-container")]'

	String getGalleryRightSizingXpath(){
		return this.GalleryRightSizingXpath
	}

	WebElement getGalleryRightSizing(){
		return brandcast.getChildElementByXpath(this.getGalleryFocusControls(), this.getGalleryRightSizingXpath())
	}

	@Keyword
	def clickGalleryRightSizing(){
	}

	@Keyword
	def dragGalleryRightSizingUp(){
	}

	/*Bottom Sizing*/
	private String GalleryBottomSizingXpath = '//span[contains(@class,"bottom-sizing-container")]'

	String getGalleryBottomSizingXpath(){
		return this.GalleryBottomSizingXpath
	}

	WebElement getGalleryBottomSizing(){
		return brandcast.getChildElementByXpath(this.getGalleryFocusControls(), this.getGalleryBottomSizingXpath())
	}

	@Keyword
	def clickGalleryBottomSizing(){
	}

	@Keyword
	def dragGalleryBottomSizingUp(){
	}

	/*Left Sizing*/
	private String GalleryLeftSizingXpath = '//span[contains(@class,"left-sizing-container")]'

	String getGalleryLeftSizingXpath(){
		return this.GalleryLeftSizingXpath
	}

	WebElement getGalleryLeftSizing(){
		return brandcast.getChildElementByXpath(this.getGalleryFocusControls(), this.getGalleryLeftSizingXpath())
	}

	@Keyword
	def clickGalleryLeftSizing(){
	}

	@Keyword
	def dragGalleryLeftSizingUp(){
	}

	/*Top Padding*/
	private String GalleryTopPaddingXpath = '//span[contains(@class,"top-padding-container")]'

	String getGalleryTopPaddingXpath(){
		return this.GalleryTopPaddingXpath
	}

	WebElement getGalleryTopPadding(){
		return brandcast.getChildElementByXpath(this.getGalleryFocusControls(), this.getGalleryTopPaddingXpath())
	}

	@Keyword
	def clickGalleryTopPadding(){
	}

	@Keyword
	def dragGalleryTopPaddingUp(){
	}

	/*Right Padding*/
	private String GalleryRightPaddingXpath = '//span[contains(@class,"right-padding-container")]'

	String getGalleryRightPaddingXpath(){
		return this.GalleryRightPaddingXpath
	}

	WebElement getGalleryRightPadding(){
		return brandcast.getChildElementByXpath(this.getGalleryFocusControls(), this.getGalleryRightPaddingXpath())
	}

	@Keyword
	def clickGalleryRightPadding(){
	}

	@Keyword
	def dragGalleryRightPaddingUp(){
	}

	/*Bottom Padding*/
	private String GalleryBottomPaddingXpath = '//span[contains(@class,"bottom-padding-container")]'

	String getGalleryBottomPaddingXpath(){
		return this.GalleryBottomPaddingXpath
	}

	WebElement getGalleryBottomPadding(){
		return brandcast.getChildElementByXpath(this.getGalleryFocusControls(), this.getGalleryBottomPaddingXpath())
	}

	@Keyword
	def clickGalleryBottomPadding(){
	}

	@Keyword
	def dragGalleryBottomPaddingUp(){
	}

	/*Left Padding*/
	private String GalleryLeftPaddingXpath = '//span[contains(@class,"left-padding-container")]'

	String getGalleryLeftPaddingXpath(){
		return this.GalleryLeftPaddingXpath
	}

	WebElement getGalleryLeftPadding(){
		return brandcast.getChildElementByXpath(this.getGalleryFocusControls(), this.getGalleryLeftPaddingXpath())
	}

	@Keyword
	def clickGalleryLeftPadding(){
	}

	@Keyword
	def dragGalleryLeftPaddingUp(){
	}

	/*Focus Link*/
	private String GalleryFocusLinkXpath = '//span[contains(@class,"focus-link-container")]'

	String getGalleryFocusLinkXpath(){
		return this.GalleryFocusLinkXpath
	}

	WebElement getGalleryFocusLink(){
		return brandcast.getChildElementByXpath(this.getGalleryFocusControls(), this.getGalleryFocusLinkXpath())
	}

	@Keyword
	def clickGalleryFocusLink(){
	}

	/*Save As*/
	private String GallerySaveAsXpath = '//span[contains(@class,"save-as")]'

	String getGallerySaveAsXpath(){
		return this.GallerySaveAsXpath
	}

	WebElement getGallerySaveAs(){
		return brandcast.getChildElementByXpath(this.getGalleryFocusControls(), this.getGallerySaveAsXpath())
	}

	@Keyword
	def clickGallerySaveAs(){
	}
}
