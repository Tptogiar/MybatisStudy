package com.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	private Integer id;
	private String lastName;
	private String email;
	private String gender;
	private Department dept;


	public Employee(String lastName, String email, String gender) {
		this.lastName=lastName;
		this.email=email;
		this.gender=gender;
	}
}
