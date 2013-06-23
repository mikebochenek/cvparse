package com.cvparse.beans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.cvparse.process.JavaCompileCommand;

@ManagedBean
@RequestScoped
public class CodeBean {

	private String name;
	private Integer count;
	private String output;


	public void countAction() {
		System.out.println("yes here " + getSessionId());
		JavaCompileCommand cmd = new JavaCompileCommand();
		try {
			output = cmd.compile(getSessionId(), name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count = name.length();
	}
	
	private String getSessionId() {
		FacesContext fCtx = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
		return session.getId();
	}

	
	public String getName() {
		return name == null ? null : name.replace("\n", "<br />");
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getOutput() {
		return output == null ? null : output.replace("\n", "<br />");
	}

	public void setOutput(String output) {
		this.output = output;
	}

}