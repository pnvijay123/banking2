package com.hcl.banking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BeneficiaryDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long accountNumber;
	private Long beneficiaryAccountNumber;
	private String beneficiaryName;
	private String beneficiaryNickName;
	private String IFSCCode;
	private String addPayeeStatus;
	
	
	
	public Long getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}



	public Long getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}



	public void setBeneficiaryAccountNumber(Long beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}



	public String getBeneficiaryName() {
		return beneficiaryName;
	}



	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}



	public String getBeneficiaryNickName() {
		return beneficiaryNickName;
	}



	public void setBeneficiaryNickName(String beneficiaryNickName) {
		this.beneficiaryNickName = beneficiaryNickName;
	}



	public String getIFSCCode() {
		return IFSCCode;
	}



	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}



	public String getAddPayeeStatus() {
		return addPayeeStatus;
	}



	public void setAddPayeeStatus(String addPayeeStatus) {
		this.addPayeeStatus = addPayeeStatus;
	}



	public BeneficiaryDetails() {
	}
		
}
