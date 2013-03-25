package com.cvparse;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.pdfbox.io.RandomAccessBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

import com.cvparse.ejb.FileUploadEJB;
import com.cvparse.entity.FileUpload;

@ManagedBean
@RequestScoped
public class TextBean {
	private Logger logger = Logger.getLogger(this.getClass().getName());

    @EJB
    private FileUploadEJB fileUploadEjb;
	
    private long id = 0;

	public String getText() {
		long startTS = System.currentTimeMillis();
		
		if (id == 0) return null;
		
		FileUpload fu = fileUploadEjb.load(id);
		
		if (fu == null) return "could not load id:" + id;
		
		logger.finer(fu.getId() + " created on: " + fu.getCreateDate());
		
		String s = null;
		if (fu.getFilename().endsWith(".pdf")) {
			s = extractPDFText(fu.getData());
		}
		if (fu.getFilename().endsWith(".doc")) {
			s = extractWordText(fu.getData());
		}
		
		logger.info ("extracted text ms: " + (System.currentTimeMillis() - startTS) 
				+ " from file: " + fu.getFilename() + "  of size: " + fu.getSize());
		
		return s;
	}
	
	private String extractPDFText(byte[] pdfBytes) {
		String text = "";
		RandomAccessBuffer tempMemBuffer = new RandomAccessBuffer();
		try {
			PDDocument doc = PDDocument.load(new ByteArrayInputStream(pdfBytes), tempMemBuffer);
			PDFTextStripper sa = new PDFTextStripper();
			text = sa.getText(doc);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "couldn't get text", e);
		}
		return text;
	}

	
	private String extractWordText(byte[] wordBytes) {
		String text = "";
		ByteArrayInputStream finStream = new ByteArrayInputStream(wordBytes);
		
		try {
			HWPFDocument doc = new HWPFDocument(finStream);
			WordExtractor wordExtract = new WordExtractor(doc); 
			String[] dataArray = wordExtract.getParagraphText();
			for (int i = 0; i < dataArray.length; i++) {
				text += ("\n–" + dataArray[i]);
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, "couldn't get text", e);
		}
		
		return text;
	}
	
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
