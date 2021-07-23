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
import com.designstudio.DSStage

public class DSHorizontalToolbar {
	BcMain bcmain = new BcMain()
	Core brandcast = new Core()
	Utils utils = new Utils()
	DSStage dsstage = new DSStage()

	/**
	 * Design Studio Horizontal Toolbar	
	 **/
	private String DsHorizontalToolbarXpath = './/div[contains(@class,"toolbar horizontal position-top-a")]/div[contains(@class,"content primary-text-menu left")]/div[contains(@class,"bc-menu-group light-theme in-design-studio")]'

	String getDsHorizontalToolbarXpath(){
		return this.DsHorizontalToolbarXpath
	}

	@Keyword
	WebElement getDsHorizontalToolbar(){
		return brandcast.getChildElementByXpath(dsstage.getStageWrapper(), this.getDsHorizontalToolbarXpath())
	}

	/**
	 * Design Studio Horizontal Toolbar Menu File
	 **/
	private String DsHorizontalToolbarMenuFileXpath = '//div[contains(@class,"menu-item") and contains(@data-identifier,"menuFile")]'
	
	String getDsHorizontalToolbarMenuFileXpath(){
		return this.DsHorizontalToolbarMenuFileXpath
	}
	
	WebElement getDsHorizontalToolbarMenuFile(){
		return brandcast.getChildElementByXpath(this.getDsHorizontalToolbar(),this.getDsHorizontalToolbarMenuFileXpath())
	}
	
	/**
	 * Design Studio Logo
	 */
	private String DsLogoXpath = './/div[contains(@class,"btn-blank design-studio-logo")]'

	String getDsLogoXpath(){
		return this.DsLogoXpath
	}

	@Keyword
	WebElement getDsLogo(){
		return brandcast.getChildElementByXpath(this.getDsHorizontalToolbarMenuFile(),this.getDsLogoXpath())
	}

	@Keyword
	def clickDsLogo(){
		brandcast.clickChildWebElement(this.getDsHorizontalToolbar(), this.getDsLogoXpath())
	}
	
	/**
	 * Logo Dropdown Menu
	 **/
	private String LogoDropDownMenuXpath = './/div[contains(@class,"menu-dropdown logo-dropdown")]'
	
	String getLogoDropDownMenuXpath(){
		return this.LogoDropDownMenuXpath
	}
	
	@Keyword
	WebElement getLogoDropDownMenu(){
		return brandcast.getChildElementByXpath(this.getDsHorizontalToolbar(),this.getLogoDropDownMenuXpath())
	}
	
	/**
	 * Logo Drop Down Menu My-Brandcast
	 **/
	private String LogoDropDownMenuMyBrandcastXpath =  './/div[contains(@class,"ui-wrapper btn-row-wrapper my-brandcast icon-14")]/div[contains(@class,"btn-row btn-row-link")]/a[contains(@class,"btn-row-label")]'
	
	String getLogoDropDownMenuMyBrandcastXpath(){
		return this.LogoDropDownMenuMyBrandcastXpath
	}
	
	@Keyword
	WebElement getLogoDropDownMenuMyBrandcast(){
		return brandcast.getChildElementByXpath(this.getLogoDropDownMenu(),this.getLogoDropDownMenuMyBrandcastXpath())
	}
	
	@Keyword
	WebElement clickLogoDropDownMenuMyBrandcast(){
		//brandcast.executeJavascriptClickElement(this.getLogoDropDownMenuMyBrandcast())
		//brandcast.moveMouseByOffSet(0, 200)
		//brandcast.clickWebElementByOffSet(this.getLogoDropDownMenuMyBrandcast(),0, 200)
		brandcast.clickWebElement(this.getLogoDropDownMenuMyBrandcast())
		//brandcast.clickChildWebElement(this.getLogoDropDownMenu(),this.getLogoDropDownMenuMyBrandcastXpath())
	}
	
	/**
	 * Logo Drop Down Menu My-Websites
	 **/
	private String LogoDropDownMenuMyWebsitesXpath = './/div[contains(@class,"ui-wrapper btn-row-wrapper my-websites icon-14")]/div[contains(@class,"btn-row btn-row-link")]/a[contains(@class,"btn-row-label")]'
	
	String getLogoDropDownMenuMyWebsitesXpath(){
		return this.LogoDropDownMenuMyWebsitesXpath
	}
	
	@Keyword
	WebElement getLogoDropDownMenuMyWebsites(){
		return brandcast.getChildElementByXpath(this.getLogoDropDownMenu(),this.getLogoDropDownMenuMyWebsitesXpath())
	}
	
	@Keyword
	WebElement clickLogoDropDownMenuMyWebsites(){
		brandcast.clickWebElementByOffSet(this.getLogoDropDownMenuMyWebsites(), 0, 200)
		//brandcast.clickChildWebElement(this.getLogoDropDownMenu(),this.getLogoDropDownMenuMyWebsitesXpath())
	}
	
	/**
	 * Logo Drop Down Menu My-Templates
	 **/
	private String LogoDropDownMenuMyTemplatesXpath = './/div[contains(@class,"ui-wrapper btn-row-wrapper my-templates icon-14")]/div[contains(@class,"btn-row btn-row-link")]/a[contains(@class,"btn-row-label")]'
	
	String getLogoDropDownMenuMyTemplatesXpath(){
		return this.LogoDropDownMenuMyTemplatesXpath
	}
	
	@Keyword
	WebElement getLogoDropDownMenuMyTemplates(){
		return brandcast.getChildElementByXpath(this.getLogoDropDownMenu(),this.getLogoDropDownMenuMyTemplatesXpath())
	}
	
	@Keyword
	WebElement clickLogoDropDownMenuMyTemplates(){
		brandcast.clickChildWebElement(this.getLogoDropDownMenu(),this.getLogoDropDownMenuMyTemplatesXpath())
	}
	
	/**
	 * Logo Drop Down Menu My-Blocks
	 */
	private String LogoDropDownMenuMyBlocksXpath = './/div[contains(@class,"ui-wrapper btn-row-wrapper my-blocks icon-14")]/div[contains(@class,"btn-row btn-row-link")]/a[contains(@class,"btn-row-label")]'
	
	String getLogoDropDownMenuMyBlocksXpath(){
		return this.LogoDropDownMenuMyBlocksXpath
	}
	
	@Keyword
	WebElement getLogoDropDownMenuMyBlocks(){
		return brandcast.getChildElementByXpath(this.getLogoDropDownMenu(),this.getLogoDropDownMenuMyBlocksXpath())
	}
	
	@Keyword
	WebElement clickLogoDropDownMenuMyBlocks(){
		brandcast.clickChildWebElement(this.getLogoDropDownMenu(),this.getLogoDropDownMenuMyBlocksXpath())
	}
	
	/**
	 * Logo Drop Down Menu My-Team
	 **/
	private String LogoDropDownMenuMyTeamXpath = './/div[contains(@class,"ui-wrapper btn-row-wrapper my-team icon-14")]/div[contains(@class,"btn-row btn-row-link")]/a[contains(@class,"btn-row-label")]'
	
	String getLogoDropDownMenuMyTeamXpath(){
		return this.LogoDropDownMenuMyTeamXpath
	}
	
	@Keyword
	WebElement getLogoDropDownMenuMyTeam(){
		return brandcast.getChildElementByXpath(this.getLogoDropDownMenu(),this.getLogoDropDownMenuMyTeamXpath())
	}
	
	@Keyword
	WebElement clickLogoDropDownMenuMyTeam(){
		brandcast.clickChildWebElement(this.getLogoDropDownMenu(),this.getLogoDropDownMenuMyTeamXpath())
	}
	
	
	
	/**================================================================================================================================
	 * Horizontal Menu File
	 **/
	private String HorizontalMenuFileXpath = '//div[contains(@class,"menu-item") and contains(@data-identifier,"menuFile")]'
	String getHorizontalMenuFileXpath(){
		return this.HorizontalMenuFileXpath
	}

	@Keyword
	WebElement getHorizontalMenuFile(){
		return brandcast.getChildElementByXpath(this.getDsHorizontalToolbar(),this.getHorizontalMenuFileXpath())
	}

	@Keyword
	def clickHorizontalMenuFile(){
		brandcast.clickChildWebElement(this.getDsHorizontalToolbar(), this.getHorizontalMenuFileXpath())
	}

	/**
	 * Horizontal Menu Edit
	 **/
	private String HorizontalMenuEditXpath = 'div[contains(@class,"menu-item") and contains(@data-identifier,"menuEdit")]'

	String getHorizontalMenuEditXpath(){
		return this.HorizontalMenuEditXpath
	}

	@Keyword
	WebElement getHorizontalMenuEdit(){
		return brandcast.getChildElementByXpath(this.getDsHorizontalToolbar(),this.getHorizontalMenuEditXpath())
	}

	@Keyword
	def clickHorizontalMenuEdit(){
		brandcast.clickChildWebElement(this.getDsHorizontalToolbar(), this.getHorizontalMenuEditXpath())
	}

	/**
	 * Horizontal Menu View
	 **/
	private String HorizontalMenuViewXpath = 'div[contains(@class,"menu-item") and contains(@data-identifier,"menuView")]'

	String getHorizontalMenuViewXpath(){
		return this.HorizontalMenuViewXpath
	}

	@Keyword
	WebElement getHorizontalMenuView(){
		return brandcast.getChildElementByXpath(this.getDsHorizontalToolbar(),this.getHorizontalMenuViewXpath())
	}

	@Keyword
	def clickHorizontalMenuView(){
		brandcast.clickChildWebElement(this.getDsHorizontalToolbar(), this.getHorizontalMenuViewXpath())
	}

	/**
	 * Horizontal Menu Window
	 **/
	private String HorizontalMenuWindowXpath = 'div[contains(@class,"menu-item") and contains(@data-identifier,"menuWindow")]'

	String getHorizontalMenuWindowXpath(){
		return this.HorizontalMenuWindowXpath
	}

	@Keyword
	WebElement getHorizontalMenuWindow(){
		return brandcast.getChildElementByXpath(this.getDsHorizontalToolbar(),this.getHorizontalMenuWindowXpath())
	}

	@Keyword
	def clickHorizontalMenuWindow(){
		brandcast.clickChildWebElement(this.getDsHorizontalToolbar(), this.getHorizontalMenuWindowXpath())
	}

	/**
	 * Horizontal Menu Help
	 **/
	private String HorizontalMenuHelpXpath = 'div[contains(@class,"menu-item") and contains(@data-identifier,"menuHelp")]'
	String getHorizontalMenuHelpXpath(){
		return this.HorizontalMenuHelpXpath
	}

	@Keyword
	WebElement getHorizontalMenuHelp(){
		return brandcast.getChildElementByXpath(this.getDsHorizontalToolbar(),this.getHorizontalMenuHelpXpath())
	}

	@Keyword
	def clickHorizontalMenuHelp(){
		brandcast.clickChildWebElement(this.getDsHorizontalToolbar(), this.getHorizontalMenuHelpXpath())
	}
}
