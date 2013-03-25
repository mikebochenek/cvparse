package com.cvparse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.pdfbox.io.RandomAccessBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import com.cvparse.ejb.FileUploadEJB;
import com.cvparse.entity.FileUpload;

@ManagedBean
@RequestScoped
public class TextBean {
	private Logger logger = Logger.getLogger(this.getClass().getName());

    @EJB
    private FileUploadEJB fileUploadEjb;
	
	public String getText() {
		long startTS = System.currentTimeMillis();
		
		FileUpload fu = fileUploadEjb.load(4);
		
		logger.finer(fu.getId() + " created on: " + fu.getCreateDate());
		
		String s = null;
		if (fu.getFilename().endsWith(".pdf")) {
			s = extractPDFText(fu.getData());
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
}
