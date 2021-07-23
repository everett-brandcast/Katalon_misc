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


class CSSignin {

	Core brandcast = new Core()

	/**
	 * Login Container
	 **/
	private String loginContainerXpath = '//div[@class="fixed-login-box"]/div[@class="login-wrapper"]/div[@class="col-wrapper"]'

	String getloginContainerXpath(){
		return this.loginContainerXpath
	}

	WebElement getloginContainer() {
		return brandcast.getElementByXpath(this.getloginContainerXpath())
	}


	/**
	 * Login Form'
	 **/
	private String LoginFormXpath = './/div[@class="column b"]/div[@class="content"]/div[contains(@class,"form-wrapper") and contains(@class,"fadeInUp")]/form[contains(@class,"form-wrapper") and contains(@class,"container")]/div'
	String getLoginFormXpath(){
		return this.LoginFormXpath
	}

	WebElement getLoginForm(){
		return brandcast.getChildElementByXpath(this.getloginContainer(), this.getLoginFormXpath())
	}


	/**
	 * Login Email Input'
	 **/
	private String LoginEmailInputXpath = './/input[@class="text-input" and @data-qa-id="login-email" and @placeholder="Email Address" and @type="email" and @autocomplete="username" and @name="login__email"]'
	String getLoginEmailInputXpath(){
		return this.LoginEmailInputXpath
	}

	WebElement getLoginEmailInput(){
		return brandcast.getChildElementByXpath(this.getLoginForm(), this.getLoginEmailInputXpath())
	}


	/**
	 * Login Email Password'
	 **/
	private String LoginEmailPasswordXpath = './/input[@class="text-input" and @data-qa-id="login-password" and @placeholder="Password" and @type="password" and @autocomplete="current-password" and @name="login__password"]'

	String getLoginEmailPasswordXpath(){
		return this.LoginEmailPasswordXpath
	}

	WebElement getLoginEmailPassword(){
		return brandcast.getChildElementByXpath(this.getLoginForm(), this.getLoginEmailPasswordXpath())
	}


	/**
	 * Refresh browser
	 */
	@Keyword
	def login(){
		KeywordUtil.logInfo("Refreshing")
		'Enter account email'
		brandcast.waitUntilPresenceOfElementLocatedBy(this.LoginEmailInputXpath)
		brandcast.sendInput(this.getLoginEmailInput(), GlobalVariable.username)
		'Enter Credentials'
		brandcast.sendInput(this.getLoginEmailPassword(), GlobalVariable.passwordPlainText)
		'Submit Login'
		WebUI.click(findTestObject('button_Submit'))
		KeywordUtil.markPassed("Refresh successfully")
	}

	@Keyword
	def clearLocalStorage(){
		brandcast.clearLocalStorage()
		brandcast.clearSessionAndLocalStorage()
	}
}