package com.designstudio

/*Java Import*/
import java.util.List
import java.awt.datatransfer.StringSelection
import java.awt.Toolkit
import java.awt.datatransfer.*

/*Robot*/
import java.awt.AWTException
import org.openqa.selenium.interactions.*


/*Groovy Import*/
import static groovy.io.FileType.FILES

/*Selenium Import*/
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.Point
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver

/*Custom Keywords*/
import com.brandcast.Core
import com.brandcast.Utils

/*Katalon Built-inb*/
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.exception.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


public class DSMediaLibrary {
	Core brandcast = new Core()
	Utils utils = new Utils()

	//Project Dir Path
	@Keyword
	def getProjectDirPath(){
		return RunConfiguration.getProjectDir()
	}

	//Test Image Path
	@Keyword
	def getSelectedImage(){
		return this.getImageFromImageList()+'.jpg'
	}

	@Keyword
	def getTestImagePath(){
		return this.getProjectDirPath()+'/assets/'+this.getSelectedImage()
	}

	//Media Library Button
	private String MediaLibraryButtonXpath = '//span/div[contains(@class,"btn-text")]/div[contains(@data-tutorial-id,"media-library-btn")]'

	String getMediaLibraryButtonXpath(){
		return this.MediaLibraryButtonXpath
	}

	WebElement getmediaLibraryButton(){
		return brandcast.getElementByXpath(this.getMediaLibraryButtonXpath())
	}

	@Keyword
	def clickMediaLibraryButton(){
		brandcast.clickWebElement(this.getmediaLibraryButton())

	}

	//Unsplash Link in Media Library Left Panel'
	private String MediaLibraryUnsplashLinkXpath = '//span[contains(text(),"Unsplash")]'

	String getMediaLibraryUnsplashLinkXpath(){
		return this.MediaLibraryUnsplashLinkXpath
	}

	WebElement getMediaLibraryUnsplashLink(){
		return brandcast.getElementByXpath(this.getMediaLibraryUnsplashLinkXpath())
	}

	@Keyword
	def clickMediaLibraryUnsplashLink(){
		brandcast.clickWebElement(this.getMediaLibraryUnsplashLink())
	}

	//Image Grid Xpath'
	private String ImageCollectionListXpath ='//div[contains(@class,"collection-item") and contains(@class,"collection-type-image")]'

	String getImageCollectionListXpath(){
		return this.ImageCollectionListXpath
	}

	List<WebElement> getImageCollectionList(){
		return brandcast.getElementListByXpath(this.getImageCollectionListXpath())
	}

	//Unsplash Image Grid Xpath'
	private String UnsplashCollectionListXpath = this.getImageCollectionListXpath()

	String getUnsplashCollectionListXpath(){
		return this.UnsplashCollectionListXpath
	}

	List<WebElement> getUnsplashCollectionList(){
		return brandcast.getElementListByXpath(this.getUnsplashCollectionListXpath())
	}

	WebElement getRandomUnsplashCollectionItem(){
		return brandcast.getRandomListWebElement(this.getUnsplashCollectionList())
	}

	@Keyword
	def clickSelectedUnsplashCollectionItem(){
		brandcast.clickWebElement(this.getRandomUnsplashCollectionItem())
	}


	//Image Tile Xpath
	private ImageTileXpath = '//div[contains(@class,"collection-text-container")]/div[contains(@class,"collection-text clearfix")]/div[contains(@class,"swap-container clearfix")]/h5[contains(@class,"text-swap")]'

	String getImageTileXpath(){
		return this.ImageTileXpath
	}

	WebElement getImageTile(){
		return brandcast.getChildElementByXpath(this.getUploadImageElementByIndex(), this.getImageTileXpath())
	}


	//Media Library Close Button
	String MediaLibraryCloseButtonXpath = '//div[@title="Close"]/div[@data-qa-id="close-btn"]'

	String getMediaLibraryCloseButtonXpath(){
		return this.MediaLibraryCloseButtonXpath
	}

	WebElement getMediaLibraryCloseButton(){
		return brandcast.getElementByXpath(this.getMediaLibraryCloseButtonXpath())
	}

	@Keyword
	def clickMediaLibraryCloseButton(){
		brandcast.clickWebElement(this.getMediaLibraryCloseButton())
	}


	//Buttons to switch Design Studio Mode'
	String StudioModeButtonXpath = '//div[@data-tutorial-id="studio-mode-btn"]'

	String getStudioModeButtonXpath(){
		return this.StudioModeButtonXpath
	}

	WebElement getStudioModeButton(){
		return brandcast.getElementByXpath(this.getStudioModeButtonXpath())
	}

	@Keyword
	def clickStudioModeButton(){
		brandcast.clickWebElement(this.getStudioModeButton())
	}


	//Click Media Download Button
	private String MediaDownloadButtonXpath = '//div[@data-tutorial-id="download-btn"]'

	String getMediaDownloadButtonXpath(){
		return this.MediaDownloadButtonXpath
	}

	WebElement getMediaDownloadButton(){
		return brandcast.getElementByXpath(this.getMediaDownloadButtonXpath())
	}

	@Keyword
	def clickMediaDownloadButton(){
		brandcast.clickWebElement(this.getMediaDownloadButton())
	}

	@Keyword
	def waitForMediaDownloadButton(){
		brandcast.waitVisibilityOfWebElement(this.clickMediaDownloadButton())
	}


	//Media Copy Button
	private String MediaCopyButtonXpath = '//div[contains(@class,"copy-btn-container")]'

	String getMediaCopyButtonXpath(){
		return this.MediaCopyButtonXpath
	}

	WebElement getMediaCopyButton(){
		return brandcast.getElementByXpath(this.getMediaCopyButtonXpath())
	}

	@Keyword
	def clickMediaCopyButton(){
		brandcast.clickWebElement(this.getMediaCopyButton())
	}

	@Keyword
	def waitForMediaCopyButton(){
		brandcast.waitVisibilityOfWebElement(this.clickMediaCopyButton())
	}

	//MediaPanel
	private String MediaPanelXpath = '//div[@data-overlay-id="medialibrarycontainer"]'

	String getMediaPanelXpath(){
		return this.MediaPanelXpath
	}

	WebElement getMediaPanel(){
		return brandcast.getElementByXpath(this.getMediaPanelXpath())
	}

	//Media Library Image Link
	private String MediaLibraryImageLinkXpath = '//span[text()="Images"]'

	String getMediaLibraryImageLinkXpath(){
		return this.MediaLibraryImageLinkXpath
	}

	WebElement getMediaLibraryImageLink(){
		return brandcast.getChildElementByXpath(this.getMediaPanel(), this.getMediaLibraryImageLinkXpath())
	}

	@Keyword
	def clickMediaLibraryImageLink(){
		brandcast.clickWebElement(this.getMediaLibraryImageLink())
	}

	//Search Field
	private String MediaLibrarySearchXpath = '//div[contains(@class,"site-info-toolbar")]/div[@class="site-info-toolbar-left"]/div[@class="site-map-toolbar-item"]/div[contains(@class,"search-input-container")]/div[@class="search-input-wrapper"]/input[@placeholder="Search"]'

	String getMediaLibrarySearchXpath(){
		return this.MediaLibrarySearchXpath
	}

	WebElement getMediaLibrarySearch(){
		return brandcast.getChildElementByXpath(this.getMediaPanel(), this.getMediaLibrarySearchXpath())
	}

	@Keyword
	def clickMediaLibrarySearch(){
		brandcast.clickWebElement(this.getMediaLibrarySearch())
	}

	@Keyword
	def sendImageNameToSearch(String insertData){
		brandcast.sendInput(this.getMediaLibrarySearch(), insertData)
	}

	//
	private String ClearSearchButtonXpath = '//div[contains(@class, "search-input-container")]/div[@class="search-input-wrapper"]/div[@class="clear-search-container"]/div[@class="clear-search"]'

	String getClearSearchButtonXpath(){
		return this.ClearSearchButtonXpath
	}

	WebElement getClearSearchButton(){
		return brandcast.getChildElementByXpath(this.getMediaPanel(), this.getClearSearchButtonXpath())
	}

	@Keyword
	def clickClearSearchButton(){
		brandcast.clickWebElement(this.getClearSearchButton())
	}

	//Delete Button XPath
	private String DeleteButtonXPath = '//div[@class="site-info-toolbar-right"]/div[@class="left"]/div[@title="Delete"]/div[@data-qa-id="delete-page-btn"]'

	String getDeleteButtonXPath(){
		return this.DeleteButtonXPath
	}

	WebElement getDeleteButton(){
		return brandcast.getChildElementByXpath(this.getMediaPanel(), this.getDeleteButtonXPath())
	}

	@Keyword
	def clickDeleteButton(){
		brandcast.clickWebElement(this.getDeleteButton())
	}

	//Delete Modal Button
	private String DeleteModalButtonXpath = '//div[@data-overlay-id="deletecollectionitemsconfirmationcontainer"]/div[@class="bc-modal-wrapper"]/div[@class="container-clear modal-system"]/div[@class="container-clear modal-btns"]/div[@class="ui-wrapper editor-style primary"]/button[@data-qa-id="delete-page-button"]'

	String getDeleteModalButtonXpath(){
		return this.DeleteModalButtonXpath
	}

	WebElement getDeleteModalButton(){
		return brandcast.getChildElementByXpath(this.getMediaPanel(), this.getDeleteModalButtonXpath())
	}

	@Keyword
	def clickDeleteModalButton(){
		brandcast.clickWebElement(this.getDeleteButton())
	}



	@Keyword
	def uploadImageFile(){
		println(this.getUploadInput().getAttribute("innerHTML"))
	}

	//Upload Button Element
	private String UploadButtonXpath = '//div[contains(@class,"left-panel")]/div[contains(@class,"file-uploader-container")]/div[contains(@class,"file-uploader")]/div[contains(@class,"ui-wrapper") and contains(@class,"file-uploader-btn") and contains(@title,"Upload Media")]/span/div[contains(@class,"btn-text")]/div[contains(@data-tutorial-id,"upload-media-btn") and contains(@class,"btn-text-label")]'


	String getUploadButtonXpath(){
		return this.UploadButtonXpath
	}

	WebElement getUploadButton(){
		return brandcast.getElementByXpath(this.getUploadButtonXpath())
	}

	@Keyword
	def clickUploadButton(){
		return brandcast.clickWebElement(this.getUploadButton())
	}

	//Upload Input Element
	private String FileUploaderContainerXpath = '//div[contains(@class,"left-panel")]/div[contains(@class,"file-uploader-container")]/div[contains(@class,"file-uploader")]'

	String getFileUploaderContainerXpath(){
		return this.FileUploaderContainerXpath
	}

	@Keyword
	WebElement getFileUploaderContainer(){
		return brandcast.getElementByXpath(this.getFileUploaderContainerXpath())
	}

	//Javascript
	private JSQueryByCSS = 'var selectElement = document.querySelector(\'input[type="file"]\'); selectElement.setAttribute("style", "block"); selectElement.setAttribute("visibility","hidden");'

	String getJSQueryByCSS(){
		return this.JSQueryByCSS
	}

	@Keyword
	def updateUploadInputAttributes(){
		brandcast.executeJSCSSQuery(this.getJSQueryByCSS())

	}

	//Upload Input
	private UploadInputXpath = '//input[@type="file"]'

	String getUploadInputXpath(){
		return this.UploadInputXpath
	}

	WebElement getUploadInput(){
		WebElement fileUpLoadInput = brandcast.getElementByXpath(this.getUploadInputXpath())
		brandcast.sendInput(fileUpLoadInput,this.getTestImagePath())
	}

	@Keyword
	String getImageFromImageList(){
		Random rand = new Random();
		List imgnamelist = GlobalVariable.ImgNameList
		return imgnamelist.get(rand.nextInt(imgnamelist.size()))
	}

	WebElement getUploadImageElementByIndex(){
		return this.getImageCollectionList()[this.getImageCollectionList().size()-1]
	}


	//Progress bar
	private String ProgressBarXpath = '//span/div[contains(text(), "note-a-container")]/span[text()="Uploading 1 item"]'

	String getProgressBarXpath(){
		return this.ProgressBarXpath
	}

	WebElement getProgressBar(){
		return brandcast.getElementByXpath(this.getProgressBarXpath())
	}

	@Keyword
	def waitForProgressBarInvisibility(){
		brandcast.waitInvisibilityOfElementLocated(this.getProgressBarXpath())
	}

	//Search for each image if exist delete
	@Keyword
	def searchGridforImageInListAndDelete(){
		WebElement foundItem = null
		String selectedlistedImage = null

		for (String listedImage: GlobalVariable.ImgNameList){
			println("Searching for image: "+listedImage+"in Grid")
			selectedlistedImage = listedImage
			this.sendImageNameToSearch(listedImage)
			WebUI.delay(5)
			brandcast.sendKeys(this.getMediaLibrarySearch(), Keys.ENTER)
			WebUI.delay(5)
			try{
				foundItem = brandcast.getWebElementFromListByText(this.getImageCollectionList(),listedImage)
			}catch (StepFailedException e) {
				continue
			}
			if(foundItem != null){
				println("Image: "+selectedlistedImage+" Found")
				brandcast.clickWebElement(foundItem)
				WebUI.delay(3)
				this.clickDeleteButton()
				WebUI.delay(3)
				this.clickDeleteModalButton()
				KeywordUtil.markPassed("Success: Upload Image Found in Grid")
				return
			}

		}
		WebUI.takeScreenshot('screenshot/'+utils.getScreenShotName())
		KeywordUtil.markFailedAndStop("Uploaded Image Not In Grid")
	}

	//Verify downloaded image file
	@Keyword
	def verifyDownloadedImageFile(){
		new File('/tmp').eachFileRecurse(FILES){
			if(it.name.endsWith('.jpg')){
				KeywordUtil.markPassed("Successfully Downloaded: "+it)
				KeywordUtil.logInfo("Deleting Download "+it)
				it.delete()
			}
		}
	}

	@Keyword
	def verifyImageOnClipboard(){
		try {
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard()
			Object data = clipboard.getData(DataFlavor.stringFlavor)
			KeywordUtil.logInfo("Successfully verified Image On Clipboard! "+data)
			return 1
		} catch (UnsupportedFlavorException | IOException ex) {
			KeywordUtil.logInfo("Failed to verify Image On Clipboard! "+ex)
			return null
		}
	}
}
