package com.sapient.gids.checker;

import java.util.ArrayList;
import java.util.List;

import org.checkerframework.checker.nullness.qual.NonNull;

public class TypeChecker {

	public static void main(String[] args) {
		//assigning null
		@NonNull Object ref = null;
		System.out.println(ref);
		
		//adding in array
		List<@NonNull String> topicList = new ArrayList<>();
		String [] topics = {"Java", ".Net", "Web", null, "Data"};
		for (String topic : topics) {
			topicList.add(topic);
		}
		topicList.add(null);
	}

}
