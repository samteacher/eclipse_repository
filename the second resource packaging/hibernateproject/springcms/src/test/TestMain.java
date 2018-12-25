package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain<T extends Object> {

	
	/**
	 * 根据配置文件获取对应的bean对象
	 * 方法名：getBean<BR>
	 * 创建人：潭州学院-keke <BR>
	 * 时间：2015年1月17日-下午11:55:05 <BR>
	 * @param beanXml
	 * @param beanId
	 * @return T<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public T getBean(String beanXml,String beanId){
		ApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
		T t = (T)context.getBean(beanId);
		return t;
	}
	
	public T getBean(String beanId){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		T t = (T)context.getBean(beanId);
		return t;
	}
}
