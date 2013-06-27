package com.cvparse.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.cvparse.ejb.ProblemSourceCodeEJB;

@RequestScoped
@ManagedBean
public class ResourcesBean {

	@EJB
	private ProblemSourceCodeEJB problemSourceCodeEjb;

	private String testCode;

	public String getTestCode() {
		if (testCode == null) {
			testCode = problemSourceCodeEjb.load(1).getTestcode();
		}
		return testCode;
	}
	
}
