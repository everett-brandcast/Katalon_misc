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


class MyBrandcast {

	Core brandcast = new Core()
	Utils utils = new Utils()


	private String NewWebsiteName =  utils.getWebsiteName()

	String getNewWebsiteName(){
		return this.NewWebsiteName
	}

	@Keyword
	def waitForNewWebsiteTabText(String elementxpath){
		brandcast.waittextToBePresent(elementxpath, this.getNewWebsiteName())
	}

	/**=============================================================================================================
	 * 
	 * Admin Container
	 * 
	 */
	private String AdminContainerXpath = '//span[contains(@id,"app")and contains(@class, "design-studio-root")]/div/span[contains(@class,"app-container") and contains(@class,"hidden-launch") and contains(@class,"dashboard") and contains(@class,"app-ready") and contains(@class,"logged-in")]/div[@class="admin-wrapper"]'

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
	 *  Admin Container Admin Content
	 */
	private AdminContentXpath = './/div[@class="admin-content"]'

	String getAdminContentXpath(){
		this.AdminContentXpath
	}

	WebElement getAdminContent(){
		return brandcast.getChildElementByXpath(this.getAdminContainer(), this.getAdminContentXpath())
	}

	/**=============================================================================================================
	 *
	 * My Brandcast
	 */
	private String MyBrandcastXpath = './/div[contains(@class,"my-brandcast") and contains(@class,"flex") and contains(@class,"module-wrapper")]'

	String getMyBrandcastXpath(){
		this.MyBrandcastXpath
	}

	WebElement getMyBrandcast(){
		return brandcast.getChildElementByXpath(this.getAdminContent(), this.getMyBrandcastXpath())
	}

	/**=============================================================================================================
	 *
	 * My Brandcast Module A
	 *
	 */
	private String MyBrandcastModuleAXpath = './/div[@class="module a"]/div[@class="mod-fl-wrap"]'

	String getMyBrandcastModuleAXpath(){
		this.MyBrandcastModuleAXpath
	}

	WebElement getMyBrandcastModuleA(){
		return brandcast.getChildElementByXpath(this.getMyBrandcast(), this.getMyBrandcastModuleAXpath())
	}

	/**
	 * 
	 * My Brandcast Module A Header
	 * 
	 */
	private String MyBrandcastModuleAHeaderXpath = './/div[@class="mod-fl-box-header"]/div[@class="module-header"]'

	String getMyBrandcastModuleAHeaderXpath(){
		this.MyBrandcastModuleAHeaderXpath
	}

	WebElement getMyBrandcastModuleAHeader(){
		return brandcast.getChildElementByXpath(this.getAdminContent(), this.getMyBrandcastModuleAHeaderXpath())
	}

	@Keyword
	def waitForMyBrandcastModuleAHeader(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getAdminContent(), this.getMyBrandcastModuleAHeaderXpath())
	}

	/**
	 *
	 * View My Brandcast Button
	 *
	 */
	private String ViewMybrandcastButtonXpath = './/a[contains(@class,"my-brandcast")]'

	String getViewMybrandcastButtonXpath(){
		return this.ViewMybrandcastButtonXpath
	}

	WebElement getViewMybrandcastButton(){
		return brandcast.getChildElementByXpath(this.getAdminContainer(), this.getViewMybrandcastButtonXpath())
	}

	@Keyword
	def clickViewMybrandcastButton(){
		brandcast.clickChildWebElement(this.getAdminContainer(), this.getViewMybrandcastButtonXpath())
	}

	@Keyword
	def waitForViewMybrandcastButton(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getAdminContainer(), this.getViewMybrandcastButtonXpath())
	}


	/**
	 *
	 * View All Website Button
	 *
	 */
	private String ViewAllWebsiteButtonXpath = './/div[@class="module-ui"]/div[@class="ui-wrapper module-btn"]/span/a/div[@data-tutorial-id="view-all-websites-btn"]'

	String getViewAllWebsiteButtonXpath(){
		return this.ViewAllWebsiteButtonXpath
	}

	WebElement getViewAllWebsiteButton(){
		return brandcast.getChildElementByXpath(this.getMyBrandcastModuleAHeader(), this.getViewAllWebsiteButtonXpath())
	}

	@Keyword
	def clickViewAllWebsiteButton(){
		brandcast.clickChildWebElement(this.getMyBrandcastModuleAHeader(), this.getViewAllWebsiteButtonXpath())
	}

	@Keyword
	def waitForViewAllWebsiteButton(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getMyBrandcastModuleAHeader(), this.getViewAllWebsiteButtonXpath())
	}

	/**
	 *
	 * View All Template Button
	 *
	 */
	private String ViewAllTemplateButtonXpath = './/div[@class="module-ui"]/div[@class="ui-wrapper module-btn"]/span/a/div[@data-tutorial-id="view-all-templates-btn"]'

	String getViewAllTemplateButtonXpath(){
		return this.ViewAllTemplateButtonXpath
	}

	WebElement getViewAllTemplateButton(){
		return brandcast.getChildElementByXpath(this.getMyBrandcastModuleAHeader(), this.getViewAllTemplateButtonXpath())
	}

	@Keyword
	def clickViewAllTemplateButton(){
		brandcast.clickChildWebElement(this.getMyBrandcastModuleAHeader(), this.getViewAllTemplateButtonXpath())
	}

	@Keyword
	def scrollViewAllTemplateButton(){
		brandcast.scrollElementIntoView(this.getViewAllTemplateButton())
	}

	@Keyword
	def waitForViewAllTemplateButton(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getMyBrandcastModuleAHeader(), this.getViewAllTemplateButtonXpath())
	}

	/**
	 *
	 * View All Team Button
	 *
	 */
	private String ViewAllTeamButtonXpath = './/div[@class="module-ui"]/div[@class="ui-wrapper module-btn"]/span/a/div[@data-tutorial-id="view-team-btn"]'

	String getViewAllTeamButtonXpath(){
		return this.ViewAllTeamButtonXpath
	}

	WebElement getViewAllTeamButton(){
		return brandcast.getChildElementByXpath(this.getMyBrandcastModuleAHeader(), this.getViewAllTeamButtonXpath())
	}

	@Keyword
	def clickViewAllTeamButton(){
		brandcast.clickChildWebElement(this.getMyBrandcastModuleAHeader(), this.getViewAllTeamButtonXpath())
	}

	@Keyword
	def moveToViewAllTemplateButton(){
		brandcast.scrollElementIntoView(this.getViewAllTemplateButton())
	}

	@Keyword
	def waitForViewAllTeamButton(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getMyBrandcastModuleAHeader(), this.getViewAllTeamButtonXpath())
	}

	/**
	 *
	 * View All Blocks Button
	 *
	 */
	private String ViewAllBlocksButtonXpath = './/div[@class="module-ui"]/div[@class="ui-wrapper module-btn"]/span/a/div[@data-tutorial-id="view-all-blocks-btn"]'

	String getViewAllBlocksButtonXpath(){
		return this.ViewAllBlocksButtonXpath
	}

	WebElement getViewAllBlocksButton(){
		return brandcast.getChildElementByXpath(this.getMyBrandcastModuleAHeader(), this.getViewAllBlocksButtonXpath())
	}

	@Keyword
	def clickViewAllBlocksButton(){
		brandcast.clickChildWebElement(this.getMyBrandcastModuleAHeader(), this.getViewAllBlocksButtonXpath())
	}

	@Keyword
	def waitForViewAllBlocksButton(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getMyBrandcastModuleAHeader(), this.getViewAllBlocksButtonXpath())
	}

	/**
	 * 
	 * My Brandcast Module A Box Childern
	 * 
	 */
	private String MyBrandcastModuleABoxChildernXpath = './/div[@class="mod-fl-box-children"]'

	String getMyBrandcastModuleABoxChildernXpath(){
		this.MyBrandcastModuleABoxChildernXpath
	}

	WebElement getMyBrandcastModuleABoxChildern(){
		return brandcast.getChildElementByXpath(this.getAdminContent(), this.getMyBrandcastModuleABoxChildernXpath())
	}

	/**
	 * 
	 * Recent Website
	 * 
	 */
	private MyBrandcastRecentWebsiteXpath = './/div[@class="recent-websites"]'

	String getMyBrandcastRecentWebsiteXpath(){
		return this.MyBrandcastRecentWebsiteXpath
	}

	WebElement getMyBrandcastRecentWebsite(){
		return brandcast.getChildElementByXpath(this.getMyBrandcastModuleABoxChildern(), this.getMyBrandcastRecentWebsiteXpath())
	}
	/**=============================================================================================================
	 * 
	 * Module B
	 * 
	 */
	private String MyBrandcastModuleBXpath = './/div[contains(@class, "my-websites") and contains(@class, "flex") and contains(@class, "module-wrapper")]/div[@class="module"]/div[contains(@class, "fl-wrap") and contains(@class, "direction-column")]'

	String getMyBrandcastModuleBXpath(){
		return this.MyBrandcastModuleBXpath
	}

	WebElement getMyBrandcastModuleB(){
		return brandcast.getChildElementByXpath(this.getAdminContent(), this.getMyBrandcastModuleBXpath())
	}

	/**
	 * 
	 * My Brandcast Module B Header
	 * 
	 */
	private String MyBrandcastModuleBHeaderXpath = './/div[@class="fl-row"]/div[@class="module-header-b"]'

	String getMyBrandcastModuleBHeaderXpath(){
		return this.MyBrandcastModuleBHeaderXpath
	}

	WebElement getMyBrandcastModuleBHeader(){
		return brandcast.getChildElementByXpath(this.getMyBrandcastModuleB(), this.getMyBrandcastModuleBHeaderXpath())
	}

	/**
	 * 
	 * My Brandcast Module B Content
	 * 
	 */
	private String MyBrandcastModuleBContentXpath = './/div[contains(@class, "fl-row") and contains(@class,"module-b-contents")]/div[@class="col-wrapper"]'

	String getMyBrandcastModuleBContentXpath(){
		return this.MyBrandcastModuleBContentXpath
	}

	WebElement getMyBrandcastModuleBContent(){
		return brandcast.getChildElementByXpath(this.getMyBrandcastModuleB(), this.getMyBrandcastModuleBContentXpath())
	}

	/**
	 * 
	 * Module B Content SideBar
	 * 
	 */
	private String ModuleBContentSideBarXpath = './/div[@class="side-bar"]'

	String getModuleBContentSideBarXpath(){
		return this.ModuleBContentSideBarXpath
	}

	WebElement getModuleBContentSideBar(){
		return brandcast.getChildElementByXpath(this.getMyBrandcastModuleBContent(), this.getModuleBContentSideBarXpath())
	}

	/**
	 * 
	 * Module B Content Area
	 * 
	 */
	private String ModuleBContentAreaXpath = './/div[@class="content-area-b"]/div[@class="main-wrapper"]'

	String getModuleBContentAreaXpath(){
		return this.ModuleBContentAreaXpath
	}

	WebElement getModuleBContentArea(){
		return brandcast.getChildElementByXpath(this.getMyBrandcastModuleBContent(), this.getModuleBContentAreaXpath())
	}

	/**
	 * 
	 * Module B Content Area Website List
	 * 
	 */
	private String ModuleBContentAreaWebsiteListXpath = './/div[@class="account-websites"]/div/div/div[@class="virtualized-grid"]/div[contains(@class,"box")]'

	String getModuleBContentAreaWebsiteListXpath(){
		return this.ModuleBContentAreaWebsiteListXpath
	}

	List<WebElement> getModuleBContentAreaWebsiteList(){
		return brandcast.getChildElementListByXpath(this.getModuleBContentArea(), this.getModuleBContentAreaWebsiteListXpath())
	}



	@Keyword
	def getNewlyCreatedWebsiteFromList(){
		for(WebElement element: this.getModuleBContentAreaWebsiteList()){
			if(element.getText().contains(this.getNewWebsiteName())){
				return element
				break
			}
		}
	}

	@Keyword
	def moveToNewlyCreatedWebsite(){
		brandcast.moveToElementByWebElement(this.getNewlyCreatedWebsiteFromList())
	}

	/**
	 * 
	 * Module B Web List Website box
	 * 
	 */
	private String ModuleBWebsiteBoxOverlayXpath = './/div[@class="box-thumbnail-wrapper"]/div[@class="box-thumbnail"]'

	String getModuleBWebsiteBoxOverlayXpath(){
		return this.ModuleBWebsiteBoxOverlayXpath
	}

	WebElement getModuleBWebsiteBoxOverlay(){
		return brandcast.getChildElementByXpath(this.getNewlyCreatedWebsiteFromList(), getModuleBWebsiteBoxOverlayXpath())
	}

	@Keyword
	def waitForModuleBWebsiteBoxOverlay(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getNewlyCreatedWebsiteFromList(), this.getModuleBWebsiteBoxOverlayXpath())
	}

	/**
	 * 
	 * Module B Website Box Overlay Avatar
	 * 
	 */
	private String BoxAvatarXpath = './/div[@class="box-action-ui"]/div[contains(@class,"bc-menu-group") and contains(@class, "creator-menu")]/div[@class="menu-item" and @data-identifier="creator-menu"]/div[@title="Website Creator" and @class="btn-blank avatar-menu-btn"]/div[contains(@class,"avatar-container") and contains(@class,"box-avatar") and contains(@class,"is-online")]/div[@class="avatar"]'

	String getBoxAvatarXpath(){
		return this.BoxAvatarXpath
	}

	WebElement getBoxAvatar(){
		return brandcast.getChildElementByXpath(this.getModuleBWebsiteBoxOverlay(), this.getBoxAvatarXpath())
	}


	/**
	 * 
	 * Module B Website Box Overlay Open Site Buttton
	 * 
	 */
	private String BoxOverlayOpenSiteBtnXpath = './/div[@class="box-action-ui"]/div[@class="centered-wrapper"]/div[contains(@class, "ui-wrapper") and conatins(@class, "box-btn")]/span'

	String getBoxOverlayOpenSiteBtnXpath(){
		return this.BoxOverlayOpenSiteBtnXpath
	}

	WebElement getBoxOverlayOpenSiteBtn(){
		return brandcast.getChildElementByXpath(this.getModuleBWebsiteBoxOverlay(), this.getBoxOverlayOpenSiteBtnXpath())
	}

	@Keyword
	def clickBoxOverlayOpenSiteBtn(){
		brandcast.clickChildWebElement(this.getModuleBWebsiteBoxOverlay(), this.getBoxOverlayOpenSiteBtnXpath())
	}


	/**
	 * 
	 * Module B Website Box Overlay Menu
	 * 
	 */
	private String BoxOverlayMenuBtnXpath = './/div[@class="box-action-ui"]/div[contains(@class,"bc-menu-group") and contains(@class,"website-menu")]/div[@class="menu-item" and @data-identifier="website-menu"]/div[@title="Website Menu"]'

	String getBoxOverlayMenuBtnXpath(){
		return this.BoxOverlayMenuBtnXpath
	}

	WebElement getBoxOverlayMenuBtn(){
		return brandcast.getChildElementByXpath(this.getModuleBWebsiteBoxOverlay(), this.getBoxOverlayMenuBtnXpath())
	}

	@Keyword
	def clickBoxOverlayMenuBtn(){
		brandcast.clickChildWebElement(this.getModuleBWebsiteBoxOverlay(), this.getBoxOverlayMenuBtnXpath())
	}

	/**
	 * 
	 * Box Overlay Context Menu
	 * 
	 */
	private String BoxOverlayContextMenuXpath = './/div[@class="box-action-ui"]' ///div[contains(@class,"bc-menu-group") and contains(@class,"website-menu")]'

	String getBoxOverlayContextMenuXpath(){
		return this.BoxOverlayContextMenuXpath
	}

	WebElement getBoxOverlayContextMenu(){
		return brandcast.getChildElementByXpath(this.getModuleBWebsiteBoxOverlay(), this.getBoxOverlayContextMenuXpath())
	}

	@Keyword
	def waitForBoxOverlayContextMenu(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getModuleBWebsiteBoxOverlay(), this.getBoxOverlayContextMenu())
	}

	/**
	 * 
	 * ContextMenuOptionList
	 * 
	 */
	private String ContextMenuOptionListXpath = './/div[contains(@class,"bc-menu-group") and contains(@class,"website-menu") and contains(@class,"active")]/div[contains(@class,"menu-item") and contains(@data-identifier, "website-menu")]/div[@class="menu-dropdown"]/div[contains(@class,"ui-wrapper") and contains(@class,"btn-row-wrapper")]/div[@class="btn-row"]'
	private String DeleteMenuOption = 'Delete Website'

	String getContextMenuOptionListXpath(){
		return this.ContextMenuOptionListXpath
	}

	List<WebElement> getContextMenuOptionList(){
		return brandcast.getChildElementListByXpath(this.getBoxOverlayContextMenu(), this.getContextMenuOptionListXpath())
	}

	@Keyword
	def clickContextMenuDeleteOptionFromList(){
		brandcast.clickListItem(this.getContextMenuOptionList(), this.DeleteMenuOption)
	}

	/**
	 * 
	 * Delete Website Modal
	 * 
	 */
	private String DeleteWebsiteModalXpath = '//span[contains(@class,"app-container") and contains(@class,"hidden-launch") and contains(@class,"dashboard") and contains(@class,"app-ready") and contains(@class,"logged-in") and contains(@class, "login-complete") and contains(@class, "modal-open")]/span/div[contains(@class,"overlays-wrapper") and contains(@class,"overlay-bounds")]/div[@data-overlay-id="deletewebsiteconfirmationcontainer"]/div[@class="bc-modal-wrapper"]'

	String getDeleteWebsiteModalXpath(){
		this.DeleteWebsiteModalXpath
	}

	WebElement getDeleteWebsiteModal(){
		return brandcast.getElementByXpath(this.getDeleteWebsiteModalXpath())
	}

	@Keyword
	def waitForDeleteWebsiteModal(){
		brandcast.waitUntilPresenceOfElementLocatedBy(this.getDeleteWebsiteModalXpath())
	}

	/**
	 * 
	 * Delete Website Modal Delete Website Button
	 * 
	 */
	private String DeleteModalDeleteBtnXpath = '//div[contains(@class,"container-clear") and contains(@class,"modal-btns")]/div[@class="ui-wrapper editor-style primary"]/button[@data-qa-id="delete-website-button"]'

	String getDeleteModalDeleteBtnXpath(){
		return this.DeleteModalDeleteBtnXpath
	}

	WebElement getDeleteModalDeleteBtn(){
		return brandcast.getChildElementByXpath(this.getDeleteWebsiteModal(), this.getDeleteModalDeleteBtnXpath())
	}

	@Keyword
	def clickDeleteModalDeleteBtn(){
		brandcast.clickChildWebElement(this.getDeleteWebsiteModal(), this.getDeleteModalDeleteBtnXpath())
	}

	/**
	 * 
	 * Delete Website Modal Cancel Button
	 * 
	 */
	private String DeleteModalCancelBtnXpath = '//div[contains(@class,"container-clear") and contains(@class,"modal-btns")]/div[@class="ui-wrapper editor-style"]/button[@data-qa-id="cancel-button"]'

	String getDeleteModalCancelBtnXpath(){
		return this.DeleteModalCancelBtnXpath
	}

	WebElement getDeleteModalCancelBtn(){
		return brandcast.getChildElementByXpath(this.getDeleteWebsiteModal(), this.getDeleteModalCancelBtnXpath())
	}

	@Keyword
	def clickDeleteModalCancelBtn(){
		brandcast.clickChildWebElement(this.getDeleteWebsiteModal(), this.getDeleteModalCancelBtnXpath())
	}

	/**=============================================================================================================
	 * 
	 * My -Teams
	 * 
	 */
	private String ModuleCTeamXpath ='//div[@class="module c team"]/div[@class="mod-fl-wrap"]'

	String getModuleCTeamXpath(){
		return this.ModuleCTeamXpath
	}

	WebElement getModuleCTeam(){
		return brandcast.getChildElementByXpath(this.getMyBrandcast(), this.getModuleCTeamXpath())
	}

	private String MyTeamXpath ='.//div[@class="mod-fl-box-children"]/div[@class="recent-team"]'

	String getMyTeamXpath(){
		return this.MyTeamXpath
	}

	WebElement getMyTeam(){
		return brandcast.getChildElementByXpath(this.getModuleCTeam(), this.getMyTeamXpath())
	}

	private String AddTeamMemberBtnXpath = '//div[@class="member-item"]/div[@class="add-user"]/div[contains(@class,"ui-wrapper") and contains(@class,"add-team-member-btn") and contains(@class, "module-btn") and contains(@class,"cs-permission-hide")]/span/div[@class="btn-text"]/div[@data-tutorial-id="add-new-team-member-btn"]'

	String getAddTeamMemberBtnXpath(){
		return this.AddTeamMemberBtnXpath
	}

	WebElement getAddTeamMemberBtn(){
		return brandcast.getChildElementByXpath(this.getMyTeam(), this.getAddTeamMemberBtnXpath())
	}

	@Keyword
	def clickAddTeamMemberBtn(){
		brandcast.clickChildWebElement(this.getMyTeam(), this.getAddTeamMemberBtnXpath())
	}

	private String TeamMemberContainerXpath = '//div[@class="overlays-wrapper overlay-bounds"]/div[@data-overlay-id="addandmanageteammembercontainer"]/div[@class="bc-modal-wrapper manage-member-role step-1"]'

	String getTeamMemberContainerXpath(){
		return this.TeamMemberContainerXpath
	}

	WebElement getTeamMemberContainer(){
		return brandcast.getElementByXpath(this.getTeamMemberContainerXpath())
	}
	@Keyword
	def waitForTeamMemberContainer(){
		brandcast.waitUntilPresenceOfElementLocatedBy(this.getTeamMemberContainerXpath())
	}

	private AddTeamMemberFormXpath = '//div[@class="fl-box b col-wrapper"]/form[@class="add-member-form"]'

	String getAddTeamMemberFormXpath(){
		return this.AddTeamMemberFormXpath
	}

	WebElement getAddTeamMemberForm(){
		return brandcast.getChildElementByXpath(this.getTeamMemberContainer(), this.getAddTeamMemberFormXpath())
	}

	private String AddeamMemberFormEmailXpath = '//div[@title="Email"]/div[@class="text-input-container"]/label/div[@class="text-input-wrapper"]/input[@name="email"]'

	String getAddeamMemberFormEmailXpath(){
		return this.AddeamMemberFormEmailXpath
	}

	WebElement getAddeamMemberFormEmail(){
		return brandcast.getChildElementByXpath(this.getAddTeamMemberForm(), this.getAddeamMemberFormEmailXpath())
	}

	@Keyword
	def sendTeamMemberName(){
		brandcast.sendInput(this.getAddeamMemberFormEmail(), GlobalVariable.username2)
	}

	private String TeamMemberBtnsXpath = '//div[@class="block-btns-wrapper fl-box"]/div[@class="block-btns"]'

	String getTeamMemberBtnsXpath(){
		return this.TeamMemberBtnsXpath
	}

	WebElement getAddTeamMemberBtns(){
		return brandcast.getChildElementByXpath(this.getAddTeamMemberForm(), this.getTeamMemberBtnsXpath())
	}

	private String AddTeamMemberButtonXpath ='//div[@class="ui-wrapper editor-style fl-auto primary"]/button[@data-qa-id="add-team-member-button"]'

	String getAddTeamMemberButtonXpath(){
		return this.AddTeamMemberButtonXpath
	}

	WebElement getAddTeamMemberButton(){
		return brandcast.getChildElementByXpath(this.getAddTeamMemberBtns(), this.getAddTeamMemberButtonXpath())
	}

	@Keyword
	def clickAddTeamMemberButton(){
		brandcast.clickChildWebElement(this.getAddTeamMemberBtns(), this.getAddTeamMemberButtonXpath())
	}
	/**=============================================================================================================
	 * 
	 * Admin Container Left Rail
	 * 
	 */
	private AdminLeftRailXpath = './/div[@class="left-rail"]'

	String getAdminLeftRailXpath(){
		return this.AdminLeftRailXpath
	}

	WebElement getAdminLeftRail(){
		return brandcast.getChildElementByXpath(this.getAdminContainer(), this.getAdminLeftRailXpath())
	}

	@Keyword
	def waitForAdminLeftRail(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getAdminContainer(), this.getAdminLeftRailXpath())
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
	 * Left Rail Panel - New Website Button
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

	@Keyword
	def waitForLeftPanelNewWebsiteButton(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getAdminLeftRail(), this.getLeftPanelNewWebsiteButtonXpath())
	}
	/**
	 * 
	 * Left Panel - Admin Navigation
	 * 
	 */
	private LeftPanelLinkListContentXpath = '//div[@class="admin-nav-wrapper"]'

	String getLeftPanelLinkListContentXpath(){
		return this.LeftPanelLinkListContentXpath
	}

	WebElement getLeftPanelLinkListContent(){
		return brandcast.getChildElementByXpath(this.getAdminLeftRail(), this.getLeftPanelLinkListContentXpath())
	}

	/**
	 *
	 * Left Panel - My Templates Link
	 *
	 */
	private LeftPanelMyBrandcastLinkXpath = './/a[contains(@class,"my-brandcast")]'

	String getLeftPanelMyBrandcastLinkXpath(){
		return this.LeftPanelMyBrandcastLinkXpath
	}

	WebElement getLeftPanelMyBrandcastLink(){
		return brandcast.getChildElementByXpath(this.getLeftPanelLinkListContent(), this.getLeftPanelMyBrandcastLinkXpath())
	}

	@Keyword
	def clickLeftPanelMyBrandcastLink(){
		brandcast.clickChildWebElement(this.getLeftPanelLinkListContent(), this.getLeftPanelMyBrandcastLinkXpath())
	}

	@Keyword
	def waitForLeftPanelMyBrandcastLink(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getLeftPanelLinkListContent(), this.getLeftPanelMyBrandcastLinkXpath())
	}

	/**
	 *
	 * Left Panel - My Website Link
	 *
	 */
	private LeftPanelMyWebsitesLinkXpath = './/a[contains(@class,"my-websites")]'

	String getLeftPanelMyWebsitesLinkXpath(){
		return this.LeftPanelMyWebsitesLinkXpath
	}

	WebElement getLeftPanelMyWebsitesLink(){
		return brandcast.getChildElementByXpath(this.getLeftPanelLinkListContent(), this.getLeftPanelMyWebsitesLinkXpath())
	}

	@Keyword
	def clickLeftPanelMyWebsitesLink(){
		brandcast.clickChildWebElement(this.getLeftPanelLinkListContent(), this.getLeftPanelMyWebsitesLinkXpath())
	}

	@Keyword
	def waitForLeftPanelMyWebsitesLink(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getLeftPanelLinkListContent(), this.getLeftPanelMyWebsitesLinkXpath())

	}

	/**
	 * 
	 * Left Panel - My Templates Link
	 * 
	 */
	private LeftPanelMyTemplatesLinkXpath = './/a[contains(@class,"my-templates")]'

	String getLeftPanelMyTemplatesLinkXpath(){
		return this.LeftPanelMyTemplatesLinkXpath
	}

	WebElement getLeftPanelMyTemplatesLink(){
		return brandcast.getChildElementByXpath(this.getLeftPanelLinkListContent(), this.getLeftPanelMyTemplatesLinkXpath())
	}

	@Keyword
	def clickLeftPanelMyTemplatesLink(){
		brandcast.clickChildWebElement(this.getLeftPanelLinkListContent(), this.getLeftPanelMyTemplatesLinkXpath())
	}

	@Keyword
	def waitForLeftPanelMyTemplatesLink(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getLeftPanelLinkListContent(), this.getLeftPanelMyTemplatesLinkXpath())
	}

	/**
	 *
	 * Left Panel - My Blocks Link
	 *
	 */
	private LeftPanelMyBlocksLinkXpath = './/a[contains(@class,"my-blocks")]'

	String getLeftPanelMyBlocksLinkXpath(){
		return this.LeftPanelMyBlocksLinkXpath
	}

	WebElement getLeftPanelMyBlocksLink(){
		return brandcast.getChildElementByXpath(this.getLeftPanelLinkListContent(), this.getLeftPanelMyBlocksLinkXpath())
	}

	@Keyword
	def clickLeftPanelMyBlocksLink(){
		brandcast.clickChildWebElement(this.getLeftPanelLinkListContent(), this.getLeftPanelMyBlocksLinkXpath())
	}

	@Keyword
	def waitForLeftPanelMyBlocksLink(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getLeftPanelLinkListContent(), this.getLeftPanelMyBlocksLinkXpath())

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

	/**
	 *
	 *
	 * Create Website Button
	 *
	 */
	private CreateWebsiteNameIputXpath ='//div[@title="Website Name"]/div[@class="text-input-container"]/label/div[@class="text-input-wrapper"]/input[@name="name"]'

	String getCreateWebsiteNameIputXpath(){
		return this.CreateWebsiteNameIputXpath
	}

	WebElement getCreateWebsiteNameIput(){
		return brandcast.getChildElementByXpath(this.getCreateWebsiteModalForm(), this.getCreateWebsiteNameIputXpath())
	}
	@Keyword
	def sendWebsiteName(){
		brandcast.sendInput(this.getCreateWebsiteNameIput(), this.getNewWebsiteName())
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