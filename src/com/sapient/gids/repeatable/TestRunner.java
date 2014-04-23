package com.sapient.gids.repeatable;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class TestRunner {
	
	private static int totalTest = 0;
	private static int passedTest = 0;
	private static int failedTest = 0;

	public static void main(String[] args) throws SecurityException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		
		if(args == null || args.length <= 0) {
			String [] classes = {"com.sapient.gids.repeatable.Calculator"};
			args = classes;
		}
		for (String className : args) {
			runTests(className);
		}
		System.out.println("Total Tests : " + totalTest);
		System.out.println("Passed Tests : " + passedTest);
		System.out.println("Failed Tests : " + failedTest);
	}

	/**
	 * Iterate thru all methods of target class and get all test annotation. Delegate processing of each method to runTestForMethod
	 */
	private static void runTests(String className) throws SecurityException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Method[] methods = Class.forName(className).getMethods();
		for (Method method : methods) {
			Annotation[] annotations = method.getAnnotationsByType(Test.class);
			if(annotations != null && annotations.length > 0) {
				runAllTestsForMethod(className, method, annotations);
			}
		}
	}

	/**
	 * Get attribute value (input, output and exception) of each Test annotation and delegate processing of each test to runSingleTest
	 */
	private static void runAllTestsForMethod(String className, Method method, Annotation[] annotations) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {
		System.out.println("Running Tests for method : " + method.getName());
		for (Annotation annotation : annotations) {
			Method inputMethod = annotation.annotationType().getMethod("input");
			String input = (String) inputMethod.invoke(annotation);
			Method outputMethod = annotation.annotationType().getMethod("output");
			String output = (String) outputMethod.invoke(annotation);
			Method exceptionMethod = annotation.annotationType().getMethod("exception");
			Boolean exception = (Boolean) exceptionMethod.invoke(annotation);
			runSingleTest(input, output, exception, className, method);
		}
	}

	@SuppressWarnings("rawtypes")
	private static void runSingleTest(String input, String output,
			Boolean exception, String className, Method method) {
		//System.out.println("Executing " + method.getName() + " with input : " + input + " and expecting output : " + output + " and exception " + exception);
		Parameter [] parameters = method.getParameters();
		Object [] parameterValues = new Object[parameters.length];
		String [] inputs = input.split(",");
		if(inputs.length != parameters.length) {
			throw new IllegalStateException("Parameter in tests are not same as that of test definition");
		}
		else {
			int i = 0;
			for (Parameter parameter : parameters) {
				Class clazz = parameter.getType();
				String value = inputs[i];
				parameterValues[i] = getValue(clazz, value);
				i++; 
			}
			try {
				Object returnValue = method.invoke(Class.forName(className).newInstance(), parameterValues);
				/**  In case of Exception control will not go beyond this and will continue in catch (InvocationTargetException e) block below **/
				Class returnTypeClass = method.getReturnType();
				Object returnObject = getValue(returnTypeClass, output);
				if(returnObject.equals(returnValue)) {
					System.out.println("Test case passed. Method Name : " + method.getName() + " Inputs : " + input + " Output : " + output + " Exception " + exception);
					passedTest++;
				}
				else {
					System.out.println("Test case failed. Method Name : " + method.getName() + " Inputs : " + input + " Output : " + output + " Exception " + exception);
					failedTest++;
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				if(exception) { // In case exception is expected
					System.out.println("Test case passed. Method Name : " + method.getName() + " Inputs : " + input + " Output : " + output + " Exception " + exception);
					passedTest++;
				}
				else { // In case exception is not expected
					System.out.println("Test case failed because of exception. Method Name : " + method.getName() + " Inputs : " + input + " Output : " + output + " Exception " + exception);
					failedTest++;
				}
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				totalTest++;
			}
		}
	}

	@SuppressWarnings("rawtypes")
	private static Object getValue(Class classType, String value) {
		if(classType.equals(String.class)) {
			return value;
		}
		else if(classType.equals(int.class)) {
			return Integer.parseInt(value);
		}
		else if(classType.equals(Integer.class)) {
			return Integer.parseInt(value);
		}
		else if(classType.equals(double.class)) {
			return Double.parseDouble(value);
		}
		else if(classType.equals(Double.class)) {
			return Double.parseDouble(value);
		}
		else if(classType.equals(float.class)) {
			return Float.parseFloat(value);
		}
		else if(classType.equals(Float.class)) {
			return Float.parseFloat(value);
		}
		else if(classType.equals(boolean.class)) {
			return Boolean.parseBoolean(value);
		}
		else if(classType.equals(Boolean.class)) {
			return Boolean.parseBoolean(value);
		}
		else {
			throw new IllegalArgumentException("Type not supported in parameter or return");
		}
	}

}
