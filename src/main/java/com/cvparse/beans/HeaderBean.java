package com.cvparse.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@RequestScoped
public class HeaderBean implements Serializable {

	private final String active = "active";
	
	public String getHomeClass() {
		//return getRequestURL().indexOf("index.jsf") == -1 ? "" : active;
		return "".equals(getProblemClass()) && "".equals(getSolutionClass()) 
				&& "".equals(getResourcesClass()) ? active : "";
	}
	public String getProblemClass() {
		return getRequestURL().indexOf("problem.jsf") == -1 ? "" : active;
	}
	public String getSolutionClass() {
		return getRequestURL().indexOf("code.jsf") == -1 ? "" : active;
	}
	public String getResourcesClass() {
		return getRequestURL().indexOf("header.jsf") == -1 ? "" : active;
	}
	
	private String getRequestURL() {
		Object request = FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if (request instanceof HttpServletRequest) {
			return ((HttpServletRequest) request).getRequestURL().toString();
		} else {
			return "";
		}
	}
}
