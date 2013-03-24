/*
 * Copyright (c) 2013 Michael Bochenek 
 */
package com.cvparse.ejb;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cvparse.entity.FileUpload;

@Stateless
public class FileUploadEJB {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	@PersistenceContext(unitName = "mysqlPU")
	private EntityManager em;

    public FileUpload update(FileUpload d) {
    	logger.info("calling update... " + d);
    	d.setCreateDate(new Date());
    	return em.merge(d);
    }
    
    public FileUpload create(byte[] b) {
    	FileUpload f = new FileUpload();
    	logger.info("calling create... " + f);
    	f.setCreateDate(new Date());
    	f.setDate(new String(b));
    	return em.merge(f);
    }
    
    

    @SuppressWarnings("unchecked")
	public List<FileUpload> loadAll() {
    	return em.createQuery("select d from FileUpload d ").getResultList();
    }
}
