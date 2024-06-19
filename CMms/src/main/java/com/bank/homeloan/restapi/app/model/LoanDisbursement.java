package com.bank.homeloan.restapi.app.model;


import java.util.Date;

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
@Table(name = "disbursement")
public class LoanDisbursement{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer loanDisbursementId;
    private Long loanNumber;
    private Date aggrementDate;
    private String amountPayType;
    private Double totalAmount;
    private String bankName;
    private Long accountNumber;
    private String ifscCode;
    private String accountType;
    private Double transferAmount;
    private String paymentStatus;
    private Date amountPaidDate;

}
