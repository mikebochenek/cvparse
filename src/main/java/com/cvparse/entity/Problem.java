package com.cvparse.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Problem {

	@Id
	@GeneratedValue
	private Long id;
	
    @Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
 
    private String problemStatement;
    
	private String owner;
	
	private String name;
	
	private String problemXML;

	
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

	public String getProblemStatement() {
		return problemStatement;
	}

	public void setProblemStatement(String problemStatement) {
		this.problemStatement = problemStatement;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getProblemXML() {
		return problemXML;
	}

	public void setProblemXML(String problemXML) {
		this.problemXML = problemXML;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Problem [id=" + id + ", createDate=" + createDate
				+ ", problemStatement=" + problemStatement + ", owner=" + owner
				+ ", name=" + name + ", problemXML=" + problemXML + "]";
	}
}
