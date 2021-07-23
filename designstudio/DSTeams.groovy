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

public class DSTeams {
	BcMain bcmain = new BcMain()
	Core brandcast = new Core()
	Utils utils = new Utils()

	/**
	 * My-TeamMembers Module Container
	 **/
	private String TeamMembersContaninerXpath = '//div[contains(@class,"team-members") and contains(@class, "module-wrapper") and contains(@class,"flex")]'

	String getTeamMembersContaninerXpath() {
		return this.TeamMembersContaninerXpath
	}

	@Keyword
	WebElement getTeamMembersContaniner(){
		return brandcast.getChildElementByXpath(bcmain.getAdminContainer(), this.getTeamMembersContaninerXpath())
	}


	/**
	 * Team Members Module Tabs Header
	 **/
	private String TeamMembersModuleTabsHeaderXpath = '//div[contains(@class,"module tabs-layout f")]/div[contains(@class,"module-tabs-header")]'

	String getTeamMembersModuleTabsHeaderXpath(){
		return this.TeamMembersModuleTabsHeaderXpath
	}

	@Keyword
	WebElement getTeamMembersModuleTabsHeader(){
		return brandcast.getChildElementByXpath(this.getTeamMembersContaniner(), this.getTeamMembersModuleTabsHeaderXpath())
	}
	
	/**
	 * Team Members Tab
	 **/
	private String TeamMembersTabXpath = '//a[contains(@class,"module-tab a")]'
	
	String getTeamMembersTabXpath(){
		return this.TeamMembersTabXpath
	}
	
	@Keyword
	WebElement getTeamMembersTab(){
		return brandcast.getChildElementByXpath(this.getTeamMembersModuleTabsHeader(), this.getTeamMembersTabXpath())
	}
	
	/**
	 * TeamMembers Title
	 **/
	private String TeamMembersTitleXpath = '//h2[contains(@class,"module-title")]'
	@Keyword
	
	String getTeamMembersTitleXpath(){
		return this.TeamMembersTitleXpath
	}
	
	WebElement getTeamMembersTitle(){
		return brandcast.getChildElementByXpath(this.getTeamMembersTab(), this.getTeamMembersTitleXpath())
	}
	
	/**
	 * Team Members Description
	 **/
	private String TeamMembersDescriptionXpath = '//p[contains(@class,"module-description")]'
	
	String getTeamMembersDescriptionXpath(){
		return this.TeamMembersDescriptionXpath
	}
	
	@Keyword
	WebElement getTeamMembersDescription(){
		return brandcast.getChildElementByXpath(this.getTeamMembersTab(), this.getTeamMembersDescriptionXpath())
	}
	
	/**
	 * Team Permission Tab
	 **/
	private String TeamPermissionTabXpath = '//a[contains(@class,"module-tab b")]'
	
	String getTeamPermissionTabXpath(){
		return this.TeamPermissionTabXpath
	}
	
	@Keyword
	WebElement getTeamPermissionTab(){
		return brandcast.getChildElementByXpath(this.getTeamMembersTab(),this.getTeamPermissionTabXpath())
	}
	
	/**
	 * TeamPermissionTitleXpath
	 **/
	private String TeamPermissionTitleXpath = '//h2[contains(@class,"module-title")]'
	
	String getTeamPermissionTitleXpath(){
		return this.TeamPermissionTitleXpath
	}
	
	@Keyword
	WebElement getTeamPermissionTitle(){
		return brandcast.getChildElementByXpath(this.getTeamPermissionTab(), this.getTeamPermissionTitleXpath())
	}
	
	/**
	 * Team Permission Description
	 **/
	private String TeamPermissionDescriptionXpath = '//p[contains(@class,"module-description")]'
	
	String getTeamPermissionDescriptionXpath(){
		return this.TeamPermissionDescriptionXpath
	}
	
	@Keyword
	WebElement getTeamPermissionDescription(){
		return brandcast.getChildElementByXpath(this.getTeamPermissionTab(), this.getTeamPermissionDescriptionXpath())
	}
	
	/**
	 * Team Feed Activity Container
	 **/
	private String TeamFeedActivityContainerXpath = './/div[contains(@class,"module aux e team-feed-activity-wrapper")]'
	
	String getTeamFeedActivityContainerXpath(){
		return this.TeamFeedActivityContainerXpath
	}
	
	@Keyword
	WebElement getTeamFeedActivityContainer(){
		return brandcast.getChildElementByXpath(this.getTeamMembersContaniner(),this.getTeamFeedActivityContainerXpath())
	}
	
	/**
	 * Team Box
	 **/
	private String TeamBoxXpath = '//div[contains(@class,"module-wrapper") and contains(@class,"no-wrap") and contains(@class,"direction-column") and contains(@class,"flex")]/div[contains(@class,"module") and contains(@class,"short-pad") and contains(@class,"team-box")]' 
	
	String getTeamBoxXpath(){
		return this.TeamBoxXpath
	}
	
	@Keyword
	WebElement getTeamBox(){
		return brandcast.getChildElementByXpath(this.getTeamFeedActivityContainer(), this.getTeamBoxXpath())
	}
	
	/**
	 * Team Account Activity
	 **/
	private String TeamAccountActivityXpath = './/div[contains(@class,"module") and contains(@class,"account-activity")]/div[contains(@class,"mod-fl-wrap")]'
	
	String getTeamAccountActivityXpath(){
		return this.TeamAccountActivityXpath
	}
	
	@Keyword
	WebElement getTeamAccountActivity(){
		return brandcast.getChildElementByXpath(this.getTeamFeedActivityContainer(),this.getTeamAccountActivityXpath())
	}
	
	private String TeamAcccountActivityHeaderXpath = './/div[contains(@class,"mod-fl-box-header")]/div[contains(@class,"module-header")]/div[contains(@class,"module-title")]'
	
	String getTeamAcccountActivityHeaderXpath(){
		return this.TeamAcccountActivityHeaderXpath
	}
	@Keyword
	WebElement getTeamAcccountActivityHeader(){
		return brandcast.getChildElementByXpath(this.getTeamAccountActivity(), this.getTeamAcccountActivityHeaderXpath())
	}
	
	/**
	 * Team Account Activity Feed Container
	 **/
	private String TeamAccountActivityFeedContainerXpath = './/div[contains(@class,"mod-fl-box-children")]/div[contains(@class,"activity-feed-container")]'
	
	String getTeamAccountActivityFeedContainerXpath(){
		return this.TeamAccountActivityFeedContainerXpath
	}
	
	@Keyword
	WebElement getTeamAccountActivityFeedContainer(){
		return brandcast.getChildElementByXpath(this.getTeamAccountActivity(),this.getTeamAccountActivityFeedContainerXpath())
	}
	
	/**
	 * Team Account Activity Feed
	 **/
	private String TeamAccountActivityFeedXpath = './/div[contains(@class,"activity-feed")]'
	
	String getTeamAccountActivityFeedXpath(){
		return this.TeamAccountActivityFeedXpath
	}
	
	@Keyword
	WebElement getTeamAccountActivityFeed(){
		return brandcast.getChildElementByXpath(this.getTeamAccountActivityFeedContainer(),this.getTeamAccountActivityFeedXpath())
	}
	
	@Keyword
	def scrollViewTeamAccountActivityFeed(){
		brandcast.executeJavascriptOnElement(this.getTeamAccountActivityFeed(), "arguments[0].scrollIntoView(true);")
	}
	
}
