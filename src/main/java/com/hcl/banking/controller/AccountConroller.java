package com.hcl.banking.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.banking.entity.Account;
import com.hcl.banking.entity.BranchMaster;
import com.hcl.banking.entity.OTPDetails;
import com.hcl.banking.entity.ValidateAccount;
import com.hcl.banking.entity.ValidateAccountResponse;
import com.hcl.banking.repository.AccountRepository;
import com.hcl.banking.repository.BeneficiaryDetailsRepository;
import com.hcl.banking.repository.BranchMasterRepository;

@RestController
@RequestMapping("/banking")
public class AccountConroller {
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	BranchMasterRepository branchMasterRepository; 
	
	@Autowired
	BeneficiaryDetailsRepository beneficiaryDetailsRepository;
	
	@GetMapping("/validateac")
	public ValidateAccountResponse validateAccount(@RequestBody ValidateAccount validateAccount) {
		Long accountNum=validateAccount.getAccountNumber();
		String ifscCode=validateAccount.getIfsccode();
		String account_status="Not Valid";
		String ifsccode_status="Not Valid";
		Optional<Account> acc=accountRepository.findById(accountNum);
		if(acc.isPresent()) {
			account_status="Valid";
		}
		Optional<BranchMaster> branch=branchMasterRepository.findByIfsccode(ifscCode);
		if(branch.isPresent()) {
			ifsccode_status="Valid";
		}
		
		ValidateAccountResponse validateAccountResponse=new ValidateAccountResponse();
		
		validateAccountResponse.setAccountNumberResponse(accountNum+" is "+account_status);
		validateAccountResponse.setIfsccodeResponse(ifscCode+" is "+ifsccode_status);
		return validateAccountResponse;
	}
	
	
	
	
	@PutMapping("/updatestatus/{id}/{otp}")
	public ResponseEntity<Account> updateAccountStatus(@PathVariable(value = "id") Long id,@PathVariable(value = "otp") String otp,OTPDetails oTPDetails)throws ResourceNotFoundException
	{
		Account acc=null;
		acc=accountRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Account No Does Not Exist :"+id));
		if(otp.equals(oTPDetails.getGeneratedOTP())) {
			acc.setAccountStatus("Confirmed");
		}
		
		final Account updateAcc=accountRepository.save(acc);
		return ResponseEntity.ok(updateAcc);
	}
		

}
