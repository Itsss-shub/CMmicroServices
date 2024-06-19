
package com.bank.homeloan.restapi.app.model;


import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ledger")
public class Ledger{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ledgerId;
	//added
	
	private Integer custId;
	
    private Date ledgerCreateDate;
    private Double totalLoanAmount;
    private Double payableAmountWithInterest;
    private Integer tenure;
    private Double monthlyEmi;
    private Double amountPaidTillDate;
    private Double remainingAmount;
    private Date nextEmiDateStart;
    private Date nextEmiDateEnd;
    private Integer defaulterCount;
    private String currentMonthEmiStatus;
    private Date loanEndDate;
    private String loanStatus;

    
}
