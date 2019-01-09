package package_DailyCheck_TC02_Ajax_Ktravel

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

/** Clase que contiene los métodos para realizar una búsqueda en
 * el servicio de "Paquetes" de KTravel.
 *
 * @author NGPDDT009243 Eduardo Hidalgo Díaz Rugama
 * @date 06/08/18
 *
 */
public class packageSearch 
{
    static String flow = "/Paquetes/busqueda?";
	
	/** Crea la URL de busqueda de Paquetes.
	 * 
	 * @param domain dominio al que se desea apuntar
	 * @param affiliate asociado (solo admite asociados KTravel)
	 */
	@Keyword
	public String CrearURL(String domain, String affiliate)
	{
		//Concatenación de la Url con sus Argumentos
		String Url = WebUI.concatenate(
			domain, flow,
			"af=", affiliate
			)
		
		//Mensajes de Debug
		String message = WebUI.concatenate("URL: ", Url)
		package_Utils.Logs.messageInfo(message)		

		return Url;
	}
	
	/** Abre una ventana nueva del explorador, la maximiza, y navega a la URL objetivo.
	 * 
	 * @param url dirección web a navegar
	 * */
	@Keyword
	public void NavegarURL(String url)
	{
		//Abre un nuevo navegador, lo maximiza, y navega la url objetivo
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(url)
	
		//Validacion -> si la página no carga produce un error
		WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)
		//tiempo de espera del loader de kaleido
		WebUI.delay(3);
		//Validacion -> si existe algún elemento de la página para validar errores al cargar la página
		WebUI.verifyElementPresent(findTestObject('DailyCheck/TC02_Ajax Ktravel/Busqueda/a_Paquetes'), 4, FailureHandling.STOP_ON_FAILURE)
		WebUI.takeScreenshot()
	}

	/** Método que selecciona un origen del Textbox "Origen", usando su AJAX
	 *
	 * @param origen IATA del origen
	 * @param origenText Texto a comparar del origen
	 */
    @Keyword
    public void SelectOrigen(String origen, String origenText)
    {
        //Codigo JS para insertar texto de busqueda en el AJAX de Origen
        //$('#EtCityOrig').val("mex")
		String query = WebUI.concatenate("\$(\'#EtCityOrig\').val(\"", origen, "\")");		
		//Ejecucion de JS
		WebUI.executeJavaScript(query, null);

        //Código JS para hacer trigger al AJAX de Origen
        //$('#EtCityOrig').keydown()
        query = "\$(\'#EtCityOrig\').keydown()";
        //Ejecucion de JS
		WebUI.executeJavaScript(query, null);
		WebUI.delay(3);

        //Código JS para detectar cuantos resultados trajo el AJAX
        //$('#ui-id-1').find(".ui-menu-item").length
        query = "return \$(\'#ui-id-1\').find(\".ui-menu-item\").length";
        //Ejecucion de JS
		String length = WebUI.executeJavaScript(query, null);

		//Si obtuvo cero botones, arroja un error
		if ( length.equalsIgnoreCase("0")  || length.isEmpty())
		{
			WebUI.takeScreenshot()
			//Excepcion que rompe el caso de prueba y denota un error en ejecucion.
			throw new com.kms.katalon.core.exception.StepFailedException("AJAX Origen doesn't found results! CRITICAL AJAX ERROR");
		}
		else
		{
			//Mensaje de debug
			String message = WebUI.concatenate("AJAX Origen results Detected: ", length)
			package_Utils.Logs.messageInfo(message)

            //Código JS para obtener el texto del resultado seleccionado. esto obtiene el primer resultado.
            //query = "return $($($('#ui-id-1').find(".ui-menu-item")[0])).find("span")[0].innerText";
						
			//Código JS para obtener el texto del resultado según un resultado esperado concreto
			//$($('#ui-id-1').find(".ui-menu-item").find("span:contains('mex')")).text()");
			//Si origenText no está seteado, compara contra la IATA inicial
			if(!origenText.isEmpty())
				query = WebUI.concatenate("return \$(\$(\'#ui-id-1\').find(\".ui-menu-item\").find(\"span:contains(\'", origenText, "\')\")).text()");
			else
				query = WebUI.concatenate("return \$(\$(\'#ui-id-1\').find(\".ui-menu-item\").find(\"span:contains(\'", origen, "\')\")).text()");
				
            String origenData = WebUI.executeJavaScript(query, null);
			
			if(origenData.equalsIgnoreCase("No se encontraron resultados"))
			{
				WebUI.takeScreenshot()
				//Excepcion que rompe el caso de prueba y denota un error en ejecucion.
				throw new com.kms.katalon.core.exception.StepFailedException("AJAX Origen doesn't found results!");
			}
			
            //Mensaje de debug
			message = WebUI.concatenate("AJAX Origen result Selected: ", origenData)
			package_Utils.Logs.messageInfo(message)

			WebUI.takeScreenshot()

            //Código JS para seleccionar un resultado del AJAX de Origen
            query = "\$(\$(\'#ui-id-1\').find(\".ui-menu-item\")[0]).click()";
			//Hace click en el boton dado que si existe y avanza al checkout1
			WebUI.executeJavaScript(query, null);
		}
    }

	/** Método que selecciona un destino del Textbox "Destino", usando su AJAX
	 *
	 * @param destino IATA del destino
	 * @param destinoText Texto a comparar del destino
	 */
    @Keyword
    public void SelectDestino(String destino , String destinoText)
    {
        //Codigo JS para insertar texto de busqueda en el AJAX de Destino
        //$('#EtDestinyHtl').val("mex")
		String query = WebUI.concatenate("\$(\'#EtDestinyHtl\').val(\"", destino, "\")");
		//Ejecucion de JS
		WebUI.executeJavaScript(query, null);

        //Código JS para hacer trigger al AJAX de Destino
        //$('#EtDestinyHtl').keydown()
        query = "\$(\'#EtDestinyHtl\').keydown()";
        //Ejecucion de JS
		WebUI.executeJavaScript(query, null);
		WebUI.delay(3);

        //Código JS para detectar cuantos resultados trajo el AJAX
        //$('#ui-id-2').find(".ui-menu-item").length
        query = "return \$(\'#ui-id-2\').find(\".ui-menu-item\").length";
        //Ejecucion de JS
		String length = WebUI.executeJavaScript(query, null);

		//Si obtuvo cero botones, arroja un error
		if ( length.equalsIgnoreCase("0") || length.isEmpty())
		{
			WebUI.takeScreenshot()
			//Excepcion que rompe el caso de prueba y denota un error en ejecucion.
			throw new com.kms.katalon.core.exception.StepFailedException("AJAX Destino doesn't found results! CRITICAL AJAX ERROR");
		}
		else
		{
			//Mensaje de debug
			String message = WebUI.concatenate("AJAX Destino results Detected: ", length)
			package_Utils.Logs.messageInfo(message)

               //Código JS para obtener el texto del resultado seleccionado. esto obtiene el primer resultado.
            //query = "return \$(\$(\$(\'#ui-id-2\').find(\".ui-menu-item\")[0])).find(\"span\")[0].innerText";
						
			//Código JS para obtener el texto del resultado según un resultado esperado concreto
			//Si destinoText no está seteado, compara contra la IATA inicial
			if(!destinoText.isEmpty())
				query = WebUI.concatenate("return \$(\$(\'#ui-id-2\').find(\".ui-menu-item\").find(\"span:contains(\'", destinoText, "\')\")).text()");
			else
				query = WebUI.concatenate("return \$(\$(\'#ui-id-2\').find(\".ui-menu-item\").find(\"span:contains(\'", destino, "\')\")).text()");
			
            String destinoData = WebUI.executeJavaScript(query, null);
			
			if(destinoData.equalsIgnoreCase("No se encontraron resultados"))
			{
				WebUI.takeScreenshot()
				//Excepcion que rompe el caso de prueba y denota un error en ejecucion.
				throw new com.kms.katalon.core.exception.StepFailedException("AJAX Destino doesn't found results!");
			}
			
            //Mensaje de debug
			message = WebUI.concatenate("AJAX Destino result Selected: ", destinoData)
			package_Utils.Logs.messageInfo(message)

			WebUI.takeScreenshot()

            //Código JS para seleccionar un resultado del AJAX de Destino
            query = "\$(\$(\'#ui-id-2\').find(\".ui-menu-item\")[0]).click()";
			//Hace click en el boton dado que si existe y avanza al checkout1
			WebUI.executeJavaScript(query, null);
		}
    }
	
	/** Realiza la cotización con los parámetros elegidos en la caja de búsqueda. Valida que llegue a la lista.
	 */
	@Keyword
	public void ClickSearchButton()
	{
		//Código JS para seleccionar un resultado del AJAX de Destino
		String query = "\$(\'#EtSearchPackages\').click();";
		//Hace click en el boton dado que si existe y avanza al checkout1
		WebUI.executeJavaScript(query, null);
		
		//Validacion -> si la página no carga produce un error
		WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)
		//tiempo de espera del loader de kaleido
		WebUI.delay(8);
		//Validacion -> si existe algún elemento de la página para validar errores al cargar la página
		WebUI.verifyElementPresent(findTestObject('DailyCheck/TC02_Ajax Ktravel/Lista/Nav_Paquetes'), 4, FailureHandling.STOP_ON_FAILURE)
		WebUI.takeScreenshot()
		WebUI.closeBrowser();
	}
}