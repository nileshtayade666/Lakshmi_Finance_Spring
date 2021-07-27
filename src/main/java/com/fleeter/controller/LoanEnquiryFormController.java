package com.fleeter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleeter.entities.applicant.LoanEnquiryForm;
import com.fleeter.repository.LoanEnquiryFormRepository;




@RestController
@CrossOrigin("*")
@RequestMapping("/loanEnquiryForm")
public class LoanEnquiryFormController {

	@Autowired
	private LoanEnquiryFormRepository loanEnquiryFormRepository;
	
	@PostMapping("/")
	public LoanEnquiryForm saveLoanEnquiryForm(@RequestBody LoanEnquiryForm loanEnquiryForm)
	{
		try {
			return loanEnquiryFormRepository.save(loanEnquiryForm);

			} catch (Exception e) {
					e.printStackTrace();
			}
		return null;
	}
	
	@GetMapping("/")
	public List<LoanEnquiryForm> getLoanEnquiryForm()
	{
		try {
			return loanEnquiryFormRepository.findAll();

		} catch (Exception e) {
				e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public LoanEnquiryForm getLoanEnquiryFormById(@PathVariable("id") int id)
	{
		try {
			return loanEnquiryFormRepository.findById(id).get();

		} catch (Exception e) {
				e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteLoanEnquiryFormById(@PathVariable("id") int id)
	{
		try {
			loanEnquiryFormRepository.deleteById(id);

		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	@PutMapping("/{id}")
	public LoanEnquiryForm updateApplicantById(@RequestBody LoanEnquiryForm loanEnquiryForm,@PathVariable("id") int id)
	{
		try {
			loanEnquiryForm.setId(id);
			return loanEnquiryFormRepository.save(loanEnquiryForm);
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		return null;
	}
	

	
	
}
