package com.company.customerInfoCRUD.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.customerInfoCRUD.entity.KycDetails;


@Repository
public interface KycDetailsRepository extends JpaRepository<KycDetails, Integer>{

	Optional<KycDetails> findByPersonalDetailsId(Integer id);

}
