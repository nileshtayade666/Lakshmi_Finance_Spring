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

import com.fleeter.entities.master.LoanType;
import com.fleeter.repository.LoanTypeRepository;


@RestController
@CrossOrigin("*")
@RequestMapping("/loanType")
public class LoanTypeController {

	@Autowired
	private LoanTypeRepository loanTypeRepository;
	
	@PostMapping("/")
	public LoanType saveLoanType(@RequestBody LoanType loanType)
	{
		try {
			return loanTypeRepository.save(loanType);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/")
	public List<LoanType> getAllLoanTypes()
	{
		try {
			return loanTypeRepository.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public LoanType getLoanTypeById(@PathVariable("id") int id)
	{
		try {
			return loanTypeRepository.findById(id).get();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deletLoanTypeById(@PathVariable("id") int id)
	{
		try {
			loanTypeRepository.deleteById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PutMapping("/{id}")
	public LoanType updateLoanTypetById(@RequestBody LoanType loanType,@PathVariable("id") int id)
	{
		try {
			loanType.setId(id);
			return loanTypeRepository.save(loanType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
