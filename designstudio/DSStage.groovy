package com.designstudio

import java.util.List

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver

/*Custom Keywords*/
import com.brandcast.Core
import com.brandcast.Utils
import com.kms.katalon.core.annotation.Keyword

public class DSStage {
	Core brandcast = new Core()
	Utils utils = new Utils()

	/* Pendo Overlay */

	private String PendoOverlayXpath ='//div[contains(@id,"pendo-base") and contains(@data-layout,"lightboxBlank") and contains(@class,"_pendo-step-container _pendo-guide-walkthrough_")]/div[contains(@data-vertical-alignment,"Bottom Aligned") and contains(@class,"_pendo-step-container-size")]/div[contains(@aria-modal,"true") and contains(@id,"pendo-guide-container") and contains(@class,"_pendo-step-container-styles")]'

	String getPendoOverlayXpath(){
		return this.PendoOverlayXpath
	}

	@Keyword
	WebElement getPendoOverlay(){
		return brandcast.getElementByXpath(this.getPendoOverlayXpath())
	}

	@Keyword
	def waitForPendoOverlay(){
		brandcast.waitUntilPresenceOfElementLocatedBy(this.getPendoOverlayXpath())
	}


	/* Pendo Overlay Close Button */
	private def PendoOverlayCloseButtonXpath = {'//button[contains(@class,"_pendo-close-guide")]'}

	def getPendoOverlayCloseButtonXpath = {return this.PendoOverlayCloseButtonXpath.call()}

	@Keyword
	WebElement getPendoOverlayCloseButton(){
		return brandcast.getChildElementByXpath(this.getPendoOverlay(), this.getPendoOverlayCloseButtonXpath.call())
	}

	@Keyword
	def clickPendoOverlayCloseButton = {
		brandcast.clickWebElement(this.getPendoOverlayCloseButton())
	}

	/*Check for Pendo Overlay*/
	@Keyword
	boolean checkForPendoOverlay() {
		try {
			WebElement element =  brandcast.getElementByXpath(this.getPendoOverlayXpath())
		}
		catch (NoSuchElementException) {
			WebElement element = null
			return false
		}
		return true
	}

	/*HighLight*/
	def HighLight = {WebElement element -> brandcast.executeJavascriptHighLight(element)}

	/*Stage Wrapper Xpath*/
	private StageWrapperXpath = '//span[contains(@id, "app") and contains(@class, "design-studio-root")]/div[contains(@class,"inline")]/span[contains(@class,"app-container") and contains(@class,"hidden-launch") and contains(@class,"design-studio") and contains(@class,"app-ready") and contains(@class,"logged-in") and contains(@class,"login-complete")]'

	String getStageWrapperXpath(){
		return this.StageWrapperXpath
	}
	WebElement getStageWrapper(){
		return brandcast.getElementByXpath(this.getStageWrapperXpath())
	}

	/* Container */
	private String StageNewWebsiteTabContainerXpath = '//span[contains(@class,"stage-wrapper") and contains(@class,"accounts-loaded")]/div[contains(@class,"stage") and contains(@class,"bc-desktop") and contains(@class,"icon") and contains(@class,"type-page") or contains(@class,"type-website")]/div[contains(@class,"toolbar") and contains(@class,"position-top-tabs")]'
	
	String getStageNewWebsiteTabContainerXpath(){
		return this.StageNewWebsiteTabContainerXpath
	}

	WebElement getStageNewWebsiteTabContainer(){
		return brandcast.getChildElementByXpath(this.getStageWrapper(),this.getStageNewWebsiteTabContainerXpath())
	}
	/* Container Content */
	private String StageNewWebsiteTabContainerContentXpath ='//div[contains(@class,"tab-content-container")]'
	
	String getStageNewWebsiteTabContainerContentXpath(){
		return this.StageNewWebsiteTabContainerContentXpath
	}

	WebElement getStageNewWebsiteTabContainerContent(){
		return brandcast.getChildElementByXpath(this.getStageNewWebsiteTabContainer(),this.getStageNewWebsiteTabContainerContentXpath())
	}
	
	/*Stage New Website Stage*/
	private String NewWebsiteStageXpath = '//div[contains(@class,"toolbar") and contains(@class,"position-top-tabs")]'
	
	String getNewWebsiteStageXpath(){
		return this.NewWebsiteStageXpath
	}

	@Keyword
	WebElement getStageNewWebsiteStage(){
		return brandcast.getChildElementByXpath(this.getStageNewWebsiteTabContainerContent(), this.getNewWebsiteStageXpath())
	}

	/*Stage New Website Tab*/
	private String StageNewWebsiteTabXpath = '//a[contains(@class,"tab website")]'

	String getStageNewWebsiteTabXpath(){
		return this.StageNewWebsiteTabXpath
	}

	@Keyword
	WebElement getStageNewWebsiteTab(){
		return brandcast.getChildElementByXpath(this.getStageNewWebsiteTabContainerContent(), this.getStageNewWebsiteTabXpath())
	}

	@Keyword
	def clickStageNewWebsiteTab(){
		brandcast.clickChildWebElement(this.getStageNewWebsiteTabContainerContent(), this.getStageNewWebsiteTabXpath())
	}

	/*Stage New Website Tab Text*/
	private String StageNewWebsiteTextXpath = '//div[contains(@class,"tab-text")]/span'

	String getStageNewWebsiteTextXpath(){
		return this.StageNewWebsiteTextXpath
	}

	@Keyword
	WebElement getStageNewWebsiteText(){
		return brandcast.getChildElementByXpath(this.getStageNewWebsiteTab(), this.getStageNewWebsiteTextXpath())
	}

	/*Stage New Website Close Tab*/
	private String StageNewWebsiteCloseTabXpath = '//div[contains(@class,"tab-close-container")]'

	String getStageNewWebsiteCloseTabXpath(){
		return this.StageNewWebsiteCloseTabXpath
	}

	WebElement getStageNewWebsiteCloseTab(){
		return brandcast.getChildElementByXpath(this.getStageNewWebsiteTab(), this.getStageNewWebsiteCloseTabXpath())
	}

	/*Stage Home Tab*/

	private String StageHomeTabXpath = '//span[contains(@class,"tab page selected")]'

	String getStageHomeTabXpath(){
		return this.StageHomeTabXpath
	}

	WebElement getStageHomeTab(){
		return brandcast.getChildElementByXpath(this.getStageNewWebsiteTabContainerContent(), this.getStageHomeTabXpath())
	}

	@Keyword
	def clickStageHomeTab(){
		brandcast.clickChildWebElement(this.getStageNewWebsiteTabContainerContent(), this.getStageHomeTabXpath())
	}

	/*Stage Home Tab Text*/
	private String StageHomeTabTextXpath = '//div[contains(@class,"tab-text")]'

	String getStageHomeTabTextXpath(){
		return this.StageHomeTabTextXpath
	}

	WebElement getStageHomeTabText(){
		return brandcast.getChildElementByXpath(this.getStageHomeTab(), this.getStageHomeTabTextXpath())
	}


	/*Stage Home Close Tab*/
	private String StageHomeCloseTabXpath = '//div[contains(@class,"tab-close-container")]'

	String getStageHomeCloseTabXpath(){
		return this.StageHomeCloseTabXpath
	}

	@Keyword
	WebElement getStageHomeCloseTab(){
		return brandcast.getChildElementByXpath(this.getStageHomeTab(), this.getStageHomeCloseTabXpath())
	}

	@Keyword
	def clickStageHomeCloseTab(){
		brandcast.clickChildWebElement(this.getStageHomeTab(), this.getStageHomeCloseTabXpath())
	}

	/*Stage BC-Desktop*/
	private String StageBcDesktopXpath = '//div[contains(@class,"stage") and contains(@class,"bc-desktop") and contains(@class,"icon") and contains(@class,"type-page")]'

	String getStageBcDesktopXpath(){
		return this.StageBcDesktopXpath
	}
	WebElement getStageBcDesktop(){
		return brandcast.getElementByXpath(this.getStageBcDesktopXpath())
	}

	/*Stage Position Top A*/
	private String StagePositionTopAXpath = '//div[contains(@class, "toolbar") and contains(@class, "position-top-a")]'

	String getStagePositionTopAXpath(){
		return this.StagePositionTopAXpath
	}

	WebElement getStagePositionTopA(){
		return brandcast.getChildElementByXpath(this.getStageBcDesktop(), this.getStagePositionTopAXpath())
	}

	/*Stage Primary Text Menu*/
	private String StagePrimaryTextMenuXpath = '//div[contains(@class,"content") and contains(@class,"primary-text-menu") and contains(@class,"left")]/div[contains(@class,"bc-menu-group") and contains(@class,"in-design-studio")]'

	String getStagePrimaryTextMenuXpath(){
		return this.StagePrimaryTextMenuXpath
	}

	WebElement getStagePrimaryTextMenu(){
		return brandcast.getChildElementByXpath(this.getStageBcDesktop(), this.getStagePrimaryTextMenuXpath())
	}

	/*Design Studio Logo*/
	private String FileMenuOptionDesignStudioLogoXpath = '//div[contains(@class,"menu-item") and contains(@data-identifier,"menuFile")]/div[contains(@class,"btn-blank") and contains(@class,"design-studio-logo")]/div[contains(@class,"design-studio-logo-btn")]'

	String getFileMenuOptionDesignStudioLogoXpath(){
		return this.FileMenuOptionDesignStudioLogoXpath
	}

	WebElement getFileMenuOptionDesignStudioLogo(){
		return brandcast.getChildElementByXpath(this.getStagePrimaryTextMenu(), this.getFileMenuOptionDesignStudioLogoXpath())
	}

	@Keyword
	def clickFileMenuOptionDesignStudioLogo(){
		brandcast.clickChildWebElement(this.getStagePrimaryTextMenu(), this.getFileMenuOptionDesignStudioLogoXpath())
	}

	def waitforFileMenuOptionDesignStudioLogo(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getStagePrimaryTextMenu(), this.getFileMenuOptionDesignStudioLogoXpath())
	}


	/*Studio*/
	private FileMenuOptionStudioXpath = '//div[contains(@class,"menu-item") and contains(@data-identifier,"menuManage")]/div[contains(@class,"ui-wrapper studio-ui")]/span/div[contains(@class,"btn-text")]/div[contains(@data-tutorial-id,"studio-btn") and contains(@data-qa-id,"studio-btn") and contains(@class,"btn-text-label")]'

	String getFileMenuOptionStudioXpath(){
		return this.FileMenuOptionStudioXpath
	}

	WebElement getFileMenuOptionStudio(){
		return brandcast.getChildElementByXpath(this.getStagePrimaryTextMenu(), this.getFileMenuOptionStudioXpath())
	}

	@Keyword
	def clickFileMenuOptionStudio(){
		brandcast.clickChildWebElement(this.getStagePrimaryTextMenu(), this.getFileMenuOptionStudio())
	}

	def waitforFileMenuOptionStudio(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getStagePrimaryTextMenu(), this.getFileMenuOptionStudioXpath())
	}


	/*File*/
	private FileMenuOptionFileXpath = "//*[normalize-space(text())='File']"

	String getFileMenuOptionFileXpath(){
		return this.FileMenuOptionFileXpath
	}

	WebElement getFileMenuOptionFile(){
		return brandcast.getChildElementByXpath(this.getStagePrimaryTextMenu(), this.getFileMenuOptionFileXpath())
	}

	@Keyword
	def clickFileMenuOptionFile(){
		this.getFileMenuOptionFile().click()
		//brandcast.clickChildWebElement(this.getStagePrimaryTextMenu(), this.getFileMenuOptionStudioXpath())
	}

	def waitforFileMenuOptionFile(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getStagePrimaryTextMenu(), this.getFileMenuOptionFileXpath())
	}


	/*Edit*/
	private String FileMenuOptionEditXpath = "//*[normalize-space(text())='Edit']"

	String getFileMenuOptionEditXpath(){
		return this.FileMenuOptionEditXpath
	}

	WebElement getFileMenuOptionEdit(){
		return brandcast.getChildElementByXpath(this.getStagePrimaryTextMenu(), this.getFileMenuOptionEditXpath())
	}

	@Keyword
	def clickFileMenuOptionEdit(){
		brandcast.clickChildWebElement(this.getStagePrimaryTextMenu(), this.getFileMenuOptionEditXpath())
	}

	def waitforFileMenuOptionEdit(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getStagePrimaryTextMenu(), this.getFileMenuOptionEditXpath())
	}


	/*View*/
	private String FileMenuOptionViewXpath = "//*[normalize-space(text())='View']"

	String getFileMenuOptionViewXpath(){
		return this.FileMenuOptionViewXpath
	}

	WebElement getFileMenuOptionView(){
		return brandcast.getChildElementByXpath(this.getStagePrimaryTextMenu(), this.getFileMenuOptionViewXpath())
	}

	@Keyword
	def clickFileMenuOptionView(){
		brandcast.clickChildWebElement(this.getStagePrimaryTextMenu(), this.getFileMenuOptionViewXpath())
	}

	def waitforFileMenuOptionView(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getStagePrimaryTextMenu(), this.getFileMenuOptionViewXpath())
	}

	//View Context Menu Outline View
	private String ViewContextMenuOutlineViewXpath = "//*[normalize-space(text())='Outline View']"
	String getViewContextMenuOutlineViewXpath(){
		return this.ViewContextMenuOutlineViewXpath
	}

	WebElement getViewContextMenuOutlineView(){
		return brandcast.getChildElementByXpath(this.getStagePrimaryTextMenu(), this.getViewContextMenuOutlineViewXpath())
	}

	@Keyword
	def clickViewContextMenuOutlineView(){
		brandcast.clickChildWebElement(this.getStagePrimaryTextMenu(), this.getViewContextMenuOutlineViewXpath())
	}

	def waitforFViewContextMenuOutlineView(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getStagePrimaryTextMenu(), this.getViewContextMenuOutlineViewXpath())
	}

	//View Context Menu Preview Mode
	private String ViewContextMenuPreviewModeXpath = "//*[normalize-space(text())='Preview Mode']"
	String getViewContextMenuPreviewModeXpath(){
		return this.ViewContextMenuPreviewModeXpath
	}

	WebElement getViewContextMenuPreviewMode(){
		return brandcast.getChildElementByXpath(this.getStagePrimaryTextMenu(), this.getViewContextMenuPreviewModeXpath())
	}

	@Keyword
	def clickViewContextMenuPreviewMode(){
		brandcast.clickChildWebElement(this.getStagePrimaryTextMenu(), this.getViewContextMenuPreviewModeXpath())
	}

	
	@Keyword
	def waitforViewContextMenuPreviewMode(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getStagePrimaryTextMenu(), this.getViewContextMenuPreviewModeXpath())
	}

	//Website Previw Mode
	private String WebsitePreviwModeXpath = '//span[contains(@class,"stage-wrapper") and contains(@class,"accounts-loaded")]/div[contains(@class,"stage") and contains(@class,"bc-desktop") and contains(@class,"icon") and contains(@class,"type-page")]/div[contains(@class,"mode-bar") and contains(@class,"clearfix") and contains(@class,"white-loader") and contains(@class,"preview-mode")]'

	String getWebsitePreviwModeXpath(){
		return this.WebsitePreviwModeXpath
	}

	WebElement getWebsitePreviwMode(){
		return brandcast.getChildElementByXpath(this.getStagePrimaryTextMenu(), this.getWebsitePreviwModeXpath())
	}

	//WebSite Preview
	private String WebSitePreviewTitleXpath = '//div[contains(@class,"col b")]/span[contains(@class,"mode-title") and contains(@class,"preview-title")]'

	String getWebSitePreviewTitleXpath(){
		return this.WebSitePreviewTitleXpath
	}

	WebElement getWebSitePreviewTitle(){
		return brandcast.getElementByXpath(this.getWebSitePreviewTitleXpath())
	}

	//Preview Mode Exit Button
	private String PreviewModeExitButtonXpath = '//div[contains(@class,"col c")]/span[contains(@class,"mode-btn")]'

	String getPreviewModeExitButtonXpath(){
		return this.PreviewModeExitButtonXpath
	}

	WebElement getPreviewModeExitButton(){
		return brandcast.getElementByXpath(this.getPreviewModeExitButtonXpath())
	}

	@Keyword
	def clickPreviewModeExitButton(){
		brandcast.clickWebElement(this.getPreviewModeExitButton())
	}
	@Keyword
	def waitforPreviewModeExitButton(){
		brandcast.waitUntilPresenceOfAllElementsLocatedBy(this.getPreviewModeExitButtonXpath())
	}

	//View Context Menu High Quality Display
	private String ViewContextMenuHighQualityDisplayXpath = "//*[normalize-space(text())='High Quality Display']"

	String getViewContextMenuHighQualityDisplayXpath(){
		return this.ViewContextMenuHighQualityDisplayXpath
	}

	WebElement getViewContextMenuHighQualityDisplay(){
		return brandcast.getChildElementByXpath(this.getStagePrimaryTextMenu(), this.getViewContextMenuHighQualityDisplayXpath())
	}

	@Keyword
	def clickViewContextMenuHighQualityDisplay(){
		brandcast.clickChildWebElement(this.getStagePrimaryTextMenu(), this.getViewContextMenuHighQualityDisplayXpath())
	}
	@Keyword
	def waitforViewContextMenuHighQualityDisplay(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getStagePrimaryTextMenu(), this.getViewContextMenuHighQualityDisplayXpath())
	}

	//View Context Menu Fast Display Xpath
	private String ViewContextMenuFastDisplayXpath = "//*[normalize-space(text())='Fast Display']"

	String getViewContextMenuFastDisplayXpath(){
		return this.ViewContextMenuFastDisplayXpath
	}

	WebElement getViewContextMenuFastDisplay(){
		return brandcast.getChildElementByXpath(this.getStagePrimaryTextMenu(), this.getViewContextMenuFastDisplayXpath())
	}

	@Keyword
	def clickViewContextMenuFastDisplay(){
		brandcast.clickChildWebElement(this.getStagePrimaryTextMenu(), this.getViewContextMenuFastDisplayXpath())
	}
	@Keyword
	def waitforViewContextMenuFastDisplay(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getStagePrimaryTextMenu(), this.getViewContextMenuFastDisplayXpath())
	}

	//New Website Container

	private String NewWebsiteContainerXpath = '//div[contains(@class,"overlays-wrapper") and contains(@class,"overlay-bounds")]/div[contains(@data-overlay-id,"newwebsiteacontainer") and contains(@class,"bc-modal")]/div[contains(@class,"bc-modal-wrapper") and contains(@class,"bc-modal-new-site") and contains(@class,"step-2")]'

	String getNewWebsiteContainerXpath(){
		return this.NewWebsiteContainerXpath
	}

	WebElement getNewWebsiteContainer(){
		return brandcast.getElementByXpath(this.getNewWebsiteContainerXpath())
	}
	//Website Name

	private String NewWebsiteNameInputXpath = '//div[contains(@class,"fl-box b col-wrapper")]/form[contains(@class,"modal-contents")]/div[contains(@class,"ui-wrapper full-width size-B white-theme fl-box") and contains(@title,"Website Name")]/div[contains(@class,"text-input-container")]/label/div[contains(@class,"text-input-wrapper")]/input[contains(@name,"name") and contains(@type,"text") and contains(@class,"text-input")]'
	String getNewWebsiteNameInputXpath(){
		return this.NewWebsiteNameInputXpath
	}

	WebElement getNewWebsiteNameInput(){
		return brandcast.getChildElementByXpath(this.getNewWebsiteContainer(), this.getNewWebsiteNameInputXpath())
	}

	@Keyword
	def clickNewWebsiteNameInput(){
		brandcast.clickChildWebElement(this.getNewWebsiteContainer(), this.getNewWebsiteNameInputXpath())
	}

	@Keyword
	def sendNewWebsiteName(){
		String n = utils.getWebsiteName()
		brandcast.sendInput(this.getNewWebsiteNameInput(),n)
		return n
	}

	@Keyword
	def clearNewWebsiteName(){
		getNewWebsiteNameInput().clear()
	}

	//Subdomain Name
	private String NewWebsiteSubdomainInputXpath = '//div[contains(@class,"fl-box b col-wrapper")]/form[contains(@class,"modal-contents")]/div[contains(@class,"ui-wrapper full-width size-B white-theme fl-box") and contains(@title,"Subdomain Name")]/div[contains(@class,"text-input-container")]/label/div[contains(@class,"text-input-wrapper")]/input[contains(@name,"slug") and contains(@type,"text") and contains(@class,"text-input")]'
	String getNewWebsiteSubdomainInputXpath(){
		return this.NewWebsiteSubdomainInputXpath
	}

	WebElement getNewWebsiteSubdomainInput(){
		return brandcast.getChildElementByXpath(this.getNewWebsiteContainer(), this.getNewWebsiteSubdomainInputXpath())
	}

	@Keyword
	def clickNewWebsiteSubdomainInput(){
		brandcast.clickChildWebElement(this.getNewWebsiteContainer(), this.getNewWebsiteSubdomainInputXpath())
	}

	//cancel-button
	private String NewWebsiteCancelButtonXpath = '//div[contains(@class,"fl-box b") and contains(@class,"col-wrapper")]/form[contains(@class,"modal-contents")]/div[contains(@class,"block-btns-wrapper")]/div[contains(@class,"block-btns")]/div[contains(@class,"ui-wrapper") and contains(@class,"editor-style") and contains(@class,"fl-auto")]/button[contains(@class,"btn-html") and contains(@type,"button") and contains(@data-qa-id,"cancel-button")]'
	String getNewWebsiteCancelButtonXpath(){
		return this.NewWebsiteCancelButtonXpath
	}

	WebElement getNewWebsiteCancelButton(){
		return brandcast.getChildElementByXpath(this.getNewWebsiteContainer(), this.getNewWebsiteCancelButtonXpath())
	}

	@Keyword
	def clickNewWebsiteCancelButton(){
		brandcast.clickChildWebElement(this.getNewWebsiteContainer(), this.getNewWebsiteCancelButtonXpath())
	}

	//create-website-button
	private String NewWebsiteCreateWebsiteButtonXpath = '//div[contains(@class,"fl-box b") and contains(@class,"col-wrapper")]/form[contains(@class,"modal-contents")]/div[contains(@class,"block-btns-wrapper")]/div[contains(@class,"block-btns")]/div[contains(@class,"ui-wrapper") and contains(@class,"editor-style") and contains(@class,"fl-auto primary")]/button[contains(@class,"btn-html") and contains(@type,"submit") and contains(@data-qa-id,"create-website-button")]'

	String getNewWebsiteCreateWebsiteButtonXpath(){
		return this.NewWebsiteCreateWebsiteButtonXpath
	}

	WebElement getNewWebsiteCreateWebsiteButton(){
		return brandcast.getChildElementByXpath(this.getNewWebsiteContainer(), this.getNewWebsiteCreateWebsiteButtonXpath())
	}

	@Keyword
	def clickNewWebsiteCreateWebsiteButton(){
		brandcast.clickChildWebElement(this.getNewWebsiteContainer(), this.getNewWebsiteCreateWebsiteButtonXpath())
	}

	private String NewWebsiteTabXpath = '//div[contains(@class,"toolbar") and contains(@class,"position-top-tabs") and contains(@class,"fadeInDown")]/div[contains(@class,"tab-content-container")]/span[contains(@class,"tab") and contains(@class,"website") and contains(@class,"selected")]/div[contains(@class,"tab-text")]'

	String getNewWebsiteTabXpath(){
		return this.NewWebsiteTabXpath
	}

	WebElement getNewWebsiteTab(){
		return brandcast.getElementByXpath(this.getNewWebsiteTabXpath())
	}

	def waitforNewWebsiteTab(){
		brandcast.waitUntilPresenceOfElementLocatedBy(this.getNewWebsiteTabXpath())
	}

	// New Website Tab Text
	private String NewWebsiteTabTextXpath = '//div[contains(@class,"toolbar") and contains(@class,"position-top-tabs") and contains(@class, "animated") and contains(@class, "fadeInDown")]/div[contains(@class,"tab-content-container")]/span[contains(@class,"tab") and contains(@class,"website") and contains(@class,"selected")]/div[contains(@class,"tab-text")]/div[contains(@class,"swap-container") and contains(@class,"clearfix")]/h5[contains(@class,"text-swap")]'

	String getNewWebsiteTabTextXpath(){
		return this.NewWebsiteTabTextXpath
	}

	WebElement getNewWebsiteTabText(){
		return brandcast.getChildElementByXpath(this.getNewWebsiteTab(), this.getNewWebsiteTabTextXpath())
	}

	/*Window*/
	private String FileMenuOptionWindowXpath = "//*[normalize-space(text())='Window']"

	String getFileMenuOptionWindowXpath(){
		return this.FileMenuOptionWindowXpath
	}

	WebElement getFileMenuOptionWindow(){
		return brandcast.getChildElementByXpath(this.getStagePrimaryTextMenu(), this.getFileMenuOptionWindowXpath())
	}

	@Keyword
	def clickFileMenuOptionWindow(){
		brandcast.clickChildWebElement(this.getStagePrimaryTextMenu(), this.getFileMenuOptionWindowXpath())
	}

	def waitforFileMenuOptionWindow(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getStagePrimaryTextMenu(), this.getFileMenuOptionWindowXpath())
	}


	/*Help*/
	private FileMenuOptionHelpXpath = "//*[normalize-space(text())='Help']"

	String getFileMenuOptionHelpXpath(){
		return this.FileMenuOptionHelpXpath
	}

	WebElement getFileMenuOptionHelp(){
		return brandcast.getChildElementByXpath(this.getStagePrimaryTextMenu(), this.getFileMenuOptionHelpXpath())
	}

	@Keyword
	def clickFileMenuOptionHelp(){
		brandcast.clickChildWebElement(this.getStagePrimaryTextMenu(), this.getFileMenuOptionHelpXpath())
	}

	def waitforFileMenuOptionHelp(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getStagePrimaryTextMenu(), this.getFileMenuOptionHelpXpath())
	}


	private String FileOptionContextMenuXpath = '//div[contains(@class,"content") and contains(@class,"primary-text-menu") and contains(@class,"left")]/div[contains(@class,"bc-menu-group") and contains(@class,"in-design-studio") and contains(@class, "active")]'

	String getFileOptionContextMenuXpath(){
		return this.FileOptionContextMenuXpath
	}

	WebElement getFileOptionContextMenu(){
		return brandcast.getChildElementByXpath(this.getStagePrimaryTextMenu(), this.getFileOptionContextMenuXpath())
	}

	private String ContextMenuDropDownXpath = '//div[contains(@class,"menu-item") and contains(@data-identifier,"menuFile")]/div[contains(@class,"menu-dropdown")]'

	String getContextMenuDropDownXpath(){
		return this.ContextMenuDropDownXpath
	}

	WebElement getContextMenuDropDown(){
		return brandcast.getChildElementByXpath(this.getFileOptionContextMenu(), this.getContextMenuDropDownXpath())
	}

	/*File Context Options*/

	/* MenuOptionNewPageXpath*/
	private String MenuOptionNewPageXpath = '//h4[contains(text(),"New Page")]' //*[normalize-space(text())='View']"
	String getMenuOptionNewPageXpath(){
		return this.MenuOptionNewPageXpath
	}

	WebElement getMenuOptionNewPage(){
		return brandcast.getChildElementByXpath(this.getContextMenuDropDown(), this.getMenuOptionNewPageXpath())
	}

	@Keyword
	def waitforMenuOptionNewPage(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getContextMenuDropDown(), this.getMenuOptionNewPageXpath())
	}

	@Keyword
	def clickFileMenuOptionNewPage(){
		brandcast.clickChildWebElement(this.getContextMenuDropDown(), this.getFileMenuOptionHelpXpath())
	}

	/* MenuOptionNewWebsiteXpath*/
	private String MenuOptionNewWebsiteXpath = '//h4[contains(text(),"New Website")]'
	String getMenuOptionNewWebsiteXpath(){
		return this.MenuOptionNewWebsiteXpath
	}

	WebElement getMenuOptionNewWebsite(){
		return brandcast.getChildElementByXpath(this.getContextMenuDropDown(), this.getMenuOptionNewWebsiteXpath())
	}

	@Keyword
	def waitforMenuOptionNewWebsite(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getContextMenuDropDown(), this.getMenuOptionNewWebsiteXpath())
	}

	@Keyword
	def clickMenuOptionNewWebsite(){
		brandcast.clickChildWebElement(this.getContextMenuDropDown(), this.getMenuOptionNewWebsiteXpath())
	}

	/* MenuOptionSaveTemplateXpath*/
	private String MenuOptionSaveTemplateXpath = '//h4[contains(text(),"Save Website As Template")]'
	String getMenuOptionSaveTemplateXpath(){
		return this.MenuOptionSaveTemplateXpath
	}

	WebElement getMenuOptionSaveTemplate(){
		return brandcast.getChildElementByXpath(this.getContextMenuDropDown(), this.getMenuOptionSaveTemplateXpath())
	}

	@Keyword
	def waitforMenuOptionSaveTemplate(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getContextMenuDropDown(), this.getMenuOptionSaveTemplateXpath())
	}

	@Keyword
	def clickMenuOptionSaveTemplate(){
		brandcast.clickChildWebElement(this.getContextMenuDropDown(), this.getMenuOptionSaveTemplateXpath())
	}


	/* Save Website Template*/
	private String SaveWebsiteAsTemplateFormXpath = '//span[contains(@id,"app") and contains(@class,"design-studio-root")]/div[contains(@class,"inline")]/span[contains(@class,"app-container") and contains(@class,"hidden-launch") and contains(@class,"design-studio") and contains(@class,"app-ready") and contains(@class,"logged-in") and contains(@class,"login-complete")]/span/div[contains(@class,"overlays-wrapper") and contains(@class,"overlay-bounds")]/div[contains(@class,"window-area") and contains(@class,"settings-window-area") and contains(@class,"save-as-template") and contains(@class,"react-draggable") and contains(@data-tutorial-id,"WindowAreaSaveAsTemplateContainer") and contains(@data-overlay-id,"windowareasaveastemplatecontainer")]/div[contains(@class,"window-area-wrapper")]/div[contains(@class,"settings-container")]/form'

	String getSaveWebsiteAsTemplateFormXpath(){
		return this.SaveWebsiteAsTemplateFormXpath
	}

	@Keyword
	WebElement getSaveWebsiteAsTemplateForm(){
		return brandcast.getElementByXpath(this.getSaveWebsiteAsTemplateFormXpath())
	}

	/*Save Website As Template Form - Template Name Input*/
	private String SaveWebsiteTemplateFormNameInputXpath ='//div[contains(@class,"panel clearfix")]/div[contains(@class,"panel-body no-side-padding clearfix")]/div[contains(@class,"content clearfix")]/div[contains(@class,"ui-wrapper") and contains(@class,"full-width") and contains(@class,"size-B") and contains(@class,"white-theme") and contains(@title,"Template Name")]/div[contains(@class,"text-input-container")]/label/div[contains(@class,"text-input-wrapper")]/input[contains(@class,"text-input") and contains(@type,"text") and contains(@name,"templateName")]'

	String getSaveWebsiteTemplateFormNameInputXpath(){
		return this.SaveWebsiteTemplateFormNameInputXpath
	}

	WebElement getSaveWebsiteTemplateFormNameInput(){
		return brandcast.getChildElementByXpath(this.getSaveWebsiteAsTemplateForm(),this.getSaveWebsiteTemplateFormNameInputXpath())
	}

	@Keyword
	def SendWebsiteTemplateName(){
		String n = utils.getTemplateName()
		brandcast.sendInput(this.getSaveWebsiteTemplateFormNameInput(),n)
		return n
	}

	private String SaveWebsiteTemplateFormCloseBtnXpath = '//div[contains(@class,"close-container")]/div[contains(@class,"close")]'

	String getSaveWebsiteTemplateFormCloseBtnXpath(){
		return this.SaveWebsiteTemplateFormCloseBtnXpath
	}

	WebElement getSaveWebsiteTemplateFormCloseBtn(){
		return brandcast.getChildElementByXpath(this.getSaveWebsiteAsTemplateForm(), this.getSaveWebsiteTemplateFormCloseBtnXpath())
	}

	@Keyword
	def clickSaveWebsiteTemplateCloseBtn(){
		brandcast.clickChildWebElement(this.getSaveWebsiteTemplateFormCloseBtn(), utils.getTemplateName())
	}

	private String SaveWebsiteTemplateFormCancelBtnXpath = '//div[contains(@class,"content") and contains(@class,"clearfix") and contains(@class,"action-btns-wrapper") and contains(@class,"closer")]/div[contains(@class,"ui-wrapper") and contains(@class,"right") and contains(@class,"btn-style-d") and contains(@class,"invert")]/button[contains(@class,"btn-html") and contains(@type,"button") and contains(@data-qa-id,"cancel-button")]'

	String getSaveWebsiteTemplateFormCancelBtnXpath(){
		return this.SaveWebsiteTemplateFormCancelBtnXpath
	}

	WebElement getSaveWebsiteTemplateFormCancelBtn(){
		return brandcast.getChildElementByXpath(this.getSaveWebsiteAsTemplateForm(), this.getSaveWebsiteTemplateFormCancelBtnXpath())
	}

	@Keyword
	def clickSaveWebsiteTemplateCancelBtn(){
		brandcast.clickChildWebElement(this.getSaveWebsiteTemplateFormCloseBtn(), this.getSaveWebsiteTemplateFormCancelBtnXpath())
	}

	/*Click Create Website Templatee - Create Template Btn*/
	private String SaveWebsiteTempolateCreateTemplateBtnXpath = '//div[contains(@class,"content") and contains(@class,"clearfix") and contains(@class,"action-btns-wrapper") and contains(@class, "closer")]/div[contains(@class,"ui-wrapper") and contains(@class, "right") and contains(@class, "btn-style-d")]/button[contains(@class,"btn-html") and contains(@type,"submit") and contains(@data-qa-id,"create-template-button")]'

	String getSaveWebsiteTemplateCreateTemplateBtnXpath(){
		return this.SaveWebsiteTempolateCreateTemplateBtnXpath
	}

	WebElement getSaveWebsiteTempolateCreateTemplateBtn(){
		return brandcast.getChildElementByXpath(this.getSaveWebsiteAsTemplateForm(),this.getSaveWebsiteTemplateCreateTemplateBtnXpath())
	}

	@Keyword
	def clickSaveWebsiteTemplateCreateBtn(){
		brandcast.clickChildWebElement(this.getSaveWebsiteAsTemplateForm(),this.getSaveWebsiteTemplateCreateTemplateBtnXpath())
	}

	/*Preview Saved Template Overlay*/
	private String SavedTemplateOverlayXpath = '//span[contains(@id,"app") and contains(@class,"design-studio-root")]/div[contains(@class,"inline")]/span[contains(@class,"app-container") and contains(@class,"hidden-launch") and contains(@class,"design-studio") and contains(@class,"app-ready") and contains(@class,"logged-in") and contains(@class,"login-complete")]/span/div[contains(@class,"overlays-wrapper") and contains(@class,"overlay-bounds")]/div[contains(@class,"window-area") and contains(@class,"settings-window-area") and contains(@class,"confirmation-modal") and contains(@class,"react-draggable") and contains(@data-tutorial-id,"WindowAreaTemplateCreatedContainer") and contains(@data-overlay-id,"windowareatemplatecreatedcontainer")]/div[contains(@class,"window-area-wrapper")]/div[contains(@class,"settings-container") and contains(@class,"new-template-overlay")]'

	String getSavedTemplateOverlayXpath(){
		this.SavedTemplateOverlayXpath
	}

	@Keyword
	WebElement getSavedTemplateOverlay(){
		return brandcast.getElementByXpath(this.getSavedTemplateOverlayXpath())
	}

	@Keyword
	def waitForNewTemplateOverlay(){
		brandcast.waitUntilPresenceOfElementLocatedBy(this.getSavedTemplateOverlayXpath())
	}

	//Close Button
	private String NewTemplateOverlayCloseBtnXpath = '//div[contains(@class,"close-container")]/div[contains(@class,"close")]'

	String getNewTemplateOverlayCloseBtnXpath(){
		return this.NewTemplateOverlayCloseBtnXpath
	}

	@Keyword
	WebElement getNewTemplateOverlayCloseBtn(){
		return brandcast.getChildElementByXpath(this.getSavedTemplateOverlay(),this.getNewTemplateOverlayCloseBtnXpath())
	}

	@Keyword
	def clickNewTemplateOverlayCloseBtn(){
		brandcast.clickChildWebElement(this.getSavedTemplateOverlay(),this.getNewTemplateOverlayCloseBtnXpath())
	}
	//Template View Button
	private TemplateOverlayViewButtonXpath = '//div[contains(@class,"content action-btns-wrapper")]/div[contains(@class,"ui-wrapper btn-style-d")]/button[contains(@class,"btn-html") and contains(@type,"button")]'

	String getTemplateOverlayViewButtonXpath(){
		return this.TemplateOverlayViewButtonXpath
	}

	WebElement getTemplateOverlayViewButton(){
		return brandcast.getChildElementByXpath(this.getSavedTemplateOverlay(), this.getTemplateOverlayViewButtonXpath())
	}

	@Keyword
	def clickgetTemplateOverlayViewButton(){
		brandcast.clickChildWebElement(this.getSavedTemplateOverlay(),getTemplateOverlayViewButtonXpath())
	}

	//Template Overlay Box
	private NewTemplateOverlayBoxXpath = '//div[contains(@class,"clearfix")]/div[contains(@class,"box")]'

	String getNewTemplateOverlayBoxXpath(){
		return this.NewTemplateOverlayBoxXpath
	}

	WebElement getNewTemplateOverlayBox(){
		return brandcast.getChildElementByXpath(this.getSavedTemplateOverlay(),this.getNewTemplateOverlayBoxXpath())
	}

	@Keyword
	def clickNewTemplateOverlayBox(){
		brandcast.clickChildWebElement(this.getSavedTemplateOverlay(),this.getNewTemplateOverlayBoxXpath())
	}

	//New Template Overlay
	private NewTemplateOverlayBoxDetailsXpath = '//div[contains(@class,"box-details")]/div[contains(@class,"box-wrapper")]/div[contains(@class,"title-date-wrap")]'

	String getNewTemplateOverlayBoxDetailsXpath(){
		return this.NewTemplateOverlayBoxDetailsXpath
	}

	WebElement getNewTemplateOverlayBoxDetails(){
		return brandcast.getChildElementByXpath(this.getNewTemplateOverlayBox(),this.getNewTemplateOverlayBoxDetailsXpath())
	}

	//Template Overlay Bax - Template Name
	private NewTemplateOverlayNameXpath = '//div[contains(@class,"title-date")]/h4'

	String getNewTemplateOverlayNameXpath(){
		return this.NewTemplateOverlayNameXpath
	}

	WebElement getNewTemplateOverlayName(){
		return brandcast.getChildElementByXpath(this.getNewTemplateOverlayBoxDetails(),this.getNewTemplateOverlayNameXpath())
	}

	/* MenuOptionOpenWebsiteXpath*/
	private String MenuOptionOpenWebsiteXpath = '//h4[contains(text(),"Open Website")]'
	String getMenuOptionOpenWebsiteXpath(){
		return this.MenuOptionOpenWebsiteXpath
	}

	WebElement getMenuOptionOpenWebsite(){
		return brandcast.getChildElementByXpath(this.getContextMenuDropDown(), this.getMenuOptionOpenWebsiteXpath())
	}

	@Keyword
	def waitforMenuOptionOpenWebsite(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getContextMenuDropDown(), this.getMenuOptionOpenWebsiteXpath())
	}

	@Keyword
	def clickMenuOptionOpenWebsite(){
		brandcast.clickChildWebElement(this.getContextMenuDropDown(), this.getMenuOptionOpenWebsiteXpath())
	}


	/* MenuOptionTemplatesXpath*/
	private String MenuOptionTemplatesXpath = '//h4[contains(text(),"Templates")]'
	String getMenuOptionTemplatesXpath(){
		return this.MenuOptionTemplatesXpath
	}

	WebElement getMenuOptionTemplates(){
		return brandcast.getChildElementByXpath(this.getContextMenuDropDown(), this.getMenuOptionTemplatesXpath())
	}

	@Keyword
	def waitforMenuOptionTemplates(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getContextMenuDropDown(), this.getMenuOptionTemplatesXpath())
	}

	@Keyword
	def clickMenuOptionTemplates(){
		brandcast.clickChildWebElement(this.getContextMenuDropDown(), this.getMenuOptionTemplatesXpath())
	}


	/* MenuOptionTagManagerXpath*/
	private String MenuOptionTagManagerXpath = '//h4[contains(text(),"Tag Manager")]'
	String getMenuOptionTagManagerXpath (){
		return this.MenuOptionTagManagerXpath
	}

	WebElement getMenuOptionTagManager(){
		return brandcast.getChildElementByXpath(this.getContextMenuDropDown(), this.getMenuOptionTagManagerXpath())
	}

	@Keyword
	def waitforMenuOptionTagManager(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getContextMenuDropDown(), this.getMenuOptionTagManagerXpath())
	}

	@Keyword
	def clickMenuOptionTagManager(){
		brandcast.clickChildWebElement(this.getContextMenuDropDown(), this.getMenuOptionTagManagerXpath())
	}


	/* MenuOptionExportCodeXpath*/
	private String MenuOptionExportCodeXpath = '//h4[contains(text(),"Export Code")]'

	String getMenuOptionExportCodeXpath (){
		return this.MenuOptionExportCodeXpath
	}

	WebElement getMenuOptionExportCode(){
		return brandcast.getChildElementByXpath(this.getContextMenuDropDown(), this.getMenuOptionExportCodeXpath())
	}

	@Keyword
	def waitforMenuOptionExportCode(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getContextMenuDropDown(), this.getMenuOptionExportCodeXpath())
	}

	@Keyword
	def clickMenuOptionExportCode(){
		brandcast.clickChildWebElement(this.getContextMenuDropDown(), this.getMenuOptionExportCodeXpath())
	}


	/*ExportHistory*/
	private String MenuOptionExportHistoryXpath = '//h4[contains(text(),"Export History")]'

	String getMenuOptionExportHistoryXpath(){
		return this.MenuOptionExportHistoryXpath
	}

	WebElement getMenuOptionExportHistory(){
		brandcast.getChildElementByXpath(this.getContextMenuDropDown(), this.getMenuOptionExportHistoryXpath())
	}

	@Keyword
	def clickMenuOptionExportHistory(){
		brandcast.clickChildWebElement(this.getContextMenuDropDown(), this.getMenuOptionExportHistoryXpath())
	}

	@Keyword
	def waitforMenuOptionExportHistory(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getContextMenuDropDown(), this.getMenuOptionExportHistoryXpath())
	}

	/*Stage Quick UI for Studio*/
	private String StageQuickUIForStudioXpath = '//span[@class="quick-ui-for-studio"]'

	String getStageQuickUIForStudioXpath(){
		return this.StageQuickUIForStudioXpath
	}

	WebElement getStageQuickUIForStudio(){
		return brandcast.getChildElementByXpath(this.getStageBcDesktop(), this.getStageQuickUIForStudioXpath())
	}

	@Keyword
	def clickStageQuickUIForStudio(){
		brandcast.clickChildWebElement(this.getStagePrimaryTextMenu(), this.getStageQuickUIForStudioXpath())
	}


	/*Tab Content Container*/
	private String TabContentContainerXpath = '//div[contains(@class,"toolbar") and contains(@class,"position-top-tabs") and contains(@class,"animated fadeInDown")]/div[@class="tab-content-container"]'

	String getTabContentContainerXpath(){
		return this.TabContentContainerXpath
	}

	WebElement getTabContentContainer(){
		return brandcast.getChildElementByXpath(this.getStageBcDesktop(), this.getTabContentContainerXpath())
	}


	/*Selected Tab Text*/
	private String SelectedTabTextXpath = '//span[@class="tab page selected"]/div[@class="tab-text"]/div[@class="swap-container clearfix"]/h5'

	String getSelectedTabTextXpath(){
		return this.SelectedTabTextXpath
	}

	WebElement getSelectedTabText(){
		return brandcast.getChildElementByXpath(this.getTabContentContainer(), this.getSelectedTabTextXpath())
	}

	@Keyword
	def clickSelectedTabText(){
		brandcast.clickChildWebElement(this.getStagePrimaryTextMenu(), this.getSelectedTabTextXpath())
	}


	/*Home Tab Close Container List*/
	private String SelectedHomeTabCloseIconXpath = '//span[contains(@class,"tab") and contains(@class,"page") and contains(@class,"selected")]/div[@class="tab-close-container"]'

	String getSelectedHomeTabCloseIconXpath(){
		return this.SelectedHomeTabCloseIconXpath
	}

	WebElement getSelectedHomeTabCloseIcon(){
		return brandcast.getChildElementByXpath(this.getTabContentContainer(), this.getSelectedHomeTabCloseIconXpath())
	}

	@Keyword
	def clickSelectedHomeTabCloseIcon(){
		brandcast.clickChildWebElement(this.getTabContentContainer(), this.getSelectedHomeTabCloseIconXpath())
	}

	@Keyword
	def waitForSelectedHomeTabCloseIcon(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getTabContentContainer(), this.getSelectedHomeTabCloseIconXpath())
	}

	/*Selected New Website Tab*/
	private String SelectedNewWebsiteTabXpath = '//div[contains(@class,"toolbar") and contains(@class,"position-top-tabs") and contains(@class,"animated") and contains(@class, "fadeInDown")]/div[contains(@class,"tab-content-container")]'

	String getSelectedNewWebsiteTabXpath(){
		return this.SelectedNewWebsiteTabXpath
	}

	WebElement getSelectedNewWebsiteTab(){
		return brandcast.getElementByXpath(this.getSelectedNewWebsiteTabXpath())
	}

	/*Selected New Website Tab Text*/
	private String SelectedNewWebsiteTabTextXpath = '//span[@class="tab website selected"]/div[@class="tab-text"]/div[@class="swap-container clearfix"]/h5'

	String getSelectedNewWebsiteTabTextXpath(){
		return this.SelectedNewWebsiteTabTextXpath
	}

	WebElement getSelectedNewWebsiteTabText(){
		return brandcast.getChildElementByXpath(this.getSelectedNewWebsiteTab(), this.getSelectedNewWebsiteTabTextXpath())
	}

	/*Close New Website Tab*/
	private String CloseNewWebsiteTabXpath = '//span[@class="tab website selected"]/div[@class="tab-close-container"]'

	String getCloseNewWebsiteTabXpath(){
		return this.CloseNewWebsiteTabXpath
	}

	WebElement getCloseNewWebsiteTab(){
		return brandcast.getChildElementByXpath(this.getSelectedNewWebsiteTab(), this.getCloseNewWebsiteTabXpath())
	}

	@Keyword
	def clickCloseNewWebsiteIcon(){
		brandcast.clickChildWebElement(this.getSelectedNewWebsiteTab(), this.getCloseNewWebsiteTabXpath())
	}


	/*Design Studio Stage*/
	private String DesigningStudioStageXpath = '//html/body[contains(@class, "logo-loader") and contains(@class, "in-editor")]/span[contains(@id,"app") and contains(@class,"design-studio-root")]/div[contains(@class,"inline")]/span[contains(@class,"app-container") and contains(@class,"hidden-launch") and contains(@class,"design-studio") and contains(@class,"app-ready") and contains(@class,"logged-in") and contains(@class,"login-complete")]'

	String getDesigningStudioStageXpath(){
		return this.DesigningStudioStageXpath
	}

	WebElement getDesigningStudioStage(){
		return brandcast.getElementByXpath(this.getDesigningStudioStageXpath())
	}

	@Keyword
	def waitForDesigningStudioStage(){
		brandcast.waitUntilPresenceOfElementLocatedBy(this.getDesigningStudioStageXpath())
	}

	/*Site Map ToolBar*/
	private String SiteMapToolBarXpath = '//div[contains(@class,"site-info-toolbar") and contains(@class, "clearfix")]/div[@class="site-info-toolbar-left"]/div[@class="site-map-toolbar-item"]'

	String getSiteMapToolBarXpath(){
		return this.SiteMapToolBarXpath
	}

	WebElement getSiteMapToolBar(){
		return brandcast.getChildElementByXpath(this.getDesigningStudioStage(), this.getSiteMapToolBarXpath())
	}

	/*Left Vertical Toolbar*/
	private String LeftVerticalToolbarXpath ='//div[contains(@class,"toolbar") and contains(@class,"vertical") and contains(@class,"position-left") and contains(@class,"droppable") and contains(@class,"animated") and contains(@class,"fadeInLeft")]'

	String getLeftVerticalToolbarXpath(){
		return this.LeftVerticalToolbarXpath
	}

	WebElement getLeftVerticalToolbar(){
		return brandcast.getChildElementByXpath(this.getDesigningStudioStage(), this.getLeftVerticalToolbarXpath())
	}

	/*Grid Icon*/
	private String GridClassName = 'grid-element'
	private String GridToolBarElementXpath = '//div[contains(@class,"ui-wrapper") and contains(@class,"grid-element") and contains(@data-identifier, "toolbarGrid") and contains(@data-tutorial-id,"global-Grid") and contains(@title,"Grid")]/div[contains(@class,"btn") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-type,"Grid") and contains(@data-drop-effect,"copy") and contains(@data-identifier,"toolbarGrid")]'

	String getGridClassName(){
		return this.GridClassName
	}

	String getGridToolBarElementXpath(){
		return this.GridToolBarElementXpath
	}

	WebElement getGridToolBarElement(){
		return brandcast.getChildElementByXpath(this.getDesigningStudioStage(), this.getGridToolBarElementXpath())
	}

	private String StageGridElementXpath = '//div[contains(@data-schema-name,"Grid") and contains(@class,"bc-grid-wrapper") and contains(@class,"focused") and contains(@class,"root-component") and contains(@data-radium,"true") and contains(@data-drag-type,"Grid")]'

	String getStageGridElementXpath(){
		return this.StageGridElementXpath
	}

	/*design-snippets-btn*/
	private String DesignSnippetsXpath = '//div[contains(@class,"ui-wrapper") and contains(@class,"design-snippets-btn") and contains(@title, "Blocks")]/div[contains(@class, "btn") and contains(@data-identifier,"toolbarDesignSnippets") and contains(@data-qa-id,"design-snippets-btn")]'
	String getDesignSnippetsXpath(){
		return this.DesignSnippetsXpath
	}

	WebElement getDesignSnippets(){
		return brandcast.getChildElementByXpath(this.getDesigningStudioStage(), this.getGridToolBarElementXpath())
	}

	/*container-element*/
	private String ContainerElementXpath = '//div[contains(@class,"ui-wrapper") and contains(@class,"container-element") and contains(@data-identifier, "toolbarContainer") and contains(@data-tutorial-id,"global-Container") and contains(@title, "Container")]/div[contains(@class,"btn") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-type,"Container") and contains(@data-drop-effect,"copy") and contains(@data-identifier,"toolbarContainer")]'
	String getContainerElementXpath(){
		return this.ContainerElementXpath
	}

	WebElement getContainerElement(){
		return brandcast.getChildElementByXpath(this.getDesigningStudioStage(), this.getContainerElementXpath())
	}

	/*text-element*/
	private String TextElementXpath = '//div[contains(@class,"ui-wrapper") and contains(@class,"text-element") and contains(@data-identifier,"toolbarText") and contains(@data-tutorial-id,"global-Text") and contains(@title,"Text")]/div[contains(@class,"btn") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-type,"Text") and contains(@data-drop-effect,"copy") and contains(@data-identifier,"toolbarText")]'

	String getTextElementXpath(){
		return this.TextElementXpath
	}

	WebElement getTextElement(){
		return brandcast.getChildElementByXpath(this.getDesigningStudioStage(), this.getTextElementXpath())
	}

	private String StageTextElementXpath = '//span[contains(@class,"bc-site-content")]/div[contains(@data-radium,"true")]/div[contains(@class,"root") and contains(@class,"disable-link") and contains(@class,"has-selections") and contains(@class,"is-master-page-empty") and contains(@class,"outline-view")]/span/span/div[contains(@class,"inline") and contains(@data-radium,"true")]/div[contains(@class,"inline")]/span/div[contains(@data-schema-name,"Text") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-is-selected,"true") and contains(@data-drag-type,"Text") and contains(@data-drop-accepts-around,"Container") and contains(@data-drop-accepts-around,"Grid") and contains(@data-drop-accepts-around,"Text") and contains(@data-drop-accepts-around,"Gallery") and contains(@data-drop-accepts-around,"LinkTree") and contains(@data-drop-accepts-around,"Embed") and contains(@data-drop-accepts-around,"Video") and contains(@data-drop-accepts-around,"Image") and contains(@data-drop-accepts-around,"SnippetContent Anchor") and contains(@data-drop-accepts-around,"ContentSnippet") and contains(@data-drop-accepts-inside,"NATIVE_FILE") and contains(@data-drop-accepts-inside,"ImageContent") and contains(@data-drop-accepts-inside,"VideoContent") and contains(@class,"bc-text-wrapper") and contains(@class,"component-wrapper") and contains(@class,"bc-center") and contains(@class,"affected-by-selection") and contains(@class,"empty") and contains(@class,"focused") and contains(@class,"root-component") and contains(@data-radium,"true")]'

	String getStageTextElementXpath(){
		return this.StageTextElementXpath
	}

	WebElement getStageTextElement(){
		return brandcast.getChildElementByXpath(this.getStageIframeBody(),this.getStageTextElementXpath())
	}

	@Keyword
	def waitForStageTextElement(){
		brandcast.waitVisibilityOfWebElement(this.getStageTextElement())
	}

	/*image-element*/
	private String ImageElementXpath = '//div[contains(@class,"ui-wrapper") and contains(@class,"image-element") and contains(@data-identifier,"toolbarImage") and contains(@data-tutorial-id,"global-Image") and contains(@title,"Image")]/div[contains(@class,"btn") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-type,"Image") and contains(@data-drop-effect,"copy") and contains(@data-identifier,"toolbarImage")]'

	String getImageElementXpath(){
		return this.ImageElementXpath
	}

	WebElement getImageElement(){
		return brandcast.getChildElementByXpath(this.getDesigningStudioStage(), this.getImageElementXpath())
	}

	private String StageImageElementXpath = '//span[contains(@class,"bc-site-content")]/div[contains(@data-radium,"true")]/div[contains(@class,"root") and contains(@class,"disable-link") and contains(@class,"has-selections") and contains(@class,"is-master-page-empty") and contains(@class,"outline-view")]/span/span/div[contains(@class,"inline") and contains(@data-radium,"true")]/div[contains(@class,"inline")]/span/div[contains(@data-schema-name,"Image") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-is-selected,"true") and contains(@data-drag-type,"Image") and contains(@data-drop-accepts-around,"Container Grid Text Gallery LinkTree Embed Video Image SnippetContent Anchor ContentSnippet") and contains(@data-drop-accepts-inside,"NATIVE_FILE ImageContent VideoContent") and contains(@class,"bc-image-wrapper") and contains(@class,"fill-width") and contains(@class,"component-wrapper") and contains(@class,"bc-center") and contains(@class,"affected-by-selection") and contains(@class,"empty") and contains(@class,"focused") and contains(@class,"root-component") and contains(@data-radium,"true")]'

	String getStageImageElementXpath(){
		return this.StageImageElementXpath
	}

	WebElement getStageImageElement(){
		return brandcast.getChildElementByXpath(this.getStageIframeBody(),this.getStageImageElementXpath())
	}

	/*gallery-element*/
	private String GalleryElementXpath = '//div[contains(@class,"ui-wrapper") and contains(@class,"gallery-element") and contains(@data-identifier,"toolbarGallery") and contains(@data-tutorial-id,"global-Gallery") and contains(@title,"Gallery")]/div[contains(@class,"btn") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-type,"Gallery") and contains(@data-drop-effect,"copy") and contains(@data-identifier,"toolbarGallery")]'

	String getGalleryElementXpath(){
		return this.GalleryElementXpath
	}

	WebElement getGalleryElement(){
		return brandcast.getChildElementByXpath(this.getDesigningStudioStage(), this.getGalleryElementXpath())
	}

	private String StageGalleryElementXpath = '//div[@data-schema-name="Gallery" and @data-drag-group="COMPONENT"]'

	String getStageGalleryElementXpath(){
		return this.StageGalleryElementXpath
	}

	WebElement getStageGalleryElement(){
		return brandcast.getChildElementByXpath(this.getStageIframeBody(),this.getStageGalleryElementXpath())
	}

	/*anchor-element*/
	private String AnchorElementXpath = '//div[contains(@class,"ui-wrapper") and contains(@class,"anchor-element") and contains(@data-identifier,"toolbarAnchor") and contains(@data-tutorial-id,"global-Anchor") and contains(@title,"Anchor")]/div[contains(@class,"btn") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-type,"Anchor") and contains(@data-drop-effect,"copy") and contains(@data-identifier,"toolbarAnchor")]'

	String getAnchorElementXpath(){
		return this.AnchorElementXpath
	}

	WebElement getAnchorElement(){
		return brandcast.getChildElementByXpath(this.getDesigningStudioStage(), this.getAnchorElementXpath())
	}

	private String StageAnchorElementXpath = '//div[@data-schema-name="Anchor" and @data-drag-group="COMPONENT"]'

	String getStageAnchorElementXpath(){
		return this.StageAnchorElementXpath
	}

	WebElement getStageAnchorElement(){
		return brandcast.getChildElementByXpath(this.getStageIframeBody(),this.getStageAnchorElementXpath())
	}

	/*link-list-element*/
	private String LinkListElementXpath = '//div[contains(@class,"ui-wrapper") and contains(@class,"link-list-element") and contains(@data-identifier,"toolbarLinkList") and contains(@data-tutorial-id, "global-LinkTree") and contains(@title,"Link List")]/div[contains(@class,"btn") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-type,"LinkTree") and contains(@data-drop-effect,"copy") and contains(@data-identifier,"toolbarLinkList")]'

	String getLinkListElementXpath(){
		return this.LinkListElementXpath
	}

	WebElement getLinkListElement(){
		return brandcast.getChildElementByXpath(this.getDesigningStudioStage(), this.getLinkListElementXpath())
	}

	private String StageLinkListElementXpath = '//span[contains(@class,"bc-site-content")]/div[contains(@data-radium,"true")]/div[contains(@class,"root") and contains(@class,"disable-link") and contains(@class,"has-selections") and contains(@class, "is-master-page-empty") and contains(@class,"outline-view")]/span/span/div[contains(@class,"inline") and contains(@data-radium,"true")]/div[contains(@class,"inline")]/span/div[contains(@data-schema-name,"LinkTree") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-is-selected,"true") and contains(@data-drag-type,"LinkTree") and contains(@data-drop-accepts-around,"Container Grid Text Gallery LinkTree Embed Video Image SnippetContent Anchor ContentSnippet") and contains(@data-drop-accepts-inside,"NATIVE_FILE ImageContent VideoContent") and contains(@class,"bc-link-tree-wrapper") and contains(@class,"bc-link-tree-on-click") and contains(@class,"component-wrapper") and contains(@class,"bc-center") and contains(@class,"is-horizontal") and contains(@class,"affected-by-selection") and contains(@class,"empty") and contains(@class,"focused") and contains(@class,"root-component") and contains(@data-radium,"true")]'

	String getStageLinkListElementXpath(){
		return this.StageLinkListElementXpath
	}

	WebElement getStageLinkListElement(){
		return brandcast.getChildElementByXpath(this.getStageIframeBody(), this.getStageLinkListElementXpath())
	}

	private String getStageLinkListInfoXpath = 'div[contains(@data-drag-is-selected,"true") and contains(@data-drop-accepts-around,"Container Grid Text Gallery LinkTree Embed Video Image SnippetContent Anchor ContentSnippet") and contains(@class,"component-inner") and contains(@class,"root-site-width") and contains(@data-radium,"true")]'

	String getStageLinkListInfoXpath(){
		return this.getStageLinkListInfoXpath
	}
	WebElement getStageLinkListInfo(){
		return brandcast.getChildElementByXpath(this.getStageLinkListElement(), this.getStageLinkListInfoXpath())
	}
	/*video-element*/
	private String VideoElementXpath ='//div[contains(@class,"ui-wrapper") and contains(@class,"video-element") and contains(@data-identifier,"toolbarVideo") and contains(@data-tutorial-id,"global-Video") and contains(@title,"Video")]/div[contains(@class,"btn") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-type,"Video") and contains(@data-drop-effect,"copy") and contains(@data-identifier,"toolbarVideo")]'

	String getVideoElementXpath(){
		return this.VideoElementXpath
	}

	WebElement getVideoElement(){
		return brandcast.getChildElementByXpath(this.getDesigningStudioStage(), this.getVideoElementXpath())
	}

	private String StageVideoElementXpath = '//span[contains(@class,"bc-site-content")]/div[contains(@data-radium,"true")]/div[contains(@class,"root") and contains(@class,"disable-link") and contains(@class,"has-selections") and contains(@class,"is-master-page-empty") and contains(@class,"outline-view")]/span/span/div[contains(@class,"inline") and contains(@data-radium,"true")]/div[contains(@class,"inline")]/span/div[contains(@data-schema-name,"Video") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-is-selected,"true") and contains(@data-drag-type,"Video") and  contains(@data-drop-accepts-around,"Container Grid Text Gallery LinkTree Embed Video Image SnippetContent Anchor ContentSnippet") and  contains(@data-drop-accepts-inside,"NATIVE_FILE ImageContent VideoContent") and  contains(@class,"bc-video-wrapper") and  contains(@class,"component-wrapper") and contains(@class,"bc-center") and contains(@class,"affected-by-selection") and contains(@class,"empty") and contains(@class,"focused") and contains(@class,"root-component") and contains(@data-radium,"true")]'

	String getStageVideoElementXpath(){
		return this.StageVideoElementXpath
	}

	WebElement getStageVideoElement(){
		return brandcast.getChildElementByXpath(this.getStageIframeBody(),this.getStageVideoElementXpath())
	}

	/*embed-element*/
	private String EmbedElementXpath ='//div[contains(@class,"ui-wrapper") and contains(@class,"embed-element") and contains(@data-identifier,"toolbarEmbed") and contains(@data-tutorial-id,"global-Embed") and contains(@title,"Embed")]/div[contains(@class,"btn") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-type,"Embed") and contains(@data-drop-effect,"copy") and contains(@data-identifier,"toolbarEmbed")]'

	String getEmbedElementXpath(){
		return this.EmbedElementXpath
	}

	WebElement getEmbedElement(){
		return brandcast.getChildElementByXpath(this.getDesigningStudioStage(), this.getEmbedElementXpath())
	}

	private String StageEmbedElementXpath = '//span[contains(@class,"bc-site-content")]/div[contains(@data-radium,"true")]/div[contains(@class,"root") and contains(@class,"disable-link") and contains(@class,"has-selections") and contains(@class,"is-master-page-empty outline-view")]/span/span/div[contains(@class,"inline") and contains(@data-radium,"true")]/div[contains(@class,"inline")]/span/div[contains(@data-schema-name,"Embed") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-is-selected,"true") and contains(@data-drag-type,"Embed") and contains(@data-drop-accepts-around,"Container Grid Text Gallery LinkTree Embed Video Image SnippetContent Anchor ContentSnippet") and contains(@class,"bc-embed-wrapper") and contains(@class,"component-wrapper") and contains(@class,"bc-center") and contains(@class,"overflow-hidden") and contains(@class,"affected-by-selection") and contains(@class,"empty") and contains(@class,"focused") and contains(@class,"root-component") and contains(@data-radium,"true")]'

	String getStageEmbedElementXpath(){
		return this.StageEmbedElementXpath
	}

	WebElement getStageEmbedElement(){
		return brandcast.getChildElementByXpath(this.getStageIframeBody(),this.getStageEmbedElementXpath())
	}

	/* ==================================================================================================
	 *
	 * GET Stage Iframe Body
	 *
	 */
	WebElement getStageIframeBody(){
		return brandcast.getElementByTagName('body')
	}

	/* ==================================================================================================
	 *
	 * Stage Iframe
	 *
	 */
	private String DSStageXpath = '//span[contains(@class,"app-container") and contains(@class, "hidden-launch") and contains(@class, "design-studio") and contains(@class,"app-ready") and contains(@class,"logged-in") and contains(@class,"login-complete")]/span[contains(@class,"stage-wrapper") and contains(@class,"accounts-loaded")]/div[contains(@class,"stage") and contains(@class,"bc-desktop") and contains(@class,"icon") and contains(@class,"type-website")]'
	
	String getDSStageXpath(){
		return this.DSStageXpath
	}
	
	WebElement getDSStage(){
		return brandcast.getElementByXpath(this.getDSStageXpath())
	}
	
	/*Collection View Containers*/
	private String CollectionViewContainersXpath = '//div[contains(@class,"collection-view-container") and contains(@class,"tree-view") and contains(@class,"site-map-container") and contains(@class,"dark-theme")]/div[contains(@class,"pull-out-right")]'
	
	String getCollectionViewContainersXpath() {
		return this.CollectionViewContainersXpath
	}
	
	@Keyword
	WebElement getCollectionViewContainers(){
		return brandcast.getChildElementByXpath(this.getDSStage(),this.getCollectionViewContainersXpath())
	}
	
	/*Page Container*/
	private String PageContainerXpath = '//div[contains(@class,"page-container")]/div[contains(@class,"aux-page-wrapper")]/div[contains(@class,"aux-pages masters")]'
	
	String getPageContainerXpath() {
		return this.PageContainerXpath
	}
	
	@Keyword
	WebElement getPageContainer(){
		return brandcast.getChildElementByXpath(this.getCollectionViewContainers(),this.getPageContainerXpath())
	}
	
	/*Page Container Item*/
	private String PageContainerItemXpath ='//div[@class="page-item-container aux-page-item clearfix"]/div[@class="page-item-wrapper clearfix" and @data-drag-type="MasterPage"]/div[@class="page-item-preview-wrapper rendering-thumbnail"]/div[@class="page-item-preview-wrapper white-loader"]'
	
	String getPageContainerItemXpath(){
		return this.PageContainerItemXpath
	}
	
	@Keyword
	WebElement getPageContainerItem(){
		return brandcast.getChildElementByXpath(this.getPageContainer(),this.getPageContainerItemXpath())
	}
	
	@Keyword
	def doubleClickPageContainerItem(){
		brandcast.doubleClickWebElememnt(this.getPageContainerItem())
	}
	
	/* DS Stage Iframe*/
	private String DSStageIframeXpath = '//body[contains(@class,"logo-loader") and contains(@class,"in-editor")]/span[contains(@id,"app") and contains(@class,"design-studio-root")]/div[contains(@class,"inline")]/span[contains(@class,"app-container") and contains(@class, "hidden-launch") and contains(@class, "design-studio") and contains(@class,"app-ready") and contains(@class,"logged-in") and contains(@class,"login-complete")]/span[contains(@class,"stage-wrapper") and contains(@class,"accounts-loaded")]/div[contains(@class,"stage") and contains(@class,"bc-desktop") and contains(@class,"icon") and contains(@class,"type-page")]/span[contains(@class,"stage-outer")]/span[contains(@class,"stage-scale-wrapper") and contains(@data-omit-in-elements-from-point,"true")]/iframe[contains(@id,"stage-iframe") and contains(@class,"bc-desktop") and contains(@class,"icon")]'

	private String DSStageIframeID = 'stage-iframe'

	String getDSStageIframeXpath(){
		return this.DSStageIframeXpath
	}

	String getDSStageIframeID(){
		return this.DSStageIframeID
	}

	WebElement getDSStageIframe(){
		return brandcast.getElementByXpath(this.getDSStageIframeXpath())
	}

	@Keyword
	def switchToDSStageIframe(){
		brandcast.switchToIframeByID(this.getDSStageIframeID())
	}

	@Keyword
	def switchToIframeByWebElement(){
		brandcast.switchToIframeByWebElement(this.getDSStageIframe())
	}
	/*DS Stage Drop Element*/
	private String DsStageDropElementXpath = '//div[contains(@class,"bc-page-content-placeholder-container") and contains(@class,"drop-zone")]'

	String getDsStageDropElementXpath(){
		return this.DsStageDropElementXpath
	}

	WebElement getDsStageDropElement(){
		return brandcast.getElementByXpath(this.getDsStageDropElementXpath())
	}

	/* ==================================================================================================
	 * 
	 * Actuate Toolbar Components
	 * 
	 */

	@Keyword
	def dragGridToStage(){
		brandcast.dragAndDropIntoIframe(this.getGridToolBarElementXpath(), this.getDsStageDropElementXpath(), this.getDSStageIframe())
	}

	@Keyword
	def dragTextElementToStage(){
		brandcast.dragAndDropIntoIframe(this.getTextElementXpath(), this.getDsStageDropElementXpath(), this.getDSStageIframe())
	}

	@Keyword
	def dragImageElementToStage(){
		brandcast.dragAndDropIntoIframe(this.getImageElementXpath(), this.getDsStageDropElementXpath(), this.getDSStageIframe())
	}

	@Keyword
	def dragGalleryElementToStage(){
		brandcast.dragAndDropIntoIframe(this.getGalleryElementXpath(), this.getDsStageDropElementXpath(), this.getDSStageIframe())
	}

	@Keyword
	def dragAnchorElementToStage(){
		brandcast.dragAndDropIntoIframe(this.getAnchorElementXpath(), this.getDsStageDropElementXpath(), this.getDSStageIframe())
	}

	@Keyword
	def dragLinkListElementToStage(){
		brandcast.dragAndDropIntoIframe(this.getLinkListElementXpath(), this.getDsStageDropElementXpath(), this.getDSStageIframe())
	}

	@Keyword
	def dragVideoElementToStage(){
		brandcast.dragAndDropIntoIframe(this.getVideoElementXpath(), this.getDsStageDropElementXpath(), this.getDSStageIframe())
	}

	@Keyword
	def dragEmbedElementToStage(){
		brandcast.dragAndDropIntoIframe(this.getEmbedElementXpath(), this.getDsStageDropElementXpath(), this.getDSStageIframe())
	}




	/* ==================================================================================================
	 * 
	 * Verify Stage Components
	 * 
	 */
	@Keyword
	def verifyStageImageElement(){
		brandcast.verifyElementInIframe(this.getStageImageElementXpath(), this.getDSStageIframe())
	}

	@Keyword
	def verifyStageGridElement(){
		brandcast.verifyElementInIframe(this.getStageGridElementXpath(), this.getDSStageIframe())
	}

	@Keyword
	def verifyStageGalleryElement(){
		brandcast.verifyElementInIframe(this.getStageGalleryElementXpath(), this.getDSStageIframe())
	}

	@Keyword
	def verifyStageEmbedElement(){
		brandcast.verifyElementInIframe(this.getStageEmbedElementXpath(), this.getDSStageIframe())
	}

	@Keyword
	def verifyStageLinkListElement(){
		brandcast.verifyElementInIframe(this.getStageLinkListElementXpath(), this.getDSStageIframe())
	}

	@Keyword
	def verifyStageTextElement(){
		brandcast.verifyElementInIframe(this.getStageTextElementXpath(), this.getDSStageIframe())
	}

	@Keyword
	def verifyStageAnchorElement(){
		brandcast.verifyElementInIframe(this.getStageAnchorElementXpath(), this.getDSStageIframe())
	}

	@Keyword
	def verifyStageVideoElementXpath(){
		brandcast.verifyElementInIframe(this.getStageVideoElementXpath(), this.getDSStageIframe())
	}

	/**
	 * 
	 * List View
	 * 
	 */
	private String ListViewXpath = '//div[@class="bb"]/div[@title="List View"]'

	String getListViewXpath(){
		return this.ListViewXpath
	}

	WebElement getListView(){
		return brandcast.getChildElementByXpath(this.getSiteMapToolBar(), this.getListViewXpath())
	}
}
