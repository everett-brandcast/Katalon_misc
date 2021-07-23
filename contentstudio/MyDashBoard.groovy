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
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

/*Custom Keywords*/
import com.brandcast.Core
import com.brandcast.Utils


class MyDashBoard {
	Core brandcast = new Core()
	Utils utils = new Utils()


	String NewWebsiteName =  utils.getWebsiteName()
	/**
	 * 
	 * Admin Container
	 * 
	 */
	private String AdminContainerXpath = '//div[@class="admin-wrapper"]'

	String getAdminContainerXpath(){
		return this.AdminContainerXpath
	}

	WebElement getAdminContainer(){
		return brandcast.getElementByXpath(this.getAdminContainerXpath())
	}

	@Keyword
	def waitForAdminContainer(){
		brandcast.waitUntilPresenceOfElementLocatedBy(this.getAdminContainerXpath())
	}

	/**
	 * 
	 * Admin Container Left Rail
	 * 
	 */
	private AdminLeftRailXpath = '//div[@class="left-rail"]'

	String getAdminLeftRailXpath(){
		return this.AdminLeftRailXpath
	}

	WebElement getAdminLeftRail(){
		return brandcast.getChildElementByXpath(this.getAdminContainer(), this.getAdminLeftRailXpath())
	}
	/**
	 * 
	 * Admin Container Top Bar
	 * 
	 */
	private AdminTopBarXpath = '//div[@class="top-bar"]'

	String getAdminTopBarXpath(){
		return this.AdminTopBarXpath
	}

	WebElement getAdminTopBar(){
		return brandcast.getChildElementByXpath(this.getAdminContainer(), this.getAdminTopBarXpath())
	}

	/**
	 * 
	 * Profile Menu
	 */
	private String ProfileMenuXpath = '//div[@class="profile-menu-wrapper"]'

	String getProfileMenuXpath(){
		return this.ProfileMenuXpath
	}

	WebElement getProfileMenu(){
		return brandcast.getChildElementByXpath(this.getAdminTopBar(), this.getProfileMenuXpath())
	}

	@Keyword
	def clickProfileMenu(){
		return brandcast.clickChildWebElement(this.getAdminTopBar(), this.getProfileMenuXpath())
	}

	/**
	 * 
	 * Profile Context Menu
	 * 
	 */
	private String ProfileContextMenuXpath = '//div[contains(@class,"bc-menu-group") and contains(@class,"active")]/div[@class="menu-item"]'

	String getProfileContextMenuXpath(){
		return this.ProfileContextMenuXpath
	}

	WebElement getProfileContextMenu(){
		return brandcast.getElementByXpath(this.getProfileContextMenuXpath())
	}

	/**
	 * 
	 * Profile Context Menu Options
	 * 
	 */
	private String MenuOptionListXpath = '//div[contains(@class,"menu-dropdown") and contains(@class,"right")]/div[contains(@class,"ui-wrapper") and contains(@class,"btn-row-wrapper")]'

	private String MenuOptionXpath = '//div[@class="btn-row"]/div[@class="btn-row-label"]'

	String getMenuOptionListXpath(){
		return this.MenuOptionListXpath
	}

	String getMenuOptionXpath(){
		return this.MenuOptionXpath
	}


	List<WebElement> getMenuOptionList(){
		return brandcast.getElementListByXpath(this.getMenuOptionListXpath())
	}

	@Keyword
	def selectSwitchAccountMenuOption(){
		brandcast.clickListItem(this.getMenuOptionList(), "Switch Accounts")
	}

	@Keyword
	def selectLogOutMenuOption(){
		brandcast.clickListItem(this.getMenuOptionList(), "Log Out")
	}

	/**
	 * 
	 *  Admin Container Admin Content
	 */
	private AdminContentXpath = '//div[@class="admin-content"]'

	String getAdminContentXpath(){
		this.AdminContentXpath
	}

	WebElement getAdminContent(){
		return brandcast.getChildElementByXpath(this.getAdminContainer(), this.getAdminContentXpath())
	}

	/**
	 * 
	 * Left Rail Panel
	 * 
	 */
	private LeftPanelNewWebsiteButtonXpath = '//div[@class="content"]/div[@class="new-website-btn"]'

	String getLeftPanelNewWebsiteButtonXpath(){
		return this.LeftPanelNewWebsiteButtonXpath
	}

	WebElement getLeftPanelNewWebsiteButton(){
		return brandcast.getChildElementByXpath(this.getAdminLeftRail(), this.getLeftPanelNewWebsiteButtonXpath())
	}

	@Keyword
	def clickLeftPanelNewWebsiteButton(){
		this.getLeftPanelNewWebsiteButton().click()
	}

	/**
	 * 
	 * New Website Overlay
	 * 
	 */
	private String NewWebsiteOverlayXpath = '//div[@data-overlay-id="newwebsiteacontainer" and @class="bc-modal"]'

	String getNewWebsiteOverlayXpath(){
		return this.NewWebsiteOverlayXpath
	}

	WebElement getNewWebsiteOverlay(){
		return brandcast.getElementByXpath(this.getNewWebsiteOverlayXpath())
	}

	@Keyword
	def waitforNewWebsiteOverlay(){
		brandcast.waitUntilPresenceOfElementLocatedBy(this.getNewWebsiteOverlayXpath())
	}

	/**
	 * 
	 * New Website Overlay Content
	 * 
	 */
	private OverlayContentXpath ='//div[contains(@class,"bc-modal-wrapper") and contains(@class, "bc-modal-new-site") and contains(@class, "step-1")]'

	String getOverlayContentXpath(){
		return this.OverlayContentXpath
	}

	WebElement getOverlayContent(){
		return brandcast.getChildElementByXpath(this.getNewWebsiteOverlay(), this.getOverlayContentXpath())
	}

	/**
	 * 
	 * Website Grid Item List
	 * 
	 */
	private String WebsiteGridItemListXpath ='//div[contains(@class,"fl-box") and contains(@class,"col-wrapper")]/div[@class="fl-wrap"]/div[@class="fl-box bb"]/div[@class="fl-wrap-column"]/div[@class="fl-box dd"]/div[@class="scroll-box"]/div/div/div[@class="grid-block"]'

	String getWebsiteGridItemListXpath(){
		return this.WebsiteGridItemListXpath
	}

	WebElement getWebsiteGridItemList(){
		return brandcast.getChildElementByXpath(this.getOverlayContent(), this.getWebsiteGridItemListXpath())
	}

	/**
	 * 
	 * Blank Template Icon
	 * 
	 */
	private String BlankTemplateIconXpath = '//div[@class="new-blank-site-btn box"]/div[@class="box-thumbnail-wrapper"]/div[@class="box-thumbnail"]'

	String getBlankTemplateIconXpath(){
		return this.BlankTemplateIconXpath
	}

	WebElement getBlankTemplateIcon(){
		return brandcast.getChildElementByXpath(this.getWebsiteGridItemList(), getBlankTemplateIconXpath())
	}

	@Keyword
	def selectBlankTemplate(){
		brandcast.clickChildWebElement(this.getWebsiteGridItemList(), this.getBlankTemplateIconXpath())
	}

	/**
	 * 
	 * Create Website Modal
	 * 
	 */
	private String CreateWebsiteModalXpath = '//div[@data-overlay-id="newwebsiteacontainer"]/div[contains(@class,"bc-modal-wrapper") and contains(@class,"bc-modal-new-site step-2")]'

	String getCreateWebsiteModalXpath(){
		return this.CreateWebsiteModalXpath
	}

	WebElement getCreateWebsiteModal(){
		return brandcast.getElementByXpath(this.getCreateWebsiteModalXpath())
	}

	@Keyword
	def waitforCreateWebsiteModal(){
		brandcast.waitUntilPresenceOfElementLocatedBy(this.getCreateWebsiteModalXpath())
	}

	/**
	 * 
	 * 
	 * Create Website Modal Form
	 * 
	 */
	private String CreateWebsiteModalFormXpath ='//div[@class="fl-box b col-wrapper"]/form[@class="modal-contents"]'

	String getCreateWebsiteModalFormXpath(){
		return this.CreateWebsiteModalFormXpath
	}

	WebElement getCreateWebsiteModalForm(){
		return brandcast.getChildElementByXpath(this.getCreateWebsiteModal(), this.getCreateWebsiteModalFormXpath())
	}

	private CreateWebsiteNameIputXpath ='//div[@title="Website Name"]/div[@class="text-input-container"]/label/div[@class="text-input-wrapper"]/input[@name="name"]'

	String getCreateWebsiteNameIputXpath(){
		return this.CreateWebsiteNameIputXpath
	}

	WebElement getCreateWebsiteNameIput(){
		return brandcast.getChildElementByXpath(this.getCreateWebsiteModalForm(), this.getCreateWebsiteNameIputXpath())
	}
	@Keyword
	def sendWebsiteName(){
		brandcast.sendInput(this.getCreateWebsiteNameIput(), this.NewWebsiteName)
	}


	/**
	 * 
	 * 
	 * Create Website Button
	 * 
	 */
	private CreateWebsiteButtonXpath = '//div[@class="block-btns-wrapper"]/div[@class="block-btns"]/div[contains(@class, "ui-wrapper") and contains(@class, "primary")]'

	String getCreateWebsiteButtonXpath(){
		return this.CreateWebsiteButtonXpath
	}

	WebElement getCreateWebsiteButton(){
		return brandcast.getChildElementByXpath(this.getCreateWebsiteModalForm(), this.getCreateWebsiteButtonXpath())
	}

	@Keyword
	def clickCreateWebsiteButton(){
		brandcast.clickChildWebElement(this.getCreateWebsiteModalForm(), this.getCreateWebsiteButtonXpath())
	}
}