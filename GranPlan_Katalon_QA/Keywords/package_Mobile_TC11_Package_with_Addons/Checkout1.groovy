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
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

// implementation in Test Case
// package.keyword.function(parameters) just like that!

/** Clase que contiene los métodos para navegar Checkout1 en
 * el servicio de "Paquetes" de Kaleido.
 *
 * @author NGPDDT009243 Eduardo Hidalgo Díaz Rugama
 * @date 04/06/18
 *
 */
public class Checkout1 {
	
	/** Avanza del Checkout1 al Checkout2.
	 */
	@Keyword
	public static void AvanzarCheckout1()
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
			throw new com.kms.katalon.core.exception.StepFailedException("Checkout1 Page not Load or Working correctly!");
		}
		else
		{
			// Añade los Addons que encuentra
			SetAddons()
			
			//Mensaje de debug
			String message = WebUI.concatenate("Checkout1 Button detected: Length: ", length)
			package_Utils.Logs.messageInfo(message)
			WebUI.takeScreenshot()
			//Hace click en el boton dado que si existe y avanza al checkout1
			WebUI.executeJavaScript("\$(\".btnNextResumen\").find(\"input[type='button']\").click()", null);
			//Validacion -> espera a que la pagina haya cargado correctamente
			WebUI.waitForPageLoad(5, FailureHandling.CONTINUE_ON_FAILURE)
			//tiempo de espera del loader de kaleido
			WebUI.delay(GlobalVariable.G_Delay);
		}
	}
	
	/** Busca el primer Addon de cada servicio que encuentre.
	 * 	Levanta errores falsos en caso de no encontrar el Addon.
	 *
	 */
	private static void SetAddons()
	{
		//tiempo de espera para saber que cargaron los ajax
		WebUI.delay(10)
		
		SetAddonInsurance();
		SetAddonShuttle();
	}
	
	/** Addon Seguros.
	 *
	 */
	private static void SetAddonInsurance()
	{
		//Valida que existan los addons de seguros en este asociado
		String query = "return \$(\$(\"#protectionQuote\").find(\"input[type='checkbox']\")).first().length";
		//Ejecucion de JS
		String length = WebUI.executeJavaScript(query, null);
		
		package_Utils.Logs.messageInfo("Insurance Length:" + length);
		// Si el length del servicio de addon es 0, tira una excepción falsa
		if (length.equalsIgnoreCase("0"))
		{
			// excepción falsa ?
			WebUI.takeScreenshot()
			//Excepcion que rompe el caso de prueba y denota un error en ejecucion.
			//throw new com.kms.katalon.core.exception.StepFailedException("Addon Insurance was not found!");
			KeywordUtil.markWarning("Addon Insurance was not found!");
		}
		else
		{
			//$($("#divAssintancePrograms").find("input[type='checkbox']").first()).click();
			//hace checked al seguro
			query = "\$(\$(\"#protectionQuote\").find(\"input[type='checkbox']\")).first().click();";
			WebUI.executeJavaScript(query, null);
			package_Utils.Logs.messageInfo("Addon Insurance Checked.");
		}
	}
	
	/** Addon Traslado.
	 *
	 */
	private static void SetAddonShuttle()
	{
		//Valida que existan los addons de traslados en este asociado
		String query = "return \$(\"#shuttles\").find(\"input[type='radio']\").first().length";
		//Ejecucion de JS
		String length = WebUI.executeJavaScript(query, null);
		
		package_Utils.Logs.messageInfo("Shuttle Length: " + length);
		// Si el length del servicio de addon es 0, tira una excepción falsa
		if (length.equalsIgnoreCase("0"))
		{
			// excepción falsa ?
			WebUI.takeScreenshot()
			//Excepcion que rompe el caso de prueba y denota un error en ejecucion.
			//throw new com.kms.katalon.core.exception.StepFailedException("Addon Insurance was not found!");
			KeywordUtil.markWarning("Addon Insurance was not found!");
		}
		else
		{
			//$($("#divShuttles").find("input[type='radio']").first()).click();
			//hace checked al seguro
			query = "\$(\"#shuttles\").find(\"input[type='radio']\").first().click()";
			WebUI.executeJavaScript(query, null);
			package_Utils.Logs.messageInfo("Addon Insurance Checked.");
		}
	}
	
}