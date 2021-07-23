package com.brandcast

/*Java*/
import java.awt.AWTException
import java.awt.Robot
import java.awt.event.InputEvent
import java.awt.event.KeyEvent
import javax.script.ScriptEngineManager
import javax.script.ScriptEngine
import java.util.Map.Entry

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
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.By.ByXPath
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.NoSuchFrameException
import org.openqa.selenium.NoSuchWindowException
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.WebDriverException
import org.openqa.selenium.TimeoutException


/*Custom Keyword*/
import com.brandcast.Utils


public class Core {

	/*Utils*/
	Utils utils = new Utils()

	/*Get the active webdriver for native Selenium*/
	private WebDriver driver = DriverFactory.getWebDriver()

	/*Initialize Wait Object*/
	private WebDriverWait wait = new WebDriverWait(this.driver,30)

	/*Declare Selenium Actions*/
	private Actions action = new Actions(this.driver)


	/**
	 * Clear Local storage	
	 */
	@Keyword
	def clearSessionAndLocalStorage() {
		println(driver.manage().getCookies().toListString())
		driver.manage().deleteAllCookies()
		WebUI.delay(7)
	}


	/**
	 * Click Web Element By Element Xpath
	 * @param String elementXpath
	 */
	@Keyword
	def clickWebElement(WebElement element){
		if(element.isDisplayed()){
			this.action.moveToElement(element).click().build().perform()
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
	def clickChildWebElement(WebElement parentWebElement, String elementXpath){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parentWebElement, By.xpath(elementXpath)))

		WebElement webElement = parentWebElement.findElement(By.xpath(elementXpath))
		if(webElement.isDisplayed()){
			KeywordUtil.logInfo("Verified: New Web Element is Displayed: "+webElement.isDisplayed())
			this.action.moveToElement(webElement).click().build().perform()
			KeywordUtil.markPassed("Successfully Clicked Web Element")
		}else{
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element Could Not Be Click")
		}
	}

	/**
	 * Get Element By Xpath
	 * @param String elementXpath
	 */
	@Keyword
	WebElement getElementByXpath(String elementXpath){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)))
		WebElement webElement = this.driver.findElement(By.xpath(elementXpath))
		if(webElement.isDisplayed()){
			KeywordUtil.logInfo("Verified: New Web Element is Displayed: "+webElement.isDisplayed())
			KeywordUtil.markPassed("Successfully Located Web Element")
			return webElement
		}else{
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element is Not Displayed")
		}
	}

	/**
	 * Get Element By TagName
	 * @param String elementTagName
	 */
	@Keyword
	WebElement getElementByTagName(String elementTagName){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(elementTagName)))
		WebElement webElement = this.driver.findElement(By.tagName(elementTagName))
		if(webElement.isDisplayed()){
			KeywordUtil.logInfo("Verified: New Web Element is Displayed: "+webElement.isDisplayed())
			KeywordUtil.markPassed("Successfully Located Web Element")
			return webElement
		}else{
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element is Not Displayed")
		}
	}

	/**
	 * Get Element By Parent WebElement and Child Xpath
	 * @param WebElement parentWebElement
	 * @param String elementXpath
	 */
	@Keyword
	WebElement getChildElementByXpath(WebElement parentWebElement, String elementXpath) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parentWebElement, By.xpath(elementXpath)))
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
	}

	/**
	 * Get Element By Class Name
	 * @param String elementClassName
	 */
	@Keyword
	WebElement getElementByClassName(String elementClassName) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(elementClassName)))
		WebElement webElement = this.driver.findElement(By.className(elementClassName))
		if(webElement.isDisplayed()){
			KeywordUtil.logInfo("Verified: New Web Element is Displayed: "+webElement.isDisplayed())
			KeywordUtil.markPassed("Successfully Located Web Element")
			return webElement
		}else{
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element is Not Displayed")
		}
	}


	/**
	 * Get Element By Css Selector
	 * @param String elementXpath
	 */
	@Keyword
	WebElement getElementByCssSelector(String elementCssSelector) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(elementCssSelector)))
		WebElement webElement = this.driver.findElement(By.cssSelector(elementCssSelector))
		if(webElement.isDisplayed()){
			KeywordUtil.logInfo("Verified: New Web Element is Displayed: "+webElement.isDisplayed())
			KeywordUtil.markPassed("Successfully Located Web Element")
			return webElement
		}else{
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element is Not Displayed")
		}
	}

	/**
	 * Get Element By Parent WebElement and Child Css Selector
	 * @param WebElement parentWebElement
	 * @param String elementXpath
	 */
	@Keyword
	WebElement getChildElementByCssSelector(WebElement parentWebElement, String elementCssSelector) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parentWebElement, By.cssSelector(elementCssSelector)))
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
	}

	/**
	 * 
	 * Get List of Frames
	 * 
	 */
	WebElement getFrames(){
		String elementListXpath = "//iframe"
		return this.driver.findElements(By.xpath(elementListXpath))
	}

	/**
	 * Click Child Web Element By Element Xpath
	 * @param List<WebElement>
	 * @return WebElement
	 */
	@Keyword
	WebElement getRandomListWebElement(List<WebElement> alist){
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
		List<WebElement> elementList = this.driver.findElements(By.xpath(elementListXpath))
		if(!elementList.isEmpty()){
			KeywordUtil.logInfo("Verified: Web Elements: "+elementList.size())
			KeywordUtil.markPassed("Successfully Located Web Elements")
			return elementList
		}else{
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Elements is Not Displayed")
		}
	}

	/**
	 * Get List of Web Element By Element Xpath
	 * @param WebElement parentWebElement
	 * @param String elementXpath
	 */
	@Keyword
	List<WebElement> getChildElementListByXpath(WebElement parentWebElement, String elementXpath) {
		List<WebElement> elementList = parentWebElement.findElements(By.xpath(elementXpath))
		if(!elementList.isEmpty()){
			KeywordUtil.logInfo("Verified: Web Elements: "+elementList.size())
			KeywordUtil.markPassed("Successfully Located Web Elements")
			return elementList
		}else{
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Elements is Not Displayed")
		}
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
		'Obtain Element Handle'
		Integer in_xOffSet
		Integer in_yOffSet

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
	}


	/**
	 * Move to Web Element By Element Xpath
	 * @param String elementXpath
	 */
	@Keyword
	def moveToElement(String elementXpath){
		'Obtain Element Handle'
		WebElement webElement = this.driver.findElement(By.xpath(elementXpath))
		if(webElement.isDisplayed()){
			KeywordUtil.logInfo("Verified: New Web Element is Displayed: "+webElement.isDisplayed())
			this.action.moveToElement(webElement).build().perform()
			KeywordUtil.markPassed("Successfully Clicked Web Element")
		}else{
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element Could Not Be Click")
		}
	}

	/**
	 * Move to Web Element By WebElement
	 * @param String elementXpath
	 */
	@Keyword
	def moveToElementByWebElement(WebElement element){
		'Obtain Element Handle'
		if(element.isDisplayed()){
			KeywordUtil.logInfo("Verified: New Web Element is Displayed: "+element.isDisplayed())
			this.action.moveToElement(element).build().perform()
			KeywordUtil.markPassed("Successfully Clicked Web Element")
		}else{
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element Could Not Be Click")
		}
	}

	/**
	 * Move to Child Web Element By Element Xpath
	 * @param WebElement parentWebElementXpath,
	 * @param String elementXpath
	 */
	@Keyword
	def moveToChildElement(WebElement parentWebElementXpath, String elementXpath){
		WebElement webElement = parentWebElementXpath.findElement(By.xpath(elementXpath))
		if(webElement.isDisplayed()){
			KeywordUtil.logInfo("Verified: New Web Element is Displayed: "+webElement.isDisplayed())
			this.action.moveToElement(webElement).build().perform()
			KeywordUtil.markPassed("Successfully Clicked Web Element")
		}else{
			WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
			KeywordUtil.markFailedAndStop("Web Element Could Not Be Click")
		}
	}

	/*Move WebElement to WebElement*/

	@Keyword
	def moveWebElementToWebElement(WebElement parentWebElementXpath, WebElement childWebElement){
		this.action.moveToElement(childWebElement)//.build().perform()
		KeywordUtil.markPassed("Successfully Clicked Web Element")
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
	 * Scroll to Element
	 * @param WebElement element
	 */
	def scrollElementIntoView(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver
		js.executeScript("arguments[0].scrollIntoView(true);", element)
		return true
	}

	/**
	 * Clear Local Storage to Element
	 * @param WebElement element
	 */
	def clearLocalStorage(){
		JavascriptExecutor js = (JavascriptExecutor) driver
		js.executeScript("window.localStorage.clear();")
		WebUI.delay(7)
	}

	/**
	 * Send input to Web Element 
	 * @param WebElement elementXpath
	 * @param String insertData
	 */
	@Keyword
	def sendInput(WebElement element, String insertData){
		element.clear()
		this.action.moveToElement(element).click().sendKeys(insertData).build().perform()
		KeywordUtil.markPassed("Failed to Send Input")
	}

	/**
	 * Send Key 
	 * @param WebElement elementXpath
	 * @param String Key
	 */
	@Keyword
	def sendKeys(WebElement element, Keys key){
		element.clear()
		this.action.moveToElement(element).sendKeys(key).build().perform()
		KeywordUtil.markPassed("Failed to Send Key")
	}

	/**
	 * Send Usename String to the Useename Input for Signin
	 * @param usernameInputElement Katalon test object
	 * @param username String
	 */
	@Keyword
	def sendAccountEmail(TestObject usernameInputElement, String username) {
		WebUI.waitForElementPresent(usernameInputElement, 20)
		WebUI.focus(usernameInputElement)
		WebUI.setText(usernameInputElement, username)
		KeywordUtil.markPassed("Element has been clicked")
	}

	/**
	 * Send Usename String to the Useename Input for Signin
	 * @param usernameInputElement Katalon test object
	 * @param username String
	 */
	@Keyword
	def sendAccountCredentials(TestObject credentialsInputElement, String credentials) {
		'Enter account password.'
		WebUI.focus(credentialsInputElement)
		WebUI.click(credentialsInputElement)
		WebUI.setEncryptedText(credentialsInputElement, credentials)
		KeywordUtil.markPassed("Element has been clicked")
	}

	/**
	 * Switch To Iframe By WebElement
	 * @param String Key
	 */
	@Keyword
	def switchToIframeByWebElement(WebElement element){
		driver.switchTo().frame(element)
	}

	@Keyword
	def dragAndDropIntoIframe(String dragElementXpath, String dropElementXpath, String dropFrameXpath){
		driver.switchTo().defaultContent()

		/*Get Drag Element And ClickHold*/ 
		WebElement dragElement = this.driver.findElement(By.xpath(dragElementXpath))
		Actions thisBuilder = new Actions(driver)
		thisBuilder.clickAndHold(dragElement).build().perform()

		/*Get Stage Frane and Switch Context*/
		WebElement stageFrame = this.driver.findElement(By.xpath(dropFrameXpath))
		driver.switchTo().frame(stageFrame)

		/*Get Drop Element, Move to Drop Element, and Release*/
		WebElement stageBody = this.driver.findElement(By.tagName('body'))
		WebElement dropElement = stageBody.findElement(By.xpath(dropElementXpath))
		thisBuilder.moveToElement(dropElement).build().perform()
		thisBuilder.release(dropElement).build().perform()

		/*Switch Back to Default Content*/
		driver.switchTo().defaultContent()
	}

	@Keyword
	def verifyElementInIframe(String stageElementXpath, String stageFrameXpath){
		driver.switchTo().defaultContent()

		/*Get Stage Frane and Switch Context*/
		WebElement stageFrame = this.driver.findElement(By.xpath(stageFrameXpath))
		driver.switchTo().frame(stageFrame)

		/*Get Drop Element, Move to Drop Element, and Release*/
		WebElement stageBody = this.driver.findElement(By.tagName('body'))
		WebElement stageElement = stageBody.findElement(By.xpath(stageElementXpath))

		if(stageElement.isDisplayed()){
			KeywordUtil.markPassed("Successfully Verified Stage Element: "+stageElement.getAttribute("data-schema-name"))
			driver.switchTo().defaultContent()
			return
		}

		KeywordUtil.markFailedAndStop("Could Not Verified Stage Element!")
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
	 * Wait Until Visibility Of Element Located
	 * @param String elementXpath
	 */
	@Keyword
	def waitVisibilityOfElementLocatedBy(String elementXpath){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)))
	}

	/**
	 * 
	 * visibilityOfAllElements
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
}
