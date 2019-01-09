package package_KTravel_Hotel_with_Addons

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
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.exception.StepErrorException
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

// implementation in Test Case
// package.keyword.function(parameters) just like that!

/** Clase que contiene los métodos para navegar Checkout1 en
 * el servicio de "Hoteles" de KTravel.
 *
 * @author NGPDDT009243 Eduardo Hidalgo Díaz Rugama
 * @date 23/05/18
 *
 */
public class Checkout1 {
	
	/** Avanza del Checkout1 al Checkout2.
	 */
	@Keyword
	public static Boolean AvanzarCheckout1()
	{
		//Codigo JS para obtener boton para avanzar al siguiente paso del checkout.
		String query = "return \$(\".EtRightPanel\").find(\"input[id='btnContinue']\").length";
		
		//Ejecucion de JS
		String length = WebUI.executeJavaScript(query, null);
		//Si obtuvo cero botones, arroja un error
		if ( length.equalsIgnoreCase("0"))
		{
			WebUI.takeScreenshot()
			//Excepcion que rompe el caso de prueba y denota un error en ejecucion.
			throw new com.kms.katalon.core.exception.StepErrorException("Checkout1 Page not Load or Working correctly!");
		
			return false;
		}
		else
		{
			// Añade los Addons que encuentra
			Boolean Shuttle = SetAddons()
			
			//Mensaje de debug
			String message = WebUI.concatenate("Checkout1 Button detected: Length: ", length)
			package_Utils.Logs.messageInfo(message)
			WebUI.takeScreenshot()
			//Hace click en el boton dado que si existe y avanza al checkout1
			WebUI.executeJavaScript("\$(\".EtRightPanel\").find(\"input[id='btnContinue']\").click()", null);
			//Validacion -> espera a que la pagina haya cargado correctamente
			WebUI.waitForPageLoad(5, FailureHandling.CONTINUE_ON_FAILURE)
			//tiempo de espera del loader de kaleido
			WebUI.delay(GlobalVariable.G_Delay);
			
			return Shuttle;
		}
	}
	
	/** Busca el primer Addon de cada servicio que encuentre.
	 * 	Levanta errores falsos en caso de no encontrar el Addon.
	 * 
	 */
	private static Boolean SetAddons() 
	{
		//tiempo de espera para saber que cargaron los ajax
		WebUI.delay(10)
		
		SetAddonInsurance();
		Boolean Shuttle = SetAddonShuttle();
		SetAddonCar();
		SetAddonTour();
		
		return Shuttle;		
	}
	
	/** Addon Seguros.
	 * 
	 */
	private static void SetAddonInsurance()
	{
		//Valida que existan los addons de seguros en este asociado
		String query = "return \$(\$(\"#divAssintancePrograms\").find(\"input[type='checkbox']\").first()).length";
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
			query = "\$(\$(\"#divAssintancePrograms\").find(\"input[type='checkbox']\").first()).click()";
			WebUI.executeJavaScript(query, null);
			package_Utils.Logs.messageInfo("Addon Insurance Checked.");
		}
	}
	
	/** Addon Traslado.
	 *
	 */
	private static Boolean SetAddonShuttle()
	{
		//Valida que existan los addons de traslados en este asociado
		String query = "return \$(\$(\"#divShuttles\").find(\"input[type='radio']\").first()).length;";
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
			
			return false;
		}
		else
		{
			//$($("#divShuttles").find("input[type='radio']").first()).click();
			//hace checked al seguro
			query = "\$(\$(\"#divShuttles\").find(\"input[type='radio']\").first()).click();";
			WebUI.executeJavaScript(query, null);
			package_Utils.Logs.messageInfo("Addon Insurance Checked.");
			
			return true;
		}
	}
	
	/** Addon Auto.
	 *
	 */
	private static void SetAddonCar()
	{
		//Valida que existan los addons de traslados en este asociado
		String query = "return \$(\$(\$(\"#divCars\").find(\".kdo--product-cars\")).find(\"input[type='button']\")[3]).length";
		//Ejecucion de JS
		String length = WebUI.executeJavaScript(query, null);
		
		package_Utils.Logs.messageInfo("Car Length: " + length);
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
			//$($("#divCars").find(".kdo--product-cars")).find("input[type='button']")[3].click()
			//hace checked al seguro
			query = "\$(\$(\"#divCars\").find(\".kdo--product-cars\")).find(\"input[type='button']\")[3].click()";
			WebUI.executeJavaScript(query, null);
			package_Utils.Logs.messageInfo("Addon Insurance Checked.");
		}
	}
	
	/** Addon Tour.
	 *
	 */
	private static void SetAddonTour()
	{
		//Valida que existan los addons de traslados en este asociado
		String query = "return \$(\$(\"#divTours\").find(\".btn\")[2]).length";
		//Ejecucion de JS
		String length = WebUI.executeJavaScript(query, null);
		
		package_Utils.Logs.messageInfo("Tour Length: " + length);
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
			//$("#divTours").find(".btn")[2].click()
			//hace checked al seguro
			query = "\$(\"#divTours\").find(\".btn\")[2].click()";
			WebUI.executeJavaScript(query, null);
			package_Utils.Logs.messageInfo("Addon Insurance Checked.");
		}
	}
	
}
