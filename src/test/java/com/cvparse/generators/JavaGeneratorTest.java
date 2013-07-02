package com.cvparse.generators;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cvparse.pojo.ProblemDefinition;
import com.cvparse.pojo.ProblemDefinitionTest;

public class JavaGeneratorTest {

	@Test
	public void testGenerate() {
		ProblemDefinitionTest pdt = new ProblemDefinitionTest();
		ProblemDefinition def = pdt.createFactorialDef();
		
		JavaGenerator jg = new JavaGenerator();
		String code = jg.generate(def);
		//System.out.println(code);
		assertTrue(code.contains("factorial"));
	}
}
