package com.project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="project_employee")
public class Employee {
	@NonNull
	@Id
	@GeneratedValue
	private Integer empId;
	private String empName;
	private String dept;
	private Double empSal;

}
