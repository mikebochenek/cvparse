/*
 * Copyright (c) 2013 Michael Bochenek 
 */
package com.cvparse.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class FileUpload {

	@Id
    @GeneratedValue
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
 
	@Lob
    private String data;
    
	private String owner;
	
	
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

	public String getData() {
		return data;
	}

	public void setDate(String data) {
		this.data = data;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "FileUpload [id=" + id + ", createDate=" + createDate + ", data="
				+ (data.length()) + ", owner=" + owner + "]";
	}
	
}