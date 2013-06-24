package com.cvparse.pojo;

import java.util.ArrayList;
import java.util.List;

public class FunctionTest {
	private Variable expectedValue;
	private List<Variable> testParameters;

	public void addTestParameter(Variable testParameter) {
		assert testParameter != null;
		
		if (testParameters == null) {
			testParameters = new ArrayList<Variable>();
		}
		testParameters.add(testParameter);
	}
	
	public Variable getExpectedValue() {
		return expectedValue;
	}
	public void setExpectedValue(Variable expectedValue) {
		this.expectedValue = expectedValue;
	}
	public List<Variable> getTestParameters() {
		return testParameters;
	}
	public void setTestParameters(List<Variable> testParameters) {
		this.testParameters = testParameters;
	}

}
