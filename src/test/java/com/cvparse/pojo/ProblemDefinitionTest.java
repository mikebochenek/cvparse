package com.cvparse.pojo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProblemDefinitionTest {

	@Test
	public void test() {
		ProblemDefinition def = createFactorialDef();
	}

	public ProblemDefinition createFactorialDef() {
		ProblemDefinition def = new ProblemDefinition();
		
		Function f = new Function();
		f.setName("Factorial");
		Variable ret = new Variable();
		ret.setType(VariableType.INT);
		f.setReturnValue(ret);
		
		Variable param = new Variable();
		param.setType(VariableType.INT);
		param.setName("x");
		f.addParameter(param);
		
		def.setTestFunction(f);
		return def;
	}

}
