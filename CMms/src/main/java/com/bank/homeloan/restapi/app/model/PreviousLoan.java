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
@Table(name = "previousloan")
public class  PreviousLoan{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer previousLoanId;
    private Double previousLoanAmount;
    private Double paidAmount;
    private Double remainingAmount;
    private Integer defaulterCount;
    private String loanStatus;
    private String remark;

}
