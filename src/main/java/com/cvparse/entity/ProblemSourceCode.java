package com.cvparse.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ProblemSourceCode {

	@Id
	@GeneratedValue
	private Long id;
	
    @Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

    private Language language;
    
    private String boilerplate;
    
    private String testcode;
}
