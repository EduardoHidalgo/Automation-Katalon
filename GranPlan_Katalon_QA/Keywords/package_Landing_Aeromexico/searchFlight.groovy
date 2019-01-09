package package_Landing_Aeromexico

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
 * el servicio de "Paquetes" de la Landing Aeroméxico.
 *
 * @author NGPDDT009243 Eduardo Hidalgo Díaz Rugama
 * @date 06/08/18
 *
 */
public class searchFlight 
{
	static String flow = "https://aeromexico.com/";
	
	/** Crea la URL para navegar en la Landing de Aeromexico.
	 * 
	 * @param internationalization idioma y país de búsqueda
	 * @return retorna la URL construida para ser navegada
	 */
	@Keyword
	public String CrearURL(String internationalization)
	{
		String Url = WebUI.concatenate(
			flow,
			internationalization
			)
		
		//Mensajes de Debug
		String message = WebUI.concatenate("URL: ", Url)
		
		return Url;
	}
	
	@Keyword
	public String CrearURL()
	{
		
	}
}
