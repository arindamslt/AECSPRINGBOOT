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
@Table(name="Student_Dtls")
public class Student {
	@Id
	@Column(length = 10)
private String rollno;
	@Column(length = 25)
private String sname;
	@Column(length = 25)
private String sdept;
}
