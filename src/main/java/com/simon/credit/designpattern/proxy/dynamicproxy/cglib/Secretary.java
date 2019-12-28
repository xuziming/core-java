package com.simon.credit.designpattern.proxy.dynamicproxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 秘书
 * @author XUZIMING 2019-10-16
 */
public class Secretary implements MethodInterceptor {

	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("预约时间");
		Object result = proxy.invokeSuper(obj, args);
		System.out.println("备注访客");
		return result;
	}

}
