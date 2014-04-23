package com.sapient.gids.lombok;

import java.util.Date;

import lombok.Data;

@Data
public class Employee {
	
	private final int id;
	private String name;
	private Date dateOfBirth;
	

}
