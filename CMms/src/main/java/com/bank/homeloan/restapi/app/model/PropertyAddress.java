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
@Table(name = "propertyaddress")
public class PropertyAddress{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer propertyAddressId;
	
    private String propertyAreaName;
    private String propertyCityName;
    private String propertyDistrict;
    private String propertyState;
    private Integer propertyPinCode;
  }