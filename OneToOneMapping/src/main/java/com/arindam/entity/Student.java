package com.arindam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
	@Id
	@Column(length = 5)
private String rollno;
	@Column(length = 25,nullable = false)
private String sname;
	@OneToOne
	@JoinColumn(name="T_ID")
	Teacher tr;
}
