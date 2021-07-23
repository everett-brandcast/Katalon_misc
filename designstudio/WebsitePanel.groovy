package com.designstudio

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.util.List

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable


import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

/*Selenium*/
import org.openqa.selenium.By
import org.openqa.selenium.By.ByXPath
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

/*custom Keywords*/
import com.brandcast.Core
import com.brandcast.Utils

public class WebsitePanel {

	Core brandcast = new Core()
	Utils utils = new Utils()

	/**
	 * 
	 * Save Template Container
	 * 
	 */
	private SaveTemplateContainerXpath = '//div[@data-overlay-id="windowareasaveastemplatecontainer"]/div[@class="window-area-wrapper"]/div[@class="settings-container"]'

	String getSaveTemplateContainerXpath(){
		return this.SaveTemplateContainerXpath
	}

	WebElement getSaveTemplateContainer(){
		return brandcast.getElementByXpath(this.getSaveTemplateContainerXpath())
	}


	/**
	 * 
	 * Save Template Form Xpath
	 * 
	 */
	private SaveTemplateFormXpath = './/form'

	String getSaveTemplateFormXpath(){
		return this.SaveTemplateFormXpath
	}

	WebElement getSaveTemplateForm(){
		return brandcast.getChildElementByXpath(this.getSaveTemplateContainer(), getSaveTemplateFormXpath())
	}


	/**
	 * 
	 * Save Template Name Input
	 * 
	 */
	private SaveTemplateNameInputXpath = '//input[@class="text-input" and @name="templateName"]'

	String getSaveTemplateNameInputXpath(){
		return this.SaveTemplateNameInputXpath
	}

	WebElement getSaveTemplateNameInput(){
		return brandcast.getChildElementByXpath(this.getSaveTemplateForm(), this.getSaveTemplateNameInputXpath())
	}

	/**
	 *
	 * Welcome Screen - Website List
	 *
	 */
	private String WebsiteListXpath = '//div[@class="website-list"]/div[@class="folder-tree-container"]/div[@class="folder-tree"]/ul/li'

	String getWebsiteListXpath(){
		return this.WebsiteListXpath
	}

	List<WebElement> getWebsiteList(){
		return brandcast.getElementListByXpath(this.getWebsiteListXpath())
	}


	WebElement getWebsiteFromList(){
		return brandcast.getRandomListWebElement(this.getWebsiteList())
	}


	@Keyword
	def selectWebsiteFromList(){
		brandcast.clickWebElement(this.getWebsiteFromList())
	}

	/**
	 * 
	 * Context Menu
	 * 
	 */
	private String WebsiteContextMenuIconXpath = '//div[@class="branch-label"]/div[@class="bc-menu-group"]'

	String getWebsiteContextMenuIconXpath(){
		return this.WebsiteContextMenuIconXpath
	}

	WebElement getWebsiteContextMenuIcon(){
		return brandcast.getChildElementByXpath(this.getWebsiteFromList(), this.getWebsiteContextMenuIconXpath())
	}

	@Keyword
	def clickWebsiteContextMenuIcon(){
		brandcast.clickChildWebElement(this.getWebsiteFromList(), this.getWebsiteContextMenuIconXpath())
	}

	private String ContextMenuOptionListXpath = '//div[@class="branch-label"]/div[contains(@class,"bc-menu-group") and contains(@class, "Active")]/div[@class="menu-item" and @data-identifier="folderBranchContext"]/div[@class="menu-dropdown"]/div[contains(@class,"ui-wrapper") and contains(@class,"btn-row-wrapper")]'
	private String ContextMenuOptionXpath = '//div[@class="branch-label"]/div[contains(@class,"bc-menu-group") and contains(@class, "Active")]'


	String getContextMenuOptionListXpath(){
		return this.ContextMenuOptionListXpath
	}

	WebElement getContextMenu(){
		return brandcast.getChildElementByXpath(this.getWebsiteFromList(), this.ContextMenuOptionXpath)
	}

	/*
	 List<WebElement> getContextMenuOptionList(){
	 return brandcast.getChildElementListByXpath(this.getWebsiteContextMenuIcon(), this.getContextMenuOptionListXpath())
	 }
	 */
	/**
	 * Get Account Selector
	 * @param WebDriver driver
	 * @param String elementXpath
	 */
	@Keyword
	def sendSaveTemplateName(){
	}
}

