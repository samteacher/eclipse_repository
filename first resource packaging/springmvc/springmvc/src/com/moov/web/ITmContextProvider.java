package com.moov.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ITmContextProvider {
	
	public HttpServletRequest getRequest();
	
	/**
	 * ���ϵͳ���·�� �磺F:\webapps\cms
	 * 
	 * @param path
	 *            ���Դ���մ�
	 * @return
	 */
	public String getApplicationRealPath(String path);

	/**
	 * ���Ӧ�þ�Ը�·��
	 * 
	 * @return
	 */
	public String getApplicationRoot();
	
	/**
	 * ���Ӧ�ú�׺
	 * 
	 * @return
	 */
	public String getApplicationSuffix();

	/**
	 * ���ϵͳ��·�� �磺/CmsSys
	 * 
	 * @return
	 */
	public String getApplicationContextPath();

	/**
	 * ���Ӧ�����
	 * 
	 * @return
	 */
	public String getServerName();
	
	/**
	 * ���Ӧ�ö˿ں�
	 * 
	 * @return
	 */
	public int getServerPort();
	
	/**
	 * ���Ӧ������
	 * 
	 * @return
	 */
	public String getDomain();
	
	public String getDomain(HttpServletRequest request);
	
	/**
	 * ע��
	 * 
	 * @return
	 */
	public void logout();

	/**
	 * ���response
	 * 
	 * @return
	 */
	public HttpServletResponse getResponse();

	/**
	 * ��Request��Attribute�л�ȡֵ
	 * 
	 * @param key
	 * @return
	 */
	public Object getRequestAttribute(String key);

	/**
	 * ��Request��Attribute�и�ֵ
	 * 
	 * @param key
	 * @param value
	 */
	public void setRequestAttribute(String key, Object value);

	/**
	 * ��SESSION�л��ֵ
	 * 
	 * @param key
	 * @return
	 */
	public Object getSessionAttribute(String key);

	/**
	 * ��session��ֵ
	 * 
	 * @param key
	 * @param value
	 */
	public void setSessionAttribute(String key, Object value);

	/**
	 * �Ƴ�session�е�����
	 * 
	 * @param key
	 */

	public void removeAttribute(String key);
	public Object getApplicationAttribute(String key);

	public void setApplicationAttribute(String key, Object value);

	/**
	 * ���sessionId
	 * 
	 * @param isCreate
	 *            ���session�������Ƿ񴴽�
	 * @return
	 */
	public String getSessionId(boolean isCreate);

	/**
	 * ��÷�����IP
	 * 
	 * @return
	 */
	public String getRemoteIp();

	/**
	 * ��÷�����PORT
	 * 
	 * @return
	 */
	public int getRemotePort();

	/**
	 * ��÷�����URL
	 * 
	 * @return
	 */
	public String getRequestURL();
	
	/**
	 * ��÷�����URI
	 * 
	 * @return
	 */
	public String getRequestURI();

	/**
	 * ��÷����������
	 * 
	 * @return
	 */
	public String getRequestBrowser();

	/**
	 * ��÷����߲���ϵͳ
	 * 
	 * @return
	 */
	public String getRequestOs();

	/**
	 * ��÷����ߵĴ���ȫ����Ϣ
	 * 
	 * @return
	 */
	public String getRequestUserAgent();

	/**
	 * ���cookie
	 * 
	 * @param cookie
	 */
	public void addCookie(Cookie cookie);

	/**
	 * ��ȡcookie
	 * 
	 * @param name
	 * @return
	 */
	public Cookie getCookie(String name);

	/**
	 * �Ƿ���post����
	 * 
	 * @return
	 */
	public boolean isMethodPost();
	
}
