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
@Table(name = "permanentaddress")
public class PermanentAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer permanentAddressId;
        private Integer   houseNo;
        private String  streetName;
        private String areaName;
        private String cityName;
        private String district;
        private String  state;
        private Integer   pincode;

}
