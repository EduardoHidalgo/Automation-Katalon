package package_Mobile_TC11_Package_with_Addons

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

// implementation in Test Case
// package.keyword.function(parameters) just like that!

/**  Clase que contiene los métodos para navegar Checkout2 en
 * el servicio de "Paquetes" de KMobile.
 *
 * @author NGPDDT009243 Eduardo Hidalgo Díaz Rugama
 * @date 04/06/18
 *
 */
public class Checkout2
{

	
	/** Llena los formularios necesarios para avanzar al paso Checkout3.
	 */
	@Keyword
	public static void AvanzarCheckout2()
	{
		//Codigo JS para obtener boton para avanzar al siguiente paso del checkout.
		//$(".btnNextResumen").find("input[type='button']").click()
		String query = "return \$(\".btnNextResumen\").find(\"input[type='button']\").length";
		
		//Ejecucion de JS
		String length = WebUI.executeJavaScript(query, null);
		//Si obtuvo cero botones, arroja un error
		if ( length.equalsIgnoreCase("0"))
		{
			WebUI.takeScreenshot()
			//Excepcion que rompe el caso de prueba y denota un error en ejecucion.
			throw new com.kms.katalon.core.exception.StepFailedException("Checkout2 Page not Load or Working correctly!");
		}
		else
		{
			//Mensaje de debug
			String message = WebUI.concatenate("Checkout2 Button detected: Length: ", length)
			package_Utils.Logs.messageInfo(message)
			
				//Llena todos los formularios del Checkout2 para poder avanzar al siguente paso del Checkout
			WebUI.setText(findTestObject('KMobile/TC11_KMobile Package with Addons/Checkout2/input_cl'), 'Prueba')			
			WebUI.setText(findTestObject('KMobile/TC11_KMobile Package with Addons/Checkout2/input_cn'), 'Prueba')			
			WebUI.setText(findTestObject('KMobile/TC11_KMobile Package with Addons/Checkout2/input_pnmAdult1'), 'Juan')		
			WebUI.setText(findTestObject('KMobile/TC11_KMobile Package with Addons/Checkout2/input_plsAdult1'), 'Perez')			
			WebUI.setText(findTestObject('KMobile/TC11_KMobile Package with Addons/Checkout2/input_pnmAdult2'), 'Ana')			
			WebUI.setText(findTestObject('KMobile/TC11_KMobile Package with Addons/Checkout2/input_plsAdult2'), 'Perez')
			WebUI.setText(findTestObject('KMobile/TC11_KMobile Package with Addons/Checkout2/input_pnmAdult3'), 'Pedro')
			WebUI.setText(findTestObject('KMobile/TC11_KMobile Package with Addons/Checkout2/input_plsAdult3'), 'Perez')
			WebUI.setText(findTestObject('KMobile/TC11_KMobile Package with Addons/Checkout2/input_pnmAdult4'), 'Susana')
			WebUI.setText(findTestObject('KMobile/TC11_KMobile Package with Addons/Checkout2/input_plsAdult4'), 'Perez')
			WebUI.setText(findTestObject('KMobile/TC11_KMobile Package with Addons/Checkout2/input_plsChild1'), 'Juanito')
			WebUI.setText(findTestObject('KMobile/TC11_KMobile Package with Addons/Checkout2/input_pnmChild1'), 'Perez')
			WebUI.setText(findTestObject('KMobile/TC11_KMobile Package with Addons/Checkout2/input_em1'), 'prueba@prueba.com')			
			WebUI.setText(findTestObject('KMobile/TC11_KMobile Package with Addons/Checkout2/input_ph1'), '1209348756')			
			WebUI.click(findTestObject('KMobile/TC11_KMobile Package with Addons/Checkout2/input_pim1'))
			
			WebUI.takeScreenshot()
			//Hace click en el boton dado que si existe y avanza al checkout1
			WebUI.executeJavaScript("\$(\".btnNextResumen\").find(\"input[type='button']\").click()", null);
			
			//Validacion -> espera a que la pagina haya cargado correctamente
			WebUI.waitForPageLoad(5, FailureHandling.CONTINUE_ON_FAILURE)
			//tiempo de espera del loader de kaleido
			WebUI.delay(4);
			
			String checkout3 = WebUI.executeJavaScript("return \$(\"#divPayments\").length;", null);
			
			if (checkout3.equalsIgnoreCase("0"))
			{
				WebUI.takeScreenshot()
				//Excepcion que rompe el caso de prueba y denota un error en ejecucion.
				throw new com.kms.katalon.core.exception.StepFailedException("Checkout3 Page not Load or Working correctly!");
			}
			else
			{
				//Excepcion que rompe el caso de prueba y denota un error en ejecucion.
				package_Utils.Logs.messageInfo("Checkout3 Load Correctly!")
				WebUI.takeScreenshot()
			}
		}
	}
}