package com.cvparse.process;

import java.io.IOException;
import java.util.logging.Logger;

public class JavaCompileCommand extends GenericCompileCommand {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	public String compile(String dir, String name, String s) throws IOException {
		createdir(dir);
		write(dir, name, s, "java");
		return executeCompile(dir, "javac", "/tmp/" + dir + "/" + name + ".java");
	}
	
	public String compileAndTest(String dir, String name, String s, String testCode) throws IOException {
		createdir(dir);
		write(dir, name, s, "java");
		executeCompile(dir, "javac", "/tmp/" + dir + "/" + name + ".java");
		//executeCompile("javac", "/tmp/" + dir + "/" + name + ".java"); //TODO, this should be one command...
		return null;
		
		//TODO like this?  http://www.vogella.com/articles/JUnit/article.html
	}
		

}
