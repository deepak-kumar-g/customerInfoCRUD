package com.company.customerInfoCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.customerInfoCRUD.requestDTO.CustomerRequestInfo;
import com.company.customerInfoCRUD.responseDTO.ApiResponse;
import com.company.customerInfoCRUD.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
		@Autowired
	    private CustomerService customerSer;

	 	// Save customer details
	    @PostMapping("/save")
	    public ResponseEntity<ApiResponse> saveDetails(@RequestBody CustomerRequestInfo requestDTO) {
	    	customerSer.saveDetails(requestDTO);
	        ApiResponse response = new ApiResponse("success", "Customer Information saved successfully!");
	        return ResponseEntity.ok(response);
	    }

	    // Update customer details
	    @PutMapping("/update/{id}")
	    public ResponseEntity<ApiResponse> updateDetails(
	            @PathVariable Integer id,
	            
	            @RequestBody CustomerRequestInfo requestDTO) {
	    	customerSer.updateDetails(id, requestDTO);
	        ApiResponse response = new ApiResponse("success", "Customer Information updated successfully!");
	        return ResponseEntity.ok(response);
	    }

	    // Delete customer details
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable Integer id) {
	        customerSer.deleteDetails(id);
	        ApiResponse response = new ApiResponse("success", "Customer Information deleted successfully!");
	        return ResponseEntity.ok(response);
	    }
	}