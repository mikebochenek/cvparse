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
    
    private String owner;
    
    private Long problemId;

	public Long getProblemId() {
		return problemId;
	}

	public void setProblemId(Long problemId) {
		this.problemId = problemId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getBoilerplate() {
		return boilerplate;
	}

	public void setBoilerplate(String boilerplate) {
		this.boilerplate = boilerplate;
	}

	public String getTestcode() {
		return testcode;
	}

	public void setTestcode(String testcode) {
		this.testcode = testcode;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "ProblemSourceCode [id=" + id + ", createDate=" + createDate
				+ ", language=" + language + ", boilerplate=" + boilerplate
				+ ", testcode=" + testcode + ", owner=" + owner
				+ ", problemId=" + problemId + "]";
	}
}
