package com.clothkatta.sb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="OrderInfo")
@Data
public class Order {
	
	@Id
	private int oid;
	
	@Column(length = 25, nullable = false)
	@NotBlank(message = "Product Name cannot be blank")
	private String odetail;
	
	@Column( nullable = false)
	@NotNull(message = "Product price cannot be blank")
	private int nooforder;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="CustomerId", referencedColumnName = "cid")
	@JsonBackReference
	private Customer customer;

}
