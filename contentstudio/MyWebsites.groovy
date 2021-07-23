package com.contentstudio

/*Java*/
import java.awt.AWTException
import java.awt.Robot
import java.awt.event.InputEvent
import java.awt.event.KeyEvent
import javax.script.ScriptEngineManager
import javax.script.ScriptEngine

/*Katalon*/
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import internal.GlobalVariable as GlobalVariable


import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webui.exception.WebElementNotFoundException


/* Selenium */
import org.openqa.selenium.By
import org.openqa.selenium.By.ByXPath
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.Point
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

/*Custom Keywords*/
import com.brandcast.Core
import com.brandcast.Utils


public class MyWebsites {
	Core brandcast = new Core()
	Utils utils = new Utils()

	//My-Brandcast Admin Cotent
	private String MyBrandcastAdminCotentXpath =  '//div[@class="admin-content"]/div[@class="my-brandcast flex module-wrapper"]'

	String getMyBrandcastAdminCotentXpath(){
		return this.MyBrandcastAdminCotentXpath
	}

	@Keyword
	WebElement getMyBrandcastAdminCotent(){
		return brandcast.getElementByXpath(this.getMyBrandcastAdminCotentXpath())
	}

	//Website Dashboard Xpath
	private String WebsiteDashboardXpath =  '//div[@class="admin-content"]/div[@class="website-dashboard module-wrapper flex"]/div[@class="module b"]'

	String getWebsiteDashboardXpath(){
		return this.WebsiteDashboardXpath
	}

	@Keyword
	WebElement getWebsiteDashboard(){
		return brandcast.getElementByXpath(this.getWebsiteDashboardXpath())
	}

	//My-Brandcast Admin Cotent Module A
	private String MyBrandcastAdminCotentModuleAXpath = './/div[@class="module a"]/div[@class="mod-fl-wrap"]'

	String getMyBrandcastAdminCotentModuleAXpath(){
		return this.MyBrandcastAdminCotentModuleAXpath
	}

	@Keyword
	WebElement getMyBrandcastAdminCotentModuleA(){
		return brandcast.getChildElementByXpath(this.getMyBrandcastAdminCotent(), this.getMyBrandcastAdminCotentModuleAXpath())
	}

	//Website dashboard Website Header
	private String WebsiteDashboardHeaderXpath = './/div[@class="mod-fl-wrap"]/div[@class="mod-fl-box-header"]/div[@class="module-header"]'

	String getWebsiteDashboardHeaderXpath(){
		return this.WebsiteDashboardHeaderXpath
	}

	@Keyword
	WebElement getWebsiteDashboardHeader(){
		return brandcast.getChildElementByXpath(this.getWebsiteDashboard(), this.getWebsiteDashboardHeaderXpath())
	}

	//Website dashboard Website Title
	private String WebsiteDashboardTitleXpath = './/div[@class="module-title"]'

	String getWebsiteDashboardTitleXpath(){
		return this.WebsiteDashboardTitleXpath
	}

	@Keyword
	WebElement getWebsiteDashboardTitle(){
		return brandcast.getChildElementByXpath(this.getWebsiteDashboardHeader(), this.getWebsiteDashboardTitleXpath())
	}

	//Website Dashboard Website Title Module Title
	private String WebsiteDashboardWebsiteTitleModuleTitleXpath = './/h2[@class="module-title"]'

	String getWebsiteDashboardWebsiteTitleModuleTitleXpath(){
		return this.WebsiteDashboardWebsiteTitleModuleTitleXpath
	}

	@Keyword
	WebElement getWebsiteDashboardWebsiteTitleModuleTitle(){
		return brandcast.getChildElementByXpath(this.getWebsiteDashboardTitle(), this.getWebsiteDashboardWebsiteTitleModuleTitleXpath())
	}


	//Website Dashboard Website Title Module Description
	private String WebsiteDashboardWebsiteTitleModuleDescriptionXpath = './/p[@class="module-description"]'

	String getWebsiteDashboardWebsiteTitleModuleDescriptionXpath(){
		return this.WebsiteDashboardWebsiteTitleModuleDescriptionXpath
	}

	@Keyword
	WebElement getWebsiteDashboardWebsiteTitleModuleDescription(){
		return brandcast.getChildElementByXpath(this.getWebsiteDashboardTitle(), this.getWebsiteDashboardWebsiteTitleModuleDescriptionXpath())
	}


	//My-WebSites Module Header
	private String  MyWebSitesModuleHeaderXpath = './/div[@class="mod-fl-box-header"]/div[@class="module-header"]'

	String getMyWebSitesModuleHeaderXpath(){
		return this.MyWebSitesModuleHeaderXpath
	}

	@Keyword
	WebElement getMyWebSitesModuleHeader(){
		return brandcast.getChildElementByXpath(this.getMyBrandcastAdminCotentModuleA(), this.getMyWebSitesModuleHeaderXpath())
	}

	// Website Dash Module Button
	private String WebsiteDashModuleButtonXpath = './/div[@class="module-ui"]/span[@class="website-dash-ui-wrap"]'

	String getWebsiteDashModuleButtonXpath(){
		return this.WebsiteDashModuleButtonXpath
	}

	@Keyword
	WebElement getWebsiteDashModuleButton(){
		return brandcast.getChildElementByXpath(this.getWebsiteDashboardHeader(), this.getWebsiteDashModuleButtonXpath())

	}


	// Website Dash Module Setting Button
	private String WebsiteDashModuleSettingButtonXpath = './/div[@class="ui-wrapper module-btn"]'

	String getWebsiteDashModuleSettingButtonXpath(){
		return this.WebsiteDashModuleSettingButtonXpath
	}

	@Keyword
	WebElement getWebsiteDashModuleSettingButton(){
		return brandcast.getChildElementByXpath(this.getWebsiteDashboardHeader(), this.getWebsiteDashModuleSettingButtonXpath())
	}

	@Keyword
	WebElement clickWebsiteDashModuleSettingButton(){
		brandcast.clickChildWebElement(this.getWebsiteDashboardHeader(), this.getWebsiteDashModuleSettingButtonXpath())
	}

	@Keyword
	def waitForWebsiteDashModuleSettingButton(){
		brandcast.waitUntilPresenceOfElementLocatedBy(this.getWebsiteDashModuleSettingButtonXpath())
	}

	// Website Dash Module Publish Website Button
	private String WebsiteDashModulePublishWebsiteButtonXpath = './/div[@class="ui-wrapper primary-module-btn blue-loader"]'

	String getWebsiteDashModulePublishWebsiteButtonXpath(){
		return this.WebsiteDashModulePublishWebsiteButtonXpath
	}

	@Keyword
	WebElement getWebsiteDashModulePublishWebsiteButton(){
		return brandcast.getChildElementByXpath(this.getWebsiteDashboardHeader(), this.getWebsiteDashModulePublishWebsiteButtonXpath())
	}

	@Keyword
	WebElement clickWebsiteDashModulePublishWebsiteButton(){
		brandcast.clickChildWebElement(this.getWebsiteDashboardHeader(), this.getWebsiteDashModulePublishWebsiteButtonXpath())
	}

	@Keyword
	def waitForWebsiteDashModulePublishWebsiteButton(){
		brandcast.waitUntilPresenceOfElementLocatedBy(this.getWebsiteDashModulePublishWebsiteButtonXpath())
	}

	//Recent Websites
	private StringRecentWebsitesXpath = './/div[@class="mod-fl-box-children"]/div[@class="recent-websites"]'

	String getStringRecentWebsitesXpath(){
		return this.StringRecentWebsitesXpath
	}

	@Keyword
	WebElement getStringRecentWebsites(){
		return brandcast.getChildElementByXpath(this.getMyBrandcastAdminCotentModuleA(), this.getStringRecentWebsitesXpath())
	}

	//Recent Websites Featured Box
	private String RecentWebsitesFeaturedBoxXpath = './/div[@class="featured-box"]/div[@class="box"]'

	String getRecentWebsitesFeaturedBoxXpath(){
		return this.RecentWebsitesFeaturedBoxXpath
	}

	@Keyword
	WebElement getRecentWebsitesFeaturedBox(){
		return brandcast.getChildElementByXpath(this.getStringRecentWebsites(), this.getRecentWebsitesFeaturedBoxXpath())
	}


	//Recent Websites Featured Box Thumbnail
	private String RecentWebsitesFeaturedBoxThumbnailXpath = './/div[@class="box-thumbnail-wrapper"]/div[@class="box-thumbnail"]'

	String getRecentWebsitesFeaturedBoxThumbnailXpath(){
		return this.RecentWebsitesFeaturedBoxThumbnailXpath
	}

	@Keyword
	WebElement getRecentWebsitesFeaturedBoxThumbnail(){
		return brandcast.getChildElementByXpath(this.getRecentWebsitesFeaturedBox(), this.getRecentWebsitesFeaturedBoxThumbnailXpath())
	}

	//Recent Websites Featured Box Wrapper
	//private String RecentWebsitesFeaturedBoxWrapperXpath =  './/div[@class="box-action-ui"]'
	private String RecentWebsitesFeaturedBoxWrapperXpath =  './/div[@class="page-item-preview-wrapper white-loader"]/div[@class="page-item-thumbnail-bg"]'

	String getRecentWebsitesFeaturedBoxWrapperXpath(){
		return this.RecentWebsitesFeaturedBoxWrapperXpath
	}

	@Keyword
	WebElement getRecentWebsitesFeaturedBoxWrapper(){
		return brandcast.getChildElementByXpath(this.getRecentWebsitesFeaturedBoxThumbnail(), this.getRecentWebsitesFeaturedBoxWrapperXpath())
	}

	@Keyword
	WebElement clickRecentWebsitesFeaturedBoxWrapper(){
		brandcast.clickChildWebElement(this.getRecentWebsitesFeaturedBoxThumbnail(), this.getRecentWebsitesFeaturedBoxWrapperXpath())
	}

	// My-Website Recent Preview Wrapper
	private String MyWebsiteRecentPreviewWrapperXpath = './/div[@class="box-action-ui"]/div[@class="bc-menu-group creator-menu light-theme"]'

	String getMyWebsiteRecentPreviewWrapperXpath(){
		return this.MyWebsiteRecentPreviewWrapperXpath
	}

	@Keyword
	WebElement getMyWebsiteRecentPreviewWrapper(){
		return brandcast.getChildElementByXpath(this.getRecentWebsitesFeaturedBoxThumbnail(), this.getMyWebsiteRecentPreviewWrapperXpath())
	}


	// My-Website Recent Preview
	private String MyWebsiteRecentPreviewXpath = './/div[@class="box-action-ui"]/div[@class="bc-menu-group creator-menu light-theme"]/div[@class="menu-item"  and @data-identifier="creator-menu"]'

	String getMyWebsiteRecentPreviewXpath(){
		return this.MyWebsiteRecentPreviewXpath
	}

	@Keyword
	WebElement getMyWebsiteRecentPreview(){
		return brandcast.getChildElementByXpath(this.getRecentWebsitesFeaturedBoxThumbnail(), this.getMyWebsiteRecentPreviewXpath())
	}

	// My-Website Recent Preview Open
	private String MyWebsiteRecentPreviewOpenXpath = './/div[@class="box-action-ui"]/div[@class="centered-wrapper"]/div[@class="ui-wrapper box-btn"]/span/a[@class="btn-text"]'

	String getMyWebsiteRecentPreviewOpenXpath(){
		return this.MyWebsiteRecentPreviewOpenXpath
	}

	@Keyword
	WebElement getMyWebsiteRecentPreviewOpen(){
		return brandcast.getChildElementByXpath(this.getRecentWebsitesFeaturedBoxThumbnail(), this.getMyWebsiteRecentPreviewOpenXpath())
	}

	// My-Website Recent Preview Website Menu
	private String MyWebsiteRecentPreviewWebsiteMenuXpath = './/div[@class="box-action-ui"]/div[@class="bc-menu-group website-menu light-theme"]/div[@class="menu-item" and @data-identifier="website-menu"]/div[@title="Website Menu" and @class="btn-blank bullet-btn"]'

	String getMyWebsiteRecentPreviewWebsiteMenuXpath(){
		return this.MyWebsiteRecentPreviewWebsiteMenuXpath
	}

	@Keyword
	WebElement getMyWebsiteRecentPreviewWebsiteMenu(){
		return brandcast.getChildElementByXpath(this.getRecentWebsitesFeaturedBoxThumbnail(), this.getMyWebsiteRecentPreviewWebsiteMenuXpath())
	}

	// Website Settings Window
	private String WebsiteSettingsWindowXPath = '//span[@class="app-container hidden-launch dashboard app-ready logged-in login-complete"]/span/div[@class="overlays-wrapper overlay-bounds"]/div[@class="window-area settings-window-area react-draggable" and @data-tutorial-id="WindowAreaWebsiteSettingsContainer" and @data-overlay-id="windowareawebsitesettingscontainer"]'

	String getWebsiteSettingsWindowXPath(){
		return this.WebsiteSettingsWindowXPath
	}

	@Keyword
	WebElement getWebsiteSettingsWindow(){
		return brandcast.getElementByXpath(this.getWebsiteSettingsWindowXPath())
	}

	@Keyword
	def waitForWebsiteSettingsWindow(){
		brandcast.waitUntilPresenceOfElementLocatedBy(this.getWebsiteSettingsWindowXPath())
	}

	// Website Settings Window Close Container
	private String WebsiteSettingsWindowCloseContainerXPath = './/div[@class="close-container"]/div[@class="close"]'

	String getWebsiteSettingsWindowCloseContainerXPath(){
		return this.WebsiteSettingsWindowCloseContainerXPath
	}

	@Keyword
	WebElement getWebsiteSettingsWindowCloseContainer(){
		return brandcast.getChildElementByXpath(this.getWebsiteSettingsWindow(), this.getWebsiteSettingsWindowCloseContainerXPath())
	}

	@Keyword
	WebElement clickWebsiteSettingsWindowCloseContainer(){
		brandcast.clickChildWebElement(this.getWebsiteSettingsWindow(), this.getWebsiteSettingsWindowCloseContainerXPath())
	}

	// WebsiteSettingsWindow Module Title
	private String WebsiteSettingsWindowModuleTitleXpath = './/div[@class="heading-container"]/h2[@class="module-title"]'

	String getWebsiteSettingsWindowModuleTitleXpath(){
		return this.WebsiteSettingsWindowModuleTitleXpath
	}

	@Keyword
	WebElement getWebsiteSettingsWindowModuleTitle(){
		return brandcast.getChildElementByXpath(this.getWebsiteSettingsWindow(), this.getWebsiteSettingsWindowModuleTitleXpath())
	}

	// WebsiteSettingsWindow Module Description
	private String WebsiteSettingsWindowModuleDescriptionXpath = './/div[@class="heading-container"]/p[@class="module-description"]'

	String getWebsiteSettingsWindowModuleDescriptionXpath(){
		return this.WebsiteSettingsWindowModuleDescriptionXpath
	}

	@Keyword
	WebElement getWebsiteSettingsWindowModuleDescription(){
		return brandcast.getChildElementByXpath(this.getWebsiteSettingsWindow(), this.getWebsiteSettingsWindowModuleDescriptionXpath())
	}


	//Website Settings Card Row Buttons Container
	private String WebsiteSettingsCardRowbuttonsContainerXpath = './/div[@class="col-a"]/div[@class="card-row-btns-container"]'

	String getWebsiteSettingsCardRowbuttonsContainerXpath(){
		return this.WebsiteSettingsCardRowbuttonsContainerXpath
	}

	@Keyword
	WebElement getWebsiteSettingsCardRowbuttonsContainer(){
		return brandcast.getChildElementByXpath(this.getWebsiteSettingsWindow(), this.getWebsiteSettingsCardRowbuttonsContainerXpath())
	}

	// Card Row Button Options
	private String CardRowbuttonOptionsXpath = './/div[contains(@class,"ui-wrapper") and contains(@class, "full-width")]'

	String getCardRowbuttonOptionsXpath(){
		return this.CardRowbuttonOptionsXpath
	}

	@Keyword
	List <WebElement> getCardRowbuttonOptions(){
		return brandcast.getChildElementListByXpath(this.getWebsiteSettingsWindow(), this.getCardRowbuttonOptionsXpath())
	}

	// Website Settings Window Form Content
	private String WebsiteSettingsWindowFormContentXPath = './/div[@class="col-b"]/div[@class="panel full-width clearfix"]/div[@class="panel-body clearfix"]/form/div[@class="content clearfix"]'

	String getWebsiteSettingsWindowFormContentXPath(){
		return this.WebsiteSettingsWindowFormContentXPath
	}

	@Keyword
	WebElement getWebsiteSettingsWindowFormContent(){
		return brandcast.getChildElementByXpath(this.getWebsiteSettingsWindow(), this.getWebsiteSettingsWindowFormContentXPath())
	}

	@Keyword
	WebElement clickWebsiteSettingsWindowFormContent(){
		brandcast.clickChildWebElement(this.getWebsiteSettingsWindow(), this.getWebsiteSettingsWindowFormContentXPath())
	}
	

	// Website Settings Window Form Website Name
	//<span class="label-text">Website Name</span><span class="error-inline"><span class="error-message"></span></span>
	private String FormWebsiteNameXPath = './/div[@class="ui-wrapper full-width size-B white-theme" and @title="Website Name"]/div[@class="text-input-container"]/label/div[@class="text-input-wrapper"]/input[@name="name" and @type="text" and @class="text-input"]'

	String getFormWebsiteNameXPath(){
		return this.FormWebsiteNameXPath
	}

	@Keyword
	WebElement getFormWebsiteName(){
		return brandcast.getChildElementByXpath(this.getWebsiteSettingsWindowFormContent(), this.getFormWebsiteNameXPath())
	}

	@Keyword
	WebElement clickFormWebsiteNameXPath(){
		brandcast.clickChildWebElement(this.getWebsiteSettingsWindowFormContent(), this.getFormWebsiteNameXPath())
	}

	@Keyword
	String updatedWebsiteName = "Updated as of-"+utils.getTimeStamp()
	def sendFormWebsiteName(){
		brandcast.sendInput(this.getFormWebsiteName(), updatedWebsiteName)
	}


	// Website Settings Window Form Subdomain Name
	// <span class="label-text">Subdomain Name</span><span class="error-inline"><span class="error-message"></span></span>
	private String FormSubdomainNameXPath = './/div[@class="ui-wrapper full-width size-B white-theme inine-help-text" and @title="Subdomain Name"]/div[@class="text-input-container"]/label/div[@class="text-input-wrapper"]/input[@name="subdomain" and @type="text" and @class="text-input"]'

	String getFormSubdomainNameXPath(){
		return this.FormSubdomainNameXPath
	}

	@Keyword
	WebElement getFormSubdomainName(){
		return brandcast.getChildElementByXpath(this.getWebsiteSettingsWindowFormContent(), this.getFormSubdomainNameXPath())
	}

	@Keyword
	WebElement clickFormSubdomainName(){
		brandcast.clickChildWebElement(this.getWebsiteSettingsWindowFormContent(), this.getFormSubdomainNameXPath())
	}

	@Keyword
	String updatedSubdomainName = "updated-subdomain-asof-"+utils.getTimeStamp()
	def sendFormSubdomainName(){
		brandcast.sendInput(this.getFormSubdomainName(), updatedSubdomainName)
	}

	// Website Settings Window Form Custom Domain Name
	//<span class="label-text">Custom Domain Name</span><span class="error-inline"><span class="error-message"></span></span>

	private String FormCustomDomainNameXPath = './/div[@class="ui-wrapper full-width size-B white-theme inine-help-text" and @title="Custom Domain Name"]/div[@class="text-input-container"]/label/div[@class="text-input-wrapper"]/input[@name="custom_domain" and @type="text" and @class="text-input"]'

	String getFormCustomDomainNameXPath(){
		return this.FormCustomDomainNameXPath
	}

	@Keyword
	WebElement getFormCustomDomainName(){
		return brandcast.getChildElementByXpath(this.getWebsiteSettingsWindowFormContent(), this.getFormCustomDomainNameXPath())
	}

	@Keyword
	WebElement clickFormCustomDomainName(){
		brandcast.clickChildWebElement(this.getWebsiteSettingsWindowFormContent(), this.getFormCustomDomainNameXPath())
	}

	@Keyword
	String updatedCustomDomainName = "CustomDomainNameUpdated-"+utils.getTimeStamp()
	def sendFormCustomDomainName(){
		brandcast.sendInput(this.getFormCustomDomainName(), updatedCustomDomainName)
	}

	// Website Settings Window Form Website Description
	//span[@class="label-text">Website Description</span><span class="error-inline"><span class="error-message"></span></span>

	private String FormWebsiteDescriptionXPath = './/div[@class="ui-wrapper full-width size-B white-theme" and @title="Website Description"]/div[@class="text-input-container"]/label/div[@class="text-input-wrapper"]/textarea[@name="description" and @type="text" and @class="text-input"]'

	String getFormWebsiteDescriptionXPath(){
		return this.FormWebsiteDescriptionXPath
	}

	@Keyword
	WebElement getFormWebsiteDescription(){
		return brandcast.getChildElementByXpath(this.getWebsiteSettingsWindowFormContent(), this.getFormWebsiteDescriptionXPath())
	}
	
	@Keyword
	WebElement clickFormWebsiteDescription(){
		brandcast.clickChildWebElement(this.getWebsiteSettingsWindowFormContent(), this.getFormWebsiteDescriptionXPath())
	}

	@Keyword
	def sendFormWebsiteDescription(){
		brandcast.sendInput(this.getFormWebsiteDescription(), utils.getTodayDate())
	}

	// Website Settings Window Form Saved Button

	private String FormSavedButtonXPath = './/div[contains(@class,"content action-btns-wrapper closer")]/div[contains(@class,"ui-wrapper right btn-style-d")]/button[contains(@class,"btn-html") and contains(@type,"submit")]'

	String getFormSavedButtonXPath(){
		return this.FormSavedButtonXPath
	}

	@Keyword
	WebElement getFormSavedButton(){
		return brandcast.getChildElementByXpath(this.getWebsiteSettingsWindowFormContent(), this.getFormSavedButtonXPath())
	}

	@Keyword
	WebElement clickFormSavedButton(){
		brandcast.clickChildWebElement(this.getWebsiteSettingsWindowFormContent(), this.getFormSavedButtonXPath())
	}

	// Website Settings Window Form Cancel Button
	private String FormCancelButtonXPath = './/div[@class="content action-btns-wrapper closer"]/div[@class="ui-wrapper right btn-style-d invert"]/button[@class="btn-html" and @type="button"]'

	String getFormCancelButtonXPath(){
		return this.FormCancelButtonXPath
	}

	@Keyword
	WebElement getFormCancelButton(){
		return brandcast.getChildElementByXpath(this.getWebsiteSettingsWindowFormContent(), this.getFormCancelButtonXPath())
	}

	@Keyword
	WebElement clickFormCancelButton(){
		brandcast.clickChildWebElement(this.getWebsiteSettingsWindowFormContent(), this.getFormCancelButtonXPath())
	}

}
