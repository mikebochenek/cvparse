package com.cvparse.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@RequestScoped
public class HomeBean implements Serializable {

	private final String active = "active";
	
	public String getWelcomeClass() {
		//return getRequestURL().indexOf("index.jsf") == -1 ? "" : active;
		return "".equals(getSigninClass()) && "".equals(getAdminClass()) 
				&& "".equals(getJobsClass()) && "".equals(getPartnersClass()) 
				&& "".equals(getContactClass()) && "".equals(getAboutClass()) ? active : "";
	}
	public String getSigninClass() {
		return getRequestURL().indexOf("signin.jsf") == -1 ? "" : active;
	}
	public String getAdminClass() {
		return getRequestURL().indexOf("/admin/") == -1 ? "" : active;
	}
	public String getJobsClass() {
		return getRequestURL().indexOf("jobs.jsf") == -1 ? "" : active;
	}
	public String getPartnersClass() {
		return getRequestURL().indexOf("partners.jsf") == -1 ? "" : active;
	}
	public String getAboutClass() {
		return getRequestURL().indexOf("about.jsf") == -1 ? "" : active;
	}
	public String getContactClass() {
		return getRequestURL().indexOf("contact.jsf") == -1 ? "" : active;
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
