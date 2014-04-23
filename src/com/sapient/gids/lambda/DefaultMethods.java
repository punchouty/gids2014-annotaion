package com.sapient.gids.lambda;

interface LegacyInterface {
	
    String legacyMethod();

    default String newMethod() {
        return "New default method in legacy class";
    }
    
    public static void print() {
    	System.out.println("This is a static method");
    }
}

class LegacyClass implements LegacyInterface {
	
    @Override
    public String legacyMethod() {
        return "Legacy Method from the Legacy Class";
    }
}

class NewClass implements LegacyInterface {
    @Override
    public String legacyMethod() {
        return "Legacy Method from the New Class";
    }

    @Override
    public String newMethod() {
        return "New Method from the New Class";
    }
}


public class DefaultMethods {

	public static void main(String[] args) {
		LegacyInterface.print();
		new LegacyClass().legacyMethod();
		new LegacyClass().newMethod();
		new NewClass().legacyMethod();
		new NewClass().newMethod();
	}
}

