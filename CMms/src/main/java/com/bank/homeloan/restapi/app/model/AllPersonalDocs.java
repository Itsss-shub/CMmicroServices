package com.bank.homeloan.restapi.app.model;

import java.io.Serializable;

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
@Table(name = "document")
public class AllPersonalDocs implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer allPersonalDocsId;
	@Lob
	@Column(length = 900000000)
	private byte[] addressProof;
	@Lob
	@Column(length = 900000000)
	private byte[] panCard;
	@Lob
	@Column(length = 900000000)
	private byte[] aadharCard;
	@Lob
	@Column(length = 900000000)
	private byte[] incomeTaxReturn;
	@Lob
	@Column(length = 900000000)
	private byte[] photo;
	@Lob
	@Column(length = 900000000)
	private byte[] signature;
	@Lob
	@Column(length = 900000000)
	private byte[] thumb;
	@Lob
	@Column(length = 900000000)
	private byte[] bankCheque;
	@Lob
	@Column(length = 900000000)
	private byte[] bankStatement;
	@Lob
	@Column(length = 900000000)
	private byte[] propertyProof;
	@Lob
	@Column(length = 900000000)
	private byte[] incomeProof;
	@Lob
	@Column(length = 900000000)
	private byte[] propertyInsurance;
	@Lob
	@Column(length = 900000000)
	private byte[] professionalSalarySlip;

}
