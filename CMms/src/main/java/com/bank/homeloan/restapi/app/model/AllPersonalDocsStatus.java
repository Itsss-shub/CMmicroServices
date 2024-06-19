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
@Table(name = "documentStatus")
public class AllPersonalDocsStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer allPersonalDocsStausId;
	
	private String addressProofStatus;
	private String panCardStatus;
	private String aadharCardStatus;
	private String incomeTaxReturnStatus;
	private String photoStatus;
	private String signatureStatus;
	private String thumbStatus;
	private String bankChequeStatus;
	private String bankStatementStatus;
	private String propertyProofStatus;
	private String incomeProofStatus;
	private String propertyInsuranceStatus;
	private String professionalSalarySlipStatus;

}
