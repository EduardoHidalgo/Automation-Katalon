package package_Mobile_TC10_Hotel_with_Addons

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
 * el servicio de "Hoteles" de KMobile.
 *
 * @author NGPDDT009243 Eduardo Hidalgo Díaz Rugama
 * @date 30/05/18
 *
 */
public class Busqueda
{
	static String flow = "/Hoteles/lista?";
	
	/** Crea la URL que realiza la búsqueda de la cotización y lleva a la lista.
	 *
	 * @param domain dominio al que se desea apuntar
	 * @param affiliate asociado (solo admite asociados KTravel)
	 * @param language Idioma
	 * @param currency Tipo de Moneda
	 * @param startDate Fecha de inicio de la cotización
	 * @param endDate Fecha de fin de la cotización
	 * @param coupon Variable que tiene el id de cupon
	 * @param destinationID Id del destino
	 * @param noRooms Numero de habitaciones
	 * @param adults1 Numero de Adultos1
	 * @param childrens1 Numero de Niños1
	 * @param ageChildren1 Edad de los Niños1
	 * @param adults2 Numero de Adultos2
	 * @param childrens2 Numero de Niños2
	 * @param ageChildren2 Edad de los Niños2
	 * @param adults3 Numero de Adultos3
	 * @param childrens3 Numero de Adultos3
	 * @param ageChildren3 Edad de los Niños3
	 * @param adults4 Numero de Adultos4
	 * @param childrens4 Numero de Adultos4
	 * @param ageChildren4 Edad de los Niños4
	 * @param adults5 Numero de Adultos5
	 * @param childrens5 Numero de Adultos5
	 * @param ageChildren5 Edad de los Niños5
	 * @param trafficSource Id utilizado para identificar origen de las apps
	 * @param deviceId Id utilizado para identificar dispositivo de las apps
	 * @param cityName Nombre de la ciudad
	 * @param orderList Orden de la lista por categoria, modelo o precio
	 * @param sortList Ordenar lista asc o desc
	 * @param records Cantidad de records a devolver
	 * @param noPage Numero de paginas
	 * @param filterOptions Filtros avanzados
	 * @return retorna la URL construida para ser navegada
	 */
	@Keyword
	public String CrearURL(String domain, String affiliate, String language, String currency, String startDate,
		String endDate, String coupon, String destinationID, String noRooms, String adults1, String childrens1,
		String ageChildren1, String adults2, String childrens2, String ageChildren2, String adults3, String childrens3,
		String ageChildren3, String adults4, String childrens4, String ageChildren4, String adults5, String childrens5,
		String ageChildren5, String trafficSource, String deviceId, String cityName, String orderList, String sortList,
		String records, String noPage, String filterOptions)
	{
		//Concatenación de la Url con sus Argumentos
		String Url = WebUI.concatenate(
			domain, flow,
			"GAProd=HT",
			"&af=", affiliate,
			"&ln=", language,
			"&cu=", currency,
			"&sd=", startDate,
			"&ed=", endDate,
			"&cou=", coupon,
			"&ds=", destinationID,
			"&rm=", noRooms,
			"&ad1=", adults1,
			"&ch1=", childrens1,
			"&ac1=", ageChildren1,
			"&ad2=", adults2,
			"&ch2=", childrens2,
			"&ac2=", ageChildren2,
			"&ad3=", adults3,
			"&ch3=", childrens3,
			"&ac3=", ageChildren3,
			"&ad4=", adults4,
			"&ch4=", childrens4,
			"&ac4=", ageChildren4,
			"&ad5=", adults5,
			"&ch5=", childrens5,
			"&ac5=", ageChildren5,
			"&ot=", trafficSource,
			"&di=", deviceId,
			"&cin=", cityName,
			"&ol=", orderList,
			"&sl=", sortList,
			"&rc=", records,
			"&pg=", noPage,
			"&fos=", filterOptions
			)
		
		//Mensajes de Debug
		String message = WebUI.concatenate("URL: ", Url)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("domain: ", domain)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("language: ", language)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("currency: ", currency)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("startDate: ", startDate)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("endDate: ", endDate)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("coupon: ", coupon)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("destinationID: ", destinationID)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("noRooms: ", noRooms)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("adults1: ", adults1)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("childrens1: ", childrens1)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("ageChildren1: ", ageChildren1)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("adults2: ", adults2)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("childrens2: ", childrens2)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("ageChildren2: ", ageChildren2)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("adults3: ", adults3)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("childrens3: ", childrens3)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("ageChildren3: ", ageChildren3)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("adults4: ", adults4)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("childrens4: ", childrens4)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("ageChildren4: ", ageChildren4)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("adults5: ", adults5)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("childrens5: ", childrens5)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("ageChildren5: ", ageChildren5)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("trafficSource: ", trafficSource)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("deviceId: ", deviceId)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("cityName: ", cityName)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("orderList: ", orderList)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("sortList: ", sortList)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("records: ", records)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("noPage: ", noPage)
		package_Utils.Logs.messageInfo(message)
		message = WebUI.concatenate("filterOptions: ", filterOptions)
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
		WebUI.waitForPageLoad(10, FailureHandling.CONTINUE_ON_FAILURE)
		//tiempo de espera del loader de kaleido
		WebUI.delay(5);
		//Validacion -> si existe algún elemento de la página para validar errores al cargar la página
		WebUI.verifyElementPresent(findTestObject('KMobile/TC10_KMobile Hotel Quote with Addons/Lista/div_verificar'), 4, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.takeScreenshot()
	}
}