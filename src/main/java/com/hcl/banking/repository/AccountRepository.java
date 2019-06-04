package com.hcl.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hcl.banking.entity.Account;

@RepositoryRestResource(collectionResourceRel = "banking", path = "banking")
public interface AccountRepository extends JpaRepository<Account, Long> {

	

}
