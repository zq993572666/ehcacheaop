package com.BeanNameAutoProxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAdvice implements MethodInterceptor {

	 @Override
	 public Object invoke(MethodInvocation invokes) throws Throwable {
	  // TODO Auto-generated method stub
	  System.out.println("提前了");
	  return invokes.proceed();
	 }

	}