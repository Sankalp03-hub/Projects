package com.clothkatta.sb.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="CustomersInfo")
@Data

public class Customer {
	@Id
	private int cid;
	
	@Column(length = 25, nullable = false)
	@NotBlank(message = "Customer Name cannot be blank")
	private String cname;
	
	@Column(length = 20, nullable = false)
	@NotBlank(message = "Customer Surname cannot be blank")
	private String csurname;
	
	@Column(length = 26, nullable = false, unique = true)
	@NotBlank(message = "Customer Email ID cannot be blank")
	@Email(message = "Email ID is not proper")
	private String cemail;
	
	@Column(length = 11, nullable = false, unique = true)
	@NotNull(message = "Phone number cannot be Null")
	private long cphone;
	
	@OneToMany(mappedBy="customer",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Order> orderDetails;


}
