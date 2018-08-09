import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.applitools.eyes.RectangleSize as RectangleSize
import com.applitools.eyes.TestResults as TestResults
import com.applitools.eyes.selenium.Eyes as Eyes
import com.katalon.integration.applitools.ApplitoolsProject as ApplitoolsProject
import com.applitools.eyes.BatchInfo as BatchInfo

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.web_url)

ApplitoolsProject project = new ApplitoolsProject(GlobalVariable.server_url, GlobalVariable.api_key, GlobalVariable.app_name, 
GlobalVariable.web_url)

RectangleSize viewportSizeLandscape = new RectangleSize(400 /*height*/ , 400)

project.start(viewportSizeLandscape)

project.getEyes().setBatch(new BatchInfo(GlobalVariable.batch_info));

if (GlobalVariable.change_test) {
	WebUI.navigateToUrl(GlobalVariable.web_url + "?diff2")
}

project.getEyes().checkWindow('Init page')

WebUI.setText(findTestObject('Page_Applitools/input_name'), 'Brian Ducson')

project.getEyes().checkWindow('Enter name')

println project.handleResult(project.close())

