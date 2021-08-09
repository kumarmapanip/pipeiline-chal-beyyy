package com.rvy.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "customer_rvy")
public class Customer implements Serializable{




	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	@NotNull
	@Column(columnDefinition = "NUMERIC(15)" , unique = true)
	private Integer uin;
	@NotBlank
	@Column(length=30)
	private String name;
	@Column(length = 30)
	private String email;
	@Column(length = 10)
	private Long mobile;
	private LocalDate birthdate;
	
	private String doorNumber;
	private String street;
	private String city;
	private String state;
	private String country;
	private Long zipCode;
	
	
	@JsonIgnore
	private Integer regionId;
	
	public Customer(Integer id,Integer uin,String name,String email,String city)
	{
		super();
		this.customerId=id;
		this.uin=uin;
		this.name=name;
		this.email=email;
		this.city=city;
	}

}




