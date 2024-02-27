package com.arindam.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Order_dt")
public class Order {
	@Id
	@Column(length = 10)
private String orderId;
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
private Date orderDt;
	@PositiveOrZero(message = "QUANTITY MUST BE  GREATER THAN AND EQUAL TO  ZERO")
private Integer oqty;

}
