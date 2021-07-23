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


class MyBlocks {

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
	private String AdminContainerXpath = '//span[contains(@id,"app") and contains(@class,"design-studio-root")]/div[contains(@class,"inline")]/span[contains(@class,"app-container") and contains(@class,"hidden-launch") and contains(@class,"dashboard") and contains(@class,"app-ready") and contains(@class,"logged-in")  and contains(@class,"login-complete")]/div[@class="admin-wrapper"]'

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

	/**=============================================================================================================
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
	 * My Blocks Modal
	 * 
	 */
	private String MyBlocksModalXpath = './/div[@class="my-blocks flex module-wrapper"]/div[@class="module"]/div[contains(@class,"fl-wrap") and contains(@class, "direction-column")]'

	String getMyBlocksModalXpath(){
		this.MyBlocksModalXpath
	}

	WebElement getMyBlocksModal(){
		return brandcast.getChildElementByXpath(this.getAdminContent(), this.getMyBlocksModalXpath())
	}

	@Keyword
	def waitForMyBlocksModal(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getAdminContent(), this.getMyBlocksModalXpath())
	}

	/**=============================================================================================================
	 * 
	 * My Blocks Modal Header
	 * 
	 */
	private String MyBlocksModalHeaderXpath = './/div[@class="fl-row"]/div[@class="module-header-b"]'

	String getMyBlocksModalHeaderXpath(){
		this.MyBlocksModalHeaderXpath
	}

	WebElement getMyBlocksModalHeader(){
		return brandcast.getChildElementByXpath(this.getMyBlocksModal(), this.getMyBlocksModalHeaderXpath())
	}

	/* Module Header B Search */
	private String ModuleHeaderBSearchXpath = './/div[@class="module-header-b-search"]/div[@class="search-sort-bar"]'

	String getModuleHeaderBSearchXpath(){
		return this.ModuleHeaderBSearchXpath
	}

	WebElement getModuleHeaderBSearch(){
		return brandcast.getChildElementByXpath(this.getMyBlocksModalHeader(), this.getModuleHeaderBSearchXpath())
	}

	/* Sort By Last Update */
	private String SortByLastUpdateXpath = './/div[@class="sorting-wrapper"]/span[@class="sorting-ui"]/div[contains(@class,"bc-menu-group") and contains(@class,"menu-select")]'

	String getSortByLastUpdateXpath(){
		return this.SortByLastUpdateXpath
	}

	WebElement getSortByLastUpdate(){
		return brandcast.getChildElementByXpath(this.getMyBlocksModalHeader(), this.getSortByLastUpdateXpath())
	}

	@Keyword
	def clickSortByLastUpdate(){
		brandcast.clickChildWebElement(this.getMyBlocksModalHeader(), this.getSortByLastUpdateXpath())
	}

	/* Switch Order */
	private String SwitchOrderXpath = './/div[@class="sorting-wrapper"]/span[@class="sorting-ui"]/div[@title="Switch"]'

	String getSwitchOrderXpath(){
		return this.SwitchOrderXpath
	}

	WebElement getSwitchOrder(){
		return brandcast.getChildElementByXpath(this.getMyBlocksModalHeader(), this.getSwitchOrderXpath())
	}

	@Keyword
	def clickSwitchOrder(){
		brandcast.clickChildWebElement(this.getMyBlocksModalHeader(), this.getSwitchOrderXpath())
	}

	/* Import Blocks */
	private String ImportBlocksXpath = './/div[@class="sorting-wrapper"]/span[@class="sorting-ui"]/div[contains(@class,"import-ui") and contains(@class,"cs-permission-hide")]'

	String getImportBlocksXpath(){
		return this.ImportBlocksXpath
	}

	WebElement getImportBlocks(){
		return brandcast.getChildElementByXpath(this.getMyBlocksModalHeader(), this.getImportBlocksXpath())
	}

	@Keyword
	def clickImportBlocks(){
		brandcast.clickChildWebElement(this.getMyBlocksModalHeader(), this.getImportBlocksXpath())
	}

	/* Delete Block */
	private String DeleteBlockXpath = './/div[@class="sorting-wrapper"]/span[@class="sorting-ui"]/div[@title="Delete"]'

	String getDeleteBlockXpath(){
		return this.DeleteBlockXpath
	}

	WebElement getDeleteBlock(){
		return brandcast.getChildElementByXpath(this.getMyBlocksModalHeader(), this.getDeleteBlockXpath())
	}

	@Keyword
	def clickDeleteBlock(){
		brandcast.clickChildWebElement(this.getMyBlocksModalHeader(), this.getDeleteBlockXpath())
	}

	/**=============================================================================================================
	 * 
	 * Import Block Modal
	 * 
	 */
	private String ImportBlocksContainerXpath = '//div[@class="overlays-wrapper overlay-bounds"]/div[@data-overlay-id="importblockscontainer"]/div[@class="bc-modal-wrapper add-to-wrapper"]'

	String getImportBlocksContainerXpath(){
		return this.ImportBlocksContainerXpath
	}

	WebElement getImportBlocksContainer(){
		return brandcast.getElementByXpath(this.getImportBlocksContainerXpath())
	}

	@Keyword
	def waitForImportBlocksContainer(){
		brandcast.waitUntilPresenceOfElementLocatedBy(this.getImportBlocksContainerXpath())
	}

	/*Import Blocks Header Container*/
	private String ImportBlocksHeaderContainerXpath = './/div[@class="fl-box a header-container"]'

	String getImportBlocksHeaderContainerXpath(){
		return this.ImportBlocksHeaderContainerXpath
	}

	WebElement getImportBlocksHeaderContainer(){
		return brandcast.getChildElementByXpath(this.getImportBlocksContainer(), this.getImportBlocksHeaderContainerXpath())
	}

	/*Close Import Block Modal*/
	private String closeImportBlockModalXpath = './/div[@class="wa-close-container"]'

	String getcloseImportBlockModalXpath(){
		return this.closeImportBlockModalXpath
	}

	WebElement getcloseImportBlockModal(){
		return brandcast.getChildElementByXpath(this.getImportBlocksHeaderContainer(), this.getcloseImportBlockModalXpath())
	}

	@Keyword
	def moveToCloseImportBlockModal(){
		return brandcast.moveToChildElement(this.getImportBlocksHeaderContainer(), this.getcloseImportBlockModalXpath())
	}

	@Keyword
	def clickCloseImportBlockModal(){
		return brandcast.clickChildWebElement(this.getImportBlocksHeaderContainer(), this.getcloseImportBlockModalXpath())
	}

	/*Import Blocks Content Container*/
	private String ImportBlocksContentContainerXpath = './/div[@class="fl-box b col-wrapper"]'

	String getImportBlocksContentContainerXpath(){
		return this.ImportBlocksContentContainerXpath
	}

	WebElement getImportBlocksContentContainer(){
		return brandcast.getChildElementByXpath(this.getImportBlocksContainer(), this.getImportBlocksContentContainerXpath())
	}

	/*Import Blocks Tags*/
	private String ImportBlocksTagsXpath = './/div[@class="fl-wrap"]/div[@class="fl-box aa tags"]/div[@class="scroll-box"]'

	String getImportBlocksTagsXpath(){
		return this.ImportBlocksTagsXpath
	}

	WebElement getImportBlocksTags(){
		return brandcast.getChildElementByXpath(this.getImportBlocksContentContainer(), this.getImportBlocksTagsXpath())
	}

	/*Import Block Bodies*/
	private String ImportBlockBodiesXpath = './/div[@class="fl-wrap"]/div[@class="fl-box bb"]/div[@class="fl-wrap-column"]'

	String getImportBlockBodiesXpath(){
		return this.ImportBlockBodiesXpath
	}

	WebElement getImportBlockBodies(){
		return brandcast.getChildElementByXpath(this.getImportBlocksContentContainer(), this.getImportBlockBodiesXpath())
	}


	/*Import Modal Search Input Container*/
	private String ImportModalSearchInputContainerXpath ='.//div[@class="fl-box cc"]/div[@class="search-sort-bar"]/div[@class="search-input-container default-search cc"]'

	String getImportModalSearchInputContainerXpath(){
		return this.ImportModalSearchInputContainerXpath
	}

	WebElement getImportModalSearchInputContainer(){
		return brandcast.getChildElementByXpath(this.getImportBlockBodies(), this.getImportModalSearchInputContainerXpath())
	}

	/**=============================================================================================================
	 * 
	 * Import Modal Grid Block
	 * 
	 */
	private String ImportModalGridBlockXpath = './/div[@class="fl-box dd"]/div[@class="scroll-box"]/div[@class="grid-block"]'

	String getImportModalGridBlockXpath(){
		return this.ImportModalGridBlockXpath
	}

	WebElement getImportModalGridBlock(){
		return brandcast.getChildElementByXpath(this.getImportBlockBodies(), this.getImportModalGridBlockXpath())
	}

	@Keyword
	def movetoImportModalGridBlock(){
		return brandcast.moveToElementByWebElement(this.getImportModalGridBlock())
	}

	/*Import Virtual Grid Collection*/
	private String ImportVirtualGridCollectionXpath = './/div[@class="virtualized-grid"]/div[contains(@class,"box")]'

	String getImportVirtualGridCollectionXpath(){
		return this.ImportVirtualGridCollectionXpath
	}

	List<WebElement> getImportVirtualGridCollection(){
		return brandcast.getChildElementListByXpath(this.getImportModalGridBlock(), this.getImportVirtualGridCollectionXpath())
	}

	/*Get Night Life Block*/
	WebElement getTestBlock(){
		return brandcast.getWebElementFromListByText(this.getImportVirtualGridCollection(),"test")
	}

	/**=============================================================================================================
	 * 
	 * Box Details Title Xpath
	 * 
	 */
	private String BoxDetailsTitleXpath = './/div[@class="box-details"]/div[@class="box-wrapper"]/div[@class="title-date"]/h4'

	String getBoxDetailsTitleXpath(){
		return this.BoxDetailsTitleXpath
	}

	WebElement getBoxDetailsTitle(){
		return brandcast.getChildElementByXpath(this.getTestBlock(), this.getBoxDetailsTitleXpath())
	}

	/* Box Details Check Box Label */
	private String BoxDetailsCheckBoxLabelXpath = './/div[@class="box-details"]/div[@class="box-wrapper"]/div[@class="title-date"]/div[@class="item-selector"]/div[@class="fl-box bb check-box-label"]/p[@class="in-use-label"]'

	String getBoxDetailsCheckBoxLabelXpath(){
		return this.BoxDetailsCheckBoxLabelXpath
	}

	WebElement getBoxDetailsCheckBoxLabel(){
		return brandcast.getChildElementByXpath(this.getTestBlock(), this.getBoxDetailsCheckBoxLabelXpath())
	}

	/* Box Details Check Box Container */
	private String BoxDetailsCheckBoxContainerXpath = './/div[@class="box-details"]/div[@class="box-wrapper"]/div[@class="title-date"]/div[@class="item-selector"]/div[@class="check-box-container fl-box aa"]/div[@class="check-box"]'

	String getBoxDetailsCheckBoxContainerXpath(){
		return this.BoxDetailsCheckBoxContainerXpath
	}

	WebElement getBoxDetailsCheckBoxContainer(){
		return brandcast.getChildElementByXpath(this.getTestBlock(), this.getBoxDetailsCheckBoxContainerXpath())
	}

	@Keyword
	def clickBoxDetailsCheckBoxContainer(){
		brandcast.clickChildWebElement(this.getTestBlock(), this.getBoxDetailsCheckBoxContainerXpath())
	}

	@Keyword
	def moveToBoxDetailsCheckBoxContainer(){
		brandcast.moveToChildElement(this.getTestBlock(), this.getBoxDetailsCheckBoxContainerXpath())
	}

	/**=============================================================================================================
	 *
	 * My Blocks Modal Content
	 *
	 */
	private String MyBlocksModalContentXpath = './/div[@class="fl-row module-b-contents"]'

	String getMyBlocksModalContentXpath(){
		this.MyBlocksModalContentXpath
	}

	WebElement getMyBlocksModalContent(){
		return brandcast.getChildElementByXpath(this.getMyBlocksModal(), this.getMyBlocksModalContentXpath())
	}

	@Keyword
	def waitForMyBlocksModalContent(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getMyBlocksModal(), this.getMyBlocksModalContentXpath())
	}

	/*My Blocks Modal Content Area B*/
	private String MyBlocksModalContentAreaBXpath = './/div[@class="content-area-b"]/div[@class="main-wrapper"]/div[@class="account-blocks"]/div[@class="virtualized-grid"]'

	String getMyBlocksModalContentAreaBXpath(){
		return this.MyBlocksModalContentAreaBXpath
	}

	WebElement getMyBlocksModalContentAreaB(){
		return brandcast.getChildElementByXpath(this.getMyBlocksModalContent(), this.getMyBlocksModalContentAreaBXpath())
	}

	/*Import Virtual Grid Collection*/
	private String ImportMyBlockCollectionXpath = './/div[contains(@class,"box")]'

	String getImportMyBlockCollectionXpath(){
		return this.ImportMyBlockCollectionXpath
	}

	List<WebElement> getImportMyBlockCollection(){
		return brandcast.getChildElementListByXpath(this.getMyBlocksModalContentAreaB(), this.getImportMyBlockCollectionXpath())
	}

	/*Get Test Block*/
	WebElement getImportedTestBlock(){
		return brandcast.getWebElementFromListByText(this.getImportMyBlockCollection(),"test")
	}

	@Keyword
	def verifyImportedTestMyBlock(){
		if(this.getImportedTestBlock().isDisplayed()){
			KeywordUtil.markPassed("Successfully Verified Imported Test Block!")
		}else{
			KeywordUtil.markFailedAndStop("Failed to Verified Imported Test Block!")
		}
	}

	/**=============================================================================================================
	 *
	 * Box Details
	 *
	 */
	private String MyBlockBoxDetailsXpath = './/div[@class="box-details"]/div[@class="box-wrapper"]'

	String getMyBlockBoxDetailsXpath(){
		return this.MyBlockBoxDetailsXpath
	}

	WebElement getMyBlockBoxDetails(){
		return brandcast.getChildElementByXpath(this.getImportedTestBlock(), this.getMyBlockBoxDetailsXpath())
	}

	/**=============================================================================================================
	 *
	 * Box Details Title Xpath
	 *
	 */
	private String MyBlockBoxDetailsTitleXpath = './/div[@class="box-details"]/div[@class="box-wrapper"]/div[@class="title-date-wrap"]/div[@class="title-date blocks"]/div[@class="default-name-wrap"]/div[@class="swap-container clearfix fl-box aa"]'

	String getMyBlockBoxDetailsTitleXpath(){
		return this.MyBlockBoxDetailsTitleXpath
	}

	WebElement getMyBlockBoxDetailsTitle(){
		return brandcast.getChildElementByXpath(this.getImportedTestBlock(), this.getMyBlockBoxDetailsTitleXpath())
	}

	/* Box Details Check Box Label */
	private String MyBlockBoxDetailsCheckBoxLabelXpath = './/div[@class="box-details"]/div[@class="box-wrapper"]/div[@class="title-date-wrap"]/div[@class="title-date blocks"]/div[@class="fl-box bb"]'

	String getMyBlockBoxDetailsCheckBoxLabelXpath(){
		return this.MyBlockBoxDetailsCheckBoxLabelXpath
	}

	/**/
	WebElement getMyBlockBoxDetailsCheckBoxLabel(){
		return brandcast.getChildElementByXpath(this.getImportedTestBlock(), this.getMyBlockBoxDetailsCheckBoxLabelXpath())
	}

	@Keyword
	def clickMyBlockDetailsCheckBoxContainer(){
		brandcast.clickWebElement(this.getImportedTestBlock())
	}

	@Keyword
	def moveToMyBlockDetailsCheckBoxContainer(){
		brandcast.moveToElementByWebElement(this.getImportedTestBlock())
	}

	/*Get Selected Imported Test Block*/
	WebElement getSelectedImportedTestBlock(){
		if(this.getImportedTestBlock().getAttribute("class").toString().contains("selected")){
			return this.getImportedTestBlock()
		}
	}

	/**
	 * 
	 * Block Details
	 * 
	 */
	private SelectedImportedTestBoxBlockMenuXpath = './/div[@class="box-thumbnail-wrapper"]/div[@class="box-thumbnail"]/div[@class="box-action-ui"]/div[@class="bc-menu-group website-menu cs-permission-hide light-theme"]/div[@class="menu-item" and @data-identifier="block-menu"]/div[@title="Block Menu" and @class="btn-blank bullet-btn"]'

	String getSelectedImportedTestBoxBlockMenuXpath(){
		return this.SelectedImportedTestBoxBlockMenuXpath
	}

	WebElement getSelectedImportedTestBoxBlockMenu(){
		return brandcast.getChildElementByXpath(this.getSelectedImportedTestBlock(), this.getSelectedImportedTestBoxBlockMenuXpath())
	}

	@Keyword
	def clickSelectedImportedTestBoxBlockMenu(){
		brandcast.clickWebElement(this.getSelectedImportedTestBoxBlockMenu())
	}


	/*Test Block*/
	WebElement selectTestBlock(){
		for(WebElement element: this.getImportMyBlockCollection()){
			if(element.getText().contains("test")){
				return element
			}
		}
	}

	/**
	 *
	 * Block Details
	 *
	 */
	private TestBoxBlockMenuXpath = './/div[@class="box-thumbnail-wrapper"]/div[@class="box-thumbnail"]/div[@class="box-action-ui"]/div[@class="bc-menu-group website-menu cs-permission-hide light-theme"]/div[@class="menu-item" and @data-identifier="block-menu"]/div[@title="Block Menu" and @class="btn-blank bullet-btn"]'

	String getTestBoxBlockMenuXpath(){
		return this.TestBoxBlockMenuXpath
	}

	WebElement getTestBoxBlockMenu(){
		return brandcast.getChildElementByXpath(this.selectTestBlock(), this.getTestBoxBlockMenuXpath())
	}

	@Keyword
	def clickTestBoxBlockMenu(){
		brandcast.clickWebElement(this.selectTestBlock())
	}

	private String TestBlockContextMenuXpath = './/div[@class="box-thumbnail-wrapper"]/div[@class="box-thumbnail"]/div[@class="box-action-ui"]'//div[contains(@class,"bc-menu-group") and contains(@class,"website-menu") and contains(@class,"cs-permission-hide") and contains(@class,"active")]/div[contains(@class,"menu-item") and contains(@data-identifie,"block-menu")]/div[@class="menu-dropdown"]'

	String getTestBlockContextMenuXpath(){
		return this.TestBlockContextMenuXpath
	}

	WebElement getTestBlockContextMenu(){
		return brandcast.getChildElementByXpath(this.selectTestBlock(), this.getTestBlockContextMenuXpath())
	}

	private String TestBlockDropDownMenuXpath = '//div[contains(@class,"bc-menu-group") and contains(@class,"website-menu") and contains(@class,"cs-permission-hide") and contains(@class,"active")]/div[contains(@class,"menu-item") and contains(@data-identifier,"block-menu")]/div[@class="menu-dropdown"]'

	String getTestBlockDropDownMenuXpath(){
		return this.TestBlockDropDownMenuXpath
	}

	WebElement getTestBlockDropDownMenu(){
		return brandcast.getChildElementByXpath(this.getTestBlockContextMenu(), this.getTestBlockDropDownMenuXpath())
	}

	@Keyword
	def waitForestBlockDropDownMenu(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getTestBlockContextMenu(), this.getTestBlockDropDownMenuXpath())
	}

	/* Add / Remove Tags */
	private String MenuOptionAddRemoveTagsXpath ='//div[contains(@class,"ui-wrapper btn-row-wrapper")]/div[@class="btn-row"]/div[@class="btn-row-label"]/h4[contains(text(), "Add / Remove Tags")]/../..'

	String getMenuOptionAddRemoveTagsXpath(){
		return this.MenuOptionAddRemoveTagsXpath
	}
	WebElement getMenuOptionAddRemoveTags(){
		return brandcast.getChildElementByXpath(this.getTestBlockDropDownMenu(), this.getMenuOptionAddRemoveTagsXpath())
	}

	@Keyword
	def clickMenuOptionAddRemoveTags(){
		brandcast.clickWebElement(this.getMenuOptionAddRemoveTags())
	}

	@Keyword
	def waitForMenuOptionAddRemoveTags(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getTestBlockDropDownMenu(), this.getMenuOptionAddRemoveTagsXpath())
	}

	/* Menu Option - Make Default Block*/
	private String MenuOptionMakeDefaultBlockXpath = '//div[contains(@class,"ui-wrapper") and contains(@class,"btn-row-wrapper") contains(@class,"cs-permission-disable")]/div[@class="btn-row"]/div[@class="btn-row-label"]/h4[contains(text(),"Make Default Block")]/../..'

	String getMenuOptionMakeDefaultBlockXpath(){
		return this.MenuOptionMakeDefaultBlockXpath
	}

	WebElement getMenuOptionMakeDefaultBlock(){
		return brandcast.getChildElementByXpath(this.getTestBlockDropDownMenu(), this.getMenuOptionMakeDefaultBlockXpath())
	}

	@Keyword
	def clickMenuOptionMakeDefaultBlock(){
		brandcast.clickWebElement(this.getMenuOptionMakeDefaultBlock())
	}

	@Keyword
	def waitForMenuOptionMakeDefaultBlock(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getTestBlockDropDownMenu(), this.getMenuOptionMakeDefaultBlockXpath())
	}

	/* Menu Option - Delete Block*/
	private MenuOptionDeleteBlockXpath = '//div[@class="ui-wrapper btn-row-wrapper accented cs-permission-disable"]/div[@class="btn-row"]/div[@class="btn-row-label"]/h4[contains(text(),"Delete Block")]/../..'

	String getMenuOptionDeleteBlockXpath(){
		return this.MenuOptionDeleteBlockXpath
	}

	WebElement getMenuOptionDeleteBlock(){
		return brandcast.getChildElementByXpath(this.getTestBlockDropDownMenu(), this.getMenuOptionDeleteBlockXpath())
	}

	@Keyword
	def clickMenuOptionDeleteBlock(){
		brandcast.clickWebElement(this.getMenuOptionDeleteBlock())
	}

	@Keyword
	def waitForMenuOptionDeleteBlock(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getTestBlockDropDownMenu(), this.getMenuOptionDeleteBlockXpath())
	}

	/**
	 *
	 * Delete Website Modal
	 *
	 */
	private String DeleteBlockModalXpath = '//span[contains(@class,"app-container") and contains(@class,"hidden-launch") and contains(@class,"dashboard") and contains(@class,"app-ready") and contains(@class,"logged-in") and contains(@class, "login-complete") and contains(@class, "modal-open")]/span/div[contains(@class,"overlays-wrapper") and contains(@class,"overlay-bounds")]/div[contains(@data-overlay-id,"deletedesignsnippetsconfirmationcontainer") and contains(@class,"bc-modal")]/div[@class="bc-modal-wrapper"]'

	String getDeleteBlockModalXpath(){
		this.DeleteBlockModalXpath
	}

	WebElement getDeleteBlockModal(){
		return brandcast.getElementByXpath(this.getDeleteBlockModalXpath())
	}

	@Keyword
	def waitForDeleteBlockModal(){
		brandcast.waitUntilPresenceOfElementLocatedBy(this.getDeleteBlockModalXpath())
	}

	/**
	 *
	 * Delete Website Modal Delete Block Button
	 *
	 */
	private String DeleteModalDeleteBtnXpath = './/div[@class="container-clear modal-system"]/div[contains(@class,"container-clear") and contains(@class,"modal-btns")]/div[contains(@class,"ui-wrapper") and contains(@class,"editor-style") and contains(@class,"primary")]/button/div[contains(@class,"btn-html-label") and contains(text(),"Delete")]'

	String getDeleteModalDeleteBtnXpath(){
		return this.DeleteModalDeleteBtnXpath
	}

	WebElement getDeleteModalDeleteBtn(){
		return brandcast.getChildElementByXpath(this.getDeleteBlockModal(), this.getDeleteModalDeleteBtnXpath())
	}

	@Keyword
	def clickDeleteModalDeleteBtn(){
		brandcast.clickChildWebElement(this.getDeleteBlockModal(), this.getDeleteModalDeleteBtnXpath())
	}

	/**
	 *
	 * Delete Website Modal Cancel Button
	 *
	 */
	private String DeleteModalCancelBtnXpath = './/div[@class="container-clear modal-system"]/div[contains(@class,"container-clear") and contains(@class,"modal-btns")]/div[contains(@class,"ui-wrapper") and contains(@class,"editor-style")]/button/div[contains(@class,"btn-html-label") and contains(text(),"Cancel")]'

	String getDeleteModalCancelBtnXpath(){
		return this.DeleteModalCancelBtnXpath
	}

	WebElement getDeleteModalCancelBtn(){
		return brandcast.getChildElementByXpath(this.getDeleteBlockModal(), this.getDeleteModalCancelBtnXpath())
	}

	@Keyword
	def clickDeleteModalCancelBtn(){
		brandcast.clickChildWebElement(this.getDeleteBlockModal(), this.getDeleteModalCancelBtnXpath())
	}

	/*Test Block*/
	@Keyword
	def verifyDeletedTestBlock(){
		for(WebElement element:this.getImportMyBlockCollection()){
			if(element.getText().contains("test")){
				KeywordUtil.markFailedAndStop("Test Block was not deleted!")
				return
			}
		}
	}

}