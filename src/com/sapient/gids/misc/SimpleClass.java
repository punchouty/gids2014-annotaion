package com.sapient.gids.misc;

import java.lang.annotation.Annotation;

@Author(name="Rajan",createdDate ="04/24/2014")
public class SimpleClass {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Annotation [] all = SimpleClass.class.getAnnotations();
		Annotation [] byType = SimpleClass.class.getAnnotationsByType(Author.class);
	}

}
