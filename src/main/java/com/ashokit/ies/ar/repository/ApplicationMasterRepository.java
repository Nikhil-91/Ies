package com.ashokit.ies.ar.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashokit.ies.ar.entity.ApplicationMasterEntity;

@Repository
public interface ApplicationMasterRepository extends JpaRepository<ApplicationMasterEntity,Serializable> {

}
