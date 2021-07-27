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

import com.fleeter.entities.roles.CreditManager;
import com.fleeter.repository.CreditManagerRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/creditManager")
public class CreditManagerController {
	
	
	@Autowired
	private CreditManagerRepository creditManagerRepository;
	
	@PostMapping("/")
	public CreditManager saveCreditManager(@RequestBody CreditManager creditManager)
	{
		try {
			
			creditManager.setRole("creditManager");
			return creditManagerRepository.save(creditManager);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/")
	public List<CreditManager> getAllCreditManager()
	{
		try {
			return creditManagerRepository.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public CreditManager getCreditManagerById(@PathVariable("id") int id)
	{
		try {
			return creditManagerRepository.findById(id).get();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteCreditManagerById(@PathVariable("id") int id)
	{
		try {
			 creditManagerRepository.deleteById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PutMapping("/{id}")
	public CreditManager updateCreditManagerById(@RequestBody CreditManager creditManager,@PathVariable("id") int id)
	{
		try {
			creditManager.setId(id);
			return creditManagerRepository.save(creditManager);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	
}
