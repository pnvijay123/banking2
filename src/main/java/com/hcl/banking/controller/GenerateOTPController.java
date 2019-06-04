package com.hcl.banking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.banking.entity.OTPDetails;
import com.hcl.banking.repository.OTPDetailsRepository;

@RestController
@RequestMapping("/banking")
@CrossOrigin(origins="*")
public class GenerateOTPController {
	@Autowired
	OTPDetailsRepository oTPDetailsRepository;
	
	@PostMapping("/generateotp")
	public OTPDetails generateOTP(@Valid @RequestBody OTPDetails oTPDetails) {
		oTPDetails.setGeneratedOTP(GenerateOTPController.getAlphaNumericString(10));
		return oTPDetailsRepository.save(oTPDetails);
	}
	
	
	public static String getAlphaNumericString(int n) 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    } 
  

}
