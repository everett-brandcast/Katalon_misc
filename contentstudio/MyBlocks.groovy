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


class MyBlocks {
	Core brandcast = new Core()
	Utils utils = new Utils()


	private def NewWebsiteName =  {utils.getWebsiteName()}

	def getNewWebsiteName = {return this.NewWebsiteName.call()}

	@Keyword //this.getNewWebsiteName()
	def waitForNewWebsiteTabText = {String elementXpath, String websiteName ->
		brandcast.waittextToBePresent(elementXpath, websiteName)
	}

	@Keyword
	def returnToDefaultIframe(){
		brandcast.switchToDefaultIframe()
	}

	/**=============================================================================================================
	 * 
	 * Admin Container
	 * 
	 */
	private def AdminContainerXpath = {$///span[contains(@id,"app") and contains(@class,"design-studio-root")]/div[contains(@class,"inline")]/span[contains(@class,"app-container") and contains(@class,"hidden-launch") and contains(@class,"dashboard") and contains(@class,"app-ready") and contains(@class,"logged-in")  and contains(@class,"login-complete")]/div[@class="admin-wrapper"]/$}

	def getAdminContainerXpath = {
		return this.AdminContainerXpath.call()
	}

	@Keyword
	WebElement getAdminContainer(){
		return brandcast.getElementByXpath(this.getAdminContainerXpath.call())
	}

	@Keyword
	def waitForAdminContainer = {
		brandcast.waitUntilPresenceOfElementLocatedBy(this.getAdminContainerXpath.call())
	}

	/**=============================================================================================================
	 *
	 *  Admin Container Admin Content
	 */
	private def AdminContentXpath = {'.//div[@class="admin-content"]'}

	def getAdminContentXpath = { return this.AdminContentXpath.call() }

	@Keyword
	WebElement getAdminContent(){
		return brandcast.getChildElementByXpath(this.getAdminContainer(), this.getAdminContentXpath.call())
	}

	/**=============================================================================================================
	 *
	 * My Blocks Modal
	 * 
	 */
	private String MyBlocksModalXpath = '//div[contains(@class,"my-blocks flex module-wrapper")]'//div[contains(@class,"module")]/div[contains(@class,"fl-wrap") and contains(@class, "direction-column")]/div[contains(@class,"fl-row")]/div[contains(@class,"module-header-b")]'

	def getMyBlocksModalXpath = {return this.MyBlocksModalXpath}

	@Keyword
	WebElement getMyBlocksModal(){
		return brandcast.getChildElementByXpath(this.getAdminContainer(), this.getMyBlocksModalXpath.call())
	}

	@Keyword
	def waitForMyBlocksModal = {
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getAdminContainer(), this.getMyBlocksModalXpath.call())
	}

	/*MyBlocks Search Sort Bar*/
	private String  MyBlocksSearchSortBarXpath = '//div[contains(@class,"search-sort-bar")]'

	def getMyBlocksSearchSortBarXpath = {
		return this.MyBlocksSearchSortBarXpath
	}

	@Keyword
	WebElement getMyBlocksSearchSortBar(){
		return brandcast.getChildElementByXpath(this.getMyBlocksModal(), this.getMyBlocksSearchSortBarXpath.call())
	}

	/*search input container*/
	private String SearchInputContainerXpath = '//div[contains(@class,"search-input-container default-search cc")]/div[contains(@class,"search-input-wrapper")]'

	def getSearchInputContainerXpath = {
		return this.SearchInputContainerXpath
	}

	@Keyword
	WebElement getSearchInputContainer(){
		return brandcast.getChildElementByXpath(this.getMyBlocksSearchSortBar(), this.getSearchInputContainerXpath.call())
	}


	/*magnify-icon*/
	private String  MagnifyIconXpath = '//div[contains(@[class,"magnify-icon-container")]'

	def getMagnifyIconXpath = {
		return this.MagnifyIconXpath
	}

	@Keyword
	WebElement getMagnifyIcon(){
		return brandcast.getChildElementByXpath(this.getSearchInputContainer(), this.getMagnifyIconXpath.call())
	}

	@Keyword
	def clickMagnifyIcon(){
		brandcast.clickChildWebElement(this.getSearchInputContainer(), this.getMagnifyIconXpath.call())
	}


	/*clear-search*/
	private String  ClearSearchXpath = '//div[contains(@class,"clear-search-container")]'

	def getClearSearchXpath = {
		return this.ClearSearchXpath
	}

	@Keyword
	WebElement getClearSearch(){
		return brandcast.getChildElementByXpath(this.getSearchInputContainer(), this.getClearSearchXpath.call())
	}

	@Keyword
	def clickClearSearch(){
		brandcast.clickChildWebElement(this.getSearchInputContainer(), this.getClearSearchXpath.call())
	}


	/*Search Input*/
	private String SearchInputXpath = '//input[contains(@type,"text") and contains(@placeholder,"Search")]'

	def getSearchInputXpath = {
		return this.SearchInputXpath
	}

	@Keyword
	WebElement getSearchInput(){
		return brandcast.getChildElementByXpath(this.getSearchInputContainer(), this.getSearchInputXpath.call())
	}

	@Keyword
	def clickSearchInput(){
		brandcast.clickChildWebElement(this.getSearchInputContainer(), this.getSearchInputXpath.call())
	}

	/*Sort Wrapper*/
	private String SortWrapperXpath = '//div[contains(@class,"sorting-wrapper")]/span[@class="sorting-ui"]'

	def getSortWrapperXpath = {
		return this.SortWrapperXpath
	}

	@Keyword
	WebElement getSortWrapper(){
		return brandcast.getChildElementByXpath(this.getMyBlocksSearchSortBar(), this.getSortWrapperXpath.call())
	}


	/*Sort Blocks*/
	private String  SortBlocksXpath = '//div[contains(@class,"bc-menu-group menu-select light-theme")]/div[contains(@class,"menu-item") and contains(@data-identifier,"websiteManager")]/div[contains(@class,"ui-wrapper menu-select-btn")]'

	def getSortBlocksXpath = {
		return this.SortBlocksXpath
	}

	@Keyword
	WebElement getSortBlocks(){
		return brandcast.getChildElementByXpath(this.getSortWrapper(), this.getSortBlocksXpath.call())
	}

	@Keyword
	def clickSortBlocks(){
		brandcast.clickChildWebElement(this.getSortWrapper(), this.getSortBlocksXpath.call())
	}

	/*Switch Order*/
	private String SwitchOrderXpath = '//div[contains(@class,"ui-wrapper editor-style") and contains(@title,"Switch Order")]/div[contains(@class,"btn")]'

	def getSwitchOrderXpath = {
		return this.SwitchOrderXpath
	}

	@Keyword
	WebElement getSwitchOrder(){
		return brandcast.getChildElementByXpath(this.getSortWrapper(), this.getSwitchOrderXpath.call())
	}

	@Keyword
	def clickSwitchOrder(){
		brandcast.clickChildWebElement(this.getSortWrapper(), this.getSwitchOrderXpath.call())
	}

	/*Import Blocks*/
	private String ImportBlocksXpath ='//div[contains(@class,"import-ui cs-permission-hide")]/div[contains(@class,"import tooltip-parent")]'

	def getImportBlocksXpath = {
		return this.ImportBlocksXpath
	}

	@Keyword
	WebElement getImportBlocks(){
		return brandcast.getChildElementByXpath(this.getSortWrapper(), this.getImportBlocksXpath.call())
	}

	@Keyword
	def clickImportBlocks(){
		brandcast.clickChildWebElement(this.getSortWrapper(), this.getImportBlocksXpath.call())
	}


	/*Delete Blocks*/
	private String DeleteBlocksXpath = '//div[contains(@class,"ui-wrapper") and contains(@class,"editor-style") and contains(@title,"Delete")]/div[contains(@class,"btn")]'

	def getDeleteBlocksXpath = {
		return this.DeleteBlocksXpath
	}

	@Keyword
	WebElement getDeleteBlocks(){
		return brandcast.getChildElementByXpath(this.getSortWrapper(), this.getDeleteBlocksXpath.call())
	}

	@Keyword
	def clickDeleteBlock(){
		brandcast.clickChildWebElement(this.getSortWrapper(), this.getDeleteBlocksXpath.call())
	}

	/**
	 * 
	 * Import BLocks
	 * 
	 */
	/*Import  Block Container*/
	private String ImportBlockContainerXpath = '//div[contains(@data-overlay-id,"importblockscontainer") and contains(@class,"bc-modal")]/div[contains(@class,"bc-modal-wrapper add-to-wrapper")]'

	def getImportBlockContainerXpath = {
		return this.ImportBlockContainerXpath
	}

	@Keyword
	WebElement getImportBlockContainer(){
		return brandcast.getChildElementByXpath(this.getImportBlocks(), this.getImportBlockContainerXpath.call())
	}

	@Keyword
	def clickImportBlockContainer(){
		brandcast.clickChildWebElement(this.getImportBlocks(), this.getImportBlockContainerXpath.call())
	}

	@Keyword
	def waitForImportBlockContainer(){
		brandcast.waitUntilPresenceOfNestedElementLocatedBy(this.getImportBlocks(), this.getImportBlockContainerXpath.call())
	}

	/*Import Block Container Header*/
	private String ImportBlockHeaderContainerXpath = '//div[contains(@class,"fl-box a header-container")]'

	def getImportBlockHeaderContainerXpath = {
		return this.ImportBlockHeaderContainerXpath
	}

	@Keyword
	WebElement getImportBlockHeaderContainer(){
		return brandcast.getChildElementByXpath(this.getImportBlockContainer(), this.getImportBlockHeaderContainerXpath.call())
	}


	/*Import  Block Container Header Title*/
	private String ImportHeaderTitleXpath = '//h2[contains(@class,"module-title")]'
	def getImportHeaderTitleXpath = {
		return this.ImportHeaderTitleXpath
	}

	@Keyword
	WebElement getImportHeaderTitle(){
		return brandcast.getChildElementByXpath(this.getImportBlockHeaderContainer(), this.getImportHeaderTitleXpath.call())
	}

	@Keyword
	def clickImportHeaderTitle(){
		brandcast.clickChildWebElement(this.getImportBlockHeaderContainer(), this.getImportHeaderTitleXpath.call())
	}


	/*Import  Block Container Header Description*/
	private String  ImportHeaderDescriptionXpath = '//p[contains(@class,"module-description")]'

	def getImportHeaderDescriptionXpath = {
		return this.ImportHeaderDescriptionXpath
	}

	@Keyword
	WebElement getImportHeaderDescription(){
		return brandcast.getChildElementByXpath(this.getImportBlockHeaderContainer(), this.getImportHeaderDescriptionXpath.call())
	}

	@Keyword
	def clickImportHeaderDescription(){
		brandcast.clickChildWebElement(this.getImportBlockHeaderContainer(), this.getImportHeaderDescriptionXpath.call())
	}


	/*Close Import Block Container*/
	private String CloseImportBlockContainerXpath = './/div[contains(@class,"wa-close-container")]'

	def getCloseImportBlockContainerXpath = {
		return this.CloseImportBlockContainerXpath
	}

	@Keyword
	WebElement getCloseImportBlockContainer(){
		return brandcast.getChildElementByXpath(this.getImportBlockHeaderContainer(), this.getCloseImportBlockContainerXpath.call())
	}

	@Keyword
	def clickCloseImportBlockContainer(){
		brandcast.clickChildWebElement(this.getImportBlockHeaderContainer(), this.getCloseImportBlockContainerXpath.call())
	}

	@Keyword
	def waitForCloseImportBlockContainer(){
		brandcast.waitVisibilityOfWebElement(this.getCloseImportBlockContainer())
	}

	@Keyword
	def waitForinvisibleCloseImportBlockContainer(){
		brandcast.waitInvisibilityOfElementLocated(this.getCloseImportBlockContainerXpath.call())
	}

	/*Import Block Content */
	private String ImportBlockContentXpath = '//div[contains(@class,"fl-box b col-wrapper")]'

	def getImportBlockContentXpath = {
		return this.ImportBlockContentXpath
	}

	@Keyword
	WebElement getImportBlockContent(){
		return brandcast.getChildElementByXpath(this.getImportBlockContainer(), this.getImportBlockContentXpath.call())
	}

	@Keyword
	def clickImportBlockContent(){
		brandcast.clickChildWebElement(this.getImportBlockContainer(), this.getImportBlockContentXpath.call())
	}


	/*Import Block Panel Links */
	private String ImportBlockPanelLinksXpath = '//div[contains(@class,"fl-wrap")]/div[contains(@class,"fl-box aa tags")]/div[contains(@class,"scroll-box")]'

	def getImportBlockPanelLinksXpath = {
		return this.ImportBlockPanelLinksXpath
	}

	@Keyword
	WebElement getImportBlockPanelLinks(){
		return brandcast.getChildElementByXpath(this.getImportBlockContent(), this.getImportBlockPanelLinksXpath.call())
	}

	@Keyword
	def clickImportBlockPanelLinks(){
		brandcast.clickChildWebElement(this.getImportBlockContent(), this.getImportBlockPanelLinksXpath.call())
	}


	/*Import Block Link Veiw All */
	private String ImportBlockLinkVeiwAllXpath = '//div[contains(@class,"all-btn selected")]/div[contains(@class,"icon")]'

	def getImportBlockLinkVeiwAllXpath = {
		return this.ImportBlockLinkVeiwAllXpath
	}

	@Keyword
	WebElement getImportBlockLinkVeiwAll(){
		return brandcast.getChildElementByXpath(this.getImportBlockContent(), this.getImportBlockLinkVeiwAllXpath.call())
	}

	@Keyword
	def clickImportBlockLinkVeiwAll(){
		brandcast.clickChildWebElement(this.getImportBlockContent(), this.getImportBlockLinkVeiwAllXpath.call())
	}


	/*Import Block Filter List*/
	private String ImportBlockFilterListXpath = '//div[contains(@class,"tag-filter-list")]'

	def getImportBlockFilterListXpath = {
		return this.ImportBlockFilterListXpath
	}

	@Keyword
	WebElement getImportBlockFilterList(){
		return brandcast.getChildElementByXpath(this.getImportBlockContent(), this.getImportBlockFilterListXpath.call())
	}

	@Keyword
	def clickImportBlockFilterList(){
		brandcast.clickChildWebElement(this.getImportBlockContent(), this.getImportBlockFilterListXpath.call())
	}


	/*Import Block Filter Bad Boys*/
	private String ImportBlockFilterBadBoysXpath = '//div[contains(@class,"ui-wrapper btn-row-wrapper tag-search-filter-item is-empty")]/div[contains(@class,"btn-row")]/div[contains(@class,"btn-row-label")]/h4[contains(text(),"Bad Boys")]'

	def getImportBlockFilterBadBoysXpath = {
		return this.ImportBlockFilterBadBoysXpath
	}

	@Keyword
	WebElement getImportBlockFilterBadBoys(){
		return brandcast.getChildElementByXpath(this.getImportBlockFilterList(), this.getImportBlockFilterBadBoysXpath.call())
	}

	@Keyword
	def clickImportBlockFilterBadBoys(){
		brandcast.clickChildWebElement(this.getImportBlockFilterList(), this.getImportBlockFilterBadBoysXpath.call())
	}


	/*Import Block Filter Footers*/
	private String ImportBlockFilterFootersXpath = '//div[contains(@class,"ui-wrapper btn-row-wrapper tag-search-filter-item is-empty")]/div[contains(@class,"btn-row")]/div[contains(@class,"btn-row-label")]/h4[contains(text(),"Footers")]'

	def getImportBlockFilterFootersXpath = {
		return this.ImportBlockFilterFootersXpath
	}

	@Keyword
	WebElement getImportBlockFilterFootersXpath(){
		return brandcast.getChildElementByXpath(this.getImportBlockFilterList(), this.getImportBlockFilterFootersXpath.call())
	}

	@Keyword
	def clickImportBlockFilterFooters(){
		brandcast.clickChildWebElement(this.getImportBlockFilterList(), this.getImportBlockFilterFootersXpath.call())
	}


	/*Import Block Filter Headers*/
	private String ImportBlockFilterHeadersXpath = '//div[contains(@class,"ui-wrapper btn-row-wrapper tag-search-filter-item is-empty")]/div[contains(@class,"btn-row")]/div[contains(@class,"btn-row-label")]/h4[contains(text(),"Headers")]'

	def getImportBlockFilterHeadersXpath = {
		return this.ImportBlockFilterHeadersXpath
	}

	@Keyword
	WebElement getImportBlockFilterHeaders(){
		return brandcast.getChildElementByXpath(this.getImportBlockFilterList(), this.getImportBlockFilterHeadersXpath.call())
	}

	@Keyword
	def clickImportBlockFilterHeaders(){
		brandcast.clickChildWebElement(this.getImportBlockFilterList(), this.getImportBlockFilterHeadersXpath.call())
	}


	/*Import Block Filter Layouts*/
	private String ImportBlockFilterLayoutsXpath = '//div[contains(@class,"ui-wrapper btn-row-wrapper tag-search-filter-item is-empty")]/div[contains(@class,"btn-row")]/div[contains(@class,"btn-row-label")]/h4[contains(text(),"Layouts")]'

	def getImportBlockFilterLayoutsXpath = {
		return this.ImportBlockFilterLayoutsXpath
	}

	@Keyword
	WebElement getImportBlockFilterLayoutsXpath(){
		return brandcast.getChildElementByXpath(this.getImportBlockFilterList(), this.getImportBlockFilterLayoutsXpath.call())
	}

	@Keyword
	def clickImportBlockFilterLayoutsXpath(){
		brandcast.clickChildWebElement(this.getImportBlockFilterList(), this.getImportBlockFilterLayoutsXpath.call())
	}


	/*Import Block Filter Bad Boys*/
	private String ImportBlockFilterUncategorizedXpath = '//div[contains(@class,"ui-wrapper btn-row-wrapper tag-search-filter-item is-empty")]/div[contains(@class,"btn-row")]/div[contains(@class,"btn-row-label")]/h4[contains(text(),"Uncategorized")]'

	def getImportBlockFilterUncategorizedXpath = {
		return this.ImportBlockFilterUncategorizedXpath
	}

	@Keyword
	WebElement getImportBlockFilterUncategorized(){
		return brandcast.getChildElementByXpath(this.getImportBlockFilterList(), this.getImportBlockFilterUncategorizedXpath.call())
	}

	@Keyword
	def clickImportBlockFilterUncategorized(){
		brandcast.clickChildWebElement(this.getImportBlockFilterList(), this.getImportBlockFilterUncategorizedXpath.call())
	}


	/*Import Block Search Sort Bar*/
	private String ImportBlockSearchSortBarXpath ='//div[contains(@class,"fl-box bb")]/div[contains(@class,"fl-wrap-column")]/div[contains(@class,"fl-box cc")]'

	def getImportBlockSearchSortBarXpath = {
		return this.ImportBlockSearchSortBarXpath
	}

	@Keyword
	WebElement getImportBlockSearchSortBar(){
		return brandcast.getChildElementByXpath(this.getImportBlockContainer(), this.getImportBlockSearchSortBarXpath.call())
	}

	@Keyword
	def clickImportBlockSearchSortBar(){
		brandcast.clickChildWebElement(this.getImportBlockContainer(), this.getImportBlockSearchSortBarXpath.call())
	}

	/*Import Block Virtualized Grid*/
	private String ImportBlockVirtualizedGridXpath = '//div[contains(@class,"fl-box dd")]/div[contains(@class,"scroll-box")]/div[contains(@class,"grid-block")]/div[contains(@class,"virtualized-grid")]'

	def getImportBlockVirtualizedGridXpath = {
		return this.ImportBlockVirtualizedGridXpath
	}

	@Keyword
	WebElement getImportBlockVirtualizedGrid(){
		return brandcast.getChildElementByXpath(this.getImportBlockContainer(), this.getImportBlockVirtualizedGridXpath.call())
	}

	/*Import Block Virtualize Grid List*/
	private String ImportBlockVirtualizeGridListXpath ='.//div[@class="box"]'

	def getImportBlockVirtualizeGridListXpath = {return this.ImportBlockVirtualizeGridListXpath}

	@Keyword
	List<WebElement> getImportBlockVirtualizeGridList(){
		return brandcast.getChildElementListByXpath(this.getImportBlockContent(), this.getImportBlockVirtualizeGridListXpath.call())
	}

	/*Filters*/
	private List Filters = [
		"Footers",
		"Headers",
		"Layouts",
		"Uncategorized"
	]

	List getFilters() {
		return this.Filters
	}

	/*Get Random Import Block Details*/
	WebElement SelectedImportedBlock = null

	@Keyword
	WebElement getSelectedImportedBlock() {
		return this.SelectedImportedBlock
	}

	def setSelectedImportedBlock(WebElement element) {
		this.SelectedImportedBlock = element
	}

	private String SelectedImportedBlockTitle = null

	String getSelectedImportedBlockTitle() {
		return this.SelectedImportedBlockTitle
	}

	def setSelectedImportedBlockTitle(String newTitle) {
		this.SelectedImportedBlockTitle = newTitle
	}

	@Keyword
	String selectRandomImportBlockTitle(List<WebElement> elementList){
		String boxDetailTitle = null

		1.times {
			//No list items greater than 4
			Integer collectionMaxRange = 0
			if (this.getImportBlockVirtualizeGridList().size() > 4) {
				collectionMaxRange = 3
			}else{
				collectionMaxRange = elementList.size()
			}

			Integer pick = utils.getRandomNumber(0, collectionMaxRange)
			WebElement listElement = this.getImportBlockVirtualizeGridList().get(pick)
			WebElement boxDetails = listElement.findElement(By.xpath('.//div[@class="box-details"]/div[@class="box-wrapper"]/div[@class="title-date"]'))
			boxDetailTitle = boxDetails.findElement(By.xpath('.//h4')).getText()
			WebElement boxDetailCheckbox = boxDetails.findElement(By.xpath('.//div[@class="item-selector"]/div[@class="check-box-container fl-box aa"]/div[@class="check-box"]'))
			assert boxDetailCheckbox.getAttribute("class") == "check-box"
			Point location = listElement.getLocation()
			brandcast.executeJSScroll(location.x,location.y)
			brandcast.moveToElementByWebElement(listElement)
			boxDetailCheckbox.click()
		}

		this.setSelectedImportedBlockTitle(boxDetailTitle)
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

	@Keyword
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
	private String ImportMyBlockCollectionXpath = '//div[@class="box" and @data-drag-is-selected="false" and @data-drag-type="ContentSnippet" and @data-drop-effect="copy"]'

	String getImportMyBlockCollectionXpath(){
		return this.ImportMyBlockCollectionXpath
	}

	List<WebElement> getImportMyBlockCollection(){
		return brandcast.getChildElementListByXpath(this.getAdminContainer(), this.getImportMyBlockCollectionXpath())
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

	@Keyword
	def verifyTagInList(List<WebElement> elementList, String addedTagName) {
		for(Integer i=0; i<elementList.size(); i++){
			println i
			WebElement tagListItem = elementList.get(i)
			WebElement TagCheckmark = tagListItem.findElement(By.xpath('.//div[@class="tag-lockup"]/div[@class="tag-checkmark"]'))
			WebElement TagLabel = tagListItem.findElement(By.xpath('.//div[@class="tag-lockup"]/div[@class="tag-title"]/p[@class="tag-label"]'))
			println TagLabel.getText()
			println addedTagName

			if(TagLabel.getText() == addedTagName) {
				println "newTagName: "+addedTagName
				return true
			}
		}
		return false
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

	@Keyword
	Boolean verifyImportedBlockStatus = false

	def verifyImportedBlockFromCollection(List<WebElement> element, String importedBlockTitle) {
		element.find{
			//Get Box Details
			WebElement BoxDetails = it.findElement(By.xpath('.//div[@class="box-details"]/div[@class="box-wrapper"]'))
			//Get Grid Item Title Date
			WebElement GridItemTitleDate = BoxDetails.findElement(By.xpath('.//div[@class="title-date-wrap"]/div[@class="title-date blocks"]'))
			WebElement GridItemTitle = GridItemTitleDate.findElement(By.xpath('.//div[@class="default-name-wrap"]/div[@class="swap-container clearfix fl-box aa"]/h5[@class="text-swap"]'))
			WebElement GridItemTime = GridItemTitleDate.findElement(By.xpath('//div[@class="fl-box bb"]/p[@class="date"]/time'))

			//Verify Imported Block Title with Grid Item Title
			if(importedBlockTitle == GridItemTitle.getText()) {
				println "Found Selected Item Title: "+GridItemTitle.getText()
				KeywordUtil.markPassed(GridItemTitle.getText()+" Block was imported")
				verifyImportedBlockStatus = true
				return true
			}


		}
	}

	/*GridItemBlockMenu*/
	private String GridItemBlockMenuXpath = './/div[@class="box-thumbnail-wrapper"]/div[@class="box-thumbnail"]/div[@class="box-action-ui"]/div[@class="bc-menu-group website-menu cs-permission-hide light-theme"]/div[@class="menu-item" and @data-identifier="block-menu"]/div[@title="Block Menu" and @class="btn-blank bullet-btn"]'

	String getGridItemBlockMenuXpath() {
		return this.GridItemBlockMenuXpath
	}

	private String MenuOptionAddRemoveTagslabel = $/Add / Remove Tags/$
	String getMenuOptionAddRemoveTagslabel() {
		return this.MenuOptionAddRemoveTagslabel
	}

	private String MenuOptionMakeDefaultBlocklabel = 'Make Default Block'
	String getMenuOptionMakeDefaultBlocklabel() {
		return this.MenuOptionMakeDefaultBlocklabel
	}

	private String MenuOptionDeleteBlocklabel = 'Delete Block'
	String getMenuOptionDeleteBlocklabel() {
		return this.MenuOptionDeleteBlocklabel
	}

	def clickBlockContextMenuOptionByName(List<WebElement> elementList, String menuOption) {
		KeywordUtil.logInfo("elementList size"+elementList.size())

		//No list items greater than 4
		Integer collectionMaxRange = 0
		if (elementList.size() >= 4) {
			collectionMaxRange = 3
		}else{
			collectionMaxRange = elementList.size()
		}

		Integer pick = utils.getRandomNumber(0,collectionMaxRange)
		KeywordUtil.logInfo("elementList pick: "+pick)
		WebElement listElement = elementList.get(pick)
		brandcast.moveToElementByWebElement(listElement)

		WebElement ContextMenuIcon = listElement.findElement(By.xpath('.//div[@class="box-thumbnail-wrapper"]/div[@class="box-thumbnail"]/div[@class="box-action-ui"]/div[@class="bc-menu-group website-menu cs-permission-hide light-theme"]/div[@class="menu-item" and @data-identifier="block-menu"]/div[@title="Block Menu" and @class="btn-blank bullet-btn"]/span[@class="bullet a"]'))
		brandcast.waitVisibilityOfWebElement(ContextMenuIcon)
		ContextMenuIcon.click()
		WebUI.delay(5)
		WebElement ContextMenuOption = listElement.findElement(By.xpath('.//div[@class="box-thumbnail-wrapper"]/div[@class="box-thumbnail"]/div[@class="box-action-ui"]/div[contains(@class,"bc-menu-group website-menu cs-permission-hide light-theme active")]/div[contains(@class,"menu-item has-layout") and contains(@data-identifier,"block-menu")]/div[@class="menu-dropdown"]'))
		if(ContextMenuOption.isDisplayed() && ContextMenuOption.isEnabled()) {
			List<WebElement> ContextMenuOptionList = ContextMenuOption.findElements(By.xpath('.//div[contains(@class,"ui-wrapper") and contains(@class,"btn-row-wrapper")]'))
			assert !ContextMenuOptionList.isEmpty()

			ContextMenuOptionList.find{
				if(menuOption == it.getText()){
					Point location = it.getLocation()
					brandcast.executeJSScroll(location.x,location.y)
					brandcast.moveToElementByWebElement(it)
					it.click()
					return true
				}
			}
		}
	}

	private String DeleteConfirmationContainerXpath = './/div[contains(@data-overlay-id,"deletedesignsnippetsconfirmationcontainer") and contains(@class,"bc-modal")]/div[contains(@class,"bc-modal-wrapper")]/div[contains(@class,"container-clear modal-system")]'

	@Keyword
	String getDeleteConfirmationContainerXpath(){
		return this.DeleteConfirmationContainerXpath
	}

	/*
	 * Confirmation Modal
	 * 
	 */
	@Keyword
	WebElement getconfirmDeleteModal(){
		return brandcast.getElementByXpath(this.getDeleteConfirmationContainerXpath())
	}

	//CloseDeleteConfirmation Modal
	private String CloseDeleteConfirmationModalXpath = './/div[contains(@class,"close-container")]/div[contains(@class,"close")]'

	@Keyword
	String getCloseDeleteConfirmationModalXpath(){return this.CloseDeleteConfirmationModalXpath}

	@Keyword
	WebElement getCloseDeleteConfirmationModal(){
		return brandcast.getChildElementByXpath(this.getconfirmDeleteModal(), this.getCloseDeleteConfirmationModalXpath())
	}

	//Delete Confirmation Content
	private String DeleteConfirmationContentXpath = './/div[contains(@class,"modal-content")]'

	@Keyword
	String getDeleteConfirmationContentXpath(){return this.DeleteConfirmationContentXpath}

	@Keyword
	WebElement getDeleteConfirmationContent(){
		return brandcast.getChildElementByXpath(this.getconfirmDeleteModal(), this.getDeleteConfirmationContentXpath())

	}

	//Delete Confirmation Cancel Button
	private String DeleteConfirmationCancelBtnXpath = './/div[@class="container-clear modal-btns"]/div[@class="ui-wrapper editor-style"]/button[@class="btn-html" and @type="button"]'

	@Keyword
	String getDeleteConfirmationCancelBtnXpath(){return DeleteConfirmationCancelBtnXpath}

	@Keyword
	WebElement getDeleteConfirmationCancelBtn(){
		return brandcast.getChildElementByXpath(this.getconfirmDeleteModal(), this.getDeleteConfirmationCancelBtnXpath())
	}

	@Keyword
	def clickDeleteConfirmationCancelBtn(){
		brandcast.clickChildWebElement(this.getconfirmDeleteModal(), this.getDeleteConfirmationCancelBtnXpath())
	}

	//Delete Confirmation Delete Button
	private String DeleteConfirmationDeleteBtnXpath = './/div[@class="container-clear modal-btns"]/div[@class="ui-wrapper editor-style primary"]/button[@class="btn-html" and @type="button"]'

	@Keyword
	String getDeleteConfirmationDeleteBtnXpath(){return this.DeleteConfirmationDeleteBtnXpath}

	@Keyword
	WebElement getDeleteConfirmationDeleteBtn(){
		return brandcast.getChildElementByXpath(this.getconfirmDeleteModal(), this.getDeleteConfirmationDeleteBtnXpath())
	}

	@Keyword
	def clickDeleteConfirmationDeleteBtn(){
		this.getDeleteConfirmationDeleteBtn().click()
	}

	//Add Remove Tags Window Area
	private String AddRemoveTagsWindowAreaXpath = '//div[contains(@class,"window-area add-remove-tags-window-area bd-filter react-draggable") and contains(@data-tutorial-id,"AddRemoveTagsContainer") and contains(@data-overlay-id,"addremovetagscontainer")]/div[contains(@class,"window-area-wrapper")]/div[contains(@class,"react-resizable")]/div[contains(@class,"edit-snippet-container")]'

	String getAddRemoveTagsWindowAreaXpath(){
		return this.AddRemoveTagsWindowAreaXpath
	}

	WebElement getAddRemoveTagsWindowArea(){
		return brandcast.getElementByXpath(this.getAddRemoveTagsWindowAreaXpath())
	}

	//Add Remove Tags List Xpath
	private String AddRemoveTagsListXpath = './/div[@class="tag-list fl-box c"]/div[@class="tag-selection-wrapper"]'

	String getAddRemoveTagsListXpath(){
		return this.AddRemoveTagsListXpath
	}

	@Keyword
	List<WebElement> getAddRemoveTagsList(){
		return brandcast.getChildElementListByXpath(this.getAddRemoveTagsWindowArea(), this.getAddRemoveTagsListXpath())
	}

	//Close Add - Remove Tags Window Area
	private String CloseAddRemoveTagsWindowAreaXpath = './/div[@class="wa-close-container"]'

	String getCloseAddRemoveTagsWindowAreaXpath(){
		return this.CloseAddRemoveTagsWindowAreaXpath
	}
	@Keyword
	WebElement getCloseAddRemoveTagsWindowArea(){
		return brandcast.getChildElementByXpath(this.getAddRemoveTagsWindowArea(), this.getCloseAddRemoveTagsWindowAreaXpath())
	}

	@Keyword
	def clickCloseAddRemoveTagsWindowArea(){
		brandcast.executeJavascriptClickElement(this.getCloseAddRemoveTagsWindowArea())
	}

	//Tags Add Remove Heading Container
	private String TagsAddRemoveHeadingContainerXpath = '//div[contains(@class,"heading-container fl-box a no-padding no-border")]/div[contains(@class,"heading-fl-wrap")]'

	String getTagsAddRemoveHeadingContainerXpath(){
		return this.TagsAddRemoveHeadingContainer
	}

	WebElement getTagsAddRemoveHeadingContainer(){
		return brandcast.getChildElementByXpath(this.getAddRemoveTagsWindowArea(), this.getTagsAddRemoveHeadingContainerXpath())
	}

	//Tags Heading Container
	private String TagsHeadingContainerXpath = './/div[@class="heading-container fl-box a no-padding no-border"]/div[@class="heading-fl-wrap"]'

	String getTagsHeadingContainerXpath(){
		return this.TagsHeadingContainerXpath
	}

	@Keyword
	WebElement getTagsHeadingContainer(){
		return brandcast.getChildElementByXpath(this.getAddRemoveTagsWindowArea(), this.getTagsHeadingContainerXpath())
	}

	//TagsEditTagsBtn
	private String TagsEditTagsBtnXpath = './/div[@class="ui-wrapper module-btn edit-tags-heading cs-permission-disable"]'//div[@class="heading-fl-box"]'

	String getTagsEditTagsBtnXpath(){
		return this.TagsEditTagsBtnXpath
	}

	@Keyword
	WebElement getTagsEditTagsBtn(){
		return brandcast.getChildElementByXpath(this.getTagsHeadingContainer(), this.getTagsEditTagsBtnXpath())
	}

	@Keyword
	def clickTagsEditTagsBtn(){
		this.getTagsEditTagsBtn().click()
	}

	//TagManagerContainer
	private String TagManagerContainerXpath = './/div[@class="window-area add-remove-tags-window-area bd-filter react-draggable" and @data-tutorial-id="TagManagerContainer" and @data-overlay-id="tagmanagercontainer"]'

	String getTagManagerContainerXpath(){
		return this.TagManagerContainerXpath
	}

	@Keyword
	WebElement getTagManagerContainer(){
		return brandcast.getElementByXpath(this.getTagManagerContainerXpath())
	}

	//Edit Snippet Container
	private String EditSnippetContainerXpath = './/div[@class="window-area-wrapper"]/div[@class="react-resizable"]/div[@class="edit-snippet-container"]'

	String getEditSnippetContainerXpath(){
		return this.EditSnippetContainerXpath
	}

	@Keyword
	WebElement getEditSnippetContainer(){
		return brandcast.getChildElementByXpath(this.getTagManagerContainer(), this.getEditSnippetContainerXpath())
	}


	//Close Edit Snippet Containers
	private String CloseEditSnippetContainersXpath = './/div[@class="wa-close-container"]'

	String getCloseEditSnippetContainersXpath(){
		return this.CloseEditSnippetContainersXpath
	}

	@Keyword
	WebElement getCloseEditSnippetContainers(){
		return brandcast.getChildElementByXpath(this.getEditSnippetContainer(), this.getCloseEditSnippetContainersXpath())
	}


	// Edit Snippet Name Container
	private String EditSnippetNameContainerXpath = './/div[@class="name-container fl-box b"]'

	String getEditSnippetNameContainerXpath(){
		return this.EditSnippetNameContainerXpath
	}

	@Keyword
	WebElement getEditSnippetNameContainer(){
		return brandcast.getChildElementByXpath(this.getTagManagerContainer(), this.getEditSnippetNameContainerXpath())
	}

	//Edit Snippet Form
	private String EditSnippetFormXpath = './/div[@class="name-container fl-box b"]/form/div[@class="ui-wrapper full-width fl-wrap aa size-B white-theme" and @title="Add Tag"]'

	String getEditSnippetFormXpath(){
		return this.EditSnippetFormXpath
	}

	@Keyword
	WebElement getEditSnippetForm(){
		return brandcast.getChildElementByXpath(this.getTagManagerContainer(), this.getEditSnippetFormXpath())
	}

	//Edit Snippet Form Text Input Container
	private String EditSnippetFormTextInputContainerXpath = './/div[@class="text-input-container"]/label/div[@class="text-input-wrapper"]'

	String getEditSnippetFormTextInputContainerXpath(){
		return this.EditSnippetFormTextInputContainerXpath
	}

	@Keyword
	WebElement getEditSnippetFormTextInputContainer(){
		return brandcast.getChildElementByXpath(this.getEditSnippetForm(), this.getEditSnippetFormTextInputContainerXpath())
	}

	//Edit Snippet Form Text Input
	private String EditSnippetFormTextInputXpath = './/input[@name="tagName" and @type="text" and @class="text-input" and @placeholder="Enter a new tag name here and click add"]'

	String getEditSnippetFormTextInputXpath(){
		return this.EditSnippetFormTextInputXpath
	}

	@Keyword
	WebElement getEditSnippetFormTextInput(){
		return brandcast.getChildElementByXpath(this.getEditSnippetForm(), this.getEditSnippetFormTextInputXpath())
	}

	@Keyword
	def sendTagToEditSnippetFormTextInput(){
		String tagName = "tagName-"+utils.getDateSerial()
		brandcast.sendInput(this.getEditSnippetFormTextInput(), tagName)
	}

	//Edit Snippet Form
	private String EditSnippetFormAddTagBtnXpath = './/div[@class="name-container fl-box b"]/form/div[@class="ui-wrapper editor-style fl-wrap bb added-btn primary"]/button[@class="btn-html" and @type="submit"]'

	String getEditSnippetFormAddTagBtnXpath(){
		return this.EditSnippetFormAddTagBtnXpath
	}

	@Keyword
	WebElement getEditSnippetFormAddTagBtn(){
		return brandcast.getChildElementByXpath(this.getTagManagerContainer(), this.getEditSnippetFormAddTagBtnXpath())
	}

	@Keyword
	def clickEditSnippetFormAddTagBtn(){
		brandcast.executeJavascriptClickElement(this.getEditSnippetFormAddTagBtn())
	}

	//EditSnippetTagList
	private String EditSnippetTagListContainerXpath = './/div[@class="tag-list edit-tag-list fl-box c"]'

	String getEditSnippetTagListContainerXpath(){
		return this.EditSnippetTagListContainerXpath
	}

	//Get Edit Snippet Tag List Container
	@Keyword
	WebElement getEditSnippetTagListContainer() {
		return brandcast.getChildElementByXpath(this.getTagManagerContainer(), this.getEditSnippetTagListContainerXpath())
	}

	//Edit Snippet Tag List
	private String EditSnippetTagListXpath = './/div[@class="tag-selection-wrapper"]'

	String getEditSnippetTagListXpath(){
		return this.EditSnippetTagListXpath
	}

	List<WebElement> getEditSnippetTagList(){
		return brandcast.getChildElementListByXpath(this.getEditSnippetTagListContainer(), this.getEditSnippetTagListXpath())
	}

	//Tag Title Input
	private String TagTitleInputXpath = './/div[@class="tag-lockup"]/div[@class="tag-title"]/div[@class="swap-container clearfix"]'//input[@class="input-swap" and @draggable="true" and @title="Design Snippets" and @type="text"]'

	String getTagTitleInputXpath(){
		return this.TagTitleInputXpath
	}

	@Keyword
	WebElement getTagTitleInput(WebElement element){
		return brandcast.getChildElementByXpath(element, this.getTagTitleInputXpath())
	}

	//Tag Title H5
	private String TagTitleH5Xpath = './/div[@class="tag-lockup"]/div[@class="tag-title"]/div[@class="swap-container clearfix"]/h5'

	String getTagTitleH5Xpath(){
		return this.TagTitleH5Xpath
	}

	@Keyword
	WebElement getTagTitleH5(WebElement element){
		return brandcast.getChildElementByXpath(element, this.getTagTitleH5Xpath())
	}

	//Tag Updated Title getter and setter
	String getUpdatedTagTitle(String tagName){
		return tagName+"-"+utils.timeStamp
	}

	//TagUpdatedTitle
	private String TagUpdatedTitle = null

	@Keyword
	String setTagUpdatedTitle(String tagTitle) {
		this.TagUpdatedTitle = tagTitle
	}

	@Keyword
	String getTagUpdatedTitle() {
		return this.TagUpdatedTitle
	}

	//Tag Rename Icon
	private String TagRenameIconXpath = './/div[@class="tag-rename"]'

	String getTagRenameIconXpath(){
		return this.TagRenameIconXpath
	}

	@Keyword
	WebElement getTagRenameIcon(WebElement element){
		return brandcast.getChildElementByXpath(element, this.getTagRenameIconXpath())
	}

	@Keyword
	def sendTagRenameIcon(WebElement element){
		element.sendKeys(utils.timeStampName)
	}

	@Keyword
	def sendTagRenameIconEnter(WebElement element){
		element.sendKeys(Keys.RETURN)
	}

	@Keyword
	def clickTagRenameIconByOffset(WebElement element){
		brandcast.clickWebElementByOffSet(element, 0, -4)
	}

	//Tag Delete Icon
	private String TagDeleteIconXpath = './/div[@class="tag-delete"]'

	String getTagDeleteIconXpath(){
		return this.TagDeleteIconXpath
	}

	@Keyword
	WebElement getTagDeleteIcon(WebElement element){
		return brandcast.getChildElementByXpath(element, this.getTagDeleteIconXpath())
	}
	@Keyword
	def clickTagIcon(WebElement element){
		brandcast.executeJavascriptClickElement(element)
	}

	//Delete Tag Confirmation Container
	private String DeleteTagConfirmationContainerXpath = '//div[@data-overlay-id="deletetagconfirmationcontainer" and @class="bc-modal"]/div[@class="bc-modal-wrapper"]/div[@class="container-clear modal-system"]'

	String getDeleteTagConfirmationContainerXpath(){
		return this.DeleteTagConfirmationContainerXpath
	}

	WebElement getDeleteTagConfirmationContainer(){
		return brandcast.getElementByXpath(this.getDeleteTagConfirmationContainerXpath())
	}


	//Delete Tag Close Container
	private String DeleteTagCloseContainerXpath = './/div[@class="close-container"]/div[@class="close"]'

	String getDeleteTagCloseContainerXpath(){
		return this.DeleteTagCloseContainerXpath
	}

	WebElement getDeleteTagCloseContainer(){
		return brandcast.getChildElementByXpath(this.getDeleteTagConfirmationContainer(), this.getDeleteTagCloseContainerXpath())
	}


	//Delete Tag Modal Content
	String DeleteTagModalContentXpath = './/div[@class="modal-content"]'

	String getDeleteTagModalContentXpath(){
		return this.DeleteTagModalContentXpath
	}

	WebElement getDeleteTagModalContent(){
		return brandcast.getChildElementByXpath(this.getDeleteTagConfirmationContainer(), this.getDeleteTagModalContentXpath())
	}


	//Delete Tag Modal Content Buttons
	String DeleteTagModalContentBtnXpath = './/div[@class="container-clear modal-btns"]'

	String getDeleteTagModalContentBtnXpath(){
		return this.DeleteTagModalContentBtnXpath
	}

	WebElement getDeleteTagModalContentBtn(){
		return brandcast.getChildElementByXpath(this.getDeleteTagConfirmationContainer(), this.getDeleteTagModalContentBtnXpath())
	}


	//Delete Tag Modal Content Delete Buttons
	String DeleteTagDeleteBtnXpath = './/div[@class="ui-wrapper editor-style primary"]/button[@class="btn-html" and @type="button" and @data-qa-id="delete-website-button"]'

	String getDeleteTagDeleteBtnXpath(){
		return this.DeleteTagDeleteBtnXpath
	}

	@Keyword
	WebElement getDeleteTagDeleteBtn(){
		return brandcast.getChildElementByXpath(this.getDeleteTagConfirmationContainer(), this.getDeleteTagDeleteBtnXpath())
	}

	@Keyword
	def clickDeleteTagDeleteBtn(){
		brandcast.executeJavascriptClickElement(this.getDeleteTagDeleteBtn())
	}

	//Delete Tag Modal Content Cancel Buttons
	String DeleteTagCancelBtnXpath = './/div[@class="container-clear modal-btns"]/button[@class="btn-html" and @type="button" and @data-qa-id="cancel-button"]'

	String getDeleteTagCancelBtnXpath(){
		return this.DeleteTagCancelBtnXpath
	}

	@Keyword
	WebElement getDeleteTagCancelBtn(){
		return brandcast.getChildElementByXpath(this.getDeleteTagConfirmationContainer(), this.getDeleteTagCancelBtnXpath())
	}

	@Keyword
	def clickDeleteTagCancelBtn(){
		brandcast.executeJavascriptClickElement(this.getDeleteTagCancelBtn())
	}

}