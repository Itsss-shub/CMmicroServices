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
@Table(name = "bankaddress")
public class BankAddress{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bankAddressId;
	
    private String bankArea;
    private String bankCity;
    private String bankDistrict;
    private String bankState;
    private Integer pincode;

    
}
