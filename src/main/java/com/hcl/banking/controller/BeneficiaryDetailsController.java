package com.hcl.banking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.banking.entity.BeneficiaryDetails;
import com.hcl.banking.repository.BeneficiaryDetailsRepository;

@RestController
@RequestMapping("/banking")
@CrossOrigin(origins="*")
public class BeneficiaryDetailsController {
	@Autowired
	BeneficiaryDetailsRepository beneficiaryDetailsRepository; 
	
	@PostMapping("/addpayee")
	public BeneficiaryDetails addPayee(@Valid @RequestBody BeneficiaryDetails beneficiaryDetails) {
		return beneficiaryDetailsRepository.save(beneficiaryDetails);
	}
	
	@GetMapping("/getbens")
	public List<BeneficiaryDetails> getAllBeneficiers() {
		return beneficiaryDetailsRepository.findAll();
	}
	
}
