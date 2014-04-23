package com.sapient.gids.checker;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.checkerframework.checker.nullness.qual.NonNull;

public class TypeChecker {

	public static void main(String[] args) {
		//assigning null
		@NonNull Object object1 = null;
		System.out.println(object1);
		
		//Check during cast
		Date date = (@NonNull Date)getDate();
		System.out.println(date);
		
		//adding in array
		List<@NonNull String> topicList = new ArrayList<>();
		String [] topics = {"Java", ".Net", "Web", null, "Data"};
		for (String topic : topics) {
			topicList.add(topic);
		}
		topicList.add(null);
	}
	
	private static Object getDate() {
		return null;
	}

	public static void doSomething() throws @Critical SQLException{	
				
	}

}