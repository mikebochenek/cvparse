package com.cvparse.tools;

import java.io.IOException;

import com.cvparse.process.JavaCompileCommand;

public class JavaCompileCommandLine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UnusedDirectoryOperationCommand ctd = new UnusedDirectoryOperationCommand();
		
		JavaCompileCommand jc = new JavaCompileCommand();
		try {
			String out1 = ctd.createDirectory("j90320930932");

			String output = jc.compile("test332", "Test", code);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	final static String code = 
			"  public class Test { \n" +
			"    public static void main(String[] args) { \n" +
			"       System.out.println(2); \n" +
			"    } \n" +
			"  }";
}
