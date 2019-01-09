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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//Abre un nuevo navegador, lo maximiza, y navega la url objetivo
WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://aeromexico.com/es-mx')

//Validacion -> si la página no carga produce un error
WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

//tiempo de espera
WebUI.delay(2)

//Validacion -> si existe algún elemento de la página para validar errores al cargar la página
WebUI.verifyElementPresent(findTestObject('DailyCheck/TC01_Landing Aeromexico/div_Aeromexico_StaticLogo'), 
    3, FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot()

WebUI.click(findTestObject('DailyCheck/TC01_Landing Aeromexico/Textbox_Origen'))

//tiempo de espera
WebUI.delay(1)
WebUI.takeScreenshot()

WebUI.click(findTestObject('DailyCheck/TC01_Landing Aeromexico/Label_Origen_CUN'))

//tiempo de espera
WebUI.delay(1)
WebUI.takeScreenshot()

//tiempo de espera del loader de kaleido
WebUI.delay(5)

WebUI.closeBrowser()