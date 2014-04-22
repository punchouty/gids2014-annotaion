package com.sapient.gids.lombok;

import lombok.Data;

@Data
public class Person {
	
	private final int id;
	private String name;
	private String [] skills;
	
	public static void main(String[] args) {
		Person person = new Person(100);
		person.setName("Rajan Punchouty");
		String [] skills = {"java", "groovy", "java script", "html5"};
		person.setSkills(skills);
		System.out.println(person);
	}

}
