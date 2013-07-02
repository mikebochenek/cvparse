package com.cvparse.process;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class GoCompileCommandTest {

	@Test
	public void testCompile() throws IOException {
		GoCompileCommand c = new GoCompileCommand();
		String out = c.compile("go_"+System.currentTimeMillis(), "test", code);
		assertEquals(c.SUCCESS, out);
	}

	@Test
	public void testCompileAndTest() {
		//TODO fail("Not yet implemented");
	}

	final static String code =
			"package main\n"
			+ "import \"fmt\"\n"
			+ "func main() {\n"
			+ "  fmt.Printf(\"hello, world\")\n"
			+ "}\n";
}
