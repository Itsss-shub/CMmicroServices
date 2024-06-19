package com.bank.homeloan.restapi.app.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//main pojo class(parent) of all child classes

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class CustomerDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerDetailsId;
	
	private String customerName;
	private String customerUsername;
	private String customerPassword;
	//ch
	private String customerMobileNo;
	private String customerEmailId;
	//change
	private String adharNo;
	private String pancardNo;
	private String gender;
	private Date customerDob;
	private Integer customerAge;
	private String maritalStatus;
	private Integer cibilScore;
	private Double totalLoanRequired;
	private String status;

	// has a relation for customer
	@OneToOne(cascade = CascadeType.ALL)
	private AllPersonalDocs allPersonalDocs;
	
	@OneToOne(cascade = CascadeType.ALL)
	private AllPersonalDocsStatus allPersonalDocsStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	private BankAddress bankAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerAccountDetails customerAccountDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerDependent customerDependent;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerEducationalDeatils customerEducationalDeatils;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerProfession customerProfession;
	
	@OneToOne(cascade = CascadeType.ALL)
	private GuarantorDetails guarantorDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Ledger ledger;
	
	@OneToOne(cascade = CascadeType.ALL)
	private LoanDisbursement loanDisbursement;
	
	@OneToOne(cascade = CascadeType.ALL)
	private LocalAddress localAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Mortgage mortgage;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PreviousBankDetails previousBankDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private PermanentAddress permanentAddress;

	@OneToOne(cascade = CascadeType.ALL)
	private PreviousLoan previousLoan;

	@OneToOne(cascade = CascadeType.ALL)
	private PropertyAddress propertyAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PropertyBuilder propertyBuilder;

	@OneToOne(cascade = CascadeType.ALL)
	private PropertyDetails propertyDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private SanctionLetter sanctionLetter;

	
}
