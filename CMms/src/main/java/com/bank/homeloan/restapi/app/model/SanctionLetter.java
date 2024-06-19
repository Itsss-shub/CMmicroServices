package com.bank.homeloan.restapi.app.model;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sanction")
public class SanctionLetter{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sanctionLetterId;
    private Date sanctionDate;
    private String applicantName;
    private String contact;
    private Double loanAmountSanctioned;
    //ch
    private String interestType;
    private Double rateOfInterest;
    //ch
    private Integer loanTenure;
    private Double monthlyEmiAmount;
    private String modeOfPayment;

    //add
    @Lob
	@Column(length = 9000000)
	private byte[] sanctionLetter;
    
}
