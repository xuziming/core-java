package com.simon.credit.designpattern.proxy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyFileOutputStream extends FileOutputStream {

	public MyFileOutputStream(File file) throws FileNotFoundException {
		super(file);
	}

	public MyFileOutputStream(String filePath) throws FileNotFoundException {
		this(new File(filePath));
	}

	@Override
	public void close() throws IOException {
		super.close();
		System.out.println("关闭IO资源");
	}

}
