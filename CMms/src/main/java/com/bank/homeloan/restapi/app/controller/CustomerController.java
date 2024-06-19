package com.bank.homeloan.restapi.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.homeloan.restapi.app.model.CustomerDetails;
import com.bank.homeloan.restapi.app.model.SanctionLetter;
import com.bank.homeloan.restapi.app.servicei.CustomerServiceI;


import lombok.extern.slf4j.Slf4j;




@CrossOrigin("*")
@Slf4j
@RestController
@RequestMapping("/bank/homeloan/restapi/customer")
public class CustomerController {
	
	@Autowired CustomerServiceI csi;
	
	
	@GetMapping("/DocVerify")
	public ResponseEntity<List<CustomerDetails>> getAllAcceptedLoanApp(){
	List<CustomerDetails>appl =	csi.getAllLoanAppl();
	log.info("All loan application fetch from database with status : DocVerify");
		return new ResponseEntity<List<CustomerDetails>>(appl,HttpStatus.OK);
	}
	
	@GetMapping("/DocRejceted")
	public ResponseEntity<List<CustomerDetails>> getAllRejectedLoanApp(){
	List<CustomerDetails>appl =	csi.getAllRejcetedLoanAppl();
	log.info("All loan application fetch from database with status : DocRejceted");

		return new ResponseEntity<List<CustomerDetails>>(appl,HttpStatus.OK);
	}

	@PutMapping("/saction/{customerDetailsId}")
	public ResponseEntity<CustomerDetails> sactionletter(@PathVariable Integer customerDetailsId, @RequestBody SanctionLetter st){
	
		CustomerDetails app = csi.getById(customerDetailsId,st);
		log.info("Application status changed status :"+app.getStatus());
		return new ResponseEntity<CustomerDetails>(app,HttpStatus.OK);
	}
}
