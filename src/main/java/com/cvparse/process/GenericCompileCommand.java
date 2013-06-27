package com.cvparse.process;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenericCompileCommand {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	protected void createdir(String dir) {
		File dirFile = new File("/tmp/" + dir);
		if (!dirFile.exists()) {
			dirFile.mkdir();
		}
	}
	
	protected void write(String dir, String name, String content, String extension) {
		String path = "/tmp/" + dir + "/" + name + "." + extension;
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
		
	protected String executeCompile(String dir, String command, String params) throws IOException {
		ProcessBuilder pb = new ProcessBuilder(command, params);
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
