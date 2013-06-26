package com.cvparse.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class ResourcesBean {

	private String testCode;

	public String getTestCode() {
		return testCode;
	}
	
}
