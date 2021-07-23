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

public class MyTeam {
	Core brandcast = new Core()
	Utils utils = new Utils()

	//DetialMapEmail
	private String Email = $/everett+team@brandcast.com/$
	private String Name = 'Everett Aknowledge'
	private String Role = 'Administrator'
	private String SearchName = 'Everett-team'
	private String SearchEmail = $/everett-team@brandcast.com/$
	private String SearchRole = 'Content Studio'

	String gridDetialMapEmail(){
		return this.Email
	}
	String gridDetialMapName(){
		return this.Name
	}
	String gridDetialMapRole(){
		return this.Role
	}

	String gridTeamSearchName(){
		return this.SearchName
	}

	String gridTeamSearchEmail(){
		return this.SearchEmail
	}
	String gridTeamSearchRole(){
		return this.SearchRole
	}

	//Add Team Member Email Input
	private String AddTeamMemberEmailInputXpath = '//div[@class="text-input-container"]/label/div[@class="text-input-wrapper"]/input[@name="email" and @type="text" and @class="text-input"]'
	String getAddTeamMemberEmailInputXpath(){
		return this.AddTeamMemberEmailInputXpath
	}

	private String TeamMemberEmail = 'everett-team@brandcast.com'
	String getTeamMemberEmail(){
		return this.TeamMemberEmail
	}

	private String AdminRole = 'Administrator'
	String getAdminRole(){
		return this.AdminRole
	}

	private String ContentStudioRole ='Content Studio'

	String getContentStudioRole(){
		return ContentStudioRole
	}

	//Team Members Module
	private String TeamMembersModuleXpath = '//div[@class="admin-content"]/div[@class="team-members module-wrapper flex"]/div[@class="module tabs-layout f"]'

	String getTeamMembersModuleXpath(){
		return this.TeamMembersModuleXpath
	}

	WebElement getTeamMembersModule(){
		return brandcast.getElementByXpath(this.getTeamMembersModuleXpath())
	}

	//Team Members Module Tabs Xpath
	private String TeamMembersModuleTabsXpath = './/div[@class="module-tabs-header"]'

	String getTeamMembersModuleTabsXpath(){
		return this.TeamMembersModuleTabsXpath
	}

	@Keyword
	WebElement getTeamMembersModuleTabs(){
		return brandcast.getChildElementByXpath(this.getTeamMembersModule(), this.getTeamMembersModuleTabsXpath())
	}

	//Team Members Tab
	private String TeamMembersTabXpath = './/a[contains(@class,"module-tab a")]'

	String getTeamMembersTabXpath(){
		return this.TeamMembersTabXpath
	}

	WebElement getTeamMembersTab(){
		return brandcast.getChildElementByXpath(this.getTeamMembersModuleTabs(), this.getTeamMembersTabXpath())
	}

	@Keyword
	def clickTeamMembersTab(){
		brandcast.executeJavascriptClickElement(this.getTeamMembersTab())
	}

	//Team Member Grid
	private String TeamMemberGridXpath = './/div[@class="team-grid-wrapper"]'


	String getTeamMemberGridXpath(){
		return this.TeamMemberGridXpath
	}

	@Keyword
	WebElement getTeamMemberGrid(){
		return brandcast.getChildElementByXpath(this.getTeamMembersModule(), this.getTeamMemberGridXpath())
	}

	//Team Permissions
	private String TeamPermissionsTabXpath = './/a[contains(@class,"module-tab b")]'

	String getTeamPermissionsTabXpath(){
		return this.TeamPermissionsTabXpath
	}

	WebElement getTeamPermissionsTab(){
		return brandcast.getChildElementByXpath(this.getTeamMembersModuleTabs(), this.getTeamPermissionsTabXpath())
	}

	@Keyword
	def clickTeamPermissionsTab(){
		brandcast.executeJavascriptClickElement(this.getTeamPermissionsTab())
	}


	//Team Module Tabs Content Area
	private String TeamModuleTabsContentAreaXpath = './/div[@class="module-tabs-content-area"]/div[@class="team-members-tab"]'

	String getTeamModuleTabsContentAreaXpath(){
		return this.TeamModuleTabsContentAreaXpath
	}

	@Keyword
	WebElement getTeamModuleTabsContentArea(){
		return brandcast.getChildElementByXpath(this.getTeamMembersModule(), this.getTeamModuleTabsContentAreaXpath())
	}

	//Team Members Toolbar Wrapper
	private String TeamMembersToolbarWrapperXpath = '//div[@class="team-members-toolbar-wrapper"]'

	String getTeamMembersToolbarWrapperXpath(){
		return this.TeamMembersToolbarWrapperXpath
	}

	@Keyword
	WebElement getTeamMembersToolbarWrapper(){
		return brandcast.getChildElementByXpath(this.getTeamModuleTabsContentArea(), this.getTeamMembersToolbarWrapperXpath())
	}

	//Add Team Member Button
	private String AddTeamMemberBtnXpath = './/div[@class="a-btn-flex cs-permission-hide"]/div[@class="ui-wrapper add-team-member-btn accent-btn a"]/span/div[@class="btn-text"]/div[@data-tutorial-id="add-member-btn" and @class="btn-text-label"]'

	String getAddTeamMemberBtnXpath(){
		return this.AddTeamMemberBtnXpath
	}

	@Keyword
	WebElement getAddTeamMemberBtn(){
		return brandcast.getChildElementByXpath(this.getTeamMembersToolbarWrapper(), this.getAddTeamMemberBtnXpath())
	}


	//Team Search Sort Bar
	private String TeamSearchSortBarXpath = './/div[@class="search-sort-bar b-search-flex"]'

	String getTeamSearchSortBarXpath(){
		return this.TeamSearchSortBarXpath
	}

	@Keyword
	WebElement getTeamSearchSortBar(){
		return brandcast.getChildElementByXpath(this.getTeamMembersToolbarWrapper(), this.getTeamSearchSortBarXpath())
	}

	//Team Search
	private String TeamSearchInputXpath = './/div[@class="search-input-container default-search cc"]/div[@class="search-input-wrapper"]/input[@type="text" and @placeholder="Search"]'

	String getTeamSearchInputXpath(){
		return this.TeamSearchInputXpath
	}

	@Keyword
	WebElement getTeamSearchInput(){
		return brandcast.getChildElementByXpath(this.getTeamSearchSortBar(), this.getTeamSearchInputXpath())
	}

	@Keyword
	WebElement clickTeamSearchInput(){
		brandcast.clickChildWebElement(this.getTeamSearchSortBar(), this.getTeamSearchInputXpath())
	}

	@Keyword
	def sendTeamSearchInput(String Text){
		brandcast.sendInput(this.getTeamSearchInput(), Text)

	}

	//Team Sort
	private String TeamSortXpath = './/div[@class="sorting-wrapper"]/span[@class="sorting-ui"]'

	String getTeamSortXpath(){
		return this.TeamSortXpath
	}

	@Keyword
	WebElement getTeamSort(){
		return brandcast.getChildElementByXpath(this.getTeamSearchSortBar(), this.getTeamSortXpath())
	}

	@Keyword
	WebElement clickTeamSort(){
		brandcast.clickChildWebElement(this.getTeamSearchSortBar(), this.getTeamSortXpath())
	}

	//Team Sort By
	private String TeamSortByXpath = './/div[@class="bc-menu-group menu-select light-theme"]/div[@class="menu-item" data-identifier="websiteManager"]/div[@class="ui-wrapper menu-select-btn"]'

	String getTeamSortByXpath(){
		return this.TeamSortByXpath
	}

	@Keyword
	WebElement getTeamSortBy(){
		return brandcast.getChildElementByXpath(this.getTeamSort(), this.getTeamSortByXpath())
	}

	@Keyword
	WebElement clickTeamSortBy(){
		brandcast.clickChildWebElement(this.getTeamSort(), this.getTeamSortByXpath())
	}

	//Team Switch Order
	private String TeamSwitchOrderXpath = './/div[@class="ui-wrapper editor-style" and @title="Switch Order"]/div[@class="btn"]'

	String getTeamSwitchOrderXpath(){
		return this.TeamSwitchOrderXpath
	}

	@Keyword
	WebElement getTeamSwitchOrder(){
		return brandcast.getChildElementByXpath(this.getTeamSort(), this.getTeamSwitchOrderXpath())
	}

	@Keyword
	WebElement clickTeamSwitchOrder(){
		brandcast.clickChildWebElement(this.getTeamSort(), this.getTeamSwitchOrderXpath())
	}

	//TeamSortByMenuDropDown
	private String TeamSortByMenuDropDownXpath = '//div[@class="menu-dropdown sort-by"]'

	String getTeamSortByMenuDropDownXpath(){
		return this.TeamSortByMenuDropDownXpath
	}

	@Keyword
	WebElement getTeamSortByMenuDropDown(){
		return brandcast.getChildElementByXpath(this.getTeamSort(), this.getTeamSortByMenuDropDownXpath())
	}

	//Team Sort By Menu Options
	private String TeamSortByMenuOptionsXpath = '//div[@class="ui-wrapper btn-row-wrapper"]'

	String getTeamSortByMenuOptionsXpath() {
		return this.TeamSortByMenuOptionsXpath
	}

	@Keyword
	List<WebElement> getTeamSortByMenuOptions(){
		return brandcast.getChildElementListByXpath(this.getTeamSortByMenuDropDown(), this.getTeamSortByMenuOptionsXpath())

	}

	//Team Sort By Menu Option
	private String TeamSortByMenuOptionXpath = './/div[@class="btn-row"]/div[@class="btn-row-label"]/h4'

	String getTeamSortByMenuOptionXpath(){
		return this.TeamSortByMenuOptionXpath
	}

	//Available Sort Options
	List availableSortOptions = [
		"Sort by first name",
		"Sort by last name",
		"Sort by date added"
	]

	@Keyword
	def getRandomSortOptions(){
		Integer pick = utils.getRandomNumber(0, this.availableSortOptions.size()-1)
		return this.availableSortOptions.get(pick)
	}

	@Keyword
	WebElement getTeamSortByMenuOption(WebElement element) {
		return brandcast.getChildElementByXpath(element, this.getTeamSortByMenuOptionXpath())
	}



	def clickTeamSortByMenuOption(String menuOption){
		this.getTeamSortByMenuOptions().find{
			WebElement current = it
			WebElement currentOption = current.findElement(By.xpath(this.getTeamSortByMenuOptionXpath()))

			if(
			currentOption.getAttribute("innerHTML").toString() == menuOption
			){
				println menuOption
				println currentOption.getAttribute("innerHTML").toString()

				KeywordUtil.markPassed("Clicking Team Menu Option: "+menuOption)
				brandcast.clickWebElement(current.findElement(By.xpath('//div[@class="ui-wrapper btn-row-wrapper"]/div[@class="btn-row"]')))
				return true

			}

		}

	}

	//
	//
	//Add And Manage Team Member Container
	private String AddAndManageTeamMemberContainerXpath = '//div[@data-overlay-id="addandmanageteammembercontainer" and @class="bc-modal"]/div[contains(@class,"bc-modal-wrapper") and contains(@class,"manage-member-role") and contains(@class,"step-1") or contains(@class,"step-2")]'

	String getAddAndManageTeamMemberContainerXpath(){
		return this.AddAndManageTeamMemberContainerXpath
	}

	WebElement getAddAndManageTeamMemberContainer(){
		return brandcast.getElementByXpath(this.getAddAndManageTeamMemberContainerXpath())
	}

	//Header Container
	private String HeaderContainerXpath = '//div[@class="fl-box a header-container"]'

	String getHeaderContainerXpath(){
		return this.HeaderContainerXpath
	}

	@Keyword
	WebElement getHeaderContainer(){
		return  brandcast.getChildElementByXpath(this.getAddAndManageTeamMemberContainer(), this.getHeaderContainerXpath())
	}

	//Team Member Module Title
	private String TeamMemberModuleTitleXpath = '//h2[@class="module-title"]'

	String getTeamMemberModuleTitleXpath(){
		return this.TeamMemberModuleTitleXpath
	}

	WebElement getTeamMemberModuleTitle(){
		return brandcast.getChildElementByXpath(this.getHeaderContainer(), this.getTeamMemberModuleTitleXpath())
	}

	//Team Member Module Description
	private String TeamMemberModuleDescriptionXpath = './/p[@class="module-description"]'

	String getTeamMemberModuleDescriptionXpath(){
		return this.TeamMemberModuleDescriptionXpath
	}

	@Keyword
	WebElement getTeamMemberModuleDescription(){
		return brandcast.getChildElementByXpath(this.getHeaderContainer(), this.getTeamMemberModuleDescriptionXpath())
	}

	//Status Bar Progress
	private String TeamMemberStatusBarProgressXpath = '//div[@class="status-wrapper"]/div[@class="status-bar-wrapper clearfix"]/div[@class="status-bar-progress clearfix"]'

	String getTeamMemberStatusBarProgressXpath(){
		return this.TeamMemberStatusBarProgressXpath
	}

	@Keyword
	WebElement getTeamMemberStatusBarProgress(){
		return brandcast.getChildElementByXpath(this.getHeaderContainer(), this.getTeamMemberStatusBarProgressXpath())
	}

	//Team Member Close Container
	private String TeamMemberCloseContainerXpath = './/div[@class="wa-close-container"]'

	String getTeamMemberCloseContainerXpath(){
		return this.TeamMemberCloseContainerXpath
	}

	@Keyword
	WebElement getTeamMemberCloseContainer(){
		return brandcast.getChildElementByXpath(this.getAddAndManageTeamMemberContainer(), this.getTeamMemberCloseContainerXpath())
	}

	// Step-1
	// Add Member Form
	private String AddMemberFormXpath = './/div[@class="fl-box b col-wrapper"]/form[@class="add-member-form"]'

	String getAddMemberFormXpath(){
		return this.AddMemberFormXpath
	}

	@Keyword
	WebElement getAddMemberForm(){
		return brandcast.getChildElementByXpath(this.getAddAndManageTeamMemberContainer(), this.getAddMemberFormXpath())
	}

	//Add Team Member Name
	private String AddTeamMemberNameXpath = './/div[@class="member-name-wrap"]'

	String getAddTeamMemberNameXpath(){
		return this.AddTeamMemberNameXpath
	}

	@Keyword
	WebElement getAddTeamMemberName(){
		return brandcast.getChildElementByXpath(this.getAddAndManageTeamMemberContainer(), this.getAddMemberFormXpath())
	}

	//Add Team Member First Name
	private String AddTeamMemberFirstNameXpath = '//div[@class="member-name"]/div[@class="ui-wrapper full-width fl-box size-B white-theme first-name" and @title="First Name"]/div[@class="text-input-container"]/label/div[@class="text-input-wrapper"]/input[@name="firstName" and @type="text" and @class="text-input"]'

	String getAddTeamMemberFirstNameXpath(){
		return this.AddTeamMemberFirstNameXpath
	}

	@Keyword
	WebElement getAddTeamMemberFirsttName(){
		return brandcast.getChildElementByXpath(this.getAddTeamMemberName(), this.getAddTeamMemberFirstNameXpath())
	}

	@Keyword
	def sendAddTeamMemberFirsttName(){
		return brandcast.sendKeys(this.getAddTeamMemberFirsttName(), key)
	}


	//Add Team Member Last Name
	private String AddTeamMemberLastNameXpath = './/div[@class="ui-wrapper full-width fl-box size-B white-theme last-name" and @title="Last Name"]/div[@class="text-input-container"]/label/div[@class="text-input-wrapper"]/input[@name="lastName" and @type="text" and @class="text-input"]'


	String getAddTeamMemberLastNameXpath(){
		return this.AddTeamMemberLastNameXpath
	}

	@Keyword
	WebElement getAddTeamMemberLastName(){
		return brandcast.getChildElementByXpath(this.getAddTeamMemberName(), this.getAddTeamMemberLastNameXpath())
	}

	@Keyword
	def sendAddTeamMemberLastName(){
		return brandcast.sendKeys(this.getAddTeamMemberLastName(), key)
	}

	//Add Team Member Email
	private String AddTeamMemberEmailXpath = '//div[@class="ui-wrapper full-width fl-box size-B white-theme fl-box" and @title="Email"]'

	String getAddTeamMemberEmailXpath(){
		return this.AddTeamMemberEmailXpath
	}

	@Keyword
	WebElement getAddTeamMemberEmail(){
		return brandcast.getChildElementByXpath(this.getAddAndManageTeamMemberContainer(), this.getAddTeamMemberEmailXpath())
	}

	@Keyword
	WebElement getAddTeamMemberEmailInput(){
		return brandcast.getChildElementByXpath(this.getAddTeamMemberEmail(), this.getAddTeamMemberEmailInputXpath())
	}

	@Keyword
	def sendAddTeamMemberEmail(){
		return brandcast.sendInput(this.getAddTeamMemberEmailInput(), this.getTeamMemberEmail())
	}

	//Add Team Member Block Buttons
	private String AddTeamMemberBlockBtnsXpath = '//div[@class="block-btns-wrapper fl-box"]/div[@class="block-btns"]'

	String getAddTeamMemberBlockBtnsXpath(){
		return this.AddTeamMemberBlockBtnsXpath
	}

	@Keyword
	WebElement getAddTeamMemberBlockBtns(){
		return brandcast.getChildElementByXpath(this.getAddAndManageTeamMemberContainer(), this.getAddTeamMemberBlockBtnsXpath())
	}

	//Add Team Member Cancel Button
	private String AddTeamMemberCancelButtonXpath = '//div[@class="ui-wrapper editor-style fl-auto"]/button[@class="btn-html" and type="button" and data-qa-id="cancel-button"]'

	String getAddTeamMemberCancelButtonXpath(){
		return this.AddTeamMemberCancelButtonXpath
	}

	@Keyword
	WebElement getAddTeamMemberCancelButton(){
		return brandcast.getChildElementByXpath(this.getAddTeamMemberBlockBtns(), this.getAddTeamMemberCancelButtonXpath())
	}

	@Keyword
	WebElement clickAddTeamMemberCancelButton(){
		return brandcast.executeJavascriptClickElement(this.getAddTeamMemberCancelButton())
	}

	//Add Team Member Button
	private String AddTeamMemberButtonXpath = '//div[@class="ui-wrapper editor-style fl-auto primary"]/button[@class="btn-html" and @type="submit" and @data-qa-id="add-team-member-button"]'

	String getAddTeamMemberButtonXpath(){
		return this.AddTeamMemberButtonXpath
	}

	@Keyword
	WebElement getAddTeamMemberButton(){
		return brandcast.getChildElementByXpath(this.getAddTeamMemberBlockBtns(), this.getAddTeamMemberButtonXpath())
	}

	@Keyword
	WebElement clickAddTeamMemberButton(){
		brandcast.clickChildWebElement(this.getAddTeamMemberBlockBtns(), this.getAddTeamMemberButtonXpath())
		//brandcast.executeJavascriptClickElement(this.getAddTeamMemberButton())
	}

	//Step-2
	//Add Memeber Choose Role
	private String AddMemeberChooseRoleXpath = '//div[@class="fl-box b col-wrapper"]'

	String getAddMemeberChooseRoleXpath(){
		return this.AddMemeberChooseRoleXpath
	}

	@Keyword
	WebElement getAddMemeberChooseRole(){
		return brandcast.getChildElementByXpath(this.getAddAndManageTeamMemberContainer(), this.getAddMemeberChooseRoleXpath())
	}

	//Add Memeber Item List
	private String AddMemeberItemListXpath = './/div[@class="fl-wrap"]/div[@class="fl-box aa"]/div[@class="item-list"]'

	String getAddMemeberItemListXpath(){
		return this.AddMemeberItemListXpath
	}

	WebElement getAddMemeberItemList(){
		return brandcast.getChildElementByXpath(this.getAddMemeberChooseRole(), this.getAddMemeberItemListXpath())
	}

	//Add Member Profile List Item
	private String AddMemberProfileListItemXpath = './/div[@class="profile-list-item-wrapper"]/div[@class="profile-list-item"]'

	String getAddMemberProfileListItemXpath(){
		return this.AddMemberProfileListItemXpath
	}

	@Keyword
	WebElement getAddMemberProfileListItem(){
		return brandcast.getChildElementByXpath(this.getAddMemeberItemList(), this.getAddMemberProfileListItemXpath())
	}

	//Team Member Avatar
	private String TeamMemberAvatarXpath = './/div[@class="avatar-container no-avatar"]/div[@class="avatar"]'

	String getTeamMemberAvatarXpath(){
		return this.TeamMemberAvatarXpath
	}

	@Keyword
	WebElement getTeamMemberAvatar(){
		return brandcast.getChildElementByXpath(this.getAddMemberProfileListItem(), this.getTeamMemberAvatarXpath())
	}

	//Team Member Username
	private String TeamMemberUsernameXpath = './/div[@class="user-name-email"]/h4'

	String getTeamMemberUsernameXpath(){
		return this.TeamMemberUsernameXpath
	}

	@Keyword
	WebElement getTeamMemberUsername(){
		return brandcast.getChildElementByXpath(this.getAddMemberProfileListItem(), this.getTeamMemberUsernameXpath())
	}

	//Team Member Role Selector
	private String TeamMemberRoleSelectorsXpath = './/div[@class="item"]/div[@class="role-selector"]'

	String getTeamMemberRoleSelectorsXpath(){
		return this.TeamMemberRoleSelectorsXpath
	}

	@Keyword
	List<WebElement> getTeamMemberRoleSelectors(){
		return brandcast.getChildElementListByXpath(this.getAddMemeberItemList(), this.getTeamMemberRoleSelectorsXpath())
	}
	@Keyword
	def verifyTeamMemberRole(List<WebElement> elementList, String teamRole){
		elementList.find{
			WebElement checkBoxContainer = it.findElement(By.xpath('.//div[contains(@class,"check-box-container role-radio")]/div[contains(@class,"check-box")]'))
			WebElement roleLabel = it.findElement(By.xpath('.//div[contains(@class,"role-radio-label")]/p[contains(@class,"role-radio-text")]'))
			if(checkBoxContainer.getAttribute("class").contains("selected") && roleLabel.getAttribute("innerHTML").toString().contains(teamRole)) {
				KeywordUtil.markPassed("User has Admin")
				return true
			}
		}
		return false
	}

	@Keyword
	def clickTeamMemberRole(List<WebElement> elementList, String teamRole){
		elementList.find{
			WebElement checkBoxContainer = it.findElement(By.xpath('.//div[contains(@class,"check-box-container role-radio")]/div[contains(@class,"check-box")]'))
			WebElement roleLabel = it.findElement(By.xpath('.//div[contains(@class,"role-radio-label")]/p[contains(@class,"role-radio-text")]'))
			if(!checkBoxContainer.getAttribute("class").contains("selected") && roleLabel.getAttribute("innerHTML").toString().contains(teamRole)) {
				KeywordUtil.markPassed("Assigning Admin")
				checkBoxContainer.click()
				return true
			}
		}
		return false
	}

	//Team Member Save Close Button
	private String TeamMemberSaveCloseButtonXpath = './/div[@class="fl-box c block-btns-wrapper"]/div[@class="block-btns"]/div[@class="ui-wrapper editor-style fl-auto primary"]/button[@class="btn-html" and @type="submit" and @data-qa-id="create-website-button"]'

	String getTeamMemberSaveCloseButtonXpath(){
		return this.TeamMemberSaveCloseButtonXpath
	}

	@Keyword
	WebElement getTeamMemberSaveCloseButton(){
		return brandcast.getChildElementByXpath(this.getAddAndManageTeamMemberContainer(), this.getTeamMemberSaveCloseButtonXpath())
	}

	@Keyword
	def clickTeamMemberSaveCloseButton(){
		brandcast.executeJavascriptClickElement(this.getTeamMemberSaveCloseButton())
	}

	//Team Member Grid Items
	private String TeamMemberGridItemsXpath = './/div[@class="box-member-wrapper"]'


	String getTeamMemberGridItemsXpath(){
		return this.TeamMemberGridItemsXpath
	}

	WebElement getTeamMemberGridItemsContainer(){
		return brandcast.getChildElementByXpath(this.getTeamMemberGrid(), this.getTeamMemberGridItemsXpath())
	}

	@Keyword
	List<WebElement> getTeamMemberGridItems(){
		return brandcast.getChildElementListByXpath(this.getTeamMemberGrid(), this.getTeamMemberGridItemsXpath())
	}

	//Grid Item Menu
	private String GridItemMenuXpath = './/div[@class="bc-menu-group member-menu light-theme active"]/div[@class="menu-item has-layout" and @data-identifier="member-menu"]'

	String getGridItemMenuXpath(){
		return this.GridItemMenuXpath
	}

	@Keyword
	WebElement getGridItemMenu(WebElement element){
		return brandcast.getChildElementByXpath(element, this.getGridItemMenuXpath())
	}



	//Grid Item Menu Drop Down
	private String GridItemMenuDropDownXpath = './/div[@class="menu-dropdown"]/div[@class="ui-wrapper btn-row-wrapper accented"]/div[@class="btn-row"]'

	String getGridItemMenuDropDownXpath(){
		return this.GridItemMenuDropDownXpath
	}

	@Keyword
	WebElement getGridItemMenuDropDown(WebElement element){
		return brandcast.getChildElementByXpath(element, this.getGridItemMenuDropDownXpath())
	}

	//Grid Item Menu Icon
	private String GridItemMenuIconXpath = './/div[@class="bc-menu-group member-menu light-theme"]/div[@class="menu-item" and @data-identifier="member-menu"]/div[@title="Member Menu" and @class="btn-blank bullet-btn"]'

	String getGridItemMenuIconXpath(){
		return this.GridItemMenuIconXpath
	}


	@Keyword
	WebElement getGridItemMenuIcon(WebElement element){
		return brandcast.getChildElementByXpath(element, this.getGridItemMenuIconXpath())
	}

	//Grid Item Details
	private String GridItemDetailsXpath  = './/div[@class="box-member b"]/div[@class="grid-item-details"]'

	String getGridItemDetailsXpath(){
		return this.GridItemDetailsXpath
	}

	@Keyword
	WebElement getGridItemDetails(WebElement element){
		return brandcast.getChildElementByXpath(element, this.getGridItemDetailsXpath())
	}

	//Grid Item Manage Role Button
	private String GridItemManageRoleBtnXpath = './/div[@class="box-member c"]'

	String getGridItemManageRoleBtnXpath(){
		return this.GridItemManageRoleBtnXpath
	}

	@Keyword
	WebElement getGridItemManageRoleBtn(WebElement element){
		return brandcast.getChildElementByXpath(element, this.getGridItemManageRoleBtnXpath())
	}


	//Grid ItemName
	private String GridItemNameXpath = './/h4[@class="name"]'

	String getGridItemNameXpath(){
		return this.GridItemNameXpath
	}

	@Keyword
	WebElement getGridItemName(WebElement element){
		return brandcast.getChildElementByXpath(element, this.getGridItemNameXpath())
	}


	//Grid Item Role
	private String GridItemRoleXpath = './/p[@class="role"]'

	String getGridItemRoleXpath(){
		return this.GridItemRoleXpath
	}

	@Keyword
	WebElement getGridItemRole(WebElement element){
		return brandcast.getChildElementByXpath(element, this.getGridItemRoleXpath())
	}


	//Grid Item Email
	private String GridItemEmailXpath = './/p[@class="member-email"]'

	String getGridItemEmailXpath(){
		return this.GridItemEmailXpath
	}

	@Keyword
	WebElement getGridItemEmail(WebElement element){
		return brandcast.getChildElementByXpath(element, this.getGridItemEmailXpath())
	}

	//Get Team Member Grid Items
	//Verify Team Member Details
	@Keyword
	def verifyTeamMemberDetails(List<WebElement> elementList) {
		elementList.find{
			WebElement membersPanel = it
			WebElement gridItemMenuIcon = this.getGridItemMenuIcon(membersPanel)
			WebElement gridItemDetails = this.getGridItemDetails(membersPanel)
			//Get Email
			WebElement getGridItemEmail = gridItemDetails.findElement(By.xpath('.//p[@class="member-email"]'))

			//Assert Name
			if(
			this.getGridItemName(gridItemDetails).getText() == this.gridDetialMapName() &&
			this.getGridItemRole(gridItemDetails).getText() == this.gridDetialMapRole() &&
			getGridItemEmail.getAttribute('innerHTML').toString() ==  this.gridDetialMapEmail()
			){
				KeywordUtil.markPassed(
						"Username: "+this.getGridItemName(gridItemDetails).getText()+
						"\nRole: "+this.getGridItemRole(gridItemDetails).getText()+
						"\nEmail: "+getGridItemEmail.getAttribute('innerHTML').toString()+
						"\nIs Verified!"
						)
			}
		}
	}

	//Remove User Confirmation Container
	private RemoveUserConfirmationContainerXpath = './/div[@data-overlay-id="removeuserconfirmationcontainer" and @class="bc-modal"]/div[@class="bc-modal-wrapper"]/div[@class="container-clear modal-system"]'

	String getRemoveUserConfirmationContainerXpath(){
		return this.RemoveUserConfirmationContainerXpath
	}

	@Keyword
	WebElement getRemoveUserConfirmationContainer(){
		return brandcast.getElementByXpath(this.getRemoveUserConfirmationContainerXpath())
	}

	//Remove User Confirmation Close
	private String RemoveUserConfirmationCloseXpath =  './/div[@class="close-container"]/div[@class="close"]'

	String getRemoveUserConfirmationCloseXpath(){
		return this.RemoveUserConfirmationCloseXpath
	}

	WebElement getRemoveUserConfirmationClose(){
		return brandcast.getChildElementByXpath(this.getRemoveUserConfirmationContainer(), this.getRemoveUserConfirmationCloseXpath())

	}

	WebElement clickRemoveUserConfirmationClose(){
		brandcast.clickChildWebElement(this.getRemoveUserConfirmationContainer(), this.getRemoveUserConfirmationCloseXpath())
	}

	//Remove User Confirmation Modal Buttons
	private String RemoveUserConfirmationModalButtonsXpath = './/div[@class="container-clear modal-btns"]'

	String getRemoveUserConfirmationModalButtonsXpath(){
		return this.RemoveUserConfirmationModalButtonsXpath
	}

	WebElement getRemoveUserConfirmationModalButtons(){
		return brandcast.getChildElementByXpath(this.getRemoveUserConfirmationContainer(), this.getRemoveUserConfirmationModalButtonsXpath())
	}


	//Remove User Confirmation Cancel Button
	private String RemoveUserConfirmationCancelButtonXpath = '//div[@class="ui-wrapper editor-style"]/button[@class="btn-html" and @type="button" and @data-qa-id="cancel-button"]'

	String getRemoveUserConfirmationCancelButtonXpath(){
		return this.RemoveUserConfirmationCancelButtonXpath
	}

	WebElement getRemoveUserConfirmationCancelButton(){
		return brandcast.getChildElementByXpath(this.getRemoveUserConfirmationModalButtons(), this.getRemoveUserConfirmationCancelButtonXpath())
	}

	WebElement clickRemoveUserConfirmationCancelButton(){
		brandcast.clickChildWebElement(this.getRemoveUserConfirmationModalButtons(), this.getRemoveUserConfirmationCancelButtonXpath())
	}

	//Remove User Confirmation Remove Users Buttons
	private String RemoveUserConfirmationRemoveUsersButtonXpath = '//div[@class="ui-wrapper editor-style primary"]/button[@class="btn-html" and @type="button" and @data-qa-id="delete-page-button"]'

	String getRemoveUserConfirmationRemoveUsersButtonXpath(){
		return this.RemoveUserConfirmationRemoveUsersButtonXpath
	}

	WebElement getRemoveUserConfirmationRemoveUsersButton(){
		return brandcast.getChildElementByXpath(this.getRemoveUserConfirmationModalButtons(), this.getRemoveUserConfirmationRemoveUsersButtonXpath())
	}

	WebElement clicktRemoveUserConfirmationRemoveUsersButton(){
		brandcast.clickChildWebElement(this.getRemoveUserConfirmationModalButtons(), this.getRemoveUserConfirmationRemoveUsersButtonXpath())
	}
}
