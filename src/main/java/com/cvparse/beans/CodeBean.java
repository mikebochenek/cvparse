package com.cvparse.beans;

import java.io.IOException;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.cvparse.process.JavaCompileCommand;

@ManagedBean
@RequestScoped
public class CodeBean {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	private String input;
	private String output;
	private Long timer;

	public void compileAction() {
		System.out.println("compileAction --> " + getSessionId());
		long startTS = System.currentTimeMillis();
		JavaCompileCommand cmd = new JavaCompileCommand();
		try {
			String name = "Test"; //TODO change to problem.getName
			output = cmd.compile(getSessionId(), name, input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timer = System.currentTimeMillis() - startTS;
	}

	public void testAction() {
		long startTS = System.currentTimeMillis();
		System.out.println("testAction --> " + getSessionId());
		timer = System.currentTimeMillis() - startTS;
	}
	
	
	private String getSessionId() {
		FacesContext fCtx = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
		return session.getId();
	}


	public Long getTimer() {
		return timer;
	}

	public void setTimer(Long timer) {
		this.timer = timer;
	}

	public String getOutput() {
		return output == null ? null : output.replace("\n", "<br />");
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getInput() {
		if (input == null) { //TODO remove test data...
			input = "public class Test { \n"
					+ "  public int fibonacci(int f) { \n"
					+ "    System.out.println(\"Hello, World\"); \n"
					+ "  }\n"
					+ "}";
		}
		
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

}