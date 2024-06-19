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
@Table(name = "Account")
public class  CustomerAccountDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerAccountDetailsId;
	
    private String accountType;
    private String accountHolderName;
    
    private String bankname;
    private Long accountNo;
    private String ifscCode;
    private double accountBalance;

}
