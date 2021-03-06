package com.cvparse.admin.beans;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.cvparse.ejb.ProblemEJB;
import com.cvparse.entity.Problem;

@ManagedBean
@RequestScoped
public class ListProblemsBean {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	@EJB
	private ProblemEJB problemEjb;
	

	public List<Problem> getProblemList() {
		return problemEjb.loadAll();
	}
}