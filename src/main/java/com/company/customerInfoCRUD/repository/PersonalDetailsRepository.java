package com.company.customerInfoCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.customerInfoCRUD.entity.PersonalDetails;



@Repository
public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Integer> {

}
