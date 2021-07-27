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
import com.fleeter.repository.BranchRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/branch")
public class BranchController {
	
	
	@Autowired
	private BranchRepository branchRepository;
	
	@PostMapping("/") 
	public Branch saveBranch(@RequestBody Branch branch)
	{
		try {
			return branchRepository.save(branch);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/")
	public List<Branch> getAllBranch()
	{
		try {
			return branchRepository.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public Branch getBranchById(@PathVariable("id") int id)
	{
		try {
			return branchRepository.findById(id).get();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteBranchById(@PathVariable("id") int id)
	{
		try {
			branchRepository.deleteById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@PutMapping("/{id}")
	public com.fleeter.entities.master.Branch updateBranchById(@RequestBody Branch branch,@PathVariable("id") int id)
	{
		try {
			branch.setId(id);
			return branchRepository.save(branch);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
