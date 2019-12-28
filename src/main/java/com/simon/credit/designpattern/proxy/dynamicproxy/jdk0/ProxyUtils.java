package com.simon.credit.designpattern.proxy.dynamicproxy.jdk0;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;

import com.simon.credit.designpattern.proxy.dynamicproxy.jdk.RealStar;

import sun.misc.ProxyGenerator;

@SuppressWarnings("restriction")
public class ProxyUtils {

	/**
	 * 将根据类信息 动态生成的二进制字节码保存到硬盘中， 默认的是clazz目录下
	 * 
	 * @param clazz          需要生成动态代理类的类
	 * @param proxyClassName 动态生成的代理类名称
	 */
	public static void generateClassFile(Class<?> clazz, String proxyClassName) {
		// 根据类信息和提供的代理类名称，生成字节码
		byte[] classFile = ProxyGenerator.generateProxyClass(proxyClassName, clazz.getInterfaces());
		String path = clazz.getResource(".").getPath();

		try (FileOutputStream out = new FileOutputStream(path + proxyClassName + ".class")) {
			// 保留到硬盘中
			out.write(classFile);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void generateProxyClass(Class<?> clazz, String proxyClassName) {
		// 根据类信息和提供的代理类名称，生成字节码
		byte[] proxyClassCodes = ProxyGenerator.generateProxyClass(proxyClassName, clazz.getInterfaces());

		String dir = clazz.getResource(".").getPath();// 获取被代理类所在的目录
		File proxyClassFile = new File(dir + File.separator + proxyClassName + ".class");

		try {
			FileUtils.writeByteArrayToFile(proxyClassFile, proxyClassCodes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		generateClassFile(RealStar.class, "RealStarProxy3");
	}

}