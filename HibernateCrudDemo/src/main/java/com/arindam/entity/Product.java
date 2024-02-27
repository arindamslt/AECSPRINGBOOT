package com.arindam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
	@Id
	@Column(length = 10)
private String pid;
	@Column(length = 25,nullable = false)
private String pname;
private Integer pqty;
@Column(length = 11,precision = 2)
private Double price;
}
