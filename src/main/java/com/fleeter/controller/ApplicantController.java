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

import com.fleeter.entities.master.Branch;
import com.fleeter.entities.master.LoginRequest;
import com.fleeter.entities.roles.Applicant;
import com.fleeter.repository.ApplicantRepository;
import com.fleeter.repository.BranchRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/applicant")
public class ApplicantController {
	
	
	@Autowired
	private ApplicantRepository applicantRepository;
	
	@Autowired
	private BranchRepository branchRepository;
	
	@PostMapping("/")
	public Applicant saveApplicant(@RequestBody Applicant applicant)
	{
		try {
			applicant.setRole("applicant");
			return applicantRepository.save(applicant);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/")
	public List<Applicant> getAllApplicant()
	{
		try {
			return applicantRepository.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/branch/{id}")
	public List<Applicant> getAllApplicantyBranch(@PathVariable("id") int id)
	{
		try {
			Branch branch= branchRepository.getById(id);
			return applicantRepository.findByBranch(branch);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public Applicant getApplicantById(@PathVariable("id") int id)
	{
		try {
			return applicantRepository.findById(id).get();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteApplicantById(@PathVariable("id") int id)
	{
		try {
			 applicantRepository.deleteById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@PutMapping("/{id}")
	public Applicant updateApplicantById(@RequestBody Applicant applicant,@PathVariable("id") int id)
	{
		try {
			
			applicant.setId(id);
			return applicantRepository.save(applicant);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	return null;
	}

	
}
