package com.ashokit.ies.ed.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.ies.ed.entity.EligibilityDetailsEntity;

public interface EligibilityDetailsRepository extends JpaRepository<EligibilityDetailsEntity, Serializable> {

}
