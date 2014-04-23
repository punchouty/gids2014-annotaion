package com.sapient.gids.lambda;

import java.util.Comparator;
import java.util.function.Consumer;

public class MethodReference {

	private static Comparator<Integer> cmp = Integer::compare;

	public static void comparison() {
		cmp.compare(100, 100);
	}

	private static Consumer<String> myprint = System.out::println;

	public static void print(String[] args) {
		for (String string : args) {
			myprint.accept(string);
		}
	}
}
