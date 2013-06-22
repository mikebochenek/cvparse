package com.cvparse.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CodeBean {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
//		System.out.println("yes we would always be here.. ");
//		count = name == null ? 0 : name.length();
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	private String name;
	private Integer count;

	public void countAction() {
		System.out.println("yes here " + name.length());
		count = name.length();
	}
}