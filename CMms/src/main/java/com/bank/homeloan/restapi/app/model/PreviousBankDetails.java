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
@Table(name = "bankdetails")
public class PreviousBankDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer previousBankDetailsId;
    private String branchName;
    private String ifscCode;
    //ch
    private String contactNo;
    private String email;
    private String status;
    private String accountType;
    private String accountHolderName;
    private Long accountNo;

}
