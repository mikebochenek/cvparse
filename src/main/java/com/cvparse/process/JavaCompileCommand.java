package com.cvparse.process;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaCompileCommand {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	public String compile(String dir, String name, String s) throws IOException {
		createdir(dir);
		write(dir, name, s);
		return executeCompile(dir, name, s);
	}
	
	public String compileAndTest(String dir, String name, String s, String testCode) throws IOException {
		createdir(dir);
		write(dir, name, s);
		executeCompile(dir, name, s);
		executeCompile(dir, name, testCode); //TODO, this should be one command...
		return null;
		
		//TODO like this?  http://www.vogella.com/articles/JUnit/article.html
	}

	private void createdir(String dir) {
		File dirFile = new File("/tmp/" + dir);
		if (!dirFile.exists()) {
			dirFile.mkdir();
		}
	}
	
	private void write(String dir, String name, String content) {
		String path = "/tmp/" + dir + "/" + name +".java";
		try {
			File file = new File(path);
			
			if (!file.exists()) { // if file doesn't exists, then create it
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

		} catch (IOException e) {
			logger.log(Level.SEVERE, "could not write " + path, e);
		}
	}
		
	private String executeCompile(String dir, String name, String s) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("javac", "/tmp/" + dir + "/" + name + ".java");
		pb.directory(new File("/tmp/" + dir));
		pb.redirectErrorStream(true);
		Process p = pb.start();
		assert p.getInputStream().read() == -1;

		InputStream stdout = p.getInputStream ();
		BufferedReader reader = new BufferedReader (new InputStreamReader(stdout));
		
		String retVal = "";
		String line = "";
		while ((line = reader.readLine ()) != null) {
			retVal += ("".equals(retVal) ? "" : "\n") + line;
		}
		
		return "".equals(retVal) ? "compiled successfully" : retVal;
	}
}
