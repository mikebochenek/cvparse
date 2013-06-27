package com.cvparse.ejb;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cvparse.entity.ProblemSourceCode;

@Stateless
public class ProblemSourceCodeEJB {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	@PersistenceContext(unitName = "mysqlPU")
	private EntityManager em;

	
	public ProblemSourceCode load(long id) {
		return em.find(ProblemSourceCode.class, id);
	}
}
