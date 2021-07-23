package com.brandcast

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
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.JavascriptException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.NotFoundException
import org.openqa.selenium.NoSuchWindowException
import org.openqa.selenium.NoSuchFrameException
import org.openqa.selenium.NoAlertPresentException
import org.openqa.selenium.Point
import org.openqa.selenium.InvalidSelectorException
import org.openqa.selenium.ElementNotVisibleException
import org.openqa.selenium.ElementNotSelectableException
import org.openqa.selenium.TimeoutException
import org.openqa.selenium.NoSuchSessionException
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.support.ui.WebDriverWait


/*Custom Keyword*/
import com.brandcast.Utils


public class Core {

	/*Utils*/
	Utils utils = new Utils()

	/*Get the active webdriver for native Selenium*/
	private WebDriver driver = DriverFactory.getWebDriver()

	/*Initialize Wait Object*/
	private WebDriverWait wait = new WebDriverWait(driver,30)

	/*Declare Selenium Actions*/
	private Actions action = new Actions(driver)


	private String GoogleTagTestTag = $/<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start': new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0], j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src= 'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f); })(window,document,'script','dataLayer','GTM-NM5VW6');</script>/$

	String getGoogleTagTestTag(){
		return this.GoogleTagTestTag
	}


	/**
	 * Get Web Element x,y
	 * @param WebElement 
	 */
	@Keyword
	List getElementLocation(WebElement element){
		Point location = element.getLocation();
		int x = location.getX()
		int y = location.getY()
		def coordinates =  [x, y]
		return coordinates
	}


	/**
	 * Click Web Element By Element Xpath
	 * @param String elementXpath
	 */
	@Keyword
	def clickWebElement(WebElement element){
		if(element.isDisplayed()){
			this.action.moveToElement(element).click().release().build().perform() //.moveByOffset( 10, 25 );
			KeywordUtil.markPassed("Successfully Clicked Web Element")
		}else{
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element Could Not Be Click")
		}
	}

	/**
	 * Click Web Element By OffSet
	 * @param String elementXpath
	 */
	@Keyword
	def clickWebElementByOffSet(WebElement element,Integer xOffSet, Integer yOffSet){
		if(element.isDisplayed()){
			this.action.moveToElement(element).click().moveByOffset( xOffSet, yOffSet ).release().build().perform()
			KeywordUtil.markPassed("Successfully Clicked Web Element")
		}else{
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element Could Not Be Click")
		}
	}

	/**
	 * Click and Hold Web Element By Element Xpath
	 * @param String elementXpath
	 */
	@Keyword
	def clickAndHoldWebElememnt(WebElement element){
		if(element.isDisplayed()){
			this.action.moveToElement(element).clickAndHold().moveByOffset(0,100).build().perform()
			this.action.release(element).build().perform()
			KeywordUtil.markPassed("Successfully Click and Hold Web Element")
		}else{
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element Could Not Be Clicked and Held")
		}
	}


	/**
	 * Click Child Web Element By Element Xpath
	 * @param String elementXpath
	 */
	@Keyword
	def clickChildWebElement(WebElement parentWebElement, String elementXpath) {
		try{
			WebElement webElement = parentWebElement.findElement(By.xpath(elementXpath))
			if(webElement.isDisplayed()){
				KeywordUtil.logInfo("Verified: New Web Element is Displayed: "+webElement.isDisplayed())
				this.action.moveToElement(webElement).click().build().perform()
				KeywordUtil.markPassed("Successfully Clicked Web Element")
			}else{
				WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
				KeywordUtil.markFailedAndStop("Web Element Could Not Be Click")
			}
		}catch(NotFoundException e){
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element Could Found")
		}
	}

	/**
	 * Click and Hold Web Element By Element Xpath
	 * @param String elementXpath
	 */
	@Keyword
	def doubleClickWebElememnt(WebElement element){
		if(element.isDisplayed()){
			this.action.moveToElement(element).doubleClick().build().perform()
			KeywordUtil.markPassed("Successfully Double Click Web Element")
		}else{
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element Could Not Double Click Web Element")
		}
	}

	/**
	 * Execute Javascript On Element
	 * @param WebElement element
	 * @param String elementjavascript
	 * 
	 */
	@Keyword
	def executeJavascriptOnElement(WebElement element, String elementjavascript){
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor)driver).executeScript(elementjavascript, element)
		} else {
			throw new IllegalStateException("This driver does not support JavaScript!");
		}
	}

	/**
	 * Execute Javascript On Element
	 * @param WebElement element
	 * @param String elementjavascript
	 *
	 */
	@Keyword
	def executeJavascriptSetAttribute(WebElement element, String attName, String attValue){
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attName, attValue)
		} else {
			throw new IllegalStateException("This driver does not support JavaScript!");
		}
	}

	//Creating a custom function
	def executeJavascriptHighLight(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
	}
	/**
	 * Execute Javascript Click On Element
	 * @param WebElement element
	 * @param String elementjavascript
	 *
	 */
	@Keyword
	def executeJavascriptClickElement(WebElement element){
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element)
		} else {
			throw new IllegalStateException("This driver does not support JavaScript!");
		}
	}

	@Keyword
	def executeJSScroll(Integer h, Integer v){
		JavascriptExecutor js = (JavascriptExecutor) driver
		js.executeScript("scroll("+h+","+v+")")
	}

	@Keyword
	def executeJSCSSQuery(String jsScript){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(jsScript)
	}

	private String jsScript = "var input = document.getElementsByTagName('input')[0];"

	@Keyword
	String getjsScript(){
		return this.jsScript
	}

	@Keyword
	String getUploadFilePathAsJS(String filepath){
		return "input.value='"+filepath+"';"
	}

	@Keyword
	def executeJSFileUpload(String jsscript,String filepath,WebElement uploadelement){
		String fp = jsscript+filepath
		JavascriptExecutor executor = (JavascriptExecutor) driver
		executor.executeScript(jsScript,uploadelement)
	}



	/**
	 * Get Element By Xpath
	 * @param String elementXpath
	 */
	@Keyword
	WebElement getElementByXpath(String elementXpath){
		try{
			WebElement webElement = driver.findElement(By.xpath(elementXpath))
			if(webElement.isDisplayed()){
				KeywordUtil.logInfo("Verified: New Web Element is Displayed: "+webElement.isDisplayed())
				KeywordUtil.markPassed("Successfully Located Web Element")
				return webElement
			}else{
				WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
				KeywordUtil.markFailedAndStop("Web Element is Not Displayed")
			}
		}catch(NotFoundException e){
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element not found")
		}
	}

	/**
	 * Get Element By Xpath
	 * @param String elementXpath
	 */
	@Keyword
	WebElement getInvisibleElementByXpath(String elementXpath){
		WebElement webElement = null
		try{
			webElement = driver.findElement(By.xpath(elementXpath))
		}catch(NotFoundException e){
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element not found")
		}
		KeywordUtil.markPassed("Successfully Located Web Element")
		return webElement
	}

	/**
	 * Get Element By TagName
	 * @param String elementTagName
	 */
	@Keyword
	WebElement getElementByTagName(String elementTagName){
		try{
			WebElement webElement = driver.findElement(By.tagName(elementTagName))
			if(webElement.isDisplayed()){
				KeywordUtil.logInfo("Verified: New Web Element is Displayed: "+webElement.isDisplayed())
				KeywordUtil.markPassed("Successfully Located Web Element")
				return webElement
			}else{
				WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
				KeywordUtil.markFailedAndStop("Web Element is Not Displayed")
			}
		}catch(NotFoundException e){
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element not found")
		}
	}

	/**
	 * Get Child Element By TagName
	 * @param String elementTagName
	 */
	@Keyword
	WebElement getChildElementByTagName(WebElement parentElement, String elementTagName){
		try{
			WebElement webElement = parentElement.findElement(By.tagName(elementTagName))
			if(webElement.isDisplayed()){
				KeywordUtil.logInfo("Verified: New Web Element is Displayed: "+webElement.isDisplayed())
				KeywordUtil.markPassed("Successfully Located Web Element")
				return webElement
			}else{
				WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
				KeywordUtil.markFailedAndStop("Web Element is Not Displayed")
			}
		}catch(NotFoundException e){
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element not found")
		}
	}
	/**
	 * Get Element By Parent WebElement and Child Xpath
	 * @param WebElement parentWebElement
	 * @param String elementXpath
	 */
	@Keyword
	WebElement getChildElementByXpath(WebElement parentWebElement, String elementXpath) {

		try{
			'Get the active webdriver for native Selenium'
			WebElement webElement = parentWebElement.findElement(By.xpath(elementXpath))
			if(webElement.isDisplayed()){
				KeywordUtil.logInfo("Verified: New Web Element is Displayed: "+webElement.isDisplayed())
				KeywordUtil.markPassed("Successfully Located Web Element")
				return webElement
			}else{
				WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
				KeywordUtil.markFailedAndStop("Web Element is Not Displayed")
			}
		}catch(NotFoundException e){
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element not found")
		}
	}

	/**
	 * Get Element By Class Name
	 * @param String elementClassName
	 */
	@Keyword
	WebElement getElementByClassName(String elementClassName) {
		try{
			WebElement webElement = driver.findElement(By.className(elementClassName))
			if(webElement.isDisplayed()){
				KeywordUtil.logInfo("Verified: New Web Element is Displayed: "+webElement.isDisplayed())
				KeywordUtil.markPassed("Successfully Located Web Element")
				return webElement
			}else{
				WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
				KeywordUtil.markFailedAndStop("Web Element is Not Displayed")
			}
		}catch(NotFoundException e){
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element not found")
		}
	}


	/**
	 * Get Element By Css Selector
	 * @param String elementXpath
	 */
	@Keyword
	WebElement getElementByCssSelector(String elementCssSelector) {
		try{
			WebElement webElement = driver.findElement(By.cssSelector(elementCssSelector))
			if(webElement.isDisplayed()){
				KeywordUtil.logInfo("Verified: New Web Element is Displayed: "+webElement.isDisplayed())
				KeywordUtil.markPassed("Successfully Located Web Element")
				return webElement
			}else{
				WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
				KeywordUtil.markFailedAndStop("Web Element is Not Displayed")
			}
		}catch(NotFoundException e){
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element not found")
		}
	}

	/**
	 * Get Element By ID Selector
	 * @param String elementXpath
	 */
	@Keyword
	WebElement getElementByIdSelector(String elementIdSelector) {
		try{
			WebElement webElement = driver.findElement(By.id(elementIdSelector))
			if(webElement.isDisplayed()){
				KeywordUtil.logInfo("Verified: New Web Element is Displayed: "+webElement.isDisplayed())
				KeywordUtil.markPassed("Successfully Located Web Element")
				return webElement
			}else{
				WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
				KeywordUtil.markFailedAndStop("Web Element is Not Displayed")
			}
		}catch(NotFoundException e){
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element not found")
		}
	}
	/**
	 * Get Element By Parent WebElement and Child Css Selector
	 * @param WebElement parentWebElement
	 * @param String elementXpath
	 */
	@Keyword
	WebElement getChildElementByCssSelector(WebElement parentWebElement, String elementCssSelector) {
		try{
			'Get the active webdriver for native Selenium'
			WebElement webElement = parentWebElement.findElement(By.cssSelector(elementCssSelector))
			if(webElement.isDisplayed()){
				KeywordUtil.logInfo("Verified: New Web Element is Displayed: "+webElement.isDisplayed())
				KeywordUtil.markPassed("Successfully Located Web Element")
				return webElement
			}else{
				WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
				KeywordUtil.markFailedAndStop("Web Element is Not Displayed")
			}
		}catch(NotFoundException e){
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element not found")
		}
	}

	/**
	 * 
	 * Get List of Frames
	 * 
	 */
	WebElement getFrames(){
		String elementListXpath = "//iframe"
		return driver.findElements(By.xpath(elementListXpath))
	}

	/**
	 * Click Child Web Element By Element Xpath
	 * @param List<WebElement>
	 * @return WebElement
	 */
	@Keyword
	WebElement getRandomListWebElement(List <WebElement> alist){
		Random rnd = new Random()
		Integer selectIndex = rnd.nextInt(alist.size())
		String selectedItem = alist[selectIndex]
		return alist[selectIndex]
	}

	/**
	 * Get Page Title
	 * @return String Title
	 */
	@Keyword
	def getPageTitle(){
		return driver.getTitle()
	}

	/**
	 * Get List of Elements By Xpath
	 * @param String elementXpath
	 */
	@Keyword
	List<WebElement> getElementListByXpath(String elementListXpath) {
		try{
			List<WebElement> elementList = driver.findElements(By.xpath(elementListXpath))
			if(!elementList.isEmpty()){
				KeywordUtil.logInfo("Verified: Web Elements: "+elementList.size())
				KeywordUtil.markPassed("Successfully Located Web Elements")
				return elementList
			}else{
				WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
				KeywordUtil.markFailedAndStop("Web Elements is Not Displayed")
			}
		}catch(NotFoundException e){
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element not found")
		}
	}

	/**
	 * Get List of Web Element By Element Xpath
	 * @param WebElement parentWebElement
	 * @param String elementXpath
	 */
	@Keyword
	List<WebElement> getChildElementListByXpath(WebElement parentWebElement, String elementXpath){
		try{
			List<WebElement> elementList = parentWebElement.findElements(By.xpath(elementXpath))
			if(!elementList.isEmpty()){
				KeywordUtil.logInfo("Verified: Web Elements: "+elementList.size())
				KeywordUtil.markPassed("Successfully Located Web Elements")
				return elementList
			}else{
				WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
				KeywordUtil.markFailedAndStop("Web Elements is Not Displayed")
			}
		}catch(NotFoundException e){
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Elements not found")
		}
	}

	/**
	 * Get New Tab Handle
	 */
	def getNewTabHandle(ArrayList<String> WindowTabs) {
		for(Integer i=0; i< WindowTabs.size(); i++){
			WebElement CurrentTab = WindowTabs.get(i)
			return CurrentTab
		}
	}

	/**
	 * Get WindowHandles
	 */
	ArrayList<String> getWindowHandles() {
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles())
		return tabs2
	}

	/**
	 * Get Number of WindowHandles
	 */
	@Keyword
	def getNumberOfWindowHandles() {
		this.getWindowHandles().size()
	}

	/**
	 * Switch to Parent Tab
	 */
	@Keyword
	def switchToParentTab(){
		ArrayList<String> tabs2 = this.getWindowHandles()
		driver.switchTo().window(tabs2.get(1))
		driver.close();
		driver.switchTo().window(tabs2.get(0))
	}




	/**
	 * Get WebElementFromList By Xpath
	 * @param WebElement parentWebElement
	 * @param String elementXpath
	 */
	@Keyword
	WebElement getWebElementFromListByXpath(List<WebElement> webelementlist, String elementxpath){
		for(WebElement webelement: webelementlist){
			if(ExpectedConditions.presenceOfNestedElementLocatedBy(webelement, By.xpath(elementxpath))){
				return webelement.findElement(By.xpath(elementxpath))
			}
		}
	}
	/**
	 * Get WebElementFromList By Xpath and Text
	 * @param WebElement parentWebElement
	 * @param String elementXpath
	 */
	@Keyword
	WebElement getWebElementFromListByXpathAndText(List<WebElement> webelementlist, String elementxpath, String elementtext){
		for(WebElement webelement: webelementlist){
			WebElement subelement = webelement.findElement(By.xpath(elementxpath))
			if(subelement.getText().contains(elementtext)){
				return subelement
			}
		}
	}

	/**
	 * Get WebElementFromList By Text
	 * @param WebElement parentWebElement
	 * @param String elementXpath
	 */
	WebElement getWebElementFromListByText(List<WebElement> webelementlist,String elementtext){
		for(WebElement webelement: webelementlist){
			if(webelement.getText().contains(elementtext)){
				return webelement
			}
		}
	}

	/**
	 * 
	 * Get WebElement By RegEx
	 * 
	 */
	WebElement getWebElementByRegEx(List<WebElement> webelementlist){
		for(WebElement element: webelementlist){
			if(element.getText().split("\\r?\\n")[0]=~/^\d{2}\-\d{2}\-\d{4}/){
				println(element.getText().split("\\r?\\n")[0])
				return
			}
		}
	}


	/**
	 * Move to Web Element By OffSet
	 * @param String elementXpath
	 */
	@Keyword
	def moveToElementByOffSet(WebElement fromElement, WebElement toElement, Integer xOffSet, Integer yOffSet){
		try{
			'Obtain Element Handle'
			Integer in_xOffSet = null
			Integer in_yOffSet = null

			switch(xOffSet) {
				case xOffSet > 0:
					in_xOffSet = xOffSet
					break;
				default:
					in_xOffSet = 0
					break;
			}

			switch(yOffSet) {
				case yOffSet > 0:
					in_yOffSet = yOffSet
					break;
				default:
					in_yOffSet = 0
					break;
			}

			this.action.clickAndHold(fromElement).moveToElement(toElement, in_xOffSet, in_yOffSet).perform()
			this.action.release(fromElement).build().perform()
			KeywordUtil.markPassed("Successfully Moved Web Element By OffSet!")
		}catch(Exception e){
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element Could Not Be Moved By OffSet!")
		}
	}


	/**
	 * Move to Web Element By Element Xpath
	 * @param String elementXpath
	 */
	@Keyword
	def moveToElement(String elementXpath){
		try{
			'Obtain Element Handle'
			WebElement webElement = driver.findElement(By.xpath(elementXpath))
			if(webElement.isDisplayed()){
				KeywordUtil.logInfo("Verified: New Web Element is Displayed: "+webElement.isDisplayed())
				this.action.moveToElement(webElement).build().perform()
				KeywordUtil.markPassed("Successfully Clicked Web Element")
			}else{
				WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
				KeywordUtil.markFailedAndStop("Web Element Could Not Be Click")
			}
		}catch(Exception e){
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element Could Found")
		}
	}

	/**
	 * Move to Web Element By Offset
	 * @param String elementXpath
	 */
	@Keyword
	def moveByOffsetAndClick(WebElement sourceElement, Integer x, Integer y){
		try{
			'Obtain Element Handle'
			if(sourceElement.isDisplayed()){

				KeywordUtil.logInfo("Verified: New Web Element is Displayed: "+sourceElement.isDisplayed())
				this.action.moveToElement(sourceElement).moveByOffset(x,y).click().build().perform()
				KeywordUtil.markPassed("Successfully Clicked Web Element")
			}else{
				WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
				KeywordUtil.markFailedAndStop("Web Element Could Not Be Click")
			}
		}catch(Exception e){
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element Could Found")
		}
	}

	/**
	 * Move to Web Element By WebElement
	 * @param String elementXpath
	 */
	@Keyword
	def moveToElementByWebElement(WebElement element){
		try{
			'Obtain Element Handle'
			if(element.isDisplayed()){
				KeywordUtil.logInfo("Verified: New Web Element is Displayed: "+element.isDisplayed())
				this.action.moveToElement(element).build().perform()
				KeywordUtil.markPassed("Successfully Clicked Web Element")
			}else{
				WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
				KeywordUtil.markFailedAndStop("Web Element Could Not Be Click")
			}
		}catch(Exception e){
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element Could Found")
		}
	}

	/**
	 * Move to Child Web Element By Element Xpath
	 * @param WebElement parentWebElementXpath,
	 * @param String elementXpath
	 */
	@Keyword
	def moveToChildElement(WebElement parentWebElementXpath, String elementXpath){
		try{
			WebElement webElement = parentWebElementXpath.findElement(By.xpath(elementXpath))
			if(webElement.isDisplayed()){
				KeywordUtil.logInfo("Verified: New Web Element is Displayed: "+webElement.isDisplayed())
				this.action.moveToElement(webElement).build().perform()
				KeywordUtil.markPassed("Successfully Clicked Web Element")
			}else{
				WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
				KeywordUtil.markFailedAndStop("Web Element Could Not Be Click")
			}
		}catch(Exception e){
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element Could Found")
		}
	}

	/*Move WebElement to WebElement*/

	@Keyword
	def moveWebElementToWebElement(WebElement parentWebElementXpath, WebElement childWebElement){
		this.action.moveToElement(childWebElement)//.build().perform()
		KeywordUtil.markPassed("Successfully Clicked Web Element")
	}


	/**
	 * 
	 **/
	def moveMouseByOffSet(Integer xOffSet, Integer yOffSet){
		'Obtain Element Handle'
		Integer in_xOffSet = null
		Integer in_yOffSet = null

		switch(xOffSet) {
			case xOffSet > 0:
				in_xOffSet = xOffSet
				break;
			default:
				in_xOffSet = 0
				break;
		}

		switch(yOffSet) {
			case yOffSet > 0:
				in_yOffSet = yOffSet
				break;
			default:
				in_yOffSet = 0
				break;
		}

		Robot robot = new Robot();
		robot.mouseMove(in_xOffSet,in_yOffSet+80)
	}

	def clickEscapeButton(){
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CANCEL)
	}

	/**
	 * Click List Item
	 * @param List<WebElement> elementlist
	 * @param String elementtext
	 */
	@Keyword
	def clickListItem(List<WebElement> elementlist, String elementtext){
		for(WebElement element: elementlist){
			if(element.getText().contains(elementtext)){
				element.click()
				break
			}
		}
	}

	/**
	 * Send input to Web Element 
	 * @param WebElement elementXpath
	 * @param String insertData
	 */
	@Keyword
	def sendInput(WebElement element, String insertData){
		try{
			element.clear()
			element.sendKeys(insertData)
			KeywordUtil.markPassed("Failed to Send Input")
		}catch(Exception e){
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailed("Failed: "+e)
		}
	}

	/**
	 * Send Key 
	 * @param WebElement elementXpath
	 * @param String Key
	 */
	@Keyword
	def sendKeys(WebElement element, Keys key){
		try{
			element.clear()
			this.action.moveToElement(element).sendKeys(key).build().perform()
			KeywordUtil.markPassed("Failed to Send Key")
		}catch(Exception e){
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailed("Failed: "+e)
		}
	}

	/**
	 * Send Usename String to the Useename Input for Signin
	 * @param usernameInputElement Katalon test object
	 * @param username String
	 */
	@Keyword
	def sendAccountEmail(TestObject usernameInputElement, String username) {
		try {
			WebUI.waitForElementPresent(usernameInputElement, 20)
			WebUI.focus(usernameInputElement)
			WebUI.setText(usernameInputElement, username)
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Send Usename String to the Useename Input for Signin
	 * @param usernameInputElement Katalon test object
	 * @param username String
	 */
	@Keyword
	def sendAccountCredentials(TestObject credentialsInputElement, String credentials) {
		try {
			'Enter account password.'
			WebUI.focus(credentialsInputElement)
			WebUI.click(credentialsInputElement)
			WebUI.setEncryptedText(credentialsInputElement, credentials)
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Switch To Iframe By WebElement
	 * @param String Key
	 */
	@Keyword
	def switchToIframeByWebElement(WebElement element){
		driver.switchTo().frame(element)
	}
	def switchToIframeByName(String frameName){
		driver.switchTo().frame(frameName)
	}

	def switchToIframeByID(String frameID){
		driver.switchTo().frame(frameID)
	}

	/**
	 * Switch to default Iframe Content
	 */
	@Keyword
	def switchToDefaultIframe(){
		driver.switchTo().defaultContent()
	}

	/**
	 * Clear Local Storage to Element
	 * @param WebElement element
	 */
	def clearLocalStorage(){
		JavascriptExecutor js = (JavascriptExecutor) driver
		js.executeScript("window.localStorage.clear();")
		return true
	}

	/**=========================================================================================
	 * Drag And Drop Into Frame
	 * @param String dragElementXpath
	 * @param String dropElementXpath
	 * @param WebElement dropFrameElement
	 * @return
	 */
	@Keyword
	def dragAndDropIntoIframe(String dragElementXpath, String dropElementXpath, WebElement dropFrameElement){
		driver.switchTo().defaultContent()

		/*Get Drag Element And ClickHold*/ 
		WebElement dragElement = driver.findElement(By.xpath(dragElementXpath))
		Actions thisBuilder = new Actions(driver)
		thisBuilder.clickAndHold(dragElement).build().perform()

		/*Get Stage Frane and Switch Context*/
		this.switchToIframeByWebElement(dropFrameElement)

		/*Get Drop Element, Move to Drop Element, and Release*/
		WebElement stageBody = driver.findElement(By.tagName('body'))
		WebElement dropElement = stageBody.findElement(By.xpath(dropElementXpath))
		thisBuilder.moveToElement(dropElement).build().perform()
		thisBuilder.release(dropElement).build().perform()

		/*Switch Back to Default Content*/
		driver.switchTo().defaultContent()
	}

	/**
	 * Drag And Drop By Offset
	 * @param dragElementXpath
	 * @param dropElementXpath
	 * @param dropFrameXpath
	 * @param elementXOffSet
	 * @param elementYOffSet
	 * @return
	 */
	@Keyword
	def dragbyOffSet(String dragElementXpath, String dropElementXpath, String dropFrameID, Integer elementXOffSet, Integer elementYOffSet){
		try {
			Integer xOffSet = null
			Integer yOffSet = null

			switch(elementXOffSet){
				case elementXOffSet > 0:
					xOffSet = elementXOffSet
					break

				default:
					xOffSet = 0
					break
			}

			switch(elementYOffSet){
				case elementYOffSet > 0:
					yOffSet = elementYOffSet
					break

				default:
					yOffSet = 0
					break
			}

			driver.switchTo().defaultContent()

			/*Get Stage Frane and Switch Context*/
			this.switchToIframeByID(dropFrameID)

			/*Get Drag Element And ClickHold*/
			WebElement dragElement = driver.findElement(By.xpath(dragElementXpath))
			Actions thisBuilder = new Actions(driver)
			thisBuilder.clickAndHold(dragElement).build().perform()

			/*Get Drop Element, Move to Drop Element, and Release*/
			WebElement stageBody = driver.findElement(By.tagName('body'))
			WebElement dropElement = stageBody.findElement(By.xpath(dropElementXpath))
			thisBuilder.moveByOffset(xOffSet, yOffSet).build().perform()
			thisBuilder.release(dropElement).build().perform()

			/*Switch Back to Default Content*/
			driver.switchTo().defaultContent()
		}catch(Exception e){
			KeywordUtil.markFailedAndStop("Could Not Drag Element by OffSet!: "+e)
		}
	}

	/**
	 * Click and Hold Web Element By Element Xpath
	 * @param String elementXpath
	 */
	@Keyword
	def dragWebElementOffset(WebElement element, Integer elementXOffSet, Integer elementYOffSet){
		if(element.isDisplayed()){
			this.action.moveToElement(element).clickAndHold().moveByOffset(elementXOffSet, elementYOffSet).build().perform()
			KeywordUtil.markPassed("Successfully Dragged WebElement by Offset")
		}else{
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element Could Not Be Dragged by Offset")
		}
	}
	/**=======================================================================================
	 * 
	 * Verification Methods
	 * 
	 * @param String stageElementXpath
	 * @param WebElement FrameElement
	 * @return
	 */
	@Keyword
	def verifyElementInIframe(String stageElementXpath, WebElement FrameElement){
		try{
			driver.switchTo().defaultContent()
		} catch (NoSuchFrameException e){
			KeywordUtil.markFailedAndStop("Cannot Switch to the Default Content!: "+e)
		}
		/*Get Stage Frane and Switch Context*/
		this.switchToIframeByWebElement(FrameElement)

		/*Get Drop Element, Move to Drop Element, and Release*/
		WebElement stageBody = driver.findElement(By.tagName('body'))
		println(stageBody)

		WebElement stageElement = null
		WebElement StagePlaceHolder = null
		String StagePlaceHolderXpath = '//div[contains(@class,"bc-page-content-placeholder-container") and contains(@class,"drop-zone") and contains(@data-schema-name,"Page")]'

		try {
			stageElement = stageBody.findElement(By.xpath(stageElementXpath))
			KeywordUtil.markPassed("Successfully Verified Stage Element: "+stageElement.getAttribute("class"))
			WebUI.takeScreenshot('screenshot/'+utils.getVerifiedScreenShotName())
			driver.switchTo().defaultContent()
			return
		}catch (NoSuchElementException e1){
			stageElement = stageBody.findElement(By.xpath(StagePlaceHolderXpath))
			KeywordUtil.markPassed("Successfully Verified Stage Element: "+stageElement.getAttribute("class"))
			WebUI.takeScreenshot('screenshot/'+utils.getVerifiedScreenShotName())
			KeywordUtil.markErrorAndStop("Drag and Drop Failure: Element Not On Stage!")
		}catch (Exception e2){
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Could Not Verified Stage Element!: "+e2)
		}
	}

	/**
	 * Verify Element in List By String
	 * @param String elementText
	 */
	@Keyword
	def verifyElementInList(List<WebElement> elementList, String elementText){
		for(WebElement element: elementList){
			if(element.getText().contains(elementText)){
				KeywordUtil.markPassed("Successfully Verified Element In List!")
				return
			}
		}
		KeywordUtil.markFailedAndStop("Could Not Verify Deleted Test Block!")
	}

	/**
	 * Wait Until Visibility Of Element)
	 * @param WebElement element
	 */
	@Keyword
	def waitVisibilityOfWebElement(WebElement element){
		wait.until(ExpectedConditions.visibilityOf(element))
	}

	/**
	 * Wait Until Visibility Of Element Located
	 * @param String elementXpath
	 */
	@Keyword
	def waitVisibilityOfElementLocatedBy(String elementXpath){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)))
	}

	/**
	 * 
	 * 
	 * Wait Invisibility Of Element Located
	 * 
	 */
	@Keyword
	def waitInvisibilityOfElementLocated(String elementXpath){
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementXpath)))
	}

	/**
	 * 
	 * Visibility Of All Elements
	 * 
	 */
	@Keyword
	def waitVisibilityOfAllElementsInList(List<WebElement> elementlist){
		wait.until(ExpectedConditions.visibilityOfAllElements(elementlist))
	}
	/**
	 * Wait Until Presence Of Element Located By
	 * @param String elementXpath
	 */
	@Keyword
	def waitUntilPresenceOfElementLocatedBy(String elementXpath){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)))
	}

	/**
	 * Wait Until Presence Of All Elements Located By
	 * @param String elementXpath
	 */
	@Keyword
	def waitUntilPresenceOfAllElementsLocatedBy(String elementXpath){
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(elementXpath)))
	}

	/**
	 * Wait Until Presence Of Nested Element Located By
	 * @param WebElement parentElement
	 * @param String childElementXpath
	 */
	@Keyword
	def waitUntilPresenceOfNestedElementLocatedBy(WebElement parentElement, String childElementXpath){
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parentElement, By.xpath(childElementXpath)))
	}

	/**
	 * Wait Until Title Is
	 * @param String title
	 */
	@Keyword
	def waitUntilTitleIs(String title){
		wait.until(ExpectedConditions.titleIs(title))
	}

	@Keyword
	def waittextToBePresent(String elementxpath, String elementtext){
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(elementxpath), elementtext))
	}

	/**
	 * Wait Until WebElement Selection State ToBe
	 * @param String title
	 */
	@Keyword
	def waitForWebElementSelectionStateToBe(WebElement element, String elementState){
		wait.until(ExpectedConditions.elementSelectionStateToBe(element, elementState))
	}

	/**
	 * WebElement Selection State ToBe
	 * @param WebElement element, 
	 * @param String itemText
	 */
	@Keyword
	def selectItemByVisibleText(WebElement element, String itemText){
		Select select = new Select(element)
		return select.selectByVisibleText(itemText)
	}

	/**
	 * WebElement Selection State ToBe
	 * @param WebElement element, 
	 * @param String itemText
	 */
	@Keyword
	def deselectItemByVisibleText(WebElement element, String itemText){
		Select select = new Select(element)
		return select.deselectByVisibleText(itemText)
	}

	/**
	 * Wait Until WebElement Selection State ToBe
	 * @param WebElement element, 
	 * @param String itemValue
	 */
	@Keyword
	def selectItemByValue(WebElement element, String itemValue) {
		Select select = new Select(element)
		return select.selectByValue(itemValue)
	}

	/**
	 * WebElement Selection State ToBe
	 * @param WebElement element, 
	 * @param String itemValue
	 */
	@Keyword
	def deselectItemByValue(WebElement element, String itemValue){
		Select select = new Select(element)
		return select.deselectByValue(itemValue)
	}

	/**
	 * WebElement Selection State ToBe
	 * @param WebElement element
	 */
	@Keyword
	def isSelectMultiple(WebElement element){
		Select select = new Select(element)
		return select.isMultiple()
	}

	/**
	 * WebElement Selection
	 * @param WebElement element
	 */
	@Keyword
	def deselectAllItems(WebElement element){
		Select select = new Select(element)
		select.deselectAll()
	}
}
