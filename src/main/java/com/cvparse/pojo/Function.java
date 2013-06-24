package com.cvparse.pojo;

import java.util.ArrayList;
import java.util.List;

public class Function {
	private String name;
	private Variable returnValue;
	private List<Variable> parameters;
	
	public void addParameter(Variable parameter) {
		assert parameter != null;
		if (parameters == null) { 
			parameters = new ArrayList<Variable>();
		}
		parameters.add(parameter);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Variable getReturnValue() {
		return returnValue;
	}
	public void setReturnValue(Variable returnValue) {
		this.returnValue = returnValue;
	}
	public List<Variable> getParameters() {
		return parameters;
	}
	public void setParameters(List<Variable> parameters) {
		this.parameters = parameters;
	}
	
	
}
