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
@Table(name = "mortgage")
public class Mortgage{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mortgageId;
    private Double  propertyValue;
    private String propertyType;
    private Double loanOnProperty;

}
