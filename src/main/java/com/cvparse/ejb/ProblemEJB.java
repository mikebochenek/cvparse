package com.cvparse.ejb;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cvparse.entity.Problem;

@Stateless
public class ProblemEJB {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	@PersistenceContext(unitName = "mysqlPU")
	private EntityManager em;

	public Problem load(long id) {
		return em.find(Problem.class, id);
	}
	
    @SuppressWarnings("unchecked")
	public List<Problem> loadAll() {
		return em.createQuery("select p from Problem p ").getResultList();
	}
}
