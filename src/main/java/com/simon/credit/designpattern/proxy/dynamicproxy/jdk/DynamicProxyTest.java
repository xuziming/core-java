package com.simon.credit.designpattern.proxy.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {

	public static void main(String[] args) {
		// 创建被代理的对象
		Star star = new RealStar();

		// 方法调用请求处理器，处理所有的代理对象上的方法调用
		InvocationHandler invocationHandler = new StarHandler(star);

		Star proxyStar = jdkProxy(star, invocationHandler);
		proxyStar.sing();
	}

	/**
	 * 创建JDK代理类
	 * @param proxyTarget 被代理的目标对象(要求: 该对象类是某接口的实现)
	 * @param invocationHandler 代理处理器
	 * @return
	 */
	public static <T> T jdkProxy(Object proxyTarget, InvocationHandler invocationHandler) {
		// 1.获取对应的ClassLoader
		ClassLoader classLoader = proxyTarget.getClass().getClassLoader();

		// 2.获取所有接口
		Class<?>[] interfaces = proxyTarget.getClass().getInterfaces();

		// 3.设置一个来自代理传过来的方法调用请求处理器，处理所有的代理对象上的方法调用
		InvocationHandler handler = invocationHandler;

		/*
		 * 4.根据上面提供的信息，创建代理对象. 在这个过程中， 
		 * a.JDK会根据传入的参数信息动态地在内存中创建与.class文件等同的字节码
		 * b.然后根据相应的字节码转换成对应的class， 
		 * c.然后调用newInstance()创建实例
		 */
		@SuppressWarnings("unchecked")
		T jdkProxy = (T) Proxy.newProxyInstance(classLoader, interfaces, handler);

		return jdkProxy;
	}

}