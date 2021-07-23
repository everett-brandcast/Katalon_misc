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
	private String AccountTemplatesXpath = './/div[@class="box"]'

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
	def clickGivenAccountTemplate(WebElement element){
		brandcast.clickWebElement(element)
	}

	@Keyword
	def moveToAccountTemplate(){
		return brandcast.moveToElementByWebElement(this.getAccountTemplateFromList())
	}

	@Keyword
	def moveToGivenAccountTemplate(WebElement element){
		return brandcast.moveToElementByWebElement(element)
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

	@Keyword
	def clickElementContexMenuButton(WebElement element){
		brandcast.clickChildWebElement(element, this.getContexMenuButtonXpath())
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

	WebElement getElementContexMenu(WebElement element){
		return brandcast.getChildElementByXpath(element, this.getContexMenuXpath())
	}

	@Keyword
	def clickElementContexMenu(WebElement element){
		brandcast.clickChildWebElement(this.getElementContexMenu(element), this.getContexMenuXpath())
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

	List<WebElement> getElementContextMenuOptions(WebElement element){
		return brandcast.getChildElementListByXpath(this.getElementContexMenu(element), this.getContextMenuOptionsXpath())
	}

	WebElement getElementMenuOption(WebElement element, String menuOption){
		for(WebElement listElement: this.getElementContextMenuOptions(element)){
			if(listElement.getText().contains(menuOption)){
				return listElement
			}
		}
	}

	@Keyword
	def getElementMenuOptionC = {WebElement element, String menuOption ->
		for(WebElement listElement: this.getElementContextMenuOptions(element)){
			if(listElement.getText().contains(menuOption)){
				return listElement
			}
		}
	}


	WebElement getMenuOption(String menuOption){
		for(WebElement element: this.getContextMenuOptions()){
			if(element.getText().contains(menuOption)){
				return element
			}
		}
	}

	@Keyword
	def clickDeleteMenuOption(){
		WebElement element = this.getMenuOption("Delete Template")
		brandcast.moveToElementByWebElement(element)
		element.click()
	}

	@Keyword
	def clickElementDeleteMenuOption(WebElement element){
		WebElement menuOption = this.getElementMenuOptionC(element,"Delete Template")
		brandcast.moveToElementByWebElement(menuOption)
		menuOption.click()
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

	@Keyword
	WebElement waitTemplateImportModalHeaderClose(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getTemplateImportModalHeader(), this.getTemplateImportModalHeaderCloseXpath())
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
	private String TemplateGridListXpath = './/div[contains(@class,"box")]/div[contains(@class,"box-details")]/div[contains(@class,"box-wrapper")]/div[contains(@class,"title-date")]'

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

	private String SelectedTemplateCheckBoxXpath = './/div[contains(@class,"item-selector")]/div[contains(@class,"check-box-container fl-box aa")]/div[contains(@class,"check-box")]'

	String getSelectedTemplateCheckBoxXpath(){
		return this.SelectedTemplateCheckBoxXpath
	}

	@Keyword
	def importTemplate(){
		for(WebElement template: this.getTemplateGridList()){
			if(template.findElement(By.xpath(this.getTemplateNameXpath())).getText().contains(this.getDefaultWebsiteTemplate())){
				template.findElement(By.xpath(this.getSelectedTemplateCheckBoxXpath())).click()
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

	/**
	 * Box Thumbnail
	 */
	private String BoxThumbnailXpath = '//div[contains(@class,"box-thumbnail-wrapper")]/div[contains(@class,"box-thumbnail")]'

	String getBoxThumbnailXpath(){
		return this.BoxThumbnailXpath
	}

	WebElement getBoxThumbnail(){
		return brandcast.getChildElementByXpath(this.getAccountTemplateFromList(),this.getBoxThumbnailXpath())
	}

	/**
	 * Box Action Use Template Button
	 */
	private String BoxActionUseTemplateButtonXpath = './/div[contains(@class,"box-action-ui")]/div[contains(@class,"centered-wrapper")]/div[contains(@class,"ui-wrapper box-btn")]/span/div[contains(@class,"btn-text")]/div[contains(@data-tutorial-id,"use-template-btn")]'

	String getBoxActionUseTemplateButtonXpath(){
		return this.BoxActionUseTemplateButtonXpath
	}

	WebElement getBoxActionUseTemplateButton(){
		return brandcast.getChildElementByXpath(this.getBoxThumbnail(), this.getBoxActionUseTemplateButtonXpath())
	}

	@Keyword
	def clickBoxActionUseTemplateButton(){
		brandcast.clickChildWebElement(this.getBoxThumbnail(), this.getBoxActionUseTemplateButtonXpath())
	}

	/**
	 * Box Action Website Menu Icon
	 */
	private String BoxActionWebsiteMenuIconXpath = './/div[contains(@class,"box-action-ui")]/div[contains(@class,"bc-menu-group website-menu light-theme")]/div[contains(@class,"menu-item") and contains(@data-identifier,"website-menu")]/div[contains(@title,"Website Menu") and contains(@class,"btn-blank bullet-btn")]'

	String getBoxActionWebsiteMenuIconXpath(){
		return this.BoxActionWebsiteMenuIconXpath
	}

	WebElement getBoxActionWebsiteMenuIcon(){
		return brandcast.getChildElementByXpath(this.getBoxThumbnail(), this.getBoxActionWebsiteMenuIconXpath())
	}

	@Keyword
	def clickBoxActionWebsiteMenuIcon(){
		brandcast.clickChildWebElement(this.getBoxThumbnail(), this.getBoxActionWebsiteMenuIconXpath())
	}

	/**
	 * Box Action Website Menu Dropdown
	 */
	private String BoxActionWebsiteMenuDropdownXpath = './/div[contains(@class,"box-action-ui")]/div[contains(@class,"bc-menu-group website-menu light-theme")]/div[contains(@class,"menu-item") and contains(@data-identifier,"website-menu")]/div[contains(@class,"menu-dropdown")]'

	String getBoxActionWebsiteMenuDropdownXpath(){
		return this.BoxActionWebsiteMenuDropdownXpath
	}

	WebElement getBoxActionWebsiteMenuDropdown(){
		return brandcast.getChildElementByXpath(this.getBoxThumbnail(), this.getBoxActionWebsiteMenuDropdownXpath())
	}

	@Keyword
	def clickBoxActionWebsiteMenuDropdown(){
		brandcast.clickChildWebElement(this.getBoxThumbnail(), this.getBoxActionWebsiteMenuDropdownXpath())
	}

	/**
	 * Dropdown Option Add / Remove
	 */
	private String DropdownOptionAddRemoveXpath = './/div[contains(@class,"ui-wrapper btn-row-wrapper")]/div[contains(@class,"btn-row")]/div[contains(@class,"btn-row-label")]/h4[contains(text(),"Add / Remove Tags")]'

	String getDropdownOptionAddRemoveXpath(){
		return this.DropdownOptionAddRemoveXpath
	}

	WebElement getDropdownOptionAddRemove(){
		return brandcast.getChildElementByXpath(this.getBoxActionWebsiteMenuDropdown(),this.getDropdownOptionAddRemoveXpath())
	}

	@Keyword
	def clickDropdownOptionAddRemove(){
		brandcast.clickChildWebElement(this.getBoxActionWebsiteMenuDropdown(),this.getDropdownOptionAddRemoveXpath())
	}

	/**
	 * Dropdown Option Preview Template
	 */
	private String DropdownOptionPreviewTemplateXpath = './/div[contains(@class,"ui-wrapper btn-row-wrapper")]/div[contains(@class,"btn-row")]/div[contains(@class,"btn-row-label")]/h4[contains(text(),"Preview Template")]'

	String getDropdownOptionPreviewTemplateXpath(){
		return this.DropdownOptionPreviewTemplateXpath
	}

	WebElement getDropdownOptionPreviewTemplate(){
		return brandcast.getChildElementByXpath(this.getBoxActionWebsiteMenuDropdown(),this.getDropdownOptionPreviewTemplateXpath())
	}

	@Keyword
	def clickDropdownOptionPreviewTemplate(){
		brandcast.clickChildWebElement(this.getBoxActionWebsiteMenuDropdown(),this.getDropdownOptionPreviewTemplateXpath())
	}

	/**
	 * Dropdown Option Edit Template
	 */
	private String DropdownOptionEditTemplateXpath = './/div[contains(@class,"ui-wrapper btn-row-wrapper cs-permission-hide")]/div[contains(@class,"btn-row btn-row-link")]/a[contains(@class,"btn-row-label")]/h4[contains(text(),"Edit Template")]'

	String getDropdownOptionEditTemplateXpath(){
		return this.DropdownOptionEditTemplateXpath
	}

	WebElement getDropdownOptionEditTemplate(){
		return brandcast.getChildElementByXpath(this.getBoxActionWebsiteMenuDropdown(),this.getDropdownOptionEditTemplateXpath())
	}

	@Keyword
	def clickDropdownOptionEditTemplate(){
		brandcast.clickChildWebElement(this.getBoxActionWebsiteMenuDropdown(),this.getDropdownOptionEditTemplateXpath())
	}

	/**
	 * Dropdown Option Duplicate
	 */
	private String DropdownOptionDuplicateXpath = './/div[contains(@class,"ui-wrapper btn-row-wrapper")]/div[contains(@class,"btn-row")]/div[contains(@class,"btn-row-label")]/h4[contains(text(),"Duplicate")]'

	String getDropdownOptionDuplicateXpath(){
		return this.DropdownOptionDuplicateXpath
	}

	WebElement getDropdownOptionDuplicate(){
		return brandcast.getChildElementByXpath(this.getBoxActionWebsiteMenuDropdown(),this.getDropdownOptionDuplicateXpath())
	}

	@Keyword
	def clickDropdownOptionDuplicate(){
		brandcast.clickChildWebElement(this.getBoxActionWebsiteMenuDropdown(),this.getDropdownOptionDuplicateXpath())
	}

	/**
	 * Dropdown Option Settings
	 */
	private String DropdownOptionSettingsXpath = './/div[contains(@class,"ui-wrapper btn-row-wrapper")]/div[contains(@class,"btn-row")]/div[contains(@class,"btn-row-label")]/h4[contains(text(),"Settings")]'

	String getDropdownOptionSettingsXpath(){
		return this.DropdownOptionSettingsXpath
	}

	WebElement getDropdownOptionSettings(){
		return brandcast.getChildElementByXpath(this.getBoxActionWebsiteMenuDropdown(),this.getDropdownOptionSettingsXpath())
	}

	@Keyword
	def clickDropdownOptionSettings(){
		brandcast.clickChildWebElement(this.getBoxActionWebsiteMenuDropdown(),this.getDropdownOptionSettingsXpath())
	}

	/**
	 * Website Settings
	 **/
	private String WebsiteSettingsXpath = '//div[contains(@class,"window-area settings-window-area react-draggable react-draggable-dragging react-draggable-dragged") and contains(@data-tutorial-id,"WindowAreaWebsiteSettingsContainer") and contains(@data-overlay-id,"windowareawebsitesettingscontainer")]'

	String getWebsiteSettingsXpath(){
		return this.WebsiteSettingsXpath
	}

	WebElement getWebsiteSettings(){
		return brandcast.getElementByXpath(this.getWebsiteSettingsXpath())
	}


	/**
	 * Dropdown Option Delete Template
	 */
	private String DropdownOptionDeleteTemplateXpath = './/div[contains(@class,"ui-wrapper btn-row-wrapper")]/div[contains(@class,"btn-row")]/div[contains(@class,"btn-row-label")]/h4[contains(text(),"Settings")]'

	String getDropdownOptionDeleteTemplateXpath(){
		return this.DropdownOptionDeleteTemplateXpath
	}

	WebElement getDropdownOptionDeleteTemplate(){
		return brandcast.getChildElementByXpath(this.getBoxActionWebsiteMenuDropdown(),this.getDropdownOptionDeleteTemplateXpath())
	}

	@Keyword
	def clickDropdownOptionDeleteTemplate(){
		brandcast.clickChildWebElement(this.getBoxActionWebsiteMenuDropdown(),this.getDropdownOptionDeleteTemplateXpath())
	}

	/**=============================================================================================================
	 *
	 * Box Details
	 *
	 */
	private String BoxDetailsXpath = './/div[contains(@class,"box-details")]/div[contains(@class,"box-wrapper")]'

	String getBoxDetailsXpath(){
		return this.BoxDetailsXpath
	}

	@Keyword
	WebElement getBoxDetails(){
		return brandcast.getChildElementByXpath(this.getAccountTemplateFromList(), this.getBoxDetailsXpath())
	}

	/**=============================================================================================================
	 *
	 * Box Details
	 *
	 */
	private String BoxDetailTitleXpath = './/div[contains(@class,"title-date-wrap")]/div[contains(@class,"title-date")]/div[contains(@class,"swap-container clearfix fl-box aa")]/h5[contains(@class,"text-swap")]'

	String getBoxDetailTitleXpath(){
		return this.BoxDetailTitleXpath
	}

	@Keyword
	WebElement getgetBoxDetailTitle(){
		return brandcast.getChildElementByXpath(this.getBoxDetails(), this.getBoxDetailTitleXpath())
	}

	/**================================================================================================================
	 * 
	 * Box Detail Aux Info
	 */
	private String BoxDetailAuxInfoXpath = 'div[contains(@class,"box-aux-ui")]'

	String getBoxDetailAuxInfoXpath(){
		return this.BoxDetailAuxInfoXpath
	}

	@Keyword
	WebElement getBoxAuxInfo(){
		return brandcast.getChildElementByXpath(this.getBoxDetails(), this.getBoxDetailAuxInfoXpath())
	}

	/**================================================================================================================
	 *
	 * Box Detail Aux Context Menu
	 */
	private String BoxDetailContextMenuXpath = './/div[contains(@class,"box-analytics tags")]/div[contains(@class,"bc-menu-group analytics-menu type-tags light-theme")]/div[contains(@class,"menu-item")]'

	String getBoxDetailContextMenuXpath(){
		return this.BoxDetailContextMenuXpath
	}

	@Keyword
	WebElement getBoxDetailContextMenu(){
		return brandcast.getChildElementByXpath(this.getBoxAuxInfo(),this.getBoxDetailContextMenuXpath())
	}

	@Keyword
	def clickBoxDetailContextMenu(){
		brandcast.clickChildWebElement(this.getBoxAuxInfo(), this.getBoxDetailContextMenuXpath())
	}


	/**
	 * Box Detail Analytics Menu Button
	 */
	private String BoxDetailAnalyticsMenuButtonXpath = '//div[contains(@class,"box-analytics")]/div[contains(@class,"bc-menu-group analytics-menu light-theme")]/div[contains(@class,"menu-item") and contains(@data-identifier,"module-options")]/div[contains(@title,"Template Analytics") and contains(@class,"btn-blank analytics-menu-btn")]'

	String getBoxDetailAnalyticsMenuButtonXpath(){
		return this.BoxDetailAnalyticsMenuButtonXpath
	}

	@Keyword
	WebElement getBoxDetailAnalyticsMenuButton(){
		return brandcast.getChildElementByXpath(this.getBoxAuxInfo(), this.getBoxDetailAnalyticsMenuButtonXpath())
	}

	@Keyword
	def clickBoxDetailAnalyticsMenuButton(){
		brandcast.clickChildWebElement(this.getBoxAuxInfo(), this.getBoxDetailAnalyticsMenuButtonXpath())
	}

	/**
	 * Template Settings Container
	 **/

	private String TemplateSettingsContainerXpath ='//div[contains(@class,"window-area") and contains(@class,"settings-window-area") and contains(@data-tutorial-id,"WindowAreaWebsiteSettingsContainer") and contains(@data-overlay-id,"windowareawebsitesettingscontainer")]/div[contains(@class,"window-area-wrapper")]/div[contains(@class,"settings-container")]'

	String getTemplateSettingsContainerXpath(){
		return this.TemplateSettingsContainerXpath
	}

	@Keyword
	WebElement getTemplateSettingsContainer(){
		return brandcast.getElementByXpath(this.getTemplateSettingsContainerXpath())
	}

	/**
	 * Close Template Container
	 **/
	private String CloseTemplateContainerXpath = '//div[contains(@class,"close-container")]/div[contains(@class,"close")]'

	String getCloseTemplateContainerXpath(){
		return this.CloseTemplateContainerXpath
	}

	@Keyword
	WebElement getCloseTemplateContainer(){
		return brandcast.getChildElementByXpath(this.getTemplateSettingsContainer(), this.getCloseTemplateContainerXpath())
	}

	@Keyword
	WebElement clickCloseTemplateContainer(){
		brandcast.clickChildWebElement(this.getTemplateSettingsContainer(), this.getCloseTemplateContainerXpath())
	}


	@Keyword
	WebElement waitCloseTemplateContainer(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getTemplateSettingsContainer(), this.getCloseTemplateContainerXpath())
	}
	/**
	 * Template Container Buttons
	 **/
	private String TemplateContainerButtonsXpath = './/div[contains(@class,"col-a")]/div[contains(@class,"card-row-btns-container")]'

	String getTemplateContainerButtonsXpath(){
		return this.TemplateContainerButtonsXpath
	}

	@Keyword
	WebElement getTemplateContainerButtons(){
		return brandcast.getChildElementByXpath(this.getTemplateSettingsContainer(),this.getTemplateContainerButtonsXpath())
	}

	/**
	 * Template Setting Button General
	 **/
	private String TemplateSettingButtonGeneralXpath =  './/div[contains(@class,"ui-wrapper") and contains(@class, "full-width")]/span/div[contains(@class,"card-row-btn") and contains(@title,"General")]'

	String getTemplateSettingButtonGeneralXpath(){
		return this.TemplateSettingButtonGeneralXpath
	}

	@Keyword
	WebElement getTemplateSettingButtonGeneral(){
		return brandcast.getChildElementByXpath(this.getTemplateContainerButtons(),this.getTemplateSettingButtonGeneralXpath())
	}

	@Keyword
	WebElement clickTemplateSettingButtonGeneral(){
		brandcast.clickChildWebElement(this.getTemplateContainerButtons(),this.getTemplateSettingButtonGeneralXpath())
	}

	/**
	 * Template Setting Button Publishing
	 **/
	private String TemplateSettingButtonPublishingXpath = './/div[contains(@class,"ui-wrapper full-width")]/span/div[contains(@class,"card-row-btn") and contains(@title,"Publishing")]'

	String getTemplateSettingButtonPublishingXpath(){
		return this.TemplateSettingButtonPublishingXpath
	}

	@Keyword
	WebElement getTemplateSettingButtonPublishing(){
		return brandcast.getChildElementByXpath(this.getTemplateContainerButtons(),this.getTemplateSettingButtonPublishingXpath())
	}

	@Keyword
	WebElement clickTemplateSettingButtonPublishing(){
		brandcast.clickChildWebElement(this.getTemplateContainerButtons(),this.getTemplateSettingButtonPublishingXpath())
	}

	/**
	 * Template Setting Button Favicon
	 **/
	private String TemplateSettingButtonFaviconXpath =  './/div[contains(@class,"ui-wrapper full-width")]/span/div[contains(@class,"card-row-btn") and contains(@title,"Favicon")]'

	String getTemplateSettingButtonFaviconXpath(){
		return this.TemplateSettingButtonFaviconXpath
	}

	@Keyword
	WebElement getTemplateSettingButtonFavicon(){
		return brandcast.getChildElementByXpath(this.getTemplateContainerButtons(),this.getTemplateSettingButtonFaviconXpath())
	}

	@Keyword
	WebElement clickTemplateSettingButtonFavicon(){
		brandcast.clickChildWebElement(this.getTemplateContainerButtons(),this.getTemplateSettingButtonFaviconXpath())
	}

	@Keyword
	WebElement waitTemplateSettingButtonFavicon(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getTemplateContainerButtons(),this.getTemplateSettingButtonFaviconXpath())
	}

	/**
	 * Favicon Content
	 */
	private String FaviconContentXpath = './/div[contains(@class,"col-b")]/div[contains(@class,"panel full-width clearfix")]/div[contains(@class,"panel-body clearfix")]/div[contains(@class,"content")]/div[contains(@class,"image-uploader-container content white-theme favicon single")]/div[contains(@class,"upload-img-input")]/div[contains(@class,"ui-wrapper full-width")]/div[contains(@class,"image-uploader has-children single")]'


	String getFaviconContentXpath(){
		return this.FaviconContentXpath
	}

	@Keyword
	WebElement getFaviconContent(){
		return brandcast.getChildElementByXpath(this.getTemplateSettingsContainer(),this.getFaviconContentXpath())
	}

	@Keyword
	WebElement waitFaviconContent(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getTemplateSettingsContainer(),this.getFaviconContentXpath())
	}

	/**
	 * Favicon Image Uploader Drop Zone
	 */
	private String FaviconImageUploaderDropZoneXpath = '//div[contains(@class,"upload-item-container upload-input") and contains(@title,"Upload Image")]/div[contains(@class,"media-dropzone image-uploader-drop-zone") and contains(@data-drop-accepts-inside,"NATIVE_FILE ImageContent") and contains(@data-drop-type,"image")]'

	String getFaviconImageUploaderDropZoneXpath(){
		return this.FaviconImageUploaderDropZoneXpath
	}

	@Keyword
	WebElement getFaviconImageUploaderDropZone(){
		return brandcast.getChildElementByXpath(this.getFaviconContent(),this.getFaviconImageUploaderDropZoneXpath())
	}

	@Keyword
	WebElement clicFaviconImageUploaderDropZone(){
		brandcast.clickChildWebElement(this.getFaviconContent(),this.getFaviconImageUploaderDropZoneXpath())
	}

	@Keyword
	def clickEscapeButton(){
		brandcast.clickEscapeButton()
	}

	/**
	 * Favicon Image Uploader Drop Zone InputXpath
	 */
	private String FaviconImageUploaderDropZoneInputXpath ='.//input[contains(@class,"display-none") and contains(@type,"file")]'

	String getFaviconImageUploaderDropZoneInputXpath(){
		return this.FaviconImageUploaderDropZoneInputXpath
	}

	@Keyword
	WebElement getFaviconImageUploaderDropZoneInput(){
		return brandcast.getChildElementByXpath(this.getFaviconImageUploaderDropZone(),this.getFaviconImageUploaderDropZoneInputXpath())
	}




	/**
	 * TemplateSettingButtonSocialImageXpath
	 **/
	private String TemplateSettingButtonSocialImageXpath = './/div[contains(@class,"ui-wrapper full-width")]/span/div[contains(@class,"card-row-btn") and contains(@title,"Social Image")]'

	String getTemplateSettingButtonSocialImageXpath(){
		return this.TemplateSettingButtonSocialImageXpath
	}

	@Keyword
	WebElement getTemplateSettingButtonSocialImage(){
		return brandcast.getChildElementByXpath(this.getTemplateContainerButtons(),this.getTemplateSettingButtonSocialImageXpath())
	}

	@Keyword
	WebElement clickTemplateSettingButtonSocialImage(){
		brandcast.clickChildWebElement(this.getTemplateContainerButtons(),this.getTemplateSettingButtonSocialImageXpath())
	}

	@Keyword
	WebElement waitTemplateSettingButtonSocialImage(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getTemplateContainerButtons(),this.getTemplateSettingButtonSocialImageXpath())
	}
	/**
	 * Template Setting Button Password Protect
	 **/
	private String TemplateSettingButtonPasswordProtectXpath  = './/div[contains(@class,"ui-wrapper full-width")]/span/div[contains(@class,"card-row-btn") and contains(@title,"Password Protect")]'

	String getTemplateSettingButtonPasswordProtectXpath(){
		return this.TemplateSettingButtonPasswordProtectXpath
	}

	@Keyword
	WebElement getTemplateSettingButtonPasswordProtect(){
		return brandcast.getChildElementByXpath(this.getTemplateContainerButtons(),this.getTemplateSettingButtonPasswordProtectXpath())
	}

	@Keyword
	WebElement clickTemplateSettingButtonPasswordProtect(){
		brandcast.clickChildWebElement(this.getTemplateContainerButtons(),this.getTemplateSettingButtonPasswordProtectXpath())
	}

	@Keyword
	WebElement waitTemplateSettingButtonPasswordProtect(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getTemplateContainerButtons(),this.getTemplateSettingButtonPasswordProtectXpath())
	}

	//Password protect option
	private String PasswordProtectFormXpath = '//div[contains(@class,"col-b")]/div[contains(@class,"panel full-width clearfix")]/div[contains(@class,"panel-body clearfix")]/div[contains(@class,"content")]/form'

	String getPasswordProtectFormXpath(){
		return this.PasswordProtectFormXpath
	}

	@Keyword
	WebElement getPasswordProtectForm(){
		return brandcast.getChildElementByXpath(this.getTemplateSettingsContainer(),this.getPasswordProtectFormXpath())
	}

	@Keyword
	WebElement waitPasswordProtectForm(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getTemplateSettingsContainer(),this.getPasswordProtectFormXpath())
	}

	/**
	 * PasswordProtectionEnableCheckboxXpath
	 */
	private String PasswordProtectionEnableCheckboxXpath = './/div[contains(@class,"content")]/div[contains(@class,"left")]/div[contains(@class,"ui-wrapper right btn-style-e") and contains(@title,"Password Protection")]/div[contains(@class,"btn-text boolean")]/div[contains(@class,"boolean-container")]/div[contains(@class,"check-box-container")]/div[contains(@class,"check-box")]'

	String getPasswordProtectionEnableCheckboxXpath(){
		return this.PasswordProtectionEnableCheckboxXpath
	}

	@Keyword
	WebElement getPasswordProtectionEnableCheckbox(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getPasswordProtectForm(),this.getPasswordProtectionEnableCheckboxXpath())
	}

	@Keyword
	WebElement clickPasswordProtectionEnableCheckbox(){
		brandcast.clickChildWebElement(this.getPasswordProtectForm(),this.getPasswordProtectionEnableCheckboxXpath())
	}

	/**
	 * Password Protection Username Input
	 */
	private String PasswordProtectionUsernameInputXpath = './/div[contains(@class,"content website-pw")]/div[contains(@class,"ui-wrapper full-width size-B white-theme") and contains(@title,"Website Username")]/div[contains(@class,"text-input-container")]/label/div[contains(@class,"text-input-wrapper")]/input[contains(@name,"website_username") and contains(@type,"text") and contains(@autocomplete,"username") and contains(@class,"text-input") and contains(@data-qa-id,"website-username")]'

	String getPasswordProtectionUsernameInputXpath(){
		return this.PasswordProtectionUsernameInputXpath
	}

	@Keyword
	WebElement getPasswordProtectionUsernameInput(){
		brandcast.getChildElementByXpath(this.getPasswordProtectForm(),this.getPasswordProtectionUsernameInputXpath())
	}

	@Keyword
	WebElement sendPasswordProtectionUsernameInput(){
		brandcast.sendInput(this.getPasswordProtectionUsernameInput(),"c0ndorM4N")
	}


	/**
	 * Password Protection Password Input
	 */
	private String PasswordProtectionPasswordInputXpath = './/div[contains(@class,"content website-pw")]/div[contains(@class,"ui-wrapper full-width size-B white-theme") and contains(@title,"Website Password")]/div[contains(@class,"text-input-container")]/label/div[contains(@class,"text-input-wrapper")]/input[contains(@name,"website_password") and contains(@type,"password") and contains(@autocomplete,"new-password") and contains(@class,"text-input") and contains(@data-qa-id,"website-password")]'

	String getPasswordProtectionPasswordInputXpath(){
		return this.PasswordProtectionPasswordInputXpath
	}

	@Keyword
	WebElement getPasswordProtectionPasswordInput(){
		brandcast.getChildElementByXpath(this.getPasswordProtectForm(),this.getPasswordProtectionPasswordInputXpath())
	}

	@Keyword
	WebElement sendPasswordProtectionPasswordInput(){
		brandcast.sendInput(this.getPasswordProtectionPasswordInput(),"0Yx-98?ji")
	}

	/*Password Protection Save Button*/
	private String PasswordProtectionSaveButtonXpath = './/div[contains(@class,"content action-btns-wrapper closer")]/div[contains(@class,"ui-wrapper btn-style-d right")]/button[contains(@class,"btn-html") and contains(@type,"submit")]'

	String getPasswordProtectionSaveButtonXpath(){
		return this.PasswordProtectionSaveButtonXpath
	}

	@Keyword
	WebElement getPasswordProtectionSaveButton(){
		brandcast.getChildElementByXpath(this.getPasswordProtectForm(),this.getPasswordProtectionSaveButtonXpath())
	}

	@Keyword
	WebElement clickPasswordProtectionSaveButton(){
		brandcast.clickChildWebElement(this.getPasswordProtectForm(),this.getPasswordProtectionSaveButtonXpath())
	}

	/*Password Protection Cancel Button*/
	private String PasswordProtectionCancelButtonXpath = './/div[contains(@class,"content action-btns-wrapper closer")]/div[contains(@class,"ui-wrapper right btn-style-d invert")]/button[contains(@class,"btn-html") and contains(@type,"button")]'

	String getPasswordProtectionCancelButtonXpath(){
		return this.PasswordProtectionCancelButtonXpath
	}

	@Keyword
	WebElement getPasswordProtectionCancelButton(){
		brandcast.getChildElementByXpath(this.getPasswordProtectForm(),this.getPasswordProtectionCancelButtonXpath())
	}

	@Keyword
	WebElement clickPasswordProtectionCancelButton(){
		brandcast.clickChildWebElement(this.getPasswordProtectForm(),this.getPasswordProtectionCancelButtonXpath())
	}

	/*Password Protection Save Button Label*/
	private String PasswordProtectionSaveButtonLabelXpath = './/div[contains(@class,"content action-btns-wrapper closer")]/div[contains(@class,"ui-wrapper btn-style-d right")]/button[contains(@class,"btn-html") and contains(@type,"submit") and contains(@data-qa-id,"website-password-button")]/div[contains(@class,"btn-html-label")]'

	String getPasswordProtectionSaveButtonLabelXpath(){
		return this.PasswordProtectionSaveButtonLabelXpath
	}

	@Keyword
	WebElement getPasswordProtectionSaveButtonLabel(){
		brandcast.getChildElementByXpath(this.getPasswordProtectForm(),this.getPasswordProtectionSaveButtonLabelXpath())
	}

	/**---------------------------------------------------
	 * Template Setting Button SEO Settings
	 **/
	private String TemplateSettingButtonSEOSettingsXpath =  './/div[contains(@class,"ui-wrapper full-width")]/span/div[contains(@class,"card-row-btn") and contains(@title,"SEO Settings")]'

	String getTemplateSettingButtonSEOSettingsXpath(){
		return this.TemplateSettingButtonSEOSettingsXpath
	}

	@Keyword
	WebElement getTemplateSettingButtonSEOSettings(){
		return brandcast.getChildElementByXpath(this.getTemplateContainerButtons(),this.getTemplateSettingButtonSEOSettingsXpath())
	}

	@Keyword
	WebElement clickTemplateSettingButtonSEOSettings(){
		brandcast.clickChildWebElement(this.getTemplateContainerButtons(),this.getTemplateSettingButtonSEOSettingsXpath())
	}

	@Keyword
	WebElement waitTemplateSettingButtonSEOSettings(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getTemplateContainerButtons(),this.getTemplateSettingButtonSEOSettingsXpath())
	}

	private String SEOSettingsFormXpath = './/div[contains(@class,"col-b")]/div[contains(@class,"panel full-width clearfix")]/div[contains(@class,"panel-body clearfix")]/form'

	String getSEOSettingsFormXpath(){
		return this.SEOSettingsFormXpath
	}

	@Keyword
	WebElement getSEOSettingsForm(){
		return brandcast.getChildElementByXpath(this.getTemplateSettingsContainer(),this.getSEOSettingsFormXpath())
	}

	/*SEO Settings Website Indexing*/
	private String SEOSettingsWebsiteIndexingXpath = '//div[contains(@class,"content publishing-body")]/div[contains(@class,"content")]/div[contains(@class,"content row")]/div[contains(@class,"col b")]/div[contains(@class,"ui-wrapper btn-style-e right") and contains(@title,"Index Website")]/div[contains(@class,"btn-text boolean active")]/div[contains(@class,"boolean-container")]/div[contains(@class,"check-box-container")]/div[contains(@class,"check-box selected")]'

	String getSEOSettingsWebsiteIndexingXpath(){
		return this.SEOSettingsWebsiteIndexingXpath
	}

	@Keyword
	WebElement getSEOSettingsWebsiteIndexing(){
		return brandcast.getChildElementByXpath(this.getSEOSettingsForm(),this.getSEOSettingsWebsiteIndexingXpath())
	}

	/*SEO Settings Website Follow Links*/
	private String SEOSettingsWebsiteFollowLinksXpath = '//div[contains(@class,"content publishing-body")]/div[contains(@class,"content")]/div[contains(@class,"content row")]/div[contains(@class,"col b")]/div[contains(@class,"ui-wrapper btn-style-e right") and contains(@title,"Follow Website")]/div[contains(@class,"btn-text boolean active")]/div[contains(@class,"boolean-container")]/div[contains(@class,"check-box-container")]/div[contains(@class,"check-box selected")]'

	String getSEOSettingsWebsiteFollowLinksXpath(){
		return this.SEOSettingsWebsiteFollowLinksXpath
	}

	@Keyword
	WebElement getSEOSettingsWebsiteFollowLinks(){
		return brandcast.getChildElementByXpath(this.getSEOSettingsForm(),this.getSEOSettingsWebsiteFollowLinksXpath())
	}

	/*SEO Settings Website Follow Links*/
	private String SEOSettingsWebsiteLanuageXpath = '//div[contains(@class,"content row white-theme size-B")]/div[contains(@class,"ui-wrapper full-width no-side-pad size-B white-theme") and contains(@title,"HTML Lang Property")]//span/div[contains(@class,"select-input-container ")]/div[contains(@class,"Select is-searchable Select--single")]/div[contains(@class,"Select-control")]/span[contains(@class,"Select-multi-value-wrapper") and contains(@id,"react-select-2--value")]/div[contains(@class,"Select-input") and contains(@style,"display: inline-block;")]'


	String getSEOSettingsWebsiteLanuageXpath(){
		return this.SEOSettingsWebsiteLanuageXpath
	}

	@Keyword
	WebElement getSEOSettingsWebsiteLanuage(){
		return brandcast.getChildElementByXpath(this.getSEOSettingsForm(),this.getSEOSettingsWebsiteLanuageXpath())
	}

	@Keyword
	WebElement clickSEOSettingsWebsiteLanuage(){
		brandcast.clickChildWebElement(this.getSEOSettingsForm(),this.getSEOSettingsWebsiteLanuageXpath())
	}


	/*SEO Settings Website Lanuage Input*/
	private String SEOSettingsWebsiteLanuageInputXpath = '//div[contains(@class,"content publishing-body")]/div[contains(@class,"content")]/div[contains(@class,"content row white-theme size-B")]/div[contains(@class,"ui-wrapper full-width no-side-pad size-B white-theme") and contains(@title,"HTML Lang Property")]/span/div[contains(@class,"select-input-container ")]/div[contains(@class,"Select is-focused is-open is-searchable Select--single")]/div[contains(@class,"Select-menu-outer")]/div[contains(@class,"Select-menu") and contains(@id,"react-select-2--list") and contains(@role,"listbox") and contains(@tabindex,"-1")]'

	String getSEOSettingsWebsiteLanuageInputXpath(){
		return this.SEOSettingsWebsiteLanuageInputXpath
	}

	@Keyword
	WebElement getSEOSettingsWebsiteLanuageInput(){
		return brandcast.getChildElementByXpath(this.getSEOSettingsForm(),this.getSEOSettingsWebsiteLanuageInputXpath())
	}

	private String LanguageItemsXpath = '//*[contains(@class,"Select-option") and contains(@role,"option")]'

	String getLanguageItemsXpath(){
		return this.LanguageItemsXpath
	}

	@Keyword
	def setSEOSettingsWebsiteLanuageToEnglish(){
		List<WebElement> langList = brandcast.getChildElementListByXpath(this.getSEOSettingsWebsiteLanuageInput(), this.getLanguageItemsXpath())
		langList.find {
			if(it.getAttribute("innerHTML").toString() =~ "English") {
				KeywordUtil.logInfo("Item: "+it.getAttribute("innerHTML"))
				KeywordUtil.logInfo("Item: "+it.getAttribute("class"))
				it.click()
				return true
			}
		}

	}

	private String SEOSettingsWebsiteButtonsXpath = '//div[contains(@class,"content publishing-body")]/div[contains(@class,"content action-btns-wrapper closer")]'

	String getSEOSettingsWebsiteButtonsXpath() {
		return this.SEOSettingsWebsiteButtonsXpath
	}

	@Keyword
	WebElement getSEOSettingsWebsiteButtons(){
		return brandcast.getChildElementByXpath(this.getSEOSettingsForm(),this.getSEOSettingsWebsiteButtonsXpath())
	}

	/*save changes button*/
	private String SEOSettingsWebsiteSaveButtonXpath ='//div[contains(@class,"ui-wrapper right btn-style-d")]/button[contains(@class,"btn-html") and contains(@type,"submit")]'

	String getSEOSettingsWebsiteSaveButtonXpath(){
		return this.SEOSettingsWebsiteSaveButtonXpath
	}

	@Keyword
	WebElement getSEOSettingsWebsiteSaveButton(){
		return brandcast.getChildElementByXpath(this.getSEOSettingsWebsiteButtons(),this.getSEOSettingsWebsiteSaveButtonXpath())
	}

	@Keyword
	WebElement clickSEOSettingsWebsiteSaveButton(){
		brandcast.clickChildWebElement(this.getSEOSettingsWebsiteButtons(),this.getSEOSettingsWebsiteSaveButtonXpath())
	}

	private String SEOSettingsWebsiteSaveButtonlabelXpath ='//div[contains(@class,"btn-html-label")]'

	String getSEOSettingsWebsiteSaveButtonlabelXpath() {
		return this.SEOSettingsWebsiteSaveButtonlabelXpath
	}

	@Keyword
	WebElement getSEOSettingsWebsiteSaveButtonlabel(){
		brandcast.getChildElementByXpath(this.getSEOSettingsWebsiteSaveButton(),this.getSEOSettingsWebsiteSaveButtonlabelXpath())
	}

	/*cancel*/
	private String SEOSettingsWebsiteCancelButtonXpath ='//div[contains(@class,"ui-wrapper right btn-style-d invert")]/button[contains(@class,"btn-html") and contains(@type,"button")]'

	String getSEOSettingsWebsiteCancelButtonXpath() {
		return this.SEOSettingsWebsiteCancelButtonXpath
	}

	@Keyword
	WebElement getSEOSettingsWebsiteCancelButton(){
		return brandcast.getChildElementByXpath(this.getSEOSettingsWebsiteButtons(),this.getSEOSettingsWebsiteCancelButtonXpath())
	}

	@Keyword
	WebElement clickSEOSettingsWebsiteCancelButton(){
		brandcast.clickChildWebElement(this.getSEOSettingsWebsiteButtons(),this.getSEOSettingsWebsiteCancelButtonXpath())
	}

	/**------------------------------------------------------------------
	 * Template Setting Button Google Tag Manager
	 **/
	private String TemplateSettingButtonGoogleTagManagerXpath = './/div[contains(@class,"ui-wrapper full-width")]/span/div[contains(@class,"card-row-btn") and contains(@title,"Google Tag Manager") and contains(@data-identifier,"googleTagManager")]'

	String getTemplateSettingButtonGoogleTagManagerXpath(){
		return this.TemplateSettingButtonGoogleTagManagerXpath
	}

	@Keyword
	WebElement getTemplateSettingButtonGoogleTagManager(){
		return brandcast.getChildElementByXpath(this.getTemplateContainerButtons(),this.getTemplateSettingButtonGoogleTagManagerXpath())
	}

	@Keyword
	WebElement clickTemplateSettingButtonGoogleTagManager(){
		brandcast.clickChildWebElement(this.getTemplateContainerButtons(),this.getTemplateSettingButtonGoogleTagManagerXpath())
	}


	@Keyword
	WebElement waitTemplateSettingButtonGoogleTagManager(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getTemplateContainerButtons(),this.getTemplateSettingButtonGoogleTagManagerXpath())
	}

	private String GoogleTagManagerContentXpath = '//div[contains(@class,"col-b")]/div[contains(@class,"panel full-width clearfix")]/div[contains(@class,"panel-body clearfix")]/div[contains(@class,"content")]/form[contains(@autocomplete,"off") and contains(@class,"form-wrapper container")]'

	String getGoogleTagManagerContentXpath(){
		return this.GoogleTagManagerContentXpath
	}

	@Keyword
	WebElement getGoogleTagManagerForm(){
		return brandcast.getChildElementByXpath(this.getTemplateSettingsContainer(),this.getGoogleTagManagerContentXpath())
	}

	private String GoogleTagManagerTextAreaXpath = '//div[contains(@class,"content")]/div[contains(@class,"ui-wrapper full-width white-theme size-B") and contains(@title,"Paste code below")]/div[contains(@class,"text-input-container")]/div[contains(@class,"text-input-wrapper")]/textarea[contains(@name,"rawCodeSnippet") and contains(@class,"text-input")]'

	String getGoogleTagManagerTextAreaXpath(){
		return this.GoogleTagManagerTextAreaXpath
	}

	@Keyword
	WebElement getGoogleTagManagerTextArea(){
		return brandcast.getChildElementByXpath(this.getGoogleTagManagerForm(), this.getGoogleTagManagerTextAreaXpath())
	}

	def sendTagToGoogleTagManagerTextArea(){
		brandcast.sendInput(this.getGoogleTagManagerTextArea(), brandcast.getGoogleTagTestTag())
	}

	private String GoogleTagManagerButtonsXpath = '//div[contains(@class,"content action-btns-wrapper closer")]'

	String getGoogleTagManagerButtonsXpath(){
		return this.GoogleTagManagerButtonsXpath
	}

	@Keyword
	WebElement getGoogleTagManagerButtons(){
		return brandcast.getChildElementByXpath(this.getGoogleTagManagerForm(), this.getGoogleTagManagerButtonsXpath())
	}


	private String GoogleTagManagerSaveButtonXpath = '//div[contains(@class,"ui-wrapper right btn-style-d") and contains(@title,"Save Changes")]/button[contains(@class,"btn-html") and contains(@type,"submit")]'
	String getGoogleTagManagerSaveButtonXpath() {
		return this.GoogleTagManagerSaveButtonXpath
	}
	@Keyword
	WebElement getGoogleTagManagerSaveButton(){
		return brandcast.getChildElementByXpath(this.getGoogleTagManagerButtons(), this.getGoogleTagManagerSaveButtonXpath())
	}

	@Keyword
	WebElement clickGoogleTagManagerSaveButton(){
		brandcast.clickChildWebElement(this.getTemplateContainerButtons(),this.getGoogleTagManagerSaveButtonXpath())
	}

	private String GoogleTagManagerCancelButtonXpath = '//div[contains(@class,"ui-wrapper right btn-style-d invert")]/button[contains(@class,"btn-html") and contains(@type,"button")]'

	String getGoogleTagManagerCancelButtonXpath() {
		return this.GoogleTagManagerCancelButtonXpath
	}
	@Keyword
	WebElement getGoogleTagManagerCancelButton(){
		return brandcast.getChildElementByXpath(this.getGoogleTagManagerButtons(), this.getGoogleTagManagerCancelButtonXpath())
	}

	@Keyword
	WebElement clickGoogleTagManagerCancelButton(){
		brandcast.clickChildWebElement(this.getTemplateContainerButtons(),this.getGoogleTagManagerCancelButtonXpath())
	}



	/**==============================================================================================================================
	 * Template Setting Content Publishing Body
	 */
	private String TemplateSettingContentPublishingBodyXpath = './/div[contains(@class,"col-b")]/div[contains(@class,"panel full-width clearfix")]/div[contains(@class,"panel-body clearfix")]/div[contains(@class,"content publishing-body")]'

	String getTemplateSettingContentPublishingBodyXpath() {
		return this.TemplateSettingContentPublishingBodyXpath
	}

	@Keyword
	WebElement getTemplateSettingContentPublishingBody() {
		return brandcast.getChildElementByXpath(this.getTemplateSettingsContainer(), this.getTemplateSettingContentPublishingBodyXpath())
	}

	/**
	 * Template Settings Publish Website Button
	 **/
	private String TemplateSettingButtonPublishXpath =  '//div[contains(@class,"col b")]/div[contains(@class,"ui-wrapper right publish-website-btn white-loader btn-style-d single") and contains(@title,"Publish Website")]/span/div[contains(@class,"btn-text")]/div[contains(@data-tutorial-id,"publish-website-btn") and contains(@class,"btn-text-label")]'

	String getTemplateSettingButtonPublishXpath(){
		return this.TemplateSettingButtonPublishXpath
	}

	@Keyword
	WebElement getTemplateSettingButtonPublish(){
		return brandcast.getChildElementByXpath(this.getTemplateSettingContentPublishingBody(), this.getTemplateSettingButtonPublishXpath())
	}

	@Keyword
	WebElement clickTemplateSettingButtonPublish(){
		brandcast.clickChildWebElement(this.getTemplateSettingContentPublishingBody(), this.getTemplateSettingButtonPublishXpath())
	}

	/**
	 * Template Setting View Live Site Button
	 **/
	private String TemplateSettingButtonViewLiveSiteXpath =  '//div[contains(@class,"content row")]/div[contains(@class,"col b")]/div[contains(@class,"ui-wrapper right btn-style-d invert disabled") and contains(@title,"View Live Site")]/span/div[contains(@class,"btn-text")]/div[contains(@data-tutorial-id,"view-live-site-btn") and contains(@class,"btn-text-label")]'

	String getTemplateSettingButtonViewLiveSiteXpath(){
		return this.TemplateSettingButtonViewLiveSiteXpath
	}

	@Keyword
	WebElement getTemplateSettingButtonViewLiveSite(){
		return brandcast.getChildElementByXpath(this.getTemplateSettingContentPublishingBody(), this.getTemplateSettingButtonViewLiveSiteXpath())
	}

	@Keyword
	WebElement clickTemplateSettingButtonViewLiveSite(){
		brandcast.clickChildWebElement(this.getTemplateSettingContentPublishingBody(),this.getTemplateSettingButtonViewLiveSiteXpath())
	}


	/**
	 * Template Setting General Information Container
	 **/
	private String TemplateSettingGeneralInformationContainerXpath =  '//div[contains(@data-overlay-id,"generalinformationcontainer") and contains(@class,"bc-modal initial-publish-success")]/div[contains(@class,"bc-modal-wrapper")]/div[contains(@class,"container-clear modal-system")]'

	String getTemplateSettingGeneralInformationContainerXpath(){
		return this.TemplateSettingGeneralInformationContainerXpath
	}

	@Keyword
	WebElement getTemplateSettingGeneralInformationContainer(){
		return brandcast.getElementByXpath(this.getTemplateSettingGeneralInformationContainerXpath())
	}

	/**
	 * Window Area Website Settings Container
	 **/
	private String WindowAreaWebsiteSettingsContainerXpath = '//div[contains(@data-overlay-id,"generalinformationcontainer") and contains(@class,"bc-modal initial-publish-success")]/div[contains(@class,"bc-modal-wrapper")]'

	String getWindowAreaWebsiteSettingsContainerXpath(){
		return this.WindowAreaWebsiteSettingsContainerXpath
	}

	@Keyword
	WebElement getWindowAreaWebsiteSettingsContainer(){
		return brandcast.getElementByXpath(this.getWindowAreaWebsiteSettingsContainerXpath())
	}

	@Keyword
	WebElement waitWindowAreaWebsiteSettingsContainer(){
		brandcast.waitUntilPresenceOfElementLocatedBy(this.getWindowAreaWebsiteSettingsContainerXpath())
	}


	/**
	 * Publish Website Success Panel
	 **/
	private String ContentPublishingBodyXpath = './/div[contains(@class,"col-b")]/div[contains(@class,"panel full-width clearfix")]/div[contains(@class,"panel-body clearfix")]/div[contains(@class,"content publishing-body")]'

	String getContentPublishingBodyXpath(){
		return this.ContentPublishingBodyXpath
	}

	@Keyword
	WebElement getContentPublishingBody(){
		return brandcast.getChildElementByXpath(this.getWindowAreaWebsiteSettingsContainer(),this.getContentPublishingBodyXpath())
	}

	/**
	 * Publish Website Success Panel
	 **/
	private String PublishWebsiteSuccessPanelXpath = './/div[contains(@class,"container-clear modal-system")]'

	String getPublishWebsiteSuccessPanelXpath(){
		return this.PublishWebsiteSuccessPanelXpath
	}

	@Keyword
	WebElement getPublishWebsiteSuccessPanel(){
		return brandcast.getChildElementByXpath(this.getWindowAreaWebsiteSettingsContainer(),this.getPublishWebsiteSuccessPanelXpath())
	}

	/**
	 * Publish Website Success Panel Close Button
	 **/
	private String PublishWebsiteSuccessPanelCloseButtonXpath =  './/div[contains(@class,"close-container")]/div[contains(@class,"close")]'

	String getPublishWebsiteSuccessPanelCloseButtonXpath(){
		return this.PublishWebsiteSuccessPanelCloseButtonXpath
	}

	@Keyword
	WebElement clickPublishWebsiteSuccessPanelCloseButton(){
		brandcast.clickChildWebElement(this.getPublishWebsiteSuccessPanel(),this.getPublishWebsiteSuccessPanelCloseButtonXpath())
	}

	@Keyword
	WebElement getPublishWebsiteSuccessPanelCloseButton(){
		return brandcast.getChildElementByXpath(this.getPublishWebsiteSuccessPanel(),this.getPublishWebsiteSuccessPanelCloseButtonXpath())
	}

	/**
	 * Publish Website Success Panel Content
	 **/
	private String PublishWebsiteSuccessPanelContentXpath = './/div[contains(@class,"modal-content")]'

	String getPublishWebsiteSuccessPanelContentXpath(){
		return this.PublishWebsiteSuccessPanelContentXpath
	}

	@Keyword
	WebElement getPublishWebsiteSuccessPanelContent(){
		return brandcast.getChildElementByXpath(this.getPublishWebsiteSuccessPanel(),this.getPublishWebsiteSuccessPanelContentXpath())
	}

	/**
	 * Publish Website Success Panel Checkmark
	 **/
	private String PublishWebsiteSuccessPanelCheckmarkXpath = './/div[contains(@class,"icon-wrapper")]/div[contains(@class,"modal-icon-container")]/div[contains(@class,"svg-container")]/div[contains(@class,"svg-icon")]/svg/title'

	String getPublishWebsiteSuccessPanelCheckmarkXpath(){
		return this.PublishWebsiteSuccessPanelCheckmarkXpath
	}

	@Keyword
	WebElement getPublishWebsiteSuccessPanelCheckmark(){
		return brandcast.getChildElementByXpath(this.getPublishWebsiteSuccessPanelContent(),this.getPublishWebsiteSuccessPanelCheckmarkXpath())
	}


	/**
	 * Publish Website Update Panel
	 **/
	private String PublishWebsiteUpdatePanelXpath = '//div[contains(@class,"window-area") and contains(@class,"settings-window-area") and contains(@data-tutorial-id,"WindowAreaWebsiteSettingsContainer") and contains(@data-overlay-id,"windowareawebsitesettingscontainer")]/div[contains(@class,"window-area-wrapper")]/div[contains(@class,"settings-container")]'

	String getPublishWebsiteUpdatePanelXpath(){
		return this.PublishWebsiteUpdatePanelXpath
	}

	@Keyword
	WebElement getPublishWebsiteUpdatePanel(){
		return brandcast.getElementByXpath(this.getPublishWebsiteUpdatePanelXpath())
	}

	/**
	 * PublishUpdatePanelButtonCloseXpath
	 **/
	private String PublishUpdatePanelButtonCloseXpath = '//div[contains(@class,"close-container")]/div[contains(@class,"close")]'

	String getPublishUpdatePanelButtonCloseXpath(){
		return this.PublishUpdatePanelButtonCloseXpath
	}

	@Keyword
	WebElement getPublishUpdatePanelButtonClose(){
		return brandcast.getChildElementByXpath(this.getPublishWebsiteUpdatePanel(), this.getPublishUpdatePanelButtonCloseXpath())
	}

	@Keyword
	WebElement clickPublishUpdatePanelButtonClose(){
		brandcast.clickChildWebElement(this.getPublishWebsiteUpdatePanel(), this.getPublishUpdatePanelButtonCloseXpath())
	}

	/**
	 * Publishing Content Body
	 **/
	private String PublishingContentPublishingBodyXpath = './/div[@class="col-b"]/div[@class="panel full-width clearfix"]/div[@class="panel-body clearfix"]/div[@class="content publishing-body"]/div[@class="content row"]'

	String getPublishingContentPublishingBodyXpath(){
		return this.ContentPublishingBodyXpath
	}

	WebElement getPublishingContentPublishingBody(){
		return brandcast.getChildElementByXpath(this.getPublishWebsiteUpdatePanel(),this.getPublishingContentPublishingBodyXpath())
	}


	/**
	 * PublishedWebsiteStateColAXpath
	 **/
	private String PublishedWebsiteStateColAXpath = '//div[@class="content row"]/div[@class="col a"]/p'
	String getPublishedWebsiteStateColAXpath(){
		return this.PublishedWebsiteStateColAXpath
	}

	WebElement getPublishedWebsiteStateColA(){
		return brandcast.getChildElementByXpath(this.getPublishingContentPublishingBody(),this.getPublishedWebsiteStateColAXpath())
	}

	/**
	 * PublishedWebsiteStateColBXpath
	 **/
	private String PublishedWebsiteStateColBXpath = '//div[@class="content row"]/div[@class="col b"]/div[@class="ui-wrapper right publish-website-btn white-loader btn-style-d single published-site-state current"  and @title="Published"]/span/div[@class="btn-text"]/div[@data-tutorial-id="published-btn" and @class="btn-text-label"]'

	String getPublishedWebsiteStateColBXpath(){
		return this.PublishedWebsiteStateColBXpath
	}

	WebElement getPublishedWebsiteStateColB(){
		return brandcast.getChildElementByXpath(this.getPublishingContentPublishingBody(),this.getPublishedWebsiteStateColBXpath())
	}


	/**
	 * PublishedWebsiteViewLiveColAXpath
	 **/
	private String PublishedWebsiteViewLiveColAXpath  = './/div[@class="content row"]/div[@class="col a"]/p'

	String getPublishedWebsiteViewLiveColAXpath(){
		return this.PublishedWebsiteViewLiveColAXpath
	}

	WebElement getPublishedWebsiteViewLiveColA(){
		return brandcast.getChildElementByXpath(this.getPublishingContentPublishingBody(),this.getPublishedWebsiteViewLiveColAXpath())
	}


	/**
	 * PublishedWebsiteViewLiveBtnColBXpath
	 */
	private String PublishedWebsiteViewLiveBtnColBXpath  = './/div[@class="col b"]/div[@class="ui-wrapper right btn-style-d invert publish-mode current" and @title="View Live Site"]/a'

	String getPublishedWebsiteViewLiveBtnColBXpath(){
		return this.PublishedWebsiteViewLiveBtnColBXpath
	}

	WebElement getPublishedWebsiteViewLiveBtnColB(){
		return brandcast.getChildElementByXpath(this.getPublishingContentPublishingBody(),this.getPublishedWebsiteViewLiveBtnColBXpath())
	}


	/**
	 * PublishedWebsiteUnPublishColAXpath
	 */
	private String PublishedWebsiteUnPublishColAXpath  = './/div[@class="content row"]/div[@class="col a"]/p'

	String getPublishedWebsiteUnPublishColAXpath(){
		return this.PublishedWebsiteUnPublishColAXpath
	}

	WebElement getPublishedWebsiteUnPublishColA(){
		return brandcast.getChildElementByXpath(this.getPublishWebsiteUpdatePanel(),this.getPublishedWebsiteUnPublishColAXpath())
	}


	/**
	 * PublishedWebsiteUnPublishColBXpath
	 */
	private String PublishedWebsiteUnPublishColBXpath  = './/div[contains(@class,"col-b")]/div[contains(@class,"panel full-width clearfix")]/div[contains(@class,"panel-body clearfix")]/div[contains(@class,"content publishing-body")]'

	String getPublishedWebsiteUnPublishColBXpath(){
		return this.PublishedWebsiteUnPublishColBXpath
	}

	WebElement getPublishedWebsiteUnPublishColB(){
		return brandcast.getChildElementByXpath(this.getPublishWebsiteUpdatePanel(),this.getPublishedWebsiteUnPublishColBXpath())
	}

	/**
	 * Publish Update Panel Content
	 **/

	private String PublishUpdatePanelContentXpath = './/div[contains(@class,"panel full-width clearfix")]/div[contains(@class,"panel-body clearfix")]/div[contains(@class,"content publishing-body")]'

	String getPublishUpdatePanelContentXpath(){
		return this.PublishUpdatePanelContentXpath()
	}

	@Keyword
	WebElement getPublishUpdatePanelContent(){
		return brandcast.getChildElementByXpath(this.getPublishedWebsiteUnPublishColB(), this.getPublishUpdatePanelContentXpath())
	}

	/**
	 * Publish Update Panel Publish Button
	 **/
	private String PublishUpdatePanelButtonPublishXpath = './/div[contains(@class,"content row")]/div[contains(@class,"col b")]/div[contains(@class,"ui-wrapper") and contains(@class,"publish-website-btn") and contains(@class,"published-site-state") and contains(@title,"Published")]'

	String getPublishUpdatePanelButtonPublishXpath(){
		return this.PublishUpdatePanelButtonPublish
	}

	@Keyword
	WebElement getPublishUpdatePanelButtonPublish(){
		return brandcast.getChildElementByXpath(this.getPublishWebsiteUpdatePanel(), this.getPublishUpdatePanelButtonPublishXpath())
	}

	@Keyword
	WebElement clickPublishUpdatePanelButtonPublish(){
		brandcast.clickChildWebElement(this.getPublishWebsiteUpdatePanel(), this.getPublishUpdatePanelButtonPublishXpath())
	}

	/**
	 * Publish Update Panel View Button/link
	 **/
	private String PublishUpdatePanelButtonViewXpath = './/div[contains(@class,"content row")]/div[contains(@class,"col b")]/div[contains(@class,"ui-wrapper right btn-style-d invert publish-mode current") and contains(@title,"View Live Site")]/a'

	String getPublishUpdatePanelButtonViewXpath(){
		return this.PublishUpdatePanelButtonViewXpath
	}

	@Keyword
	WebElement getPublishUpdatePanelButtonView(){
		return brandcast.getChildElementByXpath(this.getPublishWebsiteUpdatePanel(), this.getPublishUpdatePanelButtonViewXpath())
	}

	@Keyword
	WebElement clickPublishUpdatePanelButtonView(){
		brandcast.clickChildWebElement(this.getPublishWebsiteUpdatePanel(), this.getPublishUpdatePanelButtonViewXpath())
	}

	@Keyword
	def waitForPublishUpdatePanelButtonView(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getPublishWebsiteUpdatePanel(), this.getPublishUpdatePanelButtonViewXpath())
	}

	/**
	 * Publish Update Panel Unpublish Button
	 **/
	private String PublishUpdatePanelButtonUnpublishXpath = './/div[contains(@class,"content row")]/div[contains(@class,"col b")]/div[contains(@class,"ui-wrapper right btn-style-d invert") and contains(@title,"Unpublish")]'

	String getPublishUpdatePanelButtonUnpublishXpath(){
		return this.PublishUpdatePanelButtonUnpublishXpath
	}

	@Keyword
	WebElement getPublishUpdatePanelButtonUnpublish(){
		return brandcast.getChildElementByXpath(this.getPublishedWebsiteUnPublishColB(), this.getPublishUpdatePanelButtonUnpublishXpath())
	}

	@Keyword
	WebElement clickPublishUpdatePanelButtonUnpublish(){
		brandcast.clickChildWebElement(this.getPublishedWebsiteUnPublishColB(), this.getPublishUpdatePanelButtonUnpublishXpath())
	}

	@Keyword
	def waitForPublishUpdatePanelButtonUnpublish(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getPublishWebsiteUpdatePanel(), this.getPublishUpdatePanelButtonUnpublish()())
	}

	def switchBackToParentTab(){
		brandcast.switchToParentTab()
	}
}
