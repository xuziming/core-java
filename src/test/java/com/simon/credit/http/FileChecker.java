package com.simon.credit.http;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

public class FileChecker {

	public static void main(String[] args) {
		File dir = new File("D:\\work\\eclipse-workspace\\spring-framework-4.3.18.RELEASE");
		recursiveRename(dir);
	}

	@SuppressWarnings("unused")
	private static void recursiveCheck(File file) {
		if (file.isFile()) {
			if (file.length() == 0) {
				System.out.println(file.getAbsolutePath());
				file.delete();
			}
			if (file.getName().contains("(1)")) {
				System.out.println(file.getAbsolutePath());
				file.delete();
			}
		} else if (file.isDirectory()) {
			File[] subFiles = file.listFiles();
			for (File subFile : subFiles) {
				recursiveCheck(subFile);
			}
		}
	}

	private static void recursiveRename(File file) {
		if (file.isFile()) {
			if (StringUtils.contains(file.getName(), "@SuppressWarnings(\"serial\")")) {
				String newFileName = StringUtils.remove(file.getName(), "@SuppressWarnings(\"serial\")");
				file.renameTo(new File(file.getParent() + File.separator + newFileName));
			}
		} else if (file.isDirectory()) {
			File[] subFiles = file.listFiles();
			for (File subFile : subFiles) {
				recursiveRename(subFile);
			}
		}
	}

}