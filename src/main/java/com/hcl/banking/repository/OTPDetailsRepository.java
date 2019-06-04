package com.hcl.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hcl.banking.entity.OTPDetails;

@RepositoryRestResource(collectionResourceRel = "banking/generateotp", path = "banking/generateotp")
//@Repository
public interface OTPDetailsRepository extends JpaRepository<OTPDetails, Long> {

	

}
