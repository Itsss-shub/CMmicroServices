package com.bank.homeloan.restapi.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.homeloan.restapi.app.model.CustomerDetails;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerDetails, Integer>{

	public List<CustomerDetails> findByStatus(String status);
}
