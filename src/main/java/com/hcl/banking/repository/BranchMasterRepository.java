package com.hcl.banking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hcl.banking.entity.BranchMaster;

@RepositoryRestResource(collectionResourceRel = "banking", path = "banking")
public interface BranchMasterRepository extends JpaRepository<BranchMaster, Long> {
	
	@Query(value="select * from branch_master bm where bm.ifsc_code=?1",nativeQuery = true)
	Optional<BranchMaster> findByIfsccode(String ifsc_code);

}
