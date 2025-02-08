package com.company.customerInfoCRUD.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.customerInfoCRUD.entity.AddressDetails;


@Repository
public interface AddressDetailsRepository extends JpaRepository<AddressDetails, Integer>{

	Optional<AddressDetails> findByPersonalDetailsId(Integer id);

}
