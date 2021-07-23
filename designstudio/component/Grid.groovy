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

public class Grid {
	Core brandcast = new Core()
	Utils utils = new Utils()
	/* ==================================================================================================
	 *
	 * Grid Stage Component
	 *
	 */
	private GridStageComponentXpath = '//span[contains(@class,"bc-site-content")]/div[contains(@data-radium, "true")]/div[contains(@class,"root") and contains(@class,"has-selections") and contains(@class,"outline-view")]/span/span/div[contains(@class,"inline") and contains(@data-radium,"true")]/div[contains(@class,"inline")]/span/div[contains(@data-schema-name,"Grid") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-type,"Grid") and contains(@data-drop-accepts-inside,"NATIVE_FILE ImageContent VideoContent") and contains(@class,"bc-center") and contains(@class,"focused") and contains(@class,"root-component") and contains(@class,"bc-grid-wrapper") and contains(@data-radium,"true")]'


	String getGridStageComponentXpath(){
		return this.GridStageComponentXpath
	}

	WebElement getGridStageComponent(){
		return brandcast.getElementByXpath(this.getGridStageComponentXpath())
	}

	@Keyword
	def clickGridStageComponent(){
		brandcast.clickWebElement(this.getGridStageComponent())
	}

	/*Component info*/
	private String GridPaddingInfoXpath = './/div[@class="bc-grid padding-5 root-site-width" and @data-radium="true"]/div[@class="bc-grid-inner" and @data-radium="true"]/div[@class="bc-grid-columns" and @data-radium="true"]/div[contains(@class,"bc-column")]'

	String getGridPaddingInfoXpath(){
		return this.GridPaddingInfoXpath
	}

	WebElement getGridPaddingInfo(){
		return brandcast.getChildElementByXpath(this.getGridStageComponent(), this.getGridPaddingInfoXpath())
	}


	/* Grid Focus Controls */
	private String GridFocusControlsXpath = './/span[contains(@class,"focus-controls")]/div[contains(@class,"focus-controls-inner")]'

	String getGridFocusControlsXpath(){
		return this.GridFocusControlsXpath
	}

	WebElement getGridFocusControls(){
		return brandcast.getChildElementByXpath(this.getGridStageComponent(), this.getGridFocusControlsXpath())
	}

	/*Top Sizing*/
	private String GridTopSizingXpath = './/span[contains(@class,"top-sizing-container")]/span[contains(@class,"top-sizing-anchor-container")]/span[contains(@class,"anchor") and contains(@class, "sizing")]'

	String getGridTopSizingXpath(){
		return this.GridTopSizingXpath
	}

	WebElement getGridTopSizing(){
		return brandcast.getChildElementByXpath(this.getGridFocusControls(), this.getGridTopSizingXpath())
	}
	@Keyword
	def clickANdHoldGridTopSizing(){
		brandcast.clickAndHoldWebElememnt(this.getGridTopSizing())
	}

	@Keyword
	def dragTopSizing(Integer xOffSet, Integer yOffSet){
		brandcast.dragWebElementOffset(this.getGridTopSizing(), xOffSet, yOffSet)
	}

	/*Right Sizing*/
	private String GridRightSizingXpath = '//span[contains(@class,"right-sizing-container")]'

	String getGridRightSizingXpath(){
		return this.GridRightSizingXpath
	}

	WebElement getGridRightSizing(){
		return brandcast.getChildElementByXpath(this.getGridFocusControls(), this.getGridRightSizingXpath())
	}

	/*Bottom Sizing*/
	private String GridBottomSizingXpath = '//span[contains(@class,"bottom-sizing-container")]'

	String getGridBottomSizingXpath(){
		return this.GridBottomSizingXpath
	}

	WebElement getGridBottomSizing(){
		return brandcast.getChildElementByXpath(this.getGridFocusControls(), this.getGridBottomSizingXpath())
	}

	@Keyword
	def dragBottomSizing(Integer xOffSet, Integer yOffSet){
		brandcast.dragWebElementOffset(this.getGridBottomSizing(), xOffSet, yOffSet)
	}

	/*Left Sizing*/
	private String GridLeftSizingXpath = '//span[contains(@class,"left-sizing-container")]'

	String getGridLeftSizingXpath(){
		return this.GridLeftSizingXpath
	}

	WebElement getGridLeftSizing(){
		return brandcast.getChildElementByXpath(this.getGridFocusControls(), this.getGridLeftSizingXpath())
	}

	/*Top Padding*/
	private String GridTopPaddingXpath = './/span[contains(@class,"top-padding-container")]/span[contains(@class,"top-padding-anchor-container")]/span[contains(@class,"anchor") and contains(@class, "padding")]'
	private String PadBgHorizontalXpath = '//span[contains(@class,"top-padding-container")]/span[contains(@class,"pad-bg-horizontal")]'

	String getGridTopPaddingXpath(){
		return this.GridTopPaddingXpath
	}

	String getPadBgHorizontalXpath(){
		return this.PadBgHorizontalXpath
	}

	WebElement getGridTopPadding(){
		return brandcast.getChildElementByXpath(this.getGridFocusControls(), this.getGridTopPaddingXpath())
	}

	WebElement getPadBgHorizontal(){
		return brandcast.getChildElementByXpath(this.getGridFocusControls(), this.getPadBgHorizontalXpath())
	}
	@Keyword
	def dragGridTopPadding(Integer xOffSet, Integer yOffSet){
		brandcast.dragWebElementOffset(this.getGridTopPadding(), xOffSet, yOffSet)
	}



	/*Right Padding*/
	private String GridRightPaddingXpath = '//span[contains(@class,"right-padding-container")]'

	String getGridRightPaddingXpath(){
		return this.GridRightPaddingXpath
	}

	WebElement getGridRightPadding(){
		return brandcast.getChildElementByXpath(this.getGridFocusControls(), this.getGridRightPaddingXpath())
	}

	/*Bottom Padding*/
	private String GridBottomPaddingXpath = '//span[contains(@class,"bottom-padding-container")]'

	String getGridBottomPaddingXpath(){
		return this.GridBottomPaddingXpath
	}

	WebElement getGridBottomPadding(){
		return brandcast.getChildElementByXpath(this.getGridFocusControls(), this.getGridBottomPaddingXpath())
	}

	/*Left Padding*/
	private String GridLeftPaddingXpath = '//span[contains(@class,"left-padding-container")]'

	String getGridLeftPaddingXpath(){
		return this.GridLeftPaddingXpath
	}

	WebElement getGridLeftPadding(){
		return brandcast.getChildElementByXpath(this.getGridFocusControls(), this.getGridLeftPaddingXpath())
	}

	/*Grid Margins*/
	private String GridTopMarginContainerXpath = '//span[contains(@class,"top-margin-container")]/span[contains(@class,"margin-bg-horizontal")]'
	String getGridTopMarginContainerXpath(){
		return this.GridTopMarginContainerXpath
	}
	WebElement getGridTopMarginContainer(){
		return brandcast.getChildElementByXpath(this.getGridStageComponent(),this.getGridTopMarginContainerXpath())
	}

	private String GridRightMarginContainerXpath = '//span[contains(@class,"right-margin-container")]/span[contains(@class,"margin-bg-vertical")]'
	String getGridRightMarginContainerXpath(){
		return this.GridRightMarginContainerXpath
	}
	WebElement getGridRightMarginContainer(){
		return brandcast.getChildElementByXpath(this.getGridStageComponent(),this.getGridRightMarginContainerXpath())
	}

	private String GridBottomMarginContainerXpath = '//span[contains(@class,"bottom-margin-container")]/span[contains(@class,"margin-bg-horizontal")]'

	String getGridBottomMarginContainerXpath(){
		return this.GridBottomMarginContainerXpath
	}
	WebElement getGridBottomMarginContainer(){
		return brandcast.getChildElementByXpath(this.getGridStageComponent(),this.getGridBottomMarginContainerXpath())
	}

	private String GridLeftMarginContainerXpath = '/span[contains(@class, "left-margin-container")]/span[contains(@class, "margin-bg-vertical")]'

	String getGridLeftMarginContainerXpath(){
		return this.GridLeftMarginContainerXpath
	}
	WebElement getGridLeftMarginContainer(){
		return brandcast.getChildElementByXpath(this.getGridStageComponent(),this.getGridLeftMarginContainerXpath())
	}

	/*Focus Link*/
	private String GridFocusLinkXpath = '//span[contains(@class,"focus-link-container")]'

	String getGridFocusLinkXpath(){
		return this.GridFocusLinkXpath
	}

	WebElement getGridFocusLink(){
		return brandcast.getChildElementByXpath(this.getGridFocusControls(), this.getGridFocusLinkXpath())
	}

	@Keyword
	def clickGridFocusLink(){
	}

	/*Save As*/
	private String GridSaveAsXpath = '//span[contains(@class,"save-as")]'

	String getGridSaveAsXpath(){
		return this.GridSaveAsXpath
	}

	WebElement getGridSaveAs(){
		return brandcast.getChildElementByXpath(this.getGridFocusControls(), this.getGridSaveAsXpath())
	}

	@Keyword
	def clickGridSaveAs(){
	}
}
