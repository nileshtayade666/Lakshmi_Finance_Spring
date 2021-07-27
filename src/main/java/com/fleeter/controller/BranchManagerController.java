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

import com.fleeter.entities.roles.BranchManager;
import com.fleeter.repository.BranchManagerRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/branchManager")
public class BranchManagerController {
	
	
	@Autowired
	private BranchManagerRepository branchManagerRepository;
	
	@PostMapping("/") 
	public BranchManager saveBranchManager(@RequestBody BranchManager branchManager)
	{
		try {
			
			branchManager.setRole("branchManager");
			return branchManagerRepository.save(branchManager);
		} catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/")
	public List<BranchManager> getAllBranchManager()
	{
		try {
			return branchManagerRepository.findAll();

		} catch (Exception e) {
		e.printStackTrace();
		}
		
		return null;
	}
	
	@GetMapping("/{id}")
	public BranchManager getBranchManagerById(@PathVariable("id") int id)
	{
		try {
			return branchManagerRepository.findById(id).get();

			
		} catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteBranchManagerById(@PathVariable("id") int id)
	{
		try {
			branchManagerRepository.deleteById(id);

		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	
	@PutMapping("/{id}")
	public BranchManager updateBranchManagerById(@RequestBody BranchManager branchManager,@PathVariable("id") int id)
	{
		try {
			branchManager.setId(id);
			return branchManagerRepository.save(branchManager);
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}


}
