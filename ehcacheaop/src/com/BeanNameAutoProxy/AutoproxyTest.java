package com.BeanNameAutoProxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoproxyTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext-beanNameAutoProxy.xml");
		AutoBean bean1 = (AutoBean) ctx.getBean("foobean");
//		AutoBean bean2 = (AutoBean) ctx.getBean("barbean");
		bean1.add();
		bean1.update();
		//bean2.update();
	}
}
