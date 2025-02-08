package com.company.customerInfoCRUD.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.customerInfoCRUD.entity.AddressDetails;
import com.company.customerInfoCRUD.entity.KycDetails;
import com.company.customerInfoCRUD.entity.PersonalDetails;
import com.company.customerInfoCRUD.repository.AddressDetailsRepository;
import com.company.customerInfoCRUD.repository.KycDetailsRepository;
import com.company.customerInfoCRUD.repository.PersonalDetailsRepository;
import com.company.customerInfoCRUD.requestDTO.CustomerRequestInfo;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {

    @Autowired
    private PersonalDetailsRepository personalDetailsRepo;

    @Autowired
    private AddressDetailsRepository addressDetailsRepo;

    @Autowired
    private KycDetailsRepository kycDetailsRepo;

    
    
    //for CREATE
    @Transactional
    public void saveDetails(CustomerRequestInfo requestDTO) {
        // Save Personal Details
        PersonalDetails personalDetails = new PersonalDetails();
        personalDetails.setFirstName(requestDTO.getFirstName());
        personalDetails.setLastName(requestDTO.getLastName());
        personalDetails.setEmail(requestDTO.getEmail());
        personalDetails.setPhoneNumber(requestDTO.getPhoneNumber());
        personalDetails = personalDetailsRepo.save(personalDetails);

        // Save Address Details
        AddressDetails addressDetails = new AddressDetails();
        addressDetails.setPersonalDetailsId(personalDetails.getId());
        addressDetails.setStreet(requestDTO.getStreet());
        addressDetails.setCity(requestDTO.getCity());
        addressDetails.setState(requestDTO.getState());
        addressDetails.setZipCode(requestDTO.getZipCode());
        addressDetailsRepo.save(addressDetails);

        // Save KYC Details
        KycDetails kycDetails = new KycDetails();
        kycDetails.setPersonalDetailsId(personalDetails.getId());
        kycDetails.setDocumentType(requestDTO.getDocumentType());
        kycDetails.setDocumentNumber(requestDTO.getDocumentNumber());
        kycDetailsRepo.save(kycDetails);
    }
    
    
    
    //for UPDATE
    @Transactional
    public void updateDetails(Integer id, CustomerRequestInfo requestDTO) {
        // Update Personal Details
        
        Optional<PersonalDetails> optionalPersonalDetails = personalDetailsRepo.findById(id);
        if (optionalPersonalDetails.isPresent()) {
        	// if data present then need to create a object of address details
        	PersonalDetails personalDetails1 = optionalPersonalDetails.get();
        	personalDetails1.setFirstName(requestDTO.getFirstName());
            personalDetails1.setLastName(requestDTO.getLastName());
            personalDetails1.setEmail(requestDTO.getEmail());
            personalDetails1.setPhoneNumber(requestDTO.getPhoneNumber());
            
            personalDetailsRepo.save(personalDetails1);
        } else {
            throw new RuntimeException("Personal Details not found");
        }
        
        
//        PersonalDetails personalDetails = personalDetailsRepo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Personal Details not found"));
//        personalDetails.setFirstName(requestDTO.getFirstName());
//        personalDetails.setLastName(requestDTO.getLastName());
//        personalDetails.setEmail(requestDTO.getEmail());
//        personalDetails.setPhoneNumber(requestDTO.getPhoneNumber());
//        personalDetailsRepo.save(personalDetails);
//     
        
        
        
        // Update Address Details
        Optional<AddressDetails> optionalAddressDetails = addressDetailsRepo.findByPersonalDetailsId(id);
        if (optionalAddressDetails.isPresent()) {
        	// if data present then need to create a object of address details
            AddressDetails addressDetails = optionalAddressDetails.get();
            addressDetails.setStreet(requestDTO.getStreet());
            addressDetails.setCity(requestDTO.getCity());
            addressDetails.setState(requestDTO.getState());
            addressDetails.setZipCode(requestDTO.getZipCode());
            
            addressDetailsRepo.save(addressDetails);
        } else {
            throw new RuntimeException("Address Details not found");
        }

        // Update KYC Details
        Optional<KycDetails> optionalKycDetails = kycDetailsRepo.findByPersonalDetailsId(id);

        if (optionalKycDetails.isPresent()) {
            KycDetails kycDetails = optionalKycDetails.get();
            kycDetails.setDocumentType(requestDTO.getDocumentType());
            kycDetails.setDocumentNumber(requestDTO.getDocumentNumber());

            kycDetailsRepo.save(kycDetails);
        } else {
            throw new RuntimeException("KYC Details not found");
        }
    }
    
    
    //for DELETE
        @Transactional
    public void deleteDetails(Integer id) {
		Optional<PersonalDetails> optionalPersonalDetails = personalDetailsRepo.findById(id);
		
		if(optionalPersonalDetails.isPresent()) {
			personalDetailsRepo.deleteById(id);
		}else {
			throw new RuntimeException("Customer not found with id: " + id);
 
		}
		
	}
}
    