package com.simon.credit.designpattern.proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 访客
 * @author XUZIMING 2019-10-16
 */
public class Visitor {

	public static void main(String[] args) {
		Boss proxy = cglibProxy(Boss.class, new Secretary());
		proxy.eatLunch();
	}

	/**
	 * 创建CGLIB代理类
	 * @param proxyTargetClass 被代理的目标类型(要求: 该对象类是某接口的实现)
	 * @param methodInterceptor 方法拦截器
	 * @return CGLIB代理类对象
	 */
	public static <T> T cglibProxy(Class<T> proxyTargetClass, MethodInterceptor methodInterceptor) {
		// 创建增强器类
		Enhancer enhancer = new Enhancer();
		// 设置代理目标
		enhancer.setSuperclass(proxyTargetClass);
		// 设置单一回调对象，在调用中拦截对目标方法的调用
		enhancer.setCallback(methodInterceptor);
		// 设置类加载器
		enhancer.setClassLoader(proxyTargetClass.getClassLoader());
		// 创建代理子类
		@SuppressWarnings("unchecked")
		T proxyInst = (T) enhancer.create();

		return proxyInst;
	}

}
