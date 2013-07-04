package com.cvparse.ejb;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cvparse.entity.ProblemSourceCode;

@Stateless
public class ProblemSourceCodeEJB {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	@PersistenceContext(unitName = "mysqlPU")
	private EntityManager em;

	
	public ProblemSourceCode load(long id) {
		return em.find(ProblemSourceCode.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<ProblemSourceCode> findByProblemId(long id) {
		// http://www.mkyong.com/hibernate/hibernate-query-examples-hql/
		Query query = em.createQuery("from ProblemSourceCode where problemId = :problemId");
		query.setParameter(0, id);
		return query.getResultList();
	}
}
