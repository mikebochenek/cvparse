package com.cvparse.generators;

import com.cvparse.pojo.ProblemDefinition;

public interface CodeGenerator {
	String generate(ProblemDefinition pd);
	String generateTests(ProblemDefinition pd);
}
