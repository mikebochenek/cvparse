/*
 * Copyright (c) 2013 Michael Bochenek 
 */
package com.cvparse.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

/**
 * http://poi.apache.org/hwpf/quick-guide.html
 * 
 * Basic Text Extraction
 * 
 * For basic text extraction, make use of
 * org.apache.poi.hwpf.extractor.WordExtractor. It accepts an input stream or a
 * HWPFDocument. The getText() method can be used to get the text from all the
 * paragraphs, or getParagraphText() can be used to fetch the text from each
 * paragraph in turn. The other option is getTextFromPieces(), which is very
 * fast, but tends to return things that aren't text from the page. YMMV
 * 
 */
public class TryApachePOI {

	public static void main(String args[]) throws FileNotFoundException, IOException {

		File docFile = new File("c:\\multi\\multi.doc"); 
		
		//ByteArrayInputStream stream = new ByteArrayInputStream(buf);
		
		FileInputStream finStream = new FileInputStream(docFile.getAbsolutePath()); 
		HWPFDocument doc = new HWPFDocument(finStream);
		WordExtractor wordExtract = new WordExtractor(doc); 
		String[] dataArray = wordExtract.getParagraphText();
		// dataArray stores the each line from the document
		for (int i = 0; i < dataArray.length; i++) {
			System.out.println("\n–" + dataArray[i]);
		}
		finStream.close(); 
	}
}
