package com.contentstudio

/*Java*/
import java.awt.AWTException
import java.awt.Robot
import java.awt.event.InputEvent
import java.awt.event.KeyEvent
import java.util.List

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

public class MyTemplates {

	Core brandcast = new Core()
	Utils utils = new Utils()

	/**
	 * 
	 * Get New Website Name
	 * 
	 */
	private String NewWebsiteName =  utils.getWebsiteName()

	String getNewWebsiteName(){
		return this.NewWebsiteName
	}

	/**
	 * 
	 * Admin Wrapper
	 * 
	 */
	private TemplatePanelAdminContainerXpath = '//div[@class="admin-wrapper"]/div[@class="admin-content"]/div[contains(@class,"templates") and contains(@class, "flex") and contains(@class, "module-wrapper")]/div[@class="module"]/div[contains(@class,"fl-wrap") and contains(@class,"direction-column")]'

	String getTemplatePanelAdminContainerXpath(){
		return this.TemplatePanelAdminContainerXpath
	}

	WebElement getTemplatePanelAdminContainer(){
		return brandcast.getElementByXpath(this.getTemplatePanelAdminContainerXpath())
	}

	/**
	 * 
	 * Template Header
	 * 
	 */
	private String TemplatePanelHeaderXpath = './/div[@class="fl-row"]/div[@class="module-header-b"]'

	String getTemplatePanelHeaderXpath(){
		return this.TemplatePanelHeaderXpath
	}

	WebElement getTemplatePanelHeader(){
		return brandcast.getChildElementByXpath(this.getTemplatePanelAdminContainer(), this.getTemplatePanelHeaderXpath())
	}

	/**
	 * 
	 * Template Panel Content
	 * 
	 */
	private String TemplatePanelContentXpath = './/div[contains(@class,"fl-row") and contains(@class,"module-b-contents")]/div[contains(@class,"col-wrapper")]'

	String getTemplatePanelContentXpath(){
		return this.TemplatePanelContentXpath
	}

	WebElement getTemplatePanelContent(){
		return brandcast.getChildElementByXpath(this.getTemplatePanelAdminContainer(), this.getTemplatePanelContentXpath())
	}

	/**
	 * 
	 * 
	 * Template Panel Sidebar
	 * 
	 * 
	 */
	private String TemplatePanelSideBarXpath = './/div[@class="side-bar"]'

	String getTemplatePanelSideBarXpath(){
		return this.TemplatePanelSideBarXpath
	}

	WebElement getTemplatePanelSideBar(){
		return brandcast.getChildElementByXpath(this.getTemplatePanelAdminContainer(), this.getTemplatePanelSideBarXpath())
	}

	/**
	 * 
	 * 
	 * Template Panel Content Area B
	 * 
	 * 
	 */
	private String TemplatePanelContentAreaBXpath = './/div[@class="content-area-b"]/div[@class="main-wrapper"]'

	String getTemplatePanelContentAreaBXpath(){
		return this.TemplatePanelContentAreaBXpath
	}

	WebElement getTemplatePanelContentAreaB(){
		return brandcast.getChildElementByXpath(this.getTemplatePanelAdminContainer(), this.getTemplatePanelContentAreaBXpath())
	}

	/**
	 * 
	 *  
	 *  Accounts Templates
	 * 
	 */
	private String AccountTemplateGridXpath = './/div[contains(@class,"account-templates")]/div/div/div[contains(@class,"virtualized-grid")]'

	String getAccountTemplateGridXpath(){
		return this.AccountTemplateGridXpath
	}

	WebElement getAccountTemplateGrid(){
		return brandcast.getChildElementByXpath(this.getTemplatePanelContentAreaB(), this.getAccountTemplateGridXpath())
	}

	/**
	 * 
	 * Account Templates
	 * 
	 */
	private String AccountTemplatesXpath = './/div[contains(@class,"box")]'

	String getAccountTemplatesXpath(){
		return this.AccountTemplatesXpath
	}

	List<WebElement> getAccountTemplates(){
		return brandcast.getChildElementListByXpath(this.getAccountTemplateGrid(), this.getAccountTemplatesXpath())
	}

	WebElement getAccountTemplateFromList(){
		return brandcast.getWebElementFromListByText(this.getAccountTemplates(),"Studio 81")
	}

	@Keyword
	def clickAccountTemplate(){
		brandcast.clickWebElement(this.getAccountTemplateFromList())
	}

	@Keyword
	def moveToAccountTemplate(){
		return brandcast.moveToElementByWebElement(this.getAccountTemplateFromList())
	}


	WebElement getSelectedTemplate(){
		for(WebElement element : this.getSelectedAccountTemplates()){
			return element
			break
		}
	}


	/**
	 * 
	 * Use Template Button
	 * 
	 */
	private String UseTemplateButtonXpath = './/div[@class="box-thumbnail-wrapper"]/div[@class="box-thumbnail"]/div[@class="box-action-ui"]/div[@class="centered-wrapper"]/div[@class="ui-wrapper box-btn"]'

	String getUseTemplateButtonXpath(){
		return this.UseTemplateButtonXpath
	}

	WebElement getUseTemplateButton(){
		return brandcast.getChildElementByXpath(this.getSelectedTemplate(), this.getUseTemplateButtonXpath())
	}

	@Keyword
	def clickUseTemplateButton(){
		brandcast.clickChildWebElement(this.getSelectedTemplate(), this.getUseTemplateButtonXpath())
	}

	/**
	 *
	 * Context Menu Button
	 *
	 */
	private String ContexMenuButtonXpath = './/div[@class="box-thumbnail-wrapper"]/div[@class="box-thumbnail"]/div[@class="box-action-ui"]/div[contains(@class,"bc-menu-group") and contains(@class,"website-menu") and contains(@class,"light-theme")]/div[contains(@class,"menu-item") and contains(@data-identifier,"website-menu")]/div[@title="Website Menu"]'

	String getContexMenuButtonXpath(){
		return this.ContexMenuButtonXpath
	}

	WebElement getContexMenuButton(){
		return brandcast.getChildElementByXpath(this.getSelectedTemplate(), this.getContexMenuButtonXpath())
	}

	@Keyword
	def clickContexMenuButton(){
		brandcast.clickChildWebElement(this.getSelectedTemplate(), this.getContexMenuButtonXpath())
	}
	/**
	 * 
	 *  Context Menu Button
	 *  
	 *  
	 */
	private String ContexMenuXpath = './/div[@class="box-thumbnail-wrapper"]/div[@class="box-thumbnail"]/div[@class="box-action-ui"]/div[contains(@class,"bc-menu-group") and contains(@class,"website-menu") and contains(@class,"light-theme") and contains(@class, "active")]/div[@class="menu-item" and @data-identifier="website-menu"]/div[@class="menu-dropdown"]'

	String getContexMenuXpath(){
		return this.ContexMenuXpath
	}

	WebElement getContexMenu(){
		return brandcast.getChildElementByXpath(this.getAccountTemplateFromList(), this.getContexMenuXpath())
	}

	@Keyword
	def clickContexMenu(){
		brandcast.clickChildWebElement(this.getAccountTemplateFromList(), this.getContexMenuXpath())
	}

	/**
	 * 
	 * Context Menu Options
	 * 
	 */
	private getContextMenuOptionsXpath = '//div[contains(@class,"ui-wrapper") and contains(@class,"btn-row-wrapper")]/div[@class="btn-row"]'

	String getContextMenuOptionsXpath(){
		return this.getContextMenuOptionsXpath
	}

	List<WebElement> getContextMenuOptions(){
		return brandcast.getChildElementListByXpath(this.getContexMenu(), this.getContextMenuOptionsXpath())
	}

	WebElement getDeleteMenuOption(){
		for(WebElement element: this.getContextMenuOptions()){
			if(element.getText().contains("Delete Template")){
				return element
			}
		}
	}
	@Keyword
	def clickDeleteMenuOption(){
		brandcast.moveToElementByWebElement(this.getDeleteMenuOption())
		brandcast.clickWebElement(this.getDeleteMenuOption())
	}

	/**
	 * 
	 * Delete Container
	 * 
	 */
	private String DeleteWebsiteContainerXpath = '//div[contains(@class,"overlays-wrapper" ) and contains(@class, "overlay-bounds")]/div[@data-overlay-id="deletewebsiteconfirmationcontainer"]/div[@class="bc-modal-wrapper"]/div[contains(@class,"container-clear") and contains(@class,"modal-system")]'

	String getDeleteWebsiteContainerXpath(){
		return this.DeleteWebsiteContainerXpath
	}

	WebElement getDeleteWebsiteContainer(){
		return brandcast.getElementByXpath(this.getDeleteWebsiteContainerXpath())
	}

	@Keyword
	def waitForDeleteWebsiteContainer(){
		brandcast.waitUntilPresenceOfElementLocatedBy(this.getDeleteWebsiteContainerXpath())
	}

	private String DeleteWebsiteButtonXpath = '//div[contains(@class,"container-clear") and contains(@class,"modal-btns")]'

	String getDeleteWebsiteButtonXpath(){
		return this.DeleteWebsiteButtonXpath
	}

	WebElement getDeleteWebsiteButtons(){
		return brandcast.getChildElementByXpath(this.getDeleteWebsiteContainer(), this.getDeleteWebsiteButtonXpath())
	}

	private DeleteButtonXpath = '//div[contains(@class,"ui-wrapper") and contains(@class,"editor-style") and contains(@class,"primary")]/button[@data-qa-id="delete-website-button"]'

	String getDeleteButtonXpath(){
		return this.DeleteButtonXpath
	}

	WebElement getDeleteButton(){
		return brandcast.getChildElementByXpath(this.getDeleteWebsiteButtons(), this.getDeleteButtonXpath())
	}


	@Keyword
	def clickDeleteButton(){
		brandcast.clickChildWebElement(this.getDeleteWebsiteButtons(), this.getDeleteButtonXpath())
	}


	/**
	 * 
	 * New Website Container
	 * 
	 */
	private String NewWebsiteContainerXpath = '//div[contains(@class,"overlays-wrapper" ) and contains(@class, "overlay-bounds")]/div[@data-overlay-id="newwebsiteacontainer"]/div[contains(@class, "bc-modal-wrapper") and contains(@class, "bc-modal-new-site") and contains(@class, "step-2")]/div[contains(@class,"fl-box") and contains(@class,"b") and contains(@class,"col-wrapper")]'

	String getNewWebsiteContainerXpath(){
		return this.NewWebsiteContainerXpath
	}

	WebElement getNewWebsiteContainer(){
		return brandcast.getElementByXpath(this.getNewWebsiteContainerXpath())
	}

	@Keyword
	def waitForNewWebsiteContainer(){
		brandcast.waitUntilPresenceOfElementLocatedBy(this.getNewWebsiteContainerXpath())
	}

	/**
	 * 
	 * New Website Container Form
	 * 
	 */
	private String NewWebsiteContainerFormXpath = '//form[@class="modal-contents"]'

	String getNewWebsiteContainerFormXpath(){
		return this.NewWebsiteContainerFormXpath
	}

	WebElement getNewWebsiteContainerForm(){
		return brandcast.getChildElementByXpath(this.getNewWebsiteContainer(), this.getNewWebsiteContainerFormXpath())
	}

	/**
	 * 
	 * New WebSite Form
	 * 
	 */
	private String NewWebsiteNameInputXpath = '//div[@title="Website Name"]/div[@class="text-input-container"]/label/div[@class="text-input-wrapper"]/input'

	String getNewWebsiteNameInputXpath(){
		return this.NewWebsiteNameInputXpath
	}

	WebElement getNewWebsiteNameInput(){
		return brandcast.getChildElementByXpath(this.getNewWebsiteContainerForm(), this.getNewWebsiteNameInputXpath())
	}

	@Keyword
	def sendNewWebsiteName(){
		brandcast.sendInput(this.getNewWebsiteNameInput(), utils.getTemplateName())
	}

	/**
	 * 
	 * SubDomain Name Input
	 * 
	 */
	private String SubDomainNameInputXpath = '//div[@title="Subdomain Name"]/div[@class="text-input-container"]/label/div[@class="text-input-wrapper"]/input'

	String getSubDomainNameInputXpath(){
		return this.SubDomainNameInputXpath
	}

	WebElement getSubDomainNameInput(){
		return brandcast.getChildElementByXpath(this.getNewWebsiteContainerForm(), this.getSubDomainNameInputXpath())
	}

	/**
	 *
	 * New Website Cancel Button
	 *
	 */
	private String NewWebsiteCancelButtonXpath = 'div[@class="block-btns-wrapper"]/div[@class="block-btns"]/div[contains(@class,"ui-wrapper") and contains(@class, "editor-style") and contains(@class, "fl-auto")]'

	String getNewWebsiteCancelButtonXpath(){
		return this.NewWebsiteCancelButtonXpath
	}

	WebElement getNewWebsiteCancelButton(){
		return brandcast.getChildElementByXpath(this.getNewWebsiteContainerForm(), this.getNewWebsiteCancelButtonXpath())
	}

	/**
	 *
	 * New Website Create Button
	 *
	 */
	private String NewWebsiteCreateButtonXpath = 'div[@class="block-btns-wrapper"]/div[@class="block-btns"]/div[contains(@class,"ui-wrapper") and contains(@class, "editor-style") and contains(@class, "fl-auto primary")]'

	String getNewWebsiteCreateButtonXpath(){
		return this.NewWebsiteCreateButtonXpath
	}

	WebElement getNewWebsiteCreateButton(){
		return brandcast.getChildElementByXpath(this.getNewWebsiteContainerForm(), this.getNewWebsiteCreateButtonXpath())
	}

	@Keyword
	def clickNewWebsiteCreateButton(){
		brandcast.clickChildWebElement(this.getNewWebsiteContainerForm(), this.getNewWebsiteCreateButtonXpath())
	}

	/**
	 *
	 * Selected Account Templates
	 *
	 */
	private String SelectedAccountTemplatesXpath = './/div[contains(@class,"box") and contains(@class, "selected")]'

	String getSelectedAccountTemplatesXpath(){
		return this.SelectedAccountTemplatesXpath
	}

	List<WebElement> getSelectedAccountTemplates(){
		return brandcast.getChildElementListByXpath(this.getAccountTemplateGrid(), this.getSelectedAccountTemplatesXpath())
	}

	/**
	 * 
	 * Use Template Button
	 * 
	 */
	private String UseTemplateBtnXpath = '//div[@class="virtualized-grid"]/div[contains(@class, "box") and contains(@class, "selected")]/div[@class="box-thumbnail-wrapper"]/div[@class="box-thumbnail"]/div[@class="box-action-ui"]/div[@class="centered-wrapper"]/div[contains(@class,"ui-wrapper") and contains(@class, "box-btn")]/span/div[@class="btn-text"]/div[@class="ban-text-label"]'

	String getUseTemplateBtnXpath(){
		return this.UseTemplateBtnXpath
	}

	WebElement getUseTemplateBtn(){
		return brandcast.getChildElementByXpath(this.getAccountTemplateFromList(), this.getUseTemplateBtnXpath())
	}

	/**
	 * 
	 * 
	 * Account Template Details
	 * 
	 */
	private String AccountTemplateDetailsXpath = '//div[@class="box-details"]'

	String getAccountTemplateDetailsXpath(){
		return this.AccountTemplateDetailsXpath
	}

	WebElement getAccountTemplateDetails(){
		return brandcast.getChildElementByXpath(this.getAccountTemplateFromList(), this.getAccountTemplateDetailsXpath())
	}

	/**
	 * 
	 * Accoun Template Name
	 * 
	 */
	private String AccounTemplateNameXpath = '//div[@class="box-wrapper"]/div[@class="title-date-wrap"]/div[@class="title-date"]/div/h5'

	String getAccounTemplateNameXpath(){
		this.AccounTemplateNameXpath
	}

	WebElement getAccounTemplateName(){
		return brandcast.getChildElementByXpath(this.getAccountTemplateDetails(), this.getAccounTemplateNameXpath())
	}

	@Keyword
	def waitForTemplateTitle(){
		brandcast.waittextToBePresent(this.getAccounTemplateNameXpath(), "Studio 81")
	}

	/**
	 * 
	 * Template Header Import Link
	 * 
	 */
	//private String TemplatePanelHeaderImportLinkXpath = './/div[@class="import-ui"]'
	private String TemplatePanelHeaderImportLinkXpath = './/div[contains(@class,"import-ui") and contains(@class,"cs-permission-hide")]/div[contains(@class,"import") and contains(@class,"tooltip-parent")]'

	String getTemplatePanelHeaderImportLinkXpath(){
		return this.TemplatePanelHeaderImportLinkXpath
	}

	WebElement getTemplatePanelHeaderImportLink(){
		return brandcast.getChildElementByXpath(this.getTemplatePanelHeader(), this.getTemplatePanelHeaderImportLinkXpath())
	}

	@Keyword
	def clickTemplatePanelHeaderImportLink(){
		brandcast.clickChildWebElement(this.getTemplatePanelHeader(), this.getTemplatePanelHeaderImportLinkXpath())
	}

	/**
	 * 
	 * Template Import Modal
	 * 
	 */
	private String TemplateImportModalXpath = '//div[@class="bc-modal" and @data-overlay-id="importtemplatescontainer"]/div[contains(@class,"bc-modal-wrapper") and contains(@class, "add-to-wrapper")]'


	String getTemplateImportModalXpath(){
		return this.TemplateImportModalXpath
	}

	WebElement getTemplateImportModal(){
		return brandcast.getElementByXpath(this.getTemplateImportModalXpath())
	}

	/**
	 * 
	 * Template Import Modal Header
	 * 
	 */
	private String TemplateImportModalHeaderXpath = './/div[@class="fl-box a header-container"]'

	String getTemplateImportModalHeaderXpath(){
		return this.TemplateImportModalHeaderXpath
	}

	WebElement getTemplateImportModalHeader(){
		return brandcast.getChildElementByXpath(this.getTemplateImportModal(), this.getTemplateImportModalHeaderXpath())
	}

	/**
	 * 
	 * 
	 * Template Import Modal Header Close Button
	 * 
	 */
	private String TemplateImportModalHeaderCloseXpath = '//div[@class="wa-close-container"]'

	String getTemplateImportModalHeaderCloseXpath(){
		return this.TemplateImportModalHeaderCloseXpath
	}

	WebElement getTemplateImportModalHeaderClose(){
		return brandcast.getChildElementByXpath(this.getTemplateImportModalHeader(), this.getTemplateImportModalHeaderCloseXpath())
	}

	@Keyword
	def clickTemplateImportModalHeaderClose(){
		brandcast.clickChildWebElement(this.getTemplateImportModalHeader(), this.getTemplateImportModalHeaderCloseXpath())
	}

	/**
	 *
	 * Template Import Modal Content
	 *
	 */
	private String TemplateImportModalContentXpath = './/div[@class="fl-box b col-wrapper"]/div[@class="fl-wrap"]/div[@class="fl-box bb"]/div[@class="fl-wrap-column"]'

	String getTemplateImportModalContentXpath(){
		return this.TemplateImportModalContentXpath
	}

	WebElement getTemplateImportModalContent(){
		return brandcast.getChildElementByXpath(this.getTemplateImportModal(), this.getTemplateImportModalContentXpath())
	}

	/**
	 * 
	 * 
	 * Template Grid
	 * 
	 */
	private String TemplateGridXpath = '//div[@class="fl-box dd"]/div[@class="scroll-box"]/div[@class="grid-block"]/div[@class="virtualized-grid"]'

	String getTemplateGridXpath(){
		return this.TemplateGridXpath
	}

	WebElement getTemplateGrid(){
		return brandcast.getChildElementByXpath(this.getTemplateImportModal(), this.getTemplateGridXpath())
	}

	/**
	 * 
	 * Template Grid List
	 * 
	 */
	private String TemplateGridListXpath = '//div[@class="box"]/div[@class="box-details"]/div[@class="box-wrapper"]/div[@class="title-date"]'

	String getTemplateGridListXpath(){
		return this.TemplateGridListXpath
	}

	List<WebElement> getTemplateGridList(){
		return brandcast.getChildElementListByXpath(this.getTemplateGrid(), this.getTemplateGridListXpath())
	}

	/**
	 * 
	 * Template Name
	 * 
	 */
	private String TemplateNameXpath = './/h4'

	String getTemplateNameXpath(){
		return this.TemplateNameXpath
	}

	/**
	 * 
	 * Selected Template Box
	 * 
	 */
	private String SelectedTemplateBoxXpath = './/div[contains(@class,"box") and contains(@class,"selected")]'
	private String DefaultWebsiteTemplate = 'Studio 81'
	WebElement SelectedTemplateFromGrid = null
	String getSelectedTemplateBoxXpath(){
		return this.SelectedTemplateBoxXpath
	}

	WebElement getSelectedTemplateBox(){
		return brandcast.getChildElementByXpath(this.getTemplateGrid(), this.getTemplateGridXpath())
	}


	String getDefaultWebsiteTemplate(){
		return this.DefaultWebsiteTemplate
	}

	private String TemplateSelectorXpath = './/div[@class="item-selector"]/div[@class="check-box-container fl-box aa"]/div[@class="check-box"]'
	String getTemplateSelectorXpath(){
		return this.TemplateSelectorXpath
	}

	@Keyword
	def importTemplate(){
		for(WebElement template: this.getTemplateGridList()){
			if(template.findElement(By.xpath(this.getTemplateNameXpath())).getText().contains(this.getDefaultWebsiteTemplate())){
				brandcast.clickChildWebElement(template, this.getTemplateSelectorXpath())
			}
		}
	}

	/**
	 * 
	 * Template Import
	 * 
	 */
	private String TemplateImportProgressXpath = '//div[@class="notifications-container"]/span/div[contains(@class, "note-a-container") and contains(@class, "notification-note-a-leave") and contains(@class, "notification-note-a-leave-active")]'

	String getTemplateImportProgressXpath(){
		return this.TemplateImportProgressXpath
	}

	WebElement getTemplateImportProgress(){
		return brandcast.getElementByXpath(this.getTemplateImportProgressXpath())
	}

	@Keyword
	def waitForTemplateImportProgress(){
		brandcast.waitVisibilityOfElementLocatedBy(this.getTemplateImportProgressXpath())
	}
}
