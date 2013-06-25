package com.cvparse.pojo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProblemDefinitionTest {

	@Test
	public void test() {
		ProblemDefinition def = new ProblemDefinition();
		
		Function f = new Function();
		f.setName("Factorial");
		Variable ret = new Variable();
		ret.setType(VariableType.INTEGER);
		f.setReturnValue(ret);
		
		Variable param = new Variable();
		param.setType(VariableType.INTEGER);
		f.addParameter(param);
		
		def.setTestFunction(f);
	}

}
