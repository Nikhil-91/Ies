package com.ashokit.ies.admin.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ashokit.ies.admin.entity.AccountMasterEntity;

public interface AccountMasterRepsitory extends JpaRepository<AccountMasterEntity, Serializable> {

	public AccountMasterEntity findByemail(String email);
	
	@Query("from AccountMasterEntity where role=:rle")
	public List<AccountMasterEntity> findAllByrole(@Param("rle") String role);	
}
