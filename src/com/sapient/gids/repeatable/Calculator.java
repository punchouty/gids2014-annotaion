package com.sapient.gids.repeatable;

public class Calculator {
	
	@Test(input="1,1", output="2")
	@Test(input="0,1", output="1")
	@Test(input="-1,1", output="0")
	@Test(input="-1,-1", output="-2")
	public int sum(int x, int y) {
		return x + y;
	}
	
	@Test(input="1,1", output="1")
	@Test(input="-1,1", output="-1")
	@Test(input="-1,-1", output="1")	
	@Test(input="0,1", output="0")
	@Test(input="1,0", exception=true)
	public int divide(int x, int y) {
		if(y == 0) {
			throw new IllegalArgumentException("Cannot divide number by zero");
		}
		return x / y;
	}

}
