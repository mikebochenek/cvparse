package com.cvparse.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UnusedDirectoryOperationCommand {

	private static final String tmpDirectory = "/tmp/";

	public String createDirectory(String s) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("mkdir", s);
		pb.directory(new File(tmpDirectory));
		pb.redirectErrorStream(true);
		Process p = pb.start();

		//InputStream stdout = p.getInputStream ();
		//BufferedReader reader = new BufferedReader (new InputStreamReader(stdout));
		
		/* we should have better error handling, but then again, we are doing mkdir only...
		String retVal = "";
		String line = "";
		while ((line = reader.readLine ()) != null) {
			retVal += ("".equals(retVal) ? "" : "\n") + line;
		} */
		
		return null;
	}	
}
