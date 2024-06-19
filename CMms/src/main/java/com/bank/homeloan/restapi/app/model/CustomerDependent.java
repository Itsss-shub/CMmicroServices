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
@Table(name = "dependent")
public class CustomerDependent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerDependentId;
	
    private String fatherName;
    private String motherName;
    private Integer noOfChild;
    private String maritalStatus;
    private Integer noOfFamilyMember;
    private Double familyIncome;
    private String spouseName;
    private Integer dependentMember;

}

