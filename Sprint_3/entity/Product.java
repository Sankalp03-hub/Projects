package com.clothkatta.sb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="ProductInfo")
@Data
public class Product {
	
	@Id
	private int pid;
	
	@Column(length = 25, nullable = false)
	@NotBlank(message = "Product Name cannot be blank")
	private String pname;
	
	@Column( nullable = false)
	@NotNull(message = "Product price cannot be blank")
	private double pprice;
	
	@Column(length = 25, nullable = false)
	@NotBlank(message = "Product brand cannot be blank")
	private String pbrand;
	
	@Column(length = 25, nullable = false)
	@NotBlank(message = "Product category cannot be blank")
	private String pcategory;
	
	@Column(length = 25, nullable = false)
	@NotNull(message = "Availability cannot be blank")
	private int pavailable;

}
