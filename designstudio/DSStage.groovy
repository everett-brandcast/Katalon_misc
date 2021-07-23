package com.designstudio


import java.util.List

import org.openqa.selenium.WebElement

/*Custom Keywords*/
import com.brandcast.Core
import com.brandcast.Utils
import com.kms.katalon.core.annotation.Keyword
import html5.dnd.DragAndDropHelper

public class DSStage {
	Core brandcast = new Core()
	Utils utils = new Utils()
	DragAndDropHelper dragNdrop = new DragAndDropHelper()

	/* Pendo Overlay*/
	
	private def PendoOverlayXpath = {'//div[contains(@data-vertical-alignment,"Bottom Aligned") and contains(@class,"_pendo-step-container-size")]/div[contains(@id,"pendo-guide-container") and contains(@class,"_pendo-step-container-styles")]'}
	
	def getPendoOverlayXpath = { return this.PendoOverlayXpath.call()}
	
	WebElement getPendoOverlay(){
		return brandcast.getElementByXpath(this.getPendoOverlayXpath.call())
	}
	
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
	
	
	/**
	 * 
	 * Container
	 * 
	 */
	private StageNewWebsiteTabContainerXpath = '//div[@class="stage bc-desktop icon type-page"]/div[@class="toolbar position-top-tabs animated fadeInDown"]/div[@class="tab-content-container"]'

	String getStageNewWebsiteTabContainerXpath(){
		return this.StageNewWebsiteTabContainerXpath
	}

	WebElement getStageNewWebsiteTabContainer(){
		return brandcast.getElementByXpath(this.getStageNewWebsiteTabContainerXpath())
	}


	/**
	 * Stage New Website Tab
	 *
	 */
	private StageNewWebsiteTabXpath = '//a[@class="tab website"]/div[@class="tab-text"]'

	String getStageNewWebsiteTabXpath(){
		return this.StageNewWebsiteTabXpath
	}

	WebElement getStageNewWebsiteTab(){
		return brandcast.getChildElementByXpath(this.getStageNewWebsiteTabContainerXpath(), this.getStageNewWebsiteTabXpath())
	}

	/**
	 * 
	 * Stage BC-Desktop
	 * 
	 */
	private String StageBcDesktopXpath = '//div[contains(@class,"stage") and contains(@class,"bc-desktop") and contains(@class,"icon") and contains(@class,"type-page")]'

	String getStageBcDesktopXpath(){
		return this.StageBcDesktopXpath
	}
	WebElement getStageBcDesktop(){
		return brandcast.getElementByXpath(this.getStageBcDesktopXpath())
	}

	private String StagePositionTopAXpath = '//div[contains(@class, "toolbar") and contains(@class, "position-top-a")]'

	String getStagePositionTopAXpath(){
		return this.StagePositionTopAXpath
	}

	WebElement getStagePositionTopA(){
		return brandcast.getChildElementByXpath(this.getStageBcDesktop(), this.getStagePositionTopAXpath())
	}

	private String StagePrimaryTextMenuXpath = '//div[contains(@class,"content") and contains(@class,"primary-text-menu") and contains(@class,"left")]'

	String getStagePrimaryTextMenuXpath(){
		return this.StagePrimaryTextMenuXpath
	}

	WebElement getStagePrimaryTextMenu(){
		return brandcast.getChildElementByXpath(this.getStageBcDesktop(), this.getStagePrimaryTextMenuXpath())
	}


	private String StageQuickUIForStudioXpath = '//span[@class="quick-ui-for-studio"]'

	String getStageQuickUIForStudioXpath(){
		return this.StageQuickUIForStudioXpath
	}

	WebElement getStageQuickUIForStudio(){
		return brandcast.getChildElementByXpath(this.getStageBcDesktop(), this.getStageQuickUIForStudioXpath())
	}


	/**
	 * 
	 * Tab Content Container
	 *
	 */
	private String TabContentContainerXpath = './/div[contains(@class,"toolbar") and contains(@class,"position-top-tabs") and contains(@class,"animated fadeInDown")]/div[@class="tab-content-container"]'

	String getTabContentContainerXpath(){
		return this.TabContentContainerXpath
	}

	WebElement getTabContentContainer(){
		return brandcast.getChildElementByXpath(this.getStageBcDesktop(), this.getTabContentContainerXpath())
	}

	private String SelectedTabTextXpath = '//span[@class="tab page selected"]/div[@class="tab-text"]/div[@class="swap-container clearfix"]/h5'

	String getSelectedTabTextXpath(){
		return this.SelectedTabTextXpath
	}

	WebElement getSelectedTabText(){
		return brandcast.getChildElementByXpath(this.getTabContentContainer(), this.getSelectedTabTextXpath())
	}

	/**
	 *
	 * Home Tab Close Container List
	 *
	 */
	private String SelectedHomeTabCloseIconXpath = './/span[contains(@class,"tab") and contains(@class,"page") and contains(@class,"selected")]/div[@class="tab-close-container"]'

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

	/**
	 *
	 * Selected New Website Tab
	 *
	 */
	private String SelectedNewWebsiteTabXpath = '//div[contains(@class,"toolbar") and contains(@class,"position-top-tabs") and contains(@class,"animated") and contains(@class, "fadeInDown")]/div[contains(@class,"tab-content-container")]'

	String getSelectedNewWebsiteTabXpath(){
		return this.SelectedNewWebsiteTabXpath
	}

	WebElement getSelectedNewWebsiteTab(){
		return brandcast.getElementByXpath(this.getSelectedNewWebsiteTabXpath())
	}

	/**
	 *
	 * Selected New Website Tab Text
	 *
	 */
	private String SelectedNewWebsiteTabTextXpath = '//span[@class="tab website selected"]/div[@class="tab-text"]/div[@class="swap-container clearfix"]/h5'

	String getSelectedNewWebsiteTabTextXpath(){
		return this.SelectedNewWebsiteTabTextXpath
	}

	WebElement getSelectedNewWebsiteTabText(){
		return brandcast.getChildElementByXpath(this.getSelectedNewWebsiteTab(), this.getSelectedNewWebsiteTabTextXpath())
	}

	/**
	 *
	 * Close New Website Tab
	 *
	 */
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


	/**
	 * 
	 *  Design Studio Stage
	 * 
	 */
	//private String DesigningStudioStageXpath = '//html/body[contains(@class, "logo-loader") and contains(@class, "in-editor")]/span[contains(@id,"app") and contains(@class,"design-studio-root")]/div[contains(@class,"inline")]/span[contains(@class,"app-container") and contains(@class,"hidden-launch") and contains(@class,"design-studio") and contains(@class,"app-ready") and contains(@class,"logged-in") and contains(@class,"login-complete")]'
	private String DesigningStudioStageXpath = '//span[contains(@id,"app") and contains(@class,"design-studio-root")]/div[contains(@class,"inline")]/span[contains(@class,"app-container") and contains(@class,"hidden-launch") and contains(@class,"design-studio") and contains(@class,"app-ready") and contains(@class,"logged-in") and contains(@class,"login-complete")]'

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


	/**
	 * 
	 * Site Map ToolBar
	 * 
	 */
	private String SiteMapToolBarXpath = '//div[contains(@class,"site-info-toolbar") and contains(@class, "clearfix")]/div[@class="site-info-toolbar-left"]/div[@class="site-map-toolbar-item"]'

	String getSiteMapToolBarXpath(){
		return this.SiteMapToolBarXpath
	}

	WebElement  getSiteMapToolBar(){
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
	private String GridToolBarElementXpath = './/div[contains(@class,"ui-wrapper") and contains(@class,"grid-element") and contains(@data-identifier, "toolbarGrid") and contains(@data-tutorial-id,"global-Grid") and contains(@title,"Grid")]/div[contains(@class,"btn") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-type,"Grid") and contains(@data-drop-effect,"copy") and contains(@data-identifier,"toolbarGrid")]'

	String getGridClassName(){
		return this.GridClassName
	}

	String getGridToolBarElementXpath(){
		return this.GridToolBarElementXpath
	}

	WebElement getGridToolBarElement(){
		return brandcast.getChildElementByXpath(this.getDesigningStudioStage(), this.getGridToolBarElementXpath())
	}

	private StageGridElementXpath = './/span[contains(@class,"bc-site-content")]/div[contains(@data-radium, "true")]/div[contains(@class, "root")]/span/span/div[contains(@class,"inline") and contains(@data-radium,"true")]/div[contains(@class,"inline")]/span/div[contains(@data-schema-name,"Grid") and contains(@class,"bc-grid-wrapper") and contains(@class,"focused") and contains(@class,"root-component") and contains(@data-radium,"true") and contains(@data-drag-type,"Grid")]'

	String getStageGridElementXpath(){
		return this.StageGridElementXpath
	}

	/*design-snippets-btn*/
	private DesignSnippetsXpath = './/div[contains(@class,"ui-wrapper") and contains(@class,"design-snippets-btn") and contains(@title, "Blocks")]/div[contains(@class, "btn") and contains(@data-identifier,"toolbarDesignSnippets") and contains(@data-qa-id,"design-snippets-btn")]'
	String getDesignSnippetsXpath(){
		return this.DesignSnippetsXpath
	}

	WebElement getDesignSnippets(){
		return brandcast.getChildElementByXpath(this.getDesigningStudioStage(), this.getGridToolBarElementXpath())
	}

	/*container-element*/
	private ContainerElementXpath = './/div[contains(@class,"ui-wrapper") and contains(@class,"container-element") and contains(@data-identifier, "toolbarContainer") and contains(@data-tutorial-id,"global-Container") and contains(@title, "Container")]/div[contains(@class,"btn") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-type,"Container") and contains(@data-drop-effect,"copy") and contains(@data-identifier,"toolbarContainer")]'
	String getContainerElementXpath(){
		return this.ContainerElementXpath
	}

	WebElement getContainerElement(){
		return brandcast.getChildElementByXpath(this.getDesigningStudioStage(), this.getContainerElementXpath())
	}

	/*text-element*/
	private TextElementXpath = './/div[contains(@class,"ui-wrapper") and contains(@class,"text-element") and contains(@data-identifier,"toolbarText") and contains(@data-tutorial-id,"global-Text") and contains(@title,"Text")]/div[contains(@class,"btn") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-type,"Text") and contains(@data-drop-effect,"copy") and contains(@data-identifier,"toolbarText")]'

	String getTextElementXpath(){
		return this.TextElementXpath
	}

	WebElement getTextElement(){
		return brandcast.getChildElementByXpath(this.getDesigningStudioStage(), this.getTextElementXpath())
	}

	private StageTextElementXpath = './/span[contains(@class,"bc-site-content")]/div[contains(@data-radium, "true")]/div[contains(@class, "root")] /span/span/div[contains(@class,"inline") and contains(@data-radium,"true")]/div[contains(@class,"inline")]/span/div[contains(@data-schema-name,"Text") and contains(@class,"bc-text-wrapper") and contains(@class,"focused") and contains(@class,"root-component") and contains(@data-radium,"true") and contains(@data-drag-type,"Text")]'

	String getStageTextElementXpath(){
		return this.StageTextElementXpath
	}

	/*image-element*/
	private ImageElementXpath = './/div[contains(@class,"ui-wrapper") and contains(@class,"image-element") and contains(@data-identifier,"toolbarImage") and contains(@data-tutorial-id,"global-Image") and contains(@title,"Image")]/div[contains(@class,"btn") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-type,"Image") and contains(@data-drop-effect,"copy") and contains(@data-identifier,"toolbarImage")]'

	String getImageElementXpath(){
		return this.ImageElementXpath
	}

	WebElement getImageElement(){
		return brandcast.getChildElementByXpath(this.getDesigningStudioStage(), this.getImageElementXpath())
	}

	private StageImageElementXpath = './/span/div[contains(@data-schema-name,"Image") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-is-selected,"true") and contains(@data-drag-type,"Image")]'

	String getStageImageElementXpath(){
		return this.StageImageElementXpath
	}

	/*gallery-element*/
	private GalleryElementXpath = './/div[contains(@class,"ui-wrapper") and contains(@class,"gallery-element") and contains(@data-identifier,"toolbarGallery") and contains(@data-tutorial-id,"global-Gallery") and contains(@title,"Gallery")]/div[contains(@class,"btn") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-type,"Gallery") and contains(@data-drop-effect,"copy") and contains(@data-identifier,"toolbarGallery")]'

	String getGalleryElementXpath(){
		return this.GalleryElementXpath
	}

	WebElement getGalleryElement(){
		return brandcast.getChildElementByXpath(this.getDesigningStudioStage(), this.getGalleryElementXpath())
	}

	private StageGalleryElementXpath = './/span/div[contains(@data-schema-name,"Gallery") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-is-selected,"true") and contains(@data-drag-type,"Gallery")]'

	String getStageGalleryElementXpath(){
		return this.StageGalleryElementXpath
	}

	/*anchor-element*/
	private AnchorElementXpath = './/div[contains(@class,"ui-wrapper") and contains(@class,"anchor-element") and contains(@data-identifier,"toolbarAnchor") and contains(@data-tutorial-id,"global-Anchor") and contains(@title,"Anchor")]/div[contains(@class,"btn") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-type,"Anchor") and contains(@data-drop-effect,"copy") and contains(@data-identifier,"toolbarAnchor")]'

	String getAnchorElementXpath(){
		return this.AnchorElementXpath
	}

	WebElement getAnchorElement(){
		return brandcast.getChildElementByXpath(this.getDesigningStudioStage(), this.getAnchorElementXpath())
	}

	private StageAnchorElementXpath = './/span[contains(@class,"bc-site-content")]/div[contains(@data-radium,"true")]/div[contains(@class,"root")] /span/span/div[contains(@class,"inline") and contains(@data-radium,"true")]/div[contains(@class,"inline")]/span/div[contains(@data-schema-name,"Anchor") and contains(@class,"bc-anchor-wrapper") and contains(@class,"selected") and contains(@data-radium,"true")]'

	String getStageAnchorElementXpath(){
		return this.StageAnchorElementXpath
	}

	/*link-list-element*/
	private LinkListElementXpath = './/div[contains(@class,"ui-wrapper") and contains(@class,"link-list-element") and contains(@data-identifier,"toolbarLinkList") and contains(@data-tutorial-id, "global-LinkTree") and contains(@title,"Link List")]/div[contains(@class,"btn") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-type,"LinkTree") and contains(@data-drop-effect,"copy") and contains(@data-identifier,"toolbarLinkList")]'

	String getLinkListElementXpath(){
		return this.LinkListElementXpath
	}

	WebElement getLinkListElement(){
		return brandcast.getChildElementByXpath(this.getDesigningStudioStage(), this.getLinkListElementXpath())
	}

	private StageLinkListElementXpath = './/span/div[contains(@data-schema-name,"LinkTree") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-is-selected,"true") and contains(@data-drag-type,"LinkTree")]'

	String getStageLinkListElementXpath(){
		return this.StageLinkListElementXpath
	}

	/*video-element*/
	private VideoElementXpath ='.//div[contains(@class,"ui-wrapper") and contains(@class,"video-element") and contains(@data-identifier,"toolbarVideo") and contains(@data-tutorial-id,"global-Video") and contains(@title,"Video")]/div[contains(@class,"btn") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-type,"Video") and contains(@data-drop-effect,"copy") and contains(@data-identifier,"toolbarVideo")]'

	String getVideoElementXpath(){
		return this.VideoElementXpath
	}

	WebElement getVideoElement(){
		return brandcast.getChildElementByXpath(this.getDesigningStudioStage(), this.getVideoElementXpath())
	}

	private StageVideoElementXpath = './/span[contains(@class,"bc-site-content")]/div[contains(@data-radium, "true")]/div[contains(@class, "root")] /span/span/div[contains(@class,"inline") and contains(@data-radium,"true")]/div[contains(@class,"inline")]/span/div[contains(@data-schema-name,"Video") and contains(@class,"bc-video-wrapper") and contains(@class,"focused") and contains(@class,"root-component") and contains(@data-radium,"true") and contains(@data-drag-type,"Video")]'

	String getStageVideoElementXpath(){
		return this.StageVideoElementXpath
	}

	/*embed-element*/
	private EmbedElementXpath ='.//div[contains(@class,"ui-wrapper") and contains(@class,"embed-element") and contains(@data-identifier,"toolbarEmbed") and contains(@data-tutorial-id,"global-Embed") and contains(@title,"Embed")]/div[contains(@class,"btn") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-type,"Embed") and contains(@data-drop-effect,"copy") and contains(@data-identifier,"toolbarEmbed")]'

	String getEmbedElementXpath(){
		return this.EmbedElementXpath
	}

	WebElement getEmbedElement(){
		return brandcast.getChildElementByXpath(this.getDesigningStudioStage(), this.getEmbedElementXpath())
	}

	private StageEmbedElementXpath = './/span/div[contains(@data-schema-name,"Embed") and contains(@data-drag-group,"COMPONENT") and contains(@data-drag-is-selected,"true") and contains(@data-drag-type,"Embed")]'

	String getStageEmbedElementXpath(){
		return this.StageEmbedElementXpath
	}

	/*Stage Iframe*/
	private String DSStageIframeXpath = '//iframe[@id="stage-iframe" and @class="bc-desktop icon"]'

	String getDSStageIframeXpath(){
		return this.DSStageIframeXpath
	}

	WebElement getDSStageIframe(){
		return brandcast.getChildElementByXpath(this.getDesigningStudioStage(),this.getDSStageIframeXpath())
	}

	@Keyword
	def switchToDSStageIframe(){
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

	@Keyword
	def clickAndHoldGrid(){
		brandcast.clickAndHoldWebElememnt(this.getGridToolBarElement())
	}

	@Keyword
	def dragGridToStage(){
		brandcast.dragAndDropIntoIframe(this.getGridToolBarElementXpath(), this.getDsStageDropElementXpath(), this.getDSStageIframeXpath())
	}

	@Keyword
	def dragTextElementToStage(){
		brandcast.dragAndDropIntoIframe(this.getTextElementXpath(), this.getDsStageDropElementXpath(), this.getDSStageIframeXpath())
	}

	@Keyword
	def dragImageElementToStage(){
		brandcast.dragAndDropIntoIframe(this.getImageElementXpath(), this.getDsStageDropElementXpath(), this.getDSStageIframeXpath())
	}

	@Keyword
	def dragGalleryElementToStage(){
		brandcast.dragAndDropIntoIframe(this.getGalleryElementXpath(), this.getDsStageDropElementXpath(), this.getDSStageIframeXpath())
	}

	@Keyword
	def dragAnchorElementToStage(){
		brandcast.dragAndDropIntoIframe(this.getAnchorElementXpath(), this.getDsStageDropElementXpath(), this.getDSStageIframeXpath())
	}

	@Keyword
	def dragLinkListElementToStage(){
		brandcast.dragAndDropIntoIframe(this.getLinkListElementXpath(), this.getDsStageDropElementXpath(), this.getDSStageIframeXpath())
	}

	@Keyword
	def dragVideoElementToStage(){
		brandcast.dragAndDropIntoIframe(this.getVideoElementXpath(), this.getDsStageDropElementXpath(), this.getDSStageIframeXpath())
	}

	@Keyword
	def dragEmbedElementToStage(){
		brandcast.dragAndDropIntoIframe(this.getEmbedElementXpath(), this.getDsStageDropElementXpath(), this.getDSStageIframeXpath())
	}

	@Keyword
	def verifyStageImageElement(){
		brandcast.verifyElementInIframe(this.getStageImageElementXpath(), this.getDSStageIframeXpath())
	}

	@Keyword
	def verifyStageGridElement(){
		brandcast.verifyElementInIframe(this.getStageGridElementXpath(), this.getDSStageIframeXpath())
	}

	@Keyword
	def verifyStageGalleryElement(){
		brandcast.verifyElementInIframe(this.getStageGalleryElementXpath(), this.getDSStageIframeXpath())
	}

	@Keyword
	def verifyStageEmbedElement(){
		brandcast.verifyElementInIframe(this.getStageEmbedElementXpath(), this.getDSStageIframeXpath())
	}

	@Keyword
	def verifyStageLinkListElement(){
		brandcast.verifyElementInIframe(this.getStageLinkListElementXpath(), this.getDSStageIframeXpath())
	}

	@Keyword
	def verifyStageTextElement(){
		brandcast.verifyElementInIframe(this.getStageTextElementXpath(), this.getDSStageIframeXpath())
	}

	@Keyword
	def verifyStageAnchorElement(){
		brandcast.verifyElementInIframe(this.getStageAnchorElementXpath(), this.getDSStageIframeXpath())
	}

	@Keyword
	def verifyStageVideoElementXpath(){
		brandcast.verifyElementInIframe(this.getStageVideoElementXpath(), this.getDSStageIframeXpath())
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
