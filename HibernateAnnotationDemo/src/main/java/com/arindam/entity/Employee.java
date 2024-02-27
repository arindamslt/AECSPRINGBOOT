package com.arindam.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Employee_Master")
public class Employee {
	@Id
	@GeneratedValue
private Integer eid;
	@Column(length = 25,nullable = false)
private String ename;
 @Column(length = 10)
private String ephno;
 @Column(name="Desig",length = 25)
private String edeisg;
 @Temporal(TemporalType.DATE)
private Date joinddt;
 @Temporal(TemporalType.TIMESTAMP)
private Date workhr;
 @Column(length = 30)
 @Transient
private String email;

}