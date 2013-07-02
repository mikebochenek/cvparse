package com.cvparse.process;

import java.io.IOException;

import org.junit.Test;

import com.cvparse.process.JavaCompileCommand;
import com.cvparse.tools.UnusedDirectoryOperationCommand;

public class JavaCompileCommandLine {

	@Test
	public void main() {
		UnusedDirectoryOperationCommand ctd = new UnusedDirectoryOperationCommand();
		
		JavaCompileCommand jc = new JavaCompileCommand();
		try {
			ctd.createDirectory("j90320930932");
			jc.compile("test332", "Test", code);
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
