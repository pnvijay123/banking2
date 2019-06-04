package com.hcl.banking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BranchMaster {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long branchId;
	private String ifsccode;
	private String address;	
	
	public BranchMaster() {
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
		
}
