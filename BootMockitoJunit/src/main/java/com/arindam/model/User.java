package com.arindam.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="User_Master")
public class User {
	@Id
private Integer id;
	@Column(length = 25)
private String name;
private Integer age;
@Column(length = 30)
private String address;
}
