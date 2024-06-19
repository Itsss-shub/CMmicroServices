package com.bank.homeloan.restapi.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "profession")
public class CustomerProfession {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerProfessionId;
	private String occupation;
	private String sourceofIncome;
	private Double yearlyIncome;

}
