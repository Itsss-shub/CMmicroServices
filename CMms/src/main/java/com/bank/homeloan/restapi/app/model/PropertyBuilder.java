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
@Table(name = "builder")
public class PropertyBuilder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer propertyBuilderId;
	
	private String builderName;
	private String builderConstructionDetails;
	private String builderLicense;
	private String builderAddress;
	//add
	private String builderContactNo;
	
	

}
