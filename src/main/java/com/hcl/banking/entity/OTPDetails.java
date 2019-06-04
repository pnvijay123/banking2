package com.hcl.banking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="otp_details")
public class OTPDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long accountNumber;
	private Long beneficiaryAccountNumber;
	private String generatedOTP;
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
	public String getGeneratedOTP() {
		return generatedOTP;
	}
	public void setGeneratedOTP(String generatedOTP) {
		this.generatedOTP = generatedOTP;
	}
	public OTPDetails() {
	}
}
