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
@Table(name = "guarantor")
public class GuarantorDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer guarantorDetailsId;
	
    private String guarantorName;
    private Date guarantorDOB;
    private String guarantorReationshipWithCustomer;
    //ch
    private String guarantorMobileNo;
    //ch
    private String guarantorAdharcardNo;
    private String guarantorCityName;
    private String guarantorJobDetails;
    private String guarantorAreaName;

    
}
