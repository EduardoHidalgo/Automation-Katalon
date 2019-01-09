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

/** TC01_Verify Successfull - KTravel Hotel Quote
 *
 *  NOTA: Este Test Case contiene variables locales que se instancian en la función
 *  package_KTravel_TC01_Hotel.Busqueda.CrearURL(parameters) con datos de un Data File de tipo .CSV
 *
 * @author NGPDDT009243 Eduardo Hidalgo Díaz Rugama
 * @date 30/05/2018
 *
 */

String Url = CustomKeywords.'package_KTravel_Hotel.Busqueda.CrearURL'(((domain) as String), ((affiliate) as String), ((language) as String), 
        ((currency) as String), ((startDate) as String), ((endDate) as String), ((coupon) as String), ((destinationID) as String), 
        ((noRooms) as String), ((adults1) as String), ((childrens1) as String), ((ageChildren1) as String), ((adults2) as String), 
        ((childrens2) as String), ((ageChildren2) as String), ((adults3) as String), ((childrens3) as String), ((ageChildren3) as String), 
        ((adults4) as String), ((childrens4) as String), ((ageChildren4) as String), ((adults5) as String), ((childrens5) as String), 
        ((ageChildren5) as String), ((trafficSource) as String), ((deviceId) as String), ((cityName) as String), ((orderList) as String), 
        ((sortList) as String), ((records) as String), ((noPage) as String), ((filterOptions) as String))

CustomKeywords.'package_KTravel_Hotel.Busqueda.NavegarURL'(Url)

CustomKeywords.'package_KTravel_Hotel.Lista.SeleccionarHotel'()

CustomKeywords.'package_KTravel_Hotel.Ficha.SeleccionarHabitacion'()

CustomKeywords.'package_KTravel_Hotel.Checkout1.AvanzarCheckout1'()

CustomKeywords.'package_KTravel_Hotel.Checkout2.AvanzarCheckout2'()

