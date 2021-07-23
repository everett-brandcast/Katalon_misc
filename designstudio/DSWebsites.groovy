package com.designstudio

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

import org.junit.After
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
import com.brandcast.BcMain


public class DSWebsites {
	BcMain bcmain = new BcMain()
	Core brandcast = new Core()
	Utils utils = new Utils()

	/**
	 * My-Website Module New Tag Identifier
	 **/
	private newTagIdentifier = utils.getTimeStampName()

	String getnewTagIdentifier() {
		return this.newTagIdentifier
	}

	/**
	 * My-Website Module
	 **/
	private String MyWebsiteModuleXpath = './/div[contains(@class,"my-websites") and contains(@class,"flex") and contains(@class,"module-wrapper")]/div[contains(@class,"module")]/div[contains(@class,"fl-wrap") and contains(@class,"direction-column")]'

	String getMyWebsiteModuleXpath(){
		return this.MyWebsiteModuleXpath
	}

	WebElement getMyWebsiteModule(){
		return brandcast.getChildElementByXpath(bcmain.getAdminContainer(), this.getMyWebsiteModuleXpath())
	}

	/**
	 * My-Website Module Content
	 **/
	private String MyWebsiteModuleContentXpath = './/div[contains(@class,"fl-row") and contains(@class,"module-b-contents")]/div[contains(@class,"col-wrapper")]/div[contains(@class,"side-bar")]/div[contains(@class,"fl-wrap") and contains(@class,"direction-column")]/div[contains(@class,"fl-row") and contains(@class,"side-bar-contents")]/div[contains(@class,"side-bar-child")]'

	String getMyWebsiteModuleContentXpath(){
		return this.MyWebsiteModuleContentXpath
	}

	WebElement getMyWebsiteModuleContent(){
		return brandcast.getChildElementByXpath(this.getMyWebsiteModule(), this.getMyWebsiteModuleContentXpath())
	}

	/**
	 * My-Website Module View All Link
	 **/
	private MyWebsiteModuleViewAllLinkXpath = './/div[contains(@class,"all-btn")]'

	String getMyWebsiteModuleViewAllLinkXpath(){
		return this.MyWebsiteModuleViewAllLinkXpath
	}

	WebElement getMyWebsiteModuleViewAllLink(){
		return brandcast.getChildElementByXpath(this.getMyWebsiteModuleContent(), this.getMyWebsiteModuleViewAllLinkXpath())
	}

	@Keyword
	def clickMyBrandcastLeftPanelLink(){
		brandcast.clickChildWebElement(this.getMyWebsiteModuleContent(), this.getMyWebsiteModuleViewAllLinkXpath())
	}

	/**
	 * My-Website Module Edit Tags Link
	 **/
	private MyWebsiteModuleEditTagsLinkXpath = './/div[contains(@class,"tag-filter-list")]/p[contains(@class,"edit-list-btn") and contains(@class,"cs-permission-hide")]'

	String getMyWebsiteModuleEditTagsLinkXpath(){
		return this.MyWebsiteModuleEditTagsLinkXpath
	}

	WebElement getMyWebsiteModuleEditTagsLink(){
		return brandcast.getChildElementByXpath(this.getMyWebsiteModuleContent(), this.getMyWebsiteModuleEditTagsLinkXpath())
	}

	@Keyword
	def clickMyWebsiteModuleEditTagsLink(){
		brandcast.clickChildWebElement(this.getMyWebsiteModuleContent(), this.getMyWebsiteModuleEditTagsLinkXpath())
	}

	/**
	 * My-Website Module Edit Snippet Container
	 **/
	private String MyWebsiteModuleEditSnippetContainerXpath = '//div[contains(@class,"edit-snippet-container")]'

	String getMyWebsiteModuleEditSnippetContainerXpath() {
		return this.MyWebsiteModuleEditSnippetContainerXpath
	}

	WebElement getMyWebsiteModuleEditSnippetContainer(){
		return brandcast.getElementByXpath(this.getMyWebsiteModuleEditSnippetContainerXpath())
	}

	/**
	 * My-Website Module Edit Snippet Container Header
	 **/
	private String MyWebsiteModuleEditSnippetContainerHeaderXpath = './/div[contains(@class,"edit-snippet-container")]'

	String getMyWebsiteModuleEditSnippetContainerHeaderXpath() {
		return this.MyWebsiteModuleEditSnippetContainerHeaderXpath
	}

	WebElement getMyWebsiteModuleEditSnippetContainerHeader(){
		return brandcast.getChildElementByXpath(this.getMyWebsiteModuleEditSnippetContainer(), this.getMyWebsiteModuleEditSnippetContainerHeaderXpath())
	}

	/**
	 * My-Website Module Edit Snippet Close Container 
	 **/
	private String MyWebsiteModuleEditSnippetCloseContainerXpath = './/div[contains(@class,"wa-close-container")]'

	String getMyWebsiteModuleEditSnippetCloseContainerXpath() {
		return this.MyWebsiteModuleEditSnippetCloseContainerXpath
	}

	WebElement getMyWebsiteModuleEditSnippetCloseContainer() {
		return brandcast.getChildElementByXpath(this.getMyWebsiteModuleEditSnippetContainer(), this.getMyWebsiteModuleEditSnippetCloseContainerXpath())
	}

	@Keyword
	def clickMyWebsiteModuleEditSnippetCloseContainer(){
		brandcast.clickChildWebElement(this.getMyWebsiteModuleEditSnippetContainer(), this.getMyWebsiteModuleEditSnippetCloseContainerXpath())
	}

	/**
	 * My-Website Module Edit Snippet Tag Name Form
	 **/

	private String MyWebsiteModuleEditSnippetTagFormXpath = './/div[contains(@class,"name-container fl-box b")]'

	String getMyWebsiteModuleEditSnippetTagFormXpath() {
		return this.MyWebsiteModuleEditSnippetTagFormXpath
	}

	WebElement getMyWebsiteModuleEditSnippetTagForm(){
		return brandcast.getChildElementByXpath(this.getMyWebsiteModuleEditSnippetContainer(), this.getMyWebsiteModuleEditSnippetTagFormXpath())
	}

	/**
	 * My-Website Module Edit Snippet Tag Name Input
	 **/
	private String MyWebsiteModuleEditSnippetTagInputXpath = './/form/div[contains(@class,"ui-wrapper") and contains(@class,"full-width") and contains(@class,"fl-wrap") and contains(@class, "aa") and contains(@class,"size-B") and contains(@class, "white-theme") and contains(@title,"Add Tag")]/div[contains(@class,"text-input-container")]/label/div[contains(@class,"text-input-wrapper")]/input[contains(@name,"tagName") and contains(@type,"text") and contains(@class,"text-input") and contains(@placeholder,"Enter a new tag name here and click add")]'

	String getMyWebsiteModuleEditSnippetTagInputXpath() {
		return this.MyWebsiteModuleEditSnippetTagInputXpath
	}

	WebElement getMyWebsiteModuleEditSnippetTagInput(){
		return brandcast.getChildElementByXpath(this.getMyWebsiteModuleEditSnippetTagForm(), this.getMyWebsiteModuleEditSnippetTagInputXpath())
	}

	@Keyword
	def sendNewTagName() {
		brandcast.executeJavascriptSetAttribute(this.getMyWebsiteModuleEditSnippetTagInput(), "value", this.getnewTagIdentifier())
	}

	/**
	 * My Website Module Edit Snippet Tag Add Button
	 **/
	private String MyWebsiteModuleEditSnippetTagAddButtonXpath = './/button[@type="submit"]'

	String getMyWebsiteModuleEditSnippetTagAddButtonXpath() {
		return this.MyWebsiteModuleEditSnippetTagAddButtonXpath
	}

	WebElement getMyWebsiteModuleEditSnippetTagAddButton(){
		return brandcast.getChildElementByXpath(this.getMyWebsiteModuleEditSnippetTagForm(), this.getMyWebsiteModuleEditSnippetTagAddButtonXpath())
	}

	@Keyword
	def clicktMyWebsiteModuleEditSnippetTagAddButton(){
		brandcast.executeJavascriptClickElement(this.getMyWebsiteModuleEditSnippetTagAddButton())
	}

	/**
	 * MyWebsite Module Edit Snippet Tag Full Data List
	 **/
	private String MyWebsiteModuleEditSnippetTagDataListXpath = './/div[contains(@class,"tag-list edit-tag-list fl-box c")]/div[contains(@class,"tag-selection-wrapper")]'

	String getMyWebsiteModuleEditSnippetTagDataListXpath() {
		return this.MyWebsiteModuleEditSnippetTagDataListXpath
	}


	@Keyword
	List<WebElement> getMyWebsiteModuleEditSnippetTagDataList(){
		return brandcast.getChildElementListByXpath(this.getMyWebsiteModuleEditSnippetContainer(), this.getMyWebsiteModuleEditSnippetTagDataListXpath())
	}



	WebElement getMyWebsiteModuleEditSnippetTagDataContainer(){
		return brandcast.getChildElementByXpath(this.getMyWebsiteModuleEditSnippetContainer(), this.getMyWebsiteModuleEditSnippetTagDataListXpath())
	}

	/**
	 * MyWebsite Module Edit Snippet Tag H5 List
	 **/
	private String MyWebsiteModuleEditSnippetTagListXpath = './/div[contains(@class,"tag-list") and contains(@class,"edit-tag-list") and contains(@class,"fl-box c")]/div[contains(@class,"tag-selection-wrapper")]/div[contains(@class,"tag-lockup")]/div[contains(@class,"tag-title")]/div[contains(@class,"swap-container clearfix")]/h5'

	String getMyWebsiteModuleEditSnippetTagListXpath() {
		return this.MyWebsiteModuleEditSnippetTagListXpath
	}

	@Keyword
	List<WebElement> getMyWebsiteModuleEditSnippetTagList(){
		return brandcast.getChildElementListByXpath(this.getMyWebsiteModuleEditSnippetContainer(), this.getMyWebsiteModuleEditSnippetTagListXpath())
	}

	@Keyword
	WebElement verifyTagInList() {
		for(WebElement webelement: this.getMyWebsiteModuleEditSnippetTagList()) {
			if(this.getnewTagIdentifier() == webelement.getText()) {
				KeywordUtil.markPassed("Successfully verified new Tag in List!")
				break
			}else{
				continue
			}
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Could Not find new Tag in List!")
		}
	}

	@Keyword
	WebElement getTagfromList(){

		if(!this.getMyWebsiteModuleEditSnippetTagDataList().isEmpty()){
			for(WebElement webelement: this.getMyWebsiteModuleEditSnippetTagDataList()){
				String EditSnippetTagContainerInputXpath = './/div[contains(@class,"tag-lockup")]/div[contains(@class,"tag-title")]/div[contains(@class,"swap-container clearfix")]/input'
				String EditSnippetTagContainerTitleXpath = './/div[contains(@class,"tag-lockup")]/div[contains(@class,"tag-title")]/div[contains(@class,"swap-container clearfix")]/h5'
				String EditSnippetTagContainerTagRenameXpath  = './/div[contains(@class,"tag-rename")]'
				String EditSnippetTagContainerTagDeleteXpath  = './/div[contains(@class,"tag-delete")]'


				WebElement TagContainerInput = webelement.findElement(By.xpath(EditSnippetTagContainerInputXpath))
				WebElement TagContainerTitleElement = webelement.findElement(By.xpath(EditSnippetTagContainerTitleXpath))
				WebElement TagContainerTagRenameElement = webelement.findElement(By.xpath(EditSnippetTagContainerTagRenameXpath))
				WebElement TagContainerTagDeleteElement = webelement.findElement(By.xpath(EditSnippetTagContainerTagDeleteXpath))

				println("Input Type: "+TagContainerInput.getAttribute("type"))
				println("Title: "+TagContainerTitleElement.getText())
				println("Tag Container Tag Rename : "+TagContainerTagRenameElement)
				println("Tag Container Tag Delete : "+TagContainerTagDeleteElement)

				if(this.getnewTagIdentifier() == TagContainerTitleElement.getText()) {
					return webelement
					break
				}else{
					continue
				}
				WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
				KeywordUtil.markFailedAndStop("Could Not find new Tag in List!")
			}
		}else {
			KeywordUtil.markFailedAndStop("Could Not find Website List!")
		}
	}

	@Keyword
	WebElement clickRenameTag(){
		if(!this.getMyWebsiteModuleEditSnippetTagDataList().isEmpty()){

			for(WebElement webelement: this.getMyWebsiteModuleEditSnippetTagDataList()){


				String EditSnippetTagContainerInputXpath = './/div[contains(@class,"tag-lockup")]/div[contains(@class,"tag-title")]/div[contains(@class,"swap-container clearfix")]/input'
				String EditSnippetTagContainerTitleXpath = './/div[contains(@class,"tag-lockup")]/div[contains(@class,"tag-title")]/div[contains(@class,"swap-container clearfix")]/h5'
				String EditSnippetTagContainerTagRenameXpath  = './/div[contains(@class,"tag-rename")]'
				String EditSnippetTagContainerTagDeleteXpath  = './/div[contains(@class,"tag-delete")]'


				WebElement TagContainerInput = webelement.findElement(By.xpath(EditSnippetTagContainerInputXpath))
				WebElement TagContainerTitleElement = webelement.findElement(By.xpath(EditSnippetTagContainerTitleXpath))
				String TitleElement = TagContainerTitleElement.getText()
				WebElement TagContainerTagRenameElement = webelement.findElement(By.xpath(EditSnippetTagContainerTagRenameXpath))
				WebElement TagContainerTagDeleteElement = webelement.findElement(By.xpath(EditSnippetTagContainerTagDeleteXpath))



				println("Input Type: "+TagContainerInput.getAttribute("type"))
				println("Title: "+TagContainerTitleElement.getText())
				println("Tag Container Tag Rename : "+TagContainerTagRenameElement)
				println("Tag Container Tag Delete : "+TagContainerTagDeleteElement)

				if(this.getnewTagIdentifier() == TagContainerTitleElement.getText()) {
					TagContainerTagRenameElement.click()
					String UpdateTitle = TitleElement+"-"+utils.getDateSerial()
					TagContainerInput.sendKeys(UpdateTitle)
					WebUI.delay(3)
					TagContainerInput.sendKeys(Keys.ENTER)
					break
				}else{
					continue
				}
				WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
				KeywordUtil.markFailedAndStop("Could Not find new Tag in List!")
			}
		}else {
			KeywordUtil.markFailedAndStop("Could Not find Website List!")
		}
	}

	/**
	 * Delete Tag Modal Container
	 **/
	private String DeleteTagModalXpath = '//div[contains(@data-overlay-id,"deletetagconfirmationcontainer") and contains(@class,"bc-modal")]/div[contains(@class,"bc-modal-wrapper")]/div[contains(@class,"container-clear") and contains(@class,"modal-system")]'

	String getDeleteTagModalXpath() {
		return this.DeleteTagModalXpath
	}

	@Keyword
	WebElement getDeleteTagModal() {
		return brandcast.getChildElementByXpath(this.getMyWebsiteModuleEditSnippetContainer(), this.getDeleteTagModalXpath())
	}

	/**
	 * Delete Tag Modal Container Close Button
	 **/
	private String DeleteTagModalCloseButtonXpath = './/div[contains(@class,"close-container")]/div[contains(@class,"close")]'

	String getDeleteTagModalCloseButtonXpath(){
		return this.DeleteTagModalCloseButtonXpath
	}
	@Keyword
	WebElement getDeleteTagModalCloseButton(){
		return brandcast.getChildElementByXpath(this.getDeleteTagModal(), this.getDeleteTagModalCloseButtonXpath())
	}

	@Keyword
	def clickTagModalCloseButton(){
		this.getMyWebsiteModuleEditSnippetCloseContainer().click()
	}

	/**
	 * Delete Tag Modal Container Buttons
	 */
	private String DeleteTagModalButtonsXpath = '//div[contains(@class,"container-clear modal-btns")]'

	String getDeleteTagModalButtonsXpath() {
		return this.DeleteTagModalButtonsXpath
	}

	@Keyword
	WebElement getDeleteTagModalButtons() {
		return brandcast.getChildElementByXpath(this.getDeleteTagModal(), this.getDeleteTagModalButtonsXpath())
	}

	/**
	 * Delete Tag Modal Container Cancel Buttons
	 */
	private String DeleteTagModalCancelButtonXpath = './/div[contains(@class,"ui-wrapper editor-style")]/button[contains(@type,"button") and contains(@data-qa-id,"cancel-button")]'

	String getDeleteTagModalCancelButtonXpath() {
		return this.DeleteTagModalCancelButtonXpath
	}

	@Keyword
	WebElement getDeleteTagModalCancelButton(){
		return brandcast.getChildElementByXpath(this.getDeleteTagModalButtons(), this.getDeleteTagModalCancelButtonXpath())
	}

	@Keyword
	def clickTagModalCancelButton(){
		this.getDeleteTagModalCancelButtonXpath().click()
	}

	/**
	 * Delete Tag Modal Container Delete Buttons
	 */
	private String DeleteTagModalDeleteButtonXpath = './/div[contains(@class,"ui-wrapper editor-style primary")]/button[contains(@type,"button") and contains(@data-qa-id,"delete-website-button")]'

	String getDeleteTagModalDeleteButtonXpath() {
		return this.DeleteTagModalDeleteButtonXpath
	}

	@Keyword
	WebElement getDeleteTagModalDeleteButton() {
		return brandcast.getChildElementByXpath(this.getDeleteTagModalButtons(), this.getDeleteTagModalDeleteButtonXpath())
	}

	@Keyword
	def clicktTagModalDeleteButton(){
		brandcast.clickWebElement(this.getDeleteTagModalDeleteButton())
	}

	/**
	 * Delete Rename Tag
	 **/
	@Keyword
	WebElement deleteRenameTag(){
		if(!this.getMyWebsiteModuleEditSnippetTagDataList().isEmpty()){
			for(WebElement webelement: this.getMyWebsiteModuleEditSnippetTagDataList()){
				String EditSnippetTagContainerTitleXpath = './/div[contains(@class,"tag-lockup")]/div[contains(@class,"tag-title")]/div[contains(@class,"swap-container clearfix")]/h5'
				String EditSnippetTagContainerTagDeleteXpath  = './/div[contains(@class,"tag-delete")]'

				WebElement TagContainerTitleElement = webelement.findElement(By.xpath(EditSnippetTagContainerTitleXpath))
				String TitleElement = TagContainerTitleElement.getText()
				WebElement TagContainerTagDeleteElement = webelement.findElement(By.xpath(EditSnippetTagContainerTagDeleteXpath))

				if(this.getnewTagIdentifier() == TitleElement) {
					TagContainerTagDeleteElement.click()
					WebUI.delay(3)
					this.getDeleteTagModalDeleteButton().sendKeys(Keys.ENTER)
					break
				}else{
					continue
				}
				WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
				KeywordUtil.markFailedAndStop("Could Not find new Tag in List!")
			}
		}else {
			KeywordUtil.markFailedAndStop("Could Not find Website List!")
		}
	}

	/**
	 * Cancel Delete Rename Tag
	 **/
	@Keyword
	WebElement cancelDeleteRenameTag(){
		if(!this.getMyWebsiteModuleEditSnippetTagDataList().isEmpty()){

			for(WebElement webelement: this.getMyWebsiteModuleEditSnippetTagDataList()){
				String EditSnippetTagContainerTitleXpath = './/div[contains(@class,"tag-lockup")]/div[contains(@class,"tag-title")]/div[contains(@class,"swap-container clearfix")]/h5'
				String EditSnippetTagContainerTagDeleteXpath  = './/div[contains(@class,"tag-delete")]'

				WebElement TagContainerTitleElement = webelement.findElement(By.xpath(EditSnippetTagContainerTitleXpath))
				String TitleElement = TagContainerTitleElement.getText()
				WebElement TagContainerTagDeleteElement = webelement.findElement(By.xpath(EditSnippetTagContainerTagDeleteXpath))

				if(this.getnewTagIdentifier() == TitleElement) {
					TagContainerTagDeleteElement.click()
					WebUI.delay(3)
					this.getDeleteTagModalCancelButton().sendKeys(Keys.ENTER)
					break
				}else{
					continue
				}
				WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
				KeywordUtil.markFailedAndStop("Could Not find new Tag in List!")
			}
		}else {
			KeywordUtil.markFailedAndStop("Could Not find Website List!")
		}
	}

	/**
	 * New Website Overlay
	 **/
	private String NewWebsiteOverlayXpath = '//span[contains(@id,"app") and contains(@class,"design-studio-root")]/div[contains(@class,"inline")]/span[contains(@class,"app-container hidden-launch dashboard app-ready logged-in login-complete modal-open")]'

	String getNewWebsiteOverlayXpath(){
		return this.NewWebsiteOverlayXpath
	}

	WebElement getNewWebsiteOverlay(){
		return brandcast.getElementByXpath(this.getNewWebsiteOverlayXpath())
	}

	/**
	 * Websites Module B Contents
	 **/
	private String WebsitesModuleBContentsXpath = './/div[contains(@class,"fl-row module-b-contents")]/div[contains(@class,"col-wrapper")]'

	String getWebsitesModuleBContentsXpath(){
		return this.WebsitesModuleBContentsXpath
	}

	@Keyword
	WebElement getWebsitesModuleBContents(){
		return brandcast.getChildElementByXpath(this.getMyWebsiteModule(), this.getWebsitesModuleBContentsXpath())
	}

	/**
	 * Websites SideBar Contents
	 **/
	private String WebsitesSideBarContentsXpath = './/div[contains(@class,"side-bar")]/div[contains(@class,"fl-wrap height-100 direction-column")]/div[contains(@class,"fl-row side-bar-contents")]/div[contains(@class,"side-bar-child")]'

	String getWebsitesSideBarContentsXpath(){
		return this.WebsitesSideBarContentsXpath
	}

	@Keyword
	WebElement getWebsitesSideBarContents(){
		return brandcast.getChildElementByXpath(this.getWebsitesModuleBContents(), this.getWebsitesSideBarContentsXpath())
	}

	/**
	 * Websites View All Icon
	 **/
	private String WebsitesViewAllIconXpath = './/div[contains(@class,"all-btn")]/div[contains(@class,"icon")]'

	String getWebsitesViewAllIconXpath(){
		return this.WebsitesViewAllIconXpath
	}

	@Keyword
	WebElement getWebsitesViewAllIcon(){
		return brandcast.getChildElementByXpath(this.getWebsitesSideBarContents(), this.getWebsitesViewAllIconXpath())
	}

	/**
	 * Websites Count
	 **/
	private String  WebsitesCountXpath = './/div[contains(@class,"all-btn")]/span[contains(@class,"count")]'

	String  getWebsitesCountXpath(){
		return this.WebsitesCountXpath
	}

	@Keyword
	WebElement getWebsitesCount(){
		return brandcast.getChildElementByXpath(this.getWebsitesSideBarContents(), this.getWebsitesCountXpath())
	}

	/**
	 * Websites Virtualized Grid
	 **/
	private String WebsitesVirtualizedGridXpath = '//div[contains(@class,"account-websites")]/div/div/div[contains(@class,"virtualized-grid")]'

	String getWebsitesVirtualizedGridXpath(){
		return this.WebsitesVirtualizedGridXpath
	}

	@Keyword
	WebElement getWebsitesVirtualizedGrid(){
		return brandcast.getChildElementByXpath(this.getWebsitesModuleBContents(), this.getWebsitesVirtualizedGridXpath())
	}

	/**
	 * Websites Virtualized Grid Items
	 **/
	private String WebsitesVirtualizedGridItemsXpath = '//div[@class="box"]'

	String getWebsitesVirtualizedGridItemsXpath(){
		return this.WebsitesVirtualizedGridItemsXpath
	}

	@Keyword
	List<WebElement> getWebsitesVirtualizedGridItems(){
		return brandcast.getChildElementListByXpath(this.getWebsitesVirtualizedGrid(), this.getWebsitesVirtualizedGridItemsXpath())
	}

	/**
	 * Grid Item Box Details
	 **/
	private String GridItemBoxDetailsXpath = './/div[@class="box-details"]/div[@class="box-wrapper"]'

	String getGridItemBoxDetailsXpath(){
		return this.GridItemBoxDetailsXpath
	}

	@Keyword
	WebElement getGridItemBoxDetails(WebElement element){
		return brandcast.getChildElementByXpath(element, this.getGridItemBoxDetailsXpath())
	}

	@Keyword
	WebElement moveGridItemBoxDetails(){
		brandcast.moveToElement(this.getGridItemBoxDetailsXpath())
	}

	/**
	 * Grid Item Box Thumbnail
	 **/
	private String GridItemBoxThumbnailXpath = './/div[@class="box-thumbnail-wrapper"]/div[@class="box-thumbnail"]'

	String getGridItemBoxThumbnailXpath(){
		return this.GridItemBoxThumbnailXpath
	}
	@Keyword
	WebElement getGridItemBoxThumbnail(WebElement element){
		return element.findElement(By.xpath(this.getGridItemBoxThumbnailXpath()))
	}

	/**
	 * Grid Item Open Site Btn
	 **/
	private String GridItemOpenSiteBtnXpath = './/div[@class="box-action-ui"]/div[@class="centered-wrapper"]/div[contains(@class,"ui-wrapper box-btn")]/span/a'

	String getGridItemOpenSiteBtnXpath(){
		return this.GridItemOpenSiteBtnXpath
	}

	@Keyword
	WebElement getGridItemOpenSiteBtn(WebElement element){
		return element.findElement(By.xpath(this.getGridItemOpenSiteBtnXpath()))
	}

	/**
	 * Grid Item Context Menu
	 **/
	private String GridItemContextMenuXpath = './/div[contains(@class,"bc-menu-group website-menu light-theme")]/div[@class="menu-item" and @data-identifier="website-menu"]/div[@title="Website Menu" and @class="btn-blank bullet-btn"]'

	String getGridItemContextMenuXpath(){
		return GridItemContextMenuXpath
	}

	@Keyword
	WebElement getGridItemContextMenu(WebElement element){
		return element.findElement(By.xpath(this.getGridItemContextMenuXpath()))
	}

	/**
	 * Grid Item Context Menu Dropdown
	 **/
	private String GridItemContextMenuDropdownXpath = './/div[@class="box-action-ui"]/div[contains(@class,"bc-menu-group website-menu light-theme active")]/div[contains(@class,"menu-item has-layout") and contains(@data-identifier,"website-menu")]/div[contains(@class,"menu-dropdown")]'

	String getGridItemContextMenuDropdownXpath(){
		return this.GridItemContextMenuDropdownXpath
	}

	@Keyword
	WebElement getGridItemContextMenuDropdown(WebElement element){
		return element.findElement(By.xpath(this.getGridItemContextMenuDropdownXpath()))
	}

	@Keyword
	def waitforGridItemContextMenuDropdown(WebElement element){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getGridItemContextMenuDropdown(element), this.getGridItemContextMenuDropdownXpath())
	}

	/**
	 * Add / Remove Tags
	 */
	private String MenuOptionAddRemoveTagsXpath = './/h4[text()="Add / Remove Tags"]'

	String getMenuOptionAddRemoveTagsXpath(){
		return this.MenuOptionAddRemoveTagsXpath
	}

	WebElement getMenuOptionAddRemoveTags(WebElement element){
		return element.findElement(By.xpath(this.getMenuOptionAddRemoveTagsXpath()))
	}

	/**
	 * Publish Website
	 */
	private String MenuOptionPublishWebsiteXpath = './/h4[text()="Publish Website"]'

	String getMenuOptionPublishWebsiteXpath(){
		return this.MenuOptionPublishWebsiteXpath
	}
	WebElement getMenuOptionPublishWebsite(WebElement element){
		return element.findElement(By.xpath(this.getMenuOptionPublishWebsiteXpath()))
	}

	/**
	 * Duplicate
	 */
	private String MenuOptionDuplicateXpath = './/h4[text()="Duplicate"]'

	String getMenuOptionDuplicateXpath(){
		return this.MenuOptionDuplicateXpath
	}
	WebElement getMenuOptionDuplicate(WebElement element){
		return element.findElement(By.xpath(this.getMenuOptionDuplicateXpath()))
	}

	/**
	 * Save As Template
	 */
	private String MenuOptionSaveAsTemplateXpath = './/h4[text()="Save As Template"]'

	String getMenuOptionSaveAsTemplateXpath(){
		return this.MenuOptionSaveAsTemplateXpath
	}

	WebElement getMenuOptionSaveAsTemplate(WebElement element){
		return element.findElement(By.xpath(this.getMenuOptionSaveAsTemplateXpath()))
	}

	/**
	 * Settings
	 */
	private String MenuOptionSettingsXpath = './/h4[text(),"Settings"]'

	String getMenuOptionSettingsXpath(){
		return this.MenuOptionSettingsXpath
	}

	WebElement getMenuOptionSettings(WebElement element){
		return element.findElement(By.xpath(this.getMenuOptionSettingsXpath()))
	}

	/**
	 * Delete Website
	 */
	private String MenuOptionDeleteWebsiteXpath = './/h4[text()="Delete Website"]'

	String getMenuOptionDeleteWebsiteXpath(){
		return this.MenuOptionDeleteWebsiteXpath
	}

	WebElement getMenuOptionDeleteWebsite(WebElement element){
		return element.findElement(By.xpath(this.getMenuOptionDeleteWebsiteXpath()))
	}

	WebElement clickDeleteWebsite(WebElement element){
		element.findElement(By.xpath(this.getMenuOptionDeleteWebsiteXpath())).click()
	}

	/**
	 * Grid Item Title Container
	 **/
	private String GridItemTitleContainerXpath = './/div[@class="title-date-wrap"]/div[@class="title-date"]'

	String getGridItemTitleContainerXpath(){
		return this.GridItemTitleContainerXpath
	}
	@Keyword
	WebElement getGridItemTitleContainer(WebElement element){
		return element.findElement(By.xpath(this.getGridItemTitleContainerXpath()))
	}
	/**
	 * Grid Item Title
	 **/
	private String GridItemTitleXpath = './/div[contains(@class,"swap-container clearfix fl-box aa")]h5'

	String getGridItemTitleXpath(){
		return this.GridItemTitleXpath
	}
	@Keyword
	WebElement getGridItemTitle(WebElement element){
		return element.findElement(By.xpath(this.getGridItemTitleXpath()))
	}
	/**
	 * Grid Item Date
	 **/
	private String GridItemDateXpath = './/div[@class="fl-box bb"]/p[@class="date"]'

	String getGridItemDateXpath(){
		return this.GridItemDateXpath
	}
	@Keyword
	WebElement getGridItemDate(WebElement element){
		return element.findElement(By.xpath(this.getGridItemDateXpath()))
	}
	/**
	 * Grid Item Time
	 **/
	private String GridItemTimeXpath = './/div[@class="fl-box bb"]/p[@class="date"]/time'

	String getGridItemTimeXpath() {
		return this.GridItemTimeXpath
	}

	@Keyword
	WebElement getGridItemTime(WebElement element){
		return element.findElement(By.xpath(this.getGridItemTimeXpath()))
	}
	/**
	 * Grid Item Publish Status
	 **/
	private String GridItemPublishStatusXpath = './/div[@class="fl-box bb"]/p[@class="published-status"]/span'

	String getGridItemPublishStatusXpath(){
		return this.GridItemPublishStatusXpath
	}
	@Keyword
	WebElement getGridItemPublishStatus(WebElement element){
		return element.findElement(By.xpath(this.getGridItemPublishStatusXpath()))
	}
	/**
	 * Grid Item Tags Menu Btn
	 **/
	private String GridItemTagsMenuBtnXpath = '//div[@class="box-aux-ui"]/div[@class="box-analytics tags"]/div[contains(@class,"bc-menu-group analytics-menu type-tags light-theme")]/div[@class="menu-item" and @data-identifier="module-options"]/div[@title="Tags" and @class="btn-blank tags-menu-btn"]'

	String getGridItemTagsMenuBtnXpath(){
		return this.GridItemTagsMenuBtnXpath
	}

	@Keyword
	WebElement getGridItemTagsMenuBtn(WebElement element){
		return element.findElement(By.xpath(this.getGridItemTagsMenuBtnXpath()))
	}
	/**
	 * Grid Item Analytics Menu Btn
	 */
	private String GridItemanalyticsMenuBtnXpath = 'div[@class="box-aux-ui"]/div[@class="box-analytics"]/div[contains(@class,"bc-menu-group analytics-menu type-website light-theme")]/div[@class="menu-item" and @data-identifier="module-options"]/div[@title="Website Analytics" and @class="btn-blank analytics-menu-btn"]'

	String getGridItemanalyticsMenuBtnXpath(){
		return this.GridItemanalyticsMenuBtnXpath
	}

	@Keyword
	WebElement getGridItemanalyticsMenuBtn(WebElement element){
		return element.findElement(By.xpath(this.getGridItemanalyticsMenuBtnXpath()))
	}


	/**
	 * Delete Website Confirmation Panel
	 */
	private String DeleteWebsiteConfirmationPanelXpath = './/div[contains(@data-overlay-id,"deletewebsiteconfirmationcontainer") and contains(@class,"bc-modal")]/div[@class="bc-modal-wrapper"]/div[@class="container-clear modal-system"]'

	String getDeleteWebsiteConfirmationPanelXpath(){
		return this.DeleteWebsiteConfirmationPanelXpath
	}

	WebElement getDeleteWebsiteConfirmationPanel(){
		return brandcast.getElementByXpath(this.getDeleteWebsiteConfirmationPanelXpath())
	}

	/**
	 * DeletePanelCloseBtn
	 */
	private String DeletePanelCloseBtnXpath = '//div[@class="close-container"]/div[@class="close"]'

	String getDeletePanelCloseBtnXpath(){
		return this.DeletePanelCloseBtnXpath
	}

	WebElement getDeletePanelCloseBtn(){
		return brandcast.getChildElementByXpath(this.getDeleteWebsiteConfirmationPanel(), this.getDeletePanelCloseBtnXpath())
	}

	/**
	 * DeletePanel
	 */
	private String DeletePanelXpath = '//div[@class="modal-content"]/div[@class="modal-text"]/h1'

	String getDeletePanelXpath(){
		return this.DeletePanelXpath
	}

	WebElement getDeletePanel(){
		return brandcast.getChildElementByXpath(this.getDeleteWebsiteConfirmationPanel(), this.getDeletePanelXpath())
	}

	/**
	 * DeletePanelCancelBtn
	 */
	private String DeletePanelCancelBtnXpath = './/div[@class="container-clear modal-btns"]/div[@class="ui-wrapper editor-style"]/button[@class="btn-html" and @type="button" and @data-qa-id="cancel-button"]'

	String getDeletePanelCancelBtnXpath(){
		return this.DeletePanelCancelBtnXpath
	}

	WebElement getDeletePanelCancelBtn(){
		return brandcast.getChildElementByXpath(this.getDeleteWebsiteConfirmationPanel(), this.getDeletePanelCancelBtnXpath())
	}

	/**
	 * DeletePanelDeleteBtn
	 */
	private String DeletePanelDeleteBtnXpath = './/div[@class="container-clear modal-btns"]/div[@class="ui-wrapper editor-style primary"]/button[@class="btn-html" and @type="button" and @data-qa-id="delete-website-button"]'

	String getDeletePanelDeleteBtnXpath(){
		return this.DeletePanelDeleteBtnXpath
	}

	WebElement getDeletePanelDeleteBtn(){
		return brandcast.getChildElementByXpath(this.getDeleteWebsiteConfirmationPanel(), this.getDeletePanelDeleteBtnXpath())
	}

	@Keyword
	def clickDeletePanelDeleteBtn(){
		brandcast.clickChildWebElement(this.getDeleteWebsiteConfirmationPanel(), this.getDeletePanelDeleteBtnXpath())
	}

	@Keyword
	def waitforDeletePanelDeleteBtn(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getDeleteWebsiteConfirmationPanel(), this.getDeletePanelDeleteBtnXpath())
	}


	/**
	 * Delete Website from Grid
	 **/
	@Keyword
	def deleteWebsitefromGrid(){
		if(!this.getWebsitesVirtualizedGridItems().isEmpty()){
			for(WebElement gridItem: this.getWebsitesVirtualizedGridItems()) {
				//Get Thumbnail
				WebElement thumbnail = this.getGridItemBoxThumbnail(gridItem)
				brandcast.moveToElementByWebElement(thumbnail)

				//Get Thumbnail Objects
				WebElement opensitebtn = this.getGridItemOpenSiteBtn(thumbnail)
				WebElement contextmenu = this.getGridItemContextMenu(thumbnail)
				brandcast.clickWebElement(contextmenu)
				WebUI.delay(2)

				//Menu Dropdown
				WebElement menudropdown = this.getGridItemContextMenuDropdown(thumbnail)
				//println(menudropdown.getAttribute("innerHTML"))

				//Delete Website
				WebElement deletewebsite = this.getMenuOptionDeleteWebsite(menudropdown)
				brandcast.moveToElementByWebElement(deletewebsite)
				deletewebsite.click()
				this.waitforDeletePanelDeleteBtn()
				this.clickDeletePanelDeleteBtn()
				println("============================================================================================")
				//break
				WebUI.delay(3)
			}
		}else {
			KeywordUtil.markFailedAndStop("Could Not find Website List!")
		}
	}

	@Keyword
	def dsGetTabHandle(ArrayList<String> windowTabs, WebElement originalTab){
		if(!windowTabs.empty) {
			/*
			 windowTabs.remove(originalTab)
			 for(Integer i=0; i<windowTabs.size(); i++){
			 WebElement CurrentTab = windowTabs.get(i)
			 return CurrentTab
			 }
			 */
			println(windowTabs.size())
		}
	}

	@Keyword
	def loopWebsitesVirtualizedGridItems(){
		if(!this.getWebsitesVirtualizedGridItems().isEmpty()){
			for(WebElement gridItem: this.getWebsitesVirtualizedGridItems()) {
				//Get Thumbnail
				WebElement thumbnail = this.getGridItemBoxThumbnail(gridItem)
				brandcast.moveToElementByWebElement(thumbnail)

				//Get Thumbnail Objects
				WebElement opensitebtn = this.getGridItemOpenSiteBtn(thumbnail)
				WebElement contextmenu = this.getGridItemContextMenu(thumbnail)
				brandcast.clickWebElement(contextmenu)
				WebUI.delay(2)

				//Menu Dropdown
				WebElement menudropdown = this.getGridItemContextMenuDropdown(thumbnail)
				brandcast.waitVisibilityOfWebElement(menudropdown)

				//Delete Website
				WebElement deletewebsite = this.getMenuOptionDeleteWebsite(menudropdown)
				brandcast.moveToElementByWebElement(deletewebsite)
				deletewebsite.click()
				println("============================================================================================")
				break
			}
		}else {
			KeywordUtil.markFailedAndStop("Could Not find Website List!")
		}
	}
}

