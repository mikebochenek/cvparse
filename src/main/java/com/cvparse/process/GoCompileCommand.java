package com.cvparse.process;

import java.io.IOException;
import java.util.logging.Logger;

public class GoCompileCommand extends GenericCompileCommand {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	public String compile(String dir, String name, String s) throws IOException {
		createdir(dir);
		write(dir, name, s, "go");
		return executeCompile(dir, "go", "build");
	}
	
	public String compileAndTest(String dir, String name, String s, String testCode) throws IOException {
		return null;
	}


}
