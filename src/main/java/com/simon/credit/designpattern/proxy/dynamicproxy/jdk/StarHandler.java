package com.simon.credit.designpattern.proxy.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler {

	private Star star;

	public StarHandler(Star star) {
		this.star = star;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("代理对象：" + proxy.getClass().getName());

		Object result = null;
		System.out.println("真正的方法执行前");
		System.out.println("面谈、签订合同、预付款、订机票");
		if ("sing".equals(method.getName())) {
			result = method.invoke(star, args);
		}
		System.out.println("真正的方法执行后");
		System.out.println("收尾款");
		return result;
	}

}
