package com.bank.homeloan.restapi.app.servicei;

import java.util.List;

import com.bank.homeloan.restapi.app.model.CustomerDetails;
import com.bank.homeloan.restapi.app.model.SanctionLetter;

public interface CustomerServiceI {

	List<CustomerDetails> getAllLoanAppl();

	List<CustomerDetails> getAllRejcetedLoanAppl();

	CustomerDetails getById(Integer customerDetailsId, SanctionLetter st);


}
