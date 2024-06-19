package com.bank.homeloan.restapi.app.model;



import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enquiry implements Serializable{

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer enquiryId;
	
	private String name;
	private String email;
	//ch
	private Date dob;
	//ch
	private String contact;
	private String gender;
	private Integer age;
	//ch
	private String adhar;
	
	private String pancard;
	private String address;
	//usname , password,remark not required..
	private String username;
	private String password;
	private String status;
	private Integer cibilScore;
	private String remark;
}
