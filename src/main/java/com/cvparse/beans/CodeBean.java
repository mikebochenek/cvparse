package com.cvparse.beans;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import javax.faces.model.SelectItem;

import com.cvparse.ejb.ProblemSourceCodeEJB;
import com.cvparse.process.JavaCompileCommand;

@ManagedBean
@RequestScoped
public class CodeBean {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	@EJB
	private ProblemSourceCodeEJB problemSourceCodeEjb;
	
	private String input;
	private String output;
	private String timer;
	private String currentLang;
	private List<SelectItem> langList = new ArrayList<SelectItem>();

	public void compileAction() {
		System.out.println("compileAction --> " + getUUID());
		long startTS = System.currentTimeMillis();
		JavaCompileCommand cmd = new JavaCompileCommand();
		try {
			String name = "Test"; //TODO change to problem.getName
			output = cmd.compile(getUUID(), name, input);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "could not compile ", e);
		}
		timer = ""+ (System.currentTimeMillis() - startTS);
	}

	public void testAction() {
		long startTS = System.currentTimeMillis();
		System.out.println("testAction --> " + getSessionId());
		timer = ""+ (System.currentTimeMillis() - startTS);
	}
	
	
	private String getSessionId() {
		FacesContext fCtx = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
		return session.getId();
	}
	
	private String getUUID() {
		String session = getSessionId();
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		return sdf.format(new Date()) + "-" + session.replaceAll(".undefined", "");
	}


	public String getTimer() {
		return timer;
	}

	public void setTimer(String timer) {
		this.timer = timer;
	}

	public String getOutput() {
		return output == null ? null : output.replace("\n", "<br />");
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getCurrentLang() {
		return currentLang;
	}

	public void setCurrentLang(String currentLang) {
		this.currentLang = currentLang;
	}

	public List<SelectItem> getLangList() {
		if (langList == null || langList.size() == 0) { //TODO remove test data...
			langList.add(new SelectItem(problemSourceCodeEjb.load(1).getLanguage().toString()));
		}
		return langList;
	}

	public void setLangList(List<SelectItem> langList) {
		this.langList = langList;
	}

	public String getInput() {
		if (input == null) { //TODO remove test data...
			input = problemSourceCodeEjb.load(1).getBoilerplate();
		}
		
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

}