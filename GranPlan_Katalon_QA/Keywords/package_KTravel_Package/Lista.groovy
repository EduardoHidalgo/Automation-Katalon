package package_KTravel_Package

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


/** Clase que contiene los métodos para navegar a través de la lista de kaleido
 * en el servicio de paquetes y elegir un hotel.
 *
 * @author NGPDDT009243 Eduardo Hidalgo Díaz Rugama
 * @date 24/05/18
 *
 */
public class Lista
{
	
	/** Selecciona el primer paquete que encuentra en la lista. si no encuentra arroja
	 * una excepción.
	 * 
	 */
	@Keyword
	public void SeleccionarPaquete()
	{	
		//Validacion -> espera a que la pagina haya cargado correctamente
		WebUI.waitForPageLoad(5, FailureHandling.CONTINUE_ON_FAILURE)
		//tiempo de espera del loader de kaleido
		WebUI.delay(5);

		//Codigo JS para obtener el primer boton de reserva de hotel.
		String query = "return \$(\$('.Package').first()).find('input[type=\"button\"]').length";
		
		//Ejecucion de JS
		String length = WebUI.executeJavaScript(query, null);
		//Si obtuvo cero botones, arroja un error
		if ( length.equalsIgnoreCase("0"))
		{
			WebUI.takeScreenshot()
			//Excepcion que rompe el caso de prueba y denota un error en ejecucion.
			throw new com.kms.katalon.core.exception.StepFailedException("Package Not Found! Length: " + length);
		}
		else
		{
			//Mensaje de debug
			String message = WebUI.concatenate("Package detected: Length: ", length)
			package_Utils.Logs.messageInfo(message)
			WebUI.takeScreenshot()
			//Hace click en el boton dado que si existe y avanza al checkout1
			WebUI.executeJavaScript("\$(\$('.Package').first()).find('input[type=\"button\"]').click()", null);
			//Validacion -> espera a que la pagina haya cargado correctamente
			WebUI.waitForPageLoad(5, FailureHandling.CONTINUE_ON_FAILURE)
			//tiempo de espera del loader de kaleido
			WebUI.delay(GlobalVariable.G_Delay);
		}
	}
}
