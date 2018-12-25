package com.tz.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TmWeatherUtil {
	// private static final long serialVersionUID = 1L;

	private static String SERVICES_HOST = "www.webxml.com.cn";// 主机

	private static String WEATHER_SERVICES_URL = "http://webservice.webxml.com.cn/WebServices/WeatherWS.asmx/";
	// 获得中国省份、直辖市、地区和与之对应的ID
	private static String PROVINCE_CODE_URL = WEATHER_SERVICES_URL
			+ "getRegionProvince";
	// 获得支持的城市/地区名称和与之对应的ID
	// 输入参数：theRegionCode = 省市、国家ID或名称，返回数据：一维字符串数组。
	private static String CITY_CODE_URL = WEATHER_SERVICES_URL
			+ "getSupportCityString?theRegionCode=";
	// 获取天气
	private static String WEATHER_QUERY_URL = WEATHER_SERVICES_URL
			+ "getWeather?theUserID=&theCityCode=";
	
	public static void main(String[] args) {
		List<String> strings = TmWeatherUtil.getWeather(1665);
		System.out.println(strings);
	}

	/**
	 * 1、打开服务器主机
	 * 
	 * @param url
	 * @return
	 */
	public static InputStream getSoapInputStream(String url) {
		InputStream inputStream = null;

		try {
			URL urlObj = new URL(url);
			URLConnection urlConn = urlObj.openConnection(); // 打开连接
			urlConn.setRequestProperty("Host", SERVICES_HOST); // 通过地址访问主机
			urlConn.connect();
			inputStream = urlConn.getInputStream();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputStream;
	}

	/**
	 * 获取省份编码
	 * 
	 * @param provinceName
	 *            省份的汉字
	 * @return
	 */
	public static int getProinceCode(String provinceName) {

		Document document;
		int provinceCode = 0; // 省份的编码

		// 得到 DOM 解析器的工厂实例
		DocumentBuilderFactory documentBF = DocumentBuilderFactory
				.newInstance();
		documentBF.setNamespaceAware(true);

		try {
			DocumentBuilder documentB = documentBF.newDocumentBuilder();// 从DOM工厂获得DOM解析器
			// 把要解析的xml 文档转化为输入流，以便dom解析器解析它
			InputStream inputSteam = getSoapInputStream(PROVINCE_CODE_URL);
			// 解析xml文档的输入流，得到一个 document
			document = documentB.parse(inputSteam);

			NodeList nodeList = document.getElementsByTagName("string"); // 解析xml文件里的标签

			int len = nodeList.getLength();

			for (int i = 0; i < len; i++) {
				Node n = nodeList.item(i);
				String result = n.getFirstChild().getNodeValue();
				String[] address = result.split(",");
				String pName = address[0];
				String pCode = address[1];
				if (provinceName.equals(pName)) {
					provinceCode = Integer.parseInt(pCode);
				}
			}
			inputSteam.close();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return provinceCode;// 省份的id
	}

	/**
	 * 获取市级 编码
	 * 
	 * @param provinceCode
	 *            省份的编码
	 * @param cityName
	 *            城市中文名称
	 * @return 城市的编号
	 */
	public static int getCityCode(int provinceCode, String cityName) {
		int cityCode = 0;

		Document doc;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);

		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputStream js = getSoapInputStream(CITY_CODE_URL + provinceCode);
			doc = db.parse(js);

			NodeList nl = doc.getElementsByTagName("string");
			int len = nl.getLength();
			for (int i = 0; i < len; i++) {
				Node n = nl.item(i);
				String result = n.getFirstChild().getNodeValue();
				String[] address = result.split(",");
				String cName = address[0];
				String cCode = address[1];

				if (cName.equalsIgnoreCase(cityName)) {
					cityCode = Integer.parseInt(cCode);
				}
			}
			js.close();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return cityCode;
	}

	/**
	 * 获取最近五天的天气
	 * 
	 * @param cityCode
	 * @return
	 */
	public static List<String> getWeathers(int cityCode) {

		List<String> weatherList = new ArrayList<String>();

		Document document;
		DocumentBuilderFactory documentBF = DocumentBuilderFactory
				.newInstance();
		documentBF.setNamespaceAware(true);

		try {
			DocumentBuilder db = documentBF.newDocumentBuilder();

			InputStream inputStream = getSoapInputStream(WEATHER_QUERY_URL
					+ cityCode);
			document = db.parse(inputStream);

			NodeList nl = document.getElementsByTagName("string");
			int len = nl.getLength();
			for (int i = 0; i < len; i++) {
				Node n = nl.item(i);
				String weather = n.getFirstChild().getNodeValue();
				weatherList.add(weather);
			}
			inputStream.close();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return weatherList;
	}

	public static List<String> getWeather(int cityCode) {

		List<String> weatherList = new ArrayList<String>();

		Document document;
		DocumentBuilderFactory documentBF = DocumentBuilderFactory
				.newInstance();
		documentBF.setNamespaceAware(true);

		try {
			DocumentBuilder db = documentBF.newDocumentBuilder();

			InputStream inputStream = getSoapInputStream(WEATHER_QUERY_URL
					+ cityCode);
			document = db.parse(inputStream);

			NodeList nl = document.getElementsByTagName("string");
			int len = nl.getLength();
			for (int i = 0; i < 12; i++) {
				Node n = nl.item(i);
				if (n != null) {
					String weather = n.getFirstChild().getNodeValue();
					weatherList.add(weather);
				}
			}
			inputStream.close();
		} catch (ParserConfigurationException e) {
		} catch (SAXException e) {
		} catch (IOException e) {
		}

		return weatherList;
	}

	public static String del(String fString) {
		char[] ch = fString.toCharArray();
		String fch = "";
		for (int i = 0; i < ch.length; i++) {
			if (String.valueOf(ch[i]).equals("日")) {
				for (int k = i + 1; k < ch.length; k++) {
					fch += String.valueOf(ch[k]);
				}
				break;
			}
		}
		return fch;

	}

}
