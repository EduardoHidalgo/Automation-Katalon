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

/** TC02_Verify Successfull - KTravel Package Quote
 *
 *  NOTA: Este Test Case contiene variables locales que se instancian en la funci?n
 *  package_KTravel_TC02_Package.Busqueda.CrearURL(parameters) con datos de un Data File de tipo .CSV
 *
 * @author NGPDDT009243 Eduardo Hidalgo D?az Rugama
 * @date 06/08/2018
 *
 */
String url = CustomKeywords.'package_DailyCheck_TC02_Ajax_Ktravel.packageSearch.CrearURL'(((domain) as String), ((affiliate) as String))

CustomKeywords.'package_DailyCheck_TC02_Ajax_Ktravel.packageSearch.NavegarURL'(url)

CustomKeywords.'package_DailyCheck_TC02_Ajax_Ktravel.packageSearch.SelectOrigen'(((origen) as String), ((origenText) as String))

CustomKeywords.'package_DailyCheck_TC02_Ajax_Ktravel.packageSearch.SelectDestino'(((destino) as String), ((destinoText) as String))

CustomKeywords.'package_DailyCheck_TC02_Ajax_Ktravel.packageSearch.ClickSearchButton'()

