package com.designstudio.component

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.brandcast.Core
import com.brandcast.Utils
import com.designstudio.DSStage
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


public class LinkList {
	Core brandcast = new Core()
	Utils utils = new Utils()
	DSStage dsstage = new DSStage()
	/* ==================================================================================================
	 *
	 * LinkList Stage Component
	 *
	 */
	private String LinkListStageComponentXpath = '//span[@class="bc-site-content"]/div[@data-radium="true"]/div[contains(@class,"root") and contains(@class,"disable-link") and contains(@class,"has-selections") and contains(@class,"is-master-page-empty") and contains(@class,"outline-view")]/span/span/div[contains(@class,"inline") and contains(@data-radium,"true")]/div[contains(@class,"inline")]/span/div[contains(@data-schema-name,"LinkTree") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-is-selected,"true") and contains(@data-drag-type,"LinkTree") and contains(@data-drop-accepts-around,"Container Grid Text Gallery LinkTree Embed Video Image SnippetContent Anchor ContentSnippet") and contains(@data-drop-accepts-inside,"NATIVE_FILE ImageContent VideoContent") and contains(@class,"bc-link-tree-wrapper") and contains(@class,"bc-link-tree-on-click") and contains(@class,"component-wrapper") and contains(@class,"bc-center") and contains(@class,"is-horizontal") and contains(@class,"affected-by-selection") and contains(@class,"empty") and contains(@class,"focused") and contains(@class,"root-component") and contains(@data-radium,"true")]'


	String getLinkListStageComponentXpath(){
		return this.LinkListStageComponentXpath
	}

	WebElement getLinkListStageComponent(){
		return brandcast.getChildElementByXpath(dsstage.getStageIframeBody(), this.getLinkListStageComponentXpath())
	}

	@Keyword
	def clickLinkListStageComponent(){
		brandcast.clickWebElement(this.getLinkListStageComponent())
	}

	/*Component info*/
	private String LinkListPaddingInfoXpath = './/div[@class="bc-grid padding-5 root-site-width" and @data-radium="true"]/div[@class="bc-grid-inner" and @data-radium="true"]/div[@class="bc-grid-columns" and @data-radium="true"]/div[contains(@class,"bc-column")]'

	String getLinkListPaddingInfoXpath(){
		return this.LinkListPaddingInfoXpath
	}

	WebElement getLinkListPaddingInfo(){
		return brandcast.getChildElementByXpath(this.getLinkListStageComponent(), this.getLinkListPaddingInfoXpath())
	}


	/* LinkList Focus Controls */
	private String LinkListFocusControlsXpath = './/span[contains(@class,"focus-controls")]/div[contains(@class,"focus-controls-inner")]'

	String getLinkListFocusControlsXpath(){
		return this.LinkListFocusControlsXpath
	}

	WebElement getLinkListFocusControls(){
		return brandcast.getChildElementByXpath(this.getLinkListStageComponent(), this.getLinkListFocusControlsXpath())
	}

	/*Top Sizing*/
	private String LinkListTopSizingXpath = '//span[contains(@class,"top-sizing-container")]/span[contains(@class,"top-sizing-anchor-container")]/span[contains(@class,"anchor") and contains(@class,"sizing")]'

	String getLinkListTopSizingXpath(){
		return this.LinkListTopSizingXpath
	}

	WebElement getLinkListTopSizing(){
		return brandcast.getChildElementByXpath(this.getLinkListFocusControls(), this.getLinkListTopSizingXpath())
	}
	@Keyword
	def clickANdHoldLinkListTopSizing(){
		brandcast.clickAndHoldWebElememnt(this.getLinkListTopSizing())
	}

	@Keyword
	def dragTopSizing(Integer xOffSet, Integer yOffSet){
		brandcast.dragWebElementOffset(this.getLinkListTopSizing(), xOffSet, yOffSet)
	}

	/*Right Sizing*/
	private String LinkListRightSizingXpath = '//span[contains(@class,"right-sizing-container")]/span[contains(@class,"right-sizing-anchor-container")]/span[contains(@class,"vert-align-container")]/span[contains(@class,"vert-align-middle")]/span[contains(@class,"anchor sizing")]'

	String getLinkListRightSizingXpath(){
		return this.LinkListRightSizingXpath
	}

	WebElement getLinkListRightSizing(){
		return brandcast.getChildElementByXpath(this.getLinkListFocusControls(), this.getLinkListRightSizingXpath())
	}

	/*Bottom Sizing*/
	private String LinkListBottomSizingXpath = '//span[contains(@class,"bottom-sizing-container")]/span[contains(@class,"bottom-sizing-anchor-container")]/span[contains(@class,"anchor sizing")]'

	String getLinkListBottomSizingXpath(){
		return this.LinkListBottomSizingXpath
	}

	WebElement getLinkListBottomSizing(){
		return brandcast.getChildElementByXpath(this.getLinkListFocusControls(), this.getLinkListBottomSizingXpath())
	}

	@Keyword
	def dragBottomSizing(Integer xOffSet, Integer yOffSet){
		brandcast.dragWebElementOffset(this.getLinkListBottomSizing(), xOffSet, yOffSet)
	}

	/*Left Sizing*/
	private String LinkListLeftSizingXpath = '//span[contains(@class,"left-sizing-container")]/span[contains(@class,"left-sizing-anchor-container")]/span[contains(@class,"vert-align-container")]/span[contains(@class,"vert-align-middle")]/span[contains(@class,"anchor sizing")]'

	String getLinkListLeftSizingXpath(){
		return this.LinkListLeftSizingXpath
	}

	WebElement getLinkListLeftSizing(){
		return brandcast.getChildElementByXpath(this.getLinkListFocusControls(), this.getLinkListLeftSizingXpath())
	}

	/*Top Padding*/
	private String LinkListTopPaddingXpath = '//span[contains(@class,"top-padding-container")]/span[contains(@class,"top-padding-anchor-container") and contains(@class,"anchor-line-wrapper")]/span[contains(@class,"anchor") and contains(@class,"padding")]'
	private String PadBgHorizontalXpath = '//span[contains(@class,"top-padding-container")]/span[contains(@class,"pad-bg-horizontal")]'

	String getLinkListTopPaddingXpath(){
		return this.LinkListTopPaddingXpath
	}

	String getPadBgHorizontalXpath(){
		return this.PadBgHorizontalXpath
	}

	WebElement getLinkListTopPadding(){
		return brandcast.getChildElementByXpath(this.getLinkListFocusControls(), this.getLinkListTopPaddingXpath())
	}

	WebElement getPadBgHorizontal(){
		return brandcast.getChildElementByXpath(this.getLinkListFocusControls(), this.getPadBgHorizontalXpath())
	}

	@Keyword
	def dragLinkListTopPadding(Integer xOffSet, Integer yOffSet){
		brandcast.dragWebElementOffset(this.getLinkListTopPadding(), xOffSet, yOffSet)
	}

	/*Right Padding*/
	private String LinkListRightPaddingXpath = '//span[contains(@class,"right-padding-container")]/span[contains(@class,"pad-bg-vertical")]/span[contains(@class,"right-padding-anchor-container") and contains(@class, "anchor-line-wrapper")]/span[contains(@class,"anchor") and contains(@class,"padding")]'

	String getLinkListRightPaddingXpath(){
		return this.LinkListRightPaddingXpath
	}

	WebElement getLinkListRightPadding(){
		return brandcast.getChildElementByXpath(this.getLinkListFocusControls(), this.getLinkListRightPaddingXpath())
	}

	/*Bottom Padding*/
	private String LinkListBottomPaddingXpath = '//span[contains(@class,"bottom-padding-container")]/span[contains(@class,"pad-bg-horizontal")]/span[contains(@class,"bottom-padding-anchor-container") and contains(@class,"anchor-line-wrapper")]/span[contains(@class,"anchor") and contains(@class,"padding")]'

	String getLinkListBottomPaddingXpath(){
		return this.LinkListBottomPaddingXpath
	}

	WebElement getLinkListBottomPadding(){
		return brandcast.getChildElementByXpath(this.getLinkListFocusControls(), this.getLinkListBottomPaddingXpath())
	}

	/*Left Padding*/
	private String LinkListLeftPaddingXpath = '//span[contains(@class,"left-padding-container")]/span[contains(@class,"pad-bg-vertical")]/span[contains(@class,"left-padding-anchor-container") and contains(@class,"anchor-line-wrapper")]/span[contains(@class,"anchor") and contains(@class,"padding")]'

	String getLinkListLeftPaddingXpath(){
		return this.LinkListLeftPaddingXpath
	}

	WebElement getLinkListLeftPadding(){
		return brandcast.getChildElementByXpath(this.getLinkListFocusControls(), this.getLinkListLeftPaddingXpath())
	}

	/*LinkList Margins*/
	private String LinkListTopMarginContainerXpath = '//span[contains(@class,"top-margin-container")]/span[contains(@class,"margin-bg-horizontal")]'
	String getLinkListTopMarginContainerXpath(){
		return this.LinkListTopMarginContainerXpath
	}
	WebElement getLinkListTopMarginContainer(){
		return brandcast.getChildElementByXpath(this.getLinkListStageComponent(),this.getLinkListTopMarginContainerXpath())
	}

	private String LinkListRightMarginContainerXpath = '//span[contains(@class,"right-margin-container")]/span[contains(@class,"margin-bg-vertical")]'
	String getLinkListRightMarginContainerXpath(){
		return this.LinkListRightMarginContainerXpath
	}
	WebElement getLinkListRightMarginContainer(){
		return brandcast.getChildElementByXpath(this.getLinkListStageComponent(),this.getLinkListRightMarginContainerXpath())
	}

	private String LinkListBottomMarginContainerXpath = '//span[contains(@class,"bottom-margin-container")]/span[contains(@class,"margin-bg-horizontal")]'

	String getLinkListBottomMarginContainerXpath(){
		return this.LinkListBottomMarginContainerXpath
	}
	WebElement getLinkListBottomMarginContainer(){
		return brandcast.getChildElementByXpath(this.getLinkListStageComponent(),this.getLinkListBottomMarginContainerXpath())
	}

	private String LinkListLeftMarginContainerXpath = '/span[contains(@class, "left-margin-container")]/span[contains(@class, "margin-bg-vertical")]'

	String getLinkListLeftMarginContainerXpath(){
		return this.LinkListLeftMarginContainerXpath
	}
	WebElement getLinkListLeftMarginContainer(){
		return brandcast.getChildElementByXpath(this.getLinkListStageComponent(),this.getLinkListLeftMarginContainerXpath())
	}

	/*Focus Link*/
	private String LinkListFocusLinkXpath = '//span[contains(@class,"focus-link-container")]'

	String getLinkListFocusLinkXpath(){
		return this.LinkListFocusLinkXpath
	}

	WebElement getLinkListFocusLink(){
		return brandcast.getChildElementByXpath(this.getLinkListFocusControls(), this.getLinkListFocusLinkXpath())
	}

	@Keyword
	def clickLinkListFocusLink(){
	}

	/*Save As*/
	private String LinkListSaveAsXpath = '//span[contains(@class,"save-as")]'

	String getLinkListSaveAsXpath(){
		return this.LinkListSaveAsXpath
	}

	WebElement getLinkListSaveAs(){
		return brandcast.getChildElementByXpath(this.getLinkListFocusControls(), this.getLinkListSaveAsXpath())
	}

	@Keyword
	def clickLinkListSaveAs(){
	}
}
