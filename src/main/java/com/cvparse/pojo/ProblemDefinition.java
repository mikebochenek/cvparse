package com.cvparse.pojo;

import java.util.List;

public class ProblemDefinition {
	private Function testFunction;
	private List<FunctionTest> tests;
	
	public Function getTestFunction() {
		return testFunction;
	}
	public void setTestFunction(Function testFunction) {
		this.testFunction = testFunction;
	}
	public List<FunctionTest> getTests() {
		return tests;
	}
	public void setTests(List<FunctionTest> tests) {
		this.tests = tests;
	}
}
