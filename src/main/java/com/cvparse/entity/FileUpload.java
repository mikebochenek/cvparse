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
    private byte[] data;
    
	private String owner;
	
	private String filename;
	
	private long size;
	
	
    public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
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

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
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
		return "FileUpload [id=" + id + ", createDate=" + createDate
				+ ", owner=" + owner + ", filename=" + filename + ", size="
				+ size + "]";
	}
	
}