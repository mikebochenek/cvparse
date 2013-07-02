package com.cvparse.process;

import java.io.IOException;

import static junit.framework.Assert.*;

import org.junit.Test;

import com.cvparse.process.JavaCompileCommand;

public class JavaCompileCommandTest {

	@Test
	public void main() throws IOException {
		JavaCompileCommand jc = new JavaCompileCommand();
		String actual = jc.compile("java_"+System.currentTimeMillis(), "Test", code);
		assertEquals(jc.SUCCESS, actual);
	}

	final static String code = 
			"  public class Test { \n" +
			"    public static void main(String[] args) { \n" +
			"       System.out.println(2); \n" +
			"    } \n" +
			"  }";
}
